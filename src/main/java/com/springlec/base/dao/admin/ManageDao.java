package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.ManageDto;

public interface ManageDao {
	// 오더관련 재고 불러오기 : admin_searchOrders.do
    public ManageDto searchOrders();

    // 오더관련 모든 정보 불러오기 : admin_searchOrders.do
    public ManageDto searchUpdate(int ordercode);

    // 테이블 제품 관련 정보 불러오기 : admin_searchProduct.do
    public ArrayList<ManageDto> searchProduct();

    // 업데이트 관련 상품 관련 정보 불러오기 : admin_findproduct.do
    public ArrayList<ManageDto> findProduct(String pcode);

    // 데이터 입력하기 : admin_insertproduct.do
    public int insertProduct(String adminid, int stock, int price);

    // 데이터 수정하기 : admin_updateproduct.do
    public int updateProduct(String adminid, String pcode, int stock, int price);

    // 상품 관련 정보 삭제하기 : admin_deleteproduct.do
    public int deleteProduct(String pcode);

    // 상품 관련 정보 복구하기 : admin_deleteproduct.do
    public int recoverProduct(String pcode);
}
