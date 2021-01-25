<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
	section{
		width:1000px;
		height:700px;
		margin:auto;
		margin-top:100px;
	}
	.insertForm{
		margin-top : 20px;
		align : center;
		display : inline-block;
	}
	.insertForm__table{
		margin : auto;
		align : center;
	}
	.insertForm__btn{
		margin-top : 20px;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	 <section>
	 <br>
	 	<h1><i class="fas fa-edit"></i> 리뷰 작성하기</h1>
        <div class="insertForm">
        	<form class="insertForm__table" action="<%=request.getContextPath()%>/insert.re" method="post" enctype="multipart/form-data" onsubmit = "return checkForm();">
	            <table align="center">
	            
	            	<!--  <input type="hidden" name="writer" id="writer" value="<%=loginUser.getUserId()%>">-->
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="title" id="title" size="25"></td>
					</tr>
	                <tr>
	                    <td>제품</td>
	                    <td colspan="2"><input type="text" name="sup" id="sup" size="10"></td>
	                </tr>
	                 <tr>
	                    <td>작성자</td>
	                    <td colspan="3"><input type="text" name="writer" id="writer" value="<%=loginUser.getUserId()%>" size="10" readonly></td>
	                </tr>
					<tr>
						<td>내용</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" id="content" cols="40" rows="15" style="resize:none;"></textarea>
						</td>
	                </tr>
	                <tr>
	                	<td>첨부 이미지</td>
	                	<td colspan="3">
	                		<input type="file" id="file" name="file" onclick="test();">
	                	</td>
	                </tr>
	                <tr>
	                    <td>비밀번호</td>
	                    <td colspan="2"><input type="text" id="pwd" name="pwd" size="10"></td>
	                </tr>
	            </table>
	            <div class="insertForm__btn">
	            	<button type="submit">등록하기</button>
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
        			var file = document.getElementById("file").value;
        			
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
        			}else if(file.length==""){
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