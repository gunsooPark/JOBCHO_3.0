package org.jobcho.service;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsersVO;


public interface MembersService {
	List<MemberVO> getListMember(int team_num);
	MemberVO getMemberByUserNum(Map<String, Integer> map);
	MemberVO getMember(int member_num);
	int insertMember(MemberVO members);
	int updateMember( MemberVO members);
	int deleteMember( int member_num);
	List<UsersVO> getListWithoutMembers(int team_num);
	int insertMember2(MemberVO member);
}
