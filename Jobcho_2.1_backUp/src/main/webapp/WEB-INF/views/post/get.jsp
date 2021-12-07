<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="/WEB-INF/views/main.jsp"%>



<div class="row" style="margin-top: 80px">
  <div class="col-sm-7" style="margin-left: 450px">
    <h2 class="page-header"> ${board.board_name }</h2>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-sm-7" style="margin-left: 450px">
    <div class="panel panel-default">

      <div class="panel-heading"> ${board.board_info }</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>글 번호</label> <input class="form-control" name='bno'
            value='<c:out value="${post.post_num }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>제목</label> <input class="form-control" name='title'
            value='<c:out value="${post.post_title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>내용</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${post.post_contents}" /></textarea>
        </div>

        <div class="form-group">
          <label>작성자</label> <input class="form-control" name='writer'
            value= "${post.writer} " readonly="readonly">
        </div>
		
<button data-oper='modify' class="btn btn-info">수정</button>
<button data-oper='list' class="btn btn-default">목록</button>
<br><br>
<br><br>

<style>
.chat {
  margin: 0;
  padding: 0;
  list-style: none;
}
.chat li {
  margin-bottom: 10px;
  padding-bottom: 5px;
  border-bottom: 1px dotted #999999;
}
.chat li.left .chat-body {
  margin-left: 60px;
}
.chat li.right .chat-body {
  margin-right: 60px;
}
.chat li .chat-body p {
  margin: 0;
}
.panel .slidedown .glyphicon,
.chat .glyphicon {
  margin-right: 5px;
}
.chat-panel .panel-body {
  height: 350px;
  overflow-y: scroll;
}
</style>


<!-- ==========댓글========= -->
<div class='row'>
  <div class="col-lg-12">
    <div class="panel panel-default">
    
      <!-- 댓글 등록 -->
      <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> 댓글
        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>댓글 쓰기</button>
      </div>      
      
      <div class="panel-body">
      	<!--댓글 보여지는 부분 -->
        <ul class="chat">
			
        </ul>
        
      </div>
	<div class="panel-footer"></div>
	</div>
  </div>
</div>


<!-- 댓글 Modal -->
      <div class="modal fade" id="replyModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">댓글 작성</h4>
            </div>
            <div class="modal-body">
              <div class="form-group">
                <label>댓글 내용</label> 
                <input class="form-control" name='reply_contents' value='reply'>
              </div>      
              <div class="form-group">
                <label>작성자</label> 
                <input class="form-control" name='replyer' value='replyer'>
              </div>
              <div class="form-group">
                <label>Reply Date</label> 
                <input class="form-control" name='replyDate' value='2018-01-01 13:13'>
              </div>
            </div>
            
			<div class="modal-footer">
        		<button id='replyModBtn' type="button" class="btn btn-info">수정</button>
        		<button id='replyRemoveBtn' type="button" class="btn btn-danger">삭제</button>
        		<button id='replyRegisterBtn' type="button" class="btn btn-primary">등록</button>
        		<button id='replyCloseBtn' type="button" class="btn btn-default">닫기</button>
      		</div>
		</div>
	</div>
</div>

			<!----------- form으로 데이터 유지 ----------->
			<form id='operForm' action="/post/update" method="get">
  				<input type='hidden' id='post_num' name='post_num' value='<c:out value="${post.post_num}"/>'> <!--기존 bno 삭제 -->
 				<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  				<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  				<input type='hidden' name='board_num' value='<c:out value="${post.board_num}"/>'>
  				<input type='hidden' name='team_num' value='<c:out value="${team_num}"/>'>
  				<input type='hidden' name='member_num' value='<c:out value="${member_num}"/>'>
  				<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  				<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'> 
			</form>



      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<script type="text/javascript" src="/resources/board/reply.js?version=20211205"></script>

<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  	//수정버튼 클릭 시
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/post/update").submit();
    
  });
  
    //목록버튼 클릭 시
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#post_num").remove(); //목록으로 이동할땐 게시글 번호를 지운다.
    operForm.attr("action","/post/list")
    operForm.submit();
  });  
    
});//end d.ready
</script>



