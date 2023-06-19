package com.springlec.base.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.user.NUserOrderDto;


public class NUserOrderDaoImpl implements NUserOrderDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.user";
	
	@Override
	public List<NUserOrderDto> mypageUserOrderinfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".mypageUserOrderinfo");
	}

}
