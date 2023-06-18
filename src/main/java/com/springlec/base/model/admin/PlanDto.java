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
public class PlanDto {
	int plcode;
	String pcode;
	int scode;
	Timestamp plandate;
	int delivery;
	Timestamp deliverydate;

	String name;

}
