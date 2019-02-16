package com.happyrecipek.web.com.system.files.ckeditor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;
import com.happyrecipek.web.com.system.files.ckeditor.repositories.CommonFileRepository;
import com.happyrecipek.web.com.system.utils.FileUtil;

@RestController
public class CommonController {
	@Autowired
	private CommonFileRepository commonFileRepository;
	
	@RequestMapping("/ckeditor/imageUpload")
	public Map<String, Object> imageUploadProcess(HttpServletResponse response
			, MultipartHttpServletRequest request
			, Device device
			)throws Exception{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		/**
		 * Create File
		 * */
		List<CommonFileInfo> getFileInfos = new ArrayList<CommonFileInfo>();
		getFileInfos = FileUtil.createFile(request);
		
		/**
		 * Insert DB File Info
		 * */
		for(int i=0; i < getFileInfos.size(); i++) {
			getFileInfos.get(i).setCommonFileLocation("CKEDITOR");
		}
		commonFileRepository.saveAll(getFileInfos);
		
		for(CommonFileInfo fileInfo : getFileInfos) {
			resultMap.put("uploaded", 1);
			resultMap.put("fileName", fileInfo.getCommonFileResizeName());
			resultMap.put("url", fileInfo.getCommonFileResizeWebUrl()+fileInfo.getCommonFileResizeName());
		}
		
		return resultMap;
	}
}
