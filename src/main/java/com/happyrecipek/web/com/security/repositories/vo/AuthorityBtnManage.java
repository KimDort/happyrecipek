package com.happyrecipek.web.com.security.repositories.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Data;

@Entity
@Table(name="AUTHORITY_BTN_MANAGE", schema="happyrecipek")
@Data
public class AuthorityBtnManage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Description(logicalName="권한버튼순번")
	private int authority_btn_seq;
	
	@Column
	@Description(logicalName="권한버튼고유코드")
	private String authority_btn_code;
	@Column
	@Description(logicalName="권한버튼이름")
	private String authority_btn_name;
	@Column
	@Description(logicalName="권한버튼쓰기")
	private String authority_btn_C;
	@Column
	@Description(logicalName="권한버튼읽기")
	private String authority_btn_R;
	@Column
	@Description(logicalName="권한버튼수정")
	private String authority_btn_U;
	@Column
	@Description(logicalName="권한버튼삭제")
	private String authority_btn_D;
	@Column
	@Description(logicalName="권한버튼사용여부")
	private String authority_btn_use_yn;
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
		@JoinColumn(name="authority_role_seq", referencedColumnName="authority_role_seq")
	})
	private AuthorityRoleManage authorityRoleManage;
}
