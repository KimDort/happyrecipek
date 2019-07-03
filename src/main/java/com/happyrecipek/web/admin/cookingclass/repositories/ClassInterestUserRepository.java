package com.happyrecipek.web.admin.cookingclass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.admin.cookingclass.entities.ClassInterestUser;

@Repository
public interface ClassInterestUserRepository extends JpaRepository<ClassInterestUser, Integer>{

}
