package com.BankingFramework.pageObjects;

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

	@FindBy(id = "details-button")
	WebElement Advanced;

	@FindBy(id = "proceed-link")
	WebElement proceed;

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement btnLogout;
	
	public void setUserName(String username) throws InterruptedException {
		Thread.sleep(3000);
		
//		Advanced.click();
//		proceed.click();
		
		txtUserName.sendKeys(username);
		
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);

	}

	public void clickSubmit() throws InterruptedException {
		btnLogin.click();
	}
	public void clickLogout()
	{
		btnLogout.click();
	}
}
