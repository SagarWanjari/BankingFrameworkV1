package com.BankingFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
	
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fi=new FileInputStream(src);
			pro=new Properties();
			pro.load(fi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Exception is"+e.getMessage());
		} }
		
	public String getbaseURL()
	{
		return pro.getProperty("baseURL");
	}	
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	public String getChromepath()
	{
		return pro.getProperty("chromepath");
	}
	public String getFirefoxpath()
	{
		return pro.getProperty("firefoxpath");
	}

}
