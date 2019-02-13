package com.happyrecipek.web.admin.repositories.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="COOKING_CLASS_DATE")
public class ClassDateManage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="클래스날짜관리순번")
	private Integer classDateSeq;
	
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

	@ManyToOne
	private ClassManage classManage;
	
	public Integer getClassDateSeq() {
		return classDateSeq;
	}

	public void setClassDateSeq(Integer classDateSeq) {
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

	public ClassManage getClassManage() {
		return classManage;
	}

	public void setClassManage(ClassManage classManage) {
		this.classManage = classManage;
	}

	@Override
	public String toString() {
		return "ClassDateManage [classDateSeq=" + classDateSeq + ", classStartDay=" + classStartDay + ", classEndDay="
				+ classEndDay + ", classStartTime=" + classStartTime + ", classEndTime=" + classEndTime + "]";
	}

}
