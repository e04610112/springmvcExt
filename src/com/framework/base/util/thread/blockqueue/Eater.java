package com.framework.base.util.thread.blockqueue;

public class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int counter =0;
	public Eater(ToastQueue finished){
		this.finishedQueue=finished;
	}
	@Override
	public void run() {
		try {
			Toast toast=finishedQueue.take();
			if(toast.getId()!=counter++||toast.getStatus()!=Toast.Status.JAMMED){
				System.out.println("err:"+toast);
				System.exit(1);
			}else{
				System.out.println("chomp:"+toast);
			}
		} catch (InterruptedException e) {
			System.out.println("Eater Interrupted");
		}
		System.out.println("Eater off");
	}

}
