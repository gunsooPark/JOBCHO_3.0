package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomVO {
	private int chatRoom_num;
	private String chatRoom_name;
	private int team_num;
	private Date chatRoom_date;
	private int islive;
	
	private TeamVO team;
}
