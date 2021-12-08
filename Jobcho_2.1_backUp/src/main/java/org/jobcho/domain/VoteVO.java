package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteVO {

	private int vote_num;
	private String vote_name;
	private String vote_content1;
	private String vote_content2;
	private String vote_content3;
	private String vote_content4;
	private String vote_content5;
	private Date vote_date;
	private int islive;
	private int anonymously;
	private int team_num;
	private int member_num;
	
	private TeamVO team;
	private MemberVO member;
	
}
