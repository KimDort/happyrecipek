package com.happyrecipek.web.com.system.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import com.happyrecipek.web.com.system.files.ckeditor.entities.CommonFileInfo;

public class ImageUtil {
	private static final int THUMB_WIDTH=250;
	private static final int RESIZE_WIDTH=500;
	
	public static List<CommonFileInfo> imageResizer(String imgOriginalPath,String basePath, String baseWebPath, String imageExt, String fileName, List<CommonFileInfo> fileInfos) {
		/**
		 * Save Image Path 
		 **/
		String imgThumbPath="";
		String imgResizePath="";
		
		/**
		 * Original Image Width & Height 
		 **/
		int getImageWidth;
		int getImageHeight;
		
		/**
		 * Create Change Thumb Width & Height & Ratio
		 **/
		int chgThumbW=0;
		int chgThumbH=0;
		double thumbRatio=0;
		
		/**
		 * Create Change Resize Width & Height & Ratio
		 **/
		int chgResizeW=0;
		int chgResizeH=0;
		double resizeRatio=0;
		
		
		try {
			Image image = ImageIO.read(new File(imgOriginalPath+fileName));
			
			getImageWidth = image.getWidth(null);
			getImageHeight = image.getHeight(null);
			if(getImageWidth > THUMB_WIDTH) {
				if(getImageWidth > getImageHeight) {
					/**
					 * Create Thumb Path & Ratio
					 **/
					thumbRatio = (double)THUMB_WIDTH/(double)getImageWidth;
					imgThumbPath = basePath+"thumb/";
					
					/**
					 * Create Resize Path & Ratio
					 **/
					resizeRatio = (double)RESIZE_WIDTH/(double)getImageWidth;
					imgResizePath = basePath+"resize/";
				}else {
					/**
					 * Create Thumb Path & Ratio
					 **/
					thumbRatio = (double)THUMB_WIDTH/(double)getImageHeight;
					imgThumbPath = basePath+"thumb/";
					
					/**
					 * Create Resize Path & Ratio
					 **/
					resizeRatio = (double)RESIZE_WIDTH/(double)getImageHeight;
					imgResizePath = basePath+"resize/";
				}
			}
			
			/**
			 * Check Thumb Folder
			 **/
			File checkFolder = new File(imgThumbPath);
			
			if(!checkFolder.exists()) {
				checkFolder.mkdirs();
			}
			
			/**
			 * Check Resize Folder
			 **/
			checkFolder = new File(imgResizePath);
			
			if(!checkFolder.exists()) {
				checkFolder.mkdirs();
			}
			
			/**
			 * Set Change Thumb Width & Height
			 **/
			chgThumbW = (int)(getImageWidth * thumbRatio);
			chgThumbH = (int)(getImageHeight * thumbRatio);
			
			/**
			 * Set Change Resize Width & Height
			 **/
			chgResizeW = (int)(getImageWidth * resizeRatio);
			chgResizeH = (int)(getImageHeight * resizeRatio);
			
			/**
			 * Create Thumb & Resize BufferedImage
			 **/
			Image thumbImg = image.getScaledInstance(chgThumbW, chgThumbH, Image.SCALE_SMOOTH);
			Image resizeImg = image.getScaledInstance(chgResizeW, chgResizeH, Image.SCALE_SMOOTH);
			
			BufferedImage thumbImage = new BufferedImage(chgThumbW, chgThumbH, BufferedImage.TYPE_INT_RGB);
			BufferedImage resizeImage = new BufferedImage(chgResizeW, chgResizeH, BufferedImage.TYPE_INT_RGB);
			
			Graphics thumbG = thumbImage.getGraphics();
			Graphics resizeG = resizeImage.getGraphics();
			thumbG.drawImage(thumbImg, 0, 0, null);
			resizeG.drawImage(resizeImg, 0, 0, null);
			thumbG.dispose();
			resizeG.dispose();
			
			File createThumbFile = new File(imgThumbPath + fileName);
			ImageIO.write(thumbImage, imageExt, createThumbFile);
			
			File createResizeFile = new File(imgResizePath + fileName);
			ImageIO.write(resizeImage, imageExt, createResizeFile);
			
			for(int i=0;i<fileInfos.size();i++) {
				fileInfos.get(i).setCommonFileThumbWebUrl(baseWebPath+"thumb/");
				fileInfos.get(i).setCommonFileResizeWebUrl(baseWebPath+"resize/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileInfos;
	}
}