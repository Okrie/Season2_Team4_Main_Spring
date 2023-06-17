package com.springlec.base.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.springlec.base.model.admin.ReviewDto;
import com.springlec.base.service.admin.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	
	
	//	리뷰 찾기
	@RequestMapping("/adminSearchBoard")
	public String list(Model model,HttpSession session) throws Exception {
		session.setAttribute("ID","root1");
		ArrayList<ArrayList<String>> dataSetReview = reviewService.searchReview();
		model.addAttribute("dataSetReview", dataSetReview);

		return "admin_board";
	}
	
	
	//	리뷰 쓰기
	@PostMapping(value = "/adminInsertReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminInsertReview(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID","root1");
		Gson gson = new Gson();
	    ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
	    ReviewDto newseqDto= reviewService.searchReviewseq();
	    int seq = newseqDto.getSeq();
	    int parent = reviewDto.getParent();
	    int layer = reviewDto.getLayer();
	    String pcode = reviewDto.getPcode();
	    String adminid = (String) session.getAttribute("ID");
	    String rrcontext = reviewDto.getRrcontext();
	    
	    reviewService.insertReview(seq, parent, layer, pcode, adminid, rrcontext);
	    return "redirect:list";
	}
	//	리뷰 수정하기
	@PostMapping(value = "/adminModifyReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminModifyReview(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID","root1");
		Gson gson = new Gson();
	    ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
	    int seq = reviewDto.getSeq();
	    reviewService.deleteReview(seq);
	    return "redirect:list";
	}
	
	//	리뷰 지우기
	@PostMapping(value = "/adminDeleteReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminDeleteReview(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID","root1");
		Gson gson = new Gson();
	    ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
	    int seq = reviewDto.getSeq();
	    String rrcontext = reviewDto.getRrcontext();
	    String adminid = (String) session.getAttribute("ID");
	    reviewService.modifyReview(seq, adminid, rrcontext);
	    return "redirect:list";
	}
	

}
