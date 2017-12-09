package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.entity.Share;

public interface NoteBookDAO {
	public List<Share> findByTitle(String shareTitle);

	public List<NoteBook> findByUserId(String userId);
	
	public int save(NoteBook noteBook);
}