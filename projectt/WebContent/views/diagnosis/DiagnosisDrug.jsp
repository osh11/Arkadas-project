<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <center> <a>몸상태</a></center>
           </div>
           <br><br>
           <div>
            <center><a>복용중인 의약품을 모두 선택해주세요! </a></center>
        </div>
       
          <br><br><br>
         <center><div id="oh">
          <input type="checkbox" name="num1"  id="check">&nbsp;
          <label for="label1">&nbsp;항혈전제</label>
          <br> <br>
          <input type="checkbox" name="num2"  id="check">&nbsp;
          <label for="label2">&nbsp;혈압약</label>
          <br> <br>
          <input type="checkbox" name="num3"  id="check">&nbsp;
          <label for="label3">&nbsp;고지혈증약</label>
          <br> <br>
          <input type="checkbox" name="num4"  id="check">&nbsp;
          <label for="label4">&nbsp;항히스타민제</label>
          <br> <br>
          <input type="checkbox" name="num5"  id="check">&nbsp;
          <label for="label5">&nbsp;중추신경억제제</label>
          <br> <br>
          <input type="checkbox" name="num6"  id="check">&nbsp;
          <label for="label5">&nbsp;스테로이드제</label>
          <br> <br>
          <input type="checkbox" name="num7"  id="check">&nbsp;
          <label for="label5">&nbsp;소염진통제</label>
          <br> <br>
         
          
        </div></center>
        <script>
           
           $(function(){
                $("input:checkbox").css({"width":"20px","height":"20px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"})
           });
        </script>



        <br><br>
        <center><a href=""><input type="button" id="button3"></a></center>
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