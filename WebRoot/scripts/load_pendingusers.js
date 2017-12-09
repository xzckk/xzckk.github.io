function loadPendingUsers(){
	$.ajax({
		url:"usermanage/loadusers.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var users=result.data; //笔记本数组
				for(var i=0;i<users.length;i++){
					var userName=users[i].cn_user_name;
					var userau=users[i].cn_user_au;
					//拼接li元素
					createBookLi(userName,userau);
				}
			}
		},
		error:function(){
			alert("用户笔记本加载失败，请刷新页面");
		}
	});
};
				
function createBookLi(userName,userau){
	var notebook_li ='<li class="online">';
		notebook_li+='	<a>';
		notebook_li+='	 <i class="fa fa-book" title="online" rel="tooltip-bottom">';
		notebook_li+='	 </i>'+userName;
		notebook_li+='	</a>';
		notebook_li+='</li>';
	//将bookId和li元素绑定
	var $li=$(notebook_li); //对象化
	$li.data("userName",userName);
	//将li元素添加到ul
	$("#users_list").append($li);
};