package com.springlec.base.controller.main;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.dao.main.NDHeaderCountDao;
import com.springlec.base.model.main.NDProductListDto;
import com.springlec.base.service.main.NDHeaderCountDaoService;
import com.springlec.base.service.main.NDMainDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NDMainController {
	
	HttpSession session;
	
	@Autowired
	NDMainDaoService mainDaoService;
	
	@Autowired
	NDHeaderCountDaoService headerCountDaoService;
	
	//제품 전부 출력
	@RequestMapping("/NDTakeAll")
	public String NDTakeAll(Model model) throws Exception{
		
		List<NDProductListDto> NDTakeAll = mainDaoService.NDTakeAll();
		
		model.addAttribute("NDTakeAll", NDTakeAll);
		
		return "NDTakeAll";
	}
	
	/*
	 * HeaderCount 영역
	 * userid를 가져와서 heartCount, cartCount, cartTotalPrice의 역할을 한다.
	 */
	@RequestMapping("/NDHeaderCount")
	public String heartCount(HttpServletRequest request, Model model) throws Exception{
		session.getAttribute("userid");
		
		int heartCount = headerCountDaoService.heartCountDao("userid");
		int cartCount = headerCountDaoService.cartCountDao("userid");
		int cartTotalPrice = headerCountDaoService.cartTotalPriceDao("userid");
		String remainDate = headerCountDaoService.remainDateDao("userid");
		
		model.addAttribute("heartCount", heartCount);
		model.addAttribute("cartCount", cartCount);
		model.addAttribute("cartTotalPrice", cartTotalPrice);
		model.addAttribute("remainDate", remainDate);
		
		session.setAttribute("heartCount", heartCount);
		session.setAttribute("heartCount", cartCount);
		session.setAttribute("cartTotalPrice", cartTotalPrice);
		session.setAttribute("remainDate", remainDate);
		

		
		return "redirect:header";
		
		
	}//headerCountEnd
	
	
	
	
	

}
