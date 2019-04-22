package com.happyrecipek.web.member.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.happyrecipek.web.com.system.annotations.Description;
import com.happyrecipek.web.com.system.security.repositories.entities.AuthorityRole;

import lombok.Data;

@Entity
@Table(name="member_info_manage")
public class Member {
	
	@Id
	@Column(name="MEMBER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberSeq;
	
	@Column(name="MEMBER_CHECK_YN")
	@Description(logicalName="체크박스")
	private String memberCheckYn;
	
	@Column(name="MEMBER_PASSWORD")
	@Description(logicalName="회원암호")
	@NotEmpty(message="Your Password Must Have At Least 8 Characters")
	private String memberPassword;
	
	@Column(name="MEMBER_EMAIL")
	@NotEmpty(message="Your Id Must Have")
	@Description(logicalName="회원아이디")
	private String memberEmail;
	
	@Column(name="MEMBER_NAME")
	@Description(logicalName="회원성명")
	private String memberName;
	
	@Column(name="MEMBER_PHONE_FRONT")
	@Description(logicalName="휴대폰첫자리")
	private String memberPhoneFront;
	
	@Column(name="MEMBER_PHONE_MIDDLE")
	@Description(logicalName="휴대폰중간자리")
	private String memberPhoneMiddle;
	
	@Column(name="MEMBER_PHONE_LAST")
	@Description(logicalName="휴대폰끝자리")
	private String memberPhoneLast;
	
	@Column(name="MEMBER_LOCALE")
	@Description(logicalName="회원국가")
	private String memberLocale;
	
	@Column(name="MEMBER_EXIT_REQ_YN")
	@Description(logicalName="탈퇴요청")
	private String memberExitReqYn;
	
	@Column(name="MEMBER_EXIT_YN")
	@Description(logicalName="탈퇴요청처리")
	private String memberExitYn;
	
	@Column(name="MEMBER_AUTH_YN")
	@Description(logicalName="회원인증여부")
	private String memberAuthYn;
	
	@Column(name="REGISTER_DATE")
	@Description(logicalName="등록일")
	private String registerDate;
	
	@Column(name="UPDATE_DATE")
	@Description(logicalName="수정일")
	private String updateDate;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
		name="AUTHORITY"
		,joinColumns= {@JoinColumn(name="member_seq", referencedColumnName="member_seq")}
		,inverseJoinColumns= {@JoinColumn(name="authority_role_seq", referencedColumnName="authority_role_seq")}
		)
	private List<AuthorityRole> authorityRole;

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberCheckYn() {
		return memberCheckYn;
	}

	public void setMemberCheckYn(String memberCheckYn) {
		this.memberCheckYn = memberCheckYn;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoneFront() {
		return memberPhoneFront;
	}

	public void setMemberPhoneFront(String memberPhoneFront) {
		this.memberPhoneFront = memberPhoneFront;
	}

	public String getMemberPhoneMiddle() {
		return memberPhoneMiddle;
	}

	public void setMemberPhoneMiddle(String memberPhoneMiddle) {
		this.memberPhoneMiddle = memberPhoneMiddle;
	}

	public String getMemberPhoneLast() {
		return memberPhoneLast;
	}

	public void setMemberPhoneLast(String memberPhoneLast) {
		this.memberPhoneLast = memberPhoneLast;
	}

	public String getMemberLocale() {
		return memberLocale;
	}

	public void setMemberLocale(String memberLocale) {
		this.memberLocale = memberLocale;
	}

	public String getMemberExitReqYn() {
		return memberExitReqYn;
	}

	public void setMemberExitReqYn(String memberExitReqYn) {
		this.memberExitReqYn = memberExitReqYn;
	}

	public String getMemberExitYn() {
		return memberExitYn;
	}

	public void setMemberExitYn(String memberExitYn) {
		this.memberExitYn = memberExitYn;
	}

	public String getMemberAuthYn() {
		return memberAuthYn;
	}

	public void setMemberAuthYn(String memberAuthYn) {
		this.memberAuthYn = memberAuthYn;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public List<AuthorityRole> getAuthorityRole() {
		return authorityRole;
	}

	public void setAuthorityRole(List<AuthorityRole> authorityRole) {
		this.authorityRole = authorityRole;
	}
	
}
