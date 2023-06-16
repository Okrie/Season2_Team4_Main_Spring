package com.springlec.base.model.admin;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
	int seq;
	int parent;
	int layer;
	String userid;
	String pcode;
	String adminid;
	Timestamp insertdate;
	int invalidate;
	String rwcontext;
	String rwimage;
	Timestamp rwupdatedate;
	String rrcontext;
	Timestamp rrupdatedate;
}
