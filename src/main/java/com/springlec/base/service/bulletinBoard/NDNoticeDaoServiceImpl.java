package com.springlec.base.service.bulletinBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.bulletinBoard.NDNoticeDao;
import com.springlec.base.model.bulletinBoard.NDNoticeBoardDto;

@Service
public class NDNoticeDaoServiceImpl implements NDNoticeDaoService {
	
	@Autowired
	NDNoticeDao dao;

	@Override
	public List<NDNoticeBoardDto> NDNoticeBoardDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.NDNoticeBoardDao();
	}

}
