package com.qa.testngdemo;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertHardAssert {

	SoftAssert softAssert= new SoftAssert();
	
	@Test
	public void softAssert() {
		softAssert.assertTrue(false);
		System.out.println("In SA, code is excuted");
		softAssert.assertAll();
	}
	@Test()
	public void HardAssert() {
		Assert.assertTrue(false);
		System.out.println("In HA, code is not excuted");
	}
}
