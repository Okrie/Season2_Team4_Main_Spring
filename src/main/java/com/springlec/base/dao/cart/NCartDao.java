package com.springlec.base.dao.cart;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.cart.NCartDto;



public interface NCartDao {

	public List<NCartDto> NcartListDao(String userid) throws Exception;
	
	public void cartDeleteDao(int seq) throws Exception;
}
