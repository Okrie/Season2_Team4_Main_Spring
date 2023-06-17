package com.springlec.base.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.model.main.NDProductListDto;

//Dao인터페이스를 사용해 DB작업 수행.

@Service
public class NDMainDaoServiceImpl implements NDMainDaoService {

	@Autowired
	com.springlec.base.dao.main.NDMainDao dao;
	
	@Override
	public List<NDProductListDto> NDTakeAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDTakeAll();
	}

}
