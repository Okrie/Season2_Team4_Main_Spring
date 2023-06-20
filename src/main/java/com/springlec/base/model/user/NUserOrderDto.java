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
public class NUserOrderDto {
	// orders
	int ordercode;
	String userid;
	String pcode;
	String address;
	int count;
	Timestamp orderdate;
	Timestamp refunddate;
	Timestamp deliverydate;
	
	// subscribes
	int scode;
	Timestamp subscribedate;
	
	// plans
	String plcode;
	String ppcode;
	int pscode;
	Timestamp plandate;
	int delivery;
	
	// product
	String photo;
	String name;
	String calories;
	
	// manage
	int price;
}
