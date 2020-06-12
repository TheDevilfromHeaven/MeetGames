package com.ljh.MeetGames.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljh.MeetGames.dao.Games;
import com.ljh.MeetGames.dao.Post;
import com.ljh.MeetGames.dao.User;
import com.ljh.MeetGames.dao.Wish;
import com.ljh.MeetGames.service.ForumModelService;
import com.ljh.MeetGames.service.GamesModelService;
import com.ljh.MeetGames.service.UserModelService;
import com.ljh.MeetGames.service.WishModelService;
import com.ljh.MeetGames.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/UserModel")
public class UserModelController {
    @Autowired
    UserModelService userModelService;

    Md5 md5;

    @Autowired
    GamesModelService gamesModelService;

    @Autowired
    WishModelService wishModelService;

    @Autowired
    ForumModelService forumModelService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpSession session,String loginName,String password){
        User login = userModelService.login(loginName);
        String sql_password = login.getPassword();
        if(md5.validate(password,sql_password)){
            Long userId = login.getUser_id();
            User userinfo = userModelService.userinfo(userId);
            session.setAttribute("user",userinfo);
            session.setAttribute("userId",userId);
            session.setAttribute("state",userinfo.getState());
            return true;
        }
        return false;
    }

    @RequestMapping("/check")
    @ResponseBody
    public Object check(String loginName){
        Boolean check = userModelService.check(loginName);
        return check;
    }

    @RequestMapping("/register")
    public String register(HttpSession session,String loginName, String password,String userName){
        userModelService.register(loginName,password,userName);
        User login = userModelService.login(loginName);
        User userinfo = userModelService.userinfo(login.getUser_id());
        session.setAttribute("user",userinfo);
        session.setAttribute("userId",login.getUser_id());
        session.setAttribute("state",userinfo.getState());
        return "redirect:/index";
    }

    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping("/out")
    @ResponseBody
    public Object out(HttpSession session) {
        session.invalidate();
        return true;
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model,HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User userInfo = userModelService.userinfo(userId);
        session.setAttribute("user",userInfo);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("type","userInfo");
        return "user/userInfo";
    }

    @RequestMapping("/userInfo/headImg")
    public String headImg(Model model,HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User userInfo = userModelService.userinfo(userId);
        session.setAttribute("user",userInfo);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("type","headImg");
        return "user/userInfo";
    }

    @RequestMapping("/userInfo/wishList")
    public String wishList(Model model,HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        List<Wish> wishList = wishModelService.wishList(userId);
        model.addAttribute("wishList",wishList);
        model.addAttribute("type","wishList");
        return "user/userInfo";
    }

    @RequestMapping("/userInfo/myPost")
    public String myPost(Model model,HttpSession session,@RequestParam(defaultValue="1") Integer Page) {
        Long userId = (Long) session.getAttribute("userId");
        PageHelper.startPage(Page,10);
        List<Post> posts = forumModelService.myPost(userId);
        PageInfo<Post> PageInfo = new PageInfo<>(posts);
        model.addAttribute("posts",posts);
        model.addAttribute("PageInfo",PageInfo);
        model.addAttribute("type","myPost");
        return "user/userInfo";
    }

    @RequestMapping("/userInfo/gameManager")
    public String gameManager(Model model,HttpSession session,@RequestParam(defaultValue="1") Integer Page) {
        PageHelper.startPage(Page,10);
        List<Games> games = gamesModelService.allGames();
        PageInfo<Games> PageInfo = new PageInfo<>(games);
        model.addAttribute("games",games);
        model.addAttribute("PageInfo",PageInfo);
        model.addAttribute("type","gameManager");
        return "user/userInfo";
    }

    @RequestMapping("/changeInfo")
    @ResponseBody
    public Object changeInfo(HttpSession session,String user_name,String sex,String birthday,String email,String autograph){
        Long userId = (Long) session.getAttribute("userId");
        User userInfo = new User();
        userInfo.setUser_name(user_name);
        userInfo.setUser_id(userId);
        userInfo.setSex(sex);
        userInfo.setBirthday(birthday);
        userInfo.setEmail(email);
        userInfo.setAutograph(autograph);
        userModelService.changeInfo(userInfo);
        return true;
    }

    @RequestMapping("/oauth/github")
    public String github(String code, String param,Model model) throws IOException {
        String client_id = "f93fab1ac93e597440c4";
        String client_secret = "b57246c9323cc432aa919ac72d4f2db165031cc6";
        String redirect_uri = "http://localhost/UserModel/oauth/github";
        String PostURL = "https://github.com/login/oauth/access_token?client_id=" + client_id + "&client_secret=" + client_secret + "&code=" + code + "&redirect_uri=" + redirect_uri + "";
//        response.sendRedirect(url);
        String sendPost = sendPost(PostURL,param);
        if (sendPost != null) {
            String GetURL = "https://api.github.com/user?"+sendPost+"";
            String sendGet = sendGet(GetURL, param);
            JSONObject jsonObject = (JSONObject) JSON.parse(sendGet);
            Object login = jsonObject.get("login");
            Object avatar_url = jsonObject.get("avatar_url");
            model.addAttribute("login",login);
            model.addAttribute("avatar_url",avatar_url);
            return "forward:/welcome/hello";
        }
        return "redirect:/welcome/login";
    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
