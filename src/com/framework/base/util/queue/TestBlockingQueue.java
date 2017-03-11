package com.framework.base.util.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockingQueue {
	static void getkey(){
		
	}
	static void test(String msg, BlockingQueue<LiftOff> queue){
		System.out.println(msg);
		LiftOffRunner liftOffRunner=new LiftOffRunner(queue);
		Thread thread =new Thread(liftOffRunner);
		thread.start();
		for(int i=0;i<5;i++){
			liftOffRunner.add(new LiftOff(5));
		}
	}
	/**
	 * @param args
	 *@author lyj [May 7, 2015]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());
		test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
		test("SynchronousQueue",new SynchronousQueue<LiftOff>());
	}

}
