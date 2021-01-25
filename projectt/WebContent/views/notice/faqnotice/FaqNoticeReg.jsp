<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자주묻는질문 작성</title>
<style>
	.outer{
		width:800px;
		height:600px;
		
		margin:auto;
		margin-top:70px;
	}
	#enrollForm{width:500px; margin:auto;}
	#enrollForm>table{border:2px solid black;}
	#enrollForm>table input{
		width:100%;
		box-sizing:border-box;
	}
</style>
</head>
<body>
	<%@ include file = "/views/common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		
		<h2 align="center" style="color:red;">자주묻는질문 작성하기</h2>
		
		<form id="enrollForm" action="<%=request.getContextPath()%>/FaqNoticeReg.no" method="post" >
			<table id="enrollForm" border="1" align="center">
				<tr style="display:none;">
					<td colspan="4" style="width:530px;"><input type="text" name="user" value="<%=loginUser.getUserId()%>"></td>
				</tr>
				<tr>
					<td align="center" style="color:orangered;">제목</td>
					<td colspan="3"><input type="text" name="title"></td>
				</tr>
				
				<tr>
					<td align="center" colspan="4" style="color:orangered;">내용</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="78px" rows="23px" style="resize:none;"></textarea>
					</td>
				</tr>	
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit">등록하기</button>
				<!-- NoticeInsertServlet 만들러 가자 
					작성자 회원 번호 writer : 세션에 loginUser의 getUserNo()를 가져와서 담을 것
					notice 객체에 담을 때 content.replaceAll("\n","<br>")
					
					insert 후,
					result>0 : msg - 공지사항이 정상적으로 등록되었습니다.
					response.sendRedirect("list.no");	
				-->
				
			</div>
		</form>
	</div>
</body>
</html>