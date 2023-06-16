package com.springlec.base.dao.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.ReviewDto;

public class ReviewDaoImpl implements ReviewDao {

	SqlSession sqlsession;

	public static String namespace = "com.spring.base.dao.admin.ReviewDao";

	@Override
	public List<ReviewDto> searchBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + ".searchBoard");
	}

	@Override
	public int insertBoard_01(int seq, String parent, String layer, String pcode, String adminid) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertBoard_01");
	}

	@Override
	public int insertBoard_02(int seq, String adminid, String context) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertBoard_02");
	}

	@Override
	public ReviewDto searchBoardseq() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchBoardseq");
	}

	@Override
	public int modifyBoard(int seq, String adminid, String context) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".modifyBoard");
	}

	@Override
	public int deleteBoard(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".deleteBoard");
	}

}
