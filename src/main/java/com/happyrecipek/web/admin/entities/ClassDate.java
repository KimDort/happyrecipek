package com.happyrecipek.web.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="class_date_info")
public class ClassDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="클래스날짜관리순번")
	private int classDateSeq;
	
	@Column(name="CLASS_START_DAY")
	@Description(logicalName="클래스 시작일")
	private String classStartDay;
	
	@Column(name="CLASS_END_DAY")
	@Description(logicalName="클래스 종료일")
	private String classEndDay;
	
	@Column(name="CLASS_START_TIME")
	@Description(logicalName="클래스 시작시간")
	private String classStartTime;
	
	@Column(name="CLASS_END_TIME")
	@Description(logicalName="클래스 종료시간")
	private String classEndTime;
	
	public int getClassDateSeq() {
		return classDateSeq;
	}

	public void setClassDateSeq(int classDateSeq) {
		this.classDateSeq = classDateSeq;
	}

	public String getClassStartDay() {
		return classStartDay;
	}

	public void setClassStartDay(String classStartDay) {
		this.classStartDay = classStartDay;
	}

	public String getClassEndDay() {
		return classEndDay;
	}

	public void setClassEndDay(String classEndDay) {
		this.classEndDay = classEndDay;
	}

	public String getClassStartTime() {
		return classStartTime;
	}

	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}

	public String getClassEndTime() {
		return classEndTime;
	}

	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
	}

	@Override
	public String toString() {
		return "ClassDateManage [classDateSeq=" + classDateSeq + ", classStartDay=" + classStartDay + ", classEndDay="
				+ classEndDay + ", classStartTime=" + classStartTime + ", classEndTime=" + classEndTime + "]";
	}

}
