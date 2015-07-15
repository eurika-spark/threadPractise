package com.eurika.commandstruct;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestCommand  {

	private static ThreadPoolExecutor threadPool = null;
	public ThreadPoolExecutor getThreadPool() {
		return threadPool;
	}
	private static ArrayBlockingQueue<Runnable>  cmdBlkQueue = null;
	
	public TestCommand() {
		this(10, 20);
	}
	public TestCommand(int threadCapacity, int queueCapacity) {
		cmdBlkQueue = new ArrayBlockingQueue<Runnable>(queueCapacity);
		if(threadPool == null) {
			threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCapacity);
		}
	}
	
	public boolean addCmd(Runnable cmd) {
		//  if it is possible to do so immediately without exceeding the 
		//  queue's capacity, returning true upon success and throwing an IllegalStateException if this queue is full.
		//	return cmdBlkQueue.add(cmd);
		try {
			// waiting for space to become available if the queue is full.
			cmdBlkQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Queue<Runnable> getCmdQueue() {
		return cmdBlkQueue;
	}
	
	// TODO Test  
	public static void main(String[] args) {
		TestCommand command = new TestCommand(3, 4);
		for(int i=0; i< 3; i++) {
			command.addCmd(new Runnable() {
				@Override
				public void run() {
					System.out.println("this thread BEFORE add......");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		Executor exe = new Executor();
		exe.setCommand(command);
		exe.start();
		
		for(int i=0; i< 5; i++) {
			command.addCmd(new Runnable() {
				@Override
				public void run() {
					System.out.println("this thread AFTER add----------------");
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public void execute() {
	}
}