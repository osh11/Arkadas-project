<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
 int[] nutrious = (int[])request.getAttribute("nutrious");
   int[] nButton2 = (int[])request.getAttribute("nButton2");
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
a{
		color:#353535; }
        .wrap{
            
            height:2000px;
           
           
        }

        .wrap>*{width:100%;};
        #header{height:8%; background-color: white;}
        #content{height:92%; background-color:white; margin-top:120px;};
        #content_1{width:30%;}
        #content_2{width:70%;}

        #oh{
            width: 500px;
        }
        #oh input{
            float: left;
        }
        #oh label{
            float: left ;
        }
     
    </style>
</head>
<body>
  <%@ include file="../common/menubar.jsp" %>
  
    <div id="content">
       
            
           
           
           <div> 
               <center><img id="image" src="image/magnifier.png" width="50px"  ></center> 
           </div>
           <div>
            <center> <a>몸상태</a></center>
           </div>
           <br><br>
           <div>
            <center><a>해당되는 항목을 모두 골라주세요! </a></center>
        </div>
       
          <br><br><br>
          <form id="enrollForm"
			action="<%=request.getContextPath() %>/result.di" method="post">
         <center><div id="oh">
         
           <% if(nutrious!=null){ %>
         	<% for(int i : nutrious){ %>
				 	<input type="hidden" name="nutrious" value="<%=i%>">
			<% } %>
		<% }%>
		
			<input type="hidden" name="button11" id="button11" value="<%=nButton2[1]%>">
			<input type="hidden" name="button22" id="button22" value="<%=nButton2[2]%>">
			<input type="hidden" name="button33" id="button33" value="<%=nButton2[3]%>">
		
          <input type="checkbox" name="num1"  id="check">&nbsp;
          <label for="label1">&nbsp;심장질환</label>
          <br> <br> 
          <input type="checkbox" name="num2"  id="check">&nbsp;
          <label for="label2">&nbsp;간장질환</label>
          <br> <br> 
          <input type="checkbox" name="num3"  id="check">&nbsp;
          <label for="label3">&nbsp;신장질환</label>
          <br> <br> 
          <input type="checkbox" name="num4"  id="check">&nbsp;
          <label for="label4">&nbsp;갑상선질환</label>
          <br><br> 
          <input type="checkbox" name="num5"  id="check">&nbsp;
          <label for="label5">&nbsp;기관지</label>
          <br><br> 
          <input type="checkbox" name="num6"  id="check">&nbsp;
          <label for="label5">&nbsp;당뇨병</label>
          <br><br> 
          <input type="checkbox" name="num7"  id="check">&nbsp;
          <label for="label5">&nbsp;호르몬과민</label>
          <br><br> 
          <input type="checkbox" name="num8"  id="check">&nbsp;
          <label for="label5">&nbsp;출혈성 질환</label>
          <br><br> 
          <input type="checkbox" name="num9"  id="check">&nbsp;
          <label for="label5">&nbsp;암</label>
          <br><br> 
          <input type="checkbox" name="num10"  id="check">&nbsp;
          <label for="label5">&nbsp;혈액응고관련 질환</label>
          
        </div></center>
        
        <br><br>
         <center><button type="submit" id="button3">확인</button></center>
         <br><br> <br><br>
        </form>
        <script>
           
           $(function(){
                $("input:checkbox").css({"width":"20px","height":"20px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"})
           });
        </script>

        <script>
        $(function(){
            $("#button3").css({"background":"#D5D5D5","color":"black","width":"250px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","확인");
            
        });
      
        </script>    
            </div>
            
        
       </div>
</div>
      
    
</body>
</html>