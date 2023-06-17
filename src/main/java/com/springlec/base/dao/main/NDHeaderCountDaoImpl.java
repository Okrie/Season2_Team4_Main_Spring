package com.springlec.base.dao.main;

import java.security.Timestamp;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.main.NDHeaderCountDto;

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
	public int cartTotalPriceDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDHeaderCountDao");

	}

	@Override
	public int remainDateDao(String userid, Timestamp subscribeDate) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NDHeaderCountDto subscribeDate(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
