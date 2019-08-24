package com.happyrecipek.web.admin.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.admin.schedule.entities.ScheduleEvents;

public interface ScheduleEventDetailRepository  extends JpaRepository<ScheduleEvents, Integer>{
	//int deleteByScheduleSeq(int scheduelSeq);
}
