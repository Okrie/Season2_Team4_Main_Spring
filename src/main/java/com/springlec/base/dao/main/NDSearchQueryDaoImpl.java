package com.springlec.base.dao.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.main.NDSearchQueryDto;

public class NDSearchQueryDaoImpl implements NDSearchQueryDao {
	
	SqlSession sqlSession;
	public static String namespace = "com.springlec.base.dao.NDSearchQueryDao";	

	@Override
	public List<NDSearchQueryDto> NDSearchQuery() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+ ".searchQuery");
	}

}
