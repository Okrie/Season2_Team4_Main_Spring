package com.springlec.base.service.user;

import java.util.List;

import com.springlec.base.model.user.NUserWishlistDto;

public interface NUserBucketService {
	// 유저 카트 추가
	public int userCartIn(String pcode, String userid, int count) throws Exception;
	// 유저 위시리스트 추가
	public int userWishlistIn(String pcode, String userid) throws Exception;
	public int userWishlistDelete(String pcode, String userid) throws Exception;
	public List<NUserWishlistDto> userWishList(String userid) throws Exception;
}
