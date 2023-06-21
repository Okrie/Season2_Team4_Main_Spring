package com.springlec.base.dao.user;

import java.util.List;

import com.springlec.base.model.user.NUserReviewDto;

public interface NUserReviewDao {
	public List<NUserReviewDto> reviewList(String pcode) throws Exception;
	public List<NUserReviewDto> reviewAdminList(String pcode) throws Exception;
	
	//review작성
	public void NDReviewWriteDao(String pcode) throws Exception;
	public void NDWriteReviewUserDao(String seq, String ID, String pcode) throws Exception;
	
}
