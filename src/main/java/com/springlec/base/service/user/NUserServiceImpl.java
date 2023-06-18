package com.springlec.base.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.user.NUserDao;
import com.springlec.base.model.user.NUserLoginDto;

@Service
public class NUserServiceImpl implements NUserService{

	@Autowired
	NUserDao dao;
	
	@Override
	public boolean userInsert(NUserLoginDto dto) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.userRegisterDao(dto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

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
		if(dao.adminCheckDao(adminid) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public int userCheck(String userid) throws Exception {
		// TODO Auto-generated method stub
		try {
			if(dao.userCheckDao(userid) > 0) {
				return 1;
			}else {
				return 0;
			}
		}catch (Exception e) {
			return -1;
		}
	}

	@Override
	public String mypageUserinfoCheck(String userid, String userpw) throws Exception {
		// TODO Auto-generated method stub
		return dao.userMypageCheckDao(userid, userpw) > 0 ? "1" : "0";
	}
	
	@Override
	public List<NUserLoginDto> userInfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userInfoDao(userid);
	}

	@Override
	public void myPageUpdate(NUserLoginDto dto) throws Exception {
		// TODO Auto-generated method stub
		dao.userMypageUpdateDao(dto);
	}

//	@Override
//	public int userCartIn(String pcode, String userid) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
