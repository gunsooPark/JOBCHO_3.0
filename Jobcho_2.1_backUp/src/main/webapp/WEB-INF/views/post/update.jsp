<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/main.jsp"%>


<div class="row" style="margin-top: 80px">
	<div class="col-sm-7" style="margin-left: 450px">
		<h2 class="page-header">게시글 수정</h2>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-sm-7" style="margin-left: 450px">
		<div class="panel panel-default">

			<div class="panel-heading">게시글 수정</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				
				<!-- form을 이용해서 데이터 유지 + 수정 정보 전달 -->
				<form role="form" action="/post/update" method="post">

						<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'> 
						<input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
						<input type='hidden' name='board_num' value='<c:out value="${post.board_num}"/>'> 
						<input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
						<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>

					<div class="form-group">
						<label>글 번호</label> <input class="form-control" name='post_num'
							value='<c:out value="${post.post_num }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>제목</label> <input class="form-control" name='post_title'
							value='<c:out value="${post.post_title }"/>'>
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" name='post_contents'><c:out
								value="${post.post_contents}" /></textarea>
					</div>

					<div class="form-group">
						<label>작성자</label> <input class="form-control" name='writer'
							value='<c:out value="${post.board_num}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>작성일</label> <input class="form-control" name='post_date'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${post.post_date}" />'
							readonly="readonly">
					</div>
					

					<!-- 전송버튼 -->
					<button type="submit" data-oper='modify' class="btn btn-info">수정</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">삭제</button>
					<button type="submit" data-oper='list' class="btn btn-default">목록</button>
				</form>
				
			</div>
			<!--  end panel-body -->
		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->



<script type="text/javascript">
$(document).ready(function() {

	var formObj = $("form");
	
	$('button').on("click", function(e){
		
		e.preventDefault();
		
		var operation = $(this).data("oper"); //클릭한 버튼
		
		console.log("수정페이지에서 선택: " +operation);
		
		 //삭제버튼 클릭 시
		if(operation === 'remove'){
			alert("게시글이 삭제되었습니다.");
			formObj.attr("action", "/post/delete");
		}
		
		 //목록으로 돌아가기
		else if(operation === 'list'){
			formObj.attr("action", "/post/list").attr("method", "get");
		
			var pageNum = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			
			//기존 form내용 삭제시킨 후 list 이동, board_num 전달
			formObj.empty(); 
			formObj.append(pageNum);
			formObj.append(amountTag);
			formObj.append("<input type='hidden' name='board_num' value='"+${post.board_num}+"'>");
			/* formObj.append("<input type='hidden' name='type' value='"+${cri.type}+"'>");
			formObj.append("<input type='hidden' name='keyword' value='"+${cri.keyword}+"'>"); */
		}
	
		else if(operation === 'modify'){
			alert("게시글이 수정되었습니다.");
		}
		formObj.submit();
		
	});
});

</script>












