package com.springlec.base.service.admin;

public interface OrdersUpdateService {
	public int refundupdate(int ordercode) throws Exception;
	
	public int deliveryupdate(int ordercode) throws Exception;
}
