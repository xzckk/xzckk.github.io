package org.tarena.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.UserService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/usermanage")
@Controller("userManageController")
public class UserManageController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/loadusers.do")
	@ResponseBody
	public NoteResult execute(){
		NoteResult result=userService.loadusers();
		return result;
	}
}
