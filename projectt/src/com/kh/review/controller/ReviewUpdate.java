package com.kh.review.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import com.kh.common.MyFileRenamePolicy;
import com.kh.review.model.Attachment;
import com.kh.review.model.Review;
import com.kh.review.model.ReviewService;

/**
 * Servlet implementation class ReviewUpdate
 */
@WebServlet("/update.re")
public class ReviewUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = resources + "\\uploaded\\";
			System.out.println("savePath : "+savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			int rno = Integer.parseInt(multiRequest.getParameter("rno"));
			
			Review review = new Review();
			review.setReviewNo(rno);
			review.setReviewTitle(multiRequest.getParameter("title"));
			review.setReviewWriter(multiRequest.getParameter("writer"));
			review.setReviewContent(multiRequest.getParameter("content").replaceAll("\n", "<br>"));
			review.setSupCode(multiRequest.getParameter("sup"));
			review.setReviewPwd(multiRequest.getParameter("pwd"));
			
			Attachment image = null;
			if(multiRequest.getOriginalFileName("upFile") != null) {
				image = new Attachment();
				image.setOriginName(multiRequest.getOriginalFileName("upFile"));
				image.setChangeName(multiRequest.getFilesystemName("upFile"));
				image.setFilePath(savePath);
				if(multiRequest.getParameter("originFile")!=null) {
					File delete = new File(savePath+multiRequest.getParameter("originFile"));
					delete.delete();
					image.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
				}else {
					image.setRefBoardNo(rno);
				}
			}
			
			int result = new ReviewService().updateReview(review,image);
			System.out.println("최종 result : "+result);
			if(result>0) {
				request.getSession().setAttribute("message", "리뷰 수정 성공");
				response.sendRedirect("detail.re?rno="+rno);
			}else {
				request.setAttribute("message", "리뷰 수정 실패");
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
