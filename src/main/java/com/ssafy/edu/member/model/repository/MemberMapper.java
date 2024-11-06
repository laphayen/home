package com.ssafy.edu.member.model.repository;

import com.ssafy.edu.member.MemberDto;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    
    int idCheck(String userId); // 아이디 중복 확인

    int joinMember(MemberDto memberDto); // 회원가입

    MemberDto loginMember(Map<String, String> map) throws SQLException;

    int editMember(MemberDto memberDto); // 회원 정보 수정

    int deleteMember(String userId); // 회원 탈퇴
    
}
