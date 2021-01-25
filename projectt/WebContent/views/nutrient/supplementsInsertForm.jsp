<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Arkadas</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />

</head>

<body>

	<%@ include file="../common/menubar2.jsp"%>
	<!-- 글 등록 -->
	
			<section id="footer">
				<div class="inner">
				<header>
				<h2 align="center">영양제 등록하기</h2>
				</header>
			<form id="insertForm" action="insert.nu" method="post" enctype="multipart/form-data">
				<table align="center">
				
					<!-- 이미지 -->
					<tr>
					<td><label>썸네일 이미지</label></td>
					<td colspan="3">
						<img id="titleImg" width="150" height="150">
					</td>
					</tr>
					
					<!-- 카테고리 -->
					<tr>
					<td><label>증상 카테고리</label></td>
					<td>
						<select name="sCategory" >
		                     <option value="10" style="color : black;">소화&장</option>
		                     <option value="20" style="color : black;">피부</option>
		                     <option value="30" style="color : black;">눈</option>
		                     <option value="40" style="color : black;">두뇌활동</option>
		                     <option value="50" style="color : black;">피로&간</option>
		                     <option value="60" style="color : black;">뼈&관절</option>
		                     <option value="70" style="color : black;">치아&잇몸</option>
		                     <option value="80" style="color : black;">면역</option> 
		                     <option value="90" style="color : black;">모발</option> 
                  		</select>
					</td>
					</tr>
					
					<!-- 1개씩 -->
					<tr>
						<td><label>영양제 코드</label></td>
						<td><input type="text" name="sCode"></td>
					</tr>
					<tr>
						<td><label>영양제 이름</label></td>
						<td><input type="text" name="sName"></td>
					</tr>
					<tr>
						<td><label>영양제 브랜드</label></td>
						<td><input type="text" name="sBrand"></td>
					</tr>
					<tr>
						<td><label>영양제 품번</label></td>
						<td><input type="text" name="sBno"></td>
					</tr>
					<tr>
						<td><label>영양제 용량</label></td>
						<td><input type="text" name="sSize"></td>
					</tr>
					<tr>
						<td><label>영양제 복용일</label></td>
						<td><input type="text" name="sTerm"></td>
					</tr>
					<tr>
						<td><label>영양제 원가</label></td>
						<td><input type="text" name="sPrice"></td>
					</tr>
					<tr>
						<td><label>영양제 최저가 주소</label></td>
						<td><input type="text" name="sUrl"></td>
					</tr>
					<tr>
						<td><label>영양제 복용 방법 1 (아침/점심/저녁)</label></td>
						<td><input type="text" name="sContent1"></td>
					</tr>
					<tr>
						<td><label>영양제 복용 방법 2 (식전/식후)</label></td>
						<td><input type="text" name="sContent2"></td>
					</tr>
					<tr>
						<td><label>영양제 복용 방법 3 (1일 몇회 몇정)</label></td>
						<td><input type="text" name="sContent3"></td>
					</tr>
					<tr>
						<td><label>영양제 가이드 1</label></td>
						<td><textarea cols="50" rows="3" name="guide1"></textarea></td>
					</tr>
					<tr>
						<td><label>영양제 가이드 2</label></td>
						<td><textarea cols="50" rows="3" name="guide2"></textarea></td>
					</tr>
					<tr>
						<td><label>영양제 가이드 3</label></td>
						<td><textarea cols="50" rows="3" name="guide3"></textarea></td>
					</tr>
					
					
					<!-- 효능 -->
					
					<tr>
					<td><label>영양제 효능 아이콘</label></td>
					<td>
						<img id="iconImg1" width="150" height="150">
					&nbsp;
						<img id="iconImg2" width="150" height="150">
					&nbsp;
						<img id="iconImg3" width="150" height="150">
					</td>
					</tr>
					<tr>
						<td><label>영양제 효능 메인 타이틀 1</label></td>
						<td><input type="text" name="efContentMain1"></td>
					</tr>
					<tr>
						<td><label>영양제 효능 서브 1</label></td>
						<td><textarea cols="50" rows="3" name="efContentSub1"></textarea></td>
					</tr>
					<tr>
						<td><label>영양제 효능 메인 타이틀 2</label></td>
						<td><input type="text" name="efContentMain2"></td>
					</tr>
					<tr>
						<td><label>영양제 효능 서브 2</label></td>
						<td><textarea cols="50" rows="3" name="efContentSub2"></textarea></td>
					</tr>
					<tr>
						<td><label>영양제 효능 메인 타이틀 3</label></td>
						<td><input type="text" name="efContentMain3"></td>
					</tr>
					<tr>
						<td><label>영양제 효능 서브 3</label></td>
						<td><textarea cols="50" rows="3" name="efContentSub3"></textarea></td>
					</tr>
					
					<!-- 2개씩 -->
					<tr>
						<td><label>영양제 성분 1</label></td>
						<td><input type="text" name="sEle1"></td>
					</tr>
					<tr>
						<td><label>영양제 성분 용량 1</label></td>
						<td><input type="text" name="sEleSize1"></td>
					</tr>
					<tr>
						<td><label>영양제 성분 설명 1</label></td>
						<td><textarea cols="50" rows="3" name="sEleContent1"></textarea></td>
					</tr>
					
					<tr>
						<td><label>영양제 성분 2</label></td>
						<td><input type="text" name="sEle2"></td>
					</tr>
					<tr>
						<td><label>영양제 성분 용량 2</label></td>
						<td><input type="text" name="sEleSize2"></td>
					</tr>
					<tr>
						<td><label>영양제 성분 설명 2</label></td>
						<td><textarea cols="50" rows="3"  name="sEleContent2"></textarea></td>
					</tr>
				</table>
				
				<div id="fileArea">
				<input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
				<input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
				<input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
				<input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
				
				
				
				</div>
				<div class="inner" align="center">
					<div class="3u 6u(small) 12u$(xsmall)">
							 <button class="button alt small" type="submit" align="center">작성하기</button>
							 
					</div>
				</div>
			</form>
			<div class="inner" align="center">
			<div class="3u 6u(small) 12u$(xsmall)">
			<button class="button alt small" onclick="goList();" align="center">목록으로</button>
			</div>
			</div>
			</section>
			
			
		<script>
		$(function(){
			$("#fileArea").hide();
			
			$("#titleImg").click(function(){
				$("#file1").click();
			});
			
			$("#iconImg1").click(function(){
				$("#file2").click();
			});
			
			$("#iconImg2").click(function(){
				$("#file3").click();
			});
			
			$("#iconImg3").click(function(){
				$("#file4").click();
			});
			
		});
		
		function loadImg(inputFile, num){
			console.dir(inputFile);
		
			if(inputFile.files.length == 1) {
				var reader = new FileReader();
				
				reader.readAsDataURL(inputFile.files[0]);
				
				reader.onload = function(e){
					switch(num) {
					case 1 : $("#titleImg").attr("src", e.target.result); break;
					case 2 : $("#iconImg1").attr("src", e.target.result); break;
					case 3 : $("#iconImg2").attr("src", e.target.result); break;
					case 4 : $("#iconImg3").attr("src", e.target.result); break;
					}
				};
			}
		}
			
	
			function goList(){
			
				location.href="<%=request.getContextPath()%>/list.nu";
			}
			
			</script>
	
</body>
</html>