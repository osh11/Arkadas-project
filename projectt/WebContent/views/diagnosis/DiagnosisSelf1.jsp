<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');

		*{
		font-family:"Titillium Web";
		}
		a{
		color:#353535; 
		}
         div, form, input, img{
            /* border:1px solid red; */
            box-sizing: border-box;
        }

        .wrap{
            height:500px;
        }
        .wrap>*{width:100%;};
        #header{height:8%; background-color: white;}
        #content{height:92%; background-color:white; margin-top:200px;};
    </style>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>

        <div id="content">
        

           <div> 
               <center><img src="image/document.PNG" width="50px"  ></center> 
           </div>
           <div>
            <center> <a>기본정보</a></center>
           </div>
           <br>
          <div>
              <center><input type="text"><a>년생</a></center> 
            <script>
                 $(function(){
                $("input:text").attr("value","1996").css({"width":"100px","height":"30px","background-color":"white","border-style":"none","box-shadow":"0px 5px 1px -4px gray"})
            });
            </script>
             
          </div>
          <br><br><br><br>
          
          <center><pre><input type="button" id="button1">          <input type="button" id="button2"></pre></center>
          <script>
             $(function(){
            
            $("#button1").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","남성");
                
            
            $("#button2").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","여성");
              
             });
             $(function(){
            $("#button1").on("click",function()  {
                $("#button1").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","남성");
                $("#button2").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","여성");
            });
            })
            $(function(){
            $("#button2").on("click",function()  {
                $("#button2").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","여성");
                $("#button1").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","남성");
            });
            });

              
          </script>
            <br><br><br><br>
                <center><a href="<%=request.getContextPath()%>/self2.di"><input type="button" id="button3"></a></center>
            <script>
            $(function(){
                $("#button3").css({"background":"#D5D5D5","color":"black","width":"250px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","확인");
                
            });
          
            </script>
            </div>
       </div>
</body>
</html>