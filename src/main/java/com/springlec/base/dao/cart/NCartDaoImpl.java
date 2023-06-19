package com.springlec.base.dao.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.springlec.base.model.cart.NCartDto;

public class NCartDaoImpl implements NCartDao {
	
	
	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.cart.NCartDao";

	@Override
	public List<NCartDto> NcartListDao() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".NcartListDao");
	}
/*
	@Override
	public void cartDeleteDao(int seq) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectOne(nameSpace + ".cartDeleteDao");
	}
*/
}
