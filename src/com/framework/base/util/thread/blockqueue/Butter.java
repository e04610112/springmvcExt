package com.framework.base.util.thread.blockqueue;

public class Butter implements Runnable {
	private ToastQueue dryQueue,butterdQueue;
	public Butter(ToastQueue dryQueue,ToastQueue butterdQueue){
		this.dryQueue=dryQueue;
		this.butterdQueue=butterdQueue;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
				Toast toast=dryQueue.take();
				toast.butter();
				System.out.println(toast);
				butterdQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println("Butter Interrupted");
		}
		System.out.println("jammer off");
	}

}
