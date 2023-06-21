package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.ProductDto;

public interface ProductDao {
	public ArrayList<ProductDto> searchOrdersProduct() throws Exception;

	public ArrayList<ProductDto> searchProduct() throws Exception;

	public ArrayList<ProductDto> findProduct(String pcode) throws Exception;
	
	public int insertProduct(String pcode, String name, String category, String rice, String cook1, String cook2, String cook3,
			String soup, String photo, int calories) throws Exception;
	
	public int updateProduct(String pcode, String name, String category, String rice, String cook1, String cook2,
			String cook3, String soup, String photo, int calories) throws Exception;

	public ProductDto getPname(String pcode) throws Exception;
	
	public ProductDto getPcodeNew() throws Exception;

}
