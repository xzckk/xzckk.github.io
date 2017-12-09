					function updateNote(){
						//判断选中笔记
						var $note_li=$("#note_list li a.checked");
						if($note_li.length==0){
							alert("请选择笔记");
						}else{

							//获取请求参数
							var noteBookId=$("#book_list li a.checked").parent().data("noteBookId");
							var noteId=$("#note_list li a.checked").parent().data("noteId");
							var noteTitle=$("#input_note_title").val().trim();
							var noteBody=$("#input_note_body").val().trim();
							var fre=$("#input_note_fre").val().trim();
							var battery=$("#input_note_battery").val().trim();
							var chipid=$("#input_note_chip_id").val().trim();
							var km=$("#input_note_km").val().trim();
							var ca=$("#input_note_ca").val().trim();
								//um.getContent();
							//格式判断
							var ok=true;

							if(noteTitle==""){
								alert("请输入标");
								ok=false;
							}
							//发送Ajax请求
							if(ok){
								$.ajax({
									url:"note/addnotebody.do",
									type:"post",
									data:{"noteBookId":noteBookId,"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody,"fre":fre,"battery":battery,"chipid":chipid,"km":km,"ca":ca},
									dataType:"json",
									success:function(result){
										if(result.status==1){
											alert(result.msg);
										}
										if(result.status==0){
											//更新笔记li
											var str ='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom">';
												str+='</i>'+noteTitle;
												str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
											$("#note_list li a.checked").html(str);
											alert(result.msg);
										}
									},
									error:function(){
										alert("保存笔记失败，请稍后重试");
									}
								});
							}
						}
					};