package com.springlec.base.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.main.NDSortProductDao;
import com.springlec.base.model.main.NDSortProductDto;

@Service
public class NDSortProductDaoServiceImpl implements NDSortProductDaoService {

	@Autowired
	NDSortProductDao dao;
	
	@Override
	public List<NDSortProductDto> NDSortProductListAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductListAll();
	}

	@Override
	public List<NDSortProductDto> NDSortProductListCal() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductListCal();
	}

	@Override
	public List<NDSortProductDto> NDSortProductListHighPrice() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductListHighPrice();
	}

	@Override
	public List<NDSortProductDto> NDSortProductListLowPrice() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductListLowPrice();
	}

	@Override
	public List<NDSortProductDto> NDSortProductListDiet() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductListDiet();
	}

	@Override
	public List<NDSortProductDto> NDSortProductList7000() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductList7000();
	}

	@Override
	public List<NDSortProductDto> NDSortProductListTop10() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSortProductListTop10();
	}


}
