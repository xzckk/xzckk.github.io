					function updateuser(){
						//判断选中笔记
						var $users_list=$("#users_list li a.checked");
						if($users_list.length==0){
							alert("请选择笔记");
						}else{
							//获取请求参数
							var username=$("#users_list li a.checked").parent().data("userName");

								//um.getContent();
							//格式判断
							var ok=true;


							//发送Ajax请求
							if(ok){
								$.ajax({
									url:"user/authorize.do",
									type:"post",
									data:{"name":username},
									dataType:"json",
									success:function(result){
										if(result.status==0){

											alert(result.msg);
										}
									},
									error:function(){
										alert("保存笔记失败，请稍后重试");
									}
								});
								location.reload();
							}
						}
					};