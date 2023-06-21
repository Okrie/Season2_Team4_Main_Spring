package com.springlec.base.dao.orders;

import java.util.List;

import com.springlec.base.model.orders.NOrdersDto;

public interface NOrdersDao {

	public NOrdersDto productInfoDao(String pcode) throws Exception;
	
	public List<NOrdersDto> userInfoDao(String userid) throws Exception;
	
	public void insertOrdersDao(String userid, String pcode, String count, String address) throws Exception;
	
	
	
	public List<NOrdersDto> cartOrdersDao(String pcode) throws Exception;
	
}
