package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.OrdersDao;
import com.springlec.base.dao.admin.ProductDao;
import com.springlec.base.model.admin.OrdersDto;
import com.springlec.base.model.admin.ProductDto;

@Service
public class OrdersGraphServiceImpl implements OrdersGraphService {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Override
	public ArrayList<ArrayList<String>> searchOrdersProduct() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductDto> dtoProduct = productDao.searchOrdersProduct();
		ArrayList<ArrayList<String>> dataSetProduct = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRow = new ArrayList<String>();
		headerRow.add("'음식 이름'");
		headerRow.add("'주문 개수'");
		dataSetProduct.add(headerRow);
		for (int i = 0; i < dtoProduct.size(); i++) {
			ProductDto productDto = dtoProduct.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + productDto.getName() + "'");
			row.add(Integer.toString(productDto.getTotalorders()));
			dataSetProduct.add(row);
		}
		return dataSetProduct;
	}

	@Override
	public ArrayList<ArrayList<String>> searchWeekorders() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<OrdersDto> dtoOrder = ordersDao.searchWeekorders();
		ArrayList<ArrayList<String>> dataSetOrders = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRowbelow = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd (E)");
		
		headerRowbelow.add("'날짜'");
		headerRowbelow.add("'주문 개수'");
		dataSetOrders.add(headerRowbelow);
		for (int i = 0; i < dtoOrder.size(); i++) {
			OrdersDto ordersDto = dtoOrder.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + dateFormat.format(ordersDto.getOrderdate()) + "'");
			row.add(Integer.toString(ordersDto.getCount()));
			dataSetOrders.add(row);
		}
		return dataSetOrders;
	}

}
