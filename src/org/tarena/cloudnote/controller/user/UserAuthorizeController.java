package org.tarena.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.UserService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/user")
@Controller("userAuthorizeController")
public class UserAuthorizeController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/authorize.do")
	@ResponseBody
	public NoteResult execute(String name){
		NoteResult result=userService.authorize(name);
		return result;
	}
}
