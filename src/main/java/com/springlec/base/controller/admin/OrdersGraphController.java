package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.OrdersGraphService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrdersGraphController {

	@Autowired
	OrdersGraphService orderService;
	
	@RequestMapping("/adminGraphorders")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		ArrayList<ArrayList<String>> dataSetProduct = orderService.searchOrdersProduct();
		ArrayList<ArrayList<String>> dataSetOrders = orderService.searchWeekorders();
		model.addAttribute("dataSetProduct", dataSetProduct);
		model.addAttribute("dataSetOrders", dataSetOrders);
		return "admin_orders_graph";
	}
	
}
