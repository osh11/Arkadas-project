<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
 <%
	ArrayList<Integer> array = (ArrayList<Integer>)request.getAttribute("array");
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
        #oh input{
            float: left;
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
            <center> <a>면역</a></center>
           </div>
           <br><br>
           <div>
            <center><a>해당되는 항목을 모두 골라주세요! </a></center>
        </div>
       
          <br><br><br>
         <form id="enrollForm"
			action="<%=request.getContextPath() %>/list2.di" method="post">
         <center><div id="oh">
        
         <% if(array!=null){ %>
         	<% for(int i : array){ %>
				 	<input type="hidden" name="array" value="<%=i%>">
			<% } %>
		<% }%>
		
		<% if(nutrious!=null){ %>
         	<% for(int i : nutrious){ %>
				 	<input type="hidden" name="nutrious" value="<%=i%>">
			<% } %>
		<% }%>
		
		<input type="hidden" name="type" value="7">
		
		
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label1">&nbsp;온도가 급격히 변하는 환경을 견디기 힘들어요 </label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label2">&nbsp;피곤할 때마다 입안이 헐거나 염증이 생겨요</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label3">&nbsp;강도 높은 운동을 주 3회 이상 해요</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label4">&nbsp;이전보다 신체활동이 급격히 늘었어요</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label5">&nbsp;평소 목넘김(침삼킴)에 불편함을 느껴요</label>
        </div></center>
        <br><br><br>
        <center><button type="submit" id="button3">확인</button></center>
                <br><br><br>
        <br> <br><br><br><br>
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