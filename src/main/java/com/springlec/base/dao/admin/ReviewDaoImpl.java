package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.ReviewDto;

public class ReviewDaoImpl implements ReviewDao {

	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.ReviewDao";

	@Override
	public ArrayList<ReviewDto> searchReview() throws Exception {
		// TODO Auto-generated method stub
		List<ReviewDto> resultList = sqlsession.selectList(namespace + ".searchReview");
		ArrayList<ReviewDto> reviewList =new ArrayList<>(resultList);
		return reviewList;
	}

	@Override
	public int insertReview_01(int seq, int parent, int layer, String pcode, String adminid) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertReview_01");
	}

	@Override
	public int insertReview_02(int seq, String adminid, String rrcontext) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertReview_02");
	}

	@Override
	public ReviewDto searchReviewseq() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchReviewseq");
	}

	@Override
	public int modifyReview(int seq, String adminid, String rrcontext) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".modifyReview");
	}

	@Override
	public int deleteReview(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".deleteReview");
	}

}
