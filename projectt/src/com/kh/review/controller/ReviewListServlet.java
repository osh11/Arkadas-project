package com.kh.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.model.PageInfo;
import com.kh.review.model.Review;
import com.kh.review.model.ReviewService;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/list.re")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		int listCount; //전체 게시글 수
		int currPage; //현재 보고 있는 페이지
		int startPage; //현재 보고 있는 페이징 바 시작 수
		int endPage; //현재 보고 있는 페이징 바 마지막 수
		int maxPage; // 전체 페이지 수의 마지막
		int pageLimit; // 한 페이지에 보여지는 페이지의 최대 개수
		int reviewLimit; //한 페이지에 보여지는 게시글의 최대 개수
		
		String keyword = (String)request.getSession().getAttribute("keyword");
	
		listCount = new ReviewService().getListCount();
		
		currPage = 1; //currPage의 default로 1을 설정
		if(request.getParameter("currPage")!= null) {
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		pageLimit = 5;
		reviewLimit = 6;
		maxPage = (int)Math.ceil((double)listCount/reviewLimit);
		startPage = (currPage-1) / pageLimit*pageLimit +1;
		endPage = startPage + pageLimit -1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		ArrayList<Review> list;
		PageInfo pi = new PageInfo(listCount, currPage, startPage, endPage, maxPage, pageLimit, reviewLimit);
		
		list = new ReviewService().selectList(pi);
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/review/reviewList.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
