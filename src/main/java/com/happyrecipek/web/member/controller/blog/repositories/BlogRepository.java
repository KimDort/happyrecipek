package com.happyrecipek.web.member.controller.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happyrecipek.web.member.controller.blog.entities.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
	Page<Blog> findAllByDisplayYnOrderByRegisterDateDesc(String displayYn, Pageable pageable);
	Blog findByBlogSeq(Integer seq);
}
