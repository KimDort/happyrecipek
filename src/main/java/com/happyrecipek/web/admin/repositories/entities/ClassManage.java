package com.happyrecipek.web.admin.repositories.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;
import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;

@Entity
@Table(name="COOKING_CLASS")
public class ClassManage{
	
	@Id
	@Column(name="CLASS_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="클래스 순번")
	private Integer classSeq;
	
	@Column(name="CLASS_TITLE")
	@Description(logicalName="클래스 제목")
	private String classTitle;
	
	@Column(name="CLASS_CONTENT", columnDefinition="TEXT")
	@Description(logicalName="클래스 내용")
	private String classContent;
	
	@Column(name="CLASS_MIN_MEMBER")
	@Description(logicalName="클래스 최소인원")
	private String classMinMember;
	
	@Column(name="CLASS_MAX_MEMBER")
	@Description(logicalName="클래스 최대인원")
	private String classMaxMember;
	
	@Column(name="CLASS_DISLAY_YN")
	@Description(logicalName="클래스 메인 페이지 표시여부")
	private String classDisplayYn;
	
	@Column(name="REGISTER_DATE", updatable=false)
	@Description(logicalName="클래스 등록일")
	@CreationTimestamp
	private Timestamp registerDate;
	
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

	@OneToOne
	@JoinColumns({
		@JoinColumn(name="commonFileSeq")
	})
	private CommonFileInfo fileInfo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="classManage")
	private List<ClassDateManage> classDateManage;
	
	
	public List<ClassDateManage> getClassDateManage() {
		return classDateManage;
	}

	public void setClassDateManage(List<ClassDateManage> classDateManage) {
		this.classDateManage = classDateManage;
	}

	public Integer getClassSeq() {
		return classSeq;
	}

	public void setClassSeq(Integer classSeq) {
		this.classSeq = classSeq;
	}

	public String getClassTitle() {
		return classTitle;
	}

	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}

	public String getClassContent() {
		return classContent;
	}

	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}

	public String getClassMinMember() {
		return classMinMember;
	}

	public void setClassMinMember(String classMinMember) {
		this.classMinMember = classMinMember;
	}

	public String getClassMaxMember() {
		return classMaxMember;
	}

	public void setClassMaxMember(String classMaxMember) {
		this.classMaxMember = classMaxMember;
	}

	public String getClassDisplayYn() {
		return classDisplayYn;
	}

	public void setClassDisplayYn(String classDisplayYn) {
		this.classDisplayYn = classDisplayYn;
	}
	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public CommonFileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(CommonFileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	@Override
	public String toString() {
		return "ClassManage [classSeq=" + classSeq + ", classTitle=" + classTitle + ", classContent=" + classContent
				+ ", classMinMember=" + classMinMember + ", classMaxMember=" + classMaxMember + ", classDisplayYn="
				+ classDisplayYn + ", registerDate=" + registerDate + ", registerId=" + registerId + ", updateDate="
				+ updateDate + ", updateId=" + updateId + ", fileInfo=" + fileInfo + ", classDateManage="
				+ classDateManage + "]";
	}

}
