package org.jobcho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.jobcho.domain.UsersVO;
import org.jobcho.mapper.UsersMapper;

@Service
public class UsersServicelmpl implements UsersService {

	@Autowired
	private UsersMapper mapper;

	// 회원가입
	@Override
	public int insertUsers(UsersVO users) {
		int re = mapper.insertUsers(users);
		return re;
	}
	
	//회원가입 후 권한부여 
	@Override
	public int insertAuth(String user_email) {
		int re = mapper.insertAuth(user_email);
		return re;
	}
	

	// 비밀번호 찾기 첫번째(이메일입력해서)
	@Override
	public UsersVO findUsers(String user_email) {
		UsersVO users = mapper.findUsers(user_email);
		return users;
	}

	// 비밀번호 재설정
	@Override
	public int updatePw(UsersVO users) {
		int re = mapper.updatePw(users);
		return re;
	}

	// 로그인
	@Override
	public UsersVO loginUsers(UsersVO users) {
		return mapper.loginUsers(users);
	}

	//회원정보 수정 
	@Override
	public int updateUsers(UsersVO users) {
		int re = mapper.updateUsers(users);
		System.out.println("회원정보조회 service");
		return re;
	}

	//비밀번호 뺴고 회원정보수정 
	@Override
	public int updateUsers2(UsersVO users) {
		int re = mapper.updateUsers2(users);
		return re;
	}
	
	//회원 한명 조회 
	@Override
	public UsersVO selectUsers(int user_num) {
		UsersVO users = mapper.selectUsers(user_num);
		return users;
	}

	//아이디 중복체크 
	@Override
	public int idCheck(UsersVO users) {
		int re = mapper.idCheck(users);
		return re;
	}

	//비밀번호 찾기 이메일 
	@Override
	public UsersVO emailFindPw(Map<String, String> map) {
		UsersVO users = mapper.emailFindPw(map);
		return users;
	}

	@Override
	public UsersVO read(String user_email) {
		UsersVO users = mapper.read(user_email);
		return null;
	}

	

	

	


}











