package com.apex.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.core.SafewayConstants;
import com.apex.core.TestBase;
import com.apex.pageobjects.LoginPage;

public class Login extends TestBase implements SafewayConstants {

	String email = prop.getProperty("email");
	String pswd = prop.getProperty("password");
	LoginPage lp;

	@Test(priority = 1)
	public void validCredentials() throws Exception {
		lp = new LoginPage(driver);
		String title = "Home - Online Grocery Delivery | Safeway";
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox(email);
		lp.pswrd_TxtBox(pswd);
		lp.click_SignIn();
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Test(priority = 2)
	public void inValidEmail() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox("jijdhjsd");
		lp.pswrd_TxtBox(pswd);
		String errorMesg = driver.findElement(By.xpath(ERROR_MESSAGE1)).getText();
		Assert.assertEquals(errorMesg, "Please enter a valid email address.");
		lp.click_SignIn();
	}

	@Test(priority = 3)
	public void inValidPswd() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox(email);
		lp.pswrd_TxtBox("ewfjdsksa");
		lp.click_SignIn();
		String errorMesg = driver.findElement(By.cssSelector(".error-wrong-pwd")).getText();
		Assert.assertEquals(errorMesg,
				"The email address or password entered doesn't match our records. Please make sure your email is correct or create a new account here.");

	}

	@Test(priority = 4)
	public void invalidCredentials() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox("rtgfdzfs");
		lp.pswrd_TxtBox("regfdsz");
		String errorMesg = driver.findElement(By.xpath("//ul[@class='list-unstyled'] ")).getText();
		Assert.assertEquals(errorMesg, "Please enter a valid email address.");
		lp.click_SignIn();
	}

	@Test(priority = 5)
	public void blankEmail() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox("");
		lp.pswrd_TxtBox(pswd);
		lp.click_SignIn();
		String errorMesg = driver.findElement(By.cssSelector("div#errorMsgEmail")).getText();
		Assert.assertEquals(errorMesg, "Please enter your email address.");
	}

	@Test(priority = 6)
	public void blankPasswrd() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox(email);
		lp.pswrd_TxtBox("");
		lp.click_SignIn();
		String errorMesg = driver.findElement(By.cssSelector("div#errorMsgPwd")).getText();
		Assert.assertEquals(errorMesg, "Please enter a password.");

	}

	@Test(priority = 7)
	public void blankEmailAndBlankPswd() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox("");
		lp.pswrd_TxtBox("");
		String errorMesg1 = driver.findElement(By.cssSelector("div#errorMsgEmail")).getText();
		Assert.assertEquals(errorMesg1, "Please enter your email address.");
		lp.click_SignIn();
		String errorMesg2 = driver.findElement(By.cssSelector("div#errorMsgPwd")).getText();
		Assert.assertEquals(errorMesg2, "Please enter a password.");
	}

	@Test(priority = 8)
	public void splCharacters() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox("@#$%^&");
		lp.pswrd_TxtBox(")(*&^%$#");
		String errorMesg = driver.findElement(By.xpath("//ul[@class='list-unstyled'] ")).getText();
		Assert.assertEquals(errorMesg, "Please enter a valid email address.");
		lp.click_SignIn();
	}

	@Test(priority = 9)
	public void val_ForgotPswdPageTitle() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();

		driver.findElement(By.id("forgot-password-id")).click();
		Assert.assertEquals(driver.getTitle(), "Account Password Reset");
	}

	@Test(priority = 10)
	public void val_ForgotPswd_blankEmailMobileNo() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		driver.findElement(By.id("forgot-password-id")).click();
		driver.findElement(By.name("userName")).sendKeys("");
		driver.findElement(By.cssSelector("span.svg-forward")).click();
		String errorMesg = driver.findElement(By.xpath("//p[@class='auth-styles__input-requirements--error-state']"))
				.getText();
		Assert.assertEquals(errorMesg, "Please enter a mobile number or email address.");
	}

	int i = 0;

	@Test(invocationCount = 4, priority = 11)
	public void logInAttempts_InvalidUser() throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox("abc123@yahoo.com");
		lp.pswrd_TxtBox("jhgytufj");
		lp.click_SignIn();
		i++;
		// System.out.println(i);
		if (i == 3) {
			String errorMesg = driver.findElement(By.xpath("//span[@class='error-wrong-pwd']")).getText();
			Assert.assertEquals(errorMesg,
					"Because of multiple login attempts your account has been temporarily locked for security reasons, please try again in 1 hour.");
		}
	}

	@DataProvider(name = "validCredentials")
	public Object[][] createData1() throws Exception {
		Object[][] retObjArr = getTableArray(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xls",
				"Sheet1", "valid");
		return (retObjArr);
	}

	@Test(dataProvider = "validCredentials", priority = 12)
	public void data_Driven_Testing_ValidCredentials(String userName) throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox(userName);
		lp.pswrd_TxtBox(pswd);
		lp.click_SignIn();
	}

	@DataProvider(name = "InvalidEmail")
	public Object[][] createData2() throws Exception {
		Object[][] retObjArr = getTableArray(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xls",
				"Sheet1", "inValid");
		return (retObjArr);
	}

	@Test(dataProvider = "InvalidEmail", priority = 13)
	public void data_Driven_Testing_InValidEmail(String userName) throws Exception {
		lp = new LoginPage(driver);
		lp.click_AccountBtn();
		lp.click_SignInBtn();
		lp.email_TxtBox(userName);
		lp.pswrd_TxtBox(pswd);
		lp.click_SignIn();
	}
}
