package com.kh.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.model.Attachment;
import com.kh.review.model.Review;
import com.kh.review.model.ReviewService;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/detail.re")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rno = Integer.parseInt(request.getParameter("rno"));
		Review review = new ReviewService().selectReview(rno);
		Attachment image = new ReviewService().selectImage(rno);
		String page = "";
		
		
		if(review!=null) {
			request.setAttribute("review", review);
			request.setAttribute("image", image);
			page = "/views/review/reviewDetail.jsp";
		}else {
			request.setAttribute("message", "조회 실패");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
