					function addnote(){
						//获取请求参数
						var noteTitle=$("#input_note").val().trim();
						var noteBookId=$("#book_list li a.checked").parent().data("noteBookId");
						//逻辑判断
						var ok=true;
						if(noteTitle==""){
							$("#span_addnote").html("请输入笔记名");
							ok=false;
						}
						//发送Ajax请求
						if(ok){
							$.ajax({
								url:"note/addnote.do",
								type:"post",
								data:{"userId":userId,"noteBookId":noteBookId,"noteTitle":noteTitle},
								dataType:"json",
								success:function(result){
									if(result.status==1){
										$("#span_addnote").html(result.msg);
									}
									if(result.status==0){
										var noteId=result.data;
										createnoteLi(noteTitle,noteId);
										closeWindow;
										alert(result.msg);
									}
								},
								error:function(){
									alert("笔记添加失败，请稍候重试")
								}
							});
						}
					};