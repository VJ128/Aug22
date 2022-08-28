package com.qa.testngdemo;

import org.testng.annotations.Test;

public class TimeOutInvocationCount {
	
	@Test(timeOut=100)
	public void timeOut() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Time Out");
	}
	
	@Test(invocationCount=2)
	public void invocationCount() throws InterruptedException {
			System.out.println("invocationCount");
	}

}
