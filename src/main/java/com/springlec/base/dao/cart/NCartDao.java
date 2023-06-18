package com.springlec.base.dao.cart;

import java.util.List;

import com.springlec.base.model.cart.NCartDto;



public interface NCartDao {

	public List<NCartDto> cartListDao() throws Exception;
	
	public void cartDeleteDao(int seq) throws Exception;
}
