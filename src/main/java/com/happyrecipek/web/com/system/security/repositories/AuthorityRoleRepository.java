package com.happyrecipek.web.com.system.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.system.security.repositories.entities.AuthorityRole;

public interface AuthorityRoleRepository extends JpaRepository<AuthorityRole, Integer>{

}
