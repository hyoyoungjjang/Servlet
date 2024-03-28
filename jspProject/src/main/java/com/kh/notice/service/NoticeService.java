package com.kh.notice.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.kh.common.JDBCTemplate.*;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	public ArrayList<Notice> selectNoticeList(){
		
		Connection conn = getConnection();
		ArrayList<Notice> noticeAll = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		return noticeAll;
		
		
		
		
		
		
	}
	
}
