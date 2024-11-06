package com.ssafy.edu.member.model.service;

import com.ssafy.edu.member.MemberDto;
import com.ssafy.edu.member.model.repository.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int idCheck(String userId) throws Exception {
        return memberMapper.idCheck(userId);
    }

    @Override
    public int joinMember(MemberDto memberDto) throws Exception {
//    	System.out.println("memberDto값:   " + memberDto);
        return memberMapper.joinMember(memberDto);
    }
    
    @Override
	public MemberDto loginMember(Map<String, String> map) throws Exception {
//    	System.out.println(map);
//    	System.out.println( memberMapper.loginMember(map));
		return memberMapper.loginMember(map);
	}


    @Override
    public int editMember(MemberDto memberDto) throws Exception {
    	System.out.println("Service에서 회원정보 수정 memberDto 값" + memberDto);
        return memberMapper.editMember(memberDto);
    }

    @Override
    public int deleteMember(String userId) throws Exception {
        return memberMapper.deleteMember(userId);
    }
}
