package com.springlec.base.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.main.NDSearchQueryDao;
import com.springlec.base.model.main.NDSearchQueryDto;

@Service
public class NDSearchQueryDaoServiceImpl implements NDSearchQueryDaoService {

	@Autowired
	NDSearchQueryDao dao;
	
	@Override
	public List<NDSearchQueryDto> NDSearchQuery() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSearchQuery();
	}

}
