package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.ManageDto;

public class ManageDaoImpl implements ManageDao {

	SqlSession sqlSession;
	
	public static String namespace = "com.springlec.base.dao.admin.ManageDao";
	
	@Override
    public ManageDto searchOrders() {
        return sqlSession.selectOne("searchOrders");
    }

    @Override
    public ManageDto searchUpdate(int ordercode) {
        return sqlSession.selectOne("searchUpdate", ordercode);
    }

    @Override
    public ArrayList<ManageDto> searchProduct() {
    	List<ManageDto> resultList = sqlSession.selectList(namespace + ".searchProduct");
		ArrayList<ManageDto> manageList =new ArrayList<>(resultList);
		return manageList;
    	
    }

    @Override
    public ArrayList<ManageDto> findProduct(String pcode) {
    	List<ManageDto> resultList = sqlSession.selectList(namespace + ".findProduct",pcode);
		ArrayList<ManageDto> manageList =new ArrayList<>(resultList);
		return manageList;
    }

    @Override
    public int insertProduct(String adminid, int stock, int price) {
        return sqlSession.insert(namespace + ".insertProduct");
    }

    @Override
    public int updateProduct(String adminid, String pcode, int stock, int price) {
        return sqlSession.update(namespace + ".updateProduct");
    }

    @Override
    public int deleteProduct(String pcode) {
        return sqlSession.update(namespace + ".deleteProduct");
    }

    @Override
    public int recoverProduct(String pcode) {
        return sqlSession.update(namespace + ".recoverProduct");
    }

}
