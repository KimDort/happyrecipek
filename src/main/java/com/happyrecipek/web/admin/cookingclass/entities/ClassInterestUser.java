package com.happyrecipek.web.admin.cookingclass.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="class_interest_user")
public class ClassInterestUser {

	@Id
	@Column(name="CLASS_INTEREST_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="클래스관심사람순번")
	private int classInterestSeq;
	
	@Column(name="CLASS_INTEREST_USER_IP")
	@Description(logicalName="클래스관심사람접속ip")
	private String classInterestUserIp;
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="클래스 등록자")
	private String registerId;
	
	@Column(name="UPDATE_DATE", updatable=true)
	@Description(logicalName="클래스 수정일")
	@LastModifiedDate
	private Timestamp updateDate;
	
	@Column(name="UPDATE_ID")
	@Description(logicalName="클래스 수정자")
	private String updateId;

	@JoinColumn(name="classSeq")
	private int classSeq;
	
	public int getClassInterestSeq() {
		return classInterestSeq;
	}

	public void setClassInterestSeq(int classInterestSeq) {
		this.classInterestSeq = classInterestSeq;
	}

	public String getClassInterestUserIp() {
		return classInterestUserIp;
	}

	public void setClassInterestUserIp(String classInterestUserIp) {
		this.classInterestUserIp = classInterestUserIp;
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

	public int getClassSeq() {
		return classSeq;
	}

	public void setClassSeq(int classSeq) {
		this.classSeq = classSeq;
	}

}
