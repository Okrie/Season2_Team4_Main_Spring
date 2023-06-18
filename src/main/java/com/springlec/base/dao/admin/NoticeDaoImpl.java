package com.springlec.base.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.admin.NoticeDto;

public class NoticeDaoImpl implements NoticeDao {

	SqlSession sqlsession;

	public static String namespace = "com.springlec.base.dao.admin.NoticeDao";

	@Override
	public ArrayList<NoticeDto> searchNotice() throws Exception {
		// TODO Auto-generated method stub
		List<NoticeDto> resultList = sqlsession.selectList(namespace + ".searchNotice");
		ArrayList<NoticeDto> noticeList = new ArrayList<>(resultList);
		return noticeList;
	}

	@Override
	public int insertNotice_01(int seq, String adminid) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertNotice_01");
	}

	@Override
	public int insertNotice_02(int seq, String adminid, String title, String context) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + ".insertNotice_02");
	}

	@Override
	public NoticeDto searchNoticeseq() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".searchNoticeseq");
	}

	@Override
	public int modifyNotice(int seq, String adminid, String title, String context) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".modifyNotice");
	}

	@Override
	public int deleteNotice(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + ".deleteNotice");
	}

}
