package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.VoteVO;

public interface VoteMapper {

	int insertVote(VoteVO vote);
	List<VoteVO> listVote(int team_num);
	int endVote(int team_num);
	VoteVO getVote(int vote_num);
}
