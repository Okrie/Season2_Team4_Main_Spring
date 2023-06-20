package com.springlec.base.dao.main;


import java.sql.Timestamp;

import org.apache.ibatis.session.SqlSession;


public class NDHeaderCountDaoImpl implements NDHeaderCountDao {
	
	SqlSession session;
	public static String namespace = "com.springlec.base.dao.main";
	

	@Override
	public int heartCountDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDHeaderCountDao");

	}

	@Override
	public int cartCountDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDHeaderCountDao");

	}

	@Override
	public String cartTotalPriceDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDHeaderCountDao");

	}

	@Override
	public Timestamp remainDateDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDHeaderCountDao");
	}



}
