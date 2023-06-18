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
public class UserDto {
	String userid;
	String userpw;
	String name;
	String gender;
	Timestamp birthdate;
	String telno;
	String address;
	String email;
	String age_group;
	String allergy;
	Timestamp insertdate;
	int invalidate;
	
	int totalbuying;
	int count;
	Timestamp date;
}
