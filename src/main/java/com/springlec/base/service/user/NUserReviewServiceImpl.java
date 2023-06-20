package com.springlec.base.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.user.NUserReviewDao;
import com.springlec.base.model.user.NUserReviewDto;

@Service
public class NUserReviewServiceImpl implements NUserReviewService {
	
	@Autowired
	NUserReviewDao dao;
	
	@Override
	public List<NUserReviewDto> reviewList(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewList(pcode);
	}

	@Override
	public List<NUserReviewDto> reviewAdminList(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewAdminList(pcode);
	}

}
