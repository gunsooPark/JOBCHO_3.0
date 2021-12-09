package org.jobcho.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

import org.jobcho.domain.ChatMemberVO;
import org.jobcho.domain.ChatRoomVO;
import org.jobcho.domain.ChatVO;
import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsersVO;
import org.jobcho.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("team/{team_num}/chatroom")
@Log4j
public class ChatController {
	@Autowired
	ChatService service;
	
	//채팅생성
	@PostMapping("/{chatRoom_num}/chat/new")
	public ResponseEntity<ChatVO> insertChat(@RequestBody ChatVO chat){
		chat.setUpload_name("");
		int re = service.insertChat(chat);
		return (re==1) ? new ResponseEntity<>(chat, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅리스트 반환
	@GetMapping("/{chatRoom_num}/chat")
	public ResponseEntity<List<ChatVO>> getListChat(@PathVariable("chatRoom_num") int chatRoom_num){
		List<ChatVO> list = service.getListChat(chatRoom_num);
		return (list ==null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//채팅 삭제
	@DeleteMapping("/{chatRoom_num}/chat/{chat_num}")
	public ResponseEntity<String> deleteChat(@PathVariable("chat_num") int chat_num){
		int re = service.deleteChat(chat_num);
		return (re == 1)? new ResponseEntity<>("Success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	//채팅멤버 초대
	@PostMapping("/{chatRoom_num}/chatmember/new")
	public ResponseEntity<ChatMemberVO> insertChatMember(@RequestBody ChatMemberVO chatMember){
		int re = service.insertChatMember(chatMember);
		return (re==1) ? new ResponseEntity<>(chatMember, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅멤버 리스트 반환
	@GetMapping("/{chatRoom_num}/chatmember")
	public ResponseEntity<List<ChatMemberVO>> getListChatMember(@PathVariable("chatRoom_num") int chatRoom_num){
		List<ChatMemberVO> list = service.getListChatMember(chatRoom_num);
		return (list == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//멤버 번호에 맞는 채팅멤버 목록 반환
	@GetMapping("/{chatRoom_num}/chatmember/{member_num}")
	public ResponseEntity<List<ChatMemberVO>> getChatMember(@PathVariable("member_num") int member_num){
		List<ChatMemberVO> chatMember = service.getChatMember(member_num);
		return (chatMember == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(chatMember, HttpStatus.OK);
	}
	
	//채팅멤버 삭제
	@DeleteMapping("/chatmember/{chatmember_num}")
	public ResponseEntity<String> deleteChatMember(@PathVariable("chatmember_num") int chatMember_num){
		int re = service.deleteChatMember(chatMember_num);
		return (re == 1)? new ResponseEntity<>("Success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅방 생성
	@PostMapping("/new")
	public ResponseEntity<ChatRoomVO> insertChatRoom(@RequestBody ChatRoomVO chatRoom){
		System.out.println(chatRoom);
		int re = service.insertChatRoom(chatRoom);
		return (re==1) ? new ResponseEntity<>(chatRoom, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅방 목록 반환
	@GetMapping("/")
	public ResponseEntity<List<ChatRoomVO>> getListChatRoom(@PathVariable("team_num") int team_num){
		List<ChatRoomVO> list = service.getListChatRoom(team_num);
		return (list == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//번호에 맞는 채팅방 정보 반환
	@GetMapping("/{chatRoom_num}")
	public ResponseEntity<ChatRoomVO> getChatRoom(@PathVariable("chatRoom_num") int chatRoom_num){
		ChatRoomVO chatRoom = service.getChatRoom(chatRoom_num);
		return (chatRoom == null)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(chatRoom, HttpStatus.OK);
	}
	
	//채팅방 정보 수정
	@PutMapping("/{chatRoom_num}")
	public ResponseEntity<ChatRoomVO> updateChatRoom(
			@PathVariable("chatRoom_num")int chatRoom_num,
			@RequestBody ChatRoomVO chatRoom){
		chatRoom.setChatRoom_num(chatRoom_num);
		int re = service.updateChatRoom(chatRoom);
		
		return (re==1) ? new ResponseEntity<>(chatRoom, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅방 삭제
	@DeleteMapping("/{chatRoom_num}")
	public ResponseEntity<String> deleteChatRoom(@PathVariable("chatRoom_num") int chatRoom_num){
		int re = service.deleteChatRoom(chatRoom_num);
		return (re == 1)? new ResponseEntity<>("Success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅창에서 파일 업로드
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(MultipartFile[] uploadFile, @RequestParam int chatMember_num){
		System.out.println("run upload..");
		String uploadFolder = "C:\\upload";
		UUID uuid = UUID.randomUUID();
		String uploadFileName = null;
		for(MultipartFile multipartFile : uploadFile){
			uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uuid +"_"+ uploadFileName;
			File saveFile = new File(uploadFolder, uploadFileName);
			
			try{
				multipartFile.transferTo(saveFile);
			} catch(Exception e){
				log.error(e.getMessage());
			}
		}
		ChatVO chat = new ChatVO();
		chat.setUpload_name(uploadFileName);
		chat.setChatMember_num(chatMember_num);
		chat.setChat_contents("");
		System.out.println(chat);
		int re = service.insertChat(chat);
		
		return (re==1)? new ResponseEntity<>(uploadFileName, HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//채팅방에서 파일 다운로드 
	@GetMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName){
		System.out.println(fileName);
		log.info("download file: " + fileName);
		
		Resource resource = new FileSystemResource("c:\\upload\\"+fileName);
		log.info("resource:" + resource);
		
		String resourceName = resource.getFilename();
		
		//removeUUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
		
		HttpHeaders headers = new HttpHeaders();
		try{
			headers.add("Content-Disposition", "attachment; filename=" + new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers,HttpStatus.OK);
	}
	
	
}
