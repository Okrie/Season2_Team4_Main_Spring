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
public class NUserLoginDto {
	// Field
	String userid;
	String userpw;
	String name;
	String gender;
	String birthdate;
	String telno;
	String email;
	String address;
	String allergy;
	Timestamp insertdate;
	int invalidate;
}
