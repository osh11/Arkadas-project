package com.kh.notice.faqnotice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.faqnotice.model.vo.FaqNotice;
import com.kh.notice.mainnotice.model.vo.MainNotice;

public class FaqNoticeDao {

	private Properties prop = new Properties();
	
	public FaqNoticeDao() {
		String fileName = FaqNoticeDao.class.getResource("/sql/notice/faqnotice/FaqNotice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<FaqNotice> selectList(Connection conn, String user, String title, String content){
		ArrayList<FaqNotice> list = new ArrayList<FaqNotice>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, title);
			pstmt.setString(3, content);

			System.out.println(user + "," + title + "," + content);
				
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getString("FAQ_SEQNO"));
				list.add(new FaqNotice(rset.getString("FAQ_SEQNO"),
									rset.getString("FAQ_TITLE"),
									rset.getString("FAQ_CONTENT"),
									rset.getString("FAQ_CRT_USER"),
									rset.getString("FAQ_READ_COUNT"),
									rset.getString("FAQ_CRT_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int insertNotice(Connection conn, FaqNotice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		System.out.println("test FaqNotice :  "+ n.getFAQ_CONTENT());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getFAQ_TITLE());
			pstmt.setString(2, n.getFAQ_CONTENT());
			pstmt.setString(3, n.getFAQ_CRT_USER());
			
			/* pstmt.setInt(3, Integer.parseInt(n.getFaqNoticeWriter())); */
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
		
	}
	
	public int increaseCount(Connection conn, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
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
	
	public FaqNotice selectNotice(Connection conn, int nno) {
		FaqNotice n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new FaqNotice(rset.getString("FAQ_SEQNO"),
						rset.getString("FAQ_TITLE"),
						rset.getString("FAQ_CONTENT"),
						rset.getString("FAQ_CRT_USER"),
						rset.getString("FAQ_READ_COUNT"),
						rset.getString("FAQ_CRT_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
		
	}
	
	public int updateNotice(Connection conn, FaqNotice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getFAQ_TITLE());
			pstmt.setString(2, n.getFAQ_CONTENT());
			pstmt.setString(3, n.getFAQ_SEQNO());
			
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
