package com.springlec.base.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.main.NDProductListDao;
import com.springlec.base.model.user.NUserOrderDto;

@Service
public class NDProdcutListServiceImpl implements NDProductListService {

	@Autowired
	NDProductListDao dao;
	
	@Override
	public List<NUserOrderDto> productListDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return dao.productListDao(pcode);
	}

}
