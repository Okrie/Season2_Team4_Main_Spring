package com.springlec.base.service.main;

import java.security.Timestamp;
import java.time.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlec.base.dao.main.NDHeaderCountDao;

public class NDHeaderCountDaoServiceImpl implements NDHeaderCountDaoService {

	@Autowired
	NDHeaderCountDao dao;
	
	@Override
	public int heartCountDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.heartCountDao(userid);
	}

	@Override
	public int cartCountDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.cartCountDao(userid);
	}

	@Override
	public int cartTotalPriceDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.cartTotalPriceDao(userid);
	}
	
	//remainDate관련 
	@Override
	public int remainDateDao(String userid, Timestamp subscribeDate) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.remainDateDao(userid, subscribeDate);
	}
	
    @Override
    public long calculateRemainingDays(String userid) {
        Timestamp subscribeDate = dao.subscribeDate(userid);
        
        LocalDateTime subscribeDateTime = subscribeDate.toLocalDateTime();
        LocalDateTime endDate = subscribeDateTime.plusDays(30);

        LocalDate currentDate = LocalDate.now();
        LocalDate endDateDate = endDate.toLocalDate();
        Duration duration = Duration.between(currentDate.atStartOfDay(), endDateDate.atStartOfDay());

        return duration.toDays();
    }


}
