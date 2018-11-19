package com.happyrecipek.web.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.member.repositories.vo.MemberInfoManage;

public interface MemberInfoRepository extends JpaRepository<MemberInfoManage, Integer>{
}
