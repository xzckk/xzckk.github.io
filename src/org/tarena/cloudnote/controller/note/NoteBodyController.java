package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/note")
@Controller("noteBodyController")
public class NoteBodyController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadnotebody.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result=noteService.loadNote(noteId);
		return result;
	}
}