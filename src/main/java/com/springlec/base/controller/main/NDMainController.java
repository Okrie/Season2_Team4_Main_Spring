package com.springlec.base.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springlec.base.model.main.NDProductListDto;
import com.springlec.base.model.main.NDSortProductDto;
import com.springlec.base.service.main.NDHeaderCountDaoService;
import com.springlec.base.service.main.NDMainDaoService;
import com.springlec.base.service.main.NDSearchQueryDaoService;
import com.springlec.base.service.main.NDSortProductDaoService;

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
	
	@Autowired
	NDSortProductDaoService sortProductDaoService;
	
	
	//제품 전부 출력
	@RequestMapping("/NDTakeAll")
	public String NDTakeAll(HttpServletRequest request, Model model) throws Exception{
		List<NDProductListDto> NDTakeAll = mainDaoService.NDTakeAll();
		session = request.getSession();
		
		session.setAttribute("NDTakeAll", NDTakeAll);
		return "redirect:NDHeaderCount";
	}
	
	/*
	 * HeaderCount 영역
	 * userid를 가져와서 heartCount, cartCount, cartTotalPrice의 역할을 한다.
	 */
	@RequestMapping("/NDHeaderCount")
	public String headerCount(HttpServletRequest request, Model model) throws Exception{
		session = request.getSession();
		String userid = (String) session.getAttribute("ID");
		
		int heartCount = 0;
		int cartCount = 0;
		String cartTotalPrice = "";
		String remainDate = "";
		
		if(userid != null) {

			heartCount = headerCountDaoService.heartCountDao(userid);
			cartCount = headerCountDaoService.cartCountDao(userid);
			try {
				cartTotalPrice = headerCountDaoService.cartTotalPriceDao(userid);
			} catch (Exception e) {
				cartTotalPrice = Integer.toString(0);
			}
			
			try {
				remainDate = headerCountDaoService.remainDateDao(userid);
			}catch (Exception e) {
				remainDate = null;
			}
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
	public String list(HttpServletRequest request,@RequestParam("name") String name, Model model) throws Exception{
		List<NDProductListDto> NDSearchQuery = searchQueryDaoService.NDSearchQuery(name);
		model.addAttribute("searchAction", NDSearchQuery);
		return "productList";
		
	}
	
	//ProductList로 연결만 시켜줌
	@RequestMapping("/productList")
	public String productList() throws Exception {
		return "productList";
	}
	
	//shop-notice로 연결만 시켜줌
	@RequestMapping("/shopnotice")
	public String shopnotice() throws Exception{
		return "shopnotice";
		
	}

			
	
	
	//정렬목록 중 모든제품 출력
	@RequestMapping("/NDSortProductListAll")
	public String NDSortProductListAll(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductListAll = sortProductDaoService.NDSortProductListAll();
		model.addAttribute("NDSortProductList", NDSortProductListAll);
		return "productList";
	}
	//정렬목록 중 칼로리별 적은순 제품 출력
	@RequestMapping("/NDSortProductListCal")
	public String NDSortProductListCal(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductListCal = sortProductDaoService.NDSortProductListCal();
		model.addAttribute("NDSortProductList", NDSortProductListCal);
		return "productList";
	}
	//정렬목록 중 가격높은순 제품 출력
	@RequestMapping("/NDSortProductListHighPrice")
	public String NDSortProductListHighPrice(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductListHighPrice = sortProductDaoService.NDSortProductListHighPrice();
		model.addAttribute("NDSortProductList", NDSortProductListHighPrice);
		return "productList";
	}
	//정렬목록 중 가격낮은순 제품 출력
	@RequestMapping("/NDSortProductListLowPrice")
	public String NDSortProductListLowPrice(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductListLowPrice = sortProductDaoService.NDSortProductListLowPrice();
		model.addAttribute("NDSortProductList", NDSortProductListLowPrice);
		return "productList";
	}
	
	
	
	//정렬목록 중 400kcal이하 제품만 출력
	@RequestMapping("/NDSortProductListDiet")
	public String NDSortProductListDiet(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductListDiet = sortProductDaoService.NDSortProductListDiet();
		model.addAttribute("NDSortProductList", NDSortProductListDiet);
		return "productList";
	}
	
	//정렬목록중 7000이하인 제품만 출력
	@RequestMapping("/NDSortProductList7000")
	public String NDSortProductList7000(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductList7000 = sortProductDaoService.NDSortProductList7000();
		model.addAttribute("NDSortProductList", NDSortProductList7000);
		return "productList";
	}

	//정렬목록중 많이 팔린 기준 top10만 출력
	@RequestMapping("/NDSortProductListTop10")
	public String NDSortProductListTop10(Model model) throws Exception{
		List<NDSortProductDto> NDSortProductListTop10 = sortProductDaoService.NDSortProductListTop10();
		model.addAttribute("NDSortProductList", NDSortProductListTop10);
		return "productList";
	}
	
	
	
}
