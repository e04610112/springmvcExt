package com.framework.base.util.dbpool;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.Vector;

public class DBConnManager {
	 private static  DBConnManager instance;//唯一数据库连接池管理实例类
	 private static int clients;                 //客户连接数
	 private String initPath="com/framework/config/jdbcPool.properties";
	 //private Vector drivers  = new Vector();//驱动信息
	// private Hashtable pools=new Hashtable();//连接池
	 private DBConnPool pool=null;
	 public DBConnManager() {
		  this.init();
	 }
	 public static synchronized DBConnManager getInstance(){
		  if(instance==null){
			  instance=new DBConnManager();
		  }
		  return instance;
	 }
	 private void init(){
		DBConfigBean dBConfigBean= DBConfigLoad.loadDBPoolConfig(initPath);    
		//创建连接池
		pool=createPools(dBConfigBean);
		System.out.println("创建连接池完毕。。。");
	 }
	 /**
	  * 取得连接
	  * @return
	  *@author lyj [May 8, 2015]
	  */
	 public Connection getConnection(){
		Connection con=null;
		con=pool.getConnection();//从连接池中获取连接
		if(con!=null)
		System.out.println("得到连接。。。");
		return con;
	 }
	 /**
	  * 释放连接
	  * @param con
	  *@author lyj [May 8, 2015]
	  */
	 public void freeConnection(Connection con){
	    if(pool!=null)
	    pool.freeConn(con);//释放连接 
	 }

	 private DBConnPool createPools(DBConfigBean dBConfigBean)
	 {
		DBConnPool dbpool=new DBConnPool();
		//dbpool.setName(dBConfigBean.getName());
		dbpool.setDriver(dBConfigBean.getDriver());
		dbpool.setUrl(dBConfigBean.getUrl());
		dbpool.setUser(dBConfigBean.getUsername());
		dbpool.setPassword(dBConfigBean.getPassword());
		dbpool.setMinCon(dBConfigBean.getMincon());
		dbpool.setMaxCon(dBConfigBean.getMaxcon());
		return dbpool;
	 }
	public DBConnPool getPool() {
		return pool;
	}
	 
}
