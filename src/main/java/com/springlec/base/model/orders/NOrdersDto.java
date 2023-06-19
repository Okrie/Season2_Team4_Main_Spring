package com.springlec.base.model.orders;

public class NOrdersDto {

	String userid;
	String pcode;
	String name;
	String telno;
	String address;
	String email;
	String photo;
	int price;
	String count;
	int seq;
	
	
	public NOrdersDto() {
		// TODO Auto-generated constructor stub
	}


	public NOrdersDto(String userid, String pcode, String name, String telno, String address, String email,
			String photo, int price, String count, int seq) {
		super();
		this.userid = userid;
		this.pcode = pcode;
		this.name = name;
		this.telno = telno;
		this.address = address;
		this.email = email;
		this.photo = photo;
		this.price = price;
		this.count = count;
		this.seq = seq;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPcode() {
		return pcode;
	}


	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTelno() {
		return telno;
	}


	public void setTelno(String telno) {
		this.telno = telno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
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


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
}
