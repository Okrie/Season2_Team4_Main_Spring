package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.UserDao;
import com.springlec.base.model.admin.UserDto;


@Service
public class UserGraphServiceImpl implements UserGraphService {
	
	@Autowired
	UserDao userDao;

	@Override
	public ArrayList<ArrayList<String>> searchGender() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<UserDto> dtoUserGender = userDao.searchGender();
		ArrayList<ArrayList<String>> dataSetGender = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowGender = new ArrayList<String>();
		headerRowGender.add("'성별', '유저수'");
		dataSetGender.add(headerRowGender);
		for (int i = 0; i < dtoUserGender.size(); i++) {
			UserDto userDto = dtoUserGender.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + userDto.getGender() + "'");
			row.add(Integer.toString(userDto.getCount()));
			dataSetGender.add(row);
		}
		return dataSetGender;
	}

	@Override
	public ArrayList<ArrayList<String>> searchAge() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<UserDto> dtoUserAge = userDao.searchAge();
		ArrayList<ArrayList<String>> dataSetAge = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowAge = new ArrayList<String>();
		headerRowAge.add("'연령대'");
		headerRowAge.add("'유저수'");
		dataSetAge.add(headerRowAge);
		for (int i = 0; i < dtoUserAge.size(); i++) {
			UserDto userDto = dtoUserAge.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + userDto.getAge_group() + "'");
			row.add(Integer.toString(userDto.getCount()));
			dataSetAge.add(row);
		}
		
		return dataSetAge;
	}

	@Override
	public ArrayList<ArrayList<String>> searchInsertdate() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<UserDto> dtoUserInsert = userDao.searchInsertdate();
		ArrayList<ArrayList<String>> dataSetInsert = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowInsert = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd (E)");
		
		headerRowInsert.add("'날짜'");
		headerRowInsert.add("'유저수'");
		dataSetInsert.add(headerRowInsert );
		for (int i = 0; i < dtoUserInsert.size(); i++) {
			UserDto userDto = dtoUserInsert.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + dateFormat.format(userDto.getDate()) + "'");
			row.add(Integer.toString(userDto.getCount()));
			dataSetInsert.add(row);
		}
		
		return dataSetInsert;
	}

}
