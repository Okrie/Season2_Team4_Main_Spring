package com.springlec.base.dao.admin;

import java.util.List;

import com.springlec.base.model.admin.ReviewDto;

public interface ReviewDao {
	public List<ReviewDto> searchBoard() throws Exception;

	public int insertBoard_01(int seq, String parent, String layer, String pcode, String adminid) throws Exception;

	public int insertBoard_02(int seq, String adminid, String context) throws Exception;

	public ReviewDto searchBoardseq() throws Exception;

	public int modifyBoard(int seq, String adminid, String context) throws Exception;

	public int deleteBoard(int seq) throws Exception;
}
