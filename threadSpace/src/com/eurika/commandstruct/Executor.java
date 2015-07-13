package com.eurika.commandstruct;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Executor extends Thread {
	
	private TestCommand command = null;
	public TestCommand getCommand() {
		return command;
	}
	public void setCommand(TestCommand command) {
		this.command = command;
	}

	private ArrayBlockingQueue<Runnable> arrayTaskQueue = null;
	
	private void exeWithoutReturn() {
		if(command == null) {
			System.out.println("No Executor --Thread Pool is empty....");
			return;
		}
		arrayTaskQueue = (ArrayBlockingQueue<Runnable>) command.getCmdQueue();
		ThreadPoolExecutor threadPoolExe = command.getThreadPool();
		
		while(true) {
			Runnable task = arrayTaskQueue.poll();
			
			if(task != null) {
				threadPoolExe.execute(task);
				System.out.println("arrayTaskQueue.size():" + arrayTaskQueue.size());
			}
			
			System.out.println("threadPoolExe.getActiveCount():" + threadPoolExe.getActiveCount());
			System.out.println("threadPoolExe.isTerminated():"+ threadPoolExe.isTerminated());
			System.out.println("threadPoolExe.getCompletedTaskCount():"+ threadPoolExe.getCompletedTaskCount());
			if(threadPoolExe.getActiveCount() ==0) {
				break;
			}
		}
		
		System.out.println("---------------shut down-------------");
		threadPoolExe.shutdown();
	}
	
	private boolean needToBeShutdown() {
		return false;
	}
	
	public void run() {
		exeWithoutReturn();
	}

	
}
