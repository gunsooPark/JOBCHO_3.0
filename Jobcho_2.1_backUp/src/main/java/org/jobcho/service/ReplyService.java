package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.ReplyVO;

public interface ReplyService {
	
	public int insertReply(ReplyVO reply);
	
	public List<ReplyVO> getListReply(int post_num);
	
	
	public int updateReply(ReplyVO reply);
	
	public void deleteReply(int reply_num);
}
