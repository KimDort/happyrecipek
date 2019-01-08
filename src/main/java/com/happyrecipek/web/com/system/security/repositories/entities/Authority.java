package com.happyrecipek.web.com.system.security.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;
import com.happyrecipek.web.member.repositories.entities.Member;

import lombok.Data;

@Entity
@Table(name="AUTHORITY", schema="happyrecipek")
@Data
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Description(logicalName="권한매핑순번")
	private Integer authority_seq;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="member_seq")
	@Description(logicalName="유저정보")
	private Member member;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="authority_role_seq")
	@Description(logicalName="권한정보")
	private AuthorityRole roles;
}
