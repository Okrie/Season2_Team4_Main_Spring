package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.OrdersDto;
import com.springlec.base.model.admin.ProductDto;

public class OrdersDaoImpl implements OrdersDao {

	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.OrdersDao";

	@Override
	public OrdersDto searchmonthSales() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchmonthSales");
	}

	@Override
	public OrdersDto searchyearSalessolo() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchyearSalessolo");
	}

	@Override
	public OrdersDto searchordersHowmany() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchordersHowmany");
	}

	@Override
	public OrdersDto searchtodo() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchtodo");
	}

	@Override
	public ArrayList<OrdersDto> searchyearsales() throws Exception {
		// TODO Auto-generated method stub
		List<OrdersDto> resultList = sqlsession.selectList(namespace + ".searchyearsales");
		ArrayList<OrdersDto> ordersList = new ArrayList<>(resultList);
		return ordersList;
	}

	@Override
	public ArrayList<OrdersDto> searchOrders() throws Exception {
		// TODO Auto-generated method stub
		List<OrdersDto> resultList = sqlsession.selectList(namespace + ".searchOrders");
		ArrayList<OrdersDto> ordersList = new ArrayList<>(resultList);
		return ordersList;
	}

	@Override
	public ArrayList<OrdersDto> searchupdate() throws Exception {
		// TODO Auto-generated method stub
		List<OrdersDto> resultList = sqlsession.selectList(namespace + ".searchupdate");
		ArrayList<OrdersDto> ordersList = new ArrayList<>(resultList);
		return ordersList;
	}

	@Override
	public int refundupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".refundupdate");
	}

	@Override
	public int deliveryupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".deliveryupdate");
	}

	@Override
	public ArrayList<OrdersDto> searchWeekorders() throws Exception {
		// TODO Auto-generated method stub
		List<OrdersDto> resultList = sqlsession.selectList(namespace + ".searchWeekorders");
		ArrayList<OrdersDto> ordersList = new ArrayList<>(resultList);
		return ordersList;
	}

}
