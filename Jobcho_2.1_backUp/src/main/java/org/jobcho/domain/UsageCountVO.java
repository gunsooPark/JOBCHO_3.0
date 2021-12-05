package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsageCountVO {
	private int postCount;
	private int replyCount;
	private int todoCount;
}
