package com.kh.notice.qnanotice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.kh.notice.qnanotice.model.vo.QnaNotice;

public class QnaNoticeDao {

	private Properties prop = new Properties();
	
	public QnaNoticeDao() {
		String fileName = QnaNoticeDao.class.getResource("/sql/notice/qnanotice/QnaNotice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	public ArrayList<QnaNotice> selectList(Connection conn, String user, String title, String content){
		ArrayList<QnaNotice> list = new ArrayList<QnaNotice>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getString("QNA_COUNT"));
				
				list.add(new QnaNotice(rset.getString("QNA_COUNT"),
									rset.getString("QNA_SEQNO"),
									rset.getString("QNA_TITLE"),
									rset.getString("QNA_CONTENT"),
									rset.getString("QNA_CRT_USER"),
									rset.getString("QNA_CRT_DATE"),
									rset.getString("QNA_COMMENT"),
									rset.getString("QNA_RESP_USER"),
									rset.getString("QNA_RESP_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int insertNotice(Connection conn, QnaNotice n,String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		System.out.println("test QnaNotice :  "+ n.getQNA_CONTENT());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getQNA_TITLE());
			pstmt.setString(2, n.getQNA_CONTENT());
			pstmt.setString(3, userId);
			//insertNotice=INSERT INTO QNA_NOTICE ( QNA_SEQNO , QNA_TITLE , QNA_CONTENT , QNA_CRT_USER , QNA_CRT_DATE ) 
			//VALUES ( (SELECT NVL(MAX(QNA_SEQNO), 0) + 1 FROM QNA_NOTICE) , ? , ? , ? , SYSDATE)
			/* pstmt.setInt(3, Integer.parseInt(n.getQnaNoticeWriter())); */
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
		
	}
	
	
	
	public QnaNotice selectNotice(Connection conn, int nno) {
		QnaNotice n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new QnaNotice(rset.getString("QNA_COUNT"),
						rset.getString("QNA_SEQNO"),
						rset.getString("QNA_TITLE"),
						rset.getString("QNA_CONTENT"),
						rset.getString("QNA_CRT_USER"),
						rset.getString("QNA_CRT_DATE"),
						rset.getString("QNA_COMMENT"),
						rset.getString("QNA_RESP_USER"),
						rset.getString("QNA_RESP_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
		
	}
	
	public int updateNotice(Connection conn, QnaNotice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getQNA_TITLE());
			pstmt.setString(2, n.getQNA_CONTENT());
			pstmt.setString(3, n.getQNA_SEQNO());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateComment(Connection conn, QnaNotice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getQNA_COMMENT());
			pstmt.setString(2, n.getQNA_RESP_USER());
			pstmt.setString(3, n.getQNA_SEQNO());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteNotice(Connection conn, int nno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
}
