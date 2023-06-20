package com.springlec.base.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.service.user.NUserBucketService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NUserBucketController {

	@Autowired
	NUserBucketService service;
	
	@ResponseBody
	@RequestMapping("/NDCartInsert")
	public int cartIn(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int result;
		String userid = "";
		
		try {
			userid = (String) session.getAttribute("ID");
		}catch (Exception e) {
			// TODO: handle exception
			result = 1;
		}
		
		try {
			service.userCartIn(request.getParameter("pcode"), userid);
			result = 0;
		} catch (Exception e) {
			// TODO: handle exception
			result = 2;
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/wishlist")
	public int wishlistIn(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int result;
		String userid = "";
		
		try {
			userid = (String) session.getAttribute("ID");
		}catch (Exception e) {
			// TODO: handle exception
			result = 1;
		}
		
		try {
			service.userWishlistIn(request.getParameter("pcode"), userid);
			result = 0;
		} catch (Exception e) {
			// TODO: handle exception
			result = 2;
		}
		
		return result;
	}
}
