package com.springlec.base.service.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.ManageDto;
import com.springlec.base.model.admin.OrdersDto;
import com.springlec.base.model.admin.SubscribeDto;

public interface MainService {

	public OrdersDto searchmonthSales() throws Exception;

	public OrdersDto searchyearSalessolo() throws Exception;

	public OrdersDto searchordersHowmany() throws Exception;

	public OrdersDto searchtodo() throws Exception;
	
	public ArrayList<ArrayList<String>> searchyearsales() throws Exception;
	
	public SubscribeDto searchsubscribeSalessolo() throws Exception;
	
	public ManageDto searchWarningManage() throws Exception;
	
}
