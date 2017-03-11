package com.framework.base.util.apacheCommonsUtil.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * 1. Properties files
   2. XML documents
   3. Property list files (.plist)
   4. JNDI
   5. JDBC Datasource
   6. System properties
   7. Applet parameters
   8. Servlet parameters
 * @author Administrator
 *
 */
public class ConfigurationUtilTest {
	public static void main(String[] args) throws ConfigurationException {
		PropertiesConfiguration config = new PropertiesConfiguration("com/framework/base/util/apacheCommonsUtil/configuration/usergui.properties");  
		System.out.println("colors.background:"+config.getString("colors.background"));
		config.setProperty("colors.background", "#100000");  
		System.out.println("colors.background:"+config.getString("colors.background"));
		config.save();  
		  
		config.save("usergui.backup.properties");//save a copy  
		//Integer integer = config.getInteger("window.width");
	}
}
