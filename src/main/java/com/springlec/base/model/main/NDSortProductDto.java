package com.springlec.base.model.main;

public class NDSortProductDto {
	String pcode; //product
	String name; //product
	int price; //manage
	String photo; //product
	String calories; //product
	
	
	
	//constructor
	public NDSortProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	//NDSortProductAll
	public NDSortProductDto(String pcode, String name, int price, String photo, String calories) {
		super();
		this.pcode = pcode;
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.calories = calories;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}
	
	//getter setter
	

}
