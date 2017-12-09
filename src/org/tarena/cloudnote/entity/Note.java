package org.tarena.cloudnote.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Note implements Serializable {

	private String cn_note_id;
	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_note_status_id;
	private String cn_note_type_id;
	private String cn_note_title;
	private String cn_note_body;
	private Long cn_note_create_time;
	private Long cn_note_last_modify_time;
	private String fre;
	private String battery;
	private String chipid;
	private String km;
	private String ca;
	
	public String getfre() {
		return fre;
	}
	public void setfre(String fre) {
		this.fre = fre;
	}
	
	public String getbattery() {
		return battery;
	}
	public void setbattery(String battery) {
		this.battery = battery;
	}
	
	public String getchipid() {
		return chipid;
	}
	public void setchipid(String chipid) {
		this.chipid = chipid;
	}
	
	public String getkm() {
		return km;
	}
	public void setkm(String km) {
		this.km = km;
	}
	
	public String getca() {
		return ca;
	}
	public void setca(String ca) {
		this.ca = ca;
	}
	//杩藉姞鏍煎紡鍖栨棩鏈熸樉绀烘柟娉�
	public String getCreateTime(){
		//灏哻n_note_create_time灞炴�ц浆鎴�"yyyy-MM-dd"
		if(cn_note_create_time==null || "".equals(cn_note_create_time)){
			return "";
		}
		try {
			Date date=new Date(cn_note_create_time);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String str=sdf.format(date);
			return str;
		} catch (Exception e) {
			return "";
		}
	}
	
	
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cnNoteId) {
		cn_note_id = cnNoteId;
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
	public String getCn_note_status_id() {
		return cn_note_status_id;
	}
	public void setCn_note_status_id(String cnNoteStatusId) {
		cn_note_status_id = cnNoteStatusId;
	}
	public String getCn_note_type_id() {
		return cn_note_type_id;
	}
	public void setCn_note_type_id(String cnNoteTypeId) {
		cn_note_type_id = cnNoteTypeId;
	}
	public String getCn_note_title() {
		return cn_note_title;
	}
	public void setCn_note_title(String cnNoteTitle) {
		cn_note_title = cnNoteTitle;
	}
	public String getCn_note_body() {
		return cn_note_body;
	}
	public void setCn_note_body(String cnNoteBody) {
		cn_note_body = cnNoteBody;
	}
	public Long getCn_note_create_time() {
		return cn_note_create_time;
	}
	public void setCn_note_create_time(Long cnNoteCreateTime) {
		cn_note_create_time = cnNoteCreateTime;
	}
	public Long getCn_note_last_modify_time() {
		return cn_note_last_modify_time;
	}
	public void setCn_note_last_modify_time(Long cnNoteLastModifyTime) {
		cn_note_last_modify_time = cnNoteLastModifyTime;
	}
}