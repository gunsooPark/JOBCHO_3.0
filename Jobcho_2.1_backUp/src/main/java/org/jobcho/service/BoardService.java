package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.BoardVO;


public interface BoardService {
	
	public int insertBoard(BoardVO board);
	
	public List<BoardVO> getListBoard(int team_num);
	
	public int updateBoard(BoardVO board);
	
	public void deleteBoard(int board_num);

}
