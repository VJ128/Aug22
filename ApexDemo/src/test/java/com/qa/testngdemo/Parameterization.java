package com.qa.testngdemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	@Parameters({"val1","val2"})
	@Test
	public void param_Testing(int num1,int num2) {
		int sum=num1+num2;
		System.out.println("Sum of two numbers is--> "+sum);
	}

}
