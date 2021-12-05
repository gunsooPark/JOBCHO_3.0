package org.jobcho.domain;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class CustomUser extends User{

	private static final long serialVersionUID = 1L;
	
	private UsersVO users;
	
	//public CustomUser(){}
		
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
		super(username, password, authorities);
	}
	
	public CustomUser(UsersVO vo){
		
		super(vo.getUser_email(), vo.getUser_pw(), vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		
		this.users = vo;
	}

}
