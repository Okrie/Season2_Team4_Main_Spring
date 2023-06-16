package com.springlec.base.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.ReviewDao;
import com.springlec.base.model.admin.ReviewDto;


@Service
public class ReviewDaoServiceImpl implements ReviewDaoService {
	
	@Autowired
	ReviewDao reviewDao;
	
	
	@Override
	public List<ReviewDto> searchBoard() throws Exception {
		
		return null;
	}

	@Override
	public int insertBoard_01(int seq, String parent, String layer, String pcode, String adminid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBoard_02(int seq, String adminid, String context) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewDto searchBoardseq() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyBoard(int seq, String adminid, String context) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int seq) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
