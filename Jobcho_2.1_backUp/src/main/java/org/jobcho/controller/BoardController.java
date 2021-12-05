package org.jobcho.controller;

import java.util.List;
import java.util.Set;

import org.jobcho.domain.BoardVO;
import org.jobcho.domain.MemberVO;
import org.jobcho.domain.TeamVO;
import org.jobcho.service.BoardService;
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
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team/{team_num}/board")
@Log4j
@AllArgsConstructor
public class BoardController {

	@Autowired
	private BoardService service;

	/*
	 * 게시판 생성(PostMan 확인O) 메인화면에서 생성버튼 클릭 시 team_num, member_num 필요
	 */
	@PostMapping(value = "/new")
	public ResponseEntity<BoardVO> insertBoard(@RequestBody BoardVO board, @PathVariable("team_num") int team_num) {

//		board.setMember_num(member_num);
		board.setTeam_num(team_num);

		log.info("게시판 생성: " + board);
		log.info("팀번호: " + team_num);

		int insertCount = service.insertBoard(board);

		return insertCount == 1 ? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * 게시판 리스트 조회(PostMan 확인O) 메인 화면에서 항상 호출 team_num 필요
	 */
	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<BoardVO>> getListBoard(@PathVariable int team_num) {

		log.info("팀번호" + team_num);
		return new ResponseEntity<>(service.getListBoard(team_num), HttpStatus.OK);
	}

	/*
	 * 게시판 수정(PostMan 확인O) team_num, member_num 필요
	 */
	@PutMapping(value = "/{board_num}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BoardVO> updateBoard(@RequestBody BoardVO board, @PathVariable("board_num") int board_num) {

		log.info("수정할 게시판 번호: " + board_num);

		board.setBoard_num(board_num);
		int updateCount = service.updateBoard(board);

		return updateCount == 1 ? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * 게시판 삭제(PostMan 확인O, isLive 변경) team_num, member_num 필요
	 */
	@DeleteMapping(value = "/{board_num}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> deleteBoard(@PathVariable int board_num) {

		log.info("삭제할 게시판 번호: " + board_num);
		service.deleteBoard(board_num);

		return new ResponseEntity<>("success", HttpStatus.OK);
	}

}
