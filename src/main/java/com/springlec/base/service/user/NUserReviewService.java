package com.springlec.base.service.user;

import java.util.List;

import com.springlec.base.model.user.NUserReviewDto;

public interface NUserReviewService {
	public List<NUserReviewDto> reviewList(String pcode) throws Exception;
	public List<NUserReviewDto> reviewAdminList(String pcode) throws Exception;
}
