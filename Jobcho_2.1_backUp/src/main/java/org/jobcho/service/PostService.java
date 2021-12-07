package org.jobcho.service;

import java.util.HashMap;
import java.util.List;

import org.jobcho.domain.Criteria;
import org.jobcho.domain.PostVO;


public interface PostService {
	
	public int insertPost(PostVO post); //게시글 생성
	public List<PostVO> getListPost(HashMap<String, Object> map); //게시글 리스트
	public PostVO getPost(int post_num); //게시글 상세조회
	public int updateBoard(PostVO post); //게시글 수정
	public void deletePost(int post_num); //게시글 삭제
	
	public int getTotalCount(int board_num);// 전체 글 수
	
}
