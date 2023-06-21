package com.springlec.base.dao.user;

import java.util.List;

import com.springlec.base.model.user.NUserReviewDto;

public interface NUserReviewDao {
	public List<NUserReviewDto> reviewList(String pcode) throws Exception;
	public List<NUserReviewDto> reviewAdminList(String pcode) throws Exception;
}
