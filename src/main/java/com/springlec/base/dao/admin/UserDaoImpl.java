package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.UserDto;

public class UserDaoImpl implements UserDao {
	
	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.UserDao";

	@Override
	public ArrayList<UserDto> searchUser() {
		// TODO Auto-generated method stub
		List<UserDto> resultList = sqlsession.selectList(namespace + ".searchUser");
		ArrayList<UserDto> userList =new ArrayList<>(resultList);
		return userList;
	}

	@Override
	public ArrayList<UserDto> searchGender() {
		// TODO Auto-generated method stub
		List<UserDto> resultList = sqlsession.selectList(namespace + ".searchGender");
		ArrayList<UserDto> userList =new ArrayList<>(resultList);
		return userList;
	}

	@Override
	public ArrayList<UserDto> searchAge() {
		// TODO Auto-generated method stub
		List<UserDto> resultList = sqlsession.selectList(namespace + ".searchAge");
		ArrayList<UserDto> userList =new ArrayList<>(resultList);
		return userList;
	}

	@Override
	public ArrayList<UserDto> searchInsertdate() {
		// TODO Auto-generated method stub
		List<UserDto> resultList = sqlsession.selectList(namespace + ".searchInsertdate");
		ArrayList<UserDto> userList =new ArrayList<>(resultList);
		return userList;
	}

}
