package com.qa.testngdemo;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipExcption {

	@Test
	public void testSkipExcption() {
		String cond = "skip test";
		if (cond.equals("skip test")) {
			throw new SkipException("This tc is skipped");
		}
	}
}
