package com.happyrecipek.web.com.system.menu.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;
import com.happyrecipek.web.com.system.security.repositories.entities.AuthorityRole;

import lombok.Data;

@Entity
@Table(name="PROGRAM", schema="happyrecipek")
@Data
public class Program {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Description(logicalName="프로그램순번")
	private Integer program_seq;
	
	@Column
	@Description(logicalName="프로그램고유코드")
	private String program_code;
	
	@Column
	@Description(logicalName="프로그램이름")
	private String program_name;
	
	@Column
	@Description(logicalName="프로그램url")
	private String program_url;
	
	@Column
	@Description(logicalName="프로그램등록일자")
	private String register_date;
	
	@Column
	@Description(logicalName="프로그램수정일자")
	private String update_date;
	
	@Column
	@Description(logicalName="프로그램등록자")
	private String register_id;
	
	@Column
	@Description(logicalName="프로그램수정자")
	private String update_id;
	
	@ManyToOne
	@JoinColumn(name="authority_role_seq")
	@Description(logicalName="권한")
	private AuthorityRole authority_Role;
}
