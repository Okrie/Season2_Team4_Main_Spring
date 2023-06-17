package com.springlec.base.service.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.ReviewDto;

public interface ReviewService {
	public ArrayList<ArrayList<String>> searchReview() throws Exception;

	public int insertReview(int seq, int parent, int layer, String pcode, String adminid, String rrcontext) throws Exception;

	public ReviewDto searchReviewseq() throws Exception;

	public int modifyReview(int seq, String adminid, String rrcontext) throws Exception;

	public int deleteReview(int seq) throws Exception;
}
