package com.src.nirakar.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This class demonstrates implementing Callable Interface.
 * 
 * @author NIRAKAR
 *
 */
public class ESMultipleSubmissionUsingCallable {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService es = Executors.newFixedThreadPool(5);
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			Callable<Integer> callable = new MyCallable(i);
			Future<Integer> obj = es.submit(callable);
			int result = (Integer) obj.get();
			sum += result;
			System.out.println("result ----- : "+result +" Summation ---- " +sum);
		}
		System.out.println(sum);
		es.shutdown();
	}

}

class MyCallable implements Callable<Integer> {

	int tasknumber;

	public MyCallable(int tasknumber) {
		this.tasknumber = tasknumber;
	}

	public Integer call() throws Exception {
		Thread.sleep(1000);
		return tasknumber;
	}

}