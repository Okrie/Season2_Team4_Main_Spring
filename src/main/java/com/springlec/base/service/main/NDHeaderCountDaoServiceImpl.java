package com.springlec.base.service.main;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.main.NDHeaderCountDao;

@Service
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
	public String cartTotalPriceDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.cartTotalPriceDao(userid);
	}
	
	//remainDate관련 
	@Override
	public String remainDateDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		Timestamp subscribeDate = dao.remainDateDao(userid);
        
        LocalDateTime subscribeDateTime = subscribeDate.toLocalDateTime();
        LocalDateTime endDate = subscribeDateTime.plusDays(30);

        LocalDate currentDate = LocalDate.now();
        LocalDate endDateDate = endDate.toLocalDate();
        Duration duration = Duration.between(currentDate.atStartOfDay(), endDateDate.atStartOfDay());
        
        long remainingDays = duration.toDays();
        
        String remainDate= String.valueOf(remainingDays);
        
        return remainDate;
	}


}
