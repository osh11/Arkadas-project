package com.kh.notice.mainnotice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.mainnotice.model.service.MainNoticeService;
import com.kh.notice.mainnotice.model.vo.MainNotice;

/**
 * Servlet implementation class MainNoticeListServlet
 */
@WebServlet("/MainNotice.no")
public class MainNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String condition = "";
		String user    = "";
		String title   = "";
		String content = "";
		
		if(request.getParameter("condition") != null)
			condition = (String) request.getParameter("condition");
		
		if(condition.equals("content")) {
			content = request.getParameter("search");
		}
		
		if(condition.equals("title")) {
			title = request.getParameter("search");
		}
		
		if(condition.equals("writer")) {
			user = request.getParameter("search");
		}
		ArrayList<MainNotice> list = new MainNoticeService().selectList(user,title,content);
		request.setAttribute("list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/notice/mainnotice/MainNotice.jsp");
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
