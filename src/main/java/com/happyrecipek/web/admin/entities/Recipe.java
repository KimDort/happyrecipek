package com.happyrecipek.web.admin.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="recipe")
public class Recipe {
	
	@Id
	@Column(name="RECIPE_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Description(logicalName="레시피 순번")
	private int recipeSeq;
	
	@Column(name="RECIPE_TITLE")
	@Description(logicalName="레시피 제목")
	private String recipeTitle;
	
	@Column(name="REGISTER_DATE", updatable=false)
	@Description(logicalName="등록일")
	@CreationTimestamp
	private Timestamp registerDate;
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="등록자")
	private String registerId;
}
