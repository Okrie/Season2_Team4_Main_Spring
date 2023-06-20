package com.springlec.base.dao.bulletinBoard;

import org.apache.ibatis.session.SqlSession;

public class NDNoticeDaoImpl implements NDNoticeDao {
	
	SqlSession session;
	public static String namespace = "com.springlec.base.dao.bulletinBoard";
	
	@Override
	public String NDNoticeBoardDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace, ".NDNoticeDao");
	}

}
