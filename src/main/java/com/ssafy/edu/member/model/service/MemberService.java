package com.ssafy.edu.member.model.service;

import java.util.Map;

import com.ssafy.edu.member.MemberDto;

public interface MemberService {
    int idCheck(String userId) throws Exception;
    int joinMember(MemberDto memberDto) throws Exception;
    MemberDto loginMember(Map<String, String> map) throws Exception;
    int editMember(MemberDto memberDto) throws Exception;
    int deleteMember(String userId) throws Exception;
}
