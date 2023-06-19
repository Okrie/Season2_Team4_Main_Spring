package com.springlec.base.service.user;

import java.util.List;

import com.springlec.base.model.user.NUserOrderDto;


public interface NUserOrderService {

	public List<NUserOrderDto> mypageUserOrderinfo(String userid) throws Exception;
}
