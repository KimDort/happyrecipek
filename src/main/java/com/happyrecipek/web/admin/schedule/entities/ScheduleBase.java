package com.happyrecipek.web.admin.schedule.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="schedule_base")
public class ScheduleBase {
	
	@Id
	@Column(name="SCHEDULE_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="스케줄 순번")
	private int scheduleSeq;
	
	@Column(name="SCHEDULE_TITLE")
	@Description(logicalName="스케줄 제목")
	private String scheduleTitle;
	
	@Column(name="SCHEDULE_DATE")
	@Description(logicalName="스케줄 일자")
	private String scheduleDate;
	
	@Column(name="REGISTER_DATE", updatable=false)
	@Description(logicalName="등록일")
	@CreationTimestamp
	private Timestamp registerDate;
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="등록자")
	private String registerId;
	
	@Column(name="UPDATE_DATE", updatable=true)
	@Description(logicalName="수정일")
	@LastModifiedDate
	private Timestamp updateDate;
	
	@Column(name="UPDATE_ID")
	@Description(logicalName="수정자")
	private String updateId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="scheduleSeq")
	private List<ScheduleEvents> events;

	
	public int getScheduleSeq() {
		return scheduleSeq;
	}

	public void setScheduleSeq(int scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public List<ScheduleEvents> getEvents() {
		return events;
	}

	public void setEvents(List<ScheduleEvents> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "ScheduleBase [scheduleSeq=" + scheduleSeq + ", scheduleTitle=" + scheduleTitle + ", scheduleDate="
				+ scheduleDate + ", registerDate=" + registerDate + ", registerId=" + registerId + ", updateDate="
				+ updateDate + ", updateId=" + updateId + ", events=" + events + "]";
	}
	
}
