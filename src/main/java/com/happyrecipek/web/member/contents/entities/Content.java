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
	
	@Column
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
}
