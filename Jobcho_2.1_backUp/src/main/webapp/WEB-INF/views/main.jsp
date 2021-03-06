<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<meta charset='utf-8'>
<title>Page Title</title>
<!-- fullcalendar CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
<!-- fullcalendar locale CDN==================== -->
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment-with-locales.min.js"></script>
<!-- FullCalendar -->

<script src="https://kit.fontawesome.com/1628dac045.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>



<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
	type="text/css">
<!-- 부가적인 테마 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    -->
<link rel="stylesheet" type="text/css"
	href="/resources/main/css/codingBoostr.css">
<link rel="stylesheet" type="text/css"
	href="/resources/main/css/sidebar-right.css">
<link rel="stylesheet" type="text/css"
	href="/resources/main/css/sidebar-search.css">
<link rel="stylesheet" type="text/css"
	href="/resources/main/css/sidebar-left.css">
<link rel="stylesheet" type="text/css"
	href="/resources/main/css/content.css">
<link rel="stylesheet" type="text/css"
	href="/resources/main/css/team.css">
<link rel="stylesheet" type="text/css"
	href="/resources/chat/css/chat.css">
<link rel="stylesheet" type="text/css"
	href="/resources/chat/css/dragableChat.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="/resources/main/css/sidebar-search.js"></script>
</head>
<body>
	<header>
		<div class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">JOBCHO</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a id="inviteSearch" href="#"
							role="button" data-target="#modal" data-toggle="modal"
							aria-haspopup="true" aria-expanded="false"><ion-icon
									name="person-add-outline" class="navbar-icon"></ion-icon>팀원초대</a></li>
					</ul>

				</div>
			</div>
		</div>

	</header>
    
    

	<!--왼쪽 사이드바-->
	<!--왼쪽 사이드바-->
	<!--왼쪽 사이드바-->

	<div class="l-navbar-left" id="navbar-left">
		<nav class="nav-left">
			<div>
				<div class="nav__brand-left">
					<ion-icon name="menu-outline" class="nav__toggle-left"
						id="nav-toggle-left"></ion-icon>
				</div>

				<!--프로필-->
				<div>
					<div class="nav-profile-image-left"
						></div>
					<div class="nav-profile-content-left">
						<p>${team.team_name }</p>
						<p><sec:authentication property="principal.users.user_email"/></p>
						<p><sec:authentication property="principal.users.user_name"/></p>
					</div>
				</div>
				<!--프로필 끝-->
				
				<!-- =====게시판===== -->
				<div>
					
					<h3>토픽 
						<a href="#" class="collapse__sublink-left" id="createBoard" data-target="#boardModal" data-toggle="modal">
							<ion-icon name="add-outline"></ion-icon>
						</a>
					</h3>
					<!-- 게시판 -->
					<div class="nav__list-left nav__scroll-left" id="board">
						
						
						
					</div>	
					<!-- =====게시판 끝===== -->



					<!-- 풀커뮤니티 스크롤-->
					<!-- 풀커뮤니티 스크롤-->
					<h3>
						채팅 <a href="#" id="createChatRoom" class="collapse__sublink-left"
							onclick="onChatting(event)"><ion-icon name="add-outline"></ion-icon></a>
					</h3>
					<div id="chatRoomList" class="nav__list-left nav__scroll-left">

					</div>
					<!-- 풀커뮤니티 스크롤 끝-->
					<!-- 풀커뮤니티 스크롤 끝-->
				</div>

			</div>

			<a href="#" class="nav__link-left"  id="LogOutAction"> <ion-icon
					name="log-out-outline" class="nav__icon-left"></ion-icon> <span
				class="nav__name-left">Log Out</span>
			</a>
		</nav>
	</div>

	<!--왼쪽 사이드바 끝-->
	<!--왼쪽 사이드바 끝-->
	<!--왼쪽 사이드바 끝-->

	<!--오른쪽 사이드바-->
	<!--오른쪽 사이드바-->
	<!--오른쪽 사이드바-->

	<div class="l-navbar-right navbar-font-right" id="navbar-right">
		<nav class="nav-right">
			<div>
				<div class="nav__brand-right">
					<ion-icon name="menu-outline" class="nav__toggle-right"
						id="nav-toggle-right"></ion-icon>
				</div>
				<div class="nav__list-right">
					<a href="#" id="toggle-key-home"
						class="nav__link-right active-right"> <ion-icon
							name="home-outline" class="nav__icon-right"></ion-icon> <span
						class="nav__name-right">Dashboard</span>
					</a> <a href="#" id="toggle-key" class="nav__link-right"> <ion-icon
							name="search-outline" class="nav__icon-right"></ion-icon> <span
						class="nav__name-right">Search</span>
					</a> <a href="#" id="toggle-key2" class="nav__link-right"> <ion-icon
							name="calendar-outline" class="nav__icon-right"></ion-icon> <span
						class="nav__name-right">ToDoList</span>
					</a> <a href="#" id="toggle-key3" class="nav__link-right"> <ion-icon
							name="football-outline" class="nav__icon-right"></ion-icon> <span
						class="nav__name-right">Files</span>
					</a> <a href="#" id="toggle-key-member" class="nav__link-right"> <ion-icon
							name="people-outline" class="nav__icon-right"></ion-icon> <span
						class="nav__name-right">Members</span>
					</a>
				</div>
			</div>

			<a href="#" class="nav__link-right" id="LogOutAction"> <ion-icon
					name="log-out-outline" class="nav__icon-right"></ion-icon> <span
				class="nav__name-right">Log Out</span>
			</a>
		</nav>
	</div>

	<!--오른쪽 사이드바 끝-->
	<!--오른쪽 사이드바 끝-->

	<!--오른쪽 사이드서치바-->
	<!--오른쪽 사이드서치바-->
	<!--오른쪽 사이드서치바-->
	<div class="search-navbar-right navbar-font-search" id="navbar-search">
		<nav class="nav-search">
			<div class="nav-search-title">검색</div>
			<div class="nav-search-content">
				<input type="text" class="form-control" placeholder="검색어 입력">
				<ul class="nav-search-category">
					<li>전체</li>
					<li>메시지</li>
					<li>할일</li>
					<li>투표</li>
					<li>파일</li>
				</ul>
				<ul class="nav-search-option">
					<SELECT NAME=sltSample SIZE=1> 토픽
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION> 채팅
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>

					</SELECT>
					<SELECT NAME=sltSample SIZE=1>
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>
					</SELECT>
					<SELECT NAME=sltSample SIZE=1>
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>
					</SELECT>
				</ul>
				<div class="nav-search-result-scroll">
					<div class="nav-search-result active-right">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					<div class="nav-search-result active-right">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					<div class="nav-search-result ">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					<div class="nav-search-result ">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					<div class="nav-search-result ">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					<div class="nav-search-result active-right">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!--오른쪽 사이드서치바 끝-->
	<!--오른쪽 사이드서치바 끝-->

	<!--오른쪽 사이드서치바2-->
	<!--오른쪽 사이드서치바2-->
	<!--오른쪽 사이드서치바2-->
	<div class="search-navbar-right navbar-font-search" id="navbar-search2">
		<nav class="nav-search">
			<div class="nav-search-title">할일</div>
			<div class="nav-search-content">
				<div id="createToDo" style="cursor:pointer">➕할일생성</div>
				<div id="selectTodoDeleteList" style="cursor:pointer">완료된 할일보기</div>
				<!-- <ul class="nav-todo-option">
					<SELECT NAME=sltSample SIZE=1> 토픽
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION> 채팅
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>

					</SELECT>
					<SELECT NAME=sltSample SIZE=1>
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>
					</SELECT>

				</ul> -->
				
				<div class="nav-search-result-scroll">
					<div class="job-todolist-wrap" style="cursor:pointer">
					<div class="nav-search-result active-right">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!--오른쪽 사이드서치바2 끝-->
	<!--오른쪽 사이드서치바2 끝-->

