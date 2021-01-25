<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	font-family: "Titillium Web";
}

li {
	list-style: none;
}

a {
	text-decoration: none;
}

.clearfix {
	content: '';
	display: block;
	clear: both;
}

.topList {
	width: 900px;
	height: 600px;
}

#p {
	text-align: center;
	margin-top: 300px;
	margin-bottom: 400px;
}

footer {
	font-family: 'Titillium Web';
	font-size: 12px;
	font-color: #353535;
}

#info {
	margin-left: 20px;
}

#admin {
	float: right;
	margin-right: 20px;
	font-color: #353535;
}
</style>
</head>
<body>

	<p id="p">
		
	</p>

	<footer>
		<div>
			<% if(loginUser != null && loginUser.getUserId().equals("admin")) { %>
			<ul class="actions vertical" id="writebtn">
					<li><a id="admin" class="button alt small" onclick="location.href='<%=request.getContextPath()%>/insertForm.nu'">작성하기</a> 
			</li>
				</ul>
		<% } %>
		</div>
		<br><br>

	</footer>
	
	
</body>
</html>