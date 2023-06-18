package com.springlec.base.dao.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.NoticeDto;

public interface NoticeDao {
	public ArrayList<NoticeDto> searchNotice() throws Exception;

	public int insertNotice_01(int seq, String adminid) throws Exception;

	public int insertNotice_02(int seq, String adminid, String title, String context) throws Exception;

	public NoticeDto searchNoticeseq() throws Exception;

	public int modifyNotice(int seq, String adminid, String title, String context) throws Exception;

	public int deleteNotice(int seq) throws Exception;
}
