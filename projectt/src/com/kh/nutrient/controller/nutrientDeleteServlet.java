package com.kh.nutrient.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nutrient.model.service.nutrientBoardService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/delete.nu")
public class nutrientDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nutrientDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bId"));
		
		int result = new nutrientBoardService().deleteBoard(bid);
		
		if(result > 0) {
			response.sendRedirect("list.nu");
		}else {
			request.setAttribute("msg", "게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("views/nutrient/nutrientCollection.jsp").forward(request, response);
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
