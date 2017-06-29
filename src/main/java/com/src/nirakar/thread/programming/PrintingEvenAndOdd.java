package com.src.nirakar.thread.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrintingEvenAndOdd {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		List<Callable<Integer>> listOfThreads = new ArrayList<Callable<Integer>>();
		
		listOfThreads.add(new Callable<Integer>() {

			public Integer call() throws Exception {
					for(int i=0;i<30;i++)
					{
						if (i%2==0){
							System.out.print(i + " --->");
						}
					}
				return null;
			}
		});
		
		listOfThreads.add(new Callable<Integer>() {

			public Integer call() throws Exception {
					for(int i=0;i<30;i++)
					{
						if (i%2!=0){
							System.out.print(i + " --->");
						}
					}
				return null;
			}
		});
		
		List<Future<Integer>> futureObject=exe.invokeAll(listOfThreads);
		
		System.out.println(futureObject);
		
		Integer futureIntegerObject=exe.invokeAny(listOfThreads);
		
		System.out.print( " ******** "+futureIntegerObject);
		exe.shutdown();
	}

}
