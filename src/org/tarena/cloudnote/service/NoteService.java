package org.tarena.cloudnote.service;

import org.tarena.cloudnote.sql.vo.SearchNoteParams;
import org.tarena.cloudnote.util.NoteResult;

public interface NoteService {

	public NoteResult loadNotes(String noteBookId);
	
	public NoteResult loadNote(String noteId);
	
	public NoteResult addNote(String userId, String noteBookId,String noteTitle);
	
	public NoteResult addNoteBody(String noteBookId, String noteId,
			String noteTitle, String noteBody, String fre, String battery,String chipid,String km, String ca);
	
	public NoteResult recycleNote(String noteId);
	
	public NoteResult addShare(String noteId);
	
	
	public NoteResult loadShare(String shareId);
	
	public NoteResult searchNotes(SearchNoteParams params);
}