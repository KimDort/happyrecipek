package com.happyrecipek.web.com.commonCode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.com.commonCode.entities.CommonHighCode;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonHighCode, Integer>{

}
