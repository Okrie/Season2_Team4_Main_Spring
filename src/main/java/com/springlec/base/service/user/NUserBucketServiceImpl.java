package com.springlec.base.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.user.NUserBucketDao;

@Service
public class NUserBucketServiceImpl implements NUserBucketService {

	@Autowired
	NUserBucketDao dao;
	
	@Override
	public int userCartIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userCartIn(pcode, userid);
	}

	@Override
	public int userWishlistIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userWishlistIn(pcode, userid);
	}

}
