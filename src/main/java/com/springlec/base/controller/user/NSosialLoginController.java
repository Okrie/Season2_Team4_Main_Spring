package com.springlec.base.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.user.NUserKaKaoService;

@Controller
public class NSosialLoginController {
	
	@Autowired
	NUserKaKaoService service;

	@RequestMapping("/kakaoLogin")
	public String kakaoLogin() throws Exception{
		
		return "oauth/kakao/";
	}
	
	@RequestMapping("/oauth/kakao/")
	public String kakaoToken() throws Exception{
		
		return "";
	}
	
}
