package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.BoardDto;

public interface BoardDao {
	public ArrayList<BoardDto> searchBoard() throws Exception;

	public int insertBoard_01(int seq, int parent, int layer, String pcode, String adminid) throws Exception;

	public int insertBoard_02(int seq, String adminid, String brtitle, String brcontext) throws Exception;

	public BoardDto searchBoardseq() throws Exception;

	public int modifyBoard(int seq, String adminid, String brtitle, String brcontext) throws Exception;

	public int deleteBoard(int seq) throws Exception;
}
