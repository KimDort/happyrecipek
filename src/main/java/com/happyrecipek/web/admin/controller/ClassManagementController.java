package com.happyrecipek.web.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.happyrecipek.web.admin.repositories.ClassRepository;
import com.happyrecipek.web.admin.repositories.entities.ClassManage;
import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;
import com.happyrecipek.web.com.system.utils.FileUtil;

@Controller
public class ClassManagementController {
	private static final Logger log = LogManager.getLogger(ClassManagementController.class);

	@Autowired
	private ClassRepository classRepository; 
	
	@RequestMapping("/admin/class/addClassPage")
	public String classAddPage(Device device) {
		String returnPage = "";

		if (device.isMobile()) {
			returnPage = "web/pc/admin/class/addClass";
			//returnPage = "web/mobile/admin/class/addClass";
		} else if (device.isTablet()) {
			returnPage = "";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/class/addClass";
		}

		return returnPage;
	}
	
	@RequestMapping("/admin/class/addClassProc")
	public String classAddProc(@ModelAttribute("classManage")ClassManage classManage, MultipartHttpServletRequest request) throws Exception{
		/**
		 *Step 1 : Insert BBS Data 
		 **/
		ClassManage newClassInfo = new ClassManage();
		newClassInfo = classRepository.save(classManage);
		System.out.println(newClassInfo.toString());
		
		/**
		 *Step 2 : Create Real File In Server 
		 **/
		List<CommonFileInfo> fileInfos = new ArrayList<CommonFileInfo>();
		fileInfos = FileUtil.createFile("class", newClassInfo.getClassSeq(), request);
		
		/**
		 *Step 3 : Insert File Info 
		 **/
		
		return "redirect:/admin/class/addClassPage";
	}
}
