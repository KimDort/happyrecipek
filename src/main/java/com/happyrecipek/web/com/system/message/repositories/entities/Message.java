package com.happyrecipek.web.com.system.message.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.happyrecipek.web.com.system.annotations.Description;

import lombok.Data;

@Entity
@Table(name="messages")
@Data
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Description(logicalName="메세지순번")
	private Integer message_seq;
	
	@Column
	@Description(logicalName="메세지고유코드")
	private String message_code;
	
	@Column
	@Description(logicalName="메세지타입")
	private String message_type;
	
	@Column
	@Description(logicalName="메세지언어")
	private String message_language;
	
	@Column
	@Description(logicalName="메세지내용")
	private String message_content;
}
