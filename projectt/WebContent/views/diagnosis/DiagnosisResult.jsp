<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<%
 ArrayList<String> result = (ArrayList<String>)request.getAttribute("result");
ArrayList<String> result2 = (ArrayList<String>)request.getAttribute("result2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');

	*{
	margin:0; 
	padding:0; 
	font-family:"Titillium Web";
	font-size:15px;
	}
	
	a{
	color:#353535;
	font-size:15px;
	}

	.outer{
		width:100%;
		height:600px;
		background:white;
		color:black;
		margin:auto;
		margin-top:10%;
	}
	.outer1{
		width:20%;
		height:200px;
		background:white;
		color:black;
		margin:auto;
		margin-top:18%;
		margin-left:20%;
		float:left;
	}
	.outer2{
		background:#D5D5D5;
		text-align:center;
		width:30%;
		height:300px;
		color:black;
		margin:auto;
		margin-top:18%;;
		margin-left:100px;
		float:left;
		display: table-cell;
      	vertical-align: middle;
      	border-radius: 40px 80px / 80px 40px;
      	
	}
	
	#result{
		font-size:17px;
	}
	
	.list{
		margin-top:10px;
	}
	
	li{list-style:none;font-size:15px;cursor:pointer}
	
	.clearfix{content: ''; display:block; clear:both;}

	.low{
		margin:auto;
		float:right;
		margin-top:40px;
		margin-right:30%;
	}
	
	#join{
        background-color: #353535;
        color:white;
        width:150px;
    }
	
</style>
<script>
	$(document).ready(function(){
			<%if(result2!=null&&result.size()>=1) {%>
            $("#first").click(function(){
            	$("#outer2").html("<%=result2.get(0)%>");
            });
            <%} %>
            <%if(result2!=null&&result.size()>=2){ %>
            $("#second").click(function(){
            	$("#outer2").html("<%=result2.get(1)%>");
            });
            <%} %>
            <%if(result2!=null&&result.size()>=3){ %>
            $("#third").click(function(){
            	$("#outer2").html("<%=result2.get(2)%>");
            });
            <%} %>
            <%if(result2!=null&&result.size()>=4){ %>
            $("#forth").click(function(){
            	$("#outer2").html("<%=result2.get(3)%>");
            });
            <%} %>
        });
	 $(function(){
		 <%if(result2!=null&&result.size()>=1) {%>
		 $("#outer2").html("<%=result2.get(0)%>");
          });
	 <%} %>
</script>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
		<div class="outer1">
			<a id="result">My Nutritions</a>
			<br><br>
			<ul class="list">
				<%if(result!=null&&result.size()>=1) {%>
	 			<li id="first"><a onclick="nutrious1();">• <%=result.get(0) %></a></li>
	 			<%} %>
	 			<%if(result!=null&&result.size()>=2){ %>
	 			<li id="second"><a onclick="nutrious2();">• <%=result.get(1) %></a></li>
	 			<%} %>
	 			<%if(result!=null&&result.size()>=3){ %>
	 			<li id="third"><a onclick="nutrious3();">• <%=result.get(2) %></a></li>
	 			<%} %>
	 			<%if(result!=null&&result.size()>=4){ %>
	 			<li id="forth"><a onclick="nutrious4();">• <%=result.get(3) %></a></li>
	 			<%} %>
	 		</ul>
 		</div>
 		
		<div class="outer2" id="outer2"></div>
		
		<!-- <div class="low"><input type="button" id="join" value="최저가 사러가기"></div> -->
	
	

</body>
</html>