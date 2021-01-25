package com.kh.nutrient.model.vo;


public class Board {
	private int boardNo;
	private String sCategory;
	private String sCode;
	private String sName;		
	private String sBrand;		
	private String sBno;		
	private String sSize;	
	private String sTerm;
	private int sPrice;
	private String sUrl;
	
	private String sContent1;
	private String sContent2;
	private String sContent3;
	
	private String guide1;
	private String guide2;
	private String guide3;
	
	private String efContentMain1;
	private String efContentSub1;
	private String efContentMain2;
	private String efContentSub2;
	private String efContentMain3;
	private String efContentSub3;
	
	private String sEle1;
	private String sEleSize1;
	private String sEleContent1;
	private String sEle2;
	private String sEleSize2;
	private String sEleContent2;
	
	private String titleImg;	
	private int count;
	
	private String search;
	
	
	

	public Board(String search) {
		super();
		this.search = search;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	public Board() {
		
	}


	public Board(int boardNo, String sCategory, String sCode, String sName, String sBrand, String sBno, String sSize, String sTerm, int sPrice,
			String sUrl, String sContent1, String sContent2, String sContent3, String guide1, String guide2,
			String guide3, String efContentMain1, String efContentSub1, String efContentMain2, String efContentSub2,
			String efContentMain3, String efContentSub3, String sEle1, String sEleSize1, String sEleContent1,
			String sEle2, String sEleSize2, String sEleContent2, int count) {
		super();
		
		this.boardNo = boardNo;
		this.sCategory = sCategory;
		this.sCode = sCode;
		this.sName = sName;
		this.sBrand = sBrand;
		this.sBno = sBno;
		this.sSize = sSize;
		this.sTerm = sTerm;
		this.sPrice = sPrice;
		this.sUrl = sUrl;
		this.sContent1 = sContent1;
		this.sContent2 = sContent2;
		this.sContent3 = sContent3;
		this.guide1 = guide1;
		this.guide2 = guide2;
		this.guide3 = guide3;
		this.efContentMain1 = efContentMain1;
		this.efContentSub1 = efContentSub1;
		this.efContentMain2 = efContentMain2;
		this.efContentSub2 = efContentSub2;
		this.efContentMain3 = efContentMain3;
		this.efContentSub3 = efContentSub3;
		this.sEle1 = sEle1;
		this.sEleSize1 = sEleSize1;
		this.sEleContent1 = sEleContent1;
		this.sEle2 = sEle2;
		this.sEleSize2 = sEleSize2;
		this.sEleContent2 = sEleContent2;
		this.count = count;

	}
	
	


	public Board(int boardNo, String sCategory, String sCode, String sName, String sBrand, String sBno, String sSize, String sTerm, int sPrice,
			String sUrl, String sContent1, String sContent2, String sContent3, String guide1, String guide2,
			String guide3, String efContentMain1, String efContentSub1, String efContentMain2, String efContentSub2,
			String efContentMain3, String efContentSub3, String sEle1, String sEleSize1, String sEleContent1,
			String sEle2, String sEleSize2, String sEleContent2, String titleImg, int count) {
		super();
		this.boardNo = boardNo;
		this.sCategory = sCategory;
		this.sCode = sCode;
		this.sName = sName;
		this.sBrand = sBrand;
		this.sBno = sBno;
		this.sSize = sSize;
		this.sTerm = sTerm;
		this.sPrice = sPrice;
		this.sUrl = sUrl;
		this.sContent1 = sContent1;
		this.sContent2 = sContent2;
		this.sContent3 = sContent3;
		this.guide1 = guide1;
		this.guide2 = guide2;
		this.guide3 = guide3;
		this.efContentMain1 = efContentMain1;
		this.efContentSub1 = efContentSub1;
		this.efContentMain2 = efContentMain2;
		this.efContentSub2 = efContentSub2;
		this.efContentMain3 = efContentMain3;
		this.efContentSub3 = efContentSub3;
		this.sEle1 = sEle1;
		this.sEleSize1 = sEleSize1;
		this.sEleContent1 = sEleContent1;
		this.sEle2 = sEle2;
		this.sEleSize2 = sEleSize2;
		this.sEleContent2 = sEleContent2;
		this.titleImg = titleImg;
		this.count = count;
	}
	public String getsCategory() {
		return sCategory;
	}


	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getsCode() {
		return sCode;
	}


	public void setsCode(String sCode) {
		this.sCode = sCode;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getsBrand() {
		return sBrand;
	}


	public void setsBrand(String sBrand) {
		this.sBrand = sBrand;
	}


	public String getsBno() {
		return sBno;
	}


	public void setsBno(String sBno) {
		this.sBno = sBno;
	}


	public String getsSize() {
		return sSize;
	}


	public void setsSize(String sSize) {
		this.sSize = sSize;
	}


	public String getsTerm() {
		return sTerm;
	}


	public void setsTerm(String sTerm) {
		this.sTerm = sTerm;
	}


	public int getsPrice() {
		return sPrice;
	}


	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}


	public String getsUrl() {
		return sUrl;
	}


	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}


