package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.ChatMemberVO;
import org.jobcho.domain.ChatRoomVO;
import org.jobcho.domain.ChatVO;

public interface ChatMapper {
	int insertChat(ChatVO chat);
	List<ChatVO> getListChat(int chatRoom_num);
	int deleteChat(int chat_num);
	
	int insertChatMember(ChatMemberVO chatMember);
	List<ChatMemberVO> getListChatMember(int chatRoom_num);
	List<ChatMemberVO> getChatMember(int chatMember_num);
	int deleteChatMember(int chatMember_num);
	
	int insertChatRoom(ChatRoomVO chatRoom);
	List<ChatRoomVO> getListChatRoom(int team_num);
	ChatRoomVO getChatRoom(int chatRoom_num);
	int updateChatRoom(ChatRoomVO chatRoom);
	int deleteChatRoom(int chatRoom_num);
}
