package org.tarena.cloudnote.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteBookService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/notebook")
@Controller("noteBookEditController")
public class NoteBookEditController {

	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result=noteBookService.loadNoteBooks(userId);
		return result;
	}
}