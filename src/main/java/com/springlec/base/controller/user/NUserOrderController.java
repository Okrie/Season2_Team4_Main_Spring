package com.springlec.base.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springlec.base.model.user.NUserOrderDto;
import com.springlec.base.service.admin.OrdersUpdateService;
import com.springlec.base.service.user.NUserOrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NUserOrderController {
	
	@Autowired
	NUserOrderService service;
	
	@Autowired
	OrdersUpdateService service2;
	
	// mypage userorderinfo
	@RequestMapping("/userorderinfo")
	public String userOrderinfo(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("ID");
		
		List<NUserOrderDto> dtos = service.mypageUserOrderinfo(userid); 
		session.setAttribute("USERORDERLIST", dtos);

		return "userPurchaseinfo";
	}
	
	@ResponseBody
	@RequestMapping("/NDRefund")
	public int ndRefund(HttpServletRequest request) throws Exception{
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		
		int result;
		try {
			service2.refundupdate(ordercode);
			result = 0;
		} catch (Exception e) {
			result = 1;
		}
		return result;
	}
}
