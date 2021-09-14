package com.BankingFramework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BankingFramework.pageObjects.AddCustomerPage;
import com.BankingFramework.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username has eneterd");
		lp.setPassword(password);
		logger.info("password has entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.CustName("Sagar");
		logger.info("customer name is eneterd");
		addcust.custgender("Female");
		logger.info("customer gender selected");
		addcust.custdob("10","15","1985");
		logger.info("customer date selected");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		logger.info("customer address selected");
		addcust.custcity("HYD");
		logger.info("customer city selected");
		addcust.custstate("AP");
		logger.info("customer state selected");
		addcust.custpinno("5000074");
		logger.info("customer pin selected");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			
			logger.info("test case failed....");
			capturescreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	
	}
}
