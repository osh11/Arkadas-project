package com.kh.notice.faqnotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.faqnotice.model.service.FaqNoticeService;
import com.kh.notice.faqnotice.model.vo.FaqNotice;
import com.kh.notice.mainnotice.model.service.MainNoticeService;
import com.kh.notice.mainnotice.model.vo.MainNotice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/FaqNoticeUpdate.no")
public class FaqNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String FnNo = request.getParameter("FnNo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		FaqNotice n = new FaqNotice();
		n.setFAQ_SEQNO(FnNo);
		n.setFAQ_TITLE(title);
		n.setFAQ_CONTENT(content);
		
		int result = new FaqNoticeService().updateNotice(n);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "질문 수정 성공!");
			response.sendRedirect("FaqNoticeDetail.no?FnNo=" + FnNo);
		}else {
			request.setAttribute("msg", "질문 수정 실패!!");
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
