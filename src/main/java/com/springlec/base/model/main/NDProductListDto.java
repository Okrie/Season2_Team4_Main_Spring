package com.springlec.base.model.main;

public class NDProductListDto {//Main에 뿌려줄 product목록 관련 dto
	
	String pcode;
	String name;
	int price;
	String photo;
	String calories;
	
	//constructor
	public NDProductListDto() {
		// TODO Auto-generated constructor stub
	}

	public NDProductListDto(String pcode, String name, int price, String photo, String calories) {
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

	
}
