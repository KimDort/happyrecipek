package com.happyrecipek.web.com.system.security.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;
import com.happyrecipek.web.com.system.menu.repositories.entities.Program;

import lombok.Data;

@Entity
@Table(name="PROGRAM_ROLE")
@Data
public class ProgramRole {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Description(logicalName="프로그램권한순번")
	private Integer program_role_seq;
	
	@ManyToOne
	@JoinColumn(name="authority_role_seq")
	private AuthorityRole role;
	
	@ManyToOne
	@JoinColumn(name="program_seq")
	private Program program;
}
