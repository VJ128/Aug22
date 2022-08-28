package com.qa.testngdemo;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {

	@DataProvider(name = "DP1")
	public Object[][] dp() {
		return new Object[][] { { "Dan" }, { "Ashley" }, { "John" } };
	}

	@Test(dataProvider = "DP1")
	public void test(String name) {
		System.out.println(name);
	}

	@DataProvider()
	public Object[][] dp1() {
		return new Object[][] { { "ZZZ" }, { "XXX" }, { "YYY" } };
	}

	@Test(dataProvider = "dp1")
	public void test1(String name) {
		Reporter.log(name, true);
	}

}
