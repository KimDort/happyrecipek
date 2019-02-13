package com.happyrecipek.web.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.happyrecipek.web.admin.repositories.entities.ClassDateManage;
import com.happyrecipek.web.admin.repositories.entities.ClassManage;

public interface ClassRepository extends JpaRepository<ClassManage, Integer>{
}
