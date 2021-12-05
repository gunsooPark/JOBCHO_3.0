package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private int member_num;
	private String member_position;
	private int team_num;
	private int user_num;
	private int isLive;
	private Date member_date;
	
	private UsersVO user;
	private TeamVO team;
}

