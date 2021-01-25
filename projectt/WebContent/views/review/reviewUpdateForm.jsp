<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.review.model.Review" import="com.kh.review.model.Attachment"%>
<%
	Review review = (Review)request.getAttribute("review");
	review.setReviewContent(review.getReviewContent().replaceAll("<br>","\n"));
	Attachment image = (Attachment)request.getAttribute("image");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
	section{
		width:1000px;
		height:700px;
		margin:auto;
		margin-top:100px;
	}
	.updateForm{
		margin-top : 20px;
		align : center;
		display : inline-block;
	}
	.updateForm__table{
		margin : auto;
		align : center;
	}
	.updateForm__btn{
		margin-top : 20px;
	}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
	 <section>
	 	<h1><i class="fas fa-edit"></i> 리뷰 작성하기</h1>
        <div class="insertForm">
        	<form class="insertForm__table" action="<%=request.getContextPath()%>/update.re" method="post" enctype="multipart/form-data" onsubmit = "return checkForm();">
	            <input type="hidden" name="rno" value=<%=review.getReviewNo() %>>
	            <table align="center">
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title" id= "title" size="25" value="<%=review.getReviewTitle()%>"></td>
					</tr>
					<tr>
	                    <td>작성자</td>
	                    <td colspan="3"><input type="text" name="writer" id="writer" size="10" value="<%=review.getReviewWriter() %>" ></td>
	                </tr>
	                <tr>
	                    <td>제품</td>
	                    <td colspan="3"><input type="text" name="sup" id="sup" size="10" value="<%=review.getSupCode()%>"></td>
	                </tr>
					<tr>
						<td>내용</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" id="content" cols="40" rows="15" style="resize:none;"><%=review.getReviewContent() %></textarea>
						</td>
	                </tr>
	                <tr>
	                	<td>첨부 이미지</td>
	                	<td colspan="3">
		                	<% if(image != null){ %> <!-- 기존의 첨부파일이 있었을 경우 -->
								<%= image.getOriginName() %> <br>
								<input type='hidden' name='originFile' value='<%=image.getChangeName()%>'>
								<input type='hidden' name='originFileNo' value='<%=image.getFileNo()%>'>
							<% }%>
							<input type="file" name="upFile" id="upFile">
	                	</td>
	                </tr>
	                <tr>
	                    <td>비밀번호</td>
	                    <td colspan="3"><input type="text" name="pwd" id="pwd" size="10" value="<%=review.getReviewPwd()%>"></td>
	                </tr>
	            </table>
	            <div class="insertForm__btn">
	            	<button type="submit">수정하기</button>
	            	<input type="button" onclick="goBack();" value="돌아가기">
	        	</div>
	        	<script>
	        		function goBack(){
	        			location.href="<%=request.getContextPath()%>/list.re";
	        		}
	        	</script>
        	</form>
        	<script>
	        	function checkForm(){
	    			var title = document.getElementById("title").value;
	    			var writer = document.getElementById("writer").value;
	    			var content = document.getElementById("content").value;
	    			var sup = document.getElementById("sup").value;
	    			var pwd = document.getElementById("pwd").value;
	    			var file = document.getElementById("upFile").value;
	    			
	    			if(title == "" || title.length<1){
	    				alert("제목을 입력해주세요");
	    				return false;
	    			}else if(writer == "" || writer.length<1){
	    				alert("작성자명을 입력해주세요");
	    				return false;
	    			}else if(sup==""||sup.length<1){
	    				alert("제품명을 입력해주세요");
	    				return false;
	    			}else if(content==""||content.length<1){
	    				alert("후기 내용을 입력해주세요");
	    				return false;
	    			}else if(pwd==""||pwd.length<1){
	    				alert("비밀번호를 입력해주세요");
	    			}else if(upFile.length==""){
	    				alert("사진을 첨부해주세요");
	    				return false;
	    			}else{
	    				return true;
	    			}
	    		}
        	</script>
        </div>
    </section>
</body>
</html>