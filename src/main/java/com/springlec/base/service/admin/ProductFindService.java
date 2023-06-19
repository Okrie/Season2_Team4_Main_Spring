package com.springlec.base.service.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.DataSetProduct;

public interface ProductFindService {
	public ArrayList<DataSetProduct> findProduct(String pcode) throws Exception;
}
