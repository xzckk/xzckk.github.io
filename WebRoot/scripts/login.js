$(function(){
	$("#login").click(function(){
		//先清除上一次单击事件的提示信息
		$("#count_span").html();
		$("#password_span").html();
		//获取请求提交参数
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		//检查参数格式
		var ok=true;
		if(name==""){
			$("#count_span").html("请输入用户名");
			ok=false;
		}
		if(password==""){
			$("#password_span").html("请输入密码");
			ok=false;
		}
		//发送Ajax请求
		if(ok){ //通过检查
			$.ajax({
				url:"user/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				//回调成功
				success:function(result){
					if(result.status==0){ //帐号密码正确则跳转edit.html
						//将用户ID存入Cookie
						var userId=result.data;
						addCookie("userId",userId,0.5);
						//跳转
						window.location.href="edit.html";
					}else if(result.status==1){ //用户名错误
						$("#count_span").html(result.msg);
					}else if(result.status==2){ //密码错误
						$("#password_span").html(result.msg);
					}else if(result.status==3){
						alert(result.msg);
					}
				},
				//回调失败
				error:function(){
					alert("登录失败,请稍候重试");
				}
			});
		}		
	});
});