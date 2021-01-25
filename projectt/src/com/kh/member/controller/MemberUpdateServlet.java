package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/update.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		Date age=Date.valueOf(request.getParameter("age"));
		String gender1=request.getParameter("gender1");
		String gender2=request.getParameter("gender2");
		
		System.out.println(age);
		if(gender1.equals("1"))
			System.out.println(gender1);
		else
			System.out.println(gender2);

		Member updateMem;
		if(gender1.equals("1"))
			updateMem=new MemberService().updateMember(new Member(userId, userPwd, userName, 'm', age, email));

		else
			updateMem=new MemberService().updateMember(new Member(userId, userPwd, userName, 'f', age, email));

		if(updateMem != null) {
			request.getSession().setAttribute("msg", "성공적으로 회원정보를 수정했습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "회원정보 수정에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath());
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
