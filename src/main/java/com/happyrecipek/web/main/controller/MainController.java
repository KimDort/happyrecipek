package com.happyrecipek.web.main.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.admin.repositories.ClassRepository;

@Controller
public class MainController {
	
	private static final Logger log = LogManager.getLogger(MainController.class);
	
	@Autowired
	private ClassRepository classRepository;
	
	@RequestMapping(value="/")
	public String mainPage(Device device, Model model) {
		String setReturn="";
		
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
}
