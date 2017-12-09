					function loadUserNoteBody(){
						//显示编辑笔记，隐藏其他
						$("#pc_part_5").hide();
						$("#pc_part_3").show();
						//清除当前笔记本li选中状态移除
						$("#note_list li a").removeClass("checked");
						//将当前笔记本li设置为选中状态
						$(this).find("a").addClass("checked");
						//获取请求参数
						var noteId=$(this).data("noteId");
						//发送Ajax请求
						$.ajax({
							url:"note/loadnotebody.do",
							type:"post",
							data:{"noteId":noteId},
							dataType:"json",
							success:function(result){
								if(result.status==0){
									var note=result.data;
									var noteTitle=note.cn_note_title;
									var noteBody=note.cn_note_body;
									var fre=note.fre;
									var battery=note.battery;
									var chipid=note.chipid;
									var km=note.km;
									var ca=note.ca;
									$("#input_note_title").val(noteTitle);
									//设置内容
									$("#input_note_body").val(noteBody);
									$("#input_note_fre").val(fre);
									$("#input_note_battery").val(battery);
									$("#input_note_chip_id").val(chipid);
									$("#input_note_km").val(km);
									$("#input_note_ca").val(ca);


									

//									um.setContent(noteBody);
								}
							},
							error:function(){
								alert("笔记内容加载失败，请稍候重试");
							},
						});
					};