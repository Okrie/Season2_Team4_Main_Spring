package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.PlanDto;

public class PlanDaoImpl implements PlanDao {
	
	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.PlanDao";

	@Override
	public ArrayList<PlanDto> searchSubscribeDeliverydate() throws Exception {
		// TODO Auto-generated method stub
		List<PlanDto> resultList = sqlsession.selectList(namespace + ".searchBoard");
		ArrayList<PlanDto> planList =new ArrayList<>(resultList);
		return planList;
	}

	@Override
	public ArrayList<PlanDto> searchSubscribeShippingTmw() throws Exception {
		// TODO Auto-generated method stub
		List<PlanDto> resultList = sqlsession.selectList(namespace + ".searchBoard");
		ArrayList<PlanDto> planList =new ArrayList<>(resultList);
		return planList;
	}

	@Override
	public int updateSubscribePlan(int plcode) throws Exception {
		// TODO Auto-generated method stub
		 return sqlsession.update(namespace + ".updateSubscribePlan", plcode);
	}

}
