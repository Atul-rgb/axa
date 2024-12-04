package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.ReimDCapturePage;
import com.hbaxa.pageobjects.ReimOverviewPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.ReimOverviewData;
import com.hbaxa.testdata.ReimdcaptureData;

public class TC_ReimOverviewReverseTest_001 extends BaseClass {
	String claimdetails;
	String alertmsg;
	
	ReimOverviewData ReimOverview = new ReimOverviewData();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginLevel2Test(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched");
			
			logger.info("<===== Login test started ====>");
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);
			
			rOverview.setUserName(ReimOverview.getReimReverse(currentRow,"Username")); //First parameter is current row, second is column name
			logger.info("Username Entered");
			
			rOverview.setPassWord(ReimOverview.getReimReverse(currentRow,"Password"));
			logger.info("Password Entered");
			
			rOverview.clickSubmit();
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
	public void reimOverviewReverse(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW REVERSE THROUGH MANUAL TEST STARTED ====>");
			
			//Menu Navigation =====
			Thread.sleep(1000l);
			rOverview.clickClaim();
			logger.info("Claim clicked");
			Thread.sleep(1000l);
			rOverview.clickReimbursment();
			logger.info("Reimbursment Clicked");
			Thread.sleep(1000l);
			rOverview.clickROverview();
			logger.info("Reimbursment Overview Clicked");
			
			//===============================
			//Thread.sleep(5000l); // use sleep for loader 
			rOverview.waitLoader();
			//===============================
			
			//rOverview.enterClaimNo(ReimOverview.getReimOverview(currentRow,"CLAIM NO"));
			//rOverview.enterClaimNo(TC_ReimDCTestManual_001.claimNumber);
			//logger.info("Claim No Entered");
			
			String sheetClaim = ReimOverview.getReimReverse(currentRow,"Claim Number For Reverse");
			System.out.println("Sheetclaim = "+ sheetClaim);
			
			
			if(sheetClaim == ""){
				rOverview.enterClaimNo(TC_ReimDCTestManual_001.claimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				rOverview.enterClaimNo(ReimOverview.getReimReverse(currentRow,"Claim Number For Reverse"));
				logger.info("Claim No Entered");
			}			
			
			Thread.sleep(1000l);
			rOverview.selectFirstStatus(ReimOverview.getReimReverse(currentRow,"First Status"));
			logger.info("Status Selected");
			
			Thread.sleep(1000l);
			rOverview.selectCasePickedBy(ReimOverview.getReimReverse(currentRow,"CASE PICKED BY"));
			logger.info("Case Picked by selected");	
			
			rOverview.clickGo();
			/*driver.switchTo().alert().accept();
			logger.info("Reassign the case");
			
			Thread.sleep(1000l);
			rOverview.clickGo();
			logger.info("Go Clicked");*/
			
			//===============================
			//Thread.sleep(3000l); // use sleep for loader
			rOverview.waitLoader();
			//===============================
			
			Thread.sleep(1000l);
			rOverview.clickReverse();
			logger.info("Reversed Clicked");
			
			Thread.sleep(1000l);
			rOverview.checkReverse();
			logger.info("Reverse icon Checked");
			rOverview.waitLoader();
			Thread.sleep(5000l);
			rOverview.clickReverseBtn();
			logger.info("Reverse Button Clicked - Claim Successfully Reversed");
			
			rOverview.waitLoader();
			Thread.sleep(7000l);
			rOverview.selectStatusPending(ReimOverview.getReimReverse(currentRow,"Second Status"));
			logger.info("Pending Status selected");
			rOverview.waitLoader();
			rOverview.clickSearchAgain();
			logger.info("Searched Clicked");
			
			//Thread.sleep(1000l);
			//rOverview.selectCasePickedBy(ReimOverview.getReimReverse(currentRow,"CASE PICKED BY"));
			//logger.info("Case Picked by selected");
			
			
			if(sheetClaim == ""){
				rOverview.enterClaimNo(TC_ReimDCTestManual_001.claimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				rOverview.enterClaimNo(ReimOverview.getReimReverse(currentRow,"Claim Number For Reverse"));
				logger.info("Claim No Entered");
			}			
			
			
			//Thread.sleep(1000l);
			//rOverview.clickSearchAgain();
			//logger.info("Searched Clicked");			
			
			//===============================
			//Thread.sleep(30000l); // use sleep for loader
			rOverview.waitLoader();
			//===============================				
			
			captureScreen(driver, row+"_Success_reimOverviewReverse");
			logger.info("====> REIMBURSMENT OVERVIEW REVERSE THROUGH MANUAL TEST PASSED <====");
			
			if(ReimOverview.getReimReverse(currentRow,"Calculation").equalsIgnoreCase("Yes")){
				
				rOverview.clickProceed();
				logger.info("Proceed clicked after reverse");
				
				//===============================
				//Thread.sleep(5000l); // use sleep for loader
				rOverview.waitLoader();
				//===============================
				
				//SWITCH TO NEXT TAB
				ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab1.get(1));
				
				//===============================
				//Thread.sleep(25000l); // use sleep for loader
				rOverview.waitLoader();
				//===============================					
				
				rOverview.gotoClaimStatus();
				logger.info("Go To Claim Status");
				
				String claimStatus = ReimOverview.getReimReverse(currentRow,"ClaimStatus");
				rOverview.selectClaimStatus(claimStatus);
				logger.info("Claim Status Selected - "+claimStatus);
				
				rOverview.gotoRejectReasonbtn();
				logger.info("Move to Reject Reason Remarks Area");
				
				rOverview.clickRejectReasonbtn();
				logger.info("Reject Reason Btn Clicked");
				
				//rOverview.enterRejectReasonCode(ReimOverview.getReimReverse(currentRow,"Reject Remarks"));
				//logger.info("Reject reason code entered");
				
				//rOverview.clickSearch();
				//logger.info("Search Button clicked");
				
				rOverview.checkOptions();
				logger.info("Reject option checked");
				
				rOverview.clickSaveRejectRemarks();
				logger.info("Save clicked on reject remarks");

				rOverview.clickUpdateStatus();
				logger.info("Update Status clicked with reject option");
				
				// PAGE REDIRECTED TO VIEW PAGE
				if(sheetClaim == ""){
					
					rOverview.verify_claimno(TC_ReimDCTestManual_001.claimNumber);
					logger.info("Claim no verified on claim view page.");
					
				}else
				{
					rOverview.verify_claimno(ReimOverview.getReimReverse(currentRow,"Claim Number For Reverse"));
					logger.info("Claim no verified on claim view page.");
				}
				
				//rOverview.verify_claimno(TC_ReimDCTestManual_001.claimNumber);
				//logger.info("Claim no verified on claim view page.");
		
			}
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_reimOverviewReverse");			
			logger.info("====> REIMBURSMENT OVERVIEW REVERSE TEST THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}
	
	
			
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "reimOverviewReverse" })
	public void logoutLevel2Test(String row) throws IOException, InterruptedException
	{
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			rOverview.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			//rOverview.clickLogOut();
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
