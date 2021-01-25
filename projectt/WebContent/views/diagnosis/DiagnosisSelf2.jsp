<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>Document</title>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300&display=swap');

		*{
		font-family:"Titillium Web";
		}
		a{
		color:#353535; }
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

        
    </style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

  
        <div id="content">
       
             <div> 
               <center><img class="topList" src='image/magnifier.png' width="50px"></img></center>
           </div>
           <div>
            <center><a id="head">기본정보</a></center>
           </div>
           <br><br>
        <div>
            <center><a>걱정되는 건강항목을 모두 선택하세요!</a></center>
        </div>
        <br><br>
       <form id="enrollForm"
			action="<%=request.getContextPath() %>/list.di" method="post">
			
			<input type="hidden" name="button11" id="button11" value="0">
			<input type="hidden" name="button22" id="button22" value="0">
			<input type="hidden" name="button33" id="button33" value="0">
			<input type="hidden" name="button44" id="button44" value="0">
			<input type="hidden" name="button55" id="button55" value="0">
			<input type="hidden" name="button66" id="button66" value="0">
			<input type="hidden" name="button77" id="button77" value="0">
			<input type="hidden" name="button88" id="button88" value="0">
			<input type="hidden" name="button99" id="button99" value="0">
			
          <div id="button">
            <center><pre><input type="button" name="button1" id="button1">   <input type="button" name="button2"  id="button2">   <input type="button" name="button3" id="button3"></pre></center>
           
          </div>
          <br>
          <div id="button">
            <center><pre><input type="button" name="button4" id="button4">   <input type="button" name="button5" id="button5">   <input type="button" name="button6" id="button6"></pre></center>
           
          </div>
          <br>
          <div id="button">
            <center><pre><input type="button" name="button7" id="button7">   <input type="button" name="button8" id="button8">   <input type="button" name="button9" id="button9"></pre></center>
           
          </div>
          
          <br><br><br><br>
          
          <center><button type="submit" id="next_button">확인</button></center>
          
          <br><br><br><br> <br><br><br><br>
         </form>
          
          <script>
          
          var button_switch=[0,0,0,0,0,0,0,0,0];
          
             $(function(){
                          
                $("#button1").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","소화&장");
                $("#button2").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","피부");
                $("#button3").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","눈");
                $("#button4").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","두뇌활동");
                $("#button5").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","피로감");
                $("#button6").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","뼈&관절");
                $("#button7").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","치아&잇몸");
                $("#button8").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","면역");
                $("#button9").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","모발");
                
			
          
            })
           
            $(function(){
                $("#button1").on("click",function()  {
                if(button_switch[0] == 0 ) {
                    $("#button1").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","소화&장");
                    $("#button11").attr("value","1");
                button_switch[0]=1;
                }else{
                    $("#button1").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","소화&장");
                    $("#button11").attr("value","0");
                    button_switch[0]=0;
                }

            });
            })
            $(function(){
                $("#button2").on("click",function()  {
                if(button_switch[1] == 0 ) {
                    $("#button2").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","피부");
                button_switch[1]=1;
                $("#button22").attr("value","2");
                }else{
                    $("#button2").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","피부");
                button_switch[1]=0;
                $("#button22").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button3").on("click",function()  {
                if(button_switch[2] == 0 ) {
                    $("#button3").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","눈");
                button_switch[2]=1;
                $("#button33").attr("value","3");
                }else{
                    $("#button3").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","눈");
                button_switch[2]=0;
                $("#button33").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button4").on("click",function()  {
                if(button_switch[3] == 0 ) {
                    $("#button4").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","두뇌활동");
                button_switch[3]=1;
                $("#button44").attr("value","4");
                }else{
                    $("#button4").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","두뇌활동");
                button_switch[3]=0;
                $("#button44").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button5").on("click",function()  {
                if(button_switch[4] == 0 ) {
                    $("#button5").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","피로감");
                button_switch[4]=1;
                $("#button55").attr("value","5");
                }else{
                    $("#button5").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","피로감");
                button_switch[4]=0;
                $("#button55").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button6").on("click",function()  {
                if(button_switch[5] == 0 ) {
                    $("#button6").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","뼈&관절");
                button_switch[5]=1;
                $("#button66").attr("value","6");
                }else{
                    $("#button6").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","뼈&관절");
                button_switch[5]=0;
                $("#button66").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button7").on("click",function()  {
                if(button_switch[6] == 0 ) {
                    $("#button7").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","치아&잇몸");
                button_switch[6]=1;
                $("#button77").attr("value","7");
                }else{
                    $("#button7").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","치아&잇몸");
                button_switch[6]=0;
                $("#button77").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button8").on("click",function()  {
                if(button_switch[7] == 0 ) {
                    $("#button8").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","면역");
                button_switch[7]=1;
                $("#button88").attr("value","8");
                }else{
                    $("#button8").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","면역");
                button_switch[7]=0;
                $("#button88").attr("value","0");
                }

            });
            })
            $(function(){
                $("#button9").on("click",function()  {
                if(button_switch[8] == 0 ) {
                    $("#button9").css({"background":"#D5D5D5","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","모발");
                button_switch[8]=1;
                $("#button99").attr("value","9");
                }else{
                    $("#button9").css({"background":"white","color":"black","width":"150px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","모발");
                button_switch[8]=0;
                $("#button99").attr("value","0");
                }

            });
            })
            
        

          </script>
        
          <script>
          $(function(){
              $("#next_button").css({"background":"#D5D5D5","color":"black","width":"250px","height":"50px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","확인");
              
          });
        
          </script>    
        
       </div>
      
    
</body>
</html>