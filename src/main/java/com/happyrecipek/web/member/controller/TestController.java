package com.happyrecipek.web.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.member.repositories.MemberInfoRepository;

@Controller
public class TestController {

	@Autowired
	private MemberInfoRepository memberInfoRepository;

	@RequestMapping(value="/test/test.do")
	public void testJpa() {
		System.out.println("test repository jpa");
		memberInfoRepository.findAll();
	}
}
