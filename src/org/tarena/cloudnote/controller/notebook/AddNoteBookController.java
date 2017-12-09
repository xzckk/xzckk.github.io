package org.tarena.cloudnote.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteBookService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/notebook")
@Controller("noteBookSaveController")
public class AddNoteBookController {

	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/addnotebook.do")
	@ResponseBody
	public NoteResult execute(String userId, String noteBookName){
		NoteResult result=noteBookService.addNoteBook(userId, noteBookName);
		return result;
	}
}