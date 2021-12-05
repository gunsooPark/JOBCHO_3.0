package org.jobcho.controller;

import org.jobcho.domain.TeamVO;
import org.jobcho.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ViewsController {

	@Autowired
	private TeamService teamService;
	
	
	//로그인페이지
	@GetMapping("/users/login")
	public void loginForm(){
	}
	
	//濡쒓렇�씤�떎�쓬�럹�씠吏�
	@GetMapping("/users/main")
	public void mainForm(){
	}
	
	//회원가입 페이지
	@GetMapping("/users/register")
	public void register(){
	}
	
	//비밀번호 찾기 첫번째 페이지
	@GetMapping("/users/findPw_1")
	public void findPw_1(){
	}
	
	//비밀번호 찾기 두번째 페이지
	@GetMapping("/users/findPw_2")
	public void findPw_2(){
	}
	
	//비밀번호 찾기 세번째 페이지
	@GetMapping("/users/findPw_3")
	public void findPw_3(){
	}
	
	//�쉶�썝媛��엯 �닔�젙 �럹�씠吏� 
	@GetMapping("/users/update")
	public void updateForm(){
	}
	
	//이메일로 비밀번호 찾기 
	@GetMapping("/users/emailFindPw")
	public void emailFindPw(){
	}
	
	//로그인 다음 페이지 -> 팀고르기 및 회원수정 
	@GetMapping("/team/choose")
	public String teamChoose(){
		return "/team/team";
	}
	
	//팀고르기 다음페이지 -> 메인페이지 
	@GetMapping("/team/main")
	public String teamMain(@RequestParam("team_num") int team_num, Model model){
		//전에 페이지에 받은 team_num으로 부터 팀객체를 생성하여 main페이지에 팀객체 전송하기 
		TeamVO team = teamService.getTeam(team_num);
		model.addAttribute("team", team);
		
		
		return "/main";
	}
	
	@GetMapping("/calendar/test")
	public String calendar(){
		return "/calendar/calendar";
	}
	
}
