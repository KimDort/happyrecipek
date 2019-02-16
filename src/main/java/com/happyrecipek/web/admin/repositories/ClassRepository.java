package com.happyrecipek.web.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.happyrecipek.web.admin.repositories.entities.ClassDate;
import com.happyrecipek.web.admin.repositories.entities.ClassBase;

public interface ClassRepository extends JpaRepository<ClassBase, Integer>{
	@Query(value="SELECT * FROM CLASS_BASE_INFO A"
			+ " INNER JOIN CLASS_DATE_INFO B"
			+ " ON A.CLASS_SEQ = B.CLASS_SEQ"
			+ " WHERE A.CLASS_DISPLAY_YN = 'Y'"
			+ " AND (B.CLASS_START_DAY > LAST_DAY(NOW() - INTERVAL 2 MONTH) AND B.CLASS_START_DAY <= LAST_DAY(NOW()))"
			, nativeQuery = true)
	List<ClassBase> findAllActiveClassBasesNative();
}