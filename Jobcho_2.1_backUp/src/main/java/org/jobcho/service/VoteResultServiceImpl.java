package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.VoteResultVO;
import org.jobcho.mapper.VoteResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteResultServiceImpl implements VoteResultService {

	@Autowired
	private VoteResultMapper mapper;
	
	//투표 하기
	@Override
	public int insertVoteResult(VoteResultVO voteResult) {
	
		return mapper.insertVoteResult(voteResult);
	}

	//투표 결과 보기(투표한 숫자)
	@Override
	public VoteResultVO getVoteResult(int vote_num) {
		
		return mapper.getVoteResult(vote_num);
	}

	@Override
	public List<VoteResultVO> getVoteResultMember(int vote_num) {
		
		return mapper.getVoteResultMember(vote_num);
	}

}
