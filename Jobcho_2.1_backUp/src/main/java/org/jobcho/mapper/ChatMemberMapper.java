package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.ChatMemberVO;

public interface ChatMemberMapper {
	int insertChatMember(ChatMemberVO chatMember);
	List<ChatMemberVO> getListChatMember(int chatRoom_num);
	ChatMemberVO getChatMember(int chatMember_num);
	int deleteChatMember(int chatMember_num);
}
