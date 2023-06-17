package com.springlec.base.dao.user;

import java.util.ArrayList;

import com.springlec.base.model.user.NUserLoginDto;

public interface NUserDao {
	// 회원가입
	// public int userInsert(NUserLoginDto dto) throws Exception;
	// 로그인 시도시 정보 확인, 어드민 로그인 성공 = 1, 유저 로그인 성공 = 2, 로그인 실패 = 0
	// 유저 로그인
	public String userLoginDao(String userid, String userpw) throws Exception;
	// 유저 살아 있음?
	public String userisAliveDao(String userid) throws Exception;
	// 어드민 로그인
	public String adminLoginDao(String adminid, String adminpw) throws Exception;
	// 어드민 인지 판별
	public int adminCheckDao(String adminid) throws Exception;
	// 유저 이미 있는지 확인
	public int userCheckDao(String userid) throws Exception;
	// 유저 정보 받아 오기
	// public ArrayList<NUserLoginDto> userInfo(String userid) throws Exception;
	// mypage user 정보
	// public String mypageUserinfoCheck(String userid) throws Exception;
	// 유저 정보 변경 -수정클릭시 작동
	// public void myPageUpdate(NUserLoginDto dto, String id) throws Exception;
	// 유저의 구매내역 가져오기
	// public ArrayList<NDUserOrdersDto> mypageUserOrderinfo(String userid) throws Exception;
	// 유저 카트 추가
	// public int userCartIn(String pcode, String userid) throws Exception;
}
