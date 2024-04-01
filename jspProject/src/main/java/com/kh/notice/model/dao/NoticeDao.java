package com.kh.notice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	private Properties prop = new Properties();
	public NoticeDao() {
		String filePath = NoticeDao.class.getResource("/db/sql/notice-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn){
		
		ArrayList<Notice> noticeAll = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice(
						rset.getInt("notice_no"),
						rset.getString("notice_title"),
						rset.getString("user_id"),
						rset.getInt("count"),
						rset.getDate("create_date")
						);
				noticeAll.add(n);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return noticeAll;
	}
	
	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, Integer.parseInt(n.getNoticeWriter()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int increaseCount(Connection conn , int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	
	public Notice selectNotice(Connection conn, int noticeNo){
			
			Notice n = new Notice();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectNotice");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, noticeNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					n = new Notice(
							rset.getInt("notice_no"),
							rset.getString("notice_title"),
							rset.getString("notice_content"),
							rset.getString("user_id"),
							rset.getDate("create_date")
							);
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return n;
		}

	public int updateNotice(Connection conn, Notice n) {
			
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql =prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNO());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
		

	

	

	
	
}
