package com.happyrecipek.web.member.contents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.member.controller.blog.entities.Blog;

public interface ContentRepository extends JpaRepository<Blog, Integer>{

}
