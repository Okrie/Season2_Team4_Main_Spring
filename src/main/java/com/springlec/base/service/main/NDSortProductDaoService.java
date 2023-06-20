package com.springlec.base.service.main;

import java.util.List;

import com.springlec.base.model.main.NDSortProductDto;

public interface NDSortProductDaoService {

	
	public List<NDSortProductDto> NDSortProductListAll()throws Exception;
	public List<NDSortProductDto> NDSortProductListCal()throws Exception;
}
