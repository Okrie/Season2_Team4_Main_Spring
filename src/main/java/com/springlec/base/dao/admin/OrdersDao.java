package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.OrdersDto;

public interface OrdersDao {
	public OrdersDto searchmonthSales() throws Exception;
	
	public OrdersDto searchyearSalessolo() throws Exception;
	
	public OrdersDto searchordersHowmany() throws Exception;
	
	public OrdersDto searchtodo() throws Exception;
	
	public ArrayList<OrdersDto> searchyearsales() throws Exception;
	
	public ArrayList<OrdersDto> searchOrders() throws Exception;
	
	public ArrayList<OrdersDto> searchupdate(int ordercode) throws Exception;
	
	public int refundupdate(int ordercode) throws Exception;
	
	public int deliveryupdate(int ordercode) throws Exception;
	
	public ArrayList<OrdersDto> searchWeekorders() throws Exception;
	
	public ArrayList<OrdersDto> searchEmail(int ordercode) throws Exception;
	
	
}
