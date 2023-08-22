package com.example.SpringSecurityJWT.controller;

import com.example.SpringSecurityJWT.Dto.MemberDto;
import com.example.SpringSecurityJWT.Entity.Member;
import com.example.SpringSecurityJWT.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

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
    public MemberDto signIn(@RequestBody MemberDto memberDto) {
        return new MemberDto(memberDto.getUserId(), memberDto.getUserPw());
    }
}
