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
 * Servlet implementation class NoticeUpdateFormServlet
 */
@WebServlet("/MainNoticeUpdateForm.no")
public class MainNoticeUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNoticeUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int MnNo = Integer.parseInt(request.getParameter("MnNo"));
		
		MainNotice mainNotice = new MainNoticeService().selectUpdateNotice(MnNo);
		
		String page = "";
		if(mainNotice != null) {
			request.setAttribute("mainNotice", mainNotice);
			page = "views/notice/mainnotice/MainNoticeUpdate.jsp";
		}else {
			request.setAttribute("msg", "공지사항 조회 실패");
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
