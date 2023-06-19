package com.springlec.base.service.user;

import java.util.Map;

public interface NUserKaKaoService {
	// 인가 코드 받기
	public String getToken(String code) throws Exception;
	// 유저 정보 받기
	public String getUserInfo(String access_token) throws Exception;
	// 동의 정보 받기
	public String getAgreementInfo(String access_token) throws Exception;
}
