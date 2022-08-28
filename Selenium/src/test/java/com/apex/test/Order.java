package com.apex.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.apex.core.TestBase;
import com.apex.pageobjects.LoginPage;

public class Order extends TestBase {
	String email = prop.getProperty("email");
	String pswd = prop.getProperty("password");
	LoginPage lp;
	int j = 0;

	@Test
	public void checkout_Items() throws InterruptedException {
		lp = new LoginPage(driver);
		// Smartwater 12 - 33.8 fl oz , Bertolli Olive Oil Extra Virgin - 1.5 Liter
		String itemsToOrder[] = { "Smartwater", "Bertolli Olive Oil" };
		String idsArray[] = new String[itemsToOrder.length];
		driver.findElement(By.id("cookieConsentClose")).click();
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		lp.email_TxtBox(email);
		lp.pswrd_TxtBox(pswd);
		lp.click_SignIn();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".menu-nav__red-caret-down")).click();// Shop dropdown
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[aria-label='Deals']")).click();// deals
		Thread.sleep(5000);
		driver.navigate().refresh();
		List<WebElement> dealsList = driver.findElements(By.cssSelector(".product-title"));
		System.out.println(dealsList.size());

		for (int i = 0; i < itemsToOrder.length; i++) {
			for (WebElement element : dealsList) {

				if (element.getText().contains(itemsToOrder[i])) {
					j = dealsList.indexOf(element);
					System.out.println(element.getText());
					idsArray[i] = dealsList.get(j).getAttribute("id").substring(2);
					driver.findElement(By.id("addButton_" + idsArray[i])).click();
					System.out.println("id is " + idsArray[i]);
				}if(i==itemsToOrder.length) {break;}
			}
		}
	}

}
