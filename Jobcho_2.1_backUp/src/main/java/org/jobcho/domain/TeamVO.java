package org.jobcho.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamVO {
	private int team_num;
	private String team_name;
	private String team_info;
	private int user_num;
	private int isLive;
	
	private UsersVO user;
}
