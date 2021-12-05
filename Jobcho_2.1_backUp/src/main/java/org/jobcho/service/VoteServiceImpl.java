package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.VoteVO;
import org.jobcho.mapper.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteMapper mapper;
	
	@Override
	public int insertTeam(VoteVO vote) {
		
		return mapper.insertVote(vote);
	}

	@Override
	public List<VoteVO> listVote(int team_num) {
		
		return mapper.listVote(team_num);
	}

	@Override
	public int endVote(int vote_num) {
		
		return mapper.endVote(vote_num);
	}

}
