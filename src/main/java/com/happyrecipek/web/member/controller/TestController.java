package com.happyrecipek.web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.member.repositories.MemberRepository;
import com.happyrecipek.web.member.repositories.entities.Member;

@Controller
public class TestController {

	@Autowired
	private MemberRepository memberInfoRepository;
	

	@RequestMapping(value="/test/test.do")
	public List<Member> testJpa() {
		System.out.println("test repository jpa");
		return memberInfoRepository.findAll();
	}
	
}
