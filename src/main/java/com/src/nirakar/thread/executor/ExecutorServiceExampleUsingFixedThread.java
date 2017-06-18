package com.src.nirakar.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExampleUsingFixedThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Creating instance of Executor Service by using Single Thread Executor
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		System.out
				.print("---- Executing Execute Method by Passing Runnable Type ------ ");
		executorService.execute(new Runnable() {

			public void run() {
				System.out
						.println("Executing Executor Service --- Execute Method --- Passing Runnable Interface");

			}
		});
		System.out
				.println("---- Executing Submit Method by Passing Runnable Type ------ ");
		executorService.submit(new Runnable() {

			public void run() {

				System.out
						.println("Executing Executor Service --- Submit Method --- Passing Runnable Interface");

			}
		});

		System.out
				.println("---- Executing Submit Method by Passing Callable Type ------ ");

		Future<String> future = executorService.submit(new Callable<String>() {

			public String call() throws Exception {
				System.out
						.println("Executing Executor Service --- Submit Method --- Passing Callable Interface");
				return "Callable String";
			}
		});
	
		System.out.println(future.get());
		
		executorService.shutdown();
	}

}
