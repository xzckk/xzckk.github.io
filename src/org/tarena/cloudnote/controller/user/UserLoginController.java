package org.tarena.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.UserService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/user") //全部以/user请求开头，命名空间
@Controller("userLoginController")
public class UserLoginController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody //调用jackson包转换成json输出
	public NoteResult execute(String name, String password){
		NoteResult result=userService.checklogin(name, password);
		return result;
	}
}