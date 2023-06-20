package com.springlec.base.model.bulletinBoard;

public class NDNoticeBoardDto {
	String id;
	String title;
	String context;
	String insertdate;
	String updatedate;
	int noticeCount;
	
	public NDNoticeBoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public NDNoticeBoardDto(String id, String title, String context, String insertdate, String updatedate, int noticeCount) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.noticeCount = noticeCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	
	

}
