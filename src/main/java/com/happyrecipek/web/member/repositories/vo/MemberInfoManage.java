package com.happyrecipek.web.member.repositories.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.happyrecipek.web.com.annotations.Description;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class MemberInfoManage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int member_seq;
	
	@Description(logicalName="회원아이디")
	private String member_id;
	@Description(logicalName="체크박스")
	private String member_check_yn;
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
	private String regist_date;
	@Description(logicalName="수정일")
	private String update_date;
}
