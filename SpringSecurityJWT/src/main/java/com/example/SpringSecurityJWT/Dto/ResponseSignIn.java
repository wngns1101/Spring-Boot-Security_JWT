package com.example.SpringSecurityJWT.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseSignIn {
    private String userId;
    private String userPw;
    private String token;
}
