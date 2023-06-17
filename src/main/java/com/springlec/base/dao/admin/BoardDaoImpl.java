package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.BoardDto;

public class BoardDaoImpl implements BoardDao {
	
	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.BoardDao";
	
	@Override
	public ArrayList<BoardDto> searchBoard() throws Exception {
		// TODO Auto-generated method stub
		List<BoardDto> resultList = sqlsession.selectList(namespace + ".searchBoard");
		ArrayList<BoardDto> boardList =new ArrayList<>(resultList);
		return boardList;
	}

	@Override
	public int insertBoard_01(int seq, int parent, int layer, String pcode, String adminid) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertBoard_01");
	}

	@Override
	public int insertBoard_02(int seq, String adminid, String brtitle, String brcontext) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertBoard_02");
	}

	@Override
	public BoardDto searchBoardseq() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchBoardseq");
	}

	@Override
	public int modifyBoard(int seq, String adminid, String brtitle, String brcontext) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".modifyBoard");
	}

	@Override
	public int deleteBoard(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".deleteBoard");
	}

}
