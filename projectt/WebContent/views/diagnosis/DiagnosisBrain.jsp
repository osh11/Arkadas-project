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
            <center> <a>두뇌활동</a></center>
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
		
		<input type="hidden" name="type" value="3">
		
		
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label1">&nbsp;순간적으로 필요한 단어가 잘 떠오르지 않아요 </label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label2">&nbsp;물건을 뒀던 위치가 잘 기억나지 않아요.</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label3">&nbsp;평소 정리정돈이 서툰 편이에요.</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label4">&nbsp;전박적으로 기억력이 많이 감소된 것 같아요.</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label5">&nbsp;사람의 얼굴이나 전화번호를 외우는 것이 어려워졌어요.</label>
        </div></center>
        
        <br><br><br>
        <center><button type="submit" id="button3">확인</button></center>
        </form>
        
         <br><br><br><br> <br><br><br><br>
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