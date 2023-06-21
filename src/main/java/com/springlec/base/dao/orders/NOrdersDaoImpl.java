package com.springlec.base.dao.orders;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.orders.NOrdersDto;

public class NOrdersDaoImpl implements NOrdersDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.orders.NOrdersDao";
	
	@Override
	public NOrdersDto productInfoDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".productInfoDao");
		
	}

	@Override
	public List<NOrdersDto> userInfoDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".userInfoDao");
	}


	@Override
	public void insertOrdersDao(String userid, String pcode, String count, String address) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectList(nameSpace + ".insertOrdersDao");
		
	}

	@Override
	public List<NOrdersDto> cartOrdersDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".cartOrdersDao");
	}



}
