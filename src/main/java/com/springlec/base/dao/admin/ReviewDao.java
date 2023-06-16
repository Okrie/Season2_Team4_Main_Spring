package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.ReviewDto;

public interface ReviewDao {
	public ArrayList<ReviewDto> searchReview() throws Exception;

	public int insertReview_01(int seq, int parent, int layer, String pcode, String adminid) throws Exception;

	public int insertReview_02(int seq, String adminid, String rrcontext) throws Exception;

	public ReviewDto searchReviewseq() throws Exception;

	public int modifyReview(int seq, String adminid, String rrcontext) throws Exception;

	public int deleteReview(int seq) throws Exception;
}
