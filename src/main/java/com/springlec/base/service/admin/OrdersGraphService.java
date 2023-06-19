package com.springlec.base.service.admin;

import java.util.ArrayList;

public interface OrdersGraphService {
	public ArrayList<ArrayList<String>> searchOrdersProduct() throws Exception;
	
	public ArrayList<ArrayList<String>> searchWeekorders() throws Exception; 
}
