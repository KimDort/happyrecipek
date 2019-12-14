package com.happyrecipek.web.member.contents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
