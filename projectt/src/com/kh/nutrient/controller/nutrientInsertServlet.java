package com.kh.nutrient.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.nutrient.model.service.nutrientBoardService;
import com.kh.nutrient.model.vo.Attachment;
import com.kh.nutrient.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class nutrientInsertServlet
 */
@WebServlet("/insert.nu")
public class nutrientInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nutrientInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {//true
			System.out.println("넘어옴");
			int maxSize = 10*1024*1024;
			
			
			String resource = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = resource + "\\board_upfiles\\";

			System.out.println("savePath : "+savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			Board b = new Board();
			b.setsCategory(multiRequest.getParameter("sCategory"));
			b.setsCode(multiRequest.getParameter("sCode"));
			b.setsName(multiRequest.getParameter("sName"));
			b.setsBrand(multiRequest.getParameter("sBrand"));
			b.setsBno(multiRequest.getParameter("sBno"));
			b.setsSize(multiRequest.getParameter("sSize"));
			b.setsTerm(multiRequest.getParameter("sTerm"));
			b.setsPrice(Integer.parseInt(multiRequest.getParameter("sPrice")));
			b.setsUrl(multiRequest.getParameter("sUrl"));
			b.setsContent1(multiRequest.getParameter("sContent1"));
	        b.setsContent2(multiRequest.getParameter("sContent2"));
	        b.setsContent3(multiRequest.getParameter("sContent3"));
			b.setGuide1(multiRequest.getParameter("guide1"));
			b.setGuide2(multiRequest.getParameter("guide2"));
			b.setGuide3(multiRequest.getParameter("guide3"));
			b.setEfContentMain1(multiRequest.getParameter("efContentMain1"));
			b.setEfContentSub1(multiRequest.getParameter("efContentSub1"));
			b.setEfContentMain2(multiRequest.getParameter("efContentMain2"));
			b.setEfContentSub2(multiRequest.getParameter("efContentSub2"));
			b.setEfContentMain3(multiRequest.getParameter("efContentMain3"));
			b.setEfContentSub3(multiRequest.getParameter("efContentSub3"));
			b.setsEle1(multiRequest.getParameter("sEle1"));
			b.setsEleSize1(multiRequest.getParameter("sEleSize1"));
			b.setsEleContent1(multiRequest.getParameter("sEleContent1"));
			b.setsEle2(multiRequest.getParameter("sEle2"));
			b.setsEleSize2(multiRequest.getParameter("sEleSize2"));
			b.setsEleContent2(multiRequest.getParameter("sEleContent2"));
		
			
			ArrayList<Attachment> fileList = new ArrayList<>();
			for(int i=1;i<=4;i++) {
				String name = "file"+i;
				if(multiRequest.getOriginalFileName(name)!=null) { //파일이 존재할 경우
					String originName = multiRequest.getOriginalFileName(name);
					String changeName = multiRequest.getFilesystemName(name);
					
					Attachment at = new Attachment();
					at.setFilePath(savePath);
					at.setOriginName(originName);
					at.setChangeName(changeName);
					
					fileList.add(at);
				}
			}
			
			int result = new nutrientBoardService().insertThumbnail(b,fileList);
			System.out.println("result : "+result+", insertThumbnail 확인");
			if(result>0) {
				response.sendRedirect("list.nu");
				System.out.println("게시글 성공");
			}else {
				for(int i=0;i<fileList.size();i++) {
					File failedFile = new File(savePath+fileList.get(i).getChangeName());
					failedFile.delete();
				}
				
				request.setAttribute("msg", "게시글 등록 실패");
				request.getRequestDispatcher("views/nutrient/nutrientCollection.jsp").forward(request, response);
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
