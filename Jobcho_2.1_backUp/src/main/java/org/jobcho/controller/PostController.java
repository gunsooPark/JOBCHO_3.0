package org.jobcho.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.apache.ibatis.annotations.Param;
import org.jobcho.domain.Criteria;
import org.jobcho.domain.PageInfo;
import org.jobcho.domain.PostVO;
import org.jobcho.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team/{team_num}/board/{board_num}/post")
@Log4j
@AllArgsConstructor
public class PostController {
	
	@Autowired
	private PostService service;
	
	
	/*
	 * 게시글 생성(PostMan 확인O)
	 *board_num, member_num 필요
	*/
	@PostMapping("/new")
	public ResponseEntity<PostVO> insertPost(@RequestBody PostVO post,
																		  @PathVariable("board_num") int board_num){
		
		post.setBoard_num(board_num);
		
		log.info("게시글 생성: " + post);
		log.info("게시판 번호: " + board_num);

		int insertCount = service.insertPost(post);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/*
	 * 게시글 리스트+ 페이지 처리(PostMan 확인O)
	 * type, keyword (검색 시 필요)	 
	 * */
	@GetMapping(value = "",
							produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<HashMap<Object , Object>> getListPost(@PathVariable("board_num") int board_num,
																											@RequestParam(value = "type",required = false) String type,
																											@RequestParam(value = "keyword", required = false) String keyword){
		
		Criteria cri = new Criteria(1, 10);
		
		if(type != null && keyword != null) {
			cri.setType(type);
			cri.setKeyword(keyword);
		}
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board_num", board_num);
		map.put("cri", cri);
		List<PostVO> getListPost = service.getListPost(map);
		
		log.info("게시글 리스트 : " + board_num);
		log.info("게시판, 페이지 수: " + map);
		
		int total = service.getTotalCount(cri);  //전체 게시글 수+페이지정보
		PageInfo page = new PageInfo(cri, total);
		
		
		HashMap<Object, Object> getListPostWithPage = new HashMap<Object, Object>();
		getListPostWithPage.put("getListPost", getListPost);
		getListPostWithPage.put("pageMaker", page);
		
		return new ResponseEntity<>(getListPostWithPage, HttpStatus.OK);
	}
	
	
	/*
	 * 게시글 상세조회(PostMan 확인O)
	 * post_num 필요
	 */
	@GetMapping(value = "{post_num}",
							produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<PostVO> getPost(@PathVariable("post_num") int post_num){
		
		log.info("게시글 상세조회 : " + post_num);
		
		PostVO getPost = service.getList(post_num);
		return new ResponseEntity<>(getPost, HttpStatus.OK);
	}
	
	
	/*
	 *게시글 수정(PostMan 확인O)
	 * post_num 필요
	 */
	@PutMapping("/{post_num}")
	public ResponseEntity<PostVO> updatePost(@RequestBody PostVO post,
																			 @PathVariable("post_num") int post_num,
																			 @PathVariable("board_num") int board_num){
		post.setPost_num(post_num);
		post.setBoard_num(board_num);
		int updateCount = service.updateBoard(post);
		
		return updateCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	/*
	 * 게시글 삭제(PostMan 확인O)
	 * post_num 필요
	 */
	@DeleteMapping("/{post_num}")
	public ResponseEntity<String> deletePost(@PathVariable("post_num") int post_num){
		
		log.info("게시글 삭제: " + post_num);
		service.deletePost(post_num);
		return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	

}
