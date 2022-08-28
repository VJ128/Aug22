package com.qa.testngdemo;

import org.testng.annotations.Test;
//priority, disable
public class PriorityDisable {

	@Test(priority = 5,enabled=false)
	public void test1() {
		System.out.println("5");
	}

	@Test(priority = 4)
	public void test2() {
		System.out.println("4");
	}

	@Test(priority = 2)
	public void test3() {
		System.out.println("2");
	}

	@Test(priority = 1)
	public void test4() {
		System.out.println("1");
	}
	
	@Test(priority = 3)
	public void test5() {
		System.out.println("3");
	}

}
