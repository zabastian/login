package com.example.demo.authSessionLogin.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String emaiVerified);

    Optional<Member> findByEmail(String email);
}
