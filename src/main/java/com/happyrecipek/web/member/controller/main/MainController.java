package com.happyrecipek.web.member.controller.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.admin.cookingclass.entities.ClassBase;
import com.happyrecipek.web.admin.cookingclass.repositories.ClassRepository;

@Controller
public class MainController {

	private static final Logger log = LogManager.getLogger(MainController.class);

	@Autowired
	private ClassRepository classRepository;

	@RequestMapping(value = "/")
	public String mainPage(Device device, Model model) {
		String setReturn = "";
		List<ClassBase> classList = new ArrayList<>();
		classList = classRepository.findAllActiveClassBasesNative();

		if (device.isMobile()) {
			setReturn = "web/mobile/index";

		} else if (device.isTablet()) {
			setReturn = "web/mobile/index";
		} else if (device.isNormal()) {
			setReturn = "web/pc/index";
		}

		model.addAttribute("classList", classList);

		return setReturn;
	}
}