<!--오른쪽 사이드서치바3-->
	<!--오른쪽 사이드서치바3-->
	<!--오른쪽 사이드서치바3-->
	<div class="search-navbar-right navbar-font-search" id="navbar-search3">
		<nav class="nav-search">
			<div class="nav-search-title">투표</div>
			<div class="nav-search-content">
				<div id="createVote">➕투표생성</div>
				<div id="end-vote-list">▶이전투표</div>
				<!-- <ul class="nav-todo-option">
					<SELECT NAME=sltSample SIZE=1> 토픽
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION> 채팅
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>

					</SELECT>
					<SELECT NAME=sltSample SIZE=1>
						<OPTION VALUE=1>1번 보기입니다.</OPTION>
						<OPTION VALUE=2>2번 보기입니다.</OPTION>
						<OPTION VALUE=3>3번 보기입니다.</OPTION>
						<OPTION VALUE=4 SELECTED>4번 보기입니다.</OPTION>
					</SELECT>

				</ul> -->
				<div class="nav-search-result-scroll">
				<div class="job-vote-wrap" style="cursor:pointer">
					<div class="nav-search-result active-right">
						<div class="result-container">
							<div class="result-image"
								style="background-image: url('99D279435B3D788602.jfif');"></div>
							<div>
								<p class="team-profile-name">최지훈</p>
								<p class="team-profile-email">2015/21/505</p>
								<p class="team-profile-email">이건또 어떻게</p>
								<p class="team-profile-email">공지사항</p>

							</div>
						</div>
					</div>
					<hr>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!--오른쪽 사이드서치바3 끝-->
	<!--오른쪽 사이드서치바3 끝-->



	<!-- 컨텐츠 시작-->
	<!-- 컨텐츠 시작-->
	<div class="body-content" id="body-pd-left">
		<div class="job-team-body2"></div>
		

		<div class="job-team-body">
			
		</div>
	</div>
	<!-- 컨텐츠 끝-->
	<!-- 컨텐츠 끝-->

	<!-- 로그아웃 -->
	<form action="/customLogout" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<!-- modal 모음-->
	<div class="row">
		<div class="modal" id="modal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						팀원초대
						<button id="inviteModalClose" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<input type="text" id="inviteUserSearchbar" class="form-control"
							placeholder="이름 또는 이메일 입력" autocomplete='off'>
						<div class="modal-scroll">
							<ul id="invite-list-group" class="list-group">
								<li class="list-group-item">
									<div class="thumnail-profile"></div> Lorem
									<button class="badge">초대</button>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 팀원들의 개인정보 수정 -->
		<div class="modal" id="updataAdminModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						직책수정
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					
					<div id="profile_img">
						<input type="file" name='uploadFile' id="profile_img_upload">
						<button id="profile_img_upload_action">프로필 업로드</button>
						<img src="">
					</div>
					<div class="modal-body">
						<input type="text" class="form-control updatePosition"
							placeholder="직책 입력"> <input id="updateMemberAction"
							type="button" class="btn btn-info" value="수정">
						<div class="modal-scroll">
							<ul class="list-group">

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 팀원용 개인정보 수정 -->
		<div class="modal" id="updataModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						정보수정
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<input id="deleteMemberAction" type="button"
							class="btn btn-danger" value="탈퇴">
						<div class="modal-scroll">
							<ul class="list-group">

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 팀장용 팀관리 수정 -->
		<div class="modal" id="updataTeamModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						팀설정
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control updatePosition"
							placeholder="직책 입력"> <input id="updateMemberAction"
							type="button" class="btn btn-info" value="수정">
						<div class="modal-scroll">
							<ul class="list-group">

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 오늘의 할일 생성 모달 -->
		<div class="modal" id="insertTodoListInfoModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						오늘의 할일 생성
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">

						오늘의 할일<input id="todo_title" type="text" class="form-control">
						내용<input id="todo_description" type="text" class="form-control">
						마감날짜<input id="todo_endDate" type="date" class="form-control">
						<input id="member_num" type="hidden" class="form-control" value="${param.member_num}"> 
						<input id="team_num" type="hidden" class="form-control" value="${param.team_num}">
						<input id="insertTeamAction" type="button" class="btn btn-primary" onclick="insertTodoListAction();" value="생성">

					</div>
				</div>
			</div>
		</div>
		<!-- 오늘의 할일 수정 모달 -->
		<div class="modal" id="updateTodoListInfoModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						오늘의 할일 수정
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">

						<input id="updateTodoNum" type="hidden"> 
						오늘의 할일<input id="updateTodoTitle" type="text" class="form-control"> 
						내용<input id="updateTodoDescription" type="text" class="form-control">
						마감날짜<input id="updateTodoEnd" type="date" class="form-control">
						<input id="updateTodoAction" type="button" class="btn btn-info" value="수정"> 
						<input id="deleteTodoAction" type="button" class="btn btn-danger" value="삭제">
					</div>
				</div>
			</div>
		</div>
		
		<!-- 달력 모달 -->
		<!-- calendar  -->
		<!-- Calendar Modal -->
		<div class="modal calendar_modal" id="CalModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						Calendar
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<input type="hidden" class="form-control" id="cal_num"
							name="cal_num" value="cal_num"> 일정<br> <input
							type="text" class="form-control" id="title" name="일정" value="">
						일정 시작 시간<input type="date" class="form-control" id="starts"
							name="일정시작시간" value=""> 일정 종료 시간<input type="date"
							class="form-control" id="ends" name="일정 종료 시간" value="">
						하루종일<input type="text" class="form-control" id="allday"
							name="하루종일 true = 1 or false = 0" value=""> <br> <input
							type="button" class="btn btn-success" onclick="newEvent()"
							value="생성" id="saveBtn">
						<div class="modal-scroll">
							<ul class="list-group">

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Calendar End -->
		
		<!-- 채팅방 추가 모달 -->
		<div class="modal" id="insertChatRoomModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						채팅방 생성
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<input id="insertChatRoomName" type="text" class="form-control"
							placeholder="채팅방이름">
						<hr>
						<input type="text" id="inviteChatMemberSearchbar"
							class="form-control" placeholder="초대할 멤버 이름 또는 이메일 입력">
						<div class="modal-scroll">
							<ul id="invite-chat-list" class="list-group">
							</ul>
						</div>
						<hr>
						초대멤버
						<div class="modal-scroll">
							<ul id="invite-wait-list" class="list-group">
							</ul>
						</div>
						<input id="createRoomAction" type="button" class="btn btn-primary"
							value="생성">
					</div>
				</div>
			</div>
		</div>
		<!-- 채팅방 추가 모달 끝-->
		
		<!-- 채팅멤버 추가 모달 -->
		<div class="modal" id="inviteMemberModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						채팅방 초대
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<input type="text" id="inviteChatMemberSearchbar2"
							class="form-control" placeholder="초대할 멤버 이름 또는 이메일 입력">
						<div class="modal-scroll">
							<ul id="invite-chat-list2" class="list-group">
							</ul>
						</div>
						<hr>
						초대멤버
						<div class="modal-scroll">
							<ul id="invite-wait-list2" class="list-group">
							</ul>
						</div>
						<input id="createRoomAction2" type="button" class="btn btn-success"
							value="초대">
					</div>
				</div>
			</div>
		</div>
		<!-- 채팅멤버 추가 모달 끝-->
		
		<!-- 게시판 생성 모달창 -->
      <div class="modal" id="boardModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">게시판 등록</h4>
            </div>
            <div class="modal-body">
              <div class="form-group">
               		<label>게시판 이름</label> 
                	<input class="form-control" name='board_name' value=''>
              </div>      
              <div class="form-group">
                	<label>게시판 정보</label> 
                	<input class="form-control" name='board_info' value=''>
              </div>
            </div>
            
			<div class="modal-footer">
        		<button id='modalRegisterBtn' type="button" class="btn btn-primary">등록</button>
        		<button id='modalCloseBtn' type="button" class="btn btn-default">취소</button>
       		</div>
	</div>
  </div>
