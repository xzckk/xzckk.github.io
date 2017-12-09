package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.sql.vo.SearchNoteParams;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/note")
@Controller("noteFindAllController")
public class NoteFindAllController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/findallnotes.do")
	@ResponseBody
	public NoteResult execute(SearchNoteParams params){
		NoteResult result=noteService.searchNotes(params);
		return result;
	}
}