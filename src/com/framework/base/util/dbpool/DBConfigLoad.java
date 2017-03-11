package com.framework.base.util.dbpool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.Map.Entry;

public class DBConfigLoad {
	
	public DBConfigLoad(){}
	
	public static DBConfigBean loadDBPoolConfig(String path){
		//com/framework/config/jdbcPool.properties
		//修改为多数据库版本？暂时不修改
		Vector<DBConfigBean> vector=null;
		InputStream stream=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);  
		Properties properties=new Properties();  
		try {
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}  
//	    for (Object key: properties.keySet()) {
//	    	System.out.println((String)key);
//	    	System.out.println(properties.getProperty((String)key));
//		}
		DBConfigBean dBConfigBean=new DBConfigBean();
		dBConfigBean.setDriver(properties.getProperty("driver"));
		dBConfigBean.setUrl(properties.getProperty("url"));
		dBConfigBean.setUsername(properties.getProperty("username"));
		dBConfigBean.setPassword(properties.getProperty("password"));
		if(!"".equals((String)properties.getProperty("mincon").trim())){
			dBConfigBean.setMincon(Integer.parseInt((String)properties.getProperty("mincon").trim()));
		}
		if(!"".equals((String)properties.getProperty("maxcon").trim())){
			dBConfigBean.setMaxcon(Integer.parseInt((String)properties.getProperty("maxcon").trim()));
		}
		if(!"".equals((String)properties.getProperty("timeout").trim())){
			dBConfigBean.setTimeout(Integer.parseInt((String)properties.getProperty("timeout").trim()));
		}
		return dBConfigBean;
	}
}
