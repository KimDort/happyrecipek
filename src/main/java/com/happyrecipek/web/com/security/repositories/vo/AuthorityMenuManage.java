package com.happyrecipek.web.com.security.repositories.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Data;

@Entity
@Table(name="AUTHORITY_MENU_MANAGE", schema="happyrecipek")
@Data
public class AuthorityMenuManage {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Description(logicalName="권한메뉴순번")
	private int authority_menu_seq;
	
	@Column
	@Description(logicalName="권한상위메뉴코드")
	private String authority_upper_code;
	@Column
	@Description(logicalName="권한하위메뉴코드")
	private String authority_lower_code;
	@Column
	@Description(logicalName="권한메뉴이름")
	private String authority_menu_name;
	@Column
	@Description(logicalName="권한메뉴사용여부")
	private String authority_menu_use_yn;
	@Column
	@Description(logicalName="등록일")
	private String registr_date;
	@Column
	@Description(logicalName="수정일")
	private String update_date;
	@Column
	@Description(logicalName="등록자")
	private String register_id;
	@Column
	@Description(logicalName="수정자")
	private String update_id;
	
	@JoinColumns({
		@JoinColumn(name="authority_role_seq", referencedColumnName="authority_role_seq")
	})
	@ManyToOne
	private AuthorityRoleManage authorityRoleManage;
	
	@MapsId("authorityGroupKey")
	@JoinColumns({
		@JoinColumn(name="authority_group_seq", referencedColumnName="authority_group_seq"),
		@JoinColumn(name="authority_group_code", referencedColumnName="authority_group_code")
	})
	@ManyToOne
	private AuthorityGroup authorityGroup;
}
