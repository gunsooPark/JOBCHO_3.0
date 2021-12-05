package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.ChatMemberVO;
import org.jobcho.domain.ChatRoomVO;
import org.jobcho.domain.ChatVO;
import org.jobcho.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	ChatMapper mapper;

	@Override
	public int insertChat(ChatVO chat) {
		// TODO Auto-generated method stub
		return mapper.insertChat(chat);
	}

	@Override
	public List<ChatVO> getListChat(int chatRoom_num) {
		// TODO Auto-generated method stub
		return mapper.getListChat(chatRoom_num);
	}

	@Override
	public int deleteChat(int chat_num) {
		// TODO Auto-generated method stub
		return mapper.deleteChat(chat_num);
	}

	@Override
	public int insertChatMember(ChatMemberVO chatMember) {
		// TODO Auto-generated method stub
		return mapper.insertChatMember(chatMember);
	}

	@Override
	public List<ChatMemberVO> getListChatMember(int chatRoom_num) {
		// TODO Auto-generated method stub
		return mapper.getListChatMember(chatRoom_num);
	}

	@Override
	public List<ChatMemberVO> getChatMember(int chatMember_num) {
		// TODO Auto-generated method stub
		return mapper.getChatMember(chatMember_num);
	}

	@Override
	public int deleteChatMember(int chatMember_num) {
		// TODO Auto-generated method stub
		return mapper.deleteChatMember(chatMember_num);
	}

	@Override
	public int insertChatRoom(ChatRoomVO chatRoom) {
		// TODO Auto-generated method stub
		return mapper.insertChatRoom(chatRoom);
	}

	@Override
	public List<ChatRoomVO> getListChatRoom(int team_num) {
		// TODO Auto-generated method stub
		return mapper.getListChatRoom(team_num);
	}

	@Override
	public ChatRoomVO getChatRoom(int chatRoom_num) {
		// TODO Auto-generated method stub
		return mapper.getChatRoom(chatRoom_num);
	}

	@Override
	public int updateChatRoom(ChatRoomVO chatRoom) {
		// TODO Auto-generated method stub
		return mapper.updateChatRoom(chatRoom);
	}

	@Override
	public int deleteChatRoom(int chatRoom_num) {
		// TODO Auto-generated method stub
		return mapper.deleteChatRoom(chatRoom_num);
	}
	
	
}
