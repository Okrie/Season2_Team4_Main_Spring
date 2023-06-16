package com.springlec.base.dao.user;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.user.NUserLoginDto;

public class NUserDaoImpl implements NUserDao {

	SqlSession sqlSession;
	public static String nameSpace = "";
	
	@Override
	public int userInsert(NUserLoginDto dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".userRegisterDao");
	}

	@Override
	public String loginCheck(String uid, String upassword, String isWho) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdmin(String uid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userCheck(String userid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<NUserLoginDto> userInfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mypageUserinfoCheck(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void myPageUpdate(NUserLoginDto dto, String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int userCartIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
