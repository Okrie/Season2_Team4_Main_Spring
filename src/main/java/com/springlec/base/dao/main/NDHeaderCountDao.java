package com.springlec.base.dao.main;

import java.security.Timestamp;

import com.springlec.base.model.main.NDHeaderCountDto;

public interface NDHeaderCountDao {
	
	public int heartCountDao(String userid) throws Exception;
	public int cartCountDao(String userid) throws Exception;
	public int cartTotalPriceDao(String userid) throws Exception;
	
	//remainDate관련 dao, subscribeDate가져오기
	public int remainDateDao(String userid, Timestamp subscribeDate) throws Exception;
	public Timestamp subscribeDate(String userid) throws Exception;

}