<script type="text/javascript">
$(document).ready(function() {
	
//==========댓글 Modal==========
var postUL = '<c:out value="${post.post_num }"/>';
var replyUL =$(".chat");

var replyModal = $("#replyModal");
var modalInputReply = replyModal.find("input[name='reply_contents']");
var modalInputReplyer = replyModal.find("input[name='replyer']");
var modalInputReplyDate = replyModal.find("input[name='replyDate']");

var replyModBtn = $("#replyModBtn"); //수정버튼
var replyRemoveBtn = $("#replyRemoveBtn");//삭제버튼
var replyRegisterBtn = $("#replyRegisterBtn");//등록버튼


//==========댓글 리스트 호출==========
	getListReply();

	function getListReply(){
	
		console.log("댓글리스트 호출: " +postUL);

		replyService.getListReply({pno:postUL}, function(list){ //reply.js 호출
			
			var str ="";
	
			//댓글이 없을 경우
			if(list == null || list.length == 0){
				replyUL.html("");
				return;
			}
	
			for (var i = 0, len = list.length || 0; i < len; i++) {
		           str +="<li class='left clearfix' data-reply_num='"+list[i].reply_num+"'>";
		           str +="  <div><div class='header'><strong class='primary-font'>"+list[i].reply_contents+"</strong>"; 
		           str +="    <small class='pull-right text-muted'>"+replyService.replyTime(list[i].reply_date)+"</small></div>";
		           str +="    <p>"+list[i].reply_contents+"</p></div></li>";
		         }
			
			replyUL.html(str);
		
		});
		
	}//end getListReply

 


//댓글 모달 닫기 버튼
$("#replyCloseBtn").on("click", function(e){

	replyModal.modal('hide');	
});


//댓글 등록 버튼 클릭 시 모달 show
$("#addReplyBtn").on("click", function(e){
	
	console.log("댓글 생성 모달창");
	replyModal.find("input").val("");
	modalInputReplyDate.closest("div").hide();
	replyModal.find("button[id !='replyCloseBtn']").hide();
	
	replyRegisterBtn.show();
	
	replyModal.modal("show");
	getListReply();
});


//댓글 입력한 데이터 등록
replyRegisterBtn.on("click", function(e){
	
	console.log("댓글 등록");
	var reply = {
			reply_contents: modalInputReply.val(),
			member_num: ${member_num},
			post_num: ${post.post_num}
	};
	
	replyService.insertReply(reply, function(result){ //reply.js 호출
		
		alert("댓글이 등록되었습니다.");
		replyModal.find("input").val(""); //입력항목 비우고 
		replyModal.modal("hide");	//모달창 닫기
		getListReply(); //댓글등록 후 목록 갱신 
		});
	}); 
	

	//동적으로 생성된 댓글 이벤트 위임, 특정댓글 보기
	$(".chat").on("click", "li", function(){
		
		var reply_num = $(this).data("reply_num");
		
		replyService.getReply(reply_num, function(reply){ //reply.js 호출
			
			modalInputReply.val(reply.reply_contents);
			modalInputReplyer.val(reply.member_num);
			modalInputReplyDate.val(replyService.replyTime(reply.reply_date)).attr("readonly", "readonly");
			replyModal.data("reply_num", reply.reply_num);
			
			replyModal.find("button[id != 'replyCloseBtn']").hide();
			
			replyModBtn.show(); //수정버튼 활성화 
			replyRemoveBtn.show();//삭제버튼 활성화
			
			replyModal.modal("show");
		});
	});
	
	
	//특정 댓글 수정
	replyModBtn.on("click", function(){
		
		var reply = {reply_num: replyModal.data("reply_num"), reply_contents: modalInputReply.val() };
		console.log("댓글 수정내용: "+modalInputReply.val());
		
		replyService.updateReply(reply, function(result){//reply.js 호출
		 	
			alert("댓글이 수정되었습니다.");
			replyModal.modal("hide");
			getListReply(); //댓글 수정 후 댓글목록 갱신
			console.log("댓글 수정~");
		});
	});

	
	//댓글 삭제 
   	replyRemoveBtn.on("click", function (e){
   		
   		if(!confirm("정말로 삭제하시겠습니까?")){
   			alert("취소되었습니다.")
   			replyModal.modal("hide");
   		}
   		
   	  var reply_num = replyModal.data("reply_num");
   	  
   	  replyService.deleteReply(reply_num, function(result){//reply.js 호출
   		  
   	    alert("댓글이 삭제되었습니다.");
   	   	replyModal.modal("hide");
   	   	
   	 	getListReply(); //댓글 삭제 후 댓글목록 갱신
   	 	
   	 	console.log("댓글 삭제~");
   	  });
   	getListReply(); 
 });
   	



});//end d.ready

</script>

