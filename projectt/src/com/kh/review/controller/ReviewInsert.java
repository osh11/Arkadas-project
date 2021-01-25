package com.kh.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

import com.kh.review.model.Attachment;
import com.kh.review.model.Review;
import com.kh.review.model.ReviewService;

/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/insert.re")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = 0;
		int result2 = 0;
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			String resource = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = resource + "\\uploaded\\";
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String writer = multiRequest.getParameter("writer");
			String sup = multiRequest.getParameter("sup");
			String pwd = multiRequest.getParameter("pwd");
			
			Review review = new Review(sup,title,content.replaceAll("\n", "<br>"),writer,pwd);
			result = new ReviewService().insertReview(review);
			
			Attachment file = new Attachment();
			String name = "file";
			String originName = multiRequest.getOriginalFileName(name);
			String changeName = multiRequest.getFilesystemName(name);
			
			file.setFilePath(savePath);
			file.setOriginName(originName);
			file.setChangeName(changeName);
			
			result2 = new ReviewService().insertFile(file);
			review.setImage(changeName);
			
			if(result>0 && result2>0) {
				request.getSession().setAttribute("message", "후기 등록 성공");
				response.sendRedirect("list.re");
			}else {
				request.setAttribute("message", "후기 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
