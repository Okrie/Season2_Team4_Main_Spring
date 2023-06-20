package com.springlec.base.service.bulletinBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.bulletinBoard.NDNoticeDao;

@Service
public class NDNoticeDaoServiceImpl implements NDNoticeDaoService {
	
	@Autowired
	NDNoticeDao dao;

	@Override
	public String NDNoticeBoardDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return dao.NDNoticeBoardDao(pcode);
	}

}
