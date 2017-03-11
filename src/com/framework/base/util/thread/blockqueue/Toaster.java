package com.framework.base.util.thread.blockqueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count=0;
	private Random random=new Random(47);
	public Toaster(ToastQueue tq){toastQueue=tq;}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
				TimeUnit.MICROSECONDS.sleep(100+random.nextInt(500));
				Toast toast=new Toast(count++);
				System.out.println(toast);
				toastQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toast off");

	}

}
