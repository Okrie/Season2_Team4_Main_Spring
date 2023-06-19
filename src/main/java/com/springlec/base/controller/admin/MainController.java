package com.springlec.base.controller.admin;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.admin.OrdersDto;
import com.springlec.base.model.admin.SubscribeDto;
import com.springlec.base.service.admin.MainService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	MainService mainservice;


	@RequestMapping("/adminLogin")
	public String login(Model model, HttpSession session) throws Exception {

		return "redirect:adminMain";
	}

	@RequestMapping("/adminMain")
	public String list(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		OrdersDto searchmonthSales = mainservice.searchmonthSales();
		OrdersDto searchordersHowmany = mainservice.searchordersHowmany();
		OrdersDto searchyearSalessolo = mainservice.searchyearSalessolo();
		OrdersDto searchtodo = mainservice.searchtodo();
		SubscribeDto searchsubscribeSalessolo = mainservice.searchsubscribeSalessolo();

		String monthSales = formatter
				.format(searchmonthSales.getMonthSales()+(searchsubscribeSalessolo.getSubscribeSales()* 140000));
		// 매출액(연간) 가져오기
		String yearSales = formatter.format(searchyearSalessolo.getYearSales() + (searchsubscribeSalessolo.getSubscribeSales() * 140000));
		// 남은 주문 처리 비율 가져오기
		int count = searchordersHowmany.getCount();
		int toDo = searchtodo.getTodo();
		String percenttodo = formatter.format((100 - ((double) toDo / count) * 100));
		// 이번달 구독갯수
		String subscribeSales = formatter.format(searchsubscribeSalessolo.getSubscribeSales());

		// 매출액그래프 가져오기
		ArrayList<ArrayList<String>> dataSales = mainservice.searchyearsales();


		// SetParam
		request.setAttribute("monthSales", monthSales);
		request.setAttribute("yearSales", yearSales);
		request.setAttribute("percenttodo", percenttodo);
		request.setAttribute("subscribeSales", subscribeSales);
		request.setAttribute("ordersSales", Integer.toString(count));
		request.setAttribute("dataSales", dataSales);
		return "admin_main";
	}
	
	@RequestMapping("/adminLogout")
	public String logout(Model model, HttpSession session) throws Exception {
		session.invalidate();
		return "index";
	}
}
