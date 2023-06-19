package com.springlec.base.dao.main;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.base.model.main.NDProductListDto;

public interface NDSearchQueryDao {
	
	public List<NDProductListDto> NDSearchQuery(@RequestParam("name") String name) throws Exception;

}