</div><!--  게시판 생성모달 끝-->

		<!-- 투표 생성 모달 -->
	<div class = "modal" id ="insertVoteModal" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						투표 생성
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
						
						투표 제목<input id="vote_name" type="text" class="form-control"> 
						투표 내용1<input id="vote_content1" type="text" class="form-control">
						투표 내용2<input id="vote_content2" type="text" class="form-control">
						투표 내용3<input id="vote_content3" type="text" class="form-control">
						투표 내용4<input id="vote_content4" type="text" class="form-control">
						투표 내용5<input id="vote_content5" type="text" class="form-control">
						<input id="member_num" type="hidden" class="form-control" value="${param.member_num}">
						<input id="team_num" type="hidden" class="form-control" value="${param.team_num}">
 						<input id="insertVoteAction" type="button" class="btn btn-primary" value="투표 생성">
						
					</div>
				</div>
			</div>
	</div>	
	<!-- 투표 생성 모달 끝 -->
	
	<!-- 투표창 확인 모달 -->
	<div class = "modal" id ="voting" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						투표 확인
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
					<div class="job-vote-result-wrap" style="cursor:pointer">	
						
						
					</div>
				</div>
			</div>
	</div>
	</div>	
	<!-- 투표창 확인 모달 끝 -->
	
	<!-- 투표결과 확인 모달 -->
	<div class = "modal" id ="voteResult" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						투표 결과
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
					<div class="job-vote-result-view-wrap" style="cursor:pointer">	
						
						
					</div>
				</div>
			</div>
	</div>	
	</div>
	<!-- 투표결과 확인 모달 끝 -->
	
	
	<!-- 투표결과 멤버확인 모달 끝 -->
	
		<!-- 투표 완료확인 모달 -->
	<div class = "modal" id ="end-list-vote-modal" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						투표 결과
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
					<div class="job-vote-end-view-wrap" style="cursor:pointer">	
						
						
					</div>
				</div>
			</div>
	</div>	
	</div>
	<!-- 투표결과 완료확인 모달 끝 -->
	
			<!-- 완료된 투표 확인 모달 -->
	<div class = "modal" id ="end-list-vote-result-modal" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						투표 결과
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
					<div class="job-vote-end-result-view-wrap" style="cursor:pointer">	
						
						
					</div>
				</div>
			</div>
	</div>	
	</div>
	<!-- 완료된 투표 확인 모달 끝 -->
	
		<!-- 투표결과 멤버확인 모달 -->
	<div class = "modal" id ="voteResultMember" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						투표 결과
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
					<div class="job-vote-result-member-view-wrap" style="cursor:pointer">	
						
						<div class="jo"></div>
						
					</div>
				</div>
			</div>
		</div>	
	</div>
	
	<!--삭제된 오늘의 할일 모달 -->
	<div class = "modal" id ="selectTodoDeleteListModal" tabindex = "-1">
		<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						완료된 오늘의 할일
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="vote-modal-body">
					<div class="job-vote-result-member-view-wrap" style="cursor:pointer">	
						<div class="job-todoDeletelist-wrap" style="cursor:pointer">
							
					</div>
				</div>
			</div>
		</div>	
	</div>
	<!--삭제된 오늘의 할일 모달 끝 -->
	
		
		<!-- 게시판 board_num 계속 유지시키기 -->
    	<form id='actionForm' action="/post/list" method='get'>
				<input type='hidden' name='board_num' value='${pageMaker.cri.pageNum}'>
				<input type='hidden' name='team_num' value='${param.team_num}'>
				<input type='hidden' name='member_num' value='${param.member_num }'>
		</form>
		
		
		

	</div> <!-- 전체모달 div마지막 -->
		
		
		
		


	
	<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
	<script src="/resources/main/css/sidebar-right.js"></script>
	<script src="/resources/main/css/sidebar-left.js"></script>
	<script src="/resources/members/js/todoList.js"></script>
	<script src="/resources/chat/js/onchat.js"></script>
	<script src="/resources/chat/js/dragable.js"></script>
	<script src="/resources/board/board.js?version=20211206"></script>
	<script src="/resources/members/js/vote.js"></script>
	<script src="/resources/members/js/memberProfile.js"></script>
	<!-- 외부js에 변수 전달 -->
	<input type="hidden" id="userName"
		value="<sec:authentication property="principal.users.user_name"/>">

	<input type="hidden" id="userNum"
		value="<sec:authentication property="principal.users.user_num"/>">

	<input type="hidden" id="teamNum" value=${param.team_num }>

	<input type="hidden" id="memberNum" value=${param.member_num }>



