package com.happyrecipek.web.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.happyrecipek.web.admin.repositories.ClassRepository;
import com.happyrecipek.web.admin.repositories.entities.ClassManage;
import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;
import com.happyrecipek.web.com.system.files.ckeditor.repositories.CommonFileRepository;
import com.happyrecipek.web.com.system.utils.FileUtil;

/**
 * @author KYJ
 * @since 2019-01-03
 * Cooking Class Management Controller
 * */
@Controller
public class ClassManagementController {
	private static final Logger log = LogManager.getLogger(ClassManagementController.class);

	@Autowired
	private ClassRepository classRepository; 
	
	@Autowired
	private CommonFileRepository commonFileRepository;
	
	/**
	 * @author KYJ
	 * @since 2019-01-03
	 * @param Device
	 * @return String
	 * Cooking Class List Page
	 * */
	@RequestMapping("/admin/class/classListPage")
	public String classListPage(Device device, Model model) {
		String returnPage = "";
		
		/**
		 * Selection Class List Repository
		 * */
		List<ClassManage> resultList = classRepository.findAll();
		System.out.println(resultList.toString());
		
		model.addAttribute("classList", resultList);
		
		if (device.isMobile()) {
			returnPage = "web/pc/admin/class/list";
			//returnPage = "web/mobile/admin/class/addClass";
		} else if (device.isTablet()) {
			returnPage = "";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/class/list";
		}
		
		return returnPage;
	}
	
	
	/**
	 * @author KYJ
	 * @since 2019-01-03
	 * @param Device
	 * @return String
	 * Cooking Class Add Page Method
	 * */
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
	
	/**
	 * @author KYJ
	 * @since 2019-01-03
	 * @param Device
	 * @return String
	 * Cooking Class Add Process Method
	 * */
	@RequestMapping("/admin/class/addClassProc")
	public String classAddProc(@ModelAttribute("classManage")ClassManage classManage, MultipartHttpServletRequest request) throws Exception{
		/**
		 *Step 1 : Create Real File In Server 
		 **/
		Set<String> keys = request.getFileMap().keySet();
		List<CommonFileInfo> fileInfos = null;
		
		for(String key : keys) {
			MultipartFile getFile = request.getFileMap().get(key);
			if(!getFile.isEmpty() && getFile != null) {
				fileInfos = new ArrayList<CommonFileInfo>();
				fileInfos = FileUtil.createFile(request);
				
			}
		}
		
		/**
		 *Step 2 : Insert File Info 
		 **/
		CommonFileInfo getSavedFileInfo=null;
		if(fileInfos != null && !fileInfos.isEmpty()) {
			for(CommonFileInfo fileInfo : fileInfos) {
				getSavedFileInfo = new CommonFileInfo();
				getSavedFileInfo = commonFileRepository.save(fileInfo);
			}
		}
		
		/**
		 *Step 1 : Insert BBS Data 
		 **/
		classManage.setFileInfo(getSavedFileInfo);
		classRepository.save(classManage);
		
		
		return "redirect:/admin/class/classListPage";
	}
}
