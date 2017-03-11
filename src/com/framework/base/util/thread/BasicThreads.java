package com.framework.base.util.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicThreads {

	/**
	 * @param args
	 *@author lyj [Apr 22, 2015]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread thread=new Thread(new LiftOff());
//		thread.start();
//		System.out.println("wating for lift");
		
		//other
//		for(int i=0;i<5;i++){
//			new Thread(new LiftOff()).start();
//			System.out.println("wating for lift");
//		}
		//Executor 首选用他
		ExecutorService exec=Executors.newCachedThreadPool();//首选
		//ExecutorService exec=Executors.newFixedThreadPool(5);//限定线程数
		//ExecutorService exec=Executors.newSingleThreadExecutor();//一个线程，按任务先后顺序执行
		for(int i=0;i<5;i++){
			exec.execute(new LiftOff());
			//System.out.println("wating for lift");
		}
	}

}
