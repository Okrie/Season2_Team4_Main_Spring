package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.PlanDao;
import com.springlec.base.dao.admin.SubscribeDao;
import com.springlec.base.model.admin.PlanDto;
import com.springlec.base.model.admin.SubscribeDto;

@Service
public class SubscribeSearchServiceImpl implements SubscribeSearchService {
	
	@Autowired
	SubscribeDao subscribeDao;

	@Autowired
	PlanDao planDao;	
	
	@Override
	public ArrayList<ArrayList<String>> searchSubscribe() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<SubscribeDto> dtoSubscribe = subscribeDao.searchSubscribe();
		ArrayList<PlanDto> dtoPlanDeliverydate = planDao.searchSubscribeDeliverydate();
		ArrayList<PlanDto> dtoShippingTmw = planDao.searchSubscribeShippingTmw();

		ArrayList<ArrayList<String>> dataSetSubscribe = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < dtoSubscribe.size(); i++) {
			SubscribeDto Subscribedto = dtoSubscribe.get(i);
			PlanDto PlanDeliverydatedto = dtoPlanDeliverydate.get(i);
			PlanDto ShippingTmwdto = dtoShippingTmw.get(i);
			ArrayList<String> row = new ArrayList<String>();

			row.add("'" + Integer.toString(Subscribedto.getScode()) + "'");
			row.add("'" + Subscribedto.getUserid() + "'");
			row.add("'" + dateFormat.format(Subscribedto.getSubscribedate()) + "'");
			row.add("'" + AddDate(dateFormat.format(Subscribedto.getSubscribedate()), 0, 1, 0) + "'");
			row.add("' 일정 보기 '");
			if (PlanDeliverydatedto.getDeliverydate() == null) {
				row.add("'배송 기록 X'");
			} else {
				row.add("'" + dateFormat.format(PlanDeliverydatedto.getDeliverydate()) + "'");
			}
			if (ShippingTmwdto.getName().equals("NULL")) {
				row.add("'배송 품목 X'");
			} else {
				row.add("'" + ShippingTmwdto.getName() + "'");
			}
			row.add("'" + Integer.toString(PlanDeliverydatedto.getPlcode()) + "'");

			dataSetSubscribe.add(row);
		}
		return dataSetSubscribe;
	}
	
	private String AddDate(String strDate, int year, int month, int day) throws Exception {

		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();

		Date dt = dtFormat.parse(strDate);

		cal.setTime(dt);

		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DATE, day);

		return dtFormat.format(cal.getTime());
	}

}
