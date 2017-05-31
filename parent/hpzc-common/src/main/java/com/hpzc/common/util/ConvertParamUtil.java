package com.hpzc.common.util;

import org.apache.commons.lang3.StringUtils;

public class ConvertParamUtil {

	/**
	 * 获取FTL模板文件所在路径
	 * 
	 * @param localPath
	 * @param documentName
	 * @return
	 */
	public static String getFTLPathByDocumentName(String localPath, String documentName) {

		if (StringUtils.isEmpty(documentName)) {
			throw new RuntimeException("无法解析文件名称");
		}
		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(localPath);
		// pathBuffer.append(FTLPath);
		pathBuffer.append(documentName);
		pathBuffer.append(".ftl");
		return pathBuffer.toString();
	}

	public static String getFTLPathByDocumentName(String localPath) {
		String documentName = "payApply";
		if (StringUtils.isEmpty(documentName)) {
			throw new RuntimeException("无法解析文件名称");
		}
		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(localPath);
		// pathBuffer.append(FTLPath);
		pathBuffer.append(documentName);
		pathBuffer.append(".ftl");
		return pathBuffer.toString();
	}

	/**
	 * 获取PDF文件路径
	 * 
	 * @return
	 */
	public static String getPDFPathByDocumentName(String localPath, String documentName) {

		if (StringUtils.isEmpty(documentName)) {
			throw new RuntimeException("无法解析文件名称");
		}

		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(localPath);
		pathBuffer.append(documentName);
		pathBuffer.append(".pdf");

		return pathBuffer.toString();
	}

	/**
	 * 获取HTML文件路径
	 * 
	 * @return
	 */
	public static String getHTMLPathByDocumentName(String localPath, String documentName) {

		if (StringUtils.isEmpty(documentName)) {
			throw new RuntimeException("无法解析文件名称");
		}

		StringBuffer pathBuffer = new StringBuffer();
		pathBuffer.append(localPath);
		// pathBuffer.append(PropertiesUtils.getProperty("filepath.properties",
		// "image.filepath.html"));
		pathBuffer.append(documentName);
		pathBuffer.append(".html");

		return pathBuffer.toString();
	}

	public static String getFontPath() {
		String OS = System.getProperty("os.name").toLowerCase();
		String fontPath = null;
		if (OS.indexOf("mac") >= 0) {
			// mac
			fontPath = "/library/fonts/Arial Unicode.ttf";
		} else if (OS.indexOf("linux") >= 0) {
			// linux：
			//fontPath = "/usr/share/fonts/TTF/ARIALUNI.TTF";
			fontPath = "/usr/share/fonts/TTF/SIMSUN.TTC";
		} else if (OS.indexOf("windows") >= 0) {
			// windows:
			fontPath = "C:/Windows/Fonts/simsun.ttc";
		}
		return fontPath;
	}
}
