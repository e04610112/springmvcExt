package com.framework.base.util.dbpool;

import java.sql.Connection;

public class DBUtil {
	 public  static Connection getConnection(){
		 return DBConnManager.getInstance().getConnection();
	 }
	 public static void freeConnection(Connection con){
		 DBConnManager.getInstance().freeConnection(con);
	 }
     public static void main(String[] args) {
    	 //DBConnManager dBConnManager= DBConnManager.getInstance();
//    	 Connection connection=dBConnManager.getConnection();
//    	 dBConnManager.freeConnection(connection);
    	//创建线程定时将超过最小线程的空闲连接释放,启动后5秒启动，每个15秒再启动
		 
    	 for(int i=0;i<80;i++){
    		 Thread thread=new Thread(new TestThread());
    		 thread.start();
    		 Thread thread2=new Thread(new TestThread());
    		 thread2.start();
    		 Thread thread3=new Thread(new TestThread());
    		 thread3.start();
    	 }
    	 for(int i=0;i<60;i++){
    		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 TestThread testThread=new TestThread();
    		 Thread thread=new Thread(testThread);
    		 thread.start();
    	 }
    	 
    	
    	 
	 }
}
