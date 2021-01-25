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
<title>Q&A수정하기</title>
<style>
.headline{
	font-family:'Jeju Gothic';
	font-size : 45px;
	color : red;
}
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
		<h2 class="headline" align="center" style="color:red;">Q&A 수정하기</h2>
		
		<form id="updateForm" action="<%=request.getContextPath()%>/QnaNoticeUpdate.no" method="post" >
			
			<input type="hidden" name="QnNo" value="<%= n.getQNA_SEQNO() %>">
			<table id="updateForm" border="2" align="center">
				<tr>
					<td align="center" style="color:red;">제목</td>
					<td colspan="3"><input type="text" name="title" value="<%= n.getQNA_TITLE() %>"></td>
				</tr>
				
				<tr>
					<td align="center" style="color:red;">내용</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="60" rows="15" style="resize:none;"><%= n.getQNA_CONTENT() %></textarea>
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