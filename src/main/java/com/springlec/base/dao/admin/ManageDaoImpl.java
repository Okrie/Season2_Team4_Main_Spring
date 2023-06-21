package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.ManageDto;

public class ManageDaoImpl implements ManageDao {

	SqlSession sqlSession;

	public static String namespace = "com.springlec.base.dao.admin.ManageDao";

	@Override
	public ArrayList<ManageDto> searchOrdersManage() {
		List<ManageDto> resultList = sqlSession.selectList(namespace + ".searchOrdersManage");
		ArrayList<ManageDto> manageList = new ArrayList<>(resultList);
		return manageList;
	}

	@Override
	public ManageDto searchUpdateManage(int ordercode) {
		return sqlSession.selectOne(namespace + ".searchUpdateManage", ordercode);
	}

	@Override
	public ArrayList<ManageDto> searchProductManage() {
		List<ManageDto> resultList = sqlSession.selectList(namespace + ".searchProductManage");
		ArrayList<ManageDto> manageList = new ArrayList<>(resultList);
		return manageList;

	}

	@Override
	public ArrayList<ManageDto> findProductManage(String pcode) {
		List<ManageDto> resultList = sqlSession.selectList(namespace + ".findProductManage", pcode);
		ArrayList<ManageDto> manageList = new ArrayList<>(resultList);
		return manageList;
	}

	@Override
	public int insertProductManage(String pcode, String adminid, int stock, int price) {
		return sqlSession.insert(namespace + ".insertProductManage");
	}

	@Override
	public int updateProductManage(String pcode, String adminid,  int stock, int price) {
		return sqlSession.update(namespace + ".updateProductManage");
	}

	@Override
	public int deleteProductManage(String pcode) {
		return sqlSession.update(namespace + ".deleteProductManage");
	}

	@Override
	public int recoverProductManage(String pcode) {
		return sqlSession.update(namespace + ".recoverProductManage");
	}

	@Override
	public ManageDto searchWarningManage() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchUpdateManage");
	}

}
