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
public class BoardDto {
	int seq;
	int parent;
	int layer;
	String userid;
	String pcode;
	String adminid;
	Timestamp insertdate;
	int invalidate;
	String bwtitle;
	String bwcontext;
	String bwimage;
	Timestamp bwupdatedate;
	String brtitle;
	String brcontext;
	Timestamp brupdatedate;
}
