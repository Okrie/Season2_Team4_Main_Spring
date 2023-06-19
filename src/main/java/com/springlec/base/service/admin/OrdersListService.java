package com.springlec.base.service.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.OrdersDto;


public interface OrdersListService {
	public ArrayList<ArrayList<String>> searchOrders() throws Exception;
	
	public String searchUpdateRefunddate(int ordercode) throws Exception;

	public String searchUpdateDeliverydate(int ordercode) throws Exception;
	
	public int searchUpdateStock(int ordercode) throws Exception;
	
	public ArrayList<OrdersDto> searchupdate(int ordercode) throws Exception;
}
