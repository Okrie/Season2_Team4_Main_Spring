package com.springlec.base.dao.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.cart.NCartDto;

public class NCartDaoImml implements NCartDao {

	SqlSession sqlSession;
	
	public static String nameString = "com.springlec.base.dao.CartDao";
	
	@Override
	public List<NCartDto> cartListDao() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameString + ".cartListDao"); 
	}

	@Override
	public void cartDeleteDao(int seq) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectOne(nameString + ".cartDeleteDao");
	}

}
