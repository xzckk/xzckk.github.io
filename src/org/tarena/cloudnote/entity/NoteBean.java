package org.tarena.cloudnote.entity;

/**
 * 为Note类追加属性
 * @author soft01
 */
public class NoteBean extends Note {

	private Long beginTime;
	private Long endTime;
	
	
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}