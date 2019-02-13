package com.happyrecipek.web.com.system.files.ckeditor.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CommonController {
	@RequestMapping("/ckeditor/imageUpload")
	public Map<String, Object> imageUploadProcess(HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam MultipartFile upload
			, Device device
			)throws Exception{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		GregorianCalendar gc = new GregorianCalendar();
		String year = String.valueOf(gc.get(Calendar.YEAR));
		String month = String.valueOf(gc.get(Calendar.MONTH)+1);
		String day = String.valueOf(gc.get(Calendar.DATE));
		String currentDate = String.valueOf(System.currentTimeMillis());
		
		/**
		 * Upload File is not null
		 * */
		if(upload != null) {
			String getRealPath = request.getSession().getServletContext().getRealPath("/");
			String uploadPath = getRealPath+"/ckeditor/"+year+"/"+month+"/"+day+"/";
			String orgFileName = upload.getOriginalFilename();
			String orgFileExt = orgFileName.substring(orgFileName.indexOf(".") - 1);
			String copyFileName = currentDate+"."+orgFileExt;
			String contextFilePath = request.getSession().getServletContext().getContextPath();

			/**
			 * Create Driectory
			 * */
			File getDirectory = new File(uploadPath);
			if(!getDirectory.exists()) {
				getDirectory.mkdirs();
			}
			
			String callback =request.getParameter("CKEditorFuncNum");
			File tempFile = File.createTempFile(currentDate,orgFileExt, getDirectory);
			upload.transferTo(tempFile);
			
			/**
			 * Upload Done and Call Back Script String
			 * */
			resultMap.put("uploaded", 1);
			resultMap.put("fileName", tempFile.getName());
			resultMap.put("url", "/ckeditor/"+year+"/"+month+"/"+day+"/"+tempFile.getName());
			
		}
		
		return resultMap;
	}
}
