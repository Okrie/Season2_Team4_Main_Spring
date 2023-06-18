package com.springlec.base.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.user.NUserLoginDto;
import com.springlec.base.service.user.NUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NUserController {

	@Autowired
	NUserService service;
	
	@RequestMapping("/login")
	public String userView() throws Exception {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request, Model model) throws Exception {
		 
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		// 로그인 시도시 어드민인지, 유저인지, 없는 유저인지 확인
		HttpSession session = request.getSession();
		String result;
		
		if(service.isAdmin(userid)) {
			// 어드민이라면 어드민 로그인 체크로 보냄
			System.out.println("Admin Login");
			result = service.loginCheck(userid, userpw, true);
		}else {
			// 유저라면 유저 로그인 체크로 보냄
			System.out.println("User Login");
			result = service.loginCheck(userid, userpw, false);
		}
		// 없는 유저, 없는 어드민이라면 login 세션에 fail로 올림
		session.setAttribute("login", result);
		// 성공시 login = success , ID 세션에 값 올리고 해당 페이지로 보냄
		session.setAttribute("ID", userid);
		
		return "login";
	}
	
	// Register Page
	@RequestMapping("/registerPage")
	public String registerView() throws Exception{
		return "register";
	}
	
	// Register
	@RequestMapping("/register")
	public String userRegister(NUserLoginDto dto, Model model) throws Exception{
		boolean result = service.userInsert(dto);
		if(result) {
			return "redirect:login";
		} else {
			return "register";
		}
	}
	
	// Duplicate
	@ResponseBody
	@RequestMapping("/register/duplicate")
	public int duplicateCheck(@RequestParam("userid") String userid) throws Exception{
		return service.userCheck(userid);
	}
}
