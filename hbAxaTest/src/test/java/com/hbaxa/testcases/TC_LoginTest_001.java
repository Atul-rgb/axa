package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.testdata.LoginData;

public class TC_LoginTest_001 extends BaseClass {
	
	LoginData ldread = new LoginData();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginTest(String row) throws IOException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			logger.info("Base url launched");
			
			logger.info("Login test started");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setUserName(ldread.getUsername(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			lp.setPassWord(ldread.getPassword(currentRow,"Password"));
			logger.info("Password Entered");
			
			lp.clickSubmit();
			logger.info("Submit Button Clicked");
			
			if(driver.getTitle().equals("Home Page"))
			{
				Assert.assertTrue(true);
				logger.info("Login Test Pass");
				//captureScreen(driver, currentRow+"_Success_loginTest");
				captureScreen(driver, row+"_Success_loginTest");
			}
			else
			{
				logger.info("Login Test Fail");
				//first para is driver, second is test name.
				//captureScreen(driver,currentRow+"_loginTest");
				captureScreen(driver,row+"_loginTest");
				Assert.assertTrue(false);
	
			}
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginTest" })
	public void logoutTest(String row) throws IOException, InterruptedException
	{
			LoginPage lp = new LoginPage(driver);
			logger.info("Logout Test Started");
			lp.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			lp.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("LogOut Test Pass");
				//captureScreen(driver,row+"_Success_logoutTest");
				captureScreen(driver,row+"_Success_logoutTest");
			}
			else
			{
				logger.info("LogOut Test Fail");
				//first parameter is driver, second is test name.
				//captureScreen(driver,row+"_logoutTest");
				captureScreen(driver,row+"_logoutTest");
				Assert.assertTrue(false);
			}		
	}

}
