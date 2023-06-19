package com.springlec.base.model.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataSetProduct {
	String pcode;
	String name;
	String category;
	String rice;
	String cook1;
	String cook2;
	String cook3;
	String soup;
	String photo;
	int stock;
	int price;
	int calories;
	String conditionInsert;
	String conditionUpdate;
	int invalidate;
}
