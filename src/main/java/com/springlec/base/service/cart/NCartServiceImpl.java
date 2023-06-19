package com.springlec.base.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.cart.NCartDao;
import com.springlec.base.model.cart.NCartDto;


@Service
public class NCartServiceImpl implements NCartService {
	
		@Autowired
		NCartDao nCartDao;

	

		@Override
		public List<NCartDto> cartListDao() throws Exception {
			// TODO Auto-generated method stub
			return nCartDao.cartListDao();
		}



		@Override
		public void cartDeleteDao(int seq) throws Exception {
			// TODO Auto-generated method stub
			nCartDao.cartDeleteDao(seq);
		}
		
}
