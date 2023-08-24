package com.example.SpringSecurityJWT.Service;

import com.example.SpringSecurityJWT.Dto.MemberDto;
import com.example.SpringSecurityJWT.Dto.ResponseSignIn;
import com.example.SpringSecurityJWT.Entity.Member;
import com.example.SpringSecurityJWT.Repository.MemberRepository;
import com.example.SpringSecurityJWT.Security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public com.example.SpringSecurityJWT.Entity.Member searchById(String id) {
        return memberRepository.searchById(id);
    }

    @Transactional
    public void updateUserPw(String id, String pw) {
        Member member = memberRepository.searchById(id);
        member.setPw(pw);
    }

    @Transactional
    public void joinUser(Member member) {
        memberRepository.joinUser(member);
    }

    @Transactional
    public ResponseSignIn signIn(String id, String pw) {
        String token = null;
        Member member = memberRepository.searchById(id);
        System.out.println(pw);
        System.out.println(member.getPw());
        if (passwordEncoder.matches(pw, member.getPw())) {
            token = tokenProvider.createToken(String.format("%s:%s", member.getId(), member.getPw()));
            System.out.println(token);
        } else {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        return new ResponseSignIn(member.getId(), member.getPw(), token);
    }
}
