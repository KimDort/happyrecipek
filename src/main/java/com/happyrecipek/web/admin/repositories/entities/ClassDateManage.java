package com.happyrecipek.web.admin.repositories.entities;

import java.util.List;

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
	private Integer ClassDateSeq;
	
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
	
	@ManyToMany
	@JoinColumn(name="classSeq")
	private List<ClassManage> classManage;

	public Integer getClassDateSeq() {
		return ClassDateSeq;
	}

	public void setClassDateSeq(Integer classDateSeq) {
		ClassDateSeq = classDateSeq;
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

	public List<ClassManage> getClassManage() {
		return classManage;
	}

	public void setClassManage(List<ClassManage> classManage) {
		this.classManage = classManage;
	}

	@Override
	public String toString() {
		return "ClassDateManage [ClassDateSeq=" + ClassDateSeq + ", classStartDay=" + classStartDay + ", classEndDay="
				+ classEndDay + ", classManage=" + classManage + "]";
	}
	
}
