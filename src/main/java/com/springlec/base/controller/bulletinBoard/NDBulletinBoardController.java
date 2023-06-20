package com.springlec.base.controller.bulletinBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.service.bulletinBoard.NDNoticeDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NDBulletinBoardController {

	HttpSession session;
	
	@Autowired
	NDNoticeDaoService noticeDaoService;
	
	
	
	//NDNoticeBoard관련
	@RequestMapping("/NDNotice")
	public String NDNoticeBoardDao(HttpServletRequest request,@RequestParam("pcode") String pcode, Model model) throws Exception{
		String NDNoticeBoardDao = noticeDaoService.NDNoticeBoardDao(pcode);
		model.addAttribute("Notice", NDNoticeBoardDao);
		return "shop-board";
		
		
	}
}
