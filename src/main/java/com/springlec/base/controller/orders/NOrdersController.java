package com.springlec.base.controller.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.orders.NOrdersDto;
import com.springlec.base.service.orders.NOrdersService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NOrdersController {

	@Autowired
	NOrdersService nOrdersService;
	
	// 결제 前 물건 정보랑 구매자 정보
	@RequestMapping("/orders")
	public String ordersInfoDao(HttpServletRequest request,Model model) throws Exception{
		NOrdersDto productInfoDao =  nOrdersService.productInfoDao(request.getParameter("pcode"));
		NOrdersDto userInfoDao = nOrdersService.userInfoDao(request.getParameter("userid"));
		model.addAttribute("orders",productInfoDao);
		model.addAttribute("orders",userInfoDao);
		return "orders";
	}
	
	// 결제
	@RequestMapping("/insertorders")
	public String insertOrdersDao(HttpServletRequest request, Model model) throws Exception{
		nOrdersService.insertOrdersDao(request.getParameter("userid"), request.getParameter("pcoude"), request.getParameter("count"), request.getParameter("address"));
		return "insertorders";
	}
	
	// 결제후 정보 보기
	@RequestMapping("/ordersFinish")
	public String cartOrdersDao(HttpServletRequest request, Model model) throws Exception{
		
		List<NOrdersDto> cartOrdersDao = nOrdersService.cartOrdersDao(request.getParameter("pcode"));
		model.addAttribute("ordersFinish",cartOrdersDao);
		return "ordersFinish";
	}
	
	
}
