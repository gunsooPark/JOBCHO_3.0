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
	
	//투표 생성
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
	
	//투표 목록보기
	@GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<VoteVO>> listVote(@PathVariable("team_num") int team_num){
		return new ResponseEntity<List<VoteVO>>(service.listVote(team_num), HttpStatus.OK);
	}
	
	//특정 투표 결과 보기
	@GetMapping(value = "/{vote_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<VoteResultVO> getVote(@PathVariable("vote_num") int vote_num){
				
		return new ResponseEntity<VoteResultVO>(voteResultService.getVoteResult(vote_num), HttpStatus.OK);
	}
	
	//특정 투표한 멤버 확인
	@GetMapping(value = "/{vote_num}/member", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<VoteResultVO>> getVoteResultMember(@PathVariable("vote_num") int vote_num){
		return new ResponseEntity<List<VoteResultVO>>(voteResultService.getVoteResultMember(vote_num), HttpStatus.OK);
	}

	//투표 마감
	@DeleteMapping(value = "/{vote_num}/end", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<VoteVO> endVote(@PathVariable("vote_num") int vote_num){
		
		int insertCount = service.endVote(vote_num);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
