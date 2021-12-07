package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.ReplyVO;
import org.jobcho.mapper.PostMapper;
import org.jobcho.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper mapper;
	@Autowired
	private PostMapper postMapper;

	
	/*
	 * 댓글 등록 + 댓글 수 업데이트
	 * 트랜잭션 처리
	 */
	@Transactional
	@Override
	public int insertReply(ReplyVO reply) {
		log.info("댓글 등록 트랜잭션:" + reply);
		
		postMapper.updateReplyCnt(reply.getPost_num(), 1);
		return mapper.insertReply(reply);
	}

	
	@Override
	public List<ReplyVO> getListReply(int post_num) {
		log.info("댓글 리스트 불러오기: " + post_num);
		return mapper.getListReply(post_num);
	}

	
	@Override
	public int updateReply(ReplyVO reply) {
		log.info("댓글 수정: " + reply);
		return mapper.updateReply(reply);
	}

	
	
	/*
	 * 댓글 삭제 + 댓글 수 업데이트
	 * 트랜잭션 처리
	 */
	@Transactional
	@Override
	public void deleteReply(int reply_num) {
		log.info("댓글 삭제 =====" + reply_num);
		
		ReplyVO reply = mapper.getReply(reply_num);
		
		postMapper.updateReplyCnt(reply.getPost_num(), -1);
		mapper.deleteReply(reply_num);     
	}

	
	/*
	 * 특정 댓글 가져오기
	 */
	@Override
	public ReplyVO getReply(int reply_num) {
		
		return mapper.getReply(reply_num); 
	}

	
}
