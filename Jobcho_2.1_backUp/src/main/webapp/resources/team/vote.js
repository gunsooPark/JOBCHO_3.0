/**
 * 
 */
$(document).ready(function(){
	var team_num = param.team_num;
	var vote_num = "";
	var member_num = "";
	
	function getVoteLIst(){
		$.ajax({
			url:'/team/'+team_num+'/vote/list',
			type:'Get',
			dataType:'json',
			success:function(result){
				console.log(result);
				showVoteList(result);
			}
		});//end ajax
	}//end getVoteList
	
	function showVoteList(result){
		str = "";
		result.forEach(function(item){
			console.log(item)
			str+=`<div class="job-container">
            <!--프로필-->
            
            <div class="team-profile-image" style="background-image: url('/resources/team/99D279435B3D788602.jfif');"></div>
            
            <div>
                <p class="vote-num">`+item.vote_num+`</p>
                <p class="vote-name">`+item.vote_name+`</p>
            </div>
            <!--프로필 끝-->
            <div class="vote-btn">
                <button id="voteModal" value="`+item.vote_num+`">투표확인</button>
            </div>
        </div>`
                
            vote_num += item.vote_num;
		})
		$(".job-votelist-wrap").html(str);
	}
	
	getVoteList();
	
	$(document).on("click", "#voteModal", function(){
		$("#voteResultModal").modal("show");
		
		getVoteResult();
		
		function getVoteResult(){
			$.ajax({
				url:'/team/'+team_num+'/vote/'+vote_num,
				type:'Get',
				dataType:'json',
				success:function(result){
					console.log(result);
					showVoteResult(result);
				}
			})
		}//end function
		
		function showVoteResult(result){
			str = "";
			result.forEach(function(item){
				str += '<div class = "modal" id = "voteResultModal" tabindex = "-1">'
				'<div class ="modal-dialog">'
				'<div class = "modal-header">투표 내용<button class="close" data-dismiss="modal">닫기</button>'
				'</div>'
				'<div class="modal-body">'
					'<div id ="voteRadio">'	
						'<input id = "vote_result1" type = "radio" class="form-control" value="1">'+item.vote_result1+'</input>'
						'<input id = "vote_result2" type = "radio" class="form-control" value="2">'+item.vote_result2+'</input>'
						'<input id = "vote_result3" type = "radio" class="form-control" value="3">'+item.vote_result3+'</input>'
						'<input id = "vote_result4" type = "radio" class="form-control" value="4">'+item.vote_result4+'</input>'
						'<input id = "vote_result5" type = "radio" class="form-control" value="5">'+item.vote_result5+'</input>'
						'<button type ="submit" id = "vote-complete-button" onclick="postVote()">완료</button>'
					'</div>'
				'</div>'
			'</div>'
		'</div>'
			})
		};//end showVoteResult
		
		function postVote(){
			$.ajax({
				url:'/team/'+team_num+'/vote/'+vote_num+'/insert',
				type:'Post',
				contentType:'application/json',
				data:JSON.stringify({
					"vote_num":vote_num,
					"vote_result1":$("#vote_result1").val(),
					"vote_result2":$("#vote_result2").val(),
					"vote_result3":$("#vote_result3").val(),
					"vote_result4":$("#vote_result4").val(),
					"vote_result5":$("#vote_result5").val(),
					"member_num":param.member_num
				}),
				dataType:'json',
				success:function(result){
					console.log(result);
				}
			})
		}
		
		
		
	})
})