package com.eurika.commandstruct;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestControllor {

	private static ThreadPoolExecutor threadPoolExc = null;
	
	private void init() {
		threadPoolExc = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void test() {
		threadPoolExc.execute(null);
	}
	
}
