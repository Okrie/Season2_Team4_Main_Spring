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
public class ManageDto {
	String adminid;
	String pcode;
	int stock;
	int price;
	Timestamp updatedate;
	int invalidate;
	
	int count;
}
