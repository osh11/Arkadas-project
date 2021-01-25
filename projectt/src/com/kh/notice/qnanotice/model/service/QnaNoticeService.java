package com.kh.notice.qnanotice.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;


import com.kh.notice.qnanotice.model.dao.QnaNoticeDao;
import com.kh.notice.qnanotice.model.vo.QnaNotice;

public class QnaNoticeService {
	
	/**
	 * 1. 공지사항 리스트 조회용 서비스
	 * @return	조회된 전체 공지사항 리스트
	 */
	public ArrayList<QnaNotice> selectList(String user, String title, String content){
		Connection conn = getConnection();
		
		ArrayList<QnaNotice> list = new QnaNoticeDao().selectList(conn, user, title, content);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 2. 공지사항 글 작성용 서비스
	 * @param n		사용자가 작성한 글제목, 작성자아이디, 내용이 담겨있는 notice객체
	 * @return		처리된 행의 갯수
	 */
	public int insertNotice(QnaNotice n,String userId) {
		Connection conn = getConnection();
		int result = new QnaNoticeDao().insertNotice(conn, n,userId);
		// MainNoticeDao 클래스로 가서 insertNotice 메소드 완성시키고 오자
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 3. 공지사항 상세보기용 서비스
	 * @param nno		현재 클릭된 공지사항 번호
	 * @return			해당 번호의 공지사항 조회 객체
	 */
	public QnaNotice selectNotice(int nno) {
		
		Connection conn = getConnection();
		

		QnaNotice n = new QnaNoticeDao().selectNotice(conn, nno);

		close(conn);
		
		return n;
	}
	
	/**
	 * 4. 수정용 공지사항 조회하기
	 * @param nno		수정하고자 하는 공지사항 글 번호
	 * @return			해당 글번호의 공지사항
	 */
	public QnaNotice selectUpdateNotice(int nno) {
		Connection conn = getConnection();
		
		QnaNotice n = new QnaNoticeDao().selectNotice(conn, nno);
		
		close(conn);
		
		return n;
	}
	
	/**
	 * 5. 공지사항 수정용 서비스
	 * @param n
	 * @return
	 */
	public int updateNotice(QnaNotice n) {
		Connection conn = getConnection();
		
		int result = new QnaNoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int updateComment(QnaNotice n) {
		Connection conn = getConnection();
		
		int result = new QnaNoticeDao().updateComment(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteNotice(int nno) {
		Connection conn = getConnection();
		
		int result = new QnaNoticeDao().deleteNotice(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
