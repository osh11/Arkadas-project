package com.kh.diagnosis.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiagnosisList2
 */
@WebServlet("/list2.di")
public class DiagnosisList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisList2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button[]=request.getParameterValues("array");
		String nButton[]=request.getParameterValues("nutrious");
		String check[]=request.getParameterValues("check");
		
		ArrayList<Integer> array=new ArrayList<>();
		int[] nutrious=new int[12];
		
		if(nButton!=null) { //nutrious 이전 값 받아오기
			for(int i=0;i<12;i++) {
				nutrious[i]=Integer.parseInt(nButton[i]);
			}
		}
		
		if(check!=null) { //check 개수가 1개 이상이면
			int addNum=check.length; //check 개수 받기
			String tmp=request.getParameter("type");//증상 종류
			int type=Integer.parseInt(tmp);
			
			switch(type){
				case 0 : 
					nutrious[0]+=addNum;
					break;
				case 1 : 
					nutrious[1]+=addNum;
					nutrious[2]+=addNum;
					break;
				case 2 : 
					nutrious[3]+=addNum;
					nutrious[4]+=addNum;
					break;
				case 3 : 
					nutrious[4]+=addNum;
					nutrious[5]+=addNum;
					break;
				case 4 : 
					nutrious[6]+=addNum;
					nutrious[11]+=addNum;
					break;
				case 5 : 
					nutrious[7]+=addNum;
					nutrious[8]+=addNum;
					break;
				case 6 : 
					nutrious[9]+=addNum;
					nutrious[7]+=addNum;
					break;
				case 7 : 
					nutrious[11]+=addNum;
					break;
				case 8 : 
					nutrious[10]+=addNum;
					nutrious[5]+=addNum;
					break;
			}
		}
		
		for(int i=0;i<11;i++) {
			System.out.print(nutrious[i]+ " ");
		}
		System.out.println();
		
		
		if(button==null) {
			request.setAttribute("nutrious", nutrious);
			RequestDispatcher view = request.getRequestDispatcher("views/diagnosis/DiagnosisHabit.jsp");
			view.forward(request,response);
		}else {
			
			for(String s:button) {
				array.add(Integer.parseInt(s));
			}
			int i=array.remove(0);
			RequestDispatcher view;
			request.setAttribute("array", array);
			request.setAttribute("nutrious", nutrious);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
