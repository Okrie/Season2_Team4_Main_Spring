package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.UserListService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserListController {
	
	
	@Autowired
	UserListService userListService;
	
	@RequestMapping("/adminSearchusers")
	public String searchUpdate(HttpServletRequest request, Model model) throws Exception {
		ArrayList<ArrayList<String>> dataSetUser = userListService.searchUser();
		model.addAttribute("dataSetUser", dataSetUser);
		return "admin_user";
	}
}
