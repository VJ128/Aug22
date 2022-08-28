package com.qa.testngdemo;

import org.testng.annotations.Test;

public class ExpectedException {

	@Test(expectedExceptions = ArithmeticException.class)
	public void test() {
		System.out.println("testing exceptions in testNG");
		int i = 1 / 0;
	}

}
