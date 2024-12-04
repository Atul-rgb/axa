package com.hbaxa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Parameters;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIePath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
		
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	public String getEdgePath()
	{
		String edgepathpath = pro.getProperty("edgepath");
		return edgepathpath;
		
	}
	//======= For Retry Failed Test Case ==============
	
	public int retryCount()
	{
		String retryCount = pro.getProperty("retryCnt");
		int retryCnt = Integer.parseInt(retryCount);
		return retryCnt;
	}
	
	public int maxRetryCount()
	{
		String  maxRetryCount = pro.getProperty("maxRetryCnt");
		int  maxRetryCnt = Integer.parseInt(maxRetryCount);
		return  maxRetryCnt;
	}
	
	//======= For Reporting File Info ==============	
	
	public String gethostname()
	{
		String hostname = pro.getProperty("hostname");
		return hostname;
		
	}
	
	public String getenvironment()
	{
		String environment = pro.getProperty("environment");
		return environment;
		
	}
	
	public String getuser()
	{
		String user = pro.getProperty("user");
		return user;
		
	}	
	
/*	//@Parameters(value="tc_row")
	public String getCurrentRow(String row)
	{
		String currentRow = row;
		System.out.println(currentRow+"is that....");
		return currentRow;
	}*/
}