<script type="text/javascript">
	
	//security ajax를 사용하면 403에러가 발생하기 때문에 아래와 같은 코드를 작성해야됨 
	var csrfToken = $("meta[name='_csrf']").attr("content");

	$.ajaxPrefilter(function(options, originalOptions, jqXHR){
		if (options['type'].toLowerCase() === "post") {
	    	jqXHR.setRequestHeader('X-CSRF-TOKEN', csrfToken);
		}
		});
	
	
	//오늘의 할일 추가 모달 이벤트 
	$(document).on("click","#createToDo" ,function(e){
		e.preventDefault();
		console.log("클릭");
		$("#insertTodoListInfoModal").modal("show");
		updataMemberNum = this.value
	});
	
	
	//로그아웃 클릭시 로그아웃 되도록  
	$(document).on("click","#LogOutAction" ,function(e){
		e.preventDefault();
		console.log("클릭");
		alert("로그아웃되었습니다.")
		$('#logoutForm').submit();
	});
		
	</script>


	<script>
	//멤버리스트와 수정모달
        $(document).ready(function(){
        	//초대할 유저 검색 리스트
        	var searchUserList = null;
        	
        	//현재 팀 넘버
        	var team_num=${param.team_num}; 
        	
        	//로그인한 유저 넘버
        	var user_num=$("#userNum").val();
        	
        	
        	
        	//컨텐츠바디에 현재팀의 멤버리스트 출력
        	function showMemberList(result){
        		str=""
        		console.log("멤버리스트 출력")
        		var teamMaster = result[0].team.user_num;
        		console.log(user_num+"and"+teamMaster)
        		//팀장일때
        		if(user_num==teamMaster){
        			result.forEach(function(item){
	                    if(item.user.user_num==user_num){
	                    	str =`<div class="job-container">
                                <div class="team-profile-image" style="background-image: url('/display?filename=`+item.profile_name+`');"></div>
                                <div class="team-profile-info">
                                    <p class="team-profile-name">`+item.user.user_name+`</p>
                                    <p class="team-profile-email">`+item.user.user_email+`</p>
                                    <p class="team-profile-email">`+item.user.user_phoneNum+`</p>
                                    <p class="team-profile-email">`+item.member_position+`</p>
                                </div>
                                <div class="team-btn">
                                    <button class="updataAdminModal" value="`+item.member_num+`">수정</button>
                                    <button class="updataTeamModal" value="`+item.member_num+`">팀설정</button>
                                </div>
                            </div>`+str;
	                    }else{
	                    	str +=`<div class="job-container">
                                <div class="team-profile-image" style="background-image: url('/display?filename=`+item.profile_name+`');"></div>
                                <div class="team-profile-info">
                                    <p class="team-profile-name">`+item.user.user_name+`</p>
                                    <p class="team-profile-email">`+item.user.user_email+`</p>
                                    <p class="team-profile-email">`+item.user.user_phoneNum+`</p>
                                    <p class="team-profile-email">`+item.member_position+`</p>
                                </div>
                                <div class="team-btn">
                                    <button class="updataAdminModal" value="`+item.member_num+`">수정</button>
                                </div>
                            </div>`;
	                    }
	                    
	          
	                });
	                $(".job-team-body").html(str);
	            //팀원일때
        		}else{
        			result.forEach(function(item){
        				if(item.user.user_num==user_num){
	                    	str =`<div class="job-container">
                                <div class="team-profile-image" style="background-image: url('/display?filename=`+item.profile_name+`');"></div>
                                <div class="team-profile-info">
                                    <p class="team-profile-name">`+item.user.user_name+`</p>
                                    <p class="team-profile-email">`+item.user.user_email+`</p>
                                    <p class="team-profile-email">`+item.user.user_phoneNum+`</p>
                                    <p class="team-profile-email">`+item.member_position+`</p>
                                </div>
                                <div class="team-btn">
                                    <button class="updataModal" value="`+item.member_num+`">수정</button>
                                </div>
                            </div>`+str;
	                    }else{
	                    	str +=`<div class="job-container">
                                <div class="team-profile-image" style="background-image: url('/display?filename=`+item.profile_name+`');"></div>
                                <div class="team-profile-info">
                                    <p class="team-profile-name">`+item.user.user_name+`</p>
                                    <p class="team-profile-email">`+item.user.user_email+`</p>
                                    <p class="team-profile-email">`+item.user.user_phoneNum+`</p>
                                    <p class="team-profile-email">`+item.member_position+`</p>
                                </div>
                            </div>`;
	                    }
	          
	                })
	                $(".job-team-body").html(str);
        		};
            };   
            //현재 팀의 멤버 리스트 재출력
            function reloadMemberList(){
            	$.ajax({
                    url:'/team/'+team_num+'/member',
                    type:'Get',
                    processData:false,
                    contentType:'application/json',
                    dataType:'json',
                    success:function(result){
                        
                        console.log(result);
                        
                        showMemberList(result);

                    }
                });
            };
			
            //초대할 수 있는 유저 리스트 보여줌
            function showUserSearchList(result){
            	str=""
                    result.forEach(function(item){
                        
                        str +=`<li class="list-group-item">
                                        <div class="thumnail-profile"></div>
                                        `+item.user_name+"__"+item.user_email+`<button id="inviteMember" class="badge " value="`+item.user_num+`">초대</button>
                                    </li>`
              
                    })
                    $("#invite-list-group").html(str);
            }    
            
            //초대할 수 있는 유저 리스트를 불러옴
            function showUserSearchListAction(){
            	$.ajax({
                    url:'/team/'+team_num+'/member/withoutmember',
                    type:'Get',
                    processData:false,
                    contentType:'application/json',
                    
                    dataType:'json',
                    success:function(result){
                    	searchUserList= result
                        console.log(result);
                        showUserSearchList(result);
                    }
                });//$.ajax
            }
            
            $("#toggle-key-member").on("click",function(){
            	//처음 페이지 로드 시 멤버 리스트 호출
            	reloadMemberList();
            })
            
            
            //수정하고싶은 멤버의 번호 초기화
            var updataMemberNum=0;
            
            //팀장의 멤버 정보 수정 모달 호출
            $(document).on("click",".updataAdminModal" ,function(e){
            	$("#updataAdminModal").modal("show");
            	updataMemberNum = this.value
            });
            
            //팀원의 멤버 정보 수정 모달 호출
            $(document).on("click",".updataModal" ,function(e){
            	$("#updataModal").modal("show");
            	updataMemberNum = this.value
            });
            
            //팀장의 팀 정보 수정 모달 호출
            $(document).on("click",".updataTeamModal" ,function(e){
            	$("#updataTeamModal").modal("show");
            	updataMemberNum = this.value
            });
            
            //멤버 정보 수정 모달에서 수정엑션
            $("#updateMemberAction").on("click", function(e){
            	console.log({"member_position":$(".updatePosition").val()})
            	var position = $(".updatePosition").val()

            	$.ajax({
                    url:'/team/'+team_num+'/member/'+updataMemberNum,
                    type:'put',
                    
                    contentType:'application/json',
                    data: JSON.stringify({"member_position":position}),
                    dataType: 'json',
                    success:function(result){
                    	alert("수정완료")
                    	$("#updataAdminModal").modal("hide");
                        console.log(result);
                        reloadMemberList();
                    }
                });
            	
            	
            });
            
            $("#updateMemberAction").on("click", function(e){
            	var file = $(this).parent().parent().find("input[name='uploadFile']")[0].files;
            	console.log($(this).parent().parent().find("input[name='uploadFile']")[0].files)
    			$(this).parent().find("input[name='uploadFile']").clone();
    			
    			  console.log( file)
    			  var formData = new FormData();
    			  for(var i = 0; i<file.length; i++){
    				  formData.append("uploadFile", file[i])
    			  }
            	$.ajax({
			        url:'/team/'+team_num+'/member/'+updataMemberNum+'/uploadprofile',
			        type:'Post',
			        processData:false,
			        contentType:false,
			        data:formData,
			        success:function(result){
			        	console.log(result)
			        	console.log("upload succss");
			        	
			        }
		  		});// $.ajax
            });
            
            //초대할 유저검색 모달 호출
            $("#inviteSearch").on("click", function(){
            	showUserSearchListAction();
            });
            
            //멤버 초대 모달에서 유저를 멤버로 초대 
            $(document).on("click","#inviteMember",function(){
            	console.log("초대 실행")
            	$.ajax({
                    url:'/team/'+team_num+'/member/invite',
                    type:'Post',
                    processData:false,
                    contentType:'application/json',
                    data:JSON.stringify({"member_position": "",
                        "team_num": team_num,
                        "user_num": this.value}),
                    dataType:'json',
                    success:function(result){
                        
                        console.log(result);
                        alert("초대완료")
                        searchUserList = result;
                        showUserSearchListAction();
                        
                    }
                });//$.ajax
            	
            });
            
            //멤버초대 모달 닫기 + 현재 팀의 멤버 리스트 재출력
            $("#inviteModalClose").on("click",function(){
            	console.log("모달 닫음")
            	reloadMemberList();
            });
            
            //멤버 초대 모달의 검색바에서 검색어와 일치하는 유저 검색
            $('#inviteUserSearchbar').keyup(function(){
    			var keyword = $(this).val()
    			var str=""
    			searchUserList.forEach(function(user,index){
    				console.log(index);
    				console.log(user);
    				console.log();
    				if(((keyword==user.user_email.substr(0,keyword.length))||(keyword==user.user_name.substr(0,keyword.length)))&& keyword.length!=0){
    					str +=`<li class="list-group-item">
                            <div class="thumnail-profile"></div>
                            `+user.user_name+"__"+user.user_email+`<button id="inviteMember" class="badge " value="`+user.user_num+`">초대</button>
                        </li>`
                        
    				};
    			});
    			
    			$("#invite-list-group").html(str);
    		});
            
            //멤버탈퇴
            $('#deleteMemberAction').on('click', function(){
            	
            	var msg = "팀을 탈퇴하시겠습니까?"

            	var flag = confirm(msg);
				
            	if(flag){
            		$.ajax({
                        url:'/team/'+team_num+'/member/'+updataMemberNum,
                        type:'delete',
                        dataType:'json',
                        success:function(result){
                            console.log(result);
                            alert("탈퇴되었습니다") 
                        }
                    });//$.ajax
            	}	
            });
        });//끝
    </script>
    
    
    
  <!-- 게시판 스크립트 부분 -->
 <script>
