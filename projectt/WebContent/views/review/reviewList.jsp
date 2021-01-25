<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList, com.kh.review.model.*"%>
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currPage = pi.getCurrPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/earlyaccess/nanumgothiccoding.css" rel="stylesheet" type="text/css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
	section{
		width:1000px;
		height:700px;
		margin:auto;
		margin-top:100px;
	}
	.listArea{
		font-family: 'Nanum Gothic Coding';
		width : 800px;
		heigh : 600px;
		margin : auto;
	}
	
	.searchArea{
		font-family: 'Nanum Gothic Coding';
		margin-top : 20px;
		margin-left: 120px;
	}
	
	#searchArea__submit{
		font-weight : bold;
		width : 90px;
		hegiht: 40px;
		background-color : lightgray;
		border : 1px solid lightgray;
		border-radius : 10px;
	}
	
	#searchArea__submit:hover{
		cursor:pointer
	}
	
	#searchArea__keyword{
		border : 1px solid gray;
		border-radius : 20px;
	}
	.review{
		width : 30%;
		margin-top : 20px;
		margin-left : 10px;
		display : inline-block;
		background-color : rgb(231, 231, 231);
		border-radius : 5%;
		font-size: 12px;
	}
	.review>a{
		font-color : black;
		font-size : 15px;
		font-weight : bold;
	}
	
	.review>p>span{
		font-size : 15px;
		border-weight : bold;
	}
	
	#writeBtn{
		font-weight : bold;
		width : 80px;
		hegiht: 40px;
		background-color : lightgray;
		border : 1px solid lightgray;
		border-radius : 10px;
	}
	
	#writeBtn:hover{
		cursor:pointer
	}
	
	.headline { 
		font-family: 'Jeju Gothic'; 
		font-size : 45px;
		color : skyblue;
	}
	.subhead{
		font-family: 'Nanum Gothic Coding';
		font-size : 15px;
		font-weight : bold;
		color : rgb(38, 56, 56);
	}
	
	.pagingArea{
		font-family: 'Jeju Gothic';
		color : skyblue; 
		margin-right : 150px;
	}
	
	.pagingArea>button{
		background-color : white;
		color : skyblue;
		border : 1px solid white;
		
		
	}
	.pagingArea>button:hover{
		cursor : pointer;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<section>
		<br><br><br>
		<h1 class="headline"> 고객 리뷰 <i class="fas fa-capsules"></i></h1>
		<br>
		<p class="subhead">영양제 이용 후기 입니다.</p><br>
		<%if (loginUser!=null){ %>
        <button onclick="goWrite();" id="writeBtn">작성하기</button>
        <%} %>
        <form method="get" action="<%=request.getContextPath()%>/search.re" class="searchArea">
        	<input type="text" id="searchArea__keyword" name="keyword">
        	<input type="submit" value="영양제 검색 " id="searchArea__submit">
        </form>
        <div class="pagingArea" align="right">
        	페이지  
        	<button onclick="location.href='<%=request.getContextPath() %>/list.re?currPage=1'">&lt;&lt;</button>
        	<%if(currPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= contextPath %>/list.re?currPage=<%= currPage-1 %>'"> &lt; </button>
			<%} %>
        	<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath %>/list.re?currPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
        	<%if(currPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= contextPath %>/list.re?currPage=<%= currPage+1 %>'"> &gt; </button>
			<%} %>
        	<button onclick="location.href='<%=contextPath%>/list.re?currPage=<%=maxPage%>'"> &gt;&gt; </button>        	
        </div>
        <div class="listArea">
			<%if(list.isEmpty()){ %>
                	<br><br><br>이용후기가 존재하지 않습니다.
                	<%}else{ %>
	                	<% for(Review review : list){ %>
	                		<div class="review" align="center">
	                			<input type="hidden" value="<%= review.getReviewNo() %>"><br>
	                			<p>
	                				<span><%= review.getReviewTitle() %></span><br>
	                				<%= review.getReviewWriter() %> / <%= review.getReviewDate() %><br>
	                				<%= review.getSupCode() %>
	                			</p>
	                			<img src="<%=request.getContextPath()%>/resources/uploaded/<%=review.getImage()%>" width="200px" height="150px"><br>
	                			<a href="<%=request.getContextPath()%>/detail.re?rno=<%=review.getReviewNo()%>">더보기</a>	                			 
	                		</div>	 	                		
	                	<%} %>
                	<%} %>                            
            <br><br>
		</div>
        <script>
        	function goWrite(){
        		location.href="<%=request.getContextPath()%>/insertForm.re";
        	}
        	
        </script>
    </section>
</body>
</html>