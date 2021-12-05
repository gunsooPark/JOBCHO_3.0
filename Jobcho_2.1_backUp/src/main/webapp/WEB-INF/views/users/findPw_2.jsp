<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>find_hint</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="/resources/login/css/find.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<meta name="_csrf" content="${_csrf.token}"/>
	<script type="text/javascript">
	
	//security ajax를 사용하면 403에러가 발생하기 때문에 아래와 같은 코드를 작성해야됨 
	var csrfToken = $("meta[name='_csrf']").attr("content");
	
	$.ajaxPrefilter(function(options, originalOptions, jqXHR){
    	if (options['type'].toLowerCase() === "post") {
        	jqXHR.setRequestHeader('X-CSRF-TOKEN', csrfToken);
    	}
  	});
	
	function find_Pw2(){
		console.log("버튼눌림");
		
		$.ajax({
			url : "/users/findPw_2",
			type : "post",
			dataType : "json",
			data : {"user_pwHint" : $("#user_pwHint").val()},
			success : function(data){
				console.log(data);
				
				if(data==1){
					console.log("성공");					
					alert("성공")
					window.location.href = "/users/findPw_3";
				}else if(data == 0){
					console.log("실패");					
					alert("비밀번호가 틀렸습니다");
				}
			}
		})
	}
	
	</script>
</head>
<body>
	<div id="wrap" class="job-login">
		<h1>JOBCHO</h1>
		<div class="job-container">
			
		<div class="login-input">
			<p>본인이 졸업한 고등학교는 어디인가요?</p>
			<p class="id-pass-inp">
				<input type="text" id="user_pwHint" name="user_pwHint"  placeholder="본인확인 답 입력">
			</p>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</div>
	
		<div class="login-btn">
			<button type="button"  onclick="find_Pw2();">확인</button>
		</div>
	</div>
	
</body>
</html>