$(document).ready(function(){	
	var member_num = ${param.member_num };
	var team_num =$("#teamNum").val();
	var boardUL = $("#board"); //게시판 리스트 들어가는 부분
	var user_num = $("#userNum").val();
	
	console.log("유저넘 : " + user_num)
	
	
	//========게시판 목록 호출=======
	showList(); 
	
	function showList(){
		
		listBoard.getListBoard({team_num:team_num}, function(board){ //board.js 메서드 호출
			
			console.log("게시판 목록 callback: " +team_num );
			var str ="";
			
			for(var i = 0; i < board.length; i++){
                str +="<a href='"+board[i].board_num+"' class='nav__link-left'>"; //board_num 전달
                str +="<ion-icon name='home-outline' class='nav__icon-left'></ion-icon>";
				str +="<span class='nav__name-left'>"+board[i].board_name+"</span>"; //게시판이름 출력
				str +="</a>"; 
				
				
			}
			boardUL.html(str); //html 추가
		});
	}


//==========Modal==========
	//모달창에 입력한 데이터 값 저장
    var boardModal = $("#boardModal");
    var modalInputBoardName = boardModal.find("input[name='board_name']");
    var modalInputBoardInfo = boardModal.find("input[name='board_info']");
    /* var modalInputReplyDate = boardModal.find("input[name='member_name']"); */
    
    var modalRegisterBtn = $("#modalRegisterBtn");
    var modalModBtn = $("#modalModBtn");
 
	//모달창 닫기 버튼
    $("#modalCloseBtn").on("click", function(e){
    	
    	boardModal.modal('hide');
    });

	//게시판 생성 버튼 + 클릭시 모달창을 보여준다.
	 $("#createBoard").on("click", function(e){
		
		console.log("게시판 생성 모달창")
		e.preventDefault(); // a태그 기본이벤트 삭제
		
		boardModal.find("input").val("");
	     /* modalInputReplyDate.closest("div").hide(); */
	      boardModal.find("button[id !='modalCloseBtn']").hide(); //Close버튼이 아니면 숨기기
	      
	     modalRegisterBtn.show();
	     /* modalInputReplyDate.show();*/
	      
		$("#createBoard").modal("show");
		
		}); // end createBoard 
	
	 
		//=========게시판 생성============
		modalRegisterBtn.on("click", function(e){
			
			var board = {
					board_name: modalInputBoardName.val(),
					board_info: modalInputBoardInfo.val(),
					member_num: member_num
			};
			console.log("게시판 생성!: "+team_num );
			
			listBoard.insertBoard(board,{team_num:team_num},  function(result){
				alert("게시판이 생성되었습니다.");
	
				boardModal.modal("hide");
				
				showList();
			});
		});
	
		//======게시판 이름 클릭시 게시글로 이동======
		var actionForm = $("#actionForm");
		
		$("#board").on("click", "a", function(e){
			
			console.log("게시글로 이동")
			e.preventDefault();
			
			actionForm.find("input[name='board_num']").val($(this).attr("href"));
			actionForm.submit();
		});
		
		
		//사용자 이미지 관련
		$.ajax({
				url:"/team/"+team_num+"/member/"+user_num,
		        type:'Get',
		        dataType:'json',
		        success:function(result){
		        	console.log("result결과입니다 : "+ result);
		        	showProfile(result);
		        }
			})
		
			//사용자 이미지 관련
			function showProfile(result){
				console.log("실행");
					if(result.profile_name!=null){
						console.log("실행2");
						$('.nav-profile-image-left').css('background-image', "url('/display?filename="+result.profile_name+"')"); 
						
					}
				console.log("실행3");
			}//end showProfile
		
		
		
}); //end document.ready1
</script>

