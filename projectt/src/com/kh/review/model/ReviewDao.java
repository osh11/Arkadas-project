package com.kh.review.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

public class ReviewDao {
	private Properties prop = new Properties();
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/review/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Review> selectList(Connection conn, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (pi.getCurrPage()-1)*pi.getReviewLimit()+1;
		int endRow = startRow + pi.getReviewLimit()-1;
		System.out.println("startRow : "+startRow);
		System.out.println("endRow : "+endRow);
		String sql = prop.getProperty("selectList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review review = new Review(rset.getInt("REVIEW_NO"),
											  rset.getString("SUPPLEMENTS_CODE"),
											  rset.getString("REVIEW_TITLE"),
											  rset.getString("REVIEW_WRITER"),
											  rset.getDate("REVIEW_DATE"));
				review.setImage(rset.getString("CHANGE_NAME"));
				list.add(review);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Review> selectList(Connection conn, PageInfo pi, String keyword) {
		// TODO Auto-generated method stub
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (pi.getCurrPage()-1)*pi.getReviewLimit()+1;
		int endRow = startRow + pi.getReviewLimit()-1;
		System.out.println("startRow : "+startRow);
		System.out.println("endRow : "+endRow);
		String sql = prop.getProperty("selectListWithKeyword");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,keyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review review = new Review(rset.getInt("REVIEW_NO"),
											  rset.getString("SUPPLEMENTS_CODE"),
											  rset.getString("REVIEW_TITLE"),
											  rset.getString("REVIEW_WRITER"),
											  rset.getDate("REVIEW_DATE"));
				review.setImage(rset.getString("CHANGE_NAME"));
				list.add(review);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public int insertReview(Connection conn, Review review) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getSupCode());
			pstmt.setString(2, review.getReviewWriter());
			pstmt.setString(3, review.getReviewTitle());
			pstmt.setString(4, review.getReviewContent());
			pstmt.setString(5, review.getReviewPwd());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int increaseCount(Connection conn, int rno) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,rno);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Review selectReview(Connection conn, int rno) {
		// TODO Auto-generated method stub
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				review = new Review(rset.getString("REVIEW_PWD"),
									rset.getInt("REVIEW_NO"),
									rset.getString("SUPPLEMENTS_CODE"),
									rset.getString("REVIEW_TITLE"),
									rset.getString("REVIEW_CONTENT"),
									rset.getString("REVIEW_WRITER"),
									rset.getDate("REVIEW_DATE"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return review;
	}

	public int updateReview(Review review, Connection conn) {
		// TODO Auto-generated method stub
		System.out.println("updateReview 진입");
		System.out.println(review);
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getSupCode());
			pstmt.setString(2, review.getReviewTitle());
			pstmt.setString(3, review.getReviewContent());
			pstmt.setString(4, review.getReviewWriter());
			pstmt.setString(5, review.getReviewPwd());
			pstmt.setInt(6, review.getReviewNo());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertFile(Connection conn, Attachment file) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertImage");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, file.getOriginName());
			pstmt.setString(2, file.getChangeName());
			pstmt.setString(3, file.getFilePath());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Attachment selectImage(Connection conn, int rno) {
		// TODO Auto-generated method stub
		Attachment image = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				image = new Attachment();
				image.setFileNo(rset.getInt("FILE_NO"));
				image.setOriginName(rset.getString("ORIGIN_NAME"));
				image.setChangeName(rset.getString("CHANGE_NAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return image;
	}

	public int updateImage(Connection conn, Attachment image) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateImage");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, image.getChangeName());
			pstmt.setString(2, image.getOriginName());
			pstmt.setString(3, image.getFilePath());
			pstmt.setInt(4, image.getFileNo());
			
			result = pstmt.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int getListCount(Connection conn) {
		// TODO Auto-generated method stub
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()){
				listCount = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	
	public int getListCount(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String sql = prop.getProperty("getListCountWithKeyword");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,keyword);
			rset = pstmt.executeQuery();
			if(rset.next()){
				listCount = rset.getInt("a");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public int deleteReview(Connection conn, int rno) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteImage(Connection conn, int rno) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteImage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
}
