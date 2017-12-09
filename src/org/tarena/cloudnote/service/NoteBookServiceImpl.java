package org.tarena.cloudnote.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.NoteBookDAO;
import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.entity.Share;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;

@Transactional
@Service("noteBookService")
public class NoteBookServiceImpl implements NoteBookService {

	@Resource
	private NoteBookDAO noteBookDAO;
	public NoteResult loadShares(String shareTitle) {
		NoteResult result=new NoteResult();
		String shareTitle_new="%"+shareTitle+"%";
		List<Share> shares=noteBookDAO.findByTitle(shareTitle_new);
		if(shares.isEmpty()){
			result.setStatus(1);
			result.setMsg("鏃犵浉鍏崇瑪璁�");
			result.setData(null);
			return result;
		}
		result.setStatus(0);
		result.setMsg("绗旇鏌ヨ鎴愬姛");
		result.setData(shares);
		return result;
	}
	public NoteResult loadNoteBooks(String userId) {
		NoteResult result=new NoteResult();
		List<NoteBook> noteBooks=noteBookDAO.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("绗旇鏈垪琛ㄥ姞杞芥垚鍔�");
		result.setData(noteBooks);
		return result;
	}

	public NoteResult addNoteBook(String userId, String noteBookName) {
		NoteResult result=new NoteResult();
		List<NoteBook> noteBooks=noteBookDAO.findByUserId(userId);
		for (NoteBook noteBook : noteBooks) {
			if (noteBookName.equals(noteBook.getCn_notebook_name())) {
				result.setStatus(1);
				result.setMsg("绗旇鏈凡瀛樺湪");
				result.setData(null);
				return result;
			}
		}
		NoteBook noteBook=new NoteBook();
		noteBook.setCn_notebook_id(NoteUtil.createId());
		noteBook.setCn_user_id(userId);
		noteBook.setCn_notebook_type_id("5");
		noteBook.setCn_notebook_name(noteBookName);
		noteBook.setCn_notebook_desc("");
		noteBook.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		noteBookDAO.save(noteBook);
		result.setStatus(0);
		result.setMsg("Vehicle added");
		result.setData(noteBook.getCn_notebook_id());
		return result;
	}
}