<!-- Calendar Script -->
<script>
					console.log("캘린더 불러오기");      
     document.addEventListener("DOMContentLoaded", function() {
    			var calendarEl = document.getElementById("calendar");
    			
    			var calendar = new FullCalendar.Calendar(calendarEl, {
    				headerToolbar : {
    					left : "",
    					center : "title",
    					right : "dayGridMonth,timeGridWeek,timeGridDay",
    				},
    				locale : "ko",
    				timeZone : "local",
    				navLinks : true, 
    				selectable : true,
    				selectMirror : true,
    				select : function() {
    					// Display the modal.
    					// You could fill in the start and end fields based on the parameters
    					$('#CalModal').modal('show');
    					
    					
    						var title = prompt('Event Title:');
    						var start = prompt('Event startDate:');
    						var end = prompt('Event endDate:');
    						var allDay = prompt('Event allDay:');
    						if (title) {
    							calendar.addEvent({
    								title: title,
    								start: start,
    								end: end,
    								allDay: allDay
    							})
    						}
    							calendar.unselect()
    							console.log("화면 이벤트 출력 성공");
    						

    				},//select end
    				events:[ 
    					{
    						title : "채팅기능 개발일정",
    						start : "2021-12-03",
    						end 	: "2021-12-06"
    					},
    					{
    						title : "이벤트 추가",
    						start : "2021-12-03",
    						end 	: "2021-12-08"
    					},
    					{
    						title : "ToDo 리스트 개발",
    						start : "2021-12-17",
    						end 	: "2021-12-25"
    					},
    					{
    						title : "댓글 추가기능 개발",
    						start : "2021-12-04",
    						end 	: "2021-12-11"
    					},
    					{
    						title : "JSP 비동기화 작업",
    						start : "2021-12-03",
    						end 	: "2021-12-09				"
    					},
    					{
    						title : "MVC2 작업중",
    						start : "2021-12-03",
    						end 	: "2021-12-10"
    					}
    					
    				],
    				eventClick : function(arg) {
    					console.log("일정등록 이벤트 삭제");
    					console.log(arg.events);
    					if (confirm("일정을 삭제하시겠습니까?")) {
    						arg.event.remove();
    					}
    				},
    				editable : true,
    				dayMaxEvents : true,
    			});
    			calendar.render();
    		});
     

    		//일정 추가 밸류값
    		function newEvent() {
    			var calTitle = document.getElementById('title').value;
    			var calStarts = document.getElementById('starts').value;
    			var calEnds = document.getElementById('ends').value;
    			var calallday = document.getElementById('allday').value;
    			
    			//date format
    			calStarts = moment(starts).format('YYYY-MM-DD'); //date 날짜형식
    			calEnds = moment(ends).format('YYYY-MM-DD'); //date 날짜형식

    			//일정 추가 Ajax
    			$.ajax({
    				url : "/calendar/new",
    				type : "post",
    				dataType : "json",
    				contentType : "application/json",
    				data : JSON.stringify({
    					"title" : calTitle,
    					"starts" : calStarts,
    					"ends" : calEnds,
    					"allday" : calallday
    				}),
    				success : function(data) {
    					alert("등록 완료");
    					$('#CalModal').modal('hide');
    					console.log(calTitle);
    					console.log(calStarts);
    					console.log(calEnds);
    					console.log(calallday);
    				},
    				error : function() {
    					alert("등록되었습니다.");
    					//$('.modal').modal('hide');
    					console.log(calTitle);
    					console.log(calStarts);
    					console.log(calEnds);
    					console.log(calallday);
    				}
    			});
    		}; //newEvent end
</script>
<!-- Calendar Script End -->
<style>
#selectTodoDeleteListModal .modal-body{
height: 400px;
overflow-y : scroll;
}

.vote-modal-body{
height : 400px;
overflow-y : scroll;
}

</style>


</body>
</html>