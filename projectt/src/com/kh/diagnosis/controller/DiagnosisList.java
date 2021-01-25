package com.kh.diagnosis.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class DiagnosisList
 */
@WebServlet("/list.di")
public class DiagnosisList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] button=new String[10];
		button[1]=request.getParameter("button11");
		button[2]=request.getParameter("button22");
		button[3]=request.getParameter("button33");
		button[4]=request.getParameter("button44");
		button[5]=request.getParameter("button55");
		button[6]=request.getParameter("button66");
		button[7]=request.getParameter("button77");
		button[8]=request.getParameter("button88");
		button[9]=request.getParameter("button99");
		
		ArrayList<Integer> array=new ArrayList<>();
		int[] nutrious=new int[12];
		
		for(int i=1;i<=9;i++) {
			int tmp=Integer.parseInt(button[i]);
			if(tmp!=0) {
				array.add(Integer.parseInt(button[i]));
			}
		}
		
		if(array.size()==0) {
			request.setAttribute("nutrious", nutrious);
			RequestDispatcher view = request.getRequestDispatcher("views/diagnosis/DiagnosisHabit.jsp");
			view.forward(request,response);
		}else {
			int i=array.remove(0);
			RequestDispatcher view;
			request.setAttribute("nutrious", nutrious);
			request.setAttribute("array", array);
			
			switch(i) {
			case 1:
				view = request.getRequestDispatcher("views/diagnosis/DiagnosisViscera.jsp");
				view.forward(request,response);
				break;
			case 2:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisSkin.jsp");
				view.forward(request,response);
				break;
			case 3:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisEye.jsp");
				view.forward(request,response);
				break;
			case 4:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisBrain.jsp");
				view.forward(request,response);
				break;
			case 5:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisFatigue.jsp");
				view.forward(request,response);
				break;
			case 6:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisBone.jsp");
				view.forward(request,response);
				break;
			case 7:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisTooth.jsp");
				view.forward(request,response);
				break;
			case 8:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisImmune.jsp");
				view.forward(request,response);
				break;
			case 9:
				 view = request.getRequestDispatcher("views/diagnosis/DiagnosisHair.jsp");
				view.forward(request,response);
				break;
			}

			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
