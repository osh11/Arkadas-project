package com.kh.review.model;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private String supCode;
	private String reviewTitle;
	private String reviewContent;
	private String reviewWriter;
	private int reviewCount;
	private Date reviewDate;
	private String status;
	private String reviewPwd;
	
	private String image;
	
	public Review() {
		
	}
	
	
	
	public Review(int reviewNo, String supCode, String reviewTitle, String reviewWriter, Date reviewDate) {
		this.reviewNo = reviewNo;
		this.supCode = supCode;
		this.reviewTitle = reviewTitle;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
	}
	
	

	public Review(String reviewPwd, int reviewNo, String supCode, String reviewTitle, String reviewContent, String reviewWriter,
			Date reviewDate) {
		super();
		this.reviewPwd = reviewPwd;
		this.reviewNo = reviewNo;
		this.supCode = supCode;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
	}


	public Review(int reviewNo, String supCode, String reviewTitle, String reviewContent, String reviewWriter,
			int reviewCount, Date reviewDate, String status, String reviewPwd) {
		super();
		this.reviewNo = reviewNo;
		this.supCode = supCode;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewWriter = reviewWriter;
		this.reviewCount = reviewCount;
		this.reviewDate = reviewDate;
		this.status = status;
		this.reviewPwd = reviewPwd;
	}
	
	

	public Review(String supCode, String reviewTitle, String reviewContent, String reviewWriter, String reviewPwd) {
		super();
		this.supCode = supCode;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewWriter = reviewWriter;
		this.reviewPwd = reviewPwd;
	}




	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getSupCode() {
		return supCode;
	}

	public void setSupCode(String supCode) {
		this.supCode = supCode;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReviewPwd() {
		return reviewPwd;
	}

	public void setReviewPwd(String reviewPwd) {
		this.reviewPwd = reviewPwd;
	}
	
	
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[번호 : "+reviewNo+", 이미지 : "+image+", 제목 : "+reviewTitle+", 작성자 : "+reviewWriter+"]";
	}
	
	
}
