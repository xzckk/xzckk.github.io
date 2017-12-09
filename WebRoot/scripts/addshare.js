					function addShare(){
						//获取请求参数
						var noteId=$("#note_list li a.checked").parent().data("noteId");
						//发送Ajax请求
						$.ajax({
							url:"note/addshare.do",
							type:"post",
							data:{"noteId":noteId},
							dataType:"json",
							success:function(result){
								alert(result.msg);
							},
							error:function(){
								alert("笔记分享失败，请稍候重试");
							}
						});
						//取消冒泡
						return false;
					}