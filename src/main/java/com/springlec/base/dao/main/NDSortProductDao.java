package com.springlec.base.dao.main;

import java.util.List;

import com.springlec.base.model.main.NDSortProductDto;

public interface NDSortProductDao {
	
	
	//모든 제품 리스트 가져오는 Dao ==NDMainDao랑 코드 동일
	public List<NDSortProductDto> NDSortProductListAll() throws Exception;
	//모든 제품 리스트 cal별로 정렬하는 DAO
	public List<NDSortProductDto> NDSortProductListCal() throws Exception;
	//모든 제품 리스트 highPrice순으로 정렬
	public List<NDSortProductDto> NDSortProductListHighPrice() throws Exception;
	//모든 제품 리스트 lowPrice순으로 정렬
	public List<NDSortProductDto> NDSortProductListLowPrice() throws Exception;
	
	

}
