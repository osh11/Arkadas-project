package com.kh.notice.faqnotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.faqnotice.model.service.FaqNoticeService;
import com.kh.notice.mainnotice.model.service.MainNoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/FaqNoticeDelete.no")
public class FaqNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int FnNo = Integer.parseInt(request.getParameter("FnNo"));
		
		int result = new FaqNoticeService().deleteNotice(FnNo);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "질문 삭제 성공!!");
			response.sendRedirect("FaqNotice.no");
		}else {
			request.setAttribute("msg", "질문 삭제에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
