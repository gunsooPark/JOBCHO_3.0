<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/main.jsp"%>



<div class="row" style="margin-top: 80px">
	<div class="col-sm-7" style="margin-left: 450px">
		<h1 class="page-header">게시판 이름</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row" >
	<div class="col-sm-7" style="margin-left: 450px">
		<div class="panel panel-default">
			<div class="panel-heading">
				게시판 정보
				
				<button id='regBtn' type="button" class="btn btn-primary btn-xs pull-right">글쓰기</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>

					<c:forEach items="${postList}" var="postList">
						<tr>
							<td><c:out value="${postList.post_num}"/></td>

							<td>
								<a class='move' href='<c:out value="${postList.post_num}"/>'> <!--move 클래스 추가 -->
								<c:out value="${postList.post_title}"/><!-- 제목 클릭 시 move이벤트 발생 -->
								<b>[<c:out value="${postList.replycnt }"/>]</b>
								</a>
							</td>

							<td><c:out value="${postList.board_num}"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${postList.post_date}"/></td>
						</tr>
					</c:forEach>
				</table>
				
				
				<!--------------- 검색 처리 ----------------->
				<div class='row'>
					<div class="col-sm-7">

						<form id='searchForm' action="/post/list" method='get'>
							<select name='type'>
								<option value=""
									<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목
									+ 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목
									+ 작성자</option>
								<option value="TWC"
									<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목
									+ 내용 + 작성자</option>
							</select> 
							<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' /> 
							<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
							<input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
							<input type='hidden' name='board_num' value='<c:out value="${board_num}"/>' />
							<button class='btn btn-default'>검색</button>
						</form>
					</div>
				</div> 

				<!---------------- 페이지 처리 ----------------->
				<div class='pull-right'>
					<ul class="pagination">
					
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage -1}">이전</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<!--선택한 번호 이벤트처리(삼항연산자) -->
							<li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
								<a href="${num}">${num}</a><!--이벤트 처리-->
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage +1 }">이후</a></li>
						</c:if>
						

					</ul>
				</div>
				<!--  end Pagination -->
			</div>


			<!----------------Modal창 추가---------------->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body"></div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								
								data-dismiss="modal">닫기</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!--/.modal-dialog-->
			</div>
			<!--/.modal-->
			
								<!---------------form을 이용한 데이터 유지-------------->
								<form id='listForm' action="/post/list" method='get'>
										<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
										<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
										<input type='hidden' name='board_num' value='${board_num}'>
										<input type='hidden' name='team_num' value='${team_num}'>
										<input type='hidden' name='member_num' value='${member_num }'>
										
								</form>
			
		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

			

<script type="text/javascript">

$(document).ready(function(){
	
	//변경사항 피드백
	var result = '<c:out value="${result}"/>'; 	
	
	//checkModal 호출
	checkModal(result); 
	
	//등록 후 뒤로가기 누르면 모달창 뜨는 오류해결
	history.replaceState({}, null, null);

	function checkModal(result){
	
		if(result == '' || history.state){
			return;
		}
		
		if(result === ''){
			return;
		}
		
	 	if(parseInt(result) > 0){
		 	$(".modal-body").html("게시글이 등록되었습니다.");
		 	$("#myModal").modal("show"); 
		 	console.log("게시글 등록모달");
		} 	
	}//end checkModal
	
	
	
	//페이지 번호 이벤트 처리
	var listForm = $("#listForm");
	
	//게시글 등록버튼 클릭 시 등록폼으로 이동
	$("#regBtn").on("click", function(){
		
		console.log("게시글 등록버튼클릭: " +${board_num});
		
		
		listForm.attr("action", "/post/register");
		listForm.submit();
	});
	
	
	//게시글 상세조회
	$(".move").on("click", function(e){
		
		e.preventDefault();
		
		//post_num을 form태그에 담아서 전달
		listForm.append("<input type='hidden' name='post_num' value='"+$(this).attr("href")+"'>");
		listForm.attr("action", "/post/get");
		listForm.submit();
		
		console.log("리스트에서 상세조회로 전달: " +${board_num});
	});


	//페이지 번호 이벤트 적용
	$(".paginate_button a").on("click", function(e){
		
		e.preventDefault();
		
		console.log("페이지 이벤트: " +${board_num});
		
		listForm.find("input[name='pageNum']").val($(this).attr("href")); //href의 num값을 form에 넣는다.
		
		listForm.submit();
	}); //end pageinate 
	

	//=======검색 버튼 이벤트 처리
	/* var searchForm = $("#searchForm");
	
	$("#searchForm button").on("click", function(e){
		
		alert("키워드를 입력하세요");
		
		//검색종류 선택안하고 검색버튼 클릭 시
		if(!searchForm.find("option:selected").val()){  
			alert("검색 종류를 선택하세요");
			return false;
		}
		
		//키워드 입력안하고 검색버튼 클릭 시
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요");
			return false;
		}
		
		//검색결과는 항상 1페이지부터
		searchForm.find("input[name='pageNum']").val("1")); 
		e.preventDefault();
		
		searchForm.submit();	
	}); */
	
	
	
}); //end d.ready
	
	

</script>

