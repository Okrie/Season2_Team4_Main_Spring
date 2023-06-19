package com.springlec.base.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.main.NDProductListDto;
import com.springlec.base.model.main.NDSearchQueryDto;
import com.springlec.base.service.main.NDHeaderCountDaoService;
import com.springlec.base.service.main.NDMainDaoService;
import com.springlec.base.service.main.NDSearchQueryDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NDMainController {
	
	HttpSession session;
	
	@Autowired
	NDMainDaoService mainDaoService;
	
	@Autowired
	NDHeaderCountDaoService headerCountDaoService;
	
	@Autowired
	NDSearchQueryDaoService searchQueryDaoService;
	
	//제품 전부 출력
	@RequestMapping("/NDTakeAll")
	public String NDTakeAll(HttpServletRequest request, Model model) throws Exception{
		List<NDProductListDto> NDTakeAll = mainDaoService.NDTakeAll();
		session = request.getSession();
		
		session.setAttribute("TakeAll", NDTakeAll);
		return "redirect:NDHeaderCount";
	}
	
	/*
	 * HeaderCount 영역
	 * userid를 가져와서 heartCount, cartCount, cartTotalPrice의 역할을 한다.
	 */
	@RequestMapping("/NDHeaderCount")
	public String heartCount(HttpServletRequest request, Model model) throws Exception{
		session = request.getSession();
		String userid = (String) session.getAttribute("ID");
		
		int heartCount = 0;
		int cartCount = 0;
		int cartTotalPrice = 0;
		String remainDate = "";
		
		if(userid != null) {

			heartCount = headerCountDaoService.heartCountDao(userid);
			cartCount = headerCountDaoService.cartCountDao(userid);
			cartTotalPrice = headerCountDaoService.cartTotalPriceDao(userid);
			
			remainDate = headerCountDaoService.remainDateDao(userid);
		}
		
		model.addAttribute("heartCount", heartCount);
		model.addAttribute("cartCount", cartCount);
		model.addAttribute("cartTotalPrice", cartTotalPrice);
		model.addAttribute("remainDate", remainDate);
		
		session.setAttribute("heartCount", heartCount);
		session.setAttribute("cartCount", cartCount);
		session.setAttribute("cartTotalPrice", cartTotalPrice);
		session.setAttribute("remainDate", remainDate);
		

		
		return "redirect:/index";
		
		
	}//headerCountEnd

	//NDSearchQuery영역
	@RequestMapping("/NDSearchQuery")
	public String list(HttpServletRequest request, Model model) throws Exception{
		List<NDSearchQueryDto> NDSearchQuery = searchQueryDaoService.NDSearchQuery();
		model.addAttribute("NDSearchQuery", NDSearchQuery);
		return "redirect:NDHeaderCount";
		
	}
	

}
