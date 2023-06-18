package com.springlec.base.service.admin;

import java.util.ArrayList;

import com.springlec.base.model.admin.NoticeDto;

public interface NoticeService {
	public ArrayList<ArrayList<String>> searchNotice() throws Exception;

	public int insertNotice(int seq, String adminid, String title, String context) throws Exception;

	public NoticeDto searchNoticeseq() throws Exception;

	public int modifyNotice(int seq, String adminid, String title, String context) throws Exception;

	public int deleteNotice(int seq) throws Exception;
}
