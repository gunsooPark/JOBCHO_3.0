package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteResultVO {

	private int vote_num;
	private int vote_result1;
	private int vote_result2;
	private int vote_result3;
	private int vote_result4;
	private int vote_result5;
	private int islive;
	private int member_num;
	
	
	private String vote_content1;
	private String vote_content2;
	private String vote_content3;
	private String vote_content4;
	private String vote_content5;
	
	private String user_name;
	
	private VoteVO vote;
	private MemberVO member;
	
}
