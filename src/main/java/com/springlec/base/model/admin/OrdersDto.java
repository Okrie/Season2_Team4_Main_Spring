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
public class OrdersDto {
	int ordercode;
	String userid;
	String pcode;
	String address;
	int count;
	Timestamp orderdate;
	Timestamp refunddate;
	Timestamp deliverydate;
	int totalsales;
	String month;
	int yearSales;
	int monthSales;
	int todo;
	int price;
	
	String email;
	String name;
	
}
