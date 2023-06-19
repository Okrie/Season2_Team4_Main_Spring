package com.springlec.base.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.service.user.NUserKaKaoService;
import com.springlec.base.service.user.NUserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NSosialLoginController {
	
	@Autowired
	NUserKaKaoService service;
	
	@Autowired
	NUserService uservice;
	
	private final String client_id = "ef894ee905a0643b7844daf7341d7569";
	private final String redirect_uri = "http://localhost:8080/oauth/kakao/";
	
	@RequestMapping("/oauth/kakao/")
	public String kakaoToken(HttpServletRequest request) throws Exception{
		String code = request.getParameter("code");
		if(code.isEmpty()) {
			String error = request.getParameter("error");
			String state = request.getParameter("state");
		} else {
			String access_token = service.getToken(code);
			
			try {
				String userEmail = service.getUserInfo(access_token);
				System.out.println(userEmail);
				
				return "kakaoCheck";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "registerPage";
			}
		}
		return "";
	}

	@RequestMapping("/kakaoLogin")
	public String kakaoLogin(HttpServletRequest request) throws Exception{
		return "redirect:https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_uri;
	}
	
	@ResponseBody
	@RequestMapping("/kakaoCheck")
	public int kakaoUserCheck(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		System.out.print("kakao_ id = " + id);
		
		int result = uservice.userCheck(id);
		System.out.println("result = " + result);
		
		return result;
	}
}
