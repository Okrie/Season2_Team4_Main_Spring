package com.springlec.base.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.ManageDao;

@Service
public class ProductUpdateServiceImpl implements ProductUpdateService {
	@Autowired
	ManageDao manageDao;

	@Override
	public int updateproduct(int invalidate, String pcode) throws Exception {
		// TODO Auto-generated method stub
		if (invalidate == 1) {
			return manageDao.deleteProductManage(pcode);
		} else if(invalidate ==0){
			return manageDao.recoverProductManage(pcode);
		}
		return 0;
	}

}
