package com.springlec.base.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.user.NUserReviewDto;

public class NUserReviewDaoImpl implements NUserReviewDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.user";
	
	@Override
	public List<NUserReviewDto> reviewList(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".reviewList");
	}

	@Override
	public List<NUserReviewDto> reviewAdminList(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".reviewAdminList");
	}

}
