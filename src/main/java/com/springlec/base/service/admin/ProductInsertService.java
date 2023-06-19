package com.springlec.base.service.admin;

public interface ProductInsertService {
	public int insertProduct(String pcode, String name, String category, String rice, String cook1, String cook2,
			String cook3, String soup, String photo, int calories, String adminid, int stock, int price) throws Exception;

}
