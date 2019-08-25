package com.happyrecipek.web.admin.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.admin.schedule.entities.ScheduleEvents;

@Repository
public interface ScheduleEventDetailRepository  extends JpaRepository<ScheduleEvents, Integer>{
	ScheduleEvents findByScheduleEventSeq(int scheduleEventSeq);
}
