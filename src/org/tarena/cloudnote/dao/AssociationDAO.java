package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.entity.User;

public interface AssociationDAO {

	public User findUserAndNoteBooks(String userId);
	
	public User findUserByNoteBooks(String userId);
	
	public List<NoteBook> findNoteBooksAndUser();
	
	public List<NoteBook> findNoteBooksAndUser2();
}