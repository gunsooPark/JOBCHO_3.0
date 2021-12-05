package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.ReplyVO;

public interface ReplyMapper {

	int insertReply(ReplyVO reply);
	List<ReplyVO> getListReply(int post_num);
	public ReplyVO getReply(int reply_num);
	int updateReply(ReplyVO reply);
	void deleteReply(int reply_num);
}
