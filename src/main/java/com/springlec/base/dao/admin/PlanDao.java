package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.PlanDto;

public interface PlanDao {
	public ArrayList<PlanDto> searchSubscribeDeliverydate() throws Exception;
	
	public ArrayList<PlanDto> searchSubscribeShippingTmw() throws Exception;
	
	public int updateSubscribePlan(int plcode) throws Exception;
}
