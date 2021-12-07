package org.jobcho.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatVO {
	private int chat_num;
	private int chatMember_num;
	private String chat_contents;
	private Date chat_date;
	private int islive;
	private String upload_name;
	
	private ChatMemberVO chatMember;
}
