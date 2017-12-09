					function addnotebook(){
						//获取参数
						var noteBookName=$("#input_notebook").val().trim();
						//检查格式
						var ok=true;
						if(noteBookName==""){
							$("#span_addnotebook").html("请输入名称");
							ok=false;
						}
						//发送Ajax请求
						if(ok){
							$.ajax({
								url:"notebook/addnotebook.do",
								type:"post",
								data:{"userId":userId,"noteBookName":noteBookName},
								dataType:"json",
								success:function(result){
									if(result.status==1){ //重名
										$("#span_addnotebook").html(result.msg);
									}
									if(result.status==0){ //添加成功
										//添加到列表
										var noteBookId=result.data;
										createBookLi(noteBookName,noteBookId);
										//关闭对话框
										closeWindow();
										alert(result.msg);
									}
								},
								error:function(){
									alert("笔记本添加失败，请稍候重试");
								}
							});
						}
					};