package com.springlec.base.service.cart;

import java.util.List;


import com.springlec.base.model.cart.NCartDto;

public interface NCartService {

	
	public List<NCartDto> NcartListDao(String strings) throws Exception;
	
	public void cartDeleteDao(int seq) throws Exception;
	
}
