package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/note")
@Controller("addNoteBodyController")
public class AddNoteBodyController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/addnotebody.do")
	@ResponseBody
	public NoteResult execute(String noteBookId, String noteId, String noteTitle, String noteBody, String fre, String battery,String chipid,String km, String ca){
		NoteResult result=noteService.addNoteBody(noteBookId, noteId, noteTitle, noteBody,fre,battery,chipid,km,ca);
		return result;
	}
}