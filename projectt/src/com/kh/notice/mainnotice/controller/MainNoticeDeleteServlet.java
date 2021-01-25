package com.kh.notice.mainnotice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.mainnotice.model.service.MainNoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/MainNoticeDelete.no")
public class MainNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int MnNo = Integer.parseInt(request.getParameter("MnNo"));
		
		int result = new MainNoticeService().deleteNotice(MnNo);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "공지사항 삭제 성공!!");
			response.sendRedirect("MainNotice.no");
		}else {
			request.setAttribute("msg", "공지사항 삭제에 실패했습니다.");
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
