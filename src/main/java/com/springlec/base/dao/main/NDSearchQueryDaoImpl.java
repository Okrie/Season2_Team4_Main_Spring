package com.springlec.base.dao.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.main.NDProductListDto;

public class NDSearchQueryDaoImpl implements NDSearchQueryDao {
	
	SqlSession sqlSession;
	public static String namespace = "com.springlec.base.dao.main.NDSearchQueryDao";	

	@Override
	public List<NDProductListDto> NDSearchQuery(@RequestParam("name") String name) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+ ".NDSearchQuery");
	}

}
