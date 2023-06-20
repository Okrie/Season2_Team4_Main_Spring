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

	@Override
	public List<NDSortProductDto> NDSortProductListCal() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}

	@Override
	public List<NDSortProductDto> NDSortProductListHighPrice() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}

	@Override
	public List<NDSortProductDto> NDSortProductListLowPrice() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}

	@Override
	public List<NDSortProductDto> NDSortProductListDiet() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}

	@Override
	public List<NDSortProductDto> NDSortProductList7000() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}

	@Override
	public List<NDSortProductDto> NDSortProductListTop10() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".NDSortProductDao");
	}


}
