package com.framework.base.exception;

import java.util.Properties;
class ExceptionConfig {
	private static final String EXCEPTION_PROPERTIES = "com/framework/config/exception.properties";
	private static Properties properties = null;

	static {
		properties = ExceptionPropertiesLoader
				.loadProperties(EXCEPTION_PROPERTIES);
		System.out.println("加载exception.properties");
	}

	public static String getParam(String key) {
		return properties.getProperty(key);
	}
}
