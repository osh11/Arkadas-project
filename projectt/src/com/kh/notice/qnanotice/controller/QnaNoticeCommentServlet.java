package com.kh.notice.qnanotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.notice.qnanotice.model.service.QnaNoticeService;
import com.kh.notice.qnanotice.model.vo.QnaNotice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/QnaNoticeComment.no")
public class QnaNoticeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaNoticeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String QnNo = request.getParameter("QnNo");
		String user = request.getParameter("user");
		String comment = request.getParameter("comment");
		
		QnaNotice n = new QnaNotice();
		n.setQNA_SEQNO(QnNo);
		n.setQNA_RESP_USER(user);
		n.setQNA_COMMENT(comment);
		
		int result = new QnaNoticeService().updateComment(n);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "Q&A 수정 성공!");
			response.sendRedirect("QnaNoticeDetail.no?QnNo=" + QnNo);
		}else {
			request.setAttribute("msg", "Q&A 수정 실패!!");
			request.getRequestDispatcher("views//errorPage.jsp").forward(request, response);
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
