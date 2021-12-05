package org.jobcho.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CalendarVO implements Serializable{
	private int cal_num;
	private String cal_title;
	private int member_num;
	private String cal_contents;
	private String starts;
	private String ends;
	private boolean allday;
	private int isLive;
	
	
}
