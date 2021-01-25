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
    @import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');

		*{
		font-family:"Titillium Web";
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
            <center> <a>뼈&관절</a></center>
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
		
		<input type="hidden" name="type" value="5">
		
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label1">&nbsp;뼈 건강 및 관련 영양소 흡수에 도움이 되는 성분을 찾고 있어요 </label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label2">&nbsp;손톱/발톱이 자주 갈라지거나 깨지는 편이에요</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label3">&nbsp;골다공증에 대한 우려가 매우커요</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label4">&nbsp;일상적인 움직임에서 불편함을 느껴요</label>
          <br> <br>
          <input type="checkbox" name="check"  id="check">&nbsp;
          <label for="label5">&nbsp;목이나 허리가 자주 아파요</label>
        </div></center>
        <br><br><br>
        <center><button type="submit" id="button3">확인</button></center>
        <br><br><br><br> <br><br><br><br>
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