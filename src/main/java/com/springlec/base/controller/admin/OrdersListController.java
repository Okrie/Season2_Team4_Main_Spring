package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.admin.OrdersDto;
import com.springlec.base.service.admin.OrdersListService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrdersListController {
	
	@Autowired
	OrdersListService orderService;



	@RequestMapping("/adminSearchorders")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		ArrayList<ArrayList<String>> dataSetOrders = orderService.searchOrders();
		model.addAttribute("dataSetOrders", dataSetOrders);
		return "admin_orders";
	}
	
	@RequestMapping("/adminUpdateorders")
	public String searchUpdate(HttpServletRequest request, Model model) throws Exception {
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		ArrayList<OrdersDto> dtoOrders = orderService.searchupdate(ordercode);
		String Refunddate = orderService.searchUpdateRefunddate(ordercode);
		String Deliverydate = orderService.searchUpdateDeliverydate(ordercode);
		int Stock = orderService.searchUpdateStock(ordercode);
		
		model.addAttribute("dtoOrders", dtoOrders);
		model.addAttribute("Refunddate", Refunddate);
		model.addAttribute("Deliverydate", Deliverydate);
		model.addAttribute("Stock", Stock);
		return "admin_orders_update";
	}
}
