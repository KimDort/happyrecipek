package com.happyrecipek.web.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.admin.entities.ClassBase;
import com.happyrecipek.web.admin.entities.ClassDate;

@Repository
public interface ClassRepository extends JpaRepository<ClassBase, Integer>{
	@Query(value="select * from class_base_info a"
			+ " inner join class_date_info b"
			+ " on a.class_seq = b.class_seq"
			+ " where a.class_display_yn = 'y'"
			+ " and (b.class_start_day > last_day(now() - interval 2 month) and b.class_start_day <= last_day(now() + interval 1 month))"
			, nativeQuery = true)
	List<ClassBase> findAllActiveClassBasesNative();
	
	ClassBase findByClassSeq(Integer ClassSeq);
}