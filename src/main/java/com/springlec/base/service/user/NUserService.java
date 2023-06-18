package com.springlec.base.service.user;

import java.util.List;

import com.springlec.base.model.user.NUserLoginDto;

public interface NUserService {
	// 회원가입
	public boolean userInsert(NUserLoginDto dto) throws Exception;
	// 로그인 시도시 정보 확인, 어드민 로그인 성공 = 1, 유저 로그인 성공 = 2, 로그인 실패 = 0
	public String loginCheck(String userid, String userpw, boolean isadmin) throws Exception;
	//어드민 인지 판별
	public boolean isAdmin(String adminid) throws Exception;
	// 유저 이미 있는지 확인
	public int userCheck(String userid) throws Exception;
	// mypage user 정보
	public String mypageUserinfoCheck(String userid, String userpw) throws Exception;
	// 유저 정보 받아 오기
	public List<NUserLoginDto> userInfo(String userid) throws Exception;
	// 유저 정보 변경 -수정클릭시 작동
	public void myPageUpdate(NUserLoginDto dto) throws Exception;
	// 유저의 구매내역 가져오기
	// public ArrayList<NDUserOrdersDto> mypageUserOrderinfo(String userid) throws Exception;
	// 유저 카트 추가
	// public int userCartIn(String pcode, String userid) throws Exception;
}