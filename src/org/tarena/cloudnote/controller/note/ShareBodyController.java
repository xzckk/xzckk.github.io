package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/note")
@Controller("shareBodyController")
public class ShareBodyController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadsharebody.do")
	@ResponseBody
	public NoteResult execute(String shareId){
		NoteResult result=noteService.loadShare(shareId);
		return result;
	}
}