<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/main.jsp"%>


<div class="row" style="margin-top: 100px">
  <div class="col-sm-7" style="margin-left: 450px">
    <h2 class="page-header">게시판 이름</h2>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}
</style>

<style>
.bigPictureWrapper {
  position: absolute;
  display: none;
  justify-content: center;
  align-items: center;
  top:0%;
  width:100%;
  height:100%;
  background-color: gray; 
  z-index: 100;
}

.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}
</style>

<div class="row" style="margin-top: 40px">
  <div class="col-sm-7" style="margin-left: 450px">
    <div class="panel panel-default">

      <div class="panel-heading">게시글 등록</div>
      <!-- /.panel-heading -->
      <div class="panel-body">


        <form role="form" action="/post/register" method="post">
        			
        	<input type='hidden' name='board_num' value='<c:out value="${board_num}"/>'>
			
						
        		
          <div class="form-group">
            <label>제목</label> <input class="form-control" name='post_title'>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="7" name='post_contents'></textarea>
          </div>

          <div class="form-group">
            <label>작성자</label> <input class="form-control" name='writer'>
          </div>
          <button type="submit" class="btn btn-primary">등록</button>
          <button id='reset' type="reset" class="btn btn-default">취소</button>
        </form>
        ${board_num}

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<!-- 파일 첨부 -->
<!-- <div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">File Attach</div>
      /.panel-heading
      <div class="panel-body">
        <div class="form-group uploadDiv">
            <input type="file" name='uploadFile' multiple>
        </div>
        
        <div class='uploadResult'> 
          <ul>
          
          </ul>
        </div>
        
        
      </div>
       end panel-body

    </div>
     end panel-body
  </div>
  end panel
</div>
/.row -->

						
								

<script>

$(document).ready(function(){

	
	var formObj = $("form");
	
	//취소 버튼 클릭 시 board_num만 가지고 리스트로
	$("#reset").on("click", function(e){
		
		formObj.empty(); 
		formObj.attr("action", "/post/list").attr("method", "get");
		formObj.append("<input type='hidden' name='board_num' value='"+${board_num}+"'>");
		formObj.submit();
	});

 


  
});

</script>


