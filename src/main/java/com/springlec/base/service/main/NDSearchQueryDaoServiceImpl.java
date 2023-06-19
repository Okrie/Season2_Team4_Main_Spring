package com.springlec.base.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.dao.main.NDSearchQueryDao;
import com.springlec.base.model.main.NDProductListDto;

@Service
public class NDSearchQueryDaoServiceImpl implements NDSearchQueryDaoService {

	@Autowired
	NDSearchQueryDao dao;
	
	@Override
	public List<NDProductListDto> NDSearchQuery(@RequestParam("name") String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.NDSearchQuery(name);
	}

}
