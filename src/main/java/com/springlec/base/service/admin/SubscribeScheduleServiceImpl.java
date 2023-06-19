package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.SubscribeDao;
import com.springlec.base.model.admin.SubscribeDto;

@Service
public class SubscribeScheduleServiceImpl implements SubscribeScheduleService {
	
	@Autowired
	SubscribeDao subscribeDao;

	@Override
	public ArrayList<String> scheduleSubscribe() throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<SubscribeDto> dtoSubscribe = subscribeDao.scheduleSubscribe();
		ArrayList<String> dataSetSubscribe = new ArrayList<String>();
		

		for (SubscribeDto dto : dtoSubscribe) {
			String deliverycolor;
			if (dto.getDelivery() == 1) {
				deliverycolor = "#000000";
			} else {
				deliverycolor = "#7FAD39";
			}

			String event = "{ \"title\": \"" + dto.getUserid() + "(" + dto.getUname() + ")의 구독\", " +
			        "\"start\": \"" + dateFormat.format(dto.getPlandate()) + "\", " +
			        "\"allday\": true, " +
			        "\"backgroundColor\": \"" + deliverycolor + "\", " +
			        "\"extendedProps\": { " +
			        "\"uname\": \"" + dto.getUname() + "\", " +
			        "\"scode\": \"" + dto.getScode() + "\", " +
			        "\"pname\": \"" + dto.getPname() + "\", " +
			        "\"address\": \"" + dto.getAddress() + "\", " +
			        "\"plcode\": \"" + dto.getPlcode() + "\" " +
			        "}}";


			dataSetSubscribe.add(event);
		}
		return dataSetSubscribe;
	}

}
