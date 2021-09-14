package com.BankingFramework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BankingFramework.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws InterruptedException, IOException {

		logger.info("URL is opened");
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		logger.info("username is set");
		login.setPassword(password);
		logger.info("password is set");
		login.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test case is passed");
		} else {
			capturescreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Test case is failed");
		}
	}
}
