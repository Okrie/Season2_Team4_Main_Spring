package com.springlec.base.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.service.user.NUserService;

@Controller
public class NUserController {

	@Autowired
	NUserService service;
	
	@RequestMapping("/login")
	public String userView() throws Exception {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(@RequestParam("userid") String userid, @RequestParam("userpw") String userpw) throws Exception {
		
		return "";
	}
}
