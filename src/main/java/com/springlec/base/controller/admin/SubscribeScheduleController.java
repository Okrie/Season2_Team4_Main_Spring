package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.SubscribeScheduleService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SubscribeScheduleController {
	
	@Autowired
	SubscribeScheduleService subscribeService;
	
	@RequestMapping("/adminSchedulesubscribe")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		ArrayList<String> dataSetSubscribe = subscribeService.scheduleSubscribe();
		model.addAttribute("dataSetSubscribe", dataSetSubscribe);
		return "admin_subscribe_schedule";
	}
}
