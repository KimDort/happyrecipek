package com.happyrecipek.web.com.commonCode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.com.commonCode.entities.CommonLowCode;

@Repository
public interface CommonDetailCodeRepository extends JpaRepository<CommonLowCode, Integer>{
	CommonLowCode findByCommonLowCode(String lowCode);
	CommonLowCode findByCommonLowCodeAndCommonLowCodeLocale(String lowCode, String locale);
}
