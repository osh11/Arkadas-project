<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div, form, img, input{
   box-sizing: border-box;
}
#content{
    padding-top: 10%;
}
#content>div{height:100%}
#content_1{
   width:240px;
   /*width: 15%;*/
    position: fixed;
    height: 100%;
    /*position: fixed;*/
}
#content_2{
   	width:90%;
    float: right;
    
}
#sidebar{
margin-left: 20px;
}

#sidebar li{
    width : 40%;
    height: 100%;
    font-size: 15px;
    line-height: 50px;
    
}
#sidebar li a{
color:black
}

#sidebar li:hover>a:hover{
   text-decoration: underline;
 
}


#content_2 #prdList #prd #box{
    width: 15%;
    text-align: center;
    float: left;
    overflow: hidden;
    color:black;
}

/*이미지 크기 설정*/
#content_2 #prdList #prd #box img{
    width: 150px;
    height: 200px;
    position: relative;
}

#prdFont{
    height: 20px;
 
    color: black;
    overflow: hidden;
}
legend{
    visibility: hidden;
}
fieldset{
    border: none;
}
#content_2 #searchForm{
margin-right:20px}
#content_2 #searchForm #searchImg{
    float:right;
    width: 25px;
    height: 25px;
}
#content_2 #searchForm #keyword{
    float:right;
    border-top: 0;
    border-right: 0;
    border-left: 0;
}
#lookOp{
    margin:0;
    height: 40px;
    float: right;
    padding:0;
    
  
}
#lookOp li{
    float: left;
    width: 2px;
    height: 10px;
    text-align: center;
    font-size: 9px;
    line-height: 30px;
   
}
#lookOp .lookOpSel{
    float: left;
    width: 100px;
   
    text-align: center;
    font-size: 9px;
    line-height: 30px;
}
#look{
    float: left;
  
}
.thumbnail{
float:left;
margin-left:15px;}
.thumbnail p{
text-align : center;}

</style>
</head>
<body>
<div class = "wrab">
<%@ include file="../common/menubar.jsp"%>
<div id="content">
<div id="content_1">
                <ul id="sidebar">
                    <li><a href="<%=request.getContextPath() %>/list.nu">전체</a></li>
                    <li><a href="<%=request.getContextPath() %>/digestionList.nu">소화&장</a></li>
                    <li><a href="<%=request.getContextPath() %>/skinList.nu">피부</a></li>
                    <li><a href="<%=request.getContextPath() %>/eyeList.nu">눈</a></li>
                    <li><a href="<%=request.getContextPath() %>/brainList.nu">두뇌활동</a></li>
                    <li><a href="<%=request.getContextPath() %>/liverList.nu">피로&간</a></li>
                    <li><a href="<%=request.getContextPath() %>/boneList.nu">뼈&관절</a></li>
                    <li><a href="<%=request.getContextPath() %>/toothList.nu">치아&잇몸</a></li>
                    <li><a href="<%=request.getContextPath() %>/immunityList.nu">면역</a></li>
                    <li><a href="<%=request.getContextPath() %>/hairList.nu">모발</a></li>
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
                        <li class="lookOpSel" id="lookOpSel2"><a href="<%=request.getContextPath() %>/views/nutrient/nutrientCollection_popularity.jsp">인기순</a></li>
                        <li>/</li>
                        <li class="lookOpSel" id="lookOpSel3"><a href="">낮은 가격순</a></li>
                        <li>/</li>
                        <li class="lookOpSel" id="lookOpSel4"><a href="">높은 가격순</a></li>
                    </ul>
                    <script>
                        
                    </script>
                    <br><br>
                      
                    
                <hr>
                <div class="listArea">
			
			<div id="thumbnail">
			<!-- 
			<div class="thumb" align="center">
				<input type="hidden" value="1"> 
				<img src="<%=request.getContextPath()%>/resources/board_upfiles/2020121513395161442.png" width="250px" height="200px"> <br>
				<p>제목입니다.</p>
			</div>
			 -->
		</div>
			
			
		</div>
		<script>
		$(function(){
			selectTopList();
			//setInterval(selectTopList,2000); //2초마다 자동 갱신
			
			$("#thumbnail").on("click",".thumb",function(){
				var bId = $(this).children().eq(0).val();
				location.href = "<%=request.getContextPath()%>/detail.th?bId="+bId;
			});
		});
		function selectTopList(){
			$.ajax({
				url:"topList.nu",
				type:"post",
				success:function(list){
					console.log(list);
					var value = "";
					for(var i in list){
						value += '<div class="thumb" align="center">'+
								 '<input type="hidden" value="'+list[i].boardNo+'">'+
								 '<img src="<%=request.getContextPath()%>/resources/board_upfiles/'+list[i].titleImg+'"width="250px" height="200px"> <br>'+
								 '<p>'+list[i].sName+'</p>'+
								 '</div>';
					}
					
					$("#thumbnail").html(value);
				},
				error:function(){
					console.log("ajax 통신 실패")
				}
			});
		}
	</script>
		
                </div>
                </div>
                </div>

</body>
</html>