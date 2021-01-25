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
        
        
        
    }
   
    .textform{
        border: 1px solid rgb(199, 197, 197);
        width:500px;
        height: 15px;
        border-width: 1px;
        line-break:initial;
        outline-color:rgb(87, 85, 85);
        
    }
    #join{
        background-color: black;
        color:white;
        width:150px;
        float: right;
        visibility: hidden;
    }
    #main a{
       font-size:11px;
    }
    .h2 { padding: 0 0 15px 20px; background: 0 6px; font-size: 17px; color: #222; line-height: 100%;}
    .agree { 
        border: 1px solid #e6e6e6;
        width:500px;
    }
    .agree > div { overflow: auto; height: 124px; padding: 24px 19px; font-size: 13px; color: #555; line-height: 16px;}
    .agree > p { height: 43px; background:#f8f8f8; border-top: 1px solid #e6e6e6; line-height: 43px; font-size: 13px; color: #222; text-indent: 19px;}
  
    


</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	
    <div id="wrap">
    <br><br><br>
			
            <center><form  id="enrollForm"
			action="<%=request.getContextPath() %>/insert.me" method="post"
			onsubmit="return joinValidate();">
			<br><br><br>
                <table id=main>
                
                <input type="hidden" id="gender1" name="gender1" value="1">
                <input type="hidden" id="gender2" name="gender2" value="0">
                      
                    <tr>
                        <td><a>아이디 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="userId" id="userid" class="textform" placeholder="ID"></td>
                        <td><button type="button" id="idCheckBtn" onclick="checkId();">중복확인</button></td>
                    </tr>
                    <tr>
                        <td><a>비밀번호 : </a></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="userPwd" id="userPwd1"class="textform" placeholder="password"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><a>비밀번호 확인 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="password" name="checkPwd" id="userPwd2"class="textform" placeholder="password_check"></td>
                        <td><label id="pwdResult"></label></td>
                    </tr>
                    <tr>
                        <td><a>이름 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="userName" id="name"class="textform"placeholder="NAME"></td>
                        <td><label id="nameResult"></label></td>
                    </tr>
                    <tr>
                        <td><a>이메일 :</a> </td>
                    </tr>
                    <tr>
                        <td><input type="email" name="email" id="email"class="textform"placeholder="E-mail"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><a>생년월일</a></td>
                        <tr>
    
                        </tr>
                        <td><input type="date" name="age" id="age" class="textform"><br></td>
    
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
                        <td><h2>이용약관</h2></td>
                    </tr>
                    <tr>
                        
                        <td>
                        <div class="agree">
                            <div tabindex="0">
                            제1조(목적)
                            이 약관은 아크다스 회사가 운영하는 아크다스 사이버 몰(이하 몰이라 한다.)에서 제공하는 인터넷 관련 서비스(이하 서비스라 한다.)
                            를 이용함에 있어 사이버 몰과 이용자의 권리, 의무 및 책임 사항을 규정함을 목적으로 합니다.
                            <br>
                            ※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」<br>

제2조(정의)
① “몰”이란 아크다스 회사가 재화 또는 용역(이하 “재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.<br>
② “이용자”란 “몰”에 접속하여 이 약관에 따라 “몰”이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.<br>
③ ‘회원’이라 함은 “몰”에 (삭제) 회원등록을 한 자로서, 계속적으로 “몰”이 제공하는 서비스를 이용할 수 있는 자를 말합니다.<br>
④ ‘비회원’이라 함은 회원에 가입하지 않고 “몰”이 제공하는 서비스를 이용하는 자를 말합니다.<br>

제3조 (약관 등의 명시와 설명 및 개정)
① “몰”은 이 약관의 내용과 상호 및 대표자 성명, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함), 전화번호․모사전송번호․전자우편주소, 사업자등록번호, 통신판매업 신고번호, 개인정보보호책임자등을 이용자가 쉽게 알 수 있도록 킨다베이지 사이버몰의 초기 서비스화면(전면)에 게시합니다. 다만, 약관의 내용은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다.<br>
② “몰은 이용자가 약관에 동의하기에 앞서 약관에 정하여져 있는 내용 중 청약철회․배송책임․환불조건 등과 같은 중요한 내용을 이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을 제공하여 이용자의 확인을 구하여야 합니다.<br>
                                                        </div>
                            <p><input type="checkbox" id="chk1"><label for="chk1">홈페이지  이용약관에 동의합니다.(동의하지 않을경우 가입되지 않습니다.)</label></p>
                        </div>
                    </td>
                    </tr>
                   
                    <tr>
                  
                        <td><input type="submit" id="join" value="join" disabled></td>
                        
                        
                    </tr>
                    
                </table>
                <br><br><br><br><br>
            </form></center>
        </div>
      

        <script>
        
		function joinValidate(){
			
			if(!(/^[a-z][a-z\d]{3,11}$/i.test($("#enrollForm input[name=userId]").val()))){
				$("#enrollForm input[name=userId]").focus();
		        return false;
			}
			
			 if(!(/^[가-힣]{2,}$/.test($("#enrollForm input[name=userName]").val()))){
				 $("#enrollForm input[name=userName]").focus();
		        return false;
			 }
			 
			 return true;
			
		}
		
           
            $("#chk1").change(checkedChange);
        
            function checkedChange(){
                     

            if($(this).prop("checked"))
                $("#join").css("visibility","visible");           

            else
                $("#join").css("visibility","hidden");
                
            }
    
            $(function(){
           
           $("#button1").css({"outline":"none","background":"gray","color":"white","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
               
           
           $("#button2").css({"outline":"none","background":"white","color":"black","width":"15px","height":"15px","border-radius":"50px","border-style":"hidden","box-shadow":"5px 5px 10px -4px gray"}).attr("value","");
             
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
        <script>
        function checkId(){
			var userId = $("#enrollForm input[name=userId]");
			if(userId.val()==""){
				alert("아이디를 입력해주세요");
				return false;
			}
			$.ajax({
				url: "idCheck.me",
				type:"post",
				data:{userId:userId.val()},
				success:function(result){
					if(result=="fail"){
						alert("사용할수 없는 아이디입니다.");
						userId.focus();
					}else{//사용가능
						if(confirm("사용가능한 아이디 입니다. 사용하시겠습니까?")){
							userId.attr("readonly","true");
							$("#join").removeAttr("disabled");
							
						}else{
							userId.focus();
						}
					
					}
				},
				error:function(){
					console.log("서버통신실패");
				}
			})
		}
        
            $(function() {
                         
            

            $('#checkPwd').change(function(){
                if($("#userPwd").val()==$(this).val()){
                   
                }else{
                    window.alert("비밀번호가 일치하지 않습니다.")
                    $('#checkPwd').val('');
                    $(this).select();
                }
            });


          
        });
        
        </script>
       

</body>
</html>