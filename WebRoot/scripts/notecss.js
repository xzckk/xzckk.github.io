				function noteSure(){	
					$("#note_list").on("click",".btn_slide_down",function(){
						//隐藏所有笔记菜单
						$("#note_list .note_menu").hide();
						//显示菜单
						$(this).parents("li").find(".note_menu").show();
						//将当前笔记li选中
						$("#note_list li a.checked").removeClass("checked");
						$(this).parents("li").find("a").addClass("checked");
						//阻止冒泡
						return false;
					});
					//追加鼠标对笔记菜单的处理
					$("#note_list").on("mouseover",".note_menu",function(){
						$(this).show(); //保持显示
					});
					$("body").on("mouseout",".note_menu",function(){
						$(this).hide(); //隐藏菜单
					});
					//点击body部分隐藏菜单
					$("body").click(function(){
						$("#note_list .note_menu").hide();
					});
				};