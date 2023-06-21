package com.springlec.base.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.user.NUserBucketDao;
import com.springlec.base.model.user.NUserWishlistDto;

@Service
public class NUserBucketServiceImpl implements NUserBucketService {

	@Autowired
	NUserBucketDao dao;
	
	@Override
	public int userCartIn(String pcode, String userid, int count) throws Exception {
		// TODO Auto-generated method stub
		return dao.userCartIn(pcode, userid, count);
	}

	@Override
	public int userWishlistIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userWishlistIn(pcode, userid);
	}

	@Override
	public int userWishlistDelete(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userWishlistDelete(pcode, userid);
	}

	@Override
	public List<NUserWishlistDto> userWishList(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.userWishList(userid);
	}

}
