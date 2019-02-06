package com.happyrecipek.web.com.system.files.ckeditor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;

public interface CommonFileRepository extends JpaRepository<CommonFileInfo, Integer>{

}
