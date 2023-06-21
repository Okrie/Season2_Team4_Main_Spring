package com.springlec.base.model.user;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NUserWishlistDto {
	String userid;
	String pcode;
	Timestamp insertdate;
	
	// product
	String name;
	String photo;
	
	// manage
	int price;
}
