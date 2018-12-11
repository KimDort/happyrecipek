package com.happyrecipek.web.com.security.repositories.vo.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Data;

@Embeddable
@Data
public class AuthorityRoleGroupKey implements Serializable{

	@Column
	@Description(logicalName="권한롤그룹순번")
	private int authority_role_group_seq;
	
	@Column
	@Description(logicalName="권한롤그룹고유코드")
	private String authority_role_group_code;
}
