package com.src.nirakar.thread.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * I have to create 5 threads and each thread will do below operation 
 * 
 * 1. Thread 1 - Adding 1 : 10
 * 2. Thread 2 - Adding 1 : 50
 * 3. Thread 3 - Adding 5 : 15
 * 4. Thread 4 - Adding 10 : 20
 * 5. Thread 5 - Adding 15 : 20
 * @author NIRAKAR
 *
 */
public class ThreadingPoolingVMWareQuestion {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService exe = Executors.newFixedThreadPool(5);

		List<Callable<Integer>> callableList = new ArrayList<Callable<Integer>>();

		callableList.add(new Callable<Integer>() {

			public Integer call() throws Exception {
				int resultOfSum = 0;
				for (int i = 0; i < 10; i++)
					resultOfSum += i;
				System.out.println("Finding the result of 1 to 10 : "
						+ resultOfSum);
				return resultOfSum;
			}
		});

		callableList.add(new Callable<Integer>() {

			public Integer call() throws Exception {
				int resultOfSum = 0;
				for (int i = 5; i < 50; i++)
					resultOfSum += i;
				System.out.println("Finding the result of 1 to 50 :"
						+ resultOfSum);
				return resultOfSum;
			}
		});

		callableList.add(new Callable<Integer>() {

			public Integer call() throws Exception {
				int resultOfSum = 0;
				for (int i = 5; i < 15; i++)
					resultOfSum += i;
				System.out.println("Finding the result of 5 to 15 :"
						+ resultOfSum);
				return resultOfSum;
			}
		});

		callableList.add(new Callable<Integer>() {

			public Integer call() throws Exception {
				int resultOfSum = 0;
				for (int i = 10; i < 20; i++)
					resultOfSum += i;
				System.out.println("Finding the result of 10 to 20 : "
						+ resultOfSum);
				return resultOfSum;
			}
		});

		callableList.add(new Callable<Integer>() {

			public Integer call() throws Exception {
				int resultOfSum = 0;
				for (int i = 15; i < 20; i++)
					resultOfSum += i;
				System.out.println("Finding the result of 15 to 20 : "
						+ resultOfSum);
				return resultOfSum;
			}
		});

		List<Future<Integer>> result = exe.invokeAll(callableList);
		// System.out.println(result.get(0).get() + "  " + result.get(1).get()
		// );

		for (Future<Integer> ft : result) {
			System.out.println(ft.get());
			Thread.sleep(1000);
		}
		
		exe.shutdown();

	}

}
