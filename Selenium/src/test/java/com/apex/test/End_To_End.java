package com.apex.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.core.TestBase;
import com.apex.pageobjects.LoginPage;

public class End_To_End extends TestBase {
	String email = prop.getProperty("email");
	String pswd = prop.getProperty("password");
	LoginPage lp;

	@Test
	public void endToEndOrder() throws Exception {
		lp = new LoginPage(driver);
		driver.findElement(By.id("cookieConsentClose")).click();
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		lp.email_TxtBox(email);
		Thread.sleep(500);
		lp.pswrd_TxtBox(pswd);
		lp.click_SignIn();

		Thread.sleep(2000);
		driver.findElement(By.id("skip-main-content")).click();
		List<WebElement> prodList = driver.findElements(By.cssSelector("li.search-suggestion"));
		prodList.get(2).click();
		Thread.sleep(1000);
		List<WebElement> prodReqList = driver.findElements(By.cssSelector(".product-title__name"));
		String str = prodReqList.get(1).getAttribute("id").substring(2);

		Thread.sleep(3000);
		try {
			if (driver.findElement(By.xpath("//div[contains(@id,'addButton_" + str + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//div[contains(@id,'addButton_" + str + "')]")).click();
			}
		} catch (Exception e) {
			driver.findElement(By.xpath("(//button[contains(@id,'" + str + "')]/span)[2]")).click();

		}
		driver.findElement(By.cssSelector(".svg-icon-Cart-red")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("modal-checkout-enabled")).click();

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// driver.findElement(By.cssSelector("img.tooltip-link")).click();
		List<WebElement> datesList = driver.findElements(By.xpath("//span[@class='date-year-text']"));
		for (WebElement element : datesList) {
			String date1 = "Aug 28";
			if (element.getText().equals(date1)) {
				element.click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='time-label automateSlotIdlabel']/span[@id='slot-time1']")).click();
		driver.findElement(By.id("reserveSlotsContinue")).click();

		String emailAtChkOut = driver.findElement(By.id("contactEmail")).getAttribute("value");
		Assert.assertEquals(emailAtChkOut, email);
		Assert.assertEquals(driver.getTitle(), "Checkout");

	}
}