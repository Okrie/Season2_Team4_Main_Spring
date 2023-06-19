package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.ManageDao;
import com.springlec.base.dao.admin.ProductDao;
import com.springlec.base.model.admin.ManageDto;
import com.springlec.base.model.admin.ProductDto;

@Service
public class ProductSearchServiceImpl implements ProductSearchService {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ManageDao manageDao;

	@Override
	public ArrayList<ArrayList<String>> searchProduct() throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<ProductDto> dtoproduct = productDao.searchProduct();
		ArrayList<ManageDto> dtoManage = manageDao.searchProductManage();
		
		ArrayList<ArrayList<String>> dataSetProduct = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoproduct.size(); i++) {
			ProductDto productDto = dtoproduct.get(i);
			ManageDto manageDto = dtoManage.get(i);
			ArrayList<String> row = new ArrayList<String>();
			
			
			
			row.add("'" + productDto.getPcode() + "'");
			row.add("'" + productDto.getName() + "'");
			row.add("'" + productDto.getCategory() + "'");
			row.add("'" + productDto.getRice() + "'");
			if (productDto.getCook1() != null) {
				row.add("'" + productDto.getCook1() + "'");
			} else {
				row.add("'해당사항없음'"); 				
			}
			if (productDto.getCook2() != null) {
				row.add("'" + productDto.getCook2() + "'");
			} else {
				row.add("'해당사항없음'"); 				
			}
			if (productDto.getCook3() != null) {
				row.add("'" + productDto.getCook3() + "'");
			} else {
				row.add("'해당사항없음'"); 				
			}
			if (productDto.getSoup() != null) {
				row.add("'" + productDto.getSoup() + "'");
			} else {
				row.add("'해당사항없음'"); 				
			}
			row.add("'" + Integer.toString(manageDto.getStock()) + "세트'");
			row.add("'" + String.format("%,d 원",manageDto.getPrice()) + "'");
			row.add("'" + dateFormat.format(productDto.getInsertdate()) + "'");
			row.add("'" + dateFormat.format(manageDto.getUpdatedate()) + "'");
			if (manageDto.getInvalidate() != 0) {
				row.add("'판매 상품'");
			} else {
				row.add("'비판매 상품'"); 
			}
			dataSetProduct.add(row);
		}
		return dataSetProduct;
	}

}
