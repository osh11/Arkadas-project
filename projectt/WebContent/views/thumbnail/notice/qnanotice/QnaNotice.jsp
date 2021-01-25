<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.notice.qnanotice.model.vo.QnaNotice"%>
<%  ArrayList<QnaNotice> list = (ArrayList<QnaNotice>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/earlyaccess/nanumgothiccoding.css" rel="stylesheet" type="text/css">
<style type="text/css">
.hanna {font-family:'hanna';}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A</title>

<!-- 스크립트 영역 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
</head>
<body>
	<%@ include file = "/views/common/menubar.jsp" %>
	<%@ include file = "/views/notice/NoticeMenu.jsp" %>
	<div class="outer">
		<br>
		<br>
		<br>
		<br>
		<br>
		<h1 class="hanna" align="center" style="color:red;">Q&A</h1>
		<br>
	<button type="button" class="navyBtn" onClick="location.href='<%=request.getContextPath()%>/QnaNoticeRegForm.no'">글작성</button>
		<div style="display:flex; justify-content:center;">
		<table class="listArea" align="center">
			<thead>
				<tr>
					<th width="60" style="color:orange;">순번</th>
					<th width="60" style="color:orange;">구분</th>
					<th width="400" style="color:orange;">내용</th>
					<th width="200" style="color:orange;">작성자</th>
					<th width="200" style="color:orange;">작성일자</th>
					<th style="display:none;">글번호PK</th>
				</tr>
			</thead>
			<tbody>
				 <% if(list.isEmpty()){ %>
				 	<tr>
						<td colspan="5">존재하는 글이 없습니다.</td>
					</tr>
				 <% }else{  %>
			 		<% for(QnaNotice n : list){ %>
				 	<tr>
				 		<td align="center"><%= n.getQNA_COUNT()    %></td> <!-- 글번호 -->
				 		<td align="center"> Q </td>
				 		<td align="center"><%= n.getQNA_TITLE()    %></td>
				 		
				 		<td align="center"><%= n.getQNA_CRT_USER() %></td>
				 		<td align="center"><%= n.getQNA_CRT_DATE() %></td>
				 		<td align="center" style="display:none;"><%= n.getQNA_SEQNO() %></td>
				 	</tr>	
				 	<tr>
				 		<td></td>
				 		<td></td>
				 		<td align="center" colspan="3"><%= n.getQNA_CONTENT() %></td>
				 		<td align="center" style="display:none;"><%= n.getQNA_SEQNO() %></td>
				 	</tr>
				 	<tr>
				 		<td></td>
				 		<td align="center"> A </td>
				 		<td align="center"><%=  n.getQNA_COMMENT()  == null ? "답변이 등록되지 않았습니다." : n.getQNA_COMMENT()%></td>
				 		<td align="center"><%= n.getQNA_RESP_USER() == null ? "" : n.getQNA_RESP_USER() %></td>
				 		<td align="center"><%= n.getQNA_RESP_DATE() == null ? "" : n.getQNA_RESP_DATE() %></td>
				 		<td align="center" style="display:none;"><%= n.getQNA_SEQNO() %></td>
				 	</tr>
				 <% }
			 	} %>
			</tbody>
			
		</table>
		</div>
		<br>
		<br>
		<br>
		<form class="searchArea" align="center">
			<select id="condition" name="condition">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search" name="search">
			<input type="text" name="user" style="display:inline;" value="권석호">
			<button id="btn_search" type="submit">검색하기</button>
		</form>	

	</div>
</body>
<script>
		<%if (!list.isEmpty()) {%>
		$(function(){
			$(".listArea>tbody>tr").click(function(){
				var QnNo = "";
				
				QnNo = $(this).children().eq(5).text();
				if(QnNo == null  || QnNo.length == 0)
					QnNo = $(this).children().eq(3).text();
				
				console.log(QnNo);
				
				// 쿼리 스트링을 이용하여 get방식으로(url 노출) 글번호를 server로 전달
				location.href="<%=request.getContextPath()%>/QnaNoticeDetail.no?QnNo=" + QnNo;
			});
		});
		<%} %>
		
	</script>

</html>