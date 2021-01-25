package com.kh.review.model;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

public class ReviewService {

	public ArrayList<Review> selectList(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Review> list = new ReviewDao().selectList(conn,pi);
		close(conn);
		return list;
	}
	
	public ArrayList<Review> selectList(PageInfo pi, String keyword) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Review> list = new ReviewDao().selectList(conn,pi,keyword);
		close(conn);
		return list;
	}

	public int insertReview(Review review) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new ReviewDao().insertReview(conn,review);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Review selectReview(int rno) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result = new ReviewDao().increaseCount(conn,rno);
		Review review = null;
		if(result>0) {
			commit(conn);
			review = new ReviewDao().selectReview(conn,rno);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return review;
	}

	public Review selectUpdateReview(int rno) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Review review = new ReviewDao().selectReview(conn, rno);
		close(conn);
		return review;
	}

	public int updateReview(Review review, Attachment image) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		System.out.println("update할 review : "+review);
		int result = new ReviewDao().updateReview(review,conn);
		int result2 = 1;
		System.out.println("result1 : "+result);
		if(image!=null) {
			if(image.getFileNo()!=0) {
				result2 = new ReviewDao().updateImage(conn,image); 
				System.out.println("result2 : "+result2);
			}
		}
		
		if(result>0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result*result2;
	}

	public int insertFile(Attachment file) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertFile(conn,file);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Attachment selectImage(int rno) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Attachment image = new ReviewDao().selectImage(conn,rno);
		close(conn);
		return image;
	}

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new ReviewDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public int getListCount(String keyword) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int listCount = new ReviewDao().getListCount(conn,keyword);
		close(conn);
		return listCount;
	}

	public int deleteReview(int rno) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result1 = new ReviewDao().deleteReview(conn,rno);
		int result2 = new ReviewDao().deleteImage(conn,rno);
		
		if(result1>0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1;
	}

	


}
