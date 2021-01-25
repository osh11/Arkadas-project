<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.member.model.vo.Member" %>
      <%
   Member loginUser = (Member) session.getAttribute("loginUser");
   
   String msg=(String) session.getAttribute("msg");
   String contextPath = request.getContextPath();
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');

@import url(font-awesome.min.css);
@import url("https://fonts.googleapis.com/css?family=Lato:300,400,700|Pacifico");


*{margin:0; padding:0; font-family:"Titillium Web";
	}
	
	li{list-style:none;}
	
	a{text-decoration:none;}
	
	.clearfix{content: ''; display:block; clear:both;}
	
	header{
		height:75px;
		border:none;
		position:fixed;
		width:100%;
		z-index:9999;
		top:0;
		left:0;
		margin-top:10px;
		margin-left:10px;
		float:left;
		color:#353535;
	}
	



#logo {
	line-height: 35px;
	font-size: 1.75em;
	font-family: 'Pacifico', cursive;
	color: #8DAFC1;
	font-size: 1.75em;
	text-transform: none;
	font-weight: normal;
	text-decoration: none;
}

#logo:hover {
	color: rgba(61, 129, 172, 0.75);
}
	

	.menu{
		margin-top:0px;
		text-align:center;
	}
	
	.menu li{
		
	}
	
	.menu a{
		line-height:40px; 
		color:#353535; 
		padding:0 15px; 
		font-size:15px;
		font-weight:normal;
		display:block;
		}
		
	#h{
		margin-top:0px;
		float:left;
	}
	#sv{
		display:inline-block;
		
	}
	#r{
		display:inline-block;
	}
	#n{
		display:inline-block;
	}
	#s{
		display:inline-block;
	}
	
	#l{
		margin-right:25px;
		float:right;
	}
	#m{
		margin-right:0px;
		float:right;
	}
</style>
<script>

	$(function(){
		var msg = "<%=msg%>";
		if(msg != "null"){
			alert(msg);
			<%session.removeAttribute("msg");%>
		}
	});
</script>
</head>
<body>
	<header>
 		<ul class="menu">
			<li id="h"><a href="<%=request.getContextPath()%>" id="logo">arkadas</a>
 			<li id="s"><a href="<%=request.getContextPath()%>/self1.di">Self-diagnosis</a></li>
			<li id="n"><a href="<%=request.getContextPath()%>/list.nu">Nutrient
					collection</a></li> 			<li id="r"><a href="<%=request.getContextPath()%>/list.re">Reviews</a></li>
 			<li id="sv"><a href="<%=request.getContextPath()%>/MainNotice.no">Notices</a></li>
 			<% if(loginUser==null){ %>
 			<li id="l"><a href="<%=request.getContextPath()%>/loginForm.me">login</a></li>
 			<%} else{ %>
 			<li id="l"><a href="<%=request.getContextPath()%>/logout.me">logout</a></li>
 			<li id="m"><a href="<%=request.getContextPath()%>/myPage.me">myPage</a></li>
 			<%} %>
 		</ul>
	</header>
</body>
</html>