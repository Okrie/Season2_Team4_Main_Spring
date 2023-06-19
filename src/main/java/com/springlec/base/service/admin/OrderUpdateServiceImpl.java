package com.springlec.base.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.OrdersDao;

@Service
public class OrderUpdateServiceImpl implements OrderUpdateService {

	@Autowired
	OrdersDao ordersDao;
	
	@Override
	public int refundupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		return ordersDao.refundupdate(ordercode);
	}

	@Override
	public int deliveryupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		return ordersDao.refundupdate(ordercode);	
	}

}
