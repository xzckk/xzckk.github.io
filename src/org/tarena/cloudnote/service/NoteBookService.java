package org.tarena.cloudnote.service;

import org.tarena.cloudnote.util.NoteResult;

public interface NoteBookService {
	public NoteResult loadShares(String shareTitle);

	public NoteResult loadNoteBooks(String userId);
	
	public NoteResult addNoteBook(String userId, String noteBookName);
}