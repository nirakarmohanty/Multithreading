package com.src.nirakar.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ESMultipleSubmissionUsingRunnable {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			Runnable runnable = new MyRunnable(i);
			es.submit(runnable);
		}

	}

}

class MyRunnable implements Runnable {

	int tasknumber;

	public MyRunnable(int tasknumber) {
		this.tasknumber = tasknumber;
	}

	public void run() {
		System.out.println("Executing thread service  "
				+ Thread.currentThread().getName() + " : " + tasknumber);

	}

}