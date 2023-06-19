package com.springlec.base.service.orders;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springlec.base.dao.orders.NOrdersDao;
import com.springlec.base.model.orders.NOrdersDto;

@Service
public class NOrdersServiceImpl implements NOrdersService {

	NOrdersDao nOrdersDao;
	
	@Override
	public NOrdersDto productInfoDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return nOrdersDao.productInfoDao(pcode);
	}

	@Override
	public NOrdersDto userInfoDao(String userid) throws Exception {
		// TODO Auto-generated method stub
		return nOrdersDao.userInfoDao(userid);
	}

	@Override
	public void insertOrdersDao(String userid, String pcoude, String count, String address) throws Exception {
		// TODO Auto-generated method stub
		nOrdersDao.insertOrdersDao(userid, pcoude, count, address);
	}

	@Override
	public List<NOrdersDto> cartOrdersDao(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return nOrdersDao.cartOrdersDao(pcode);
	}

}
