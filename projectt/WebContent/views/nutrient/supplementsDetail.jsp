<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, com.kh.nutrient.model.vo.*" %>
 <%
 	Board b = (Board)request.getAttribute("b");
 
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	
	Attachment titleImg = fileList.get(0);
	Attachment iconImg1 = fileList.get(1);
	Attachment iconImg2 = fileList.get(2);
	Attachment iconImg3 = fileList.get(3);
	
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
<meta charset="UTF-8">
<title>Arkadass</title>
</head>
<body>

<%@ include file="../common/menubar2.jsp" %>
		
		<!-- 상품 -->
			<section id="four">
				<div class="inner">
					<article class="alt">
						<a>
						<img width="500px" height="500px" id="titleImg" src="<%= request.getContextPath() %>/resources/board_upfiles/<%= titleImg.getChangeName() %>">
						</a>
					</article>
					<article class="content">
						<br><br><br>
						 <header>
							<h2><%= b.getsName() %></h2>
						</header>
							<p><%= b.getsBrand() %>ㅤ<%= b.getsBno() %> 번<br>
							<%= b.getsSize() %>ㅤ<%= b.getsTerm() %></p>
							<hr>
							<p>판매가ㅤㅤㅤㅤㅤㅤㅤㅤㅤ<%= b.getsPrice() %>원<br>
							</p>
						<br>
						<div class="3u 6u(small) 12u$(xsmall)">
							<ul class="actions vertical">
								<li><a href="<%= b.getsUrl() %>" target="_blank" class="button special fit">최저가</a></li>
							</ul>
						</div>
					</article>
				</div>
			
			
		<!-- 가이드 콘텐트 -->
				<br><br>
					<div class="inner">
						<article class="alt">
								<h3>복용 방법</h3>
								<ul>
									<li> <%= b.getsContent1() %> </li>
									<li> <%= b.getsContent2() %> </li>
									<li> <%= b.getsContent3() %> </li>
								</ul>
							</article>
						<article class="alt">
								<h3>추천 가이드</h3>
								<ul>
									<li> <%= b.getGuide1() %> </li>
									<li> <%= b.getGuide2() %> </li>
									<li> <%= b.getGuide3() %> </li>
								</ul>
						</article>
					</div>
				</section>
	
		<!-- 효능 -->
		<section id="two">
		<br>
			<div class="inner">
				
				<article>
					<div class="content">
						<img width="60px" height="60px" id="iconImg1" src="<%= request.getContextPath() %>/resources/board_upfiles/<%= iconImg1.getChangeName() %>">
						<header>
							<h4><%= b.getEfContentMain1() %></h4>
						</header>
						<p><%= b.getEfContentSub1() %></p>
					</div>
				</article>
				<article>
					<div class="content">
						<img width="60px" height="60px" id="iconImg2" src="<%= request.getContextPath() %>/resources/board_upfiles/<%= iconImg2.getChangeName() %>">
						<header>
							<h4><%= b.getEfContentMain2() %></h4>
						</header>
						<p><%= b.getEfContentSub2() %></p>
						
					</div>
				</article>
				<article>
				<div class="content">
					<img width="60px" height="60px" id="iconImg3" src="<%= request.getContextPath() %>/resources/board_upfiles/<%= iconImg3.getChangeName() %>">
						<header>
							<h4><%= b.getEfContentMain3() %></h4>
						</header>
						<p><%= b.getEfContentSub3() %></p>
					</div>
				</article>
			</div>
		</section>


	<!-- 성분 -->
	<section id="four">
		<div class="inner">
			<h3>이런 성분이 있어요</h3>
			<p>&nbsp; (일일 섭취량 기준)</p>
		</div>
		<div class="inner">
			<article class="alt">
				<header>
					<h3><%= b.getsEle1() %></h3>
					<h5><%= b.getsEleSize1() %></h5>
				</header>
				<p><%= b.getsEleContent1() %></p>
				</article>
			<article class="alt">
				<header>
					<h3><%= b.getsEle2() %></h3>
					<h5><%= b.getsEleSize2() %></h5>
				</header>
				<p><%= b.getsEleContent2() %></p></article>
		</div>
	</section>
		
	<section id="four">
		<div class="inner">
		<ul class="actions">
		<li><a onclick="goSBoard();" class="button special big">목록으로</a></li>
		</ul>
		</div>
	</section>
	
	
	<script>
	function goSBoard(){
		location.href="<%= request.getContextPath() %>/list.nu";
	}

	</script>
	
	</body>
</html>