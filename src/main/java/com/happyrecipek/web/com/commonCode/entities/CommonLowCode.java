package com.happyrecipek.web.com.commonCode.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="common_code_low")
public class CommonLowCode {

	@Id
	@Column(name="COMMON_LOW_CODE_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="공통코드 순번")
	private int commonLowCodeSeq;
	
	@Column(name="COMMON_LOW_CODE_CODE")
	@Description(logicalName="공통 소분류 코드")
	private String commonLowCode;
	
	@Column(name="COMMON_CODE_LOW_LOCLE")
	@Description(logicalName="공통 소분류 언어")
	private String commonLowCodeLocale;
	
	@Column(name="COMMON_CODE_LOW_NAME")
	@Description(logicalName="공통 소분류 이름")
	private String commonLowCodeName;
	
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
	private CommonHighCode commonHighCode;

	public int getCommonLowCodeSeq() {
		return commonLowCodeSeq;
	}

	public void setCommonLowCodeSeq(int commonLowCodeSeq) {
		this.commonLowCodeSeq = commonLowCodeSeq;
	}

	public String getCommonLowCode() {
		return commonLowCode;
	}

	public void setCommonLowCode(String commonLowCode) {
		this.commonLowCode = commonLowCode;
	}

	public String getCommonLowCodeLocale() {
		return commonLowCodeLocale;
	}

	public void setCommonLowCodeLocale(String commonLowCodeLocale) {
		this.commonLowCodeLocale = commonLowCodeLocale;
	}

	public String getCommonLowCodeName() {
		return commonLowCodeName;
	}

	public void setCommonLowCodeName(String commonLowCodeName) {
		this.commonLowCodeName = commonLowCodeName;
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

	public CommonHighCode getCommonHighCode() {
		return commonHighCode;
	}

	public void setCommonHighCode(CommonHighCode commonHighCode) {
		this.commonHighCode = commonHighCode;
	}

	@Override
	public String toString() {
		return "CommonLowCode [commonLowCodeSeq=" + commonLowCodeSeq + ", commonLowCode=" + commonLowCode
				+ ", commonLowCodeLocale=" + commonLowCodeLocale + ", commonLowCodeName=" + commonLowCodeName
				+ ", registerDate=" + registerDate + ", registerId=" + registerId + ", updateDate=" + updateDate
				+ ", updateId=" + updateId + ", commonHighCode=" + commonHighCode + "]";
	}
	
}
