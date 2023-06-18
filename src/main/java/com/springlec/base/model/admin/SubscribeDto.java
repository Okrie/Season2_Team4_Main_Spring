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
public class SubscribeDto {
	int scode;
	String userid;
	Timestamp subscribedate;
	int subscribeSales;
	
	Timestamp plandate;
	int delivery;
	String uname;
	String pname;
	String address;
	int plcode;
}
