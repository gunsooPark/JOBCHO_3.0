package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.BoardVO;
import org.jobcho.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	
	//게시판 등록
	@Override
	public int insertBoard(BoardVO board) {
		
		log.info("서비스 게시판 등록");
		
		return mapper.insertBoard(board);
	}

	
	//게시판 목록
	@Override
	public List<BoardVO> getListBoard(int team_num) {
		log.info("서비스 목록 테스트!!");
		return mapper.getListBoard(team_num);
	}

	
	//게시판 수정
	@Override
	public int updateBoard(BoardVO board) {
		log.info("서비스 수정 테스트!!" + board);
		
		return mapper.updateBoard(board);
	}

	
	//게시판 삭제
	@Override
	public void deleteBoard(int board_num) {
		
		log.info("서비스 삭제 테스트!!"+ board_num );
		mapper.deleteBoard(board_num);
	}

}
