package com.framework.base.util.queue;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
	private BlockingQueue<LiftOff> queue;
	public LiftOffRunner(BlockingQueue<LiftOff> queue){
		this.queue=queue;
	}
	public void add(LiftOff lo){
		try {
			queue.put(lo);//add与put都是放入对象，区别是add如果队列不够报异常，而put则会阻塞等待
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			//e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				LiftOff lOff=queue.take();
				lOff.run();
			} catch (InterruptedException e) {
				System.out.println("Waiting  interrupted");
			}
		}
		System.out.println("LiftOffRunner finish");
	}

}
