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

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply")
@Log4j
@AllArgsConstructor
public class ReplyController {
	

	@Autowired
	private ReplyService service;
	
	
	// 댓글 등록 
	@PostMapping(value = "/new",
					consumes = "application/json")
	public ResponseEntity<ReplyVO> insertReply(@RequestBody ReplyVO reply
																				){
		
		log.info("댓글 등록: " + reply);
		int insertCount = service.insertReply(reply);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//댓글 리스트 불러오기
	@GetMapping(value = "/post/{post_num}",
							produces = { MediaType.TEXT_XML_VALUE,
												 MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getListReply(@PathVariable("post_num") int post_num){
		
		log.info("댓글 목록: " + post_num);
		
		return new ResponseEntity<>(service.getListReply(post_num), HttpStatus.OK);
	}
	
	
	//특정 댓글 조회
		@GetMapping("/{reply_num}")
		public ResponseEntity<ReplyVO> get(@PathVariable("reply_num") int reply_num) {
			
			log.info("특정 댓글 조회: " +reply_num);
			
			return new ResponseEntity<>(service.getReply(reply_num), HttpStatus.OK);
		}
	
	
	//댓글 수정
	@PutMapping(value = "/{reply_num}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ReplyVO> updateReply(@PathVariable("reply_num") int reply_num,
																				@RequestBody ReplyVO reply){
		log.info("댓글 수정: " + reply_num);
		System.out.println("댓글 수정 내용: " +reply.getReply_contents());
		
		reply.setReply_num(reply_num);
		int updateCount = service.updateReply(reply);
		
		return  updateCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//댓글 삭제
	@DeleteMapping(value = "/{reply_num}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteReply(@PathVariable int reply_num){
		
		log.info("댓글 삭제: " + reply_num);
		System.out.println("댓글 삭제 번호: " +reply_num);
		service.deleteReply(reply_num);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
