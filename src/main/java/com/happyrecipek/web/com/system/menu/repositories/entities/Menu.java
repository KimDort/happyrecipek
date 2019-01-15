package com.happyrecipek.web.com.system.menu.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;

import lombok.Data;

@Entity
@Table(name="MENU", schema="happyrecipek")
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Description(logicalName="메뉴순번")
	private Integer menu_seq;
	
	@Column
	@Description(logicalName="상위메뉴번호")
	private String menu_upper_code;
	
	@Column
	@Description(logicalName="하위메뉴번호")
	private String menu_lower_code;
	
	@Column
	@Description(logicalName="메뉴이름")
	private String menu_name;
	
	@Column
	@Description(logicalName="메뉴사용여부")
	private String menu_use_yn;
	
	@Column
	@Description(logicalName="메뉴등록일자")
	private String register_date;
	
	@Column
	@Description(logicalName="메뉴수정일자")
	private String update_date;
	
	@Column
	@Description(logicalName="메뉴등록자")
	private String register_id;
	
	@Column
	@Description(logicalName="메뉴수정자")
	private String update_id;
	
	@OneToOne
	@JoinColumn(name="program_seq")
	@Description(logicalName="프로그램")
	private Program program;
}
