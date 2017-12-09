				function loadUserNoteBooks(){
					$.ajax({
						url:"notebook/loadbooks.do",
						type:"post",
						data:{"userId":userId},
						dataType:"json",
						success:function(result){
							if(result.status==0){
								var noteBooks=result.data; //笔记本数组
								for(var i=0;i<noteBooks.length;i++){
									var noteBookName=noteBooks[i].cn_notebook_name;
									var noteBookId=noteBooks[i].cn_notebook_id;
									var year=noteBooks[i].year;
									var model=noteBooks[i].model;
									//拼接li元素
									createBookLi(noteBookName,noteBookId,year,model);
								}
							}
						},
						error:function(){
							alert("用户笔记本加载失败，请刷新页面");
						}
					});
				};
				
function createBookLi(noteBookName,noteBookId,year,model){
	var notebook_li ='<li class="online">';
		notebook_li+='	<a>';
		notebook_li+='	 <i >';
		//class="fa fa-book" title="online" rel="tooltip-bottom"
		notebook_li+='	 </i>'+noteBookName+" "+model+" "+year;
		notebook_li+='	</a>';
		notebook_li+='</li>';
	//将bookId和li元素绑定
	var $li=$(notebook_li); //对象化
	$li.data("noteBookId",noteBookId);
	//将li元素添加到ul
	$("#book_list").append($li);
};