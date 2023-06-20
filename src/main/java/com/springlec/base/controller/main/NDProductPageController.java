package com.springlec.base.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.main.NDProductListService;
import com.springlec.base.service.user.NUserOrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NDProductPageController {
	
	@Autowired
	NDProductListService service;

	@RequestMapping("/productInformSend")
	public String productInform(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		service.productListDao(request.getParameter("pcode"));
		
		session.setAttribute("list", request);
		return "redirect:board";
	}
}
