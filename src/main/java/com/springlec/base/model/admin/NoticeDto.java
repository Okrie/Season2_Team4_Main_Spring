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
public class NoticeDto {
	int seq;
	String adminid;
	Timestamp insertdate;
	int invalidate;
	String title;
	String context;
	Timestamp updatedate;
}
