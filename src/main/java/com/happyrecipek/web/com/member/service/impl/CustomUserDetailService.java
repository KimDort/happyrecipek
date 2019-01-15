package com.happyrecipek.web.com.member.service.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.happyrecipek.web.member.repositories.MemberRepository;
import com.happyrecipek.web.member.repositories.entities.Member;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByMemberEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
				
		return new org.springframework.security.core.userdetails.User(member.getMemberEmail(), member.getMemberPassword(), getAuthorities(member));
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(Member member){
		String[] memberRoles = member.getAuthorityRole().stream().map((AuthorityRole) -> AuthorityRole.getAuthority_role_code()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(memberRoles);
		return authorities;
	}

}
