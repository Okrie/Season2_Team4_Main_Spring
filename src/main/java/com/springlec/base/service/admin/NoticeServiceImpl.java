package com.springlec.base.service.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.admin.NoticeDao;
import com.springlec.base.model.admin.NoticeDto;

@Service
@Transactional(rollbackFor = Exception.class) // rollback을 안하면 data가 꼬인다.
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;


	@Override
	public ArrayList<ArrayList<String>> searchNotice() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<NoticeDto> dtoNotice = noticeDao.searchNotice();
		
		ArrayList<ArrayList<String>> dataSetNotice = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < dtoNotice.size(); i++) {
			NoticeDto noticeDto = dtoNotice.get(i);
			ArrayList<String> row = new ArrayList<String>();
			row.add("'" + Integer.toString(noticeDto.getSeq()) + "'");
			row.add("'" + noticeDto.getAdminid() + "'");
			row.add("'" + (noticeDto.getInsertdate() != null ? dateFormat.format(noticeDto.getInsertdate()) : "") + "'");
			if (noticeDto.getInvalidate() == 1) {
				row.add("'유효한 글'");
			} else {
				row.add("'삭제된 글'");
			}
			row.add("'" + noticeDto.getTitle() + "'");
			row.add("'" + noticeDto.getContext() + "'");
			row.add("'" + (noticeDto.getUpdatedate() != null ? dateFormat.format(noticeDto.getUpdatedate()) : "") + "'");

			dataSetNotice.add(row);
		}
		
		return dataSetNotice;
	}

	@Override
	public int insertNotice(int seq, String adminid, String title, String context)
			throws Exception {
		// TODO Auto-generated method stub
		int result_01 = noticeDao.insertNotice_01(seq, adminid);
		int result_02 = noticeDao.insertNotice_02(seq, adminid, title, context);
		return result_01 + result_02;
	}

	@Override
	public NoticeDto searchNoticeseq() throws Exception {
		// TODO Auto-generated method stub
		return noticeDao.searchNoticeseq();
	}

	@Override
	public int modifyNotice(int seq, String adminid, String title, String context) throws Exception {
		// TODO Auto-generated method stub
		return noticeDao.modifyNotice(seq, adminid, title, context);
	}

	@Override
	public int deleteNotice(int seq) throws Exception {
		// TODO Auto-generated method stub
		return noticeDao.deleteNotice(seq);
	}

}
