package com.apex.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.apex.core.TestBase;

public class Registration extends TestBase {

	@Test
	public void valid_Credentials() throws Exception {
		driver.findElement(By.className("account-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#creat-account-modal-link")).click();
		driver.findElement(By.id("input-firstName")).sendKeys("Ashley");
		driver.findElement(By.id("input-lastName")).sendKeys("Hamilton");
		driver.findElement(By.id("input-email")).sendKeys("ashleymathews2050@gmail.com");
		driver.findElement(By.id("showPass")).sendKeys("AshleyMathews2050");
		driver.findElement(By.id("input-clubCardNumber")).sendKeys("4087914451");
		WebElement chkBox=driver.findElement(By.className("checkmark"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", chkBox);
		driver.findElement(By.id("cookieConsentClose")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("create-account-btn-unified")).click();
	}
}
