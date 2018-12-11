package com.happyrecipek.web.com.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.security.repositories.vo.AuthorityRoleManage;

public interface AuthorityRoleManageRepository extends JpaRepository<AuthorityRoleManage, Integer>{

}
