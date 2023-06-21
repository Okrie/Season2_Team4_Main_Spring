package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.ManageDto;

public interface ManageDao {
	// 오더관련 재고 불러오기 : admin_searchOrders.do
    public ArrayList<ManageDto> searchOrdersManage();

    // 오더관련 모든 정보 불러오기 : admin_searchOrders.do
    public ManageDto searchUpdateManage(int ordercode);

    // 테이블 제품 관련 정보 불러오기 : admin_searchProduct.do
    public ArrayList<ManageDto> searchProductManage();

    // 업데이트 관련 상품 관련 정보 불러오기 : admin_findproduct.do
    public ArrayList<ManageDto> findProductManage(String pcode);

    // 데이터 입력하기 : admin_insertproduct.do
    public int insertProductManage(String pcode, String adminid, int stock, int price);

    // 데이터 수정하기 : admin_updateproduct.do
    public int updateProductManage(String pcode, String adminid,  int stock, int price);

    // 상품 관련 정보 삭제하기 : admin_deleteproduct.do
    public int deleteProductManage(String pcode);

    // 상품 관련 정보 복구하기 : admin_deleteproduct.do
    public int recoverProductManage(String pcode);
    
    // 재고 위험 개수 알려주기 : adminMain
    public ManageDto searchWarningManage();
}
