package com.springlec.base.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.user.NUserWishlistDto;
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
		int count;
		
		try {
			userid = (String) session.getAttribute("ID");
		}catch (Exception e) {
			// TODO: handle exception
			result = 1;
		}
		
		try {
			count = Integer.parseInt(request.getParameter("count"));
		} catch (Exception e) {
			// TODO: handle exception
			count = 1;
		}
		
		try {
			service.userCartIn(request.getParameter("pcode"), userid, count);
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
	
	@RequestMapping("/userwishlist")
	public String wishlistView(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("ID");
		List<NUserWishlistDto> list = service.userWishList(userid);
		model.addAttribute("USERWISHLIST", list);
		return "userWishlistinfo";
	}
	
	@ResponseBody
	@RequestMapping("/wishlistdelete")
	public int wishlistdelete(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String pcode = request.getParameter("pcode");
		System.out.println(pcode);
		int result;
		String userid = (String) session.getAttribute("ID");
		
		try {
			service.userWishlistDelete(pcode, userid);
			result = 0;
		} catch (Exception e) {
			// TODO: handle exception
			result = 1;
		}
		
		return result;
	}
}
