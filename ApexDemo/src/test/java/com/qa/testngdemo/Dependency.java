package com.qa.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency {
	public class Login {
		@Test
		public void login() {
			 Assert.assertTrue(false);
			//Assert.assertTrue(true);
			System.out.println("Login");
		}

		@Test(dependsOnMethods = "login")
		public void home() {
			System.out.println("Home page");

		}
	}

}
