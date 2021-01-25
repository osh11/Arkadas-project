<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("Load Notice Menu");
	request.setAttribute("user"    , "권석호");
	request.setAttribute("title"   , "%");
	request.setAttribute("content" , "%");
%>

<!DOCTYPE html>
<html>
<head>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/earlyaccess/nanumgothiccoding.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<script>
</script>
<style>
.left-menu{
word-break: keep-all;
line-height: 3.2;
color: skyblue;
margin: 30px;
padding-top : 15%;
border: 0;
font-size: 125%;
font-family:'Jeju Gothic';
vertical-align: baseline;
display: block;
float: left;
width: 160px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">

</script>
</head>
<body>
<nav class="left-menu" align="center">
	<h2>고객센터</h2><hr style="border: solid 1px black;">
	<ul>
		<li align="center" class="on"><a href="<%=request.getContextPath()%>/MainNotice.no?condition=content&search=">공지사항</a><hr></li>
		<li align="center"class=""><a href="<%=request.getContextPath()%>/FaqNotice.no?condition=content&search="">자주묻는질문</a><hr></li>
		<li align="center" class="" id="liQnA"><a href="<%=request.getContextPath()%>/QnaNotice.no?condition=content&search=">Q&A</a></li>
	</ul>
</nav>
		
</body>
</html>