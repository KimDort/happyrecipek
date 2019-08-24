package com.happyrecipek.web.admin.schedule.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.admin.schedule.entities.ScheduleBase;

@Repository
public interface ScheduleEventRepository extends JpaRepository<ScheduleBase, Integer>{
	List<ScheduleBase> findByscheduleDateContaining(String month);
	ScheduleBase findById(int eventSeq);
}
