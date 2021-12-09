package org.jobcho.controller;

import java.util.List;

import org.jobcho.domain.VoteResultVO;
import org.jobcho.domain.VoteVO;
import org.jobcho.service.VoteResultService;
import org.jobcho.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team/{team_num}/vote/*")
@Log4j
public class VoteController {

	@Autowired
	private VoteService service;
	
	@Autowired
	private VoteResultService voteResultService;
	
	//투표생성하기
	@PostMapping("/new")
	public ResponseEntity<VoteVO> insertVote(@RequestBody VoteVO vote, @PathVariable("team_num") int team_num){
		vote.setTeam_num(team_num);
		
		int insertCount = service.insertTeam(vote);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//투표하기 
	@PostMapping("/{vote_num}/insert")
	public ResponseEntity<VoteResultVO> insertVoteResult(@RequestBody VoteResultVO voteResult, @PathVariable("vote_num") int vote_num){
		voteResult.setVote_num(vote_num);
		
		int insertCount = voteResultService.insertVoteResult(voteResult);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//투표 내용 리스트 보기 
	@GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<VoteVO>> listVote(@PathVariable("team_num") int team_num){
		return new ResponseEntity<List<VoteVO>>(service.listVote(team_num), HttpStatus.OK);
	}
	
	//완료된 투표 리스트 보기 
	@GetMapping(value = "/endlist", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<VoteVO>> listEndVote(@PathVariable("team_num") int team_num){
		return new ResponseEntity<List<VoteVO>>(service.listEndVote(team_num), HttpStatus.OK);
	}
	
	//투표 한개 반환하기 
	@GetMapping(value = "/{vote_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<VoteVO> getVote(@PathVariable("vote_num") int vote_num){
		return new ResponseEntity<VoteVO>(service.getVote(vote_num), HttpStatus.OK);
	}
	
	//투표보기 
	@GetMapping(value = "/{vote_num}/result", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<VoteResultVO> getVoteResult(@PathVariable("vote_num") int vote_num){
				
		VoteResultVO voteResult = new VoteResultVO();
		VoteVO vote = new VoteVO();
		
		vote = service.getVote(vote_num);
		voteResult = voteResultService.getVoteResult(vote_num);
		
		voteResult.setVote_content1(vote.getVote_content1());
		voteResult.setVote_content2(vote.getVote_content2());
		voteResult.setVote_content3(vote.getVote_content3());
		voteResult.setVote_content4(vote.getVote_content4());
		voteResult.setVote_content5(vote.getVote_content5());
		
		return new ResponseEntity<VoteResultVO>(voteResult, HttpStatus.OK);
	}
	
	//투표결과 참가자 조회 
	@GetMapping(value = "/{vote_num}/result/member", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Integer>> getVoteResultMember(@PathVariable("vote_num") int vote_num){
		return new ResponseEntity<List<Integer>>(voteResultService.getVoteResultMember(vote_num), HttpStatus.OK);
	}

	//투표종료하기
	@DeleteMapping(value = "/{vote_num}/end", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<VoteVO> endVote(@PathVariable("vote_num") int vote_num){
		
		int insertCount = service.endVote(vote_num);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//1번 투표 결과 보기(멤버)
	@GetMapping(value = "/{vote_num}/result/1", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<VoteResultVO>> getContent1ResultMember(@PathVariable("vote_num") int vote_num){
		VoteResultVO voteResult = new VoteResultVO();
		
		
		voteResult.setVote_num(vote_num);
		
		return new ResponseEntity<List<VoteResultVO>>(voteResultService.getContent1ResultMember(voteResult), HttpStatus.OK);
	}
	
	//2번 투표 결과 보기(멤버)
		@GetMapping(value = "/{vote_num}/result/2", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<List<VoteResultVO>> getContent2ResultMember(@PathVariable("vote_num") int vote_num){
			VoteResultVO voteResult = new VoteResultVO();
			
			
			voteResult.setVote_num(vote_num);
			
			return new ResponseEntity<List<VoteResultVO>>(voteResultService.getContent2ResultMember(voteResult), HttpStatus.OK);
		}
		
		//3번 투표 결과 보기(멤버)
		@GetMapping(value = "/{vote_num}/result/3", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<List<VoteResultVO>> getContent3ResultMember(@PathVariable("vote_num") int vote_num){
			VoteResultVO voteResult = new VoteResultVO();
			System.out.println(vote_num);//14
			voteResult.setVote_num(vote_num);
			System.out.println("보트객체 : " +  voteResult);
			List<VoteResultVO> list = voteResultService.getContent3ResultMember(voteResult);
			System.out.println("리스트 확인중 : " + list);
			
			
			return new ResponseEntity<List<VoteResultVO>>(list, HttpStatus.OK);
		}
		
		//4번 투표 결과 보기(멤버)
		@GetMapping(value = "/{vote_num}/result/4", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<List<VoteResultVO>> getContent4ResultMember(@PathVariable("vote_num") int vote_num){
			VoteResultVO voteResult = new VoteResultVO();
			
			
			voteResult.setVote_num(vote_num);
			
			return new ResponseEntity<List<VoteResultVO>>(voteResultService.getContent4ResultMember(voteResult), HttpStatus.OK);
		}
		
		//5번 투표 결과 보기(멤버)
		@GetMapping(value = "/{vote_num}/result/5", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<List<VoteResultVO>> getContent5ResultMember(@PathVariable("vote_num") int vote_num){
			VoteResultVO voteResult = new VoteResultVO();
			
			
			voteResult.setVote_num(vote_num);
			
			return new ResponseEntity<List<VoteResultVO>>(voteResultService.getContent5ResultMember(voteResult), HttpStatus.OK);
		}
	
}
