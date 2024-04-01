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
	
	public int insertNotice(Notice n) {
		
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Notice increaseCount(int noticeNo) {
		Connection conn = getConnection();
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		Notice n = null;
		if(result > 0) {
			commit(conn);
			n = new NoticeDao().selectNotice(conn, noticeNo);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return n;
	}
	
	public Notice selecNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		close(conn);
		return n;
	}
	
	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		int result = 0;
		result = new NoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result = 0;
		result = new NoticeDao().deleteNotice(conn, noticeNo);
		

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
		
	}
}
