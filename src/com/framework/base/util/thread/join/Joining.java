package com.framework.base.util.thread.join;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class Joining {
	class Sleeper extends Thread{
		private int duration;
		public Sleeper(String name,int sleepTime){
			super(name);
			duration=sleepTime;
			start();
		}
		public void run(){
			try {
				sleep(duration);
			} catch (Exception e) {
				System.out.println(getName()+"interrupted"+" isInterrupted():"+isInterrupted());
				return;
			}
			System.out.println(getName()+"has awakened");
		}
	}
	class Jioner extends Thread{
		private Sleeper sleeper;
		public Jioner(String name,Sleeper sleeper){
			super(name);
			this.sleeper=sleeper;
			start();
		}
		public void run(){
			try {
				sleeper.join();
			} catch (Exception e) {
				System.out.println("interrupted");
			}
			System.out.println(getName()+" jion complted");
		}
	}
	/**
	 * @param args
	 *@author lyj [Apr 23, 2015]
	 */
	public static void main(String[] args) {
		Sleeper sleeper=new Joining().new Sleeper("sleep",1500);
		Sleeper grumpy=new Joining().new Sleeper("grumpy",1500);
		Jioner dopey=new Joining().new Jioner("dopey",sleeper);
		Jioner doc=new Joining().new Jioner("doc",grumpy);
		grumpy.interrupt();

	}

}
