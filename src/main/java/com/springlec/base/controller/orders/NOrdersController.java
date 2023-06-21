package com.springlec.base.controller.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.orders.NOrdersDto;
import com.springlec.base.service.orders.NOrdersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NOrdersController {
	HttpSession session;

	

	@Autowired
	NOrdersService nOrdersService;
	
	// 결제 前 물건 정보랑 구매자 정보
	@RequestMapping("/orders")
	public String ordersInfoDao(HttpServletRequest request, Model model) throws Exception{
		session = request.getSession();
		String[] pcode = request.getParameterValues("pcode");
		ArrayList<NOrdersDto> dto = new ArrayList<>();
		for(String temp: pcode) {
			NOrdersDto productInfoDao = nOrdersService.productInfoDao(temp);
			dto.add(productInfoDao);
		}
		List<NOrdersDto> userInfoDao = nOrdersService.userInfoDao((String) session.getAttribute("ID"));
		model.addAttribute("orders", dto);
		model.addAttribute("user", userInfoDao);
		model.addAttribute("count", request.getParameter("count"));
		return "orders";
	}
	
	// 결제
	@RequestMapping("/insertorders")
	public String insertOrdersDao(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
	    String userid = (String) session.getAttribute("ID");
	    String pcode = request.getParameter("pcode");
	    String count = request.getParameter("count");
	    String address = request.getParameter("address");


	    nOrdersService.insertOrdersDao(userid, pcode, count, address);

	    model.addAttribute("userid", userid);
	    model.addAttribute("pcode", pcode);
	    model.addAttribute("count", count);
	    model.addAttribute("address", address);

	    return "ordersFinish";
	}

	@RequestMapping("/ordersFinish")
	public String cartOrdersDao(HttpServletRequest request, Model model) throws Exception{
		List<NOrdersDto> cartOrdersDao = nOrdersService.cartOrdersDao(request.getParameter("pcode"));
		model.addAttribute("cartOrders",cartOrdersDao);
		return "redirect:ordersFinish";
	}



	
	
	
}
