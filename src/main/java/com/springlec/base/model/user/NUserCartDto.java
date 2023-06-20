package com.springlec.base.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NUserCartDto {
	int seq;
	String userid;
	String pcode;
	int count;
}
