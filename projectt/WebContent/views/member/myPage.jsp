<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.sql.Date, com.kh.member.model.vo.Member, com.kh.member.model.vo.MemberNutrition" %>
<%
ArrayList<MemberNutrition> memberNutrition = (ArrayList<MemberNutrition>)request.getAttribute("memberNutrition");

Member m=(Member) request.getAttribute("loginUser");

String userId = m.getUserId();
String userPwd = m.getUserPwd();
String userName = m.getUserName();
String originPwd = (String)session.getAttribute("originPwd");

String email = m.getEmail() != null ? m.getEmail() : "";
Date age = m.getAge();

char gender =  m.getGender();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
    
@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');

*{margin:0; padding:0; font-family:"Titillium Web";
    }

    #id_text{
        width:350px;
        border-top:0;
        border-right:0;
        border-left:0;
        
        
        
    }
   
    .textform{
        border: 1px solid rgb(199, 197, 197);
        width:500px;
        height: 15px;
        border-width: 1px;
        line-break:initial;
        outline-color:rgb(87, 85, 85);
        
    }
    #modify{
        background-color: black;
        color:white;
        width:150px;
        float: right;
        
    }
     #deleteBtn{
        background-color: white;
        color:black;
        width:150px;
        float: right;
        
    }
    #main a{
        font : 11px 바탕체;
    }
    .h2 { padding: 0 0 15px 20px; background: 0 6px; font-size: 17px; color: #222; line-height: 100%;}
    .agree { 
        border: 1px solid #e6e6e6;
        width:500px;
    }
    .agree > div { overflow: auto; height: 124px; padding: 24px 19px; font-size: 13px; color: #555; line-height: 16px;}
    .agree > p { height: 1px; background:#f8f8f8; border-top: 1px solid #e6e6e6; line-height: 43px; font-size: 13px; color: #222; text-indent: 19px;}
    #mypage_button{
        float: right;
        
    }


</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>





    <div id="wrap">
    <br><br><br>
  
    
    
    
        
            
            <center><form id="updateForm"
			action="<%=request.getContextPath() %>/update.me" method="post">
               <table id=main>
                
                <input type="hidden" id="gender1" name="gender1" value="1">
                <input type="hidden" id="gender2" name="gender2" value="0">
                      
                    <tr>
                        <td><a>아이디 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="userId" value=<%=userId %> id="userid" class="textform" placeholder="ID"></td>
                        <td><button type="button" id="idCheckBtn" onclick="checkId();">중복확인</button></td>
                    </tr>
                    <tr>
                        <td><a>비밀번호 : </a></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="userPwd" value=<%=userPwd%> id="userPwd1"class="textform" placeholder="password"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><a>이름 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="userName" value=<%=userName %> id="name"class="textform"placeholder="NAME"></td>
                        <td><label id="nameResult"></label></td>
                    </tr>
                    <tr>
                        <td><a>이메일 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="email" name="email" value=<%=email%> id="email"class="textform"placeholder="E-mail"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><a>생년월일</a></td>
                        <tr>
    
                        </tr>
                        <td><input type="date" name="age" value=<%=age%> id="age" class="textform"><br></td>
    
                        </tr>
                    <tr>
                        <td><a>성별:</a> </td>
                    </tr>
                    <tr>
                        <td> <input type="button" id="button1"><a>남자</a></td>
                    </tr>
                    <tr>
                        <td><input type="button" id="button2" ><a>여자</a></td>   
                        
                    </tr>
                    <tr>
                        <td><h2>진단결과</h2></td>
                    </tr>
                    <tr>
                        
                        <td>
                        <div class="agree">
                            <div tabindex="0">
                               <div class="outer">
        <%if(memberNutrition.size()!=0){ %>
		<div class="outer1">
			<ul class="list">
	 			<li id="first"><a>1. <%=memberNutrition.get(0).getNutrition() %></a></li>
	 			<%if(memberNutrition.size()>=2){ %>
	 			<li id="second"><a>2. <%=memberNutrition.get(1).getNutrition() %></a></li>
	 			<%} %>
	 			<%if(memberNutrition.size()>=3){ %>
	 			<li id="third"><a>3. <%=memberNutrition.get(2).getNutrition() %></a></li>
	 			<%} %>
	 			<%if(memberNutrition.size()>=4){ %>
	 			<li id="forth"><a>4. <%=memberNutrition.get(3).getNutrition() %></a></li>
	 			<%} %>
	 		</ul>
 		</div>
 		<%} %>
	</div>
                                                        </div>
                            <p></p>
                        </div>
                    </td>
                    </tr>
                   
                    <tr>
                  
                        <td><input type="submit" id="modify" value="modify"></td>
                        
                    </tr>
 
                    <tr>
                         <td><input type="button" id="deleteBtn" value="탈퇴하기" onclick="deleteMember();"></td>
                    </tr>
                    
                </table>
            </form></center>
        </div>
      <script>
			
			function deleteMember(){
				var pwd = prompt("현재 비밀번호를 입력해주세요");
				if("<%= userPwd %>" == pwd){
					var val=confirm("정말로 탈퇴하시겠습니까?");
					
					if(val){
						$("#updateForm").attr("action","<%=request.getContextPath()%>/delete.me");
						$("#updateForm").submit();
					}else{
						alert("취소하였습니다.");
					}
				}
				else{
					alert("비밀번호를 잘못 입력하였습니다.");
				}
				return true;
			}
		</script>

        <script>
           
           
    
            $(function(){
           
            	<%if(gender=='m'){%>
           $("#button1").css({"outline":"none","background":"gray","color":"white","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
           $("#button2").css({"outline":"none","background":"white","color":"black","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
           $("#gender1").attr("value","1");
           $("#gender2").attr("value","0");
               <%}else{%>
           
               $("#button2").css({"outline":"none","background":"gray","color":"white","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               $("#button1").css({"outline":"none","background":"white","color":"black","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               $("#gender1").attr("value","0");
               $("#gender2").attr("value","1");
               <%}%>
            });
            $(function(){
           $("#button1").on("click",function()  {
               $("#button1").css({"background":"gray","color":"white","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               $("#button2").css({"background":"white","color":"black","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               $("#gender1").attr("value","1");
               $("#gender2").attr("value","0");
           });
           })
           $(function(){
           $("#button2").on("click",function()  {
               $("#button2").css({"background":"gray","color":"white","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               $("#button1").css({"background":"white","color":"black","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               $("#gender1").attr("value","0");
               $("#gender2").attr("value","1");
           
           });
           });
         </script>
       
	
	
</body>
</html>