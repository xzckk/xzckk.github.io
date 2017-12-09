package org.tarena.cloudnote.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.NoteDAO;
import org.tarena.cloudnote.dao.ShareDAO;
import org.tarena.cloudnote.entity.Note;
import org.tarena.cloudnote.entity.NoteBean;
import org.tarena.cloudnote.entity.Share;
import org.tarena.cloudnote.sql.vo.SearchNoteParams;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;

@Transactional
@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource
	private NoteDAO noteDAO;
	@Resource
	private ShareDAO shareDAO;
	
	public NoteResult loadNotes(String noteBookId) {
		NoteResult result=new NoteResult();
		List<Note> notes=noteDAO.findByNoteBookId(noteBookId);
		result.setStatus(0);
		result.setMsg("绗旇鍒楄〃鍔犺浇鎴愬姛");
		result.setData(notes);
		return result;
	}

	public NoteResult loadNote(String noteId) {
		NoteResult result=new NoteResult();
		Note note=noteDAO.findByNoteId(noteId);
		result.setStatus(0);
		result.setMsg("绗旇鍐呭鍔犺浇鎴愬姛");
		result.setData(note);
		return result;
	}

	public NoteResult addNote(String userId, String noteBookId, String noteTitle) {
		NoteResult result=new NoteResult();
		List<Note> notes=noteDAO.findByNoteBookId(noteBookId);
		for (Note note : notes) {
			if (noteTitle.equals(note.getCn_note_title()) && "1".equals(note.getCn_note_status_id())) {
				result.setStatus(1);
				result.setMsg("绗旇宸插瓨鍦�");
				result.setData(null);
				return result;
			}
		}
		Note note=new Note();
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_notebook_id(noteBookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_title(noteTitle);
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDAO.save(note);
		result.setStatus(0);
		result.setMsg("Add successfully");
		result.setData(note.getCn_note_id());
		return result;
	}

	public NoteResult addNoteBody(String noteBookId, String noteId,
			String noteTitle, String noteBody, String fre, String battery,String chipid,String km, String ca) {
		NoteResult result=new NoteResult();
		List<Note> notes=noteDAO.findByNoteBookId(noteBookId);
		for (Note note_old : notes) {
			if(noteId.equals(note_old.getCn_note_id())){
				Note note=new Note();
				note.setCn_note_id(noteId);
				note.setCn_note_title(noteTitle);
				note.setCn_note_body(noteBody);
				note.setfre(fre);
				note.setbattery(battery);
				note.setchipid(chipid);
				note.setkm(km);
				note.setca(ca);
				note.setCn_note_last_modify_time(System.currentTimeMillis());
				noteDAO.addBody(note);
				result.setStatus(0);
				result.setMsg("update successfuly");
				result.setData(null);
				return result;
			}else if(noteTitle.equals(note_old.getCn_note_title()) && "1".equals(note_old.getCn_note_status_id())){
				result.setStatus(1);
				result.setMsg("the key is existed");
				result.setData(null);
				return result;
			}
		}
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setfre(fre);
		note.setbattery(battery);
		note.setchipid(chipid);
		note.setkm(km);
		note.setca(ca);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDAO.addBody(note);
		result.setStatus(0);
		result.setMsg("update successfully");
		result.setData(null);
		return result;
	}

	public NoteResult recycleNote(String noteId) {
		NoteResult result=new NoteResult();
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_status_id("2");
		noteDAO.recycle(note);
		result.setStatus(0);
		result.setMsg("宸叉坊鍔犺嚦鍥炴敹绔�");
		result.setData(null);
		return result;
	}
	
	public NoteResult addShare(String noteId) {
		NoteResult result=new NoteResult();
		Share share_old=shareDAO.findByNoteId(noteId);
		if(share_old!=null){
			result.setStatus(1);
			result.setMsg("绗旇宸插垎浜�");
			result.setData(null);
			return result;
		}
		Note note=noteDAO.findByNoteId(noteId);
		if(note==null){
			result.setStatus(2);
			result.setMsg("绗旇涓嶅瓨鍦�");
			result.setData(null);
			return result;
		}
		String noteTitle=note.getCn_note_title();
		String noteBody=note.getCn_note_body();
		Share share=new Share();
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_share_title(noteTitle);
		share.setCn_share_body(noteBody);
		share.setCn_note_id(noteId);
		shareDAO.save(share);
		result.setStatus(0);
		result.setMsg("绗旇鍒嗕韩鎴愬姛");
		result.setData(null);
		return result;
	}



	public NoteResult loadShare(String shareId) {
		NoteResult result=new NoteResult();
		Share share=shareDAO.findByShareId(shareId);
		if(share==null){
			result.setStatus(1);
			result.setMsg("绗旇涓嶅瓨鍦�");
			result.setData(null);
			return result;
		}
		result.setStatus(0);
		result.setMsg("绗旇棰勮鎴愬姛");
		result.setData(share);
		return result;
	}

	public NoteResult searchNotes(SearchNoteParams params) {
		NoteResult result=new NoteResult();
		NoteBean noteBean=new NoteBean();
		//璁剧疆鏌ヨ鍙傛暟
		//鏍囬
		if (params.getTitle()!=null && !"".equals(params.getTitle())) {
			noteBean.setCn_note_title("%"+params.getTitle()+"%");
		}
		//鐘舵��
		if (!"0".equals(params.getStatus())) {
			noteBean.setCn_note_status_id(params.getStatus());
		}
		//璧峰鏃ユ湡
		if (params.getBeginTime()!=null && !"".equals(params.getBeginTime())) {
			Date beginDate=Date.valueOf(params.getBeginTime());
			Long beginTime=beginDate.getTime();
			noteBean.setBeginTime(beginTime);
		}
		//缁撴潫鏃ユ湡
		if (params.getEndTime()!=null && !"".equals(params.getEndTime())) {
			Date endDate=Date.valueOf(params.getEndTime());
			Long endTime=endDate.getTime();
			noteBean.setEndTime(endTime);
		}
		List<Note> notes=noteDAO.findNotes(noteBean);
		result.setStatus(0);
		result.setMsg("鏌ヨ鎴愬姛");
		result.setData(notes);
		return result;
	}
}