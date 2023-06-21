package com.springlec.base.model.bulletinBoard;

public class NDNoticeBoardDto {
	String adminid;//admin
	String title;//nwrite
	String context;//nwrite
	String insertdate;//notice
	String updatedate;//nwrite
	int seq;//noice
	
	
	public NDNoticeBoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public NDNoticeBoardDto(String adminid, String title, String context, String insertdate, String updatedate,
			int seq) {
		super();
		this.adminid = adminid;
		this.title = title;
		this.context = context;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.seq = seq;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	
	
}
	
	
	