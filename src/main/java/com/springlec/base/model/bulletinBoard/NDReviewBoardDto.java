package com.springlec.base.model.bulletinBoard;

public class NDReviewBoardDto {
	
	int likes; // 좋아요
	String userid; //userid
	String contexts; //글 쓴 내용
	String insertdate; //글 삽입 시기
	String updatedate; //글 편집 시기
	
	int layer; //부모 댓글의 댓글 순서
	int parent;//부모
	
	String adminid;
	
	String name;
	String image;
	
	public NDReviewBoardDto() {
		// TODO Auto-generated constructor stub
	}

	public NDReviewBoardDto(int likes, String userid, String contexts, String insertdate, String updatedate, int layer,
			int parent, String image) {
		super();
		this.likes = likes;
		this.userid = userid;
		this.contexts = contexts;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.layer = layer;
		this.parent = parent;
		this.image = image;
	}
	
	

}
