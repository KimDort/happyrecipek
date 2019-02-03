package com.happyrecipek.web.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.admin.repositories.entities.ClassManage;

public interface ClassRepository extends JpaRepository<ClassManage, Integer>{
	
}
