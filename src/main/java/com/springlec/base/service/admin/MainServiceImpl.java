package com.springlec.base.service.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.ManageDao;
import com.springlec.base.dao.admin.OrdersDao;
import com.springlec.base.dao.admin.SubscribeDao;
import com.springlec.base.model.admin.ManageDto;
import com.springlec.base.model.admin.OrdersDto;
import com.springlec.base.model.admin.SubscribeDto;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	SubscribeDao subscribedao;
	
	@Autowired
	OrdersDao ordersdao;

	@Autowired
	ManageDao managedao;
	
	@Override
	public OrdersDto searchmonthSales() throws Exception {
		// TODO Auto-generated method stub
		return ordersdao.searchmonthSales();
	}

	@Override
	public OrdersDto searchyearSalessolo() throws Exception {
		// TODO Auto-generated method stub
		return ordersdao.searchyearSalessolo();
	}

	@Override
	public OrdersDto searchordersHowmany() throws Exception {
		// TODO Auto-generated method stub
		return ordersdao.searchordersHowmany();
	}

	@Override
	public OrdersDto searchtodo() throws Exception {
		// TODO Auto-generated method stub
		return ordersdao.searchtodo();
	}

	@Override
	public ArrayList<ArrayList<String>> searchyearsales() throws Exception {
		ArrayList<OrdersDto> dtoOrders = ordersdao.searchyearsales();

		ArrayList<ArrayList<String>> dataSales = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRow = new ArrayList<String>();
		headerRow.add("'월'");
		headerRow.add("'판매액(₩)'");
		dataSales.add(headerRow);
		for (int i = 0; i < dtoOrders.size(); i++) {
			OrdersDto ordersDto = dtoOrders.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + ordersDto.getMonth() + "'");
			row.add(Integer.toString(ordersDto.getTotalsales()));
			dataSales.add(row);
		}
		return dataSales;
	}

	@Override
	public SubscribeDto searchsubscribeSalessolo() throws Exception {
		// TODO Auto-generated method stub
		return subscribedao.searchsubscribeSalessolo();
	}

	@Override
	public ManageDto searchWarningManage() throws Exception {
		// TODO Auto-generated method stub
		return managedao.searchWarningManage();
	}

}
