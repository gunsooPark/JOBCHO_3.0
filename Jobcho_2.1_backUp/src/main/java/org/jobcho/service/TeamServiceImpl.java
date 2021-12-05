package org.jobcho.service;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.TeamVO;
import org.jobcho.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamMapper mapper;
	
	

	@Override
	public int insertTeam(TeamVO team) {
		
		return mapper.insertTeam(team);
	}

	
	@Override
	public List<TeamVO> getListTeam(int user_num) {
		
		return mapper.getListTeam(user_num);
	}

	
	@Override
	public TeamVO getTeam(int team_num) {
		
		return mapper.getTeam(team_num);
	}

	
	@Override
	public int updateTeam(TeamVO team) {
		
		return mapper.updateTeam(team);
	}

	@Override
	public int deleteTeam(int team_num) {
		
		return mapper.deleteTeam(team_num);
	}


	@Override
	public TeamVO selectTeam(Map<String, String> map) {
		TeamVO team = mapper.selectTeam(map);
		return team;
	}
	
	@Override
	public List<TeamVO> getListTeamByMemberJoin(int user_num){
		return mapper.getListTeamByMemberJoin(user_num);
	}

}
