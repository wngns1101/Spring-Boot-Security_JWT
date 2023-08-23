package com.example.SpringSecurityJWT.controller;

import com.example.SpringSecurityJWT.Dto.MemberDto;
import com.example.SpringSecurityJWT.Dto.ResponseSignIn;
import com.example.SpringSecurityJWT.Entity.Member;
import com.example.SpringSecurityJWT.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/member")
    public MemberDto searchMember(@RequestParam (value = "id") String userId) {
        Member member = memberService.searchById(userId);
        return new MemberDto(member.getId(), member.getPw());
    }

    @PutMapping("/member")
    public MemberDto updateMember(@RequestBody MemberDto memberDto) {
        memberService.updateUserPw(memberDto.getUserId(), memberDto.getUserPw());
        Member member = memberService.searchById(memberDto.getUserId());
        return new MemberDto(member.getId(), member.getPw());
    }

    @DeleteMapping("/member")
    public void deleteMember() {

    }

    @PostMapping("/sign-in")
    public ResponseEntity<ResponseSignIn> signIn(@RequestParam("id") String userId, @RequestParam("pw") String userPw) {
        ResponseSignIn responseSignIn = memberService.signIn(userId, userPw);// memberService를 사용한 처리
        return ResponseEntity.ok(responseSignIn);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestParam("id") String userId, @RequestParam("pw") String userPw) {
        // userId와 userPw를 사용하여 필요한 처리를 수행
        Member member = new Member();
        member.setId(userId);
        member.setPw(passwordEncoder.encode(userPw));
        memberService.joinUser(member); // memberService를 사용한 처리

        return ResponseEntity.ok("완료");
    }

}
