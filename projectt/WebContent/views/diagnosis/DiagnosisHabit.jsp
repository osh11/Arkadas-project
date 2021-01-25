<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 int[] nutrious = (int[])request.getAttribute("nutrious");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta name="viewport" content="width=0, initial-scale=1.0">
    <title>Document</title>
    <style>
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
        #content_1{width:30%;}
        #content_2{width:70%;}

        #oh{
            width: 500px;
        }
     
        #oh label{
            float: left ;
        }
      
        

      

        a{
		color:#353535; }
     
       
        
        
        
    </style>
</head>
<body>
  
<%@ include file="../common/menubar.jsp" %>
  
    <div id="content">
       
           
           <div> 
               <center><img src="image/magnifier.png" width="50px"  ></center> 
           </div>
           <div>
            <center> <a>생활습관</a></center>
           </div>
         
       
          <br><br>
           <form id="enrollForm"
			action="<%=request.getContextPath() %>/result.di" method="post">
         <center><div id="oh">
         
         <% if(nutrious!=null){ %>
         	<% for(int i : nutrious){ %>
				 	<input type="hidden" name="nutrious" value="<%=i%>">
			<% } %>
		<% }%>
         
         	<input type="hidden" name="button11" id="button11" value="0">
			<input type="hidden" name="button22" id="button22" value="0">
			<input type="hidden" name="button33" id="button33" value="0">
			
			
          <label for="label1">&nbsp;현재 흡연 중이신가요? </label>
          <br><br>
          <input type="button" name="button1" id="button1"><a>&nbsp;<sup><strong><u>예</u></strong></sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
          <input type="button" name="button2" id="button2"><a>&nbsp;<sup><strong><u>아니오</u></strong></sup></a>
          <script>
             $(function(){
            
            $("#button2").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                
            
            $("#button1").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
              
             });
             $(function(){
            $("#button1").on("click",function()  {
                $("#button1").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button2").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button11").attr("value","1");
            });
            })
            $(function(){
            $("#button2").on("click",function()  {
                $("#button2").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button1").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button11").attr("value","0");
            });
            });

              
          </script>
         
          <br> <br> 
         
          <label for="label2">&nbsp;의약품이나 영양제를 복용한 뒤 속쓰림 증상이 종종 있나요?</label>
          <br> <br>
          <input type="button" name="button3" id="button3"><a>&nbsp;<sup><strong><u>예</u></strong></sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ㅔ>
          <input type="button" name="button4" id="button4"><a>&nbsp;<sup><strong><u>아니오</u></strong></sup></a>
          <script>
             $(function(){
            
            $("#button4").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               
            
            $("#button3").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
              
             });
             $(function(){
            $("#button3").on("click",function()  {
                $("#button3").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button4").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button22").attr("value","1");
            
            });
            })
            $(function(){
            $("#button4").on("click",function()  {
                $("#button4").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button3").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button22").attr("value","0");
             
            });
            });

              
          </script>
          <br><br>
          
          
          
          <label for="label3">&nbsp;음식에 대한 알러지 반응이 자주 나타나는 편인가요? </label>
          <br><br>
          <input type="button" name="button5" id="button5"><a>&nbsp;<sup><strong><u>예</u></strong></sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
          <input type="button" name="button6" id="button6"><a>&nbsp;<sup><strong><u>아니오</u></strong></sup></a>
          
          <script>
             $(function(){
            
            $("#button6").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                
            
            $("#button5").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
              
             });
             $(function(){
            $("#button5").on("click",function()  {
                $("#button5").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button6").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button33").attr("value","1");
            });
            })
            $(function(){
            $("#button6").on("click",function()  {
                $("#button6").css({"background":"#D5D5D5","color":"white","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button5").css({"background":"white","color":"black","width":"30px","height":"30px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
                $("#button33").attr("value","0");
            });
            });

              
          </script>
      
        </div></center>
        
         <br><br><br>
         <center><button type="submit" id="next_button">확인</button></center>
        </form>
        <br><br><br><br><br><br><br><br>
        <script>
           
           $(function(){
                $("input:checkbox").css({"width":"20px","height":"20px","box-shadow":"5px 5px 10px gray"})
           });
        </script>


        <script>
        $(function(){
            $("#next_button").css({"background":"#D5D5D5","color":"black","width":"250px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","확인");
            
        });
      
        </script>    
            </div>
            
        
       </div>
</div>
      
    
</body>
</html>