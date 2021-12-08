package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.VoteVO;

public interface VoteService {

	public int insertTeam(VoteVO vote);
	public List<VoteVO> listVote(int team_num);
	public int endVote(int vote_num);
	public VoteVO getVote(int vote_num);
}
