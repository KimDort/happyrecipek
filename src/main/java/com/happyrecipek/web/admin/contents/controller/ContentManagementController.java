package com.happyrecipek.web.admin.contents.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.happyrecipek.web.com.commonCode.entities.CommonHighCode;
import com.happyrecipek.web.com.commonCode.repositories.CommonCodeRepository;
import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;
import com.happyrecipek.web.com.system.files.ckeditor.repositories.CommonFileRepository;
import com.happyrecipek.web.com.system.utils.FileUtil;
import com.happyrecipek.web.member.contents.entities.Content;

@Controller
public class ContentManagementController {
	
	//파일 처리
	@Autowired
	private CommonFileRepository commonFileRepository;
	
	@Autowired
	private CommonCodeRepository commonCodeRepository;
	
	@RequestMapping("/admin/content/addContentPage")
	public String addContentPage(Device device, Locale locale, Model model) {
		String returnPage="";
		String lang = locale.getLanguage().toUpperCase();
		CommonHighCode languageCode = new CommonHighCode();
		
		if(lang.equals("KO")) {
			languageCode = commonCodeRepository.findByCommonHighCode("COMMLOC001");
		}else if(lang.equals("JA")) {
			languageCode = commonCodeRepository.findByCommonHighCode("COMMLOC002");
		}else if(lang.equals("EN")) {
			languageCode = commonCodeRepository.findByCommonHighCode("COMMLOC003");
		}
		
		model.addAttribute("languageCode", languageCode);
		
		if (device.isMobile()) {
			returnPage = "web/pc/admin/content/addContent";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/content/addContent";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/content/addContent";
		}
		return returnPage;
	}
	
	@RequestMapping("/admin/content/addContentProc")
	public String addContentProc(@ModelAttribute("content")Content content, MultipartHttpServletRequest request)throws Exception {
		//임시
		String returnPage="redirect:/admin/content/addContentPage";
		
		/**
		 * Step 1 : Create Real File In Server
		 **/
		FileUtil fileUtil = new FileUtil();
		Set<String> keys = request.getFileMap().keySet();
		List<CommonFileInfo> fileInfos = null;
		
		for (String key : keys) {
			MultipartFile getFile = request.getFileMap().get(key);
			if (!getFile.isEmpty() && getFile != null) {
				fileInfos = new ArrayList<CommonFileInfo>();
				fileInfos = fileUtil.createFile(request);

			}
		}
		
		/**
		 * Step 2 : Insert File Info
		 **/

		CommonFileInfo getSavedFileInfo = null;
		if (fileInfos != null && !fileInfos.isEmpty()) {
			for (CommonFileInfo fileInfo : fileInfos) {
				getSavedFileInfo = new CommonFileInfo();
				fileInfo.setCommonFileLocation("CONTENT_");
				getSavedFileInfo = commonFileRepository.save(fileInfo);
			}
		}
		return returnPage;
	}
}
