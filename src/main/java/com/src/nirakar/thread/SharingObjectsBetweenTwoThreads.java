package com.src.nirakar.thread;

import java.awt.DisplayMode;

public class SharingObjectsBetweenTwoThreads {

	int[] array = new int[15] ;

	public void display() {
		for (int i = 0; i < 10; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SharingObjectsBetweenTwoThreads sharingObjectsBetweenTwoThreads = new SharingObjectsBetweenTwoThreads();
		// sharingObjectsBetweenTwoThreads.r
		// System.out.println(r1);

		Thread r1 = new Thread(
				new SharingObjectsBetweenTwoThreads().new First());
		
		//sharingObjectsBetweenTwoThreads.display();
		Thread r2 = new Thread(
				new SharingObjectsBetweenTwoThreads().new Second());
		r1.start();
		
		r2.start();
		r1.join();
		r2.join();
		sharingObjectsBetweenTwoThreads.display();
	}

	class First implements Runnable {

		public void run() {

			for (int i = 0; i < 10; i++) {
				array[i] = i;
			}

		}

	}

	class Second implements Runnable {

		public void run() {
			for (int i = 10; i > 0; i--) {
				array[i] = i;
			}
		}
	};
}
