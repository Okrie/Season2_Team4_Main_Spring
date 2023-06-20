package com.springlec.base.service.admin;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.ManageDao;
import com.springlec.base.dao.admin.ProductDao;
import com.springlec.base.model.admin.DataSetProduct;
import com.springlec.base.model.admin.ManageDto;
import com.springlec.base.model.admin.ProductDto;

@Service
public class ProductFindServiceImpl implements ProductFindService {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	ManageDao manageDao;
	
	@Override
	public ArrayList<DataSetProduct> findProduct(String pcode) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<DataSetProduct> dataSetProduct = new ArrayList<>();
		ArrayList<ProductDto> dtoProduct = productDao.findProduct(pcode);
		ArrayList<ManageDto> dtoManage = manageDao.findProductManage(pcode);
		
		Timestamp insertdate = dtoProduct.get(0).getInsertdate();
		Timestamp updatedate = dtoManage.get(0).getUpdatedate();
		

		String conditionInsert = "";
		if (insertdate == null) {
			conditionInsert = "입력을 누르시면 자동 완성됩니다.";
		} else {
			conditionInsert = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(insertdate);
		}

		String conditionUpdate = "";
		if (updatedate == null) {
			conditionUpdate = "수정을 누르시면 자동 완성됩니다.";
		} else {
			conditionUpdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(updatedate);
		}

		DataSetProduct product = new DataSetProduct();
		product.setPcode(pcode);
		product.setName(dtoProduct.get(0).getName());
		product.setCategory(dtoProduct.get(0).getCategory());
		product.setRice(dtoProduct.get(0).getRice());
		product.setCook1(dtoProduct.get(0).getCook1());
		product.setCook2(dtoProduct.get(0).getCook2());
		product.setCook3(dtoProduct.get(0).getCook3());
		product.setSoup(dtoProduct.get(0).getSoup());
		product.setPhoto(dtoProduct.get(0).getPhoto());
		product.setStock(dtoManage.get(0).getStock());
		product.setPrice(dtoManage.get(0).getPrice());
		product.setCalories(dtoProduct.get(0).getCalories());
		product.setConditionInsert(conditionInsert);
		product.setConditionUpdate(conditionUpdate);
		product.setInvalidate(dtoManage.get(0).getInvalidate());

		dataSetProduct.add(product);

		// dataSetProduct에 모든 값들이 들어있습니다.

		
		return dataSetProduct;
	}

}
