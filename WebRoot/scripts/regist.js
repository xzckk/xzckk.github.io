		$(function(){
			$("#regist_button").click(function(){
				//再次清空提示
				$("#warning_1").hide();
				$("#warning_4").hide();
				$("#warning_2").hide();
				$("#warning_3").hide();
				//获取请求信息
				var name=$("#regist_username").val().trim();
				var nick=$("#nickname").val().trim();
				var password=$("#regist_password").val().trim();
				var final_password=$("#final_password").val().trim();
				//检查格式
				var ok=true;
				if(name==""){
					$("#warning_1 span").html("Please Enter username");
					$("#warning_1").show();
					ok=false;
				}
				if(nick==""){
					$("#warning_4 span").html("Please Enter nickname");
					$("#warning_4").show();
					ok=false;
				}
				if(password==""){
					$("#warning_2 span").html("Please enter password");
					$("#warning_2").show();
					ok=false;
				}else{
					if(password.length<6){
						$("#warning_2 span").html("Too short!");
						$("#warning_2").show();
						ok=false;
					}
				}
				if(final_password==""){
					$("#warning_3 span").html("Please enter password");
					$("#warning_3").show();
					ok=false;
				}else{
					if(password!=final_password){
						$("#warning_3 span").html("Check password");
						$("#warning_3").show();
						ok=false;
					}
				}
				//发送Ajax请求
				if(ok){
					$.ajax({
						url:"user/regist.do",
						type:"post",
						data:{"name":name,"password":password,"nick":nick},
						dataType:"json",
						success:function(result){
							if(result.status==0){ //注册成功
								alert(result.msg); //提示
								$("#back").click(); //切换到登录界面（无参触发，有参绑定）
							}else if(result.status==1){ //
								$("#warning_1 span").html(result.msg);
								$("#warning_1").show();
							}
						},
						error:function(){
							alert("Failed,try later!");
						}
					});
				}
			});
		});