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
public class NUserReviewDto {
	// user review - rwrite Table
	int seq;
	String userid;
	int ordercode;
	String pcode;
	int likes;
	String context;
	String image;
	Timestamp updatedate;
	
	// review order dto - review Table
	int parent;
	int layer;
	String adminid;
	String insertdate;
	String invalidate;
	
	// admin review reply
	
	
	
}
