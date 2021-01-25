<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        outline:none;
        
        
    }
    #login_button{
        width:350px;
        height:50px;
        background-color:white;
        outline:none;

    }



</style>

</head>
<body>
	<%@ include file="menubar.jsp" %>
    
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
    
    <form id="loginForm" action="<%=request.getContextPath()%>/login.me" method="post" onsubmit="return loginValidate();">
    <center><input type=text id=id_text name="userId" placeholder=ID></center>
  
    <br>
    <center><input type=password id=id_text name="userPwd" placeholder=Password></center>
  
    <br>
    <center><button type="submit" id="login_button" value="Sign in">Sign in</button></center>
    <center><a href="<%= request.getContextPath() %>/enrollForm.me">Create Account</a></center>
    
    </form>
   
    <script>
        $(function(){
           $("#login_button").on("click",function()  {
               $("#login_button").css("border-style","inset");
              
           });

           $("#login_button").mouseleave(function(){
                console.log("LEAVE!!");
            });
           });
   </script>
   
</body>
</html>