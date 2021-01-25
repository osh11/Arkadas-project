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
<title>Q&A상세보기</title>
<style>
	.outer{
		width:800px;
		height:600px;
		
		margin:auto;
		margin-top:50px;
	}
	#detailArea{width:75%; margin:auto;border-color:black;}
	#detailArea p{height:400px;}
	.btns a{text-decoration:none; color:black;}
	
	
</style>
</head>
<body>
	<%@ include file = "/views/common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		
		<h2 align="center" style="color:red;">Q&A 상세보기</h2>
		

		<table id="detailArea" border="1">
			<tr>
				<td align="center" style="color:orangered;">제목</td>
				<td colspan="3"><%= n.getQNA_TITLE() %></td>
			</tr>
			<tr>
				<td align="center" style="color:orangered;">작성자</td>
				<td><%= n.getQNA_CRT_USER() %></td>
				<td align="center" style="color:orangered;">작성일</td>
				<td><%= n.getQNA_CRT_DATE() %></td>
			</tr>
			<tr>
				<td align="center" style="color:orangered" colspan="4">내용</td>
			
			</tr>
			<tr>
				<td colspan="4">
					<p><%= n.getQNA_CONTENT() %></p>
				</td>
			</tr>
			<tr>
				<td align="center" style="color:blue"colspan="4">답변</td>
				<td colspan="3"></td>
				
			</tr>
			<tr>
				<td align="center" style="color:blue">답변작성자</td>
				<td><%= n.getQNA_RESP_USER() == null ? "" : n.getQNA_RESP_USER() %></td>
				<td align="center" style="color:blue">답변작성일</td>
				<td><%= n.getQNA_RESP_DATE() == null ? "" : n.getQNA_RESP_DATE() %></td>
			</tr>
			<tr>
				<td align="center" style="color:blue" colspan="4">내용</td>
				<td colspan="3"></td>
				
			</tr>
			<tr>
				<td colspan="4">
					<p><%=  n.getQNA_COMMENT()  == null ? "답변이 등록되지 않았습니다." : n.getQNA_COMMENT()%></p>
				</td>
			</tr>
		</table>
		
		<br>
		
		<div class="btns" align="center">
		
			<a href="QnaNotice.no">목록으로</a> &nbsp;&nbsp;
				
			<!-- 로그인 기능 없을경우 이것을 임시사용 -->
			<a href="QnaNoticeUpdateForm.no?QnNo=<%=n.getQNA_SEQNO()%>">수정하기&nbsp;&nbsp;</a>
			<a href="QnaNoticeCommentForm.no?QnNo=<%=n.getQNA_SEQNO()%>">답변하기&nbsp;&nbsp;</a>
			<a href="QnaNoticeDelete.no?QnNo=<%=n.getQNA_SEQNO()%>">삭제하기</a>
			
			
				
			<!-- 글을 보는 회원이 admin인 경우 수정하기,삭제하기 버튼이 보이도록 하자!  로그인 기능 추가시 이것을 사용-->
			<%-- <% if(loginUser != null && loginUser.getUserId().equals("admin")) { %>
			<a href="QnaNoticeUpdateForm.no?MnNo=<%=n.getQnaNoticeNo()%>">수정하기</a> &nbsp;&nbsp;
			<a href="QnaNoticeDelete.no?MnNo=<%=n.getQnaNoticeNo()%>">삭제하기</a>
		
			<% } %> --%>
			<!-- 공지사항을 수정화면으로 넘어가기 위해 NoticeUpdateFormServlet 만들러 가자!! -->
		</div>
	</div>
	<%--<%@ include file = "/views/common/footer.jsp" %>--%>
	
</body>
</html>