package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.ProductDto;

public class ProductDaoImpl implements ProductDao {

	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.ProductDao";

	@Override
	public ArrayList<ProductDto> searchOrdersProduct() throws Exception {
		// TODO Auto-generated method stub
		List<ProductDto> resultList = sqlsession.selectList(namespace + ".searchOrdersProduct");
		ArrayList<ProductDto> productList = new ArrayList<>(resultList);
		return productList;
	}

	@Override
	public ArrayList<ProductDto> searchProduct() throws Exception {
		// TODO Auto-generated method stub
		List<ProductDto> resultList = sqlsession.selectList(namespace + ".searchProduct");
		ArrayList<ProductDto> productList = new ArrayList<>(resultList);
		return productList;
	}

	@Override
	public ArrayList<ProductDto> findProduct(String pcode) throws Exception {
		// TODO Auto-generated method stub
		List<ProductDto> resultList = sqlsession.selectList(namespace + ".findProduct", pcode);
		ArrayList<ProductDto> productList = new ArrayList<>(resultList);
		return productList;
	}

	@Override
	public int insertProduct(String pcode, String name, String category, String rice, String cook1, String cook2, String cook3,
			String soup, String photo, int calories) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertProduct");
	}

	@Override
	public int updateProduct(String pcode, String name, String category, String rice, String cook1, String cook2,
			String cook3, String soup, String photo, int calories) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".updateProduct");
	}

	@Override
	public ProductDto getPname(String pcode) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".getPname", pcode);
	}

	@Override
	public ProductDto getPcodeNew() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".getPcodeNew");
	}

}
