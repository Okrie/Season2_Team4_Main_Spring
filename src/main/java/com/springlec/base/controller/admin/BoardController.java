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
import com.springlec.base.model.admin.NoticeDto;
import com.springlec.base.model.admin.ReviewDto;
import com.springlec.base.service.admin.BoardService;
import com.springlec.base.service.admin.NoticeService;
import com.springlec.base.service.admin.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	BoardService boardService;

	@Autowired
	NoticeService noticeService;
	
	// board_table.js 초기화
	@RequestMapping("/adminSearchBoard")
	public String list(Model model, HttpSession session) throws Exception {
		ArrayList<ArrayList<String>> dataSetReview = reviewService.searchReview();
		ArrayList<ArrayList<String>> dataSetBoard = boardService.searchBoard();
		ArrayList<ArrayList<String>> dataSetNotice = noticeService.searchNotice();
		model.addAttribute("dataSetReview", dataSetReview);
		model.addAttribute("dataSetBoard", dataSetBoard);
		model.addAttribute("dataSetNotice", dataSetNotice);

		return "admin_board";
	}

	//	Board
	
	// 쓰기
	@PostMapping(value = "/adminInsertBoard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminInsertBoard(@RequestBody String json, HttpSession session) throws Exception {
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

	// 삭제
	@PostMapping(value = "/adminDeleteBoard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminModifyBoard(@RequestBody String json, HttpSession session) throws Exception {
		Gson gson = new Gson();
		BoardDto boardDto = gson.fromJson(json, BoardDto.class);
		int seq = boardDto.getSeq();
		boardService.deleteBoard(seq);
		return "redirect:admin_board";
	}

	// 수정
	@PostMapping(value = "/adminModifyBoard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminDeleteBoard(@RequestBody String json, HttpSession session) throws Exception {
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

	// 삭제
	@PostMapping(value = "/adminDeleteReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminModifyReview(@RequestBody String json, HttpSession session) throws Exception {
		Gson gson = new Gson();
		ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
		int seq = reviewDto.getSeq();
		reviewService.deleteReview(seq);
		return "redirect:admin_board";
	}

	// 수정
	@PostMapping(value = "/adminModifyReview", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminDeleteReview(@RequestBody String json, HttpSession session) throws Exception {
		Gson gson = new Gson();
		ReviewDto reviewDto = gson.fromJson(json, ReviewDto.class);
		int seq = reviewDto.getSeq();
		String rrcontext = reviewDto.getRrcontext();
		String adminid = (String) session.getAttribute("ID");
		reviewService.modifyReview(seq, adminid, rrcontext);
		return "redirect:admin_board";
	}
	
	
	//	Notice
	
	// 쓰기
	@PostMapping(value = "/adminInsertNotice", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminInsertNotice(@RequestBody String json, HttpSession session) throws Exception {
		Gson gson = new Gson();
		NoticeDto noticeDto = gson.fromJson(json, NoticeDto.class);
		NoticeDto newseqDto = noticeService.searchNoticeseq();
		int seq = newseqDto.getSeq();
		String title = noticeDto.getTitle();
		String adminid = (String) session.getAttribute("ID");
		String brcontext = noticeDto.getContext();

		noticeService.insertNotice(seq, adminid, title, brcontext);
		return "redirect:admin_board";
	}

	// 삭제
	@PostMapping(value = "/adminDeleteNotice", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminModifyNotice(@RequestBody String json, HttpSession session) throws Exception {
		Gson gson = new Gson();
		NoticeDto noticeDto = gson.fromJson(json, NoticeDto.class);
		int seq = noticeDto.getSeq();
		noticeService.deleteNotice(seq);
		return "redirect:admin_board";
	}

	// 수정
	@PostMapping(value = "/adminModifyNotice", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adminDeleteNotice(@RequestBody String json, HttpSession session) throws Exception {
		Gson gson = new Gson();
		NoticeDto noticeDto = gson.fromJson(json, NoticeDto.class);
		int seq = noticeDto.getSeq();
		String title = noticeDto.getTitle();
		String context = noticeDto.getContext();
		String adminid = (String) session.getAttribute("ID");
		noticeService.modifyNotice(seq, adminid,title, context);
		return "redirect:admin_board";
	}

}
