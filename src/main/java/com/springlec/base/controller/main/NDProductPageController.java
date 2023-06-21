package com.springlec.base.controller.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.user.NUserOrderDto;
import com.springlec.base.model.user.NUserReviewDto;
import com.springlec.base.service.main.NDProductListService;
import com.springlec.base.service.user.NUserReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NDProductPageController {
	
	@Autowired
	NDProductListService service;
	
	@Autowired
	NUserReviewService reviewService;

	@RequestMapping("/productInformSend")
	public String productInform(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		NUserOrderDto list = service.productListDao(request.getParameter("pcode"));
		// 이 아래 두개를 합쳐서 정렬 한다면?
		List<NUserReviewDto> rlist = reviewService.reviewList(request.getParameter("pcode"));
		List<NUserReviewDto> alist = reviewService.reviewAdminList(request.getParameter("pcode"));
		List<NUserReviewDto> mergedList = new ArrayList<>();
		mergedList.addAll(rlist);
		mergedList.addAll(alist);
		
		Collections.sort(mergedList, Comparator.comparing(NUserReviewDto::getSeq));
		
		session.setAttribute("list", list);
		session.setAttribute("RList", mergedList);
		//session.setAttribute("AList", alist);
		return "shop-board";
	}
}
