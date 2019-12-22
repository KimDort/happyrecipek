package com.happyrecipek.web.member.contents.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="content")
public class Content {
	@Id
	@Column(name="CONTENT_SEQ")
	@Description(logicalName="콘텐츠순번")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contentSeq;
	
	@Column(name="CONTENT_CATEGORY_CODE")
	@Description(logicalName="카테고리코드")
	private String categoryCode;
	
	@Column(name="CONTENT_TITLE")
	@Description(logicalName = "콘텐츠제목")
	private String contentTitle;
	
	@Column(name="CONTENT_YOUTUBE", columnDefinition="TEXT")
	@Description(logicalName="콘텐츠유튜브")
	private String contentYoutube;
	
	@Column(name="CONTENT_OTHER", columnDefinition="TEXT")
	@Description(logicalName="콘텐츠기타설명")
	private String contentOther;
	
	@Column(name="DISPLAY_YN")
	@Description(logicalName = "표시여부")
	private String displayYn;
	
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

	public int getContentSeq() {
		return contentSeq;
	}

	public void setContentSeq(int contentSeq) {
		this.contentSeq = contentSeq;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentYoutube() {
		return contentYoutube;
	}

	public void setContentYoutube(String contentYoutube) {
		this.contentYoutube = contentYoutube;
	}

	public String getContentOther() {
		return contentOther;
	}

	public void setContentOther(String contentOther) {
		this.contentOther = contentOther;
	}

	public String getDisplayYn() {
		return displayYn;
	}

	public void setDisplayYn(String displayYn) {
		this.displayYn = displayYn;
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
	
}
