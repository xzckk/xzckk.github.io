package org.tarena.cloudnote.service;

import org.tarena.cloudnote.util.NoteResult;

public interface UserService {

	public NoteResult authorize(String name);
	
	public NoteResult loadusers();
	
	public NoteResult checklogin(String name, String password);
	
	public NoteResult regist(String name, String password, String nick);
}