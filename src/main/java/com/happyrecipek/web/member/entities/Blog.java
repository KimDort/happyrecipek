package com.happyrecipek.web.member.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="blog")
public class Blog {
	@Id
	@Column(name="BLOG_SEQ")
	@Description(logicalName="블로그순번")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blogSeq;
	
	@Column(name="BLOG_TITLE")
	@Description(logicalName="블로그제목")
	@NotEmpty
	private String blogTitle;
	
	@Column(name="BLOG_CONTENT")
	@Description(logicalName="블로그내용")
	private String blogContent;
	
	@Column(name="DISPLAY_YN")
	@Description(logicalName="표시여부")
	private String displayYn;
	
	@Column(name="REGISTER_DATE", updatable=false)
	@Description(logicalName="등록일")
	@CreationTimestamp
	private Timestamp registerDate;
	
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="등록자")
	private String registerId;

	
	public String getDisplayYn() {
		return displayYn;
	}

	public void setDisplayYn(String displayYn) {
		this.displayYn = displayYn;
	}

	public int getBlogSeq() {
		return blogSeq;
	}

	public void setBlogSeq(int blogSeq) {
		this.blogSeq = blogSeq;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
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

	@Override
	public String toString() {
		return "Blog [blogSeq=" + blogSeq + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent
				+ ", registerDate=" + registerDate + ", displayYn=" + displayYn + ", registerId=" + registerId + "]";
	}
	
}
