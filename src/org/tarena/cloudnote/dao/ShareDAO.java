package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.Share;

public interface ShareDAO {

	public Share findByNoteId(String noteId);
	
	public int save(Share share);
	
	
	public Share findByShareId(String shareId);
}