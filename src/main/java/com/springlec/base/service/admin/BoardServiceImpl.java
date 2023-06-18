package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.admin.BoardDao;
import com.springlec.base.dao.admin.ProductDao;
import com.springlec.base.model.admin.BoardDto;

@Service
@Transactional(rollbackFor = Exception.class) // rollback을 안하면 data가 꼬인다.
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	ProductDao productDao;

	@Autowired
	BoardDao boardDao;
	
	
	@Override
	public ArrayList<ArrayList<String>> searchBoard() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<BoardDto> dtoBoard = boardDao.searchBoard();
		
		ArrayList<ArrayList<String>> dataSetBoard = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoBoard.size(); i++) {
			BoardDto boardDto = dtoBoard.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + Integer.toString(boardDto.getSeq()) + "'"); //0
			row.add("'" + Integer.toString(boardDto.getParent()) + "'"); //1
			row.add("'" + Integer.toString(boardDto.getLayer()) + "'");  //2

			if (boardDto.getAdminid() == null) { // 글쓴이가 유저일때.
				row.add("'user'"); //3
				row.add("'" + boardDto.getUserid() + "'"); //4
				row.add("'" + productDao.getPname(boardDto.getPcode()).getName() + "'"); //5
				row.add("'" + (boardDto.getInsertdate() != null ? dateFormat.format(boardDto.getInsertdate()) : "")
						+ "'"); //6
				if (boardDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				} //7
				row.add("'" + boardDto.getBwtitle() + "'"); //8
				row.add("'" + boardDto.getBwcontext() + "'"); //9
				if (boardDto.getBwimage() == null) {
					row.add("'" + boardDto.getBwimage() + "'");
				} else {
					row.add("' '");
				} //9
				row.add("'"
						+ (boardDto.getBwupdatedate() != null ? dateFormat.format(boardDto.getBwupdatedate()) : "")
						+ "'"); //10
			} else { // 글쓴이가 관리자 일때.
				row.add("'admin'"); //3
				row.add("'" + boardDto.getAdminid() + "'"); //4
				row.add("'" + productDao.getPname(boardDto.getPcode()).getName() + "'"); //5
				row.add("'" + (boardDto.getInsertdate() != null ? dateFormat.format(boardDto.getInsertdate()) : "")
						+ "'"); //6
				if (boardDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				} //7
				row.add("'" + boardDto.getBrtitle() + "'"); //8
				row.add("'" + boardDto.getBrcontext() + "'"); //9
				row.add("'이미지가 없습니다.'"); //10
				row.add("'"
						+ (boardDto.getBrupdatedate() != null ? dateFormat.format(boardDto.getBrupdatedate()) : "")
						+ "'"); //11
			}
			row.add("'" + boardDto.getPcode() + "'"); //12
			dataSetBoard.add(row);
		}
		
		return dataSetBoard;
	}

	@Override
	public int insertBoard(int seq, int parent, int layer, String pcode, String adminid, String brtitle, String brcontext)
			throws Exception {
		// TODO Auto-generated method stub
		int result_01 = boardDao.insertBoard_01(seq, parent, layer, pcode, adminid);
		int result_02 = boardDao.insertBoard_02(seq, adminid, brtitle, brcontext);
		return result_01 + result_02;
	}

	@Override
	public BoardDto searchBoardseq() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.searchBoardseq();
	}

	@Override
	public int modifyBoard(int seq, String adminid, String brtitle, String brcontext) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.modifyBoard(seq, adminid, brtitle, brcontext);
	} 

	@Override
	public int deleteBoard(int seq) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(seq);
	}

}
