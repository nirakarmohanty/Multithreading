package com.src.nirakar.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExampleUsingSingleThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Creating instance of Executor Service by using Single Thread Executor
		ExecutorService executorService = Executors.newSingleThreadExecutor();

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

		
		List<Callable<Object>> callableList = new ArrayList<Callable<Object>>();
		
		callableList.add(new Callable<Object>() {

			public String call() throws Exception {
				
				return "String Implementation";
			}
		});

		callableList.add(new Callable<Object>() {

			public Integer call() throws Exception {
				
				return 12;
			}
		});
		
		Object object= executorService.invokeAny(callableList);
		
		System.out.println(object);
		
		
		
		executorService.shutdown();
	}

}
