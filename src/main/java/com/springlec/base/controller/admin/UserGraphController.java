package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.UserGraphService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserGraphController {
	
	@Autowired
	UserGraphService userGraphService;
	
	@RequestMapping("/adminGraphusers")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		ArrayList<ArrayList<String>> dataSetGender = userGraphService.searchGender();
		ArrayList<ArrayList<String>> dataSetAge = userGraphService.searchAge();
		ArrayList<ArrayList<String>> dataSetInsert = userGraphService.searchInsertdate();
		model.addAttribute("dataSetGender", dataSetGender);
		model.addAttribute("dataSetAge", dataSetAge);
		model.addAttribute("dataSetInsert", dataSetInsert);
		return "admin_user_graph";
	}
}
