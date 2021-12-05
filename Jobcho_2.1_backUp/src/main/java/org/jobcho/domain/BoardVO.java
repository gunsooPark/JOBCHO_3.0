package org.jobcho.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO implements Serializable {
	private int board_num;
	private String board_name;
	private String board_info;
	private int member_num;
	private int team_num;
	private int isLive; // delete �뿬遺�
	private Date board_date;
	
	private MemberVO member;
	private TeamVO team;
}
