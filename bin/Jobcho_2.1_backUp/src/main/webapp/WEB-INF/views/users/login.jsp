<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>login</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/resources/login/css/login.css">

</head>
<body>
	<div id="wrap" class="job-login">
		<h1>JOBCHO</h1>
		
		<form action="/login" method="post">
			<div class="job-container">
				<div class="login-input">
					<p class="id-pass-inp">
						<input type="text" id="inputId" name="username" placeholder="아이디">
					</p>
					
					<p class="id-pass-inp">
						<input type="password" id="password" name="password" placeholder="비밀번호">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</p>
				</div>
	
			<div class="login-btn">
				<button type="submit">JOBCHO로그인</button>
			</div>
		</form>
		<br>
		<div>
			<a href="/users/findPw_1">힌트로 비밀번호 찾기</a>       <a href="/users/emailFindPw">이메일로 비밀번호 찾기</a>
		</div>
		
	</div>

	<p class="job-signup"><span>JOBCHO가 처음이신가요?</span>
	
	<a href="/users/register" >회원가입</a>

	
</body>
</html>