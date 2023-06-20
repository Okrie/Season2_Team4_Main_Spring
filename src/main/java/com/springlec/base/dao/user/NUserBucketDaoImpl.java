package com.springlec.base.dao.user;

import org.apache.ibatis.session.SqlSession;

public class NUserBucketDaoImpl implements NUserBucketDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.user";
	
	@Override
	public int userCartIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".userCartIn");
	}

	@Override
	public int userWishlistIn(String pcode, String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".userWishlistIn");
	}

}
