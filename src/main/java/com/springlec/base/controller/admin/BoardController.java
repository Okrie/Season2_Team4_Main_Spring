package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.springlec.base.model.admin.BoardDto;
import com.springlec.base.model.admin.ReviewDto;
import com.springlec.base.service.admin.BoardService;
import com.springlec.base.service.admin.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	BoardService boardService;
	
	// board_table.js 초기화
	@RequestMapping("/adminSearchBoard")
	public String list(Model model, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		ArrayList<ArrayList<String>> dataSetReview = reviewService.searchReview();
		ArrayList<ArrayList<String>> dataSetBoard = boardService.searchBoard();
		model.addAttribute("dataSetReview", dataSetReview);
		model.addAttribute("dataSetBoard", dataSetBoard);

		return "admin_board";
	}

	//	Board
	
	// 쓰기
	@PostMapping(value = "/adminInsertBoard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminInsertBoard(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		Gson gson = new Gson();
		BoardDto boardDto = gson.fromJson(json, BoardDto.class);
		BoardDto newseqDto = boardService.searchBoardseq();
		int seq = newseqDto.getSeq();
		int parent = boardDto.getParent();
		int layer = boardDto.getLayer();
		String pcode = boardDto.getPcode();
		String title = boardDto.getBrtitle();
		String adminid = (String) session.getAttribute("ID");
		String brcontext = boardDto.getBrcontext();

		boardService.insertBoard(seq, parent, layer, pcode, adminid, title, brcontext);
		return "redirect:admin_board";
	}

	// 수정하기
	@PostMapping(value = "/adminModifyBoard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminModifyBoard(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		Gson gson = new Gson();
		BoardDto boardDto = gson.fromJson(json, BoardDto.class);
		int seq = boardDto.getSeq();
		boardService.deleteBoard(seq);
		return "redirect:admin_board";
	}

	// 지우기
	@PostMapping(value = "/adminDeleteBoard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminDeleteBoard(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		Gson gson = new Gson();
		BoardDto boardDto = gson.fromJson(json, BoardDto.class);
		int seq = boardDto.getSeq();
		String title = boardDto.getBrtitle();
		String brcontext = boardDto.getBrcontext();
		String adminid = (String) session.getAttribute("ID");
		boardService.modifyBoard(seq, adminid,title, brcontext);
		return "redirect:admin_board";
	}
	
	
	
	
	
	//	Review

	// 쓰기
	@PostMapping(value = "/adminInsertReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminInsertReview(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		Gson gson = new Gson();
		ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
		ReviewDto newseqDto = reviewService.searchReviewseq();
		int seq = newseqDto.getSeq();
		int parent = reviewDto.getParent();
		int layer = reviewDto.getLayer();
		String pcode = reviewDto.getPcode();
		String adminid = (String) session.getAttribute("ID");
		String rrcontext = reviewDto.getRrcontext();

		reviewService.insertReview(seq, parent, layer, pcode, adminid, rrcontext);
		return "redirect:admin_board";
	}

	// 수정하기
	@PostMapping(value = "/adminModifyReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminModifyReview(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		Gson gson = new Gson();
		ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
		int seq = reviewDto.getSeq();
		reviewService.deleteReview(seq);
		return "redirect:admin_board";
	}

	// 지우기
	@PostMapping(value = "/adminDeleteReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminDeleteReview(@RequestBody String json, HttpSession session) throws Exception {
		session.setAttribute("ID", "root1");
		Gson gson = new Gson();
		ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
		int seq = reviewDto.getSeq();
		String rrcontext = reviewDto.getRrcontext();
		String adminid = (String) session.getAttribute("ID");
		reviewService.modifyReview(seq, adminid, rrcontext);
		return "redirect:admin_board";
	}

}
