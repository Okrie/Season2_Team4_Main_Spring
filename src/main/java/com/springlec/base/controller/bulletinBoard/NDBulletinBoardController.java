package com.springlec.base.controller.bulletinBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.bulletinBoard.NDNoticeBoardDto;
import com.springlec.base.service.bulletinBoard.NDNoticeDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class NDBulletinBoardController {

	HttpSession session;
	
	@Autowired
	NDNoticeDaoService noticeDaoService;
	
	
	
	//NDNoticeBoard관련
	@RequestMapping("/shop-notice")
	public String NDNoticeBoardDao(HttpServletRequest request, Model model) throws Exception{
		List<NDNoticeBoardDto> NDNoticeBoardDao = noticeDaoService.NDNoticeBoardDao();
		model.addAttribute("SIZE", NDNoticeBoardDao.size());
		model.addAttribute("NDNotice", NDNoticeBoardDao);
		return "shopnotice";
	}
}
