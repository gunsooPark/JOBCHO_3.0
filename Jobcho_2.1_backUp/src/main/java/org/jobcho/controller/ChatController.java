package org.jobcho.controller;

import java.util.List;

import org.jobcho.domain.ChatMemberVO;
import org.jobcho.domain.ChatRoomVO;
import org.jobcho.domain.ChatVO;
import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsersVO;
import org.jobcho.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("team/{team_num}/chatroom")
public class ChatController {
	@Autowired
	ChatService service;
	
	@PostMapping("/{chatRoom_num}/chat/new")
	public ResponseEntity<ChatVO> insertChat(@RequestBody ChatVO chat){
		int re = service.insertChat(chat);
		return (re==1) ? new ResponseEntity<>(chat, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{chatRoom_num}/chat")
	public ResponseEntity<List<ChatVO>> getListChat(@PathVariable("chatRoom_num") int chatRoom_num){
		List<ChatVO> list = service.getListChat(chatRoom_num);
		return (list ==null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/{chatRoom_num}/chat/{chat_num}")
	public ResponseEntity<String> deleteChat(@PathVariable("chat_num") int chat_num){
		int re = service.deleteChat(chat_num);
		return (re == 1)? new ResponseEntity<>("Success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/{chatRoom_num}/chatmember/new")
	public ResponseEntity<ChatMemberVO> insertChatMember(@RequestBody ChatMemberVO chatMember){
		int re = service.insertChatMember(chatMember);
		return (re==1) ? new ResponseEntity<>(chatMember, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{chatRoom_num}/chatmember")
	public ResponseEntity<List<ChatMemberVO>> getListChatMember(@PathVariable("chatRoom_num") int chatRoom_num){
		List<ChatMemberVO> list = service.getListChatMember(chatRoom_num);
		return (list == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{chatRoom_num}/chatmember/{member_num}")
	public ResponseEntity<List<ChatMemberVO>> getChatMember(@PathVariable("member_num") int member_num){
		List<ChatMemberVO> chatMember = service.getChatMember(member_num);
		return (chatMember == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(chatMember, HttpStatus.OK);
	}
	
	@DeleteMapping("/chatmember/{chatmember_num}")
	public ResponseEntity<String> deleteChatMember(@PathVariable("chatmember_num") int chatMember_num){
		int re = service.deleteChatMember(chatMember_num);
		return (re == 1)? new ResponseEntity<>("Success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/new")
	public ResponseEntity<ChatRoomVO> insertChatRoom(@RequestBody ChatRoomVO chatRoom){
		System.out.println(chatRoom);
		int re = service.insertChatRoom(chatRoom);
		return (re==1) ? new ResponseEntity<>(chatRoom, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ChatRoomVO>> getListChatRoom(@PathVariable("team_num") int team_num){
		List<ChatRoomVO> list = service.getListChatRoom(team_num);
		return (list == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{chatRoom_num}")
	public ResponseEntity<ChatRoomVO> getChatRoom(@PathVariable("chatRoom_num") int chatRoom_num){
		ChatRoomVO chatRoom = service.getChatRoom(chatRoom_num);
		return (chatRoom == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(chatRoom, HttpStatus.OK);
	}
	
	@PutMapping("/{chatRoom_num}")
	public ResponseEntity<ChatRoomVO> updateChatRoom(
			@PathVariable("chatRoom_num")int chatRoom_num,
			@RequestBody ChatRoomVO chatRoom){
		chatRoom.setChatRoom_num(chatRoom_num);
		int re = service.updateChatRoom(chatRoom);
		
		return (re==1) ? new ResponseEntity<>(chatRoom, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{chatRoom_num}")
	public ResponseEntity<String> deleteChatRoom(@PathVariable("chatRoom_num") int chatRoom_num){
		int re = service.deleteChatRoom(chatRoom_num);
		return (re == 1)? new ResponseEntity<>("Success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
