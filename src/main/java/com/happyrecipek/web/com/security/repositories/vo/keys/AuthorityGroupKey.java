package com.happyrecipek.web.com.security.repositories.vo.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Data;

@Embeddable
@Data
public class AuthorityGroupKey implements Serializable{
	@Column
	@Description(logicalName="권한그룹이름")
	private int authority_group_seq;
	@Column
	@Description(logicalName="권한그룹고유코드")
	private String authority_group_code;
}
