package com.happyrecipek.web.com.security.repositories.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Data;

@Entity
@Table(name="AUTHORITY_MANAGE", schema="happyrecipek")
@Data
public class AuthorityManage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Description(logicalName="권한순번")
	private int authority_seq;
	@Column
	@Description(logicalName="권한고유코드")
	private String authority_code;
	@Column
	@Description(logicalName="권한이름")
	private String authority_name;
	@Column
	@Description(logicalName="권한레벨")
	private String authority_level;
	@Column
	@Description(logicalName="권한사용여부")
	private String authority_use_yn;
	@Column
	@Description(logicalName="등록일")
	private String register_date;
	@Column
	@Description(logicalName="수정일")
	private String update_date;
	@Column
	@Description(logicalName="등록자")
	private String register_id;
	@Column
	@Description(logicalName="수정자")
	private String update_id;
	
}
