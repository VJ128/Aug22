package com.apex.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "account-icon")
	private WebElement accntBtn;

	public void click_AccountBtn() throws Exception {
		accntBtn.click();
		Thread.sleep(1000);
	}

	@FindBy(id = "sign-in-modal-link")
	private WebElement signInBtn;

	public void click_SignInBtn() {
		signInBtn.click();
	}

	@FindBy(id = "label-email")
	private WebElement emailTxtBox;

	public void email_TxtBox(String email) {
		emailTxtBox.sendKeys(email);
	}

	@FindBy(id = "label-password")
	private WebElement passwrdTxtBox;

	public void pswrd_TxtBox(String pswrd) {
		passwrdTxtBox.sendKeys(pswrd);
	}

	@FindBy(id = "btnSignIn")
	private WebElement signIn;

	public void click_SignIn() {
		signIn.click();
	}

}
