package org.jobcho.security;

import org.jobcho.domain.CustomUser;
import org.jobcho.domain.UsersVO;
import org.jobcho.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = { @Autowired })
	private UsersMapper usersMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		log.warn("Load User By UserName : " + userName);

		// userName means userid
		// 프로젝트에 알맞게 수정하면 됨 
		UsersVO vo = usersMapper.read(userName);
		
		
		
		log.warn("queried by member mapper: " + vo);

		return vo == null ? null : new CustomUser(vo);
	} 

}
