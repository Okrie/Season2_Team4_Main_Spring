package com.springlec.base.dao.user;

import java.util.List;

import com.springlec.base.model.user.NUserWishlistDto;

public interface NUserBucketDao {
	// 유저 카트 추가
	public int userCartIn(String pcode, String userid, int count) throws Exception;
	// 유저 위시리스트 추가
	public int userWishlistIn(String pcode, String userid) throws Exception;
	// 유저 위시리스트 삭제
	public int userWishlistDelete(String pcode, String userid) throws Exception;
	// 유저 위시리스트 검색
	public List<NUserWishlistDto> userWishList(String userid) throws Exception;
}
