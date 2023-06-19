package com.springlec.base.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.ProductUpdateService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductUpdateController {

	@Autowired
	ProductUpdateService productService;
	
	@RequestMapping("/adminUpdateProduct")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		int invalidate = Integer.parseInt(request.getParameter("invalidate"));
		String pcode = request.getParameter("pcode");
		productService.updateproduct(invalidate, pcode);
		return "redirect:adminSearchProduct";
	}
}
