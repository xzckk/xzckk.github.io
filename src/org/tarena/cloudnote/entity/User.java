package org.tarena.cloudnote.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private String cn_user_id;
	private String cn_user_name;
	private String cn_user_password;
	private String cn_user_token;
	private String cn_user_nick;
	private String cn_user_au;
	//鍏宠仈灞炴�э紝鐢ㄤ簬鍔犺浇鐩稿叧cn_notebook琛ㄤ俊鎭�
	private List<NoteBook> noteBooks;
	
	
	public List<NoteBook> getNoteBooks() {
		return noteBooks;
	}
	public void setNoteBooks(List<NoteBook> noteBooks) {
		this.noteBooks = noteBooks;
	}
	public String getCn_user_au() {
		return cn_user_au;
	}
	public void setCn_user_au(String cnUserau) {
		cn_user_au = cnUserau;
	}
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cnUserId) {
		cn_user_id = cnUserId;
	}
	public String getCn_user_name() {
		return cn_user_name;
	}
	public void setCn_user_name(String cnUserName) {
		cn_user_name = cnUserName;
	}
	public String getCn_user_password() {
		return cn_user_password;
	}
	public void setCn_user_password(String cnUserPassword) {
		cn_user_password = cnUserPassword;
	}
	public String getCn_user_token() {
		return cn_user_token;
	}
	public void setCn_user_token(String cnUserToken) {
		cn_user_token = cnUserToken;
	}
	public String getCn_user_nick() {
		return cn_user_nick;
	}
	public void setCn_user_nick(String cnUserNick) {
		cn_user_nick = cnUserNick;
	}
}