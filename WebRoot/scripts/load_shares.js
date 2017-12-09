					function loadShares(event){
						var code=event.keyCode;
						if(code==13){ //回车键
							//清空列表
							$("#share_list").empty();
							//获取请求参数
							var shareTitle=$(this).val().trim();
							//判断逻辑
							var ok=true;
							if(shareTitle==""){
								ok=false;
							}
							//发送Ajax请求
							if(ok){
								$.ajax({
									url:"note/loadshares.do",
									type:"post",
									data:{"shareTitle":shareTitle},
									dataType:"json",
									success:function(result){
										if(result.status==1){
											alert(result.msg);
										}
										if(result.status==0){
											var shares=result.data;
											for(var i=0;i<shares.length;i++){
												var shareTitle=shares[i].name;
												var shareId=shares[i].cn_notebook_id;
												//拼接li
												createSharesLi(shareTitle,shareId);
											}
											$("#save_note").hide();
											$("#pc_part_1").hide();
											$("#pc_part_4").hide();
											$("#pc_part_7").hide();
											$("#pc_part_8").hide();
											$("#pc_part_6").show();
										}
									},
									error:function(){
										alert("搜索笔记失败，请稍候重试");
									}
								});
							}
						}
					};
					
function createSharesLi(shareTitle,shareId){
	var shares_li ='<li class="online">';
		shares_li+='	<a>';
		shares_li+='	 <i class="fa fa-share" title="online" rel="tooltip-bottom">';
		shares_li+='	 </i>'+shareTitle;
		shares_li+='	</a>';
		shares_li+='</li>';
		//将bookId和li元素绑定
		var $li=$(shares_li); //对象化
		$li.data("shareId",shareId);
		//将li元素添加到ul
		$("#share_list").append($li);
};