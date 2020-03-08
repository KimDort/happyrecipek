package com.happyrecipek.web.com.commonCode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.com.commonCode.entities.CommonHighCode;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonHighCode, Integer>{
	CommonHighCode findByCommonHighCode(String code);
	CommonHighCode findByCommonHighCodeAndCommonHighCodeLocale(String code, String locale);
	List<CommonHighCode> findByCommonHighCodeLocale(String local);
}
