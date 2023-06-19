package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.UserDao;
import com.springlec.base.model.admin.UserDto;

@Service
public class UserListServiceImpl implements UserListService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public ArrayList<ArrayList<String>> searchUser() throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDateTime now =LocalDateTime.now();
		
		ArrayList<UserDto> dtoUser = userDao.searchUser();
		
		ArrayList<ArrayList<String>> dataSetUser = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoUser.size(); i++) {
			UserDto userDto = dtoUser.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'"+userDto.getUserid()+"'");
			row.add("'"+userDto.getName()+"'");
			row.add("'"+userDto.getGender()+"'");
			row.add("'"+Integer.toString(Period.between(userDto.getBirthdate().toLocalDateTime().toLocalDate(), now.toLocalDate()).getYears())+"세'");
			row.add("'"+userDto.getTelno()+"'");
			row.add("'"+userDto.getAddress()+"'");
			row.add("'"+userDto.getEmail()+"'");
			row.add("'"+String.format("%,d 원",userDto.getTotalbuying())+"'");
			if (userDto.getAllergy() == null) {
				row.add("'알러지가 없습니다.'");
			} else {
				row.add("'"+userDto.getAllergy()+"'");
			}
			row.add("'"+dateFormat.format(userDto.getInsertdate())+"'");
			if (userDto.getInvalidate() == 1) {
				row.add("'회원'");
			} else {
				row.add("'탈퇴한 회원'"); 
			}
			dataSetUser.add(row);
		}
		return dataSetUser;
	}

}
