package com.springlec.base.model.cart;

public class NCartDto {

	String userid;
	int seq;
	String pcode;
	String name;
	String photo;
	int price;
	String count;
	
	public NCartDto() {
		// TODO Auto-generated constructor stub
	}

	public NCartDto(String userid, int seq, String pcode, String name, String photo, int price, String count) {
		super();
		this.userid = userid;
		this.seq = seq;
		this.pcode = pcode;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.count = count;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	
	
}
