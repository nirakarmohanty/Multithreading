package com.src.nirakar.thread;

public class ExtendingThread extends Thread{

	public void run(){
		System.out.println("Thread Started execution : " + Thread.currentThread());
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new ExtendingThread());
		thread.start();
	}

}
