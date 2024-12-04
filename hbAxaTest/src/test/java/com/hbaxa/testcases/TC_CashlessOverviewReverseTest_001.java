package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.CashlessOverviewPage;
import com.hbaxa.testdata.CashlessOverviewData;

public class TC_CashlessOverviewReverseTest_001 extends BaseClass {
	String claimdetails;
	String alertmsg;
	
	CashlessOverviewData CashlessOverview = new CashlessOverviewData();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginLevel2Test(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched");
			
			logger.info("<===== Login test started ====>");
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);
			
			cashlessOverview.setUserName(CashlessOverview.getCashlessReverse(currentRow,"Username")); //First parameter is current row, second is column name
			logger.info("Username Entered");
			
			cashlessOverview.setPassWord(CashlessOverview.getCashlessReverse(currentRow,"Password"));
			logger.info("Password Entered");
			
			cashlessOverview.clickSubmit();
			logger.info("Submit Button Clicked");
			
			if(driver.getTitle().equals("Home Page"))
			{
				Assert.assertTrue(true);
				logger.info("====> Login Test Pass <====");

				Thread.sleep(3000l);
				captureScreen(driver, row+"_Success_loginLevel2Test");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("Login Test Fail");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_loginLevel2Test");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
	
			}
		
	}
	

	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginLevel2Test" })
	public void cashlessOverviewReverse(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW REVERSE THROUGH MANUAL TEST STARTED ====>");
			
			//Menu Navigation =====
			Thread.sleep(1000l);
			cashlessOverview.clickClaim();
			logger.info("Claim clicked");
			Thread.sleep(1000l);
			cashlessOverview.clickCashlessClaim();
			logger.info("Cashless Claim Clicked");
			Thread.sleep(1000l);
			cashlessOverview.clickCOverview();
			logger.info("Cashless Overview Clicked");
			
			//===============================
			//Thread.sleep(5000l); // use sleep for loader 
			cashlessOverview.waitLoader();
			//===============================
			
	
			String sheetClaim = CashlessOverview.getCashlessReverse(currentRow,"Claim Number For Reverse");
			System.out.println("Sheetclaim = "+ sheetClaim);
			
			
			if(sheetClaim == ""){
				cashlessOverview.enterClaimNo(TC_CashLessDCTestManual_001.claimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				cashlessOverview.enterClaimNo(CashlessOverview.getCashlessReverse(currentRow,"Claim Number For Reverse"));
				logger.info("Claim No Entered");
			}			
			
			Thread.sleep(1000l);
			cashlessOverview.selectFirstStatus(CashlessOverview.getCashlessReverse(currentRow,"First Status"));
			logger.info("Status Selected");
			
			Thread.sleep(1000l);
			cashlessOverview.selectCasePickedBy(CashlessOverview.getCashlessReverse(currentRow,"CASE PICKED BY"));
			logger.info("Case Picked by selected");			
			
			Thread.sleep(1000l);
			cashlessOverview.clickGo();
			logger.info("Go Clicked");
			
			//===============================
			//Thread.sleep(3000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================
			
			Thread.sleep(1000l);
			cashlessOverview.clickReverse();
			logger.info("Reversed Clicked");
			
			Thread.sleep(1000l);
			cashlessOverview.checkReverse();
			logger.info("Reverse icon Checked");
			
			Thread.sleep(1000l);
			cashlessOverview.clickReverseBtn();
			logger.info("Reverse Button Clicked - Claim Successfully Reversed");
			
			cashlessOverview.waitLoader();
			Thread.sleep(5000l);
			cashlessOverview.selectStatusPending(CashlessOverview.getCashlessReverse(currentRow,"Second Status"));
			logger.info("Pending Status selected");
			
			//Thread.sleep(1000l);
			//cashlessOverview.selectCasePickedBy(CashlessOverview.getCashlessReverse(currentRow,"CASE PICKED BY"));
			//logger.info("Case Picked by selected");
			
			
			if(sheetClaim == ""){
				cashlessOverview.enterClaimNo(TC_CashLessDCTestManual_001.claimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				cashlessOverview.enterClaimNo(CashlessOverview.getCashlessReverse(currentRow,"Claim Number For Reverse"));
				logger.info("Claim No Entered");
			}			
			
			
			Thread.sleep(3000l);
			cashlessOverview.clickSearchAgain();
			logger.info("Searched Clicked");			
			
			//===============================
			//Thread.sleep(30000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================				
			
			captureScreen(driver, row+"_Success_cashlessOverviewReverse");
			logger.info("====> CASHLESS OVERVIEW REVERSE THROUGH MANUAL TEST PASSED <====");
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOverviewReverse");			
			logger.info("====> CASHLESS OVERVIEW REVERSE TEST THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}
	
	
			
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "cashlessOverviewReverse" })
	public void logoutLevel2Test(String row) throws IOException, InterruptedException
	{
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			cashlessOverview.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			//cashlessOverview.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutLevel2Test");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				
				captureScreen(driver,row+"_logoutLevel2Test");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
			
			driver.close();
	}

}
