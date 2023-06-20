package com.springlec.base.dao.main;

import java.sql.Timestamp;

public interface NDHeaderCountDao {
	
	public int heartCountDao(String userid) throws Exception;
	public int cartCountDao(String userid) throws Exception;
	public String cartTotalPriceDao(String userid) throws Exception;
	
	//remainDate관련 dao
	public Timestamp remainDateDao(String userid) throws Exception;

}
