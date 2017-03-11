package com.framework.base.util.thread;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{

	/**
	 * @param args
	 *@author lyj [Apr 22, 2015]
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			Thread daemonThread=new Thread(new SimpleDaemons());
			daemonThread.setDaemon(true);//设置为后台线程
			daemonThread.start();
		}
		System.out.println("all daemons");
		TimeUnit.MICROSECONDS.sleep(175000);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
			TimeUnit.MICROSECONDS.sleep(100);
			System.out.println(Thread.currentThread()+""+this);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

}
