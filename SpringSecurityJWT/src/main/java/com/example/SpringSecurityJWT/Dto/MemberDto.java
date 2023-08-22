package com.example.SpringSecurityJWT.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MemberDto {
    private String userId;
    private String userPw;
}
