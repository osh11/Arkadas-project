package com.kh.notice.mainnotice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.mainnotice.model.vo.MainNotice;

public class MainNoticeDao {

	private Properties prop = new Properties();
	
	public MainNoticeDao() {
		String fileName = MainNoticeDao.class.getResource("/sql/notice/mainnotice/MainNotice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MainNotice> selectList(Connection conn, String user, String title, String content){
		ArrayList<MainNotice> list = new ArrayList<MainNotice>();
		
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
				System.out.println(rset.getString("NOTICE_SEQNO"));
				list.add(new MainNotice(rset.getString("NOTICE_SEQNO"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getString("NOTICE_CRT_USER"),
									rset.getString("NOTICE_READ_COUNT"),
									rset.getString("NOTICE_CRT_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int insertNotice(Connection conn, MainNotice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		System.out.println("test MainNotice :  "+ n.getNOTICE_CONTENT());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNOTICE_TITLE());
			pstmt.setString(2, n.getNOTICE_CONTENT());
			pstmt.setString(3, n.getNOTICE_CRT_USER());
			
			/* pstmt.setInt(3, Integer.parseInt(n.getMainNoticeWriter())); */
			
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
	
	public MainNotice selectNotice(Connection conn, int nno) {
		MainNotice n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new MainNotice(rset.getString("NOTICE_SEQNO"),
						rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"),
						rset.getString("NOTICE_CRT_USER"),
						rset.getString("NOTICE_READ_COUNT"),
						rset.getString("NOTICE_CRT_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
		
	}
	
	public int updateNotice(Connection conn, MainNotice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNOTICE_TITLE());
			pstmt.setString(2, n.getNOTICE_CONTENT());
			pstmt.setString(3, n.getNOTICE_SEQNO());
			
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
