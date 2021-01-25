<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.nutrient.model.vo.*"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css" />
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
#sidebar li a{
    font-family: 'Noto Sans KR', sans-serif}
#lookOp a{
  	 font-family: 'Noto Sans KR', sans-serif;
    color:black;
    font-size:11px;
}
.thumbnail p{
font-family: 'Noto Sans KR', sans-serif;
font-size : 15px;}
#searchForm{
outline : none;
}
#keyword{
outline : none;}
</style>
</head>
<body>
	<div class="wrab">
		<%@ include file="../common/menubar.jsp"%>
		<div id="content">
			<div id="content_1">
				<ul id="sidebar">
					<li><a href="<%=request.getContextPath()%>/list.nu">전체</a></li>
					<li><a href="<%=request.getContextPath()%>/digestionList.nu">소화&장</a></li>
					<li><a href="<%=request.getContextPath()%>/skinList.nu">피부</a></li>
					<li><a href="<%=request.getContextPath()%>/eyeList.nu">눈</a></li>
					<li><a href="<%=request.getContextPath()%>/brainList.nu">두뇌활동</a></li>
					<li><a href="<%=request.getContextPath()%>/liverList.nu">피로&간</a></li>
					<li><a href="<%=request.getContextPath()%>/boneList.nu">뼈&관절</a></li>
					<li><a href="<%=request.getContextPath()%>/toothList.nu">치아&잇몸</a></li>
					<li><a href="<%=request.getContextPath()%>/immunityList.nu">면역</a></li>
					<li><a href="<%=request.getContextPath()%>/hairList.nu">모발</a></li>
				</ul>
			</div>

			<div id="content_2">

            <div id="searchForm">
            <form action="<%=request.getContextPath()%>/searchList.nu" method="post">
               <fieldset>
                  <legend>검색</legend>
                  <input id="searchImg" type="image" src="<%=request.getContextPath()%>/resources/images/돋보기.JPG"  width="200px" height="150px">
                   <input id="keyword" name="keyword" type="text">

               </fieldset>
               </form>
            </div>
				
					<ul id="lookOp">
						<li class="lookOpSel" id="lookOpSel1"><a
							href="<%=request.getContextPath()%>/skinTopList.nu">인기순</a></li>
						<li>/</li>
						<li class="lookOpSel" id="lookOpSel2"><a href="<%=request.getContextPath()%>/skinHighPrice.nu">낮은 가격순</a></li>
						<li>/</li>
						<li class="lookOpSel" id="lookOpSel3"><a href="<%=request.getContextPath()%>/skinLowPrice.nu">높은 가격순</a></li>
					</ul>
					
					<br>
					<br>


					<hr>
					<br>
					<div class="listArea">
						<%
							for (Board b : list) {
						%>
						<div class="thumbnail">
							<input type="hidden" value="<%=b.getBoardNo()%>"> <img
								src="<%=request.getContextPath()%>/resources/board_upfiles/<%=b.getTitleImg()%>"
								width="200px" height="200px"> <br>
							<p id="kk">
								
								<%=b.getsName()%></p>
							
						</div>
						<%
							}
						%>


						<br>
					</div>
					<%@ include file="../common/insertbtn.jsp"%>
				</div>
				<script>
			
				$(function(){
					$(".thumbnail").click(function(){
						var bId = $(this).children().eq(0).val();
						location.href="<%=request.getContextPath()%>/detail.nu?bId=" + bId;
					});
				});
				</script>
				
			</div>
		</div>

</body>
</html>