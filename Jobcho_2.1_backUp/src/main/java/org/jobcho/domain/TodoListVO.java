package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListVO {
	private int todo_num;
	private String todo_title;
	private String todo_description;
	private Date todo_startDate;
	private Date todo_endDate;
	private int member_num;
	private int isLive;
	
	private MemberVO member;
}
