package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.Note;
import org.tarena.cloudnote.entity.NoteBean;

public interface NoteDAO {

	public List<Note> findByNoteBookId(String noteBookId);
	
	public Note findByNoteId(String noteId);
	
	public int save(Note note);
	
	public int addBody(Note note);
	
	public int recycle(Note note);
	//组合查询
	public List<Note> findNotes(NoteBean note);
	//动态更新
	public int dynamicUpdate(Note note);
	//批量删除
	public int batchDelete(String[] noteIds);
}