package org.jobcho.mapper;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.TeamVO;

public interface TeamMapper {
	
	int insertTeam(TeamVO team);
	List<TeamVO> getListTeam(int user_num);
	TeamVO getTeam(int team_num);
	int updateTeam(TeamVO team);
	int deleteTeam(int team_num);
	TeamVO selectTeam(Map<String, String> map);
	List<TeamVO> getListTeamByMemberJoin(int user_num);
}
