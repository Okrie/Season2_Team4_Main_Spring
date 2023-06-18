package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.SubscribeDto;

public interface SubscribeDao {
	public SubscribeDto searchsubscribeSalessolo() throws Exception;
	
	public ArrayList<SubscribeDto> searchSubscribe() throws Exception;
	
	public ArrayList<SubscribeDto> scheduleSubscribe() throws Exception;
}
