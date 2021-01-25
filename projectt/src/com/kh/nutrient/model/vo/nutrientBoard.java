package com.kh.nutrient.model.vo;

import java.sql.Date;

public class nutrientBoard {
	private int nutrientBoardNo;			// 게시글 고유 번호
	private int nutrientBoardType;			// 게시글 타입(1.일반게시판, 2.사진게시판)
	private String nutrientcategory;		// 게시글 분류(10 ~ 20)
	private String nutrientBoardTitle;		// 게시글 제목
	private String nutrientBoardContent;	// 게시글 내용
	private String nutrientBoardWriter;		// 게시글 작성자 (번호 또는 이름)
	private int nutrientCount;				// 게시글 조회수
	private Date nutrientCreateDate;		// 게시글 작성일
	private String nutrientStatus;			// 게시글 상태값(Y, N)
	
	public nutrientBoard() {
		
	}
	
	public nutrientBoard(int nutrientBoardNo, String nutrientcategory, String nutrientBoardTitle,
			String nutrientBoardContent, String nutrientBoardWriter, int nutrientCount, Date nutrientCreateDate) {
		super();
		this.nutrientBoardNo = nutrientBoardNo;
		this.nutrientcategory = nutrientcategory;
		this.nutrientBoardTitle = nutrientBoardTitle;
		this.nutrientBoardContent = nutrientBoardContent;
		this.nutrientBoardWriter = nutrientBoardWriter;
		this.nutrientCount = nutrientCount;
		this.nutrientCreateDate = nutrientCreateDate;
	}

	public nutrientBoard(int nutrientBoardNo, String nutrientcategory, String nutrientBoardTitle,
			String nutrientBoardWriter, int nutrientCount, Date nutrientCreateDate) {
		super();
		this.nutrientBoardNo = nutrientBoardNo;
		this.nutrientcategory = nutrientcategory;
		this.nutrientBoardTitle = nutrientBoardTitle;
		this.nutrientBoardWriter = nutrientBoardWriter;
		this.nutrientCount = nutrientCount;
		this.nutrientCreateDate = nutrientCreateDate;
	}

	public nutrientBoard(int nutrientBoardNo, int nutrientBoardType, String nutrientcategory, String nutrientBoardTitle,
			String nutrientBoardContent, String nutrientBoardWriter, int nutrientCount, Date nutrientCreateDate,
			String nutrientStatus) {
		super();
		this.nutrientBoardNo = nutrientBoardNo;
		this.nutrientBoardType = nutrientBoardType;
		this.nutrientcategory = nutrientcategory;
		this.nutrientBoardTitle = nutrientBoardTitle;
		this.nutrientBoardContent = nutrientBoardContent;
		this.nutrientBoardWriter = nutrientBoardWriter;
		this.nutrientCount = nutrientCount;
		this.nutrientCreateDate = nutrientCreateDate;
		this.nutrientStatus = nutrientStatus;
	}

	public int getNutrientBoardNo() {
		return nutrientBoardNo;
	}

	public void setNutrientBoardNo(int nutrientBoardNo) {
		this.nutrientBoardNo = nutrientBoardNo;
	}

	public int getNutrientBoardType() {
		return nutrientBoardType;
	}

	public void setNutrientBoardType(int nutrientBoardType) {
		this.nutrientBoardType = nutrientBoardType;
	}

	public String getNutrientcategory() {
		return nutrientcategory;
	}

	public void setNutrientcategory(String nutrientcategory) {
		this.nutrientcategory = nutrientcategory;
	}

	public String getNutrientBoardTitle() {
		return nutrientBoardTitle;
	}

	public void setNutrientBoardTitle(String nutrientBoardTitle) {
		this.nutrientBoardTitle = nutrientBoardTitle;
	}

	public String getNutrientBoardContent() {
		return nutrientBoardContent;
	}

	public void setNutrientBoardContent(String nutrientBoardContent) {
		this.nutrientBoardContent = nutrientBoardContent;
	}

	public String getNutrientBoardWriter() {
		return nutrientBoardWriter;
	}

	public void setNutrientBoardWriter(String nutrientBoardWriter) {
		this.nutrientBoardWriter = nutrientBoardWriter;
	}

	public int getNutrientCount() {
		return nutrientCount;
	}

	public void setNutrientCount(int nutrientCount) {
		this.nutrientCount = nutrientCount;
	}

	public Date getNutrientCreateDate() {
		return nutrientCreateDate;
	}

	public void setNutrientCreateDate(Date nutrientCreateDate) {
		this.nutrientCreateDate = nutrientCreateDate;
	}

	public String getNutrientStatus() {
		return nutrientStatus;
	}

	public void setNutrientStatus(String nutrientStatus) {
		this.nutrientStatus = nutrientStatus;
	}

	public String getNutrientTitleImg() {
		return nutrientTitleImg;
	}

	public void setNutrientTitleImg(String nutrientTitleImg) {
		this.nutrientTitleImg = nutrientTitleImg;
	}

	private String nutrientTitleImg;		// 게시글의 타이틀 이미지 (실제 서버에 업로드되어있는 이름)
}

