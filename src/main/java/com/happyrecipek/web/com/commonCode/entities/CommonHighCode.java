package com.happyrecipek.web.com.commonCode.entities;

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
@Table(name="common_code_high")
public class CommonHighCode {
	
	@Id
	@Column(name="COMMON_HIGH_CODE_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="공통코드 순번")
	private int commonHighCodeSeq;
	
	@Column(name="COMMON_HIGH_CODE_CODE")
	@Description(logicalName="공통 대분류 코드")
	private String commonHighCode;
	
	@Column(name="COMMON_CODE_HIGH_LOCLE")
	@Description(logicalName="공통 대분류 언어")
	private String commonHighCodeLocale;
	
	@Column(name="COMMON_CODE_HIGH_NAME")
	@Description(logicalName="공통 대분류 이름")
	private String commonHighCodeName;
	
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
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="commonHighCodeSeq")
	private List<CommonLowCode> commonLowCodes;

	public int getCommonHighCodeSeq() {
		return commonHighCodeSeq;
	}

	public void setCommonHighCodeSeq(int commonHighCodeSeq) {
		this.commonHighCodeSeq = commonHighCodeSeq;
	}

	public String getCommonHighCode() {
		return commonHighCode;
	}

	public void setCommonHighCode(String commonHighCode) {
		this.commonHighCode = commonHighCode;
	}

	public String getCommonHighCodeLocale() {
		return commonHighCodeLocale;
	}

	public void setCommonHighCodeLocale(String commonHighCodeLocale) {
		this.commonHighCodeLocale = commonHighCodeLocale;
	}

	public String getCommonHighCodeName() {
		return commonHighCodeName;
	}

	public void setCommonHighCodeName(String commonHighCodeName) {
		this.commonHighCodeName = commonHighCodeName;
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

	public List<CommonLowCode> getCommonLowCodes() {
		return commonLowCodes;
	}

	public void setCommonLowCodes(List<CommonLowCode> commonLowCodes) {
		this.commonLowCodes = commonLowCodes;
	}
	
}
