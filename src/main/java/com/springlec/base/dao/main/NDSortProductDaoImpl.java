package com.springlec.base.dao.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.main.NDSortProductDto;

public class NDSortProductDaoImpl implements NDSortProductDao {
	
	SqlSession sqlSession;
	public static String namespace = "com.springlec.base.dao.main.NDSortProductDao";
 
	@Override
	public List<NDSortProductDto> NDSortProductListAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}

}
