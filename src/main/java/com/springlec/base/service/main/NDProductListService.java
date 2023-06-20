package com.springlec.base.service.main;

import java.util.List;

import com.springlec.base.model.user.NUserOrderDto;

public interface NDProductListService {
	public List<NUserOrderDto> productListDao(String pcode) throws Exception;
}
