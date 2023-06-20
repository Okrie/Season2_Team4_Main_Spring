package com.springlec.base.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.cart.NCartDto;
import com.springlec.base.service.cart.NCartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NCartController {
	
	HttpSession session;

	@Autowired
	NCartService nCartService;
	
	@RequestMapping("/cart")
	public String cartlist(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
	    List<NCartDto> NcartListDao = nCartService.NcartListDao((String)session.getAttribute("ID")); 
	    model.addAttribute("cart", NcartListDao);
	    return "shoping-cart";
	}
	
	

	
	@RequestMapping("/cartdelete")
	public String cartdelete(HttpServletRequest request, Model model)throws Exception{
		int seq = Integer.parseInt(request.getParameter("seq"));
		nCartService.cartDeleteDao(seq);
		return "redirect:cart";
	}
	
}
