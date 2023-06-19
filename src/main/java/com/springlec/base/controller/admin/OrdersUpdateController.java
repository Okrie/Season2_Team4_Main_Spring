package com.springlec.base.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.OrdersUpdateService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrdersUpdateController {
	
	@Autowired
	OrdersUpdateService orderService;



	@RequestMapping("/adminUpdateOrdersRefund")
	public String adminUpdateOrdersRefund(HttpServletRequest request, Model model) throws Exception {
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		orderService.refundupdate(ordercode);
		return "redirect:adminSearchorders";
	}
	
	@RequestMapping("/adminUpdateOrdersDelivery")
	public String adminUpdateOrdersDelivery(HttpServletRequest request, Model model) throws Exception {
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		orderService.deliveryupdate(ordercode);
		return "redirect:adminSearchorders";
	}
	
	
}
