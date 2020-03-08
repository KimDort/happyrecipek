package com.happyrecipek.web.member.contents.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.member.contents.entities.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>{
	List<Content> findByCategoryLowCodeAndContentLocale(String lowCode, String locale);
	Page<Content> findByCategoryLowCodeAndContentLocale(String lowCode, String locale, Pageable page);
	Content findByCategoryLowCodeAndContentLocaleAndContentSeq(String lowCode, String locale, int seq);
	long countByCategoryLowCodeAndContentLocale(String lowCode, String locale);
}
