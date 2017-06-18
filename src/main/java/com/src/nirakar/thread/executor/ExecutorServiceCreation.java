package com.src.nirakar.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * THis class demonstrates that how many ways you can create the Executor Service.
 * @author NIRAKAR
 *
 */
public class ExecutorServiceCreation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating Single Thread Executor Service.
		ExecutorService executorService = Executors.newSingleThreadExecutor();	
		
		System.out.println("-----Using SIngle Thread Executor Service----");
		System.out.println(executorService.isTerminated());
		
		System.out.println(executorService.isShutdown());
		
		System.out.println(executorService);
		
		executorService.shutdown();
		
		System.out.println(executorService.isShutdown());
		
		System.out.println("----- Using Fixed Thread Executor Service ----"); 
		
		ExecutorService executorService2 = Executors.newFixedThreadPool(2);
		
		System.out.println(executorService2.isTerminated());
		
		System.out.println(executorService2.isShutdown());
		
		System.out.println(executorService2);
		
		executorService2.shutdown();
		
		System.out.println(executorService2.isShutdown());
		

		System.out.println("----- Using Scheduled Thread Pool Executor Service ----"); 
		
		ExecutorService executorService3 = Executors.newScheduledThreadPool(2);
		
		System.out.println(executorService3.isTerminated());
		
		System.out.println(executorService3.isShutdown());
		
		System.out.println(executorService3);
		
		executorService3.shutdown();
		
		System.out.println(executorService3.isShutdown());
		
		
	}

}
