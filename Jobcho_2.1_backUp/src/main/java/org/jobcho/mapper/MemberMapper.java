package org.jobcho.mapper;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsersVO;

public interface MemberMapper {
	int insertMembers(MemberVO member);
	List<MemberVO> listTeamMembers(int team_num);
	int updateMemberInfo(MemberVO member);
	int deleteMemberInfo(int member_num);
	MemberVO checkMember(MemberVO member);
	int deleteAllMember(int team_num);
	int memberTeamNumber(int user_num);
	MemberVO getMemberByUserNum(Map<String, Integer> map);
	MemberVO getMember(int member_num);
	List<UsersVO> getUsersWithoutMembersList(int team_num);
	int insertMember2(MemberVO member);
	List<MemberVO> getListWithOutChatMember(Map<String, Integer> map);
}
