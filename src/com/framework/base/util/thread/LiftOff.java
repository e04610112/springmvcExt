package com.framework.base.util.thread;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable{
	protected int countDown=10;
	private static int taskCount=0;
	private final int id=taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
	}
	@Override
	public void run() {
		while (countDown-->0) {
			System.out.print(status());
			//Thread.yield();切换线程
			
			try {
				//jdk1.5前版本
				//Thread.sleep(100);
				//jdk1.6,1.6
				TimeUnit.MILLISECONDS.sleep(0);//挂起，再次跟其他线程抢cpu时间
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
			
		}
		
		
	}

}
