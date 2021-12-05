package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.ChatRoomVO;

public interface ChatRoomMapper {
	int insertChatRoom(ChatRoomVO chatRoom);
	List<ChatRoomVO> getListChatRoom(int team_num);
	ChatRoomVO getChatRoom(int chatRoom_num);
	int updateChatRoom(ChatRoomVO chatRoom);
	int deleteChatRoom(int chatRoom_num);
}
