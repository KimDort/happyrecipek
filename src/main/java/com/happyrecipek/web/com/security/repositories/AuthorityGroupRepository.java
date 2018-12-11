package com.happyrecipek.web.com.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.security.repositories.vo.AuthorityGroup;

public interface AuthorityGroupRepository extends JpaRepository<AuthorityGroup, Integer>{

}
