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
 * Servlet implementation class NoticeUpdateFormServlet
 */
@WebServlet("/QnaNoticeUpdateForm.no")
public class QnaNoticeUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaNoticeUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int QnNo = Integer.parseInt(request.getParameter("QnNo"));
		
		QnaNotice qnaNotice = new QnaNoticeService().selectUpdateNotice(QnNo);
		
		String page = "";
		if(qnaNotice != null) {
			request.setAttribute("qnaNotice", qnaNotice);
			page = "views/notice/qnanotice/QnaNoticeUpdate.jsp";
		}else {
			request.setAttribute("msg", "Q&A 조회 실패");
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
