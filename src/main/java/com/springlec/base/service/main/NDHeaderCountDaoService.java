package com.springlec.base.service.main;


public interface NDHeaderCountDaoService {
	
	public int heartCountDao(String userid) throws Exception;
	public int cartCountDao(String userid) throws Exception;
	public String cartTotalPriceDao(String userid) throws Exception;
	public String remainDateDao(String userid) throws Exception;
}
