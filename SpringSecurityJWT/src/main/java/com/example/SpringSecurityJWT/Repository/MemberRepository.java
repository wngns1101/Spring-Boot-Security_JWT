package com.example.SpringSecurityJWT.Repository;

import com.example.SpringSecurityJWT.Dto.MemberDto;
import com.example.SpringSecurityJWT.Entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public Member searchById(String userId) {
        return em.find(Member.class, userId);
    }

}
