package com.neuresys.formation.java8.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestFuture {
	Integer maValeur;
	public  void test()
	{
		Thread t=new Thread(()->
		{
			TestFuture.this.maValeur=3;
		});
		
		
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		try {
			
			Integer entier=future.get();//appel bloquant
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String [] args)
	{
		(new TestFuture()).test();
	}
}
