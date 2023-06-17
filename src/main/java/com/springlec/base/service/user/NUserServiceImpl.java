package com.springlec.base.service.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.user.NUserDao;

@Service
public class NUserServiceImpl implements NUserService{

	@Autowired
	NUserDao dao;
	
//	@Override
//	public int userInsert(NUserLoginDto dto) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public String loginCheck(String userid, String userpw, boolean isadmin) throws Exception {
		// TODO Auto-generated method stub
		String result = "";
		try {
			if(isadmin) {
				result = dao.adminLoginDao(userid, userpw);
				if(result != null && !result.equals("0")) {
					result = "admin";
				}
			} else {
				result = dao.userisAliveDao(userid);
				if(result.equals("1")) {
					if(!dao.userLoginDao(userid, userpw).equals("0")) {
						result = "user";
					} else {
						result = "fail";
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}
		return result;
	}

	@Override
	public boolean isAdmin(String adminid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(dao.adminCheckDao(adminid));
		if(dao.adminCheckDao(adminid) == 1) {
			return true;
		}
		return false;
	}
//
//	@Override
//	public boolean userCheck(String userid) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}
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
