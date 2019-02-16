package com.happyrecipek.web.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happyrecipek.web.admin.repositories.ClassRepository;
import com.happyrecipek.web.admin.repositories.entities.ClassBase;

@Controller
public class MainController {
	
	private static final Logger log = LogManager.getLogger(MainController.class);
	
	@Autowired
	private ClassRepository classRepository;
	
	@RequestMapping(value="/")
	public String mainPage(Device device, Model model) {
		String setReturn="";
		List<ClassBase> classList = new ArrayList<>();
		classList = classRepository.findAllActiveClassBasesNative();
		
		model.addAttribute("classList", classList);
		
		if(device.isMobile()) {
			setReturn = "web/mobile/index";
			//setReturn="web/pc/index";
		}else if(device.isTablet()) {
			setReturn = "";
		}else if(device.isNormal()) {
			setReturn="web/pc/index";
		}
		
		return setReturn;
	}
	
	@RequestMapping(value="/test")
	public @ResponseBody List<ClassBase> testMethod(){
		List<ClassBase> classList = new ArrayList<>();
		classList = classRepository.findAllActiveClassBasesNative();
		return classList;
	}
}
