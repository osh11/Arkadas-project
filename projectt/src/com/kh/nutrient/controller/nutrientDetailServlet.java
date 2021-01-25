package com.kh.nutrient.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.nutrient.model.service.nutrientBoardService;
import com.kh.nutrient.model.vo.Attachment;
import com.kh.nutrient.model.vo.Board;

/**
 * Servlet implementation class nutrientDetailServlet
 */
@WebServlet("/detail.nu")
public class nutrientDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nutrientDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				int bid = Integer.parseInt(request.getParameter("bId")); //혹시 안되면 Bid, BID 등으로 바꿔보기
				Board b = new nutrientBoardService().selectDetailBoard(bid);
				ArrayList<Attachment> fileList = new nutrientBoardService().selectDetailThumbnail(bid);
				System.out.println("넘어옴");
				if(b!=null) {
					request.setAttribute("b", b);
					request.setAttribute("fileList", fileList);
					request.getRequestDispatcher("views/nutrient/supplementsDetail.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "사진 상세보기 실패");
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
