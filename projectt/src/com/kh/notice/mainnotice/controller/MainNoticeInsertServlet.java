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
 * Servlet implementation class MainNoticeInsertServlet
 */
@WebServlet("/MainNoticeReg.no")
public class MainNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// DB에 저장시 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String user = request.getParameter("user");
		/*
		 * String writer =
		 * String.valueOf(((Member)request.getSession().getAttribute("loginUser")).
		 * getUserNo());
		 */// 작성자회원번호
		System.out.println(content);
		
		MainNotice n = new MainNotice(title,content, user);
		
		int result = new MainNoticeService().insertNotice(n);
		
		if(result > 0) {
				
			request.getSession().setAttribute("msg", "공지사항이  성공적으로 등록되었습니다.");
			response.sendRedirect("MainNotice.no");
		}else {
			request.setAttribute("msg", "공지사항 등록 실패!!");
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
