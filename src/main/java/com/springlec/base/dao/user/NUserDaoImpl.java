package com.springlec.base.dao.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class NUserDaoImpl implements NUserDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.user";
	
//	@Override
//	public int userInsert(NUserLoginDto dto) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlSession.insert(nameSpace + ".userRegisterDao");
//	}

	@Override
	public String userLoginDao(String userid, String userpw) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> parameters = new HashMap<>();
		parameters.put("userid", userid);
		parameters.put("userpw", userpw);
		
		return sqlSession.selectOne(nameSpace + ".userLoginDao", parameters);
	}
	
	@Override
	public String adminLoginDao(String adminid, String adminpw) throws Exception {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("adminid", adminid);
		parameters.put("adminpw", adminpw);
		
		return sqlSession.selectOne(nameSpace + ".adminLoginDao", parameters);
	}

	
	@Override
	public int userCheckDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".userCheckDao");
	}

	@Override
	public String userisAliveDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".userisAliveDao").equals(0) ? "fail" : "success";
	}

	@Override
	public int adminCheckDao(String adminid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".adminCheckDao");
	}
//
//	@Override
//	public ArrayList<NUserLoginDto> userInfo(String userid) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String mypageUserinfoCheck(String userid) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void myPageUpdate(NUserLoginDto dto, String id) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int userCartIn(String pcode, String userid) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
