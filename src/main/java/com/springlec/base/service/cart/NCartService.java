package com.springlec.base.service.cart;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.cart.NCartDto;

public interface NCartService {

	
	public List<NCartDto> NcartListDao(String userid) throws Exception;
	
	public void cartDeleteDao(int seq) throws Exception;
	
}
