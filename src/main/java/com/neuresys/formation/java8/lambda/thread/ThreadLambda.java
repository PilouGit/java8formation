package com.neuresys.formation.java8.lambda.thread;

public class ThreadLambda {

	public static void main(String [] args)
	{
		Thread t=new Thread(new Runnable() {

			@Override
			public void run() {
				
			}
			
		});
		t.start();
		Thread t2=new Thread(()->{
			
		});
	}
}
