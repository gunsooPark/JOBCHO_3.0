package org.jobcho.mapper;

import java.util.HashMap;
import java.util.List;

import org.jobcho.domain.BoardVO;
import org.jobcho.domain.PostVO;


public interface BoardMapper {

	int insertBoard(BoardVO board); 		//게시판 생성
	List<BoardVO> getListBoard(int team_num); 			//게시판 리스트목록
	BoardVO getBoard(int board_num);                           //게시글 상세
	int updateBoard(BoardVO board);		//게시판 수정
	void deleteBoard(int board_num);		//게시판 삭제
	
	
	
}
