package org.jobcho.service;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.TeamVO;

public interface TeamService {

	public int insertTeam(TeamVO team);
	public List<TeamVO> getListTeam(int user_num);
	public TeamVO getTeam(int team_num);
	public int updateTeam(TeamVO team);
	public int deleteTeam(int team_num);
	TeamVO selectTeam(Map<String, String> map);
	List<TeamVO> getListTeamByMemberJoin(int user_num);
}
