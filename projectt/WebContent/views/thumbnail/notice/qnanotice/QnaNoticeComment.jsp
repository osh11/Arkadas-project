<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.qnanotice.model.vo.QnaNotice" %>
<%
	QnaNotice n = (QnaNotice)request.getAttribute("qnaNotice");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변하기</title>
<style>
	.outer{
		width:800px;
		height:700px;
		
		margin:auto;
		margin-top:50px;
	}
	#updateForm{width:530px; margin:auto;}
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
		<div style="display:flex; height:200px; justify-content:center;">
			<table id="detailArea" border="1">
				<tr>
					<td >제목</td>
					<td colspan="3"><%= n.getQNA_CONTENT() %></td>
				</tr>
				<tr>
					<td style="width:55px;">작성자</td>
					<td style="width:200px;"><%= n.getQNA_CRT_USER() %></td>
					<td style="width:55px;">작성일</td>
					<td style="width:200px;"><%= n.getQNA_CRT_DATE() %></td>
				</tr>
				<tr>
					<td align="center" colspan="4">내용</td>
				
				</tr>
				<tr>
					<td style="height:100px;" colspan="4">
						<p><%= n.getQNA_TITLE() %></p>
					</td>
				</tr>
			</table>
		</div>
		
		
		
		<h2 align="center">Q&A 답변하기</h2>
		
		<form id="updateForm" action="<%=request.getContextPath()%>/QnaNoticeComment.no" method="post" >
			<input type="hidden" name="QnNo" value="<%= n.getQNA_SEQNO() %>">
			<input type="hidden" name="user" value="권석호">
			<table align="center"style="width:530px;">
				<tr>
					<td colspan="4" style="text-align:center;">내용</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="comment" cols="80" rows="15" style="width:530px;resize:none;"><%= n.getQNA_COMMENT() %></textarea>
					</td>
				</tr>	
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit">답변하기</button>
			</div>
		</form>
	

</body>
</html>