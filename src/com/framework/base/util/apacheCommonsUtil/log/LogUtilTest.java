package com.framework.base.util.apacheCommonsUtil.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtilTest {
	private static Log log = LogFactory.getLog(LogUtilTest.class); 
	public static void main(String[] args) {
		log.error("ERROR");  
        log.debug("DEBUG");  
        log.warn("WARN");  
        log.info("INFO");  
        log.trace("TRACE");  
     System.out.println(log.getClass());  
	}
}
