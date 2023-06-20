package com.springlec.base.dao.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.user.NUserOrderDto;

public class NDProductListDaoImpl implements NDProductListDao {

	SqlSession sqlSession;
	public static String nameSpace = "com.springlec.base.dao.main.NDProductListDao";
	
	@Override
	public List<NUserOrderDto> productListDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".productListDao");
	}

}
