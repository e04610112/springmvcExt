package com.framework.base.util.apacheCommonsUtil.dbcp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.dbcp.BasicDataSource;






public class DbcpConnect {
	private static DataSource dataSource;  
    private static Connection connection;  
      
    public static void initDataSource() throws ConfigurationException{  
        FileInputStream is = null;  
        //Properties properties = new Properties();  
          
        String driverClassName = null;  
        String url = null;  
        String username = null;  
        String password = null;  
          
        int initialSize = 0;  
        int minIdle = 0;  
        int maxIdle = 0;  
        int maxWait = 0;  
        int maxActive = 0;  
       
    	PropertiesConfiguration config = new PropertiesConfiguration("com/framework/base/util/apacheCommonsUtil/dbcp/dbcp.properties");  
        driverClassName = config.getString("dbcp.driverClassName");  
        url = config.getString("dbcp.url");  
        username = config.getString("dbcp.username");  
        password = config.getString("dbcp.password");  
        initialSize = Integer.parseInt((config.getString("dbcp.initialSize").trim()));//初始化连接数
        minIdle = Integer.parseInt((config.getString("dbcp.minIdle")).trim());  //最小空闲连接
        maxIdle = Integer.parseInt((config.getString("dbcp.maxIdle")).trim());  //最大空闲连接
        maxWait = Integer.parseInt((config.getString("dbcp.maxWait")).trim());  //等待时间
        maxActive = Integer.parseInt((config.getString("dbcp.maxActive")).trim());  //最大连接数
              
          
        BasicDataSource bds = new BasicDataSource();  
          
        bds.setUrl(url);  
        bds.setDriverClassName(driverClassName);  
        bds.setUsername(username);  
        bds.setPassword(password);
        //bds.setInitialSize(initialSize); 1.2版本之后支持 
        bds.setMaxActive(maxActive);  
        bds.setMinIdle(minIdle);  
        bds.setMaxIdle(maxIdle);  
        bds.setMaxWait(maxWait);  
          
        dataSource = bds;  
    }  
      
    public static Connection  getConnection() throws  SQLException, ConfigurationException {  
        if (dataSource == null) {     
            initDataSource();     
        }     
        Connection conn = null;     
        if (dataSource != null) {     
            conn = dataSource.getConnection();     
        }   
        return conn;     
    }
    public static void main(String[] args) throws SQLException, ConfigurationException {
    	Thread thread =new Thread(new ThreadTest());
    	thread.start();
    	Thread thread1 =new Thread(new ThreadTest());
    	thread1.start();
    	Thread thread2 =new Thread(new ThreadTest());
    	thread2.start();
    	Thread thread3 =new Thread(new ThreadTest());
    	thread3.start();
    	Thread thread4 =new Thread(new ThreadTest());
    	thread4.start();
    	
    }
}
