package com.kh.review.model;

public class PageInfo {
	
	private int listCount;			// 총 게시글 갯수
	private int currPage;		// 현재 페이지 (즉, 요청한 페이지)
	private int startPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 시작 수 
	private int endPage;			// 현재 페이지에 하단에 보여지는 페이징 바의 끝 수
	private int maxPage;			// 전체 페이지에서의 가장 마지막 페이지
	private int pageLimit;			// 한 페이지 하단에 보여질 페이지 최대 갯수
	private int reviewLimit;			// 한 페이지에 보여질 게시글 최대 갯수
	
	public PageInfo() {
		
	}

	public PageInfo(int listCount, int currPage, int startPage, int endPage, int maxPage, int pageLimit,
			int reviewLimit) {
		super();
		this.listCount = listCount;
		this.currPage = currPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.pageLimit = pageLimit;
		this.reviewLimit = reviewLimit;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getReviewLimit() {
		return reviewLimit;
	}

	public void setReviewLimit(int reviewLimit) {
		this.reviewLimit = reviewLimit;
	}

	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", maxPage=" + maxPage + ", pageLimit=" + pageLimit + ", boardLimit="
				+ reviewLimit + "]";
	}
	
	

}
