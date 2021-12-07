package org.jobcho.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jobcho.domain.MemberVO;

import org.jobcho.domain.UsersVO;
import org.jobcho.mapper.MemberMapper;

import org.jobcho.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team/{team_num}/member")
@Log4j
public class MembersController {
//	get: /team/{team_num}/members=>팀번호에 맞는 멤버리스트 반환
//
//			get: /team/{team_num}/members/{member_num} =>멤버 정보 반환
//
//			post: /team/{team_num}/members/invite => 팀에 멤버 초대
//
//			put: /team/{team_num}/members/{member_num} =>멤버 정보 수정
//
//			delete: /team/{team_num}/members/{member_num} => 멤버 정보 삭제
	@Autowired
	MembersService service;
	
	@GetMapping("")
	public ResponseEntity<List<MemberVO>> getListMember(@PathVariable("team_num") int team_num
			){
		List<MemberVO> list = service.getListMember(team_num);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{user_num}")
	public ResponseEntity<MemberVO> getMember(
			@PathVariable("team_num") int team_num, 
			@PathVariable("user_num") int user_num){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("team_num", team_num);
		map.put("user_num", user_num);
		MemberVO member = service.getMemberByUserNum(map);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
	@PostMapping("/invite")
	public ResponseEntity<MemberVO> insertMember(@PathVariable("team_num") int team_num, @RequestBody MemberVO members){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("user_num", members.getUser_num());
		map.put("team_num", members.getTeam_num());
		System.out.println(map);
		MemberVO isliveMember = service.getMemberByUserNum(map);
		System.out.println(isliveMember);
		
		if(isliveMember==null){
			int re = service.insertMember(members);
			log.info(members);
			return (re==1)? new ResponseEntity<>(members, HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(isliveMember.getIsLive()==0){
			isliveMember.setIsLive(1);
			
			int re = service.updateMember(isliveMember);
			return (re==1)? new ResponseEntity<>(members, HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		int re = service.insertMember(members);
		log.info(members);
		return (re==1)? new ResponseEntity<>(members, HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{member_num}")
	public ResponseEntity<MemberVO> updateMember(@PathVariable("team_num") int team_num, 
			@PathVariable("member_num") int member_num, @RequestBody MemberVO members){
		MemberVO updateMember = service.getMember(member_num);
		updateMember.setMember_position(members.getMember_position());
		int re = service.updateMember(updateMember);
		
		return (re==1)? new ResponseEntity<>(updateMember, HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/{member_num}")
	public ResponseEntity<String> deleteMember(@PathVariable("team_num") int team_num,
			@PathVariable("member_num") int member_num){
		int re = service.deleteMember(member_num);
		
		return (re==1)? new ResponseEntity<>("success", HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/withoutmember")
	public ResponseEntity<List<UsersVO>> getListWithoutMembers(@PathVariable("team_num") int team_num){
		List<UsersVO> searchList = service.getListWithoutMembers(team_num);
		
		return ResponseEntity.status(HttpStatus.OK).body(searchList);
	}
	
	@GetMapping("/withoutchatmember")
	public ResponseEntity<List<MemberVO>> getListWithOutChatMember(@PathVariable("team_num") int team_num,
			@RequestParam int chatroom_num){
		Map<String, Integer> map = new HashMap<>();
		map.put("team_num", team_num);
		map.put("chatroom_num", chatroom_num);
		List<MemberVO> list = service.getListWithOutChatMember(map);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
}
