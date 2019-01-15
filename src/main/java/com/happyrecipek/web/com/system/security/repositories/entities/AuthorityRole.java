package com.happyrecipek.web.com.system.security.repositories.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;
import com.happyrecipek.web.member.repositories.entities.Member;

import lombok.Data;

@Entity
@Table(name="AUTHORITY_ROLES", schema="happyrecipek")
public class AuthorityRole {
	@Id
	@Description(logicalName="권한순번")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer authority_role_seq;
	
	@Column
	@Description(logicalName="권한고유코드")
	private String authority_role_code;
	
	@Column
	@Description(logicalName="권한이름")
	private String authority_role_name;
	
	@Column
	@Description(logicalName="권한사용여부")
	private String authority_role_useYn;
	
	@Column
	@Description(logicalName="권한등록일")
	private String register_date;
	
	@Column
	@Description(logicalName="권한변경일")
	private String update_date;
	
	@OneToMany
	private List<ProgramRole> programRoles;

	@ManyToMany(mappedBy="authorityRole")
	private List<Member> members;
	
	
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Integer getAuthority_role_seq() {
		return authority_role_seq;
	}

	public void setAuthority_role_seq(Integer authority_role_seq) {
		this.authority_role_seq = authority_role_seq;
	}

	public String getAuthority_role_code() {
		return authority_role_code;
	}

	public void setAuthority_role_code(String authority_role_code) {
		this.authority_role_code = authority_role_code;
	}

	public String getAuthority_role_name() {
		return authority_role_name;
	}

	public void setAuthority_role_name(String authority_role_name) {
		this.authority_role_name = authority_role_name;
	}

	public String getAuthority_role_useYn() {
		return authority_role_useYn;
	}

	public void setAuthority_role_useYn(String authority_role_useYn) {
		this.authority_role_useYn = authority_role_useYn;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public List<ProgramRole> getProgramRoles() {
		return programRoles;
	}

	public void setProgramRoles(List<ProgramRole> programRoles) {
		this.programRoles = programRoles;
	}
	
}
