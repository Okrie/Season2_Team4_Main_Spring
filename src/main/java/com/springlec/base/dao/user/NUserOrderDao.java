package com.springlec.base.dao.user;

import java.util.List;

import com.springlec.base.model.user.NUserOrderDto;


public interface NUserOrderDao {
	public List<NUserOrderDto> mypageUserOrderinfo(String userid) throws Exception;
}
