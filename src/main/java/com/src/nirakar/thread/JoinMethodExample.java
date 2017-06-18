package com.src.nirakar.thread;

public class JoinMethodExample implements Runnable{

	volatile int i=10;
	int j=1;
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new JoinMethodExample(),"Thread -1");
		Thread t2 = new Thread(new JoinMethodExample(),"Thread -2");
		t1.start();
		t1.join();
		t2.start();

	}

	public void run() {
		i = i+1;
		j ++; 
		System.out.println("Run method Executed" + Thread.currentThread() + "Value of i = " + i + "Value of J = " + j);
		
	}

}
