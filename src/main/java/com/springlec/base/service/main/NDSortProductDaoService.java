package com.springlec.base.service.main;

import java.util.List;

import com.springlec.base.model.main.NDSortProductDto;

public interface NDSortProductDaoService {

	
	public List<NDSortProductDto> NDSortProductListAll()throws Exception;
	public List<NDSortProductDto> NDSortProductListCal()throws Exception;
	public List<NDSortProductDto> NDSortProductListHighPrice()throws Exception;
	public List<NDSortProductDto> NDSortProductListLowPrice()throws Exception;
	public List<NDSortProductDto> NDSortProductListDiet()throws Exception;
	public List<NDSortProductDto> NDSortProductList7000()throws Exception;
	public List<NDSortProductDto> NDSortProductListTop10()throws Exception;
}
