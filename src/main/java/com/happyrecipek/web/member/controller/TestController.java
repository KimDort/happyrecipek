package com.happyrecipek.web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happyrecipek.web.com.security.repositories.AuthorityGroupRepository;
import com.happyrecipek.web.com.security.repositories.AuthorityManageRepository;
import com.happyrecipek.web.com.security.repositories.vo.AuthorityGroup;
import com.happyrecipek.web.com.security.repositories.vo.AuthorityManage;
import com.happyrecipek.web.member.repositories.MemberInfoRepository;
import com.happyrecipek.web.member.repositories.vo.MemberInfoManage;

@Controller
public class TestController {

	@Autowired
	private MemberInfoRepository memberInfoRepository;
	
	@Autowired
	private AuthorityManageRepository authorityManageRepository;
	
	@Autowired
	private AuthorityGroupRepository authorityGroupRepository;

	@RequestMapping(value="/test/test.do")
	public List<MemberInfoManage> testJpa() {
		System.out.println("test repository jpa");
		return memberInfoRepository.findAll();
	}
	
	@RequestMapping(value="/test/saveTest.do", method=RequestMethod.POST)
	public @ResponseBody AuthorityManage testSaveJpa(@RequestBody AuthorityManage authorityManage){
		AuthorityManage manage = authorityManageRepository.save(authorityManage);
		return manage;
	}
	
	@RequestMapping(value="/test/testGroupSave.do", method=RequestMethod.POST)
	public @ResponseBody AuthorityGroup testGroupSaveJpa(@RequestBody AuthorityGroup authorityGroup) {
		return authorityGroupRepository.save(authorityGroup);
	}
	
	@RequestMapping(value="/test/testGroupAllList.do", method=RequestMethod.POST)
	public @ResponseBody List<AuthorityGroup> testGroupAllListJpa() {
		return authorityGroupRepository.findAll();
	}
	
	@RequestMapping(value="/test/saveList.do", method=RequestMethod.POST)
	public @ResponseBody List<AuthorityManage> testSaveList() {
		return authorityManageRepository.findAll();
	}
}
