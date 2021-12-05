package org.jobcho.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersVO implements Serializable {
	private int user_num; //사용자번호
	private String user_name; //사용자이름
	private String user_phoneNum; //사용자전화번호
	private String user_email; //사용자 이메일
	private String user_pw; //사용자비밀번호
	private String user_birth; //사용자생년월일
	private String user_pwHint; //사용자 비밀번호 힌트
	private boolean enabled;
	private int isLive;
	private List<AuthVO> authList; //한사람이 여러개의 권한을 가질 수 있다. 
	private Date user_date;
}
