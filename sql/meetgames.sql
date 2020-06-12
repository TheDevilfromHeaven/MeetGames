/*
 Navicat Premium Data Transfer

 Source Server         : MySQL8.0
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : meetgames

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 12/06/2020 23:55:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for games
-- ----------------------------
DROP TABLE IF EXISTS `games`;
CREATE TABLE `games`  (
  `game_id` bigint(255) NOT NULL,
  `game_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_platform` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_img_mini` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_img1_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_img2_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_img3_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_img4_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_img_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`game_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of games
-- ----------------------------
INSERT INTO `games` VALUES (1, '60秒', '36元', 'PC', '《60秒》是由Robot Gentleman Studios 2015年发行的一款具有黑暗喜剧的生存冒险游戏。游戏主要以生存为主，在核攻击前有60秒时间储备好你的供应品，营救你的家人，并且60秒之后需要一直在避难所生活。游戏中还需要做出一些困难决定，例如分配食品，外出探险等。', '/img/games/60s.jpg', '/img/games/60s_01.jpg', '/img/games/60s_02.jpg', '/img/games/60s_03.jpg', '/img/games/60s_04.jpg', '/img/games/60s_title.jpg');
INSERT INTO `games` VALUES (2, '战地5', '292元', 'PC/PS4/XBOXONE', '《战地5》（英文名：Battlefield 5）是一款由EA DICE工作室（EA Digital Illusions CE）开发制作、EA（美国艺电）出版发行的第一人称射击游戏。游戏采用了寒霜引擎，展现了更强大的3D细节效果，把动画、环境破坏、光照、地图和音效提升到一个新的高度。游戏于2018年11月20日在PC、Xbox One、PS4平台正式发售。《战地5》是《战地1》的正统续作，PC版多人模式支持高达64人网络对战。', '/img/games/BattlefieldⅤ.jpg', '/img/games/BattlefieldⅤ_01.jpg', '/img/games/BattlefieldⅤ_02.jpg', '/img/games/BattlefieldⅤ_03.jpg', '/img/games/BattlefieldⅤ_04.jpg', '/img/games/BattlefieldⅤ_title.jpg');
INSERT INTO `games` VALUES (3, '中国式家长', '36元', 'PC', '《中国式家长》是一款由墨鱼玩游戏开发的模拟养成游戏，于2018年9月29日正式在Steam、WeGame平台发售。作为一款轻松休闲的模拟养成游戏，模拟从出生到成人这段过程，探讨孩子与家长之间的关系。', '/img/games/ChineseParents.jpg', '/img/games/ChineseParents_01.jpg', '/img/games/ChineseParents_02.jpg', '/img/games/ChineseParents_03.jpg', '/img/games/ChineseParents_04.jpg', '/img/games/ChineseParents_title.jpg');
INSERT INTO `games` VALUES (4, '文明6', '199元', 'PC/PS4/XBOXONE/Switch', '《文明6》是Firaxis Games开发，2K Games发行的历史策略回合制游戏，于2016年10月21日发行PC版本，2018年11月16日登陆Switch平台，2019年11月22日发布了XboxOne、PS4版本。该游戏是游戏设计师席德·梅尔创作的《文明》系列第6部。游戏中玩家建立起一个帝国，并接受时间的考验。玩家将创建及带领自己的文明从石器时代迈向信息时代，并成为世界的领导者。在尝试建立起世界上赫赫有名的伟大文明的过程中，玩家将启动战争、实行外交、促进文化，同时正面对抗历史上的众多领袖。', '/img/games/CivilizationVI.jpg', '/img/games/CivilizationVI_01.jpg', '/img/games/CivilizationVI_02.jpg', '/img/games/CivilizationVI_03.jpg', '/img/games/CivilizationVI_04.jpg', '/img/games/CivilizationVI_title.jpg');
INSERT INTO `games` VALUES (5, 'CSGO', '免费', 'PC', '《反恐精英：全球攻势》是一款由VALVE与Hidden Path Entertainment合作开发的第一人称射击游戏，于2012年8月21日在欧美地区正式发售，国服发布会于2017年4月11日在北京召开。游戏为《反恐精英》系列游戏的第四款作品（不包括Neo和Online等衍生作品）。 游戏玩家分为反恐精英（CT阵营）与恐怖份子（T阵营）两个阵营，双方需在一个地图上进行多回合的战斗，达到地图要求目标或消灭全部敌方则取得胜利。', '/img/games/csgo.jpg', '/img/games/csgo_01.jpg', '/img/games/csgo_02.jpg', '/img/games/csgo_03.jpg', '/img/games/csgo_04.jpg', '/img/games/csgo_title.jpg');
INSERT INTO `games` VALUES (6, '神界：原罪2', '133元', 'PC/PS4/XBOXONE/Switch', '《神界：原罪2》是一款由Larian Studios开发的具备单人和多人模式，以团队配合为基础的角色扮演游戏，于2017年9月12日PC、PS4、XBOXONE同步发售。2018年8月31日，《神界：原罪2 终极版》同步登陆PC/XBOX/PS4，拥有《神界：原罪2》的玩家将免费获得终极版，并于2019年9月5日登录Switch平台。该作为《神界：原罪》的续作。', '/img/games/DivinityOriginalSin2.jpg', '/img/games/DivinityOriginalSin2_01.jpg', '/img/games/DivinityOriginalSin2_02.jpg', '/img/games/DivinityOriginalSin2_03.jpg', '/img/games/DivinityOriginalSin2_04.jpg', '/img/games/DivinityOriginalSin2_title.jpg');
INSERT INTO `games` VALUES (7, 'DOTA2', '免费', 'PC', '《刀塔2》也被称作《DOTA2》，由《DOTA》的地图核心制作者IceFrog（冰蛙）联手美国Valve公司研发的一款游戏，于2013年4月28日开始测试，发布中文名为“刀塔”，是该系列的第二部作品。', '/img/games/dota2.jpg', '/img/games/dota2_01.jpg', '/img/games/dota2_02.jpg', '/img/games/dota2_03.jpg', '/img/games/dota2_04.jpg', '/img/games/dota2_title.jpg');
INSERT INTO `games` VALUES (8, '集合啦！动物森友会', '389元', 'Switch', '玩家需要在无人岛开始新生活，在与现实同时进行的世界里，每天随性自在地过日子。从垂钓、捕捉虫子、园艺等户外活动，到房间制作、服饰等各式各样的乐趣，通过一年时间享受愉快生活。', '/img/games/AnimalCrossing.jpg', '/img/games/AnimalCrossing_01.png', '/img/games/AnimalCrossing_02.jpg', '/img/games/AnimalCrossing_03.jpg', '/img/games/AnimalCrossing_04.jpg', '/img/games/AnimalCrossing_title.jpg');
INSERT INTO `games` VALUES (9, '炉石传说', '免费', 'PC/手机', '《炉石传说：魔兽英雄传》是一款由暴雪娱乐开发的集换式卡牌游戏。中国大陆地区的独家运营由网易公司代理。2014年3月13日全球同步正式运营。《酒馆战棋》模式于北京时间2019年11月6日凌晨2点国服开启抢先体验。', '/img/games/HearthStone.jpg', '/img/games/HearthStone_01.jpg', '/img/games/HearthStone_02.jpg', '/img/games/HearthStone_03.jpg', '/img/games/HearthStone_04.png', '/img/games/HearthStone_title.jpg');
INSERT INTO `games` VALUES (10, '空洞骑士', '48元', 'PC/Switch', '《空洞骑士(Hollow Knight)》是一款动画风格的银河恶魔城类型动作游戏。发售PC版，Nintendo Switch版，PS4版和XBOX版本。内置免费内容包“Hidden Dreams”（即“隐藏的梦”），新增2个BOSS，两首新BOSS音乐，升级“Dream Gate”（梦之门），以及新的Stag Station（鹿角站）。《空洞骑士》NS版2018年早期上市。PS4/XBOX版于9月25日上线，包含3个免费内容包和一个主要更新。', '/img/games/HollowKnight.jpg', '/img/games/HollowKnight_01.jpg', '/img/games/HollowKnight_02.jpg', '/img/games/HollowKnight_03.jpg', '/img/games/HollowKnight_04.jpg', '/img/games/HollowKnight_title.jpg');
INSERT INTO `games` VALUES (11, '人类一败涂地', '48元', 'PC', '《人类一败涂地》是一款快节奏开放结局物理模拟解谜探索游戏，游戏设置在奇幻漂浮的梦境世界中，玩家的目标是要通过一系列解谜来逃离不断崩塌的梦境，一切仅靠着玩家的智慧和知识。Curve工作室官方确认，在17年十月推出NS版《人类：一败涂地》。', '/img/games/HumanFallFlat.jpg', '/img/games/HumanFallFlat_01.jpg', '/img/games/HumanFallFlat_02.jpg', '/img/games/HumanFallFlat_03.jpg', '/img/games/HumanFallFlat_04.jpg', '/img/games/HumanFallFlat_title.jpg');
INSERT INTO `games` VALUES (12, '马里奥赛车8', '392元', 'Switch', '马里奥赛车8（Mario Kart 8），是任天堂游戏公司出版发行的竞速游戏。2014年5月29日登陆WiiU，NS完全版《马里奥赛车8豪华版（Mario Kart 8 Deluxe）》2017年4月28日上市。2017年12月15日 [2]  NS版《马里奥赛车8豪华版》追加简体、繁体中文。Wii U《马里奥赛车8》838万套。', '/img/games/MarioKart8.jpg', '/img/games/MarioKart8_01.jpg', '/img/games/MarioKart8_02.jpg', '/img/games/MarioKart8_03.jpg', '/img/games/MarioKart8_04.jpg', '/img/games/MarioKart8_title.jpg');
INSERT INTO `games` VALUES (13, '地铁：逃离', '199元', 'PC/PS4/XBOXONE', '《地铁：离去》（Metro Exodus）是一款由4A Games开发、Deep Silver发行的第一人称射击游戏，本作是地铁系列的第三作，也是《地铁2033》与《地铁：最后的曙光》的续作。', '/img/games/MetroExodus.jpg', '/img/games/MetroExodus_01.jpg', '/img/games/MetroExodus_02.jpg', '/img/games/MetroExodus_03.jpg', '/img/games/MetroExodus_04.jpg', '/img/games/MetroExodus_title.jpg');
INSERT INTO `games` VALUES (14, '怪物猎人：世界', '203元', 'PC/PS4/XBOXONE', '《怪物猎人：世界》是由CAPCOM制作发行的一款动作冒险游戏，在全球范围内都享有盛赞，本代怪物猎人发生了诸多进化，玩法与画面都有非常巨大的进步，游戏最多支持16人联机集会所，4人联机狩猎。在游戏中玩家将扮演一位第五期团的推荐组猎人，探索新大陆的深处，解开古龙迁徙的秘密。猎人们必须利用他们的聪明才智和个人能力才能在激烈、变化多端的战斗中存活下来，并且最终成为“指引明路的苍蓝星”。', '/img/games/MonsterHunter.jpg', '/img/games/MonsterHunter_01.jpg', '/img/games/MonsterHunter_02.jpg', '/img/games/MonsterHunter_03.jpg', '/img/games/MonsterHunter_04.png', '/img/games/MonsterHunter_title.jpeg');
INSERT INTO `games` VALUES (15, '三国志14', '349元', 'PC/PS4', '《三国志》系列是由KOEI TECMO制作并的历史模拟类游戏系列，初代发行于1985年。本系列的精华是对三国历史细致的考据，和传神的人物肖像，将三国时代庞大的政治军事构架完美的融入策略游戏模式中。《三国志14》是本系列的正统续作，相信会给玩家带来全新的游戏体验。', '/img/games/Sangokushi14.jpg', '/img/games/Sangokushi14_01.jpg', '/img/games/Sangokushi14_02.jpg', '/img/games/Sangokushi14_03.jpg', '/img/games/Sangokushi14_04.jpg', '/img/games/Sangokushi14_title.jpg');
INSERT INTO `games` VALUES (16, 'Skul:英雄杀手', '62元', 'PC', 'Skul：英雄杀手是2D Rogue Lite动作平台游戏。负责魔王城平安的小骷髅“Skul”，为了拯救被人类捉住的魔王，一个人独自对抗帝国军队开始冒险。', '/img/games/skul.png', '/img/games/skul_01.jpg', '/img/games/skul_02.jpg', '/img/games/skul_03.jpg', '/img/games/skul_04.jpg', '/img/games/skul_title.jpg');
INSERT INTO `games` VALUES (17, '杀戮尖塔', '80元', 'PC/PS4/Switch', '《杀戮尖塔》是一款由Mega Crit Games制作发行的结合了卡牌与策略冒险游戏。选择数百个不同的卡和强大的古代文物，用你自己的方式打造你工艺独特的卡组，通过你自己的战斗方式到达塔的顶端!游戏中有丰富的卡牌系统等待着你来体验，如何组合一个强力的卡组将会是你成功的一半!你将遭遇数十场战役，和不同的怪物作战，在战利品中你也许会发现一些能大大增强你套牌的传奇道具。', '/img/games/SlayTheSpire.jpg', '/img/games/SlayTheSpire_01.jpg', '/img/games/SlayTheSpire_02.jpg', '/img/games/SlayTheSpire_03.jpg', '/img/games/SlayTheSpire_04.jpg', '/img/games/SlayTheSpire_title.jpg');
INSERT INTO `games` VALUES (18, '超级马力欧创作家2', '392元', 'Switch', '《超级马力欧创作家2》（Super Mario Maker 2）是一款由任天堂开发的动作游戏。2019年6月28日在任天堂Switch平台发售。\r\n本作NS独占，拥有单人故事模式。在故事模式中，玩家需挑战超100个内置关卡，帮助碧奇公主（Princess Peach）重建城堡。此外，玩家可自己或与朋友共同制作关卡，可在网上分享关卡。', '/img/games/SuperMarioMaker2.jpeg', '/img/games/SuperMarioMaker2_01.jpg', '/img/games/SuperMarioMaker2_02.jpg', '/img/games/SuperMarioMaker2_03.jpg', '/img/games/SuperMarioMaker2_04.jpeg', '/img/games/SuperMarioMaker2_title.jpg');
INSERT INTO `games` VALUES (19, '巫师3：狂猎', '127元', 'PC/PS4/XBOXONE/Switch', '《巫师3：狂猎（The Witcher 3: Wild Hunt）》是由CD Projekt RED制作，WB Games（NA）、Spike Chunsoft（JP）发行的一款角色扮演类游戏，游戏于2015年5月19日在PC、PS4、XboxOne平台发行，2019年10月13日登录Switch平台。游戏自同名小说改编，为《巫师》系列游戏作品的第三部，是杰洛特冒险的终曲。', '/img/games/TheWitcher3.jpg', '/img/games/TheWitcher3_01.jpg', '/img/games/TheWitcher3_02.jpg', '/img/games/TheWitcher3_03.jpg', '/img/games/TheWitcher3_04.jpg', '/img/games/TheWitcher3_title.jpg');
INSERT INTO `games` VALUES (20, '塞尔达传说：旷野之息', '456元', 'Switch', '《塞尔达传说：旷野之息》（ゼルダの伝说： ブレスオブザワイルド）是由任天堂企划制作本部与子公司Monolith Soft协力研发制作的一款开放世界动作冒险游戏。于2017年3月3日由任天堂发行，为《塞尔达传说》系列游戏正统续作的第15部作品，其他续作有《塞尔达传说：众神的三角力量》、《塞尔达传说2：林克的冒险》、《塞尔达传说：风之杖》、《塞尔达传说：时之笛》等。2019年6月12日，在任天堂E3展前发布会上官方公开了该作续作的首个宣传片，并正在开发中。', '/img/games/Zelda.png', '/img/games/Zelda_01.jpg', '/img/games/Zelda_02.jpg', '/img/games/Zelda_03.jpg', '/img/games/Zelda_04.jpg', '/img/games/Zelda_title.jpg');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `user_id` bigint(255) NULL DEFAULT NULL,
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1242658571913662464, 'csry1', 'xVJrkMLu1qjPsTqcNAFufF0M6fzHhMYelt7/2Q==');
INSERT INTO `login` VALUES (1242755815383896064, 'qwer', 'BqV+sE/x6GH0VwHIeqJ5xeDC6SOnr0LlZM7Acw==');
INSERT INTO `login` VALUES (1245740134561878016, 'csry3', 'rNwx9tPVbEfXwKzPgaAhI1niAiLku6OTIcWWHQ==');
INSERT INTO `login` VALUES (1247481817678876672, 'csry2', '//4An3II3nf+HhiAwc5drrbRdXRZlcTFG/JUmA==');
INSERT INTO `login` VALUES (1258684006711562240, 'csry5', 'qYhbxcWl33DMdnfCj8MRCTBTPsZw/ICQOI79/Q==');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `note_id` bigint(20) NOT NULL,
  `game_id` bigint(255) NULL DEFAULT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `note_master` bigint(255) NULL DEFAULT NULL,
  `recommend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`note_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1243911624646070272, 1, '测试1', '2020-03-28 22:43:36', 1242755815383896064, '是');
INSERT INTO `note` VALUES (1246094280280379392, 1, '测试2', '2020-04-03 23:16:42', 1242755815383896064, '推荐');
INSERT INTO `note` VALUES (1246101830212128768, 1, '测试3', '2020-04-03 23:46:42', 1242755815383896064, '不推荐');
INSERT INTO `note` VALUES (1258691371741614080, 6, '??????????', '2020-05-08 17:33:03', 1242755815383896064, '推荐');
INSERT INTO `note` VALUES (1259781544906723328, 1, '20200511', '2020-05-11 17:45:00', 1242755815383896064, '推荐');
INSERT INTO `note` VALUES (1259782965802700800, 3, '20200511', '2020-05-11 17:50:39', 1242755815383896064, '推荐');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` bigint(20) NOT NULL,
  `post_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `post_master` bigint(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'text1', '测试1', '2020-03-26 23:06:30', 1242755815383896064);
INSERT INTO `post` VALUES (1243062851288043520, 'test3', '测试3', '2020-03-26 14:30:53', 1242755815383896064);
INSERT INTO `post` VALUES (1243130641214738432, 'tset4', '测试4', '2020-03-26 19:00:15', 1242755815383896064);
INSERT INTO `post` VALUES (1243759231820238848, 'test5', '测试5', '2020-03-28 12:38:03', 1242755815383896064);
INSERT INTO `post` VALUES (1244640137804124160, 'test6', '测试6', '2020-03-30 22:58:27', 1242658571913662464);
INSERT INTO `post` VALUES (1244640249951424512, 'test7', '测试7', '2020-03-30 22:58:54', 1242755815383896064);
INSERT INTO `post` VALUES (1247175003796017152, 'text8', '8', '2020-04-06 22:51:06', 1242755815383896064);
INSERT INTO `post` VALUES (1247175034531876864, 'text9', '9', '2020-04-06 22:51:14', 1242755815383896064);
INSERT INTO `post` VALUES (1247175067515883520, 'text10', '10', '2020-04-06 22:51:22', 1242755815383896064);
INSERT INTO `post` VALUES (1247175089343041536, 'text11', '11', '2020-04-06 22:51:27', 1242755815383896064);
INSERT INTO `post` VALUES (1247175116878647296, 'text12', '12', '2020-04-06 22:51:33', 1242755815383896064);
INSERT INTO `post` VALUES (1247175268964110336, 'text13', '13', '2020-04-06 22:52:10', 1242755815383896064);
INSERT INTO `post` VALUES (1259783126650064896, '20200511', '20200511', '2020-05-11 17:51:17', 1242755815383896064);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` bigint(255) NULL DEFAULT NULL,
  `post_id` bigint(20) NULL DEFAULT NULL,
  `reply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reply_master` bigint(255) NULL DEFAULT NULL,
  `reply_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, 1, '测试1', 11, '2020-03-26 10:54:54');
INSERT INTO `reply` VALUES (2, 1, '测试2', 22, '2020-03-26 10:54:52');
INSERT INTO `reply` VALUES (3, 2, '测试1', 33, '2020-03-26 10:55:10');
INSERT INTO `reply` VALUES (4, 1, '测试3', 44, '2020-03-26 11:50:22');
INSERT INTO `reply` VALUES (1243129560741056512, 1, '测试4', 1242755815383896064, '2020-03-26 18:55:58');
INSERT INTO `reply` VALUES (1243131331106443264, 1243130641214738400, '测试1', 1242755815383896064, '2020-03-26 19:03:00');
INSERT INTO `reply` VALUES (1243759281812148224, 1243759231820238848, '测试1', 1242755815383896064, '2020-03-28 12:38:15');
INSERT INTO `reply` VALUES (1244651897688821760, 1243130641214738432, '202003302345', 1242755815383896064, '2020-03-30 23:45:11');
INSERT INTO `reply` VALUES (1244844535616507904, 1244640249951424512, '20200331', 1242755815383896064, '2020-03-31 12:30:40');
INSERT INTO `reply` VALUES (1247167273655996416, 1244640249951424512, '1', 1242755815383896064, '2020-04-06 22:20:23');
INSERT INTO `reply` VALUES (1247167289854398464, 1244640249951424512, '2', 1242755815383896064, '2020-04-06 22:20:27');
INSERT INTO `reply` VALUES (1247167299627126784, 1244640249951424512, '3', 1242755815383896064, '2020-04-06 22:20:30');
INSERT INTO `reply` VALUES (1247167314613374976, 1244640249951424512, '4', 1242755815383896064, '2020-04-06 22:20:33');
INSERT INTO `reply` VALUES (1247167322460917760, 1244640249951424512, '5', 1242755815383896064, '2020-04-06 22:20:35');
INSERT INTO `reply` VALUES (1247167331055046656, 1244640249951424512, '6', 1242755815383896064, '2020-04-06 22:20:37');
INSERT INTO `reply` VALUES (1247167338709651456, 1244640249951424512, '7', 1242755815383896064, '2020-04-06 22:20:39');
INSERT INTO `reply` VALUES (1247167348448825344, 1244640249951424512, '8', 1242755815383896064, '2020-04-06 22:20:41');
INSERT INTO `reply` VALUES (1247167357193949184, 1244640249951424512, '9', 1242755815383896064, '2020-04-06 22:20:43');
INSERT INTO `reply` VALUES (1247167370972237824, 1244640249951424512, '10', 1242755815383896064, '2020-04-06 22:20:47');
INSERT INTO `reply` VALUES (1247758836241141760, 1247175089343041536, '22', 1245740134561878016, '2020-04-08 13:31:03');
INSERT INTO `reply` VALUES (1258689151411294208, 1247175268964110336, '1111', 1242755815383896064, '2020-05-08 17:24:13');
INSERT INTO `reply` VALUES (1259781747248336896, 1259781699106115584, '1745', 1242755815383896064, '2020-05-11 17:45:48');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `autograph` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/img/heads/default.jpg',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1242658571913662464, '管理员', '男', '2020-04-04', NULL, NULL, '/img/heads/14e87faf-0424-4b3e-b9e7-0bab621f47c3.jpg', '1');
INSERT INTO `userinfo` VALUES (1242755815383896064, '测试人员1', '男', '2013-04-09', '11112@qq.com', '', '/img/heads/1d04ef5f-d786-4708-b270-22d1ce4d0fcb.jpg', '0');
INSERT INTO `userinfo` VALUES (1245740134561878016, '测试人员3', NULL, NULL, NULL, NULL, '/img/heads/default.jpg', '0');
INSERT INTO `userinfo` VALUES (1247481817678876672, '测试人员4', NULL, NULL, NULL, NULL, '/img/heads/default.jpg', '0');
INSERT INTO `userinfo` VALUES (1258684006711562240, 'qwer', NULL, NULL, NULL, NULL, '/img/heads/default.jpg', '0');

-- ----------------------------
-- Table structure for wish
-- ----------------------------
DROP TABLE IF EXISTS `wish`;
CREATE TABLE `wish`  (
  `user_id` bigint(20) NOT NULL,
  `game_id` bigint(255) NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wish
-- ----------------------------
INSERT INTO `wish` VALUES (1242755815383896064, 2, '2020-03-29 13:18:51');
INSERT INTO `wish` VALUES (1242658571913662464, 5, '2020-03-29 18:18:08');
INSERT INTO `wish` VALUES (1242658571913662464, 7, '2020-03-29 18:18:16');
INSERT INTO `wish` VALUES (1242755815383896064, 20, '2020-04-03 21:48:51');
INSERT INTO `wish` VALUES (1242755815383896064, 19, '2020-04-03 21:52:46');
INSERT INTO `wish` VALUES (1242755815383896064, 1, '2020-05-11 17:46:15');

SET FOREIGN_KEY_CHECKS = 1;
