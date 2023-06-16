package com.springlec.base.model.admin;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	String pcode;
	String name;
	String category;
	String rice;
	String cook1;
	String cook2;
	String cook3;
	String soup;
	String photo;
	Timestamp insertdate;
	int calories;

	int totalorders;
}
