package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.VoteResultVO;

public interface VoteResultMapper {

	public int insertVoteResult(VoteResultVO voteResult);
	public VoteResultVO getVoteResult(int vote_num);
	public List<Integer> getVoteResultMember(int vote_num);
	public List<VoteResultVO> getContent1ResultMember(VoteResultVO voteResult);
	public List<VoteResultVO> getContent2ResultMember(VoteResultVO voteResult);
	public List<VoteResultVO> getContent3ResultMember(VoteResultVO voteResult);
	public List<VoteResultVO> getContent4ResultMember(VoteResultVO voteResult);
	public List<VoteResultVO> getContent5ResultMember(VoteResultVO voteResult);
}
