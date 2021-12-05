<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>find</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="/resources/login/css/find.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="_csrf" content="${_csrf.token}"/>
	<script type="text/javascript">
	
	//security ajax를 사용하면 403에러가 발생하기 때문에 아래와 같은 코드를 작성해야됨 
	var csrfToken = $("meta[name='_csrf']").attr("content");

	$.ajaxPrefilter(function(options, originalOptions, jqXHR){
    	if (options['type'].toLowerCase() === "post") {
        	jqXHR.setRequestHeader('X-CSRF-TOKEN', csrfToken);
    	}
  	});
	
	
	function find_Pw(){
		console.log("버튼누름");
		$.ajax({
			url : "/users/findPw_1",
			type : "post",
			dataType : "json",
			data : {"user_email" : $("#user_email").val()},
			success : function(data){ // 성공할때 
					alert("success");
					console.log("성공");
					window.location.href = "/users/findPw_2"; //성공하면 왼쪽페이지로 이동한다.
			},
			error : function(error){
				console.log("실패");
				alert("이메일이 존재하지 않습니다.");
				return false;
			}
		})	
	}
	
	</script>
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" class="job-login">
		<h1>JOBCHO</h1>
		<div class="job-container">
			
		<div class="login-input">
			<p class="id-pass-inp">
				<input type="text" id="user_email" name="user_email" placeholder="이메일">
			</p>
		</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="login-btn">
			<button type="button" onclick="find_Pw();">비밀번호찾기</button>
		</div>
		</div>
	</div>
	
</body>
</html>