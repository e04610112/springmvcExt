package com.framework.base.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.log4j.Logger;

class ExceptionPropertiesLoader {
	/**
	 * exception.properties加载器
	 */
	private static Logger log = Logger.getLogger(ExceptionPropertiesLoader.class);

	public static Properties loadProperties(String subDir) {
		Properties props = new Properties();

		URL url = ExceptionPropertiesLoader.class.getClassLoader().getResource(subDir);

		String decodeUrl = "";
		try {
			decodeUrl = URLDecoder.decode(url.getPath(), "GBK");
		} catch (UnsupportedEncodingException e) {
			log.error("GBK解码异常!", e);
		}

		File f = new File(decodeUrl);
		InputStream in = null;
		try {
			in = new FileInputStream(f);
			props.load(in);
		} catch (Exception e) {
			log.error("加载exception.properties失败", e);
			try {
				in.close();
			} catch (Exception e1) {
				log.error("关闭exception.properties输入流失败！", e1);
			}
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				log.error("关闭exception.properties输入流失败！", e);
			}
		}

		return props;
	}

}
