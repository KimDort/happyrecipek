package com.happyrecipek.web.com.system.files.ckeditor.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="common_file_info")
public class CommonFileInfo {

	@Id
	@Column(name="COMMON_FILE_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="공통파일순번")
	private Integer commonFileSeq;
	
	@Column(name="COMMON_FILE_LOCATION")
	@Description(logicalName="공통파일호출경위")
	private String commonFileLocation;
	
	@Column(name="COMMON_FILE_ORG_NAME")
	@Description(logicalName="공통파일원본이름")
	private String commonFileOrgName;
	
	@Column(name="COMMON_FILE_COPY_NAME")
	@Description(logicalName="공통파일복사본이름")
	private String commonFileCopyName;
	
	@Column(name="COMMON_FILE_THUMB_NAME")
	@Description(logicalName="공통파일썸네일이름")
	private String commonFileThumbName;
	
	@Column(name="COMMON_FILE_RESIZE_NAME")
	@Description(logicalName="공통파일리사이즈이름")
	private String commonFileResizeName;
	
	@Column(name="COMMON_FILE_SIZE")
	@Description(logicalName="공통파일크기")
	private long commonFileSize;
	
	@Column(name="COMMON_FILE_EXT")
	@Description(logicalName="공통파일확장자")
	private String commonFileExt;

	@Column(name="COMMON_FILE_WEB_URL")
	@Description(logicalName="공통파일웹주소")
	private String commonFileWebUrl;
	
	@Column(name="COMMON_FILE_THUMB_WEB_URL")
	@Description(logicalName="공통파일썸네일웹주소")
	private String commonFileThumbWebUrl;
	
	@Column(name="COMMON_FILE_RESIZE_WEB_URL")
	@Description(logicalName="공통파일리사이즈웹주소")
	private String commonFileResizeWebUrl;
	
	@Column(name="COMMON_FILE_REAL_PATH")
	@Description(logicalName="공통파일물리경로")
	private String commonFileRealPath;

	@Column(name="REGISTER_DATE")
	@Description(logicalName="공통파일등록일")
	@CreationTimestamp
	private Timestamp registerDate;
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="공통파일등록자")
	private String registerId;

	public Integer getCommonFileSeq() {
		return commonFileSeq;
	}

	public void setCommonFileSeq(Integer commonFileSeq) {
		this.commonFileSeq = commonFileSeq;
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

	public String getCommonFileThumbName() {
		return commonFileThumbName;
	}

	public void setCommonFileThumbName(String commonFileThumbName) {
		this.commonFileThumbName = commonFileThumbName;
	}

	public String getCommonFileResizeName() {
		return commonFileResizeName;
	}

	public void setCommonFileResizeName(String commonFileResizeName) {
		this.commonFileResizeName = commonFileResizeName;
	}
	
	public String getCommonFileThumbWebUrl() {
		return commonFileThumbWebUrl;
	}

	public void setCommonFileThumbWebUrl(String commonFileThumbWebUrl) {
		this.commonFileThumbWebUrl = commonFileThumbWebUrl;
	}

	public String getCommonFileResizeWebUrl() {
		return commonFileResizeWebUrl;
	}

	public void setCommonFileResizeWebUrl(String commonFileResizeWebUrl) {
		this.commonFileResizeWebUrl = commonFileResizeWebUrl;
	}

	public String getCommonFileLocation() {
		return commonFileLocation;
	}

	public void setCommonFileLocation(String commonFileLocation) {
		this.commonFileLocation = commonFileLocation;
	}

	@Override
	public String toString() {
		return "CommonFileInfo [commonFileSeq=" + commonFileSeq + ", commonFileLocation=" + commonFileLocation
				+ ", commonFileOrgName=" + commonFileOrgName + ", commonFileCopyName=" + commonFileCopyName
				+ ", commonFileThumbName=" + commonFileThumbName + ", commonFileResizeName=" + commonFileResizeName
				+ ", commonFileSize=" + commonFileSize + ", commonFileExt=" + commonFileExt + ", commonFileWebUrl="
				+ commonFileWebUrl + ", commonFileThumbWebUrl=" + commonFileThumbWebUrl + ", commonFileResizeWebUrl="
				+ commonFileResizeWebUrl + ", commonFileRealPath=" + commonFileRealPath + ", registerDate="
				+ registerDate + ", registerId=" + registerId + "]";
	}

}
