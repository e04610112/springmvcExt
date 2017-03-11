package com.framework.base.util.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class OrnamentalGarden {
	class Count{
		private int count=0;
		private Random random=new Random(47);
		public synchronized int increment() {
			int temp=count;
			if(random.nextBoolean()){
				Thread.yield();
			}
			return(count=++temp);
		}
		public synchronized  int value() {
			return count;
		}
	}
	class Entrance implements Runnable{
		private Count count=new OrnamentalGarden().new Count();
		private List<Entrance> entrances=new ArrayList<Entrance>();
		private int number=0;
		private final int id;
		private  volatile boolean canceled=false;
		public  void cancel(){canceled=true;}
		public Entrance(int id){
			this.id=id;
			entrances.add(this);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (!canceled) {
				synchronized (this) {
					++number;
				}
				System.out.println(this+" Total: "+count.increment());
				try {
					TimeUnit.MICROSECONDS.sleep(100);
				} catch (Exception e) {
					System.out.println("sleep interrupted");
				}
			}
			System.out.println("stoping "+this);
		}
		public synchronized int getValue() {
			return number;
		}
		public String toString(){
			return "Entrance "+id+":"+getValue();
		}
		public  int getTotalCount(){
			return count.value();
		}
		public  int sumEntrances(){
			int sum=0;
			for (Entrance entrance:entrances) {
				sum+=entrance.getValue();
			}
			return sum;
		}
	}
	/**
	 * @param args
	 *@author lyj [Apr 23, 2015]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
