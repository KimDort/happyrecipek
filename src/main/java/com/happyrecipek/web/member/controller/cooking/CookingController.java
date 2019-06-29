package com.happyrecipek.web.member.controller.cooking;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happyrecipek.web.admin.cookingclass.entities.ClassBase;
import com.happyrecipek.web.admin.cookingclass.repositories.ClassRepository;

@Controller
public class CookingController {
	
	private static final Logger log = LogManager.getLogger(CookingController.class);
	
	@Autowired
	private ClassRepository classRepository;

	@RequestMapping("/cooking/list")
	public String listPage(Device device, Model model) {
		String returnPage = "";

		/**
		 * Selection Class List Repository
		 */
		List<ClassBase> resultList = classRepository.findAll();

		model.addAttribute("classList", resultList);

		if (device.isMobile()) {
			returnPage = "web/mobile/cooking/list";
		} else if (device.isTablet()) {
			returnPage = "web/mobile/cooking/list";
		} else if (device.isNormal()) {
			returnPage = "web/pc/cooking/list";
		}

		return returnPage;
	}

	/**
	 * @author KYJ
	 * @since 2019-01-03
	 * @param Device
	 * @return String Cooking Class Detail Page
	 */
	@RequestMapping("/cooking/detail")
	public @ResponseBody ClassBase classDetailPage(Integer classSeq) {
		ClassBase getDetail = new ClassBase();
		getDetail = classRepository.findByClassSeq(classSeq);
		return getDetail;
	}
	
	/**
	 * @author KYJ
	 * @since 2019-05-25
	 * @param Device
	 * @return String Cooking Class Detail Page
	 */
	@RequestMapping("/cooking/joinPage")
	public String classJoinPage(Device device, Model model, @RequestParam("classNum")int classNum) {
		String returnPage = "";
		/**
		 * Selection Class List Repository
		 */
		ClassBase result = classRepository.findByClassSeq(classNum);

		model.addAttribute("classInfo", result);

		if (device.isMobile()) {
			returnPage = "web/mobile/cooking/join";
		} else if (device.isTablet()) {
			returnPage = "web/mobile/cooking/join";
		} else if (device.isNormal()) {
			returnPage = "web/pc/cooking/join";
		}

		return returnPage;
	}
	
	/**
	 * @author KYJ
	 * @since 2019-05-27
	 * @param Device
	 * @return String Cooking Class Detail Page
	 */
	@RequestMapping("/cooking/classJoin")
	public String classJoin() {
		return "";
	}
}
