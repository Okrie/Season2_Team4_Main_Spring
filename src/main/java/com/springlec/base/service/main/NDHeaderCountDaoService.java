package com.springlec.base.service.main;

import java.security.Timestamp;

public interface NDHeaderCountDaoService {
	
	public int heartCountDao(String userid) throws Exception;
	public int cartCountDao(String userid) throws Exception;
	public int cartTotalPriceDao(String userid) throws Exception;
	public int remainDateDao(String userid, Timestamp subscribeDate) throws Exception;
	public long calculateRemainingDays(String userid);
}
