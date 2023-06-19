package com.springlec.base.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.cart.NCartDto;
import com.springlec.base.service.cart.NCartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NCartController {

	@Autowired
	NCartService nCartService;
	
	@RequestMapping("/shoping-cart")
	public String cartlist(HttpServletRequest request, Model model) throws Exception {
	    List<NCartDto> NcartListDao = nCartService.NcartListDao(); 
	    model.addAttribute("shoping-cart", NcartListDao);
	    return "redirect:shoping-cart";
	}
	
/*
	
	@RequestMapping("/cartdelete")
	public String cartdelete(HttpServletRequest request, Model model)throws Exception{
		int seq = Integer.parseInt(request.getParameter("seq"));
		nCartService.cartDeleteDao(seq);
		return "redirect:shoping-cart";
	}
	*/
}
