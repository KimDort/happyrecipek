package com.happyrecipek.web.com.security.repositories.vo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.annotations.Description;
import com.happyrecipek.web.com.security.repositories.vo.keys.AuthorityGroupKey;

import lombok.Data;

@Entity
@Table(name="AUTHORITY_GROUP", schema="happyrecipek")
@Data
public class AuthorityGroup {

	@EmbeddedId
	private AuthorityGroupKey authorityGroupKey;
	
	@Column
	@Description(logicalName="권한그룹이름")
	private String authority_group_name;
	@Column
	@Description(logicalName="권한그룹사용여부")
	private String authority_group_use_yn;
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
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="authority_seq", referencedColumnName="authority_seq")
	})
	private AuthorityManage authorityManage;
}
