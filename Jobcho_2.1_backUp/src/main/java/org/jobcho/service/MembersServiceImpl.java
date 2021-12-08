package org.jobcho.service;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsersVO;
import org.jobcho.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl implements MembersService {
	
	@Autowired
	MemberMapper mapper;
	
	@Override
	public List<MemberVO> getListMember(int team_num) {
		// TODO Auto-generated method stub
		return mapper.listTeamMembers(team_num);
	}

	@Override
	public MemberVO getMemberByUserNum(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		System.out.println(map);
		return mapper.getMemberByUserNum(map);
	}
	
	@Override
	public MemberVO getMember(int member_num) {
		// TODO Auto-generated method stub
		return mapper.getMember(member_num);
	}

	@Override
	public int insertMember(MemberVO members) {
		// TODO Auto-generated method stub
		return mapper.insertMembers(members);
	}

	@Override
	public int updateMember( MemberVO members) {
		// TODO Auto-generated method stub
		return mapper.updateMemberInfo(members);
	}

	@Override
	public int deleteMember(int member_num) {
		// TODO Auto-generated method stub
		return mapper.deleteMemberInfo(member_num);
	}

	@Override
	public List<UsersVO> getListWithoutMembers(int team_num) {
		// TODO Auto-generated method stub
		return mapper.getUsersWithoutMembersList(team_num);
	}

	@Override
	public int insertMember2(MemberVO member) {
		int re = mapper.insertMember2(member);
		return re;
	}

	@Override
	public List<MemberVO> getListWithOutChatMember(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return mapper.getListWithOutChatMember(map);
	}

	@Override
	public int updateMemberProfile(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.updateMemberProfile(member);
	}
	
	

}
