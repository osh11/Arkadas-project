<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.faqnotice.model.vo.FaqNotice" %>
<%
	FaqNotice n = (FaqNotice)request.getAttribute("faqNotice");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAQ 수정하기</title>
<style>
	.outer{
		width:800px;
		height:500px;
		
		margin:auto;
		margin-top:50px;
	}
	#updateForm{width:60%; margin:auto;}
	#updateForm>table{border:1px solid black;}
	#updateForm>table input{
		width:100%;
		box-sizing:border-box;
	}
	
</style>
</head>
<body>

	<%@ include file = "/views/common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center" style="color:red;">자주묻는질문 수정하기</h2>
		
		<form id="updateForm" action="<%=request.getContextPath()%>/FaqNoticeUpdate.no" method="post" >
			<input type="hidden" name="FnNo" value="<%= n.getFAQ_SEQNO() %>">
			<table id="updateForm" border="2" align="center">
				<tr>
					<td align="center" style="color:orangered;">제목</td>
					<td colspan="3"><input type="text" name="title" value="<%= n.getFAQ_TITLE() %>"></td>
				</tr>
				
				<tr>
					<td align="center" colspan="4" style="color:orangered;">내용</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="75" rows="20" style="resize:none;"><%= n.getFAQ_CONTENT() %></textarea>
					</td>
				</tr>	
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit">수정하기</button>
			</div>
		</form>
	</div>

</body>
</html>