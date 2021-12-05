package org.jobcho.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jobcho.domain.AuthVO;
import org.jobcho.domain.CustomUser;
import org.jobcho.domain.UsersVO;
import org.jobcho.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import spring.board.email.Email;
import spring.board.email.EmailSender;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/users/*")
public class UsersController {

	@Autowired
	private UsersService service;

	@Autowired
	private Email email;

	@Autowired
	private EmailSender emailSender;
	
	
	// 회원가입
	@PostMapping("/register")
	public ResponseEntity<Integer> register(@RequestBody UsersVO users) {
		System.out.println(users);
		// 비밀번호 암호화 (인코더)
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		users.setUser_pw(passwordEncoder.encode(users.getUser_pw()));
		// 회원가입
		int re = service.insertUsers(users);
		// 권한부여
		service.insertAuth(users.getUser_email());
		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 비밀번호 찾기 첫번째
	@PostMapping("/findPw_1")
	public ResponseEntity<UsersVO> findPw_1(String user_email, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 이메일 받아서 나온 UsersVO 객체를 다음 페이지에 넘기기 위해 session에 저장
		UsersVO users = service.findUsers(user_email);
		session.setAttribute("users", users);

		System.out.println("비밀번호 찾기" + users);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// 비밀번호 찾기 두번째 비동기
	@PostMapping("/findPw_2")
	public ResponseEntity<Integer> findPw_2(HttpServletRequest request,
			@RequestParam("user_pwHint") String user_pwHint) {
		HttpSession session = request.getSession();
		UsersVO users = (UsersVO) session.getAttribute("users");

		int re = 0;

		if (users.getUser_pwHint().equals(user_pwHint)) {
			re = 1;
		}
		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 비밀번호 찾기 세번째 비동기
	@PostMapping("/findPw_3")
	public ResponseEntity<Integer> findPw_3(HttpServletRequest request, @RequestParam("user_pw") String user_pw) {
		// 비밀번호 암호화 (인코더)
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		HttpSession session = request.getSession();
		UsersVO users = (UsersVO) session.getAttribute("users");
		users.setUser_pw(passwordEncoder.encode(user_pw));
		int re = service.updatePw(users);
		System.out.println(re);
		// 세션 초기화
		session.invalidate();

		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 회원수정 -> 비동기
	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody UsersVO users, HttpSession session, Principal principal) {
		// principal로 user객체 가져오기 
		String user_email = principal.getName();
		System.out.println(user_email);
		//user객체 
		UsersVO users2 = service.findUsers(user_email);
		//원래 비밀번호
		String principalPw = users2.getUser_pw();
		System.out.println("principal의 비밀번호 : " + users2.getUser_pw());
		System.out.println("수정전 : " + users.getUser_pw());
		// 입력받은 비밀번호 
		String beforePw = users.getUser_pw();
		
		int re = 0;
		
		if(principalPw.equals(beforePw)){
			//비밀번호 뺴고 업데이트하도록 
			re = service.updateUsers2(users);
		}else{
			// 비밀번호 암호화 (인코더)
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			users.setUser_pw(passwordEncoder.encode(users.getUser_pw()));
			 re = service.updateUsers(users);
		}

		
		
		System.out.println("수정완료여부 : " + re);
		System.out.println(users);

		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 아이디 중복체크
	@PostMapping("/idCheck")
	public ResponseEntity<Integer> idCheck(UsersVO users) throws Exception {
		System.out.println(users);
		int re = service.idCheck(users);
		System.out.println(re);
		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 비밀번호 찾기 실제이메일로
	@PostMapping("/emailFindPw")
	public ResponseEntity<String> emailFindPw(@RequestBody UsersVO users) throws Exception {
		String user_name = users.getUser_name();
		String user_email = users.getUser_email();

		// hashMap 사용
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_name", user_name);
		map.put("user_email", user_email);

		// user 객체 가져오기
		UsersVO users1 = service.emailFindPw(map);
		System.out.println(users1);
		// 비밀번호
		String user_pw = users1.getUser_pw();
		System.out.println(user_pw);
		if (user_pw != null) {
			UUID uid = UUID.randomUUID();
			// 임시비밀번호 생성
			String pwd = uid.toString().substring(0, 8);
			System.out.println(pwd);

			email.setContent("당신의 임시 비밀번호는 " + pwd + "입니다");
			email.setReceiver(user_email);
			email.setSubject(user_name + "님 비밀번호 찾기 메일입니다.");
			emailSender.sendEmail(email);

			// 비밀번호 암호화 (인코더)
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			// 임시로 만든 비밀번호를 db에 적용
			// 암호화된 비밀번호
			String encodePw = passwordEncoder.encode(pwd);
			System.out.println("암호화된 비밀번호 : " + encodePw);
			users1.setUser_pw(encodePw);
			int re = service.updatePw(users1);
			System.out.println("비밀번호 변경 성공여부 : " + re);

		}

		return new ResponseEntity<String>(user_pw, HttpStatus.OK);
	}
	
	

}// endController
