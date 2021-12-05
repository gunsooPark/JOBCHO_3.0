package org.jobcho.controller;

import java.util.List;

import org.jobcho.domain.BoardVO;
import org.jobcho.domain.ReplyVO;
import org.jobcho.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team/{team_num}/board/{board_num}/post/{post_num}/reply")
@Log4j
public class ReplyController {
	
	
	
	@Autowired
	private ReplyService service;
	
	
	// /team/{team_num}/board/{board_num}/post/{post_num}/reply/new
	//�룷�뒪�듃留� o
	@RequestMapping(value="/new", method = {RequestMethod.GET, RequestMethod.POST})
	
	public ResponseEntity<ReplyVO> insertReply(@RequestBody ReplyVO rvo,
																				@PathVariable("post_num") int post_num){
		
		rvo.setPost_num(post_num);
		log.info("insertReply ==================" + rvo);
		int r_insertCount = service.insertReply(rvo);
		
		return r_insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//포스트맨 o 
	@GetMapping(value = "",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getListReply(@PathVariable("post_num") int post_num){
		log.info("getListReply ================== " + post_num);
		return new ResponseEntity<>(service.getListReply(post_num), HttpStatus.OK);
	}
	
	
	
	
	//포스트맨 o
	@PutMapping(value = "/{reply_num}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ReplyVO> updateReply(@PathVariable("reply_num") int reply_num,
																				@RequestBody ReplyVO reply){
		log.info("putMapping ==================" + reply_num);
		
		reply.setReply_num(reply_num);
		int updateCount = service.updateReply(reply);
		
		return  updateCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//포스트맨 o
	@DeleteMapping(value = "/{reply_num}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteReply(@PathVariable int reply_num){
		
		log.info("DeleteMapping ==================" + reply_num);
		service.deleteReply(reply_num);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
