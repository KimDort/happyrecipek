package com.happyrecipek.web.com.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.security.repositories.vo.AuthorityRoleGroup;
import com.happyrecipek.web.com.security.repositories.vo.keys.AuthorityGroupKey;

public interface AuthorityRoleGroupRepository extends JpaRepository<AuthorityRoleGroup, AuthorityGroupKey>{

}
