package com.kh.notice.mainnotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.mainnotice.model.service.MainNoticeService;
import com.kh.notice.mainnotice.model.vo.MainNotice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/MainNoticeUpdate.no")
public class MainNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String MnNo = request.getParameter("MnNo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MainNotice n = new MainNotice();
		n.setNOTICE_SEQNO(MnNo);
		n.setNOTICE_TITLE(title);
		n.setNOTICE_CONTENT(content);
		
		int result = new MainNoticeService().updateNotice(n);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "공지사항 수정 성공!");
			response.sendRedirect("MainNoticeDetail.no?MnNo=" + MnNo);
		}else {
			request.setAttribute("msg", "공지사항 수정 실패!!");
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
