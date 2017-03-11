package com.framework.base.util.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;

public class DBConnPool  {
	private Connection con=null;//连接
	private int inUsed=0;//连接使用数
	private ArrayList<Connection> freeConnectList=new ArrayList<Connection>();//空闲连接list
	private int minCon;//最小连接数
	private int maxCon;//最大连接数
	private String name;//连接池名字
	private String driver;//驱动
	private String url; //数据库连接地址
	private String user; //用户名
	private String password; //密码
	public Timer timer=new Timer();//定时
	public DBConnPool(){
		Thread t=new Thread(new ClearOverConThread(this));
		 //t.setDaemon(true);
		t.start();
	}
	public synchronized void cleanOverCon(){
		Connection con=null;
		int size=this.freeConnectList.size();
//		int minCon=pool.getMinCon();
		if(size<=this.minCon){//如果空闲连接数小于最小工作线程数则等待
			System.out.println("清理程序wait：：：：：：：：wait 1000");
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("启动清理!!!!!!!!!!!!!!!!!!!!");
			//Thread.sleep(10000);
			for(int i=0;i<size-minCon;i++){
				con=this.freeConnectList.get(size-i-1);
				this.freeConnectList.remove(size-i-1);
				try {
					System.out.println("清理一个，目前有"+this.freeConnectList.size()+"个空闲");
					con.close();
					//Thread.sleep(3000);	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 将空闲的连接放入连接池末尾
	 * @param con
	 *@author lyj [May 7, 2015]
	 */
	 public synchronized void freeConn(Connection con){
	 	 this.freeConnectList.add(con);//添加到空闲连接的末尾
	 	 this.inUsed--;
	 	 System.out.println("添加空闲连接，现有"+inUsed+"个连接在使用!有"+freeConnectList.size()+"个空闲连接");
	 }
	 /**
	  * 获取连接
	  * @return
	  *@author lyj [May 8, 2015]
	  */
	 public synchronized Connection getConnection(){
		  Connection con=null;
		  if(this.maxCon==0){return null;}
		  if(this.maxCon<=this.inUsed){//超过最大连接时,等待1秒再取
			  try {
				wait(500);
				con=getConnection();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  }else{
			  if(this.freeConnectList.size()>0){
				  con=(Connection)this.freeConnectList.get(0);
			   	  this.freeConnectList.remove(0);//如果连接分配出去了，就从空闲连接里删除
			   	  if(con==null)con=getConnection(); //如果连接为空，则继续获取
			  }else{
				  con=newConnection(); //新建连接
			  }
			  
			  if(con!=null){
				  this.inUsed++;
				  System.out.println("得到连接，现有"+inUsed+"个连接在使用! 有"+freeConnectList.size()+"个空闲连接");
			  }
		  }
		  return con;
	 }
	 /**
	  * 创建一个jdbc连接
	  * @return
	  *@author lyj [May 7, 2015]
	  */
	 private Connection newConnection(){
		  try {
			  Class.forName(driver);
			  con=DriverManager.getConnection(url, user, password);
			  System.out.println("创建一个新连接!");
		  } catch (ClassNotFoundException e) {
			  System.out.println("驱动加载失败!");
			  e.printStackTrace();
		  } catch (SQLException e1) {
			  System.out.println("不能创建连接，请检查网络！");
			  e1.printStackTrace();
		  }
		  return con; 
	 }
	 public synchronized int getFreeConSize() {
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return freeConnectList.size();
	 }
	 public synchronized Connection getFreeCon(int index) {
		 return freeConnectList.get(index);
 }
	 public synchronized void removeFreeCon(int index) {
			 freeConnectList.remove(index);
	 }
	 /*
	  * 释放所有连接，清空资源
	  */
	public synchronized void release(){
		  for (Connection con : freeConnectList) {
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		  this.freeConnectList.clear(); 
	}
	
	public synchronized  int getInUsed() {
		return inUsed;
	}
	public synchronized void setInUsed(int inUsed) {
		this.inUsed = inUsed;
	}
	public  int getMinCon() {
		return minCon;
	}
	public  void setMinCon(int minCon) {
		this.minCon = minCon;
	}
	public  int getMaxCon() {
		return maxCon;
	}
	public  void setMaxCon(int maxCon) {
		this.maxCon = maxCon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}


}
