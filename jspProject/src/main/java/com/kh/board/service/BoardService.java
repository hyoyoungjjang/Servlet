package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.vo.PageInfo;

public class BoardService {
	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDao().selectListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Board> selectList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public Board increaseCount( int boardNo) {
		
		Connection conn = getConnection();
		BoardDao bDao = new BoardDao();
		int result = bDao.increaseCount(conn, boardNo);
		
		Board b = null;
		if(result > 0) {
			commit(conn);
			b = bDao.selectBoard(conn, boardNo);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return b;
	}
	
	public ArrayList<Category> selectCategoryList(){
		Connection conn = getConnection();
		
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		return list;
		
	}
	
	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		BoardDao bDao = new BoardDao();
		int result =  bDao.insertBoard(conn, b);
		int result2 = 1;
		
		if(at != null) {
			result2 = bDao.insertAttachment(conn, at);
		}
		
		if(result > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result * result2;
	}
	
	public Attachment selectAttachment(int boardNo){
		Connection conn = getConnection();
		Attachment at = new BoardDao().selectAttachment(conn, boardNo);
		
		close(conn);
		
		return at;
	}
	
	public Board selectBoard(int bno) {
		Connection conn = getConnection();
		Board b = new BoardDao().selectBoard(conn, bno);
		
		close(conn);
		return b;
		
		
	}
	
	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.updateBoard(conn, b);
		
		int result2 = 1;
		if(at != null) {//새로운 첨부파일이 있을 때
			if(at.getFileNo() != 0) {//기존첨부파일이 있었을 경우
				result2 = bDao.updateAttachment(conn, at);
			} else {//기존첨부파일 없으므로 insert
				result2 = bDao.insertNewAttachment(conn, at);
			}	
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}
	
	
	
	
	
	
}