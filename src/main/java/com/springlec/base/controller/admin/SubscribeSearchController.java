package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.SubscribeSearchService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SubscribeSearchController {
	
	@Autowired
	SubscribeSearchService subscribeService;
	
	@RequestMapping("/adminSearchsubscribe")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		ArrayList<ArrayList<String>> dataSetSubscribe = subscribeService.searchSubscribe();
		model.addAttribute("dataSetSubscribe", dataSetSubscribe);
		return "admin_subscribe";
	}

}
