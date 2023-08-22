package com.example.SpringSecurityJWT.Service;

import com.example.SpringSecurityJWT.Dto.MemberDto;
import com.example.SpringSecurityJWT.Entity.Member;
import com.example.SpringSecurityJWT.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;

    @Transactional
    public com.example.SpringSecurityJWT.Entity.Member searchById(String id) {
        return memberRepository.searchById(id);
    }

    @Transactional
    public void updateUserPw(String id, String pw) {
        Member member = memberRepository.searchById(id);
        member.setPw(pw);
    }
}
