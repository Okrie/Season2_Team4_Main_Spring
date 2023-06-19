package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.ManageDao;
import com.springlec.base.dao.admin.OrdersDao;
import com.springlec.base.model.admin.ManageDto;
import com.springlec.base.model.admin.OrdersDto;

@Service
public class OrdersListServiceImpl implements OrdersListService {

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	ManageDao manageDao;

	@Override
	public ArrayList<ArrayList<String>> searchOrders() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ArrayList<OrdersDto> dtoOrders = ordersDao.searchOrders();
		ArrayList<ManageDto> dtoManage = manageDao.searchOrdersManage();

		ArrayList<ArrayList<String>> dataSetOrders = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoOrders.size(); i++) {
			OrdersDto ordersDto = dtoOrders.get(i);
			ManageDto manageDto = dtoManage.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'"+Integer.toString(ordersDto.getOrdercode())+"'");
			row.add("'"+ordersDto.getUserid()+"'");
			row.add("'"+ordersDto.getPcode()+"'");
			row.add("'"+ordersDto.getAddress()+"'");
			row.add("'"+Integer.toString(ordersDto.getCount())+"'");
			row.add("'"+Integer.toString(manageDto.getStock())+"'");
			row.add("'"+dateFormat.format(ordersDto.getOrderdate())+"'");
			if (ordersDto.getRefunddate() != null) {
				row.add("'"+dateFormat.format(ordersDto.getRefunddate())+"'");
			} else {
				row.add("'환불되지 않았습니다.'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.				
			}
			if (ordersDto.getDeliverydate() != null) {
				row.add("'"+dateFormat.format(ordersDto.getDeliverydate())+"'");
			} else {
				row.add("'배송되지 않았습니다.'"); // null인 경우 빈 문자열로 처리하거나 다른 기본값으로 대체할 수 있습니다.
			}
			dataSetOrders.add(row);
		}

		return dataSetOrders;
	}


	@Override
	public String searchUpdateRefunddate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String Refunddate = "환불되지 않았습니다.";

		ArrayList<OrdersDto> dtoOrders = ordersDao.searchupdate(ordercode);
		
		if (dtoOrders.get(0).getRefunddate() != null) {
			Refunddate = dateFormat.format(dtoOrders.get(0).getRefunddate());
		}
		return Refunddate;
	}

	@Override
	public String searchUpdateDeliverydate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String Deliverydate = "배송되지 않았습니다.";
		
		ArrayList<OrdersDto> dtoOrders = ordersDao.searchupdate(ordercode);
		
		if (dtoOrders.get(0).getDeliverydate() != null) {
			Deliverydate = dateFormat.format(dtoOrders.get(0).getDeliverydate());
		}
		
		return Deliverydate;
	}

	@Override
	public int searchUpdateStock(int ordercode) throws Exception {
		ManageDto dtoManage = manageDao.searchUpdateManage(ordercode);
		return dtoManage.getStock();
	}


	@Override
	public ArrayList<OrdersDto> searchupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<OrdersDto> dtoOrders = ordersDao.searchupdate(ordercode);
		return dtoOrders;
	}

}
