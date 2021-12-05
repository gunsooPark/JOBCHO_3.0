package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessLogVO {
	private int log_num;
	private Date log_date;
	private int member_num;
	
	private MemberVO member;
}
