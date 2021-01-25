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
<meta charset="UTF-8">
<script>
</script>
<style>
.left-menu{
word-break: keep-all;
line-height: 3.2;
color: #333;
margin: 30px;
padding-top : 10%;
border: 0;
font-size: 110%;
font-family: inherit;
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
<nav class="left-menu">
	<h3>고객센터</h3>
	<ul>
		<li class="on"><a href="<%=request.getContextPath()%>/MainNotice.no?condition=content&search=">공지사항</a></li>
		<li class=""><a href="<%=request.getContextPath()%>/FaqNotice.no?condition=content&search="">자주묻는질문</a></li>
		<li class="" id="liQnA"><a href="<%=request.getContextPath()%>/QnaNotice.no?user=권석호&condition=content&search=">Q&A</a></li>
	</ul>
</nav>
		
</body>
</html>