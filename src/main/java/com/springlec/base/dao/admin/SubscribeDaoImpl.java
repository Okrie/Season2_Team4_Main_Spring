package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.SubscribeDto;

public class SubscribeDaoImpl implements SubscribeDao {
	
	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.SubscribeDao";

	@Override
	public SubscribeDto searchsubscribeSalessolo() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchsubscribeSalessolo");
	}

	@Override
	public ArrayList<SubscribeDto> searchSubscribe() throws Exception {
		// TODO Auto-generated method stub
		List<SubscribeDto> resultList = sqlsession.selectList(namespace + ".searchSubscribe");
		ArrayList<SubscribeDto> subscribeList = new ArrayList<>(resultList);
		return subscribeList;
	}

	@Override
	public ArrayList<SubscribeDto> scheduleSubscribe() throws Exception {
		// TODO Auto-generated method stub
		List<SubscribeDto> resultList = sqlsession.selectList(namespace + ".scheduleSubscribe");
		ArrayList<SubscribeDto> subscribeList = new ArrayList<>(resultList);
		return subscribeList;
	}

}
