package com.springlec.base.dao.bulletinBoard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.bulletinBoard.NDNoticeBoardDto;

public class NDNoticeDaoImpl implements NDNoticeDao {
	
	SqlSession session;
	public static String namespace = "com.springlec.base.dao.bulletinBoard";
	
	@Override
	public List<NDNoticeBoardDto> NDNoticeBoardDao() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDNoticeDao");
	}

}
