package com.springlec.base.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.user.NUserLoginDto;
import com.springlec.base.service.user.NUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NUserMypageController {

	@Autowired
	NUserService service;
	
	
	// User Mypage
	@RequestMapping("/mypage")
	public String mypageView() throws Exception{
		
		return "mypage";
	}
	
	// UserInfo Detail
	@RequestMapping("/mypageDetail")
	public String mypageDetail(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		List<NUserLoginDto> dto = service.userInfo((String) session.getAttribute("ID"));
		model.addAttribute("userinfo", dto);
		return "mypageDetail";
	}
	
	// mypage update
	@RequestMapping("/userinfoupdate")
	public String mypageUpdate(NUserLoginDto dto) throws Exception{
		service.myPageUpdate(dto);
		return "mypage";
	}
}
