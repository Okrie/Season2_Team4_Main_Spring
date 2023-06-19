package com.springlec.base.service.main;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.main.NDProductListDto;

public interface NDSearchQueryDaoService {
	
	public List<NDProductListDto> NDSearchQuery(@RequestParam("name")String name) throws Exception;

}
