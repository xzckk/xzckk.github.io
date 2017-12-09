					function recyclenote(){
						//获取请求参数
						var noteId=$("#note_list li a.checked").parent().data("noteId");
						//发送Ajax请求
						$.ajax({
							url:"note/recyclenote.do",
							type:"post",
							data:{"noteId":noteId},
							dataType:"json",
							success:function(result){
								if(result.status==0){
									$("#input_note_title").val("");
									um.setContent("");
									$("#note_list li a.checked").hide();
									closeWindow();
									alert(result.msg);
								}
							},
							error:function(){
								alert("笔记删除失败，请稍候重试");
							}
						});
					}