package com.springlec.base.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.PlanDao;

@Service
public class SubscribeUpdateServiceImpl implements SubscribeUpdateService {
	@Autowired
	PlanDao planDao;
	@Override
	public int updateSubscribe(int plcode) throws Exception {
		// TODO Auto-generated method stub
		return planDao.updateSubscribePlan(plcode);
	}

}
