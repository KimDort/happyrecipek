package com.happyrecipek.web.com.commonCode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.com.commonCode.entities.CommonHighCode;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonHighCode, Integer>{
	CommonHighCode findByCommonHighCode(String code);
	List<CommonHighCode> findByCommonHighCodeLocale(String local);
}
