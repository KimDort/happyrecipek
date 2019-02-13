package com.happyrecipek.web.com.system.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;

/**
 *@author KYJ
 *@since 2019-02-03
 * Common File Utils
 **/
public final class FileUtil {
	
	/**
	 *@author KYJ
	 *@since 2019-02-03
	 *@param  String bbsName, Integer bbsSeq, MultipartHttpServletRequest
	 *@return List
	 * Create File in Real Path
	 **/
	public static List<CommonFileInfo> createFile(MultipartHttpServletRequest request)throws Exception {
		List<CommonFileInfo> fileInfos = new ArrayList<>();

		Set<String> getKeys = request.getFileMap().keySet();
		MultipartFile getFiles = null;
		
		for(String key : getKeys) {
			getFiles = request.getFileMap().get(key);
			if(!getFiles.isEmpty() && getFiles != null) {
				CommonFileInfo fileInfo = new CommonFileInfo();
				String uploadPath = getRealPath(request)+"/image/"+DateUtil.getYear()+"/"+DateUtil.getMonth()+"/"+DateUtil.getDay()+"/";
				String fileOrgName = getFiles.getOriginalFilename();
				String fileExt = fileOrgName.substring(fileOrgName.lastIndexOf(".") + 1);
				String copyFileName = DateUtil.getCurrentDate()+"."+fileExt;
				long fileSize = getFiles.getSize();
				
				File checkFolders = new File(uploadPath);
				if(!checkFolders.exists()) {
					checkFolders.mkdirs();
				}
				
				File createFile = new File(uploadPath+copyFileName);
				if(createFile.createNewFile()) {
					getFiles.transferTo(createFile);
					
					/**
					 * Set File Info
					 * */
					fileInfo.setCommonFileOrgName(fileOrgName);
					fileInfo.setCommonFileCopyName(copyFileName);
					fileInfo.setCommonFileSize(fileSize);
					fileInfo.setCommonFileExt(fileExt);
					fileInfo.setCommonFileWebUrl("/image/"+DateUtil.getYear()+"/"+DateUtil.getMonth()+"/"+DateUtil.getDay()+"/");
					fileInfo.setCommonFileRealPath(uploadPath);
					fileInfos.add(fileInfo);
				}
				
			}
		}
		
		return fileInfos;
	}

	/**
	 *@author KYJ
	 *@since 2019-02-03
	 *@param  HttpServletRequest
	 *@return String(getRealPath)
	 * get Real Path Method
	 **/
	public static final String getRealPath(HttpServletRequest request) {
		String getRealPath = request.getSession().getServletContext().getRealPath("/");
		return getRealPath;
	}
	
	/**
	 *@author KYJ
	 *@since 2019-02-10
	 *@param  String device
	 *@return 
	 * Image Resize to Device
	 **/
	public static final void imageResizer(String device, String filePath, String fileName, String fileExt)throws Exception {
		
	}
}
