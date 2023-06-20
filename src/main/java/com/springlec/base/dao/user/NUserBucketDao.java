package com.springlec.base.dao.user;

public interface NUserBucketDao {
	// 유저 카트 추가
	public int userCartIn(String pcode, String userid) throws Exception;
	// 유저 위시리스트 추가
	public int userWishlistIn(String pcode, String userid) throws Exception;
}
