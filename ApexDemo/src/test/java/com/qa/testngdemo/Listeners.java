package com.qa.testngdemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{  
public void onTestStart(ITestResult result) {  
}  
  
public void onTestSuccess(ITestResult result) {  
 
System.out.println("Success of test cases and its details are : "+result.getName());  
}  
  
public void onTestFailure(ITestResult result) {  
 
System.out.println("Failure of test cases and its details are : "+result.getName());  
}  
  
public void onTestSkipped(ITestResult result) {  
 
System.out.println("Skip of test cases and its details are : "+result.getName());  
}  
  
  
public void onStart(ITestContext context) {  
// TODO Auto-generated method stub  
}  
  
public void onFinish(ITestContext context) {  
// TODO Auto-generated method stub  
}}  