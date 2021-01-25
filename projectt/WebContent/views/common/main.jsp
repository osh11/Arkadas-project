<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');
	
	*{margin:0; padding:0; font-family:"Titillium Web";
	}
	
	li{list-style:none;}
	
	a{text-decoration:none;}
	
	.clearfix{content: ''; display:block; clear:both;}
	
	
	.topList {
		width: 900px;
		height: 600px;
	}
	
	#p{
		text-align:center;
		margin-top:300px;
		margin-bottom:400px;
	}
	
	footer{
		font-family:'Titillium Web';
		font-size:12px;
		font-color:#353535; 
	}
	#info{
		margin-left:20px;
	}
	
	
</style>
</head>
<body>
	<%@ include file="menubar.jsp" %>
	
	<p id="p">
	<a href="<%=request.getContextPath()%>/self1.di">
	<img class="topList" src='image/image.jpg'></img>
	</a>

	</p>
	
	<footer>
	<hr>
		<br><br>
		<div id="info">
	    <p>Copyright © 2018 tcpschool.co.,Ltd. All rights reserved.</p>
	    <address>Contact webmaster for more information. 070-1234-5678</address>
	    </div>
	    <br><br>
	</footer>
	
</body>
</html>