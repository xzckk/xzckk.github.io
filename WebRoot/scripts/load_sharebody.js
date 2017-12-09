					function loadShareBody(){ 
						//点击显示笔记列表，隐藏其他列表
						$("#pc_part_4").hide();
						$("#pc_part_7").hide();
						$("#pc_part_8").hide();
						$("#pc_part_6").show();
						$("#pc_part_2").show();
						$("#save_note").show();
						//清除当前笔记本li选中状态移除
						$("#share_list li a").removeClass("checked");
						//将当前笔记本li设置为选中状态
						$(this).find("a").addClass("checked");
						//再次单击清空笔记列表
						$("#note_list").empty();
						//获取请求参数
						var noteBookId=$(this).data("shareId");
						//发送Ajax请求
						$.ajax({
							url:"note/loadnotes.do",
							type:"post",
							data:{"noteBookId":noteBookId},
							dataType:"json",
							success:function(result){
								if(result.status==0){
									var notes=result.data; //笔记数组
									for(var i=0;i<notes.length;i++){
										var noteTitle=notes[i].cn_note_title;
										var noteId=notes[i].cn_note_id;
										var noteStatusId=notes[i].cn_note_status_id;
										//拼接笔记li
										if(noteStatusId==1){
											createnoteLi(noteTitle,noteId);
										}
									}
								}
							},
							error:function(){
								alert("笔记加载失败，请稍后重试");
							}
						});
					};
					
function createnoteLi(noteTitle,noteId){
	var notes_li ='<li class="online">';
		notes_li+='	 <a>';
		notes_li+='		<i >';
		//class="fa fa-file-text-o" title="online" rel="tooltip-bottom"
		notes_li+='		</i>'+noteTitle;
		notes_li+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
		notes_li+='	 </a>';
		notes_li+='  <div class="note_menu" tabindex="-1">';
		notes_li+='		<dl>';
		//notes_li+='			<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
		//notes_li+='			<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
		notes_li+='			<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="delete"><i class="fa fa-times"></i></button></dt>';
		notes_li+='		</dl>';
		notes_li+='  </div>';
		notes_li+='</li>';
	//将noteId绑定li
	var $li=$(notes_li);
	$li.data("noteId",noteId);
	//将li添加到ul列表
	$("#note_list").append($li);
};