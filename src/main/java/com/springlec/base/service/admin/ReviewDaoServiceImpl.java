package com.springlec.base.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.admin.ReviewDao;
import com.springlec.base.model.admin.ReviewDto;

@Service
@Transactional(rollbackFor = Exception.class) // rollback을 안하면 data가 꼬인다.
public class ReviewDaoServiceImpl implements ReviewDaoService {

	@Autowired
	ReviewDao reviewDao;

	@Override
	public ArrayList<ArrayList<ReviewDto>> searchReview() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ReviewDto> dtoReview = reviewDao.searchReview();
		
	}

	@Override
	public int insertReview(int seq, int parent, int layer, String pcode, String adminid, String rrcontext)
			throws Exception {
		// TODO Auto-generated method stub
		int result_01 = reviewDao.insertReview_01(seq, parent, layer, pcode, adminid);
		int result_02 = reviewDao.insertReview_02(seq, adminid, rrcontext);
		return result_01 + result_02;
	}

	@Override
	public ReviewDto searchReviewseq() throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.searchReviewseq();
	}

	@Override
	public int modifyReview(int seq, String adminid, String rrcontext) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.modifyReview(seq, adminid, rrcontext);
	}

	@Override
	public int deleteReview(int seq) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.deleteReview(seq);
	}

}
