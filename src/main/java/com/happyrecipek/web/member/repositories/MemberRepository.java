package com.happyrecipek.web.member.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.member.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	Optional<Member> findByMemberEmail(String memberEmail);
}
