package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/note")
@Controller("addNoteController")
public class AddNoteController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/addnote.do")
	@ResponseBody
	public NoteResult execute(String userId, String noteBookId, String noteTitle){
		NoteResult result=noteService.addNote(userId, noteBookId, noteTitle);
		return result;
	}
}