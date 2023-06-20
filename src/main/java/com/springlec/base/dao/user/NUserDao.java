package com.springlec.base.dao.user;

import java.util.List;

import com.springlec.base.model.user.NUserLoginDto;

public interface NUserDao {
	// 회원가입
	public int userRegisterDao(NUserLoginDto dto) throws Exception;
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
	public List<NUserLoginDto> userInfoDao(String userid) throws Exception;
	// mypage user 정보
	public int userMypageCheckDao(String userid, String userpw) throws Exception;
	// 유저 정보 변경 -수정클릭시 작동
	public int userMypageUpdateDao(NUserLoginDto dto) throws Exception;
}
