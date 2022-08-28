package com.qa.testngdemo;

import org.testng.annotations.Test;

public class Groups {

	@Test( groups = "Smoke")
	public void test1() {
		System.out.println("Smoke");
	}

	@Test( groups = "Regression")
	public void test2() {
		System.out.println("Regression");
	}

	@Test(groups = "Regression")
	public void test3() {
		System.out.println("Regression");
	}

	@Test(groups = "Functional")
	public void test4() {
		System.out.println("Functional");
	}
	
	@Test(groups = "Regression")
	public void test5() {
		System.out.println("Regression");
	}

}
