package org.tarena.cloudnote.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class NoteBook implements Serializable {

	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_notebook_type_id;
	private String cn_notebook_name;
	private String cn_notebook_desc;
	private String year;
	private String model;
	private String name;
	private Timestamp cn_notebook_createtime;
	//杩藉姞鍏宠仈灞炴�э紝鐢ㄤ簬鍔犺浇鐩稿叧cn_user淇℃伅
	private User user;
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getmodel() {
		return model;
	}
	public void setmodel(String model) {
		this.model = model;
	}
	public String getyear() {
		return year;
	}
	public void setyear(String year) {
		this.year = year;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCn_notebook_id() {
		return cn_notebook_id;
	}
	public void setCn_notebook_id(String cnNotebookId) {
		cn_notebook_id = cnNotebookId;
	}
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cnUserId) {
		cn_user_id = cnUserId;
	}
	public String getCn_notebook_type_id() {
		return cn_notebook_type_id;
	}
	public void setCn_notebook_type_id(String cnNotebookTypeId) {
		cn_notebook_type_id = cnNotebookTypeId;
	}
	public String getCn_notebook_name() {
		return cn_notebook_name;
	}
	public void setCn_notebook_name(String cnNotebookName) {
		cn_notebook_name = cnNotebookName;
	}
	public String getCn_notebook_desc() {
		return cn_notebook_desc;
	}
	public void setCn_notebook_desc(String cnNotebookDesc) {
		cn_notebook_desc = cnNotebookDesc;
	}
	public Timestamp getCn_notebook_createtime() {
		return cn_notebook_createtime;
	}
	public void setCn_notebook_createtime(Timestamp cnNotebookCreatetime) {
		cn_notebook_createtime = cnNotebookCreatetime;
	}
}