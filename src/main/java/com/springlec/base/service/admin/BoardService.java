package com.springlec.base.service.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.BoardDto;

public interface BoardService {
	public ArrayList<ArrayList<String>> searchBoard() throws Exception;

	public int insertBoard(int seq, int parent, int layer, String pcode, String adminid, String brtitle, String brcontext)
			throws Exception;

	public BoardDto searchBoardseq() throws Exception;

	public int modifyBoard(int seq, String adminid, String brtitle, String brcontext) throws Exception;

	public int deleteBoard(int seq) throws Exception;
}
