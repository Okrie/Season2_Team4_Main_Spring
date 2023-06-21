package com.springlec.base.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.admin.ManageDao;
import com.springlec.base.dao.admin.ProductDao;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInsertServiceImpl implements ProductInsertService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ManageDao manageDao;
	
	@Override
	public int insertProduct(String pcode, String name, String category, String rice, String cook1, String cook2,
			String cook3, String soup, String photo, int calories, String adminid, int stock, int price) throws Exception {
		// TODO Auto-generated method stub
		
		if(rice.equals("")) {
			rice = null;
		}
		if(cook1.equals("")) {
			cook1 = null;
		}
		if(cook2.equals("")) {
			cook2 = null;
		}
		if(cook3.equals("")) {
			cook3 = null;
		}
		if(soup.equals("")) {
			soup = null;
		}
		System.out.println( "1"+pcode+ "1"+ name+ "1"+ category+"1"+  rice+"1"+  cook1+"1"+  cook2+"1"+
			 cook3+"1"+  soup+"1"+  photo+"1"+ Integer.toString(calories)  +"1"+  adminid+"1"+  Integer.toString(stock)+"1"+  Integer.toString(price));
		
		
		
		if (pcode.equals("입력을 누르시면 자동 완성됩니다.")) {
			pcode = productDao.getPcodeNew().getPcode();
			productDao.insertProduct(pcode, name, category, rice, cook1, cook2, cook3, soup, photo, calories);
			manageDao.insertProductManage(pcode, adminid, stock, price);
			return 1;
		} else {
			productDao.updateProduct(pcode, name, category, rice, cook1, cook2, cook3, soup, photo,calories);
			manageDao.updateProductManage(pcode, adminid, stock, price);
			return 1;
		}
	}

}
