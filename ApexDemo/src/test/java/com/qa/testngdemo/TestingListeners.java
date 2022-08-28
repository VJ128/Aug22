package com.qa.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qa.testngdemo.Listeners.class)
public class TestingListeners 
{  
    
	 @Test(priority=1)
	 public void success()  
	 {  
	     Assert.assertTrue(true);  
	 }  
	 @Test(priority=2)
	 public void fail()  
	 {  
	     Assert.assertTrue(false);  
	 }  
	  
	}  
