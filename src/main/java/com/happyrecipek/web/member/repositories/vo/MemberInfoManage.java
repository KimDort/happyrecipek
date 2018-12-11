package com.happyrecipek.web.member.repositories.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Data;

@Entity
@Table(name="MEMBER_INFO_MANAGE", schema="happyrecipek")
@Data
public class MemberInfoManage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int member_seq;
	
	@Description(logicalName="체크박스")
	private String member_check_yn;
	@Description(logicalName="회원암호")
	@NotEmpty(message="Your Password Must Have At Least 8 Characters")
	private String member_password;
	@NotEmpty(message="Your Id Must Have")
	@Description(logicalName="회원아이디")
	private String member_id;
	@Description(logicalName="회원성명")
	private String member_name;
	@Description(logicalName="휴대폰첫자리")
	private String member_phone_front;
	@Description(logicalName="휴대폰중간자리")
	private String member_phone_middle;
	@Description(logicalName="휴대폰끝자리")
	private String member_phone_last;
	@Description(logicalName="회원국가")
	private String member_locale;
	@Description(logicalName="이메일주소")
	private String member_email_address;
	@Description(logicalName="이메일도메인")
	private String member_email_domain;
	@Description(logicalName="탈퇴요청")
	private String member_exit_req_yn;
	@Description(logicalName="탈퇴요청처리")
	private String member_exit_yn;
	@Description(logicalName="회원인증여부")
	private String member_auth_yn;
	@Description(logicalName="등록일")
	private String register_date;
	@Description(logicalName="수정일")
	private String update_date;
}
