package com.happyrecipek.web.admin.schedule.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="schedule_events")
public class ScheduleEvents {

	@Id
	@Column(name="SCHEDULE_EVENT_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="스케줄 이벤트 순번")
	private int scheduleEventSeq;
	
	@Column(name="SCHEDULE_EVENT_START_TIME")
	@Description(logicalName="스케줄 이벤트 시작 시간")
	private String scheduleEventStartTime;
	
	@Column(name="SCHEDULE_EVENT_END_TIME")
	@Description(logicalName="스케줄 이벤트 종료 시간")
	private String scheduleEventEndTime;
	
	@Column(name="SCHEDULE_EVENT_CONTENT", columnDefinition="TEXT")
	@Description(logicalName="클래스 내용")
	private String scheduleEventContent;
	
	@Column(name="SCHEDULE_EVENT_CONFIRM_YN")
	@Description(logicalName="스케줄 이벤트 처리여부")
	private String scheduleEventConfirmYn;
	
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

	@ManyToOne
	@JoinColumn(name="scheduleSeq")
	private ScheduleBase scheduleBase;
	
	
	public ScheduleBase getScheduleBase() {
		return scheduleBase;
	}

	public void setScheduleBase(ScheduleBase scheduleBase) {
		this.scheduleBase = scheduleBase;
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

	public int getScheduleEventSeq() {
		return scheduleEventSeq;
	}

	public void setScheduleEventSeq(int scheduleEventSeq) {
		this.scheduleEventSeq = scheduleEventSeq;
	}

	public String getScheduleEventStartTime() {
		return scheduleEventStartTime;
	}

	public void setScheduleEventStartTime(String scheduleEventStartTime) {
		this.scheduleEventStartTime = scheduleEventStartTime;
	}

	public String getScheduleEventEndTime() {
		return scheduleEventEndTime;
	}

	public void setScheduleEventEndTime(String scheduleEventEndTime) {
		this.scheduleEventEndTime = scheduleEventEndTime;
	}

	public String getScheduleEventContent() {
		return scheduleEventContent;
	}

	public void setScheduleEventContent(String scheduleEventContent) {
		this.scheduleEventContent = scheduleEventContent;
	}

	public String getScheduleEventConfirmYn() {
		return scheduleEventConfirmYn;
	}

	public void setScheduleEventConfirmYn(String scheduleEventConfirmYn) {
		this.scheduleEventConfirmYn = scheduleEventConfirmYn;
	}

	@Override
	public String toString() {
		return "ScheduleEvents [scheduleEventSeq=" + scheduleEventSeq + ", scheduleEventStartTime="
				+ scheduleEventStartTime + ", scheduleEventEndTime=" + scheduleEventEndTime + ", scheduleEventContent="
				+ scheduleEventContent + ", scheduleEventConfirmYn=" + scheduleEventConfirmYn + ", registerDate="
				+ registerDate + ", registerId=" + registerId + ", updateDate=" + updateDate + ", updateId=" + updateId
				+ ", scheduleBase=" + scheduleBase + "]";
	}

}
