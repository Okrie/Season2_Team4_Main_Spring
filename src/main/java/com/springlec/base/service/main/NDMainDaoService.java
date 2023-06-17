package com.springlec.base.service.main;

import java.util.List;

import com.springlec.base.model.main.NDProductListDto;

public interface NDMainDaoService {
	
	//NDProductDao를 추상화.
	//NDProductDao interface를 서비스 계층에서 호출하고 그 결과를 변환.
	public List<NDProductListDto> NDTakeAll() throws Exception;

}
