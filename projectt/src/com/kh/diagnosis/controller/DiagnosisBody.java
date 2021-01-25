package com.kh.diagnosis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiagnosisBody
 */
@WebServlet("/body.di")
public class DiagnosisBody extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisBody() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nButton[]=request.getParameterValues("nutrious");
		
		String [] button2=new String[4];
		button2[1]=request.getParameter("button11");
		button2[2]=request.getParameter("button22");
		button2[3]=request.getParameter("button33");
		
		int[] nutrious=new int[12];
		int[] nButton2=new int[4];
		
		if(nButton!=null) { //nutrious 이전 값 받아오기
			for(int i=0;i<12;i++) {
				nutrious[i]=Integer.parseInt(nButton[i]);
			}
		}
		
		for(int i=1;i<=3;i++) {
			nButton2[i]=Integer.parseInt(button2[i]);
		}
		
		
		
		
		request.setAttribute("nutrious", nutrious);
		request.setAttribute("nButton2",nButton2);
		request.getRequestDispatcher("views/diagnosis/DiagnosisBody.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
