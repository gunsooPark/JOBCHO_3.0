package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.VoteResultVO;

public interface VoteResultMapper {

	public int insertVoteResult(VoteResultVO voteResult);
	public VoteResultVO getVoteResult(int vote_num);
	public List<VoteResultVO> getVoteResultMember(int vote_num);
	
}
