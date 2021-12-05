package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMemberVO {
	private int chatMember_num;
	private int chatRoom_num;
	private int member_num;
	private Date chatMember_date;
	private int islive;
	
	private MemberVO member;
	private ChatRoomVO chatRoom;
}
