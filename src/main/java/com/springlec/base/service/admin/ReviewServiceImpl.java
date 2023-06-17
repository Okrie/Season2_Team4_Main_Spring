package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.admin.ProductDao;
import com.springlec.base.dao.admin.ReviewDao;
import com.springlec.base.model.admin.ReviewDto;

@Service
@Transactional(rollbackFor = Exception.class) // rollback을 안하면 data가 꼬인다.
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ProductDao productDao;

	@Autowired
	ReviewDao reviewDao;


	@Override
	public ArrayList<ArrayList<String>> searchReview() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<ReviewDto> dtoReview = reviewDao.searchReview();
		
		ArrayList<ArrayList<String>> dataSetReview = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoReview.size(); i++) {
			ReviewDto reviewDto = dtoReview.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + Integer.toString(reviewDto.getSeq()) + "'"); //0
			row.add("'" + Integer.toString(reviewDto.getParent()) + "'"); //1
			row.add("'" + Integer.toString(reviewDto.getLayer()) + "'");  //2

			if (reviewDto.getAdminid() == null) { // 글쓴이가 유저일때.
				row.add("'user'"); //3
				row.add("'" + reviewDto.getUserid() + "'"); //4
				row.add("'" + productDao.getPname(reviewDto.getPcode()).getName() + "'"); //5
				row.add("'" + (reviewDto.getInsertdate() != null ? dateFormat.format(reviewDto.getInsertdate()) : "")
						+ "'"); //6
				if (reviewDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				} //7
				row.add("'" + reviewDto.getRwcontext() + "'"); //8
				if (reviewDto.getRwimage() == null) {
					row.add("'" + reviewDto.getRwimage() + "'");
				} else {
					row.add("' '");
				} //9
				row.add("'"
						+ (reviewDto.getRwupdatedate() != null ? dateFormat.format(reviewDto.getRwupdatedate()) : "")
						+ "'"); //10
			} else { // 글쓴이가 관리자 일때.
				row.add("'admin'"); //3
				row.add("'" + reviewDto.getAdminid() + "'"); //4
				row.add("'" + productDao.getPname(reviewDto.getPcode()).getName() + "'"); //5
				row.add("'" + (reviewDto.getInsertdate() != null ? dateFormat.format(reviewDto.getInsertdate()) : "")
						+ "'"); //6
				if (reviewDto.getInvalidate() == 1) {
					row.add("'유효한 글'");
				} else {
					row.add("'삭제된 글'");
				} //7
				row.add("'" + reviewDto.getRrcontext() + "'"); //8
				row.add("'이미지가 없습니다.'"); //9
				row.add("'"
						+ (reviewDto.getRrupdatedate() != null ? dateFormat.format(reviewDto.getRrupdatedate()) : "")
						+ "'"); //10
			}
			row.add("'" + reviewDto.getPcode() + "'"); //11
			dataSetReview.add(row);
		}
		
		return dataSetReview;
	}

	@Override
	public int insertReview(int seq, int parent, int layer, String pcode, String adminid, String rrcontext)
			throws Exception {
		// TODO Auto-generated method stub
		int result_01 = reviewDao.insertReview_01(seq, parent, layer, pcode, adminid);
		int result_02 = reviewDao.insertReview_02(seq, adminid, rrcontext);
		return result_01 + result_02;
	}

	@Override
	public ReviewDto searchReviewseq() throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.searchReviewseq();
	}

	@Override
	public int modifyReview(int seq, String adminid, String rrcontext) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.modifyReview(seq, adminid, rrcontext);
	}

	@Override
	public int deleteReview(int seq) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.deleteReview(seq);
	}

}