	public String getsContent1() {
		return sContent1;
	}


	public void setsContent1(String sContent1) {
		this.sContent1 = sContent1;
	}


	public String getsContent2() {
		return sContent2;
	}


	public void setsContent2(String sContent2) {
		this.sContent2 = sContent2;
	}


	public String getsContent3() {
		return sContent3;
	}


	public void setsContent3(String sContent3) {
		this.sContent3 = sContent3;
	}


	public String getGuide1() {
		return guide1;
	}


	public void setGuide1(String guide1) {
		this.guide1 = guide1;
	}


	public String getGuide2() {
		return guide2;
	}


	public void setGuide2(String guide2) {
		this.guide2 = guide2;
	}


	public String getGuide3() {
		return guide3;
	}


	public void setGuide3(String guide3) {
		this.guide3 = guide3;
	}


	public String getEfContentMain1() {
		return efContentMain1;
	}


	public void setEfContentMain1(String efContentMain1) {
		this.efContentMain1 = efContentMain1;
	}


	public String getEfContentSub1() {
		return efContentSub1;
	}


	public void setEfContentSub1(String efContentSub1) {
		this.efContentSub1 = efContentSub1;
	}


	public String getEfContentMain2() {
		return efContentMain2;
	}


	public void setEfContentMain2(String efContentMain2) {
		this.efContentMain2 = efContentMain2;
	}


	public String getEfContentSub2() {
		return efContentSub2;
	}


	public void setEfContentSub2(String efContentSub2) {
		this.efContentSub2 = efContentSub2;
	}


	public String getEfContentMain3() {
		return efContentMain3;
	}


	public void setEfContentMain3(String efContentMain3) {
		this.efContentMain3 = efContentMain3;
	}


	public String getEfContentSub3() {
		return efContentSub3;
	}


	public void setEfContentSub3(String efContentSub3) {
		this.efContentSub3 = efContentSub3;
	}


	public String getsEle1() {
		return sEle1;
	}


	public void setsEle1(String sEle1) {
		this.sEle1 = sEle1;
	}


	public String getsEleSize1() {
		return sEleSize1;
	}


	public void setsEleSize1(String sEleSize1) {
		this.sEleSize1 = sEleSize1;
	}


	public String getsEleContent1() {
		return sEleContent1;
	}


	public void setsEleContent1(String sEleContent1) {
		this.sEleContent1 = sEleContent1;
	}


	public String getsEle2() {
		return sEle2;
	}


	public void setsEle2(String sEle2) {
		this.sEle2 = sEle2;
	}


	public String getsEleSize2() {
		return sEleSize2;
	}


	public void setsEleSize2(String sEleSize2) {
		this.sEleSize2 = sEleSize2;
	}


	public String getsEleContent2() {
		return sEleContent2;
	}


	public void setsEleContent2(String sEleContent2) {
		this.sEleContent2 = sEleContent2;
	}


	public String getTitleImg() {
		return titleImg;
	}


	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}


	
	

}
