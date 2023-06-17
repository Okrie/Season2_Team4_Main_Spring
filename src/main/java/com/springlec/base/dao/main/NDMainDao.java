package com.springlec.base.dao.main;

import java.util.List;

import com.springlec.base.model.main.NDProductListDto;

public interface NDMainDao {

	//모든 제품 리스트 가져오는 Dao
	//메서드 : NDTakeAll(), List<NDProdcutDto>를 반환값으로 가짐.
	public List<NDProductListDto> NDTakeAll() throws Exception;
	
	
}
