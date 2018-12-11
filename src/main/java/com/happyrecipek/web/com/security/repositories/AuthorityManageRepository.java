package com.happyrecipek.web.com.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.security.repositories.vo.AuthorityManage;

public interface AuthorityManageRepository extends JpaRepository<AuthorityManage, Integer>{

}
