package com.springlec.base.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.user.NUserWishlistDto;

public class NUserBucketDaoImpl implements NUserBucketDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.user";
	
	@Override
	public int userCartIn(String pcode, String userid, int count) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".userCartIn");
	}

	@Override
	public int userWishlistIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".userWishlistIn");
	}

	@Override
	public int userWishlistDelete(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace + ".userWishlistDelete");
	}

	@Override
	public List<NUserWishlistDto> userWishList(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".userWishList");
	}

}
