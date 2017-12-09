package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteBookService;
import org.tarena.cloudnote.util.NoteResult;

@RequestMapping("/note")
@Controller("shareController")
public class ShareController {

	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/loadshares.do")
	@ResponseBody
	public NoteResult execute(String shareTitle){
		NoteResult result=noteBookService.loadShares(shareTitle);
		return result;
	}
}