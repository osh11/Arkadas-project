package com.kh.notice.qnanotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.notice.qnanotice.model.service.QnaNoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/QnaNoticeDelete.no")
public class QnaNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int QnNo = Integer.parseInt(request.getParameter("QnNo"));
		
		int result = new QnaNoticeService().deleteNotice(QnNo);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "Q&A 삭제 성공!!");
			response.sendRedirect("QnaNotice.no");
		}else {
			request.setAttribute("msg", "Q&A 삭제에 실패했습니다.");
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
