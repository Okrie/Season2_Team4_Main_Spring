package com.springlec.base.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.user.NUserOrderDao;
import com.springlec.base.model.user.NUserOrderDto;

@Service
public class NUserOrderServiceImpl implements NUserOrderService {

	@Autowired
	NUserOrderDao dao;
	
	@Override
	public List<NUserOrderDto> mypageUserOrderinfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.mypageUserOrderinfo(userid);
	}

}
