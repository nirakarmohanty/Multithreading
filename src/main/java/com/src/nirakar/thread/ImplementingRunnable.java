package com.src.nirakar.thread;

public class ImplementingRunnable implements Runnable {

	public void run() {
		System.out.println("Executing Thread : " + Thread.currentThread());

	}
	public static void main(String[] args) {
		
		Thread thred = new Thread(new ImplementingRunnable());
		thred.start();
	}

}
