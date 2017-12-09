//笔记本添加对话框
function showAddNoteBookWindow(){
	//遮挡背景
	$(".opacity_bg").show();
	//对话框
	$("#can").load("alert/alert_notebook.html");
};

//笔记添加对话框
function showAddNoteWindow(){
	//判断是否有选中的笔记本
	var $book_li=$("#book_list a.checked");
	if($book_li.length==0){
		alert("please choose one");
	}else{
		//遮挡背景
		$(".opacity_bg").show();
		//对话框
		$("#can").load("alert/alert_note.html");
	}
};

function showRecycleNoteWindow(){
	//遮挡背景
	$(".opacity_bg").show();
	//对话框
	$("#can").load("alert/alert_delete_note.html");
}