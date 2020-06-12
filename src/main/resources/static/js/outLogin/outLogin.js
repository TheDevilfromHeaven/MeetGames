$(function(){
	$(".outLogin").click(function(){
		$.ajax({
			async: false,
			url: "/UserModel/out",
			success:function(result){
				if(result == true){
					history.pushState(null, null, document.URL);
				    window.addEventListener('popstate', function () {
				        history.pushState(null, null, document.URL);
				    });
				    window.location.reload();
				}else{
					alert("出现了未知bug");
				}
			},
			error:function(){
				alert("出现了未知bug");
			}
		});
	});
});