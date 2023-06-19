package com.springlec.base.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.SubscribeUpdateService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SubscribeUpdateController {
	
	@Autowired
	SubscribeUpdateService subscribeService;
	
	@RequestMapping("/adminUpdateSubscribe")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		int plcode = Integer.parseInt(request.getParameter("plcode"));
		subscribeService.updateSubscribe(plcode);
		return "redirect:adminSchedulesubscribe";
	}
	
	
}
