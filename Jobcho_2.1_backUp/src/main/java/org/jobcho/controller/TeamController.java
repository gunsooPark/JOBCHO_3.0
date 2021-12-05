package org.jobcho.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jobcho.domain.MemberVO;
import org.jobcho.domain.TeamVO;
import org.jobcho.service.MembersService;
import org.jobcho.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team")
@Log4j
public class TeamController {

	@Autowired
	private TeamService service;
	
	@Autowired
	private MembersService memberService;
	
	//팀생성
	@PostMapping("/{user_num}")
	public ResponseEntity<TeamVO> insertTeam(@RequestBody TeamVO teamVO, @PathVariable("user_num") int user_num){
		//성연님 작업중 버그가 생겨 아래와 같이 코드를 작성하였습니다.
		
		//팀생성 실행 
		int insertCount = service.insertTeam(teamVO);
		//위에 생성된  teamVO team_num이 없다. 그래서 team_num을 가져오기 위해 아래와 같이 실행함
		System.out.println("team_num이 없는 팀 객체 : " + teamVO);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("team_name", teamVO.getTeam_name());
		map.put("team_info", teamVO.getTeam_info());
		
		//team_num이 포함된 teamVO 객체를 가져왔다. 
		TeamVO team = service.selectTeam(map);
		System.out.println("team_num이 있는 팀 객체" + team);
		
		
		MemberVO member = new MemberVO();
		member.setTeam_num(team.getTeam_num());
		member.setUser_num(user_num);
		//사용자가 자동으로 member테이블에 insert된다. 
		memberService.insertMember2(member);
		System.out.println("member 객체 확인용 : " +member);
		
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//팀불러오기
	@GetMapping(value = "/{user_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TeamVO>> getListTeam(@PathVariable("user_num") int user_num){
		log.info("�� ��� ȣ�� Ȯ��");
		return new ResponseEntity<>(service.getListTeam(user_num), HttpStatus.OK);
	}
	
	//팀하나 가져오기 
	@GetMapping(value="/{user_num}/{team_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<TeamVO> getTeam(@PathVariable("team_num") int team_num){
		log.info("�� ���� ��ȸ");
		return new ResponseEntity<>(service.getTeam(team_num), HttpStatus.OK);
	}
	
	//팀업데이트
	@PutMapping(value = "/{team_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<TeamVO> getTeam(@PathVariable("team_num") int team_num, @RequestBody TeamVO teamVO){
		/*int user_num = 
		TeamVO team = new TeamVO();
		
		team = service.getTeam(team_num);
		
		if(team.getUser_num() == user_num){
			
		}*/
		TeamVO team = new TeamVO();
		
		team.setTeam_num(team_num);
		team.setTeam_name(teamVO.getTeam_name());
		team.setTeam_info(teamVO.getTeam_info());
		
		int insertCount = service.updateTeam(team);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//팀삭제
	@DeleteMapping(value = "/{team_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<TeamVO> deleteTeam(@PathVariable("team_num") int team_num){
		int insertCount = service.deleteTeam(team_num);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping(value = "/getlist/{user_num}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TeamVO>> getListTeamByMemberJoin(@PathVariable("user_num") int user_num){
		log.info("�� ��� ȣ�� Ȯ��");
		return new ResponseEntity<>(service.getListTeamByMemberJoin(user_num), HttpStatus.OK);
	}
	
}
