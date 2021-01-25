<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.review.model.Review" import="com.kh.review.model.Attachment" %>
<%
	Review review = (Review)request.getAttribute("review");
	Attachment image = (Attachment)request.getAttribute("image");
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
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
	
	.detailForm{
		font-family: 'Nanum Gothic Coding';
		width : 500px;
		height : 400px;
		margin-left : 50px;
		margin-top : 40px;
		align : center;
		display : inline-block;
		border-radius : 20px;
		background-color : rgb(245, 240, 240);
	}
	.detailForm__table{
		font-family: 'Nanum Gothic Coding';
		width : 90%;
		margin-left : 25px;
		margin-top : 20px;
		align : center;
	}
	#dateArea{
		float : right;
		margin-right : 30px;
	}
	#supArea, #writerArea{
		float : left;
		margin-left : 30px;
	}
	#contentArea{
		margin-left : 30px;
	}
	
	.detailForm__btn{
		margin-top : 50px;
		margin-left : 120px;
		
	}
	.detailForm__btn>input{
		margin-left : 20px;
	}
	
	.headline { 
		font-family: 'Jeju Gothic'; 
		font-size : 40px;
		color : rgb(65, 65, 163);
	}
	
	.btn{
		font-weight : bold;
		width : 80px;
		hegiht: 40px;
		background-color : lightgray;
		border : 1px solid lightgray;
		border-radius : 10px;
	}
	
	.btn:hover{
		cursor:pointer
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<section>
	
       <h1 class="headline"><i class="fas fa-clipboard-list"></i> 리뷰 상세보기</h1>
        <div class="detailForm">
	            <table class="detailForm__table" align="center">
					<tr>
						<th colspan="2"><%=review.getReviewTitle()%></th>
					</tr>
					<tr>
						<td id="writerArea"><%=review.getReviewWriter() %></td>
						<td id="dateArea"><%=review.getReviewDate() %></td>
	                </tr>
	                <tr>
	                    <td colspan="2" id="supArea"><%=review.getSupCode()%></td>
	                </tr>
	                <tr>
	                	<th colspan="2">
	                		<p id="imgArea">
	                			<img src="<%=request.getContextPath()%>/resources/uploaded/<%=image.getChangeName()%>" width="200px" height="150px">
	                		</p>
	                	</th>
	                </tr>
					<tr>
						<td colspan="2" id="contentArea">
							<p>
								<%=review.getReviewContent() %>
							</p>
						</td>
					</tr>
	            </table>
	            <div class="detailForm__btn">
	            	<%if (loginUser!=null){ %>
	            	<button onclick="goUpdate();" class="btn">수정하기</button> &nbsp &nbsp &nbsp
	            	<button onclick="goDelete();" class="btn">삭제하기</button>
	            	<%} %>
	            	<input type="button" onclick="goBack();" value="돌아가기" class="btn">
	        	</div>
	        	<script>
	        		function goBack(){
	        			location.href="<%=request.getContextPath()%>/list.re";
	        		}
	        		
	        		function goUpdate(){
                		var pwd = prompt("비밀번호를 입력해주세요");
                		
                		if("<%=review.getReviewPwd() %>"==pwd){
                			location.href="<%=request.getContextPath()%>/updateForm.re?rno=<%=review.getReviewNo()%>";
                		}else{
                			alert("잘못 입력하셨습니다.");
                		}
                	}
	        		
	        		function goDelete(){
						var pwd = prompt("비밀번호를 입력해주세요");
                		if("<%=review.getReviewPwd() %>"==pwd){
                			var check = confirm("정말 삭제하시겠습니까?");
                			if(check == true){
                    			location.href="<%=request.getContextPath()%>/deleteR.re?rno=<%=review.getReviewNo()%>";                				
                			}else{
                				return;
                			}
                		}else{
                			alert("잘못 입력하셨습니다.");
                		}
	        		}
	        	</script>
        </div>        
    </section>
</body>
</html>