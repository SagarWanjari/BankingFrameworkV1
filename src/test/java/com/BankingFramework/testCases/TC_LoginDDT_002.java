package com.BankingFramework.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BankingFramework.pageObjects.LoginPage;
import com.BankingFramework.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username has been set");
		lp.setPassword(pwd);
		logger.info("Password has been set");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent())
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login Successful");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/BankingFramework/testData/LoginData.xlsx";
		
		int rowCount=XLUtils.getRowCount(path, "sheet1");
		int colCount=XLUtils.getCellCount(path,"sheet1", rowCount);
		String loginData[][]=new String [rowCount][colCount];
		for(int i=1;i<rowCount;i++)
		{
			for(int k=0;k<colCount;k++)
			{
				loginData[i-1][k]=XLUtils.getCellData(path, "sheet1", i, k);
			}
		}
		return loginData;
	}
}
