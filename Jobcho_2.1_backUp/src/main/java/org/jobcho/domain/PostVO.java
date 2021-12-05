package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
	private int post_num;
	private String post_title;
	private String post_contents;
	private int board_num;
	private int member_num;
	private Date post_date;
	private int isLive;
	private int replyCnt; //댓글 수 컬럼추가
	
	private BoardVO board;
	private MemberVO member;
	
}
