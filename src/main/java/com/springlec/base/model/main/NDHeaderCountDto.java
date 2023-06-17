package com.springlec.base.model.main;

import java.security.Timestamp;

public class NDHeaderCountDto {

	String userid;
	String pcode;
	String count;
	int price;
	Timestamp subsribeDate;
	
	

	//constructor
	public NDHeaderCountDto() {
		// TODO Auto-generated constructor stub
	}

	public NDHeaderCountDto(String userid, String pcode, String count, int price) {
		super();
		this.userid = userid;
		this.pcode = pcode;
		this.count = count;
		this.price = price;
	}
	
	
	
	public NDHeaderCountDto(Timestamp subsribeDate) {
		super();
		this.subsribeDate = subsribeDate;
	}

	//heartCount
	public NDHeaderCountDto(String userid, String pcode) {
		super();
		this.userid = userid;
		this.pcode = pcode;
	}
	

	//getter setter
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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public Timestamp getSubsribeDate() {
		return subsribeDate;
	}

	public void setSubsribeDate(Timestamp subsribeDate) {
		this.subsribeDate = subsribeDate;
	}
	
}//End
