package com.happyrecipek.web.com.system.files.ckeditor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="COMMON_FILE_INFO")
public class CommonFileInfo {

	@Id
	@Column(name="COMMON_FILE_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="공통파일순번")
	private Integer commonFileSeq;
	
	@Column(name="COMMON_FILE_REGISTER_BBS_SEQ")
	@Description(logicalName="공통파일등록게시판순번")
	private Integer commonFileRegisterBbsSeq;
	
	@Column(name="COMMON_FILE_REGISTER_BBS")
	@Description(logicalName="공통파일등록게시판")
	private String commonFileRegisterBbs;
	
	@Column(name="COMMON_FILE_ORG_NAME")
	@Description(logicalName="공통파일원본이름")
	private String commonFileOrgName;
	
	@Column(name="COMMON_FILE_COPY_NAME")
	@Description(logicalName="공통파일복사본이름")
	private String commonFileCopyName;
	
	@Column(name="COMMON_FILE_SIZE")
	@Description(logicalName="공통파일크기")
	private long commonFileSize;
	
	@Column(name="COMMON_FILE_EXT")
	@Description(logicalName="공통파일확장자")
	private String commonFileExt;

	@Column(name="COMMON_FILE_WEB_URL")
	@Description(logicalName="공통파일웹주소")
	private String commonFileWebUrl;
	
	@Column(name="COMMON_FILE_REAL_PATH")
	@Description(logicalName="공통파일물리경로")
	private String commonFileRealPath;
	
	@Column(name="REGISTER_DATE")
	@Description(logicalName="공통파일등록일")
	private String registerDate;
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="공통파일등록자")
	private String registerId;

	public Integer getCommonFileSeq() {
		return commonFileSeq;
	}

	public void setCommonFileSeq(Integer commonFileSeq) {
		this.commonFileSeq = commonFileSeq;
	}

	public Integer getCommonFileRegisterBbsSeq() {
		return commonFileRegisterBbsSeq;
	}

	public void setCommonFileRegisterBbsSeq(Integer commonFileRegisterBbsSeq) {
		this.commonFileRegisterBbsSeq = commonFileRegisterBbsSeq;
	}

	public String getCommonFileRegisterBbs() {
		return commonFileRegisterBbs;
	}

	public void setCommonFileRegisterBbs(String commonFileRegisterBbs) {
		this.commonFileRegisterBbs = commonFileRegisterBbs;
	}

	public String getCommonFileOrgName() {
		return commonFileOrgName;
	}

	public void setCommonFileOrgName(String commonFileOrgName) {
		this.commonFileOrgName = commonFileOrgName;
	}

	public String getCommonFileCopyName() {
		return commonFileCopyName;
	}

	public void setCommonFileCopyName(String commonFileCopyName) {
		this.commonFileCopyName = commonFileCopyName;
	}

	public long getCommonFileSize() {
		return commonFileSize;
	}

	public void setCommonFileSize(long commonFileSize) {
		this.commonFileSize = commonFileSize;
	}

	public String getCommonFileExt() {
		return commonFileExt;
	}

	public void setCommonFileExt(String commonFileExt) {
		this.commonFileExt = commonFileExt;
	}

	public String getCommonFileWebUrl() {
		return commonFileWebUrl;
	}

	public void setCommonFileWebUrl(String commonFileWebUrl) {
		this.commonFileWebUrl = commonFileWebUrl;
	}

	public String getCommonFileRealPath() {
		return commonFileRealPath;
	}

	public void setCommonFileRealPath(String commonFileRealPath) {
		this.commonFileRealPath = commonFileRealPath;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
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
		return "CommonFileInfo [commonFileSeq=" + commonFileSeq + ", commonFileRegisterBbsSeq="
				+ commonFileRegisterBbsSeq + ", commonFileRegisterBbs=" + commonFileRegisterBbs + ", commonFileOrgName="
				+ commonFileOrgName + ", commonFileCopyName=" + commonFileCopyName + ", commonFileSize="
				+ commonFileSize + ", commonFileExt=" + commonFileExt + ", commonFileWebUrl=" + commonFileWebUrl
				+ ", commonFileRealPath=" + commonFileRealPath + ", registerDate=" + registerDate + ", registerId="
				+ registerId + "]";
	}
	
}
