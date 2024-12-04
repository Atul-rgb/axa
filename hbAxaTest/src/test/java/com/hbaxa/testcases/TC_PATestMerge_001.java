package com.hbaxa.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.PAListPage;
import com.hbaxa.pageobjects.PAPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.PAData;

public class TC_PATestMerge_001 extends BaseClass  {
	String parent;
	String child;
	String paNdetails;
	String toppaNdetails;
	String paNumber;
	String actions;
	String alertsApprovedClick;
	
	PAData paread = new PAData();
	LoginData ldread = new LoginData();
	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void paTestMerge(String row) throws IOException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);		
			
			PAPage pa = new PAPage(driver);
			
			//Login Scenario
			logger.info("<==== PA TEST MERGE STARTED THROUGH DOCID ====>");
			
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
			
			//================ NAVIGATE TO INDEXING
			Thread.sleep(1000l);
			pa.clickClaimmenu();
			logger.info("Claim Menu Clicked");
			
			Thread.sleep(1000l);
			pa.clickPalink();
			logger.info("Pre-Approval Clicked");
			
			Thread.sleep(1000l);
			pa.clickIndexinglink();
			logger.info("Indexing Clicked");
			
			//===========================================
			//Thread.sleep(30000l); // for loader if any
			//===========================================
			//pa.waitTillLoader();
			pa.waitLoader();
			//===========================================
			pa.clickAdvanceSerach();
			logger.info("Advanced Option Clicked");
			
			pa.enterDocID(paread.getpamergedata(currentRow, "DocId"));
			logger.info("Document ID Entered");
			
			pa.clickSearch();
			logger.info("Search Button Clicked");
			
			pa.verifyDocId(paread.getpamergedata(currentRow, "DocId"));
			logger.info("Document Id Verified");
			
			Thread.sleep(3000l);
			pa.clickProceed();
			logger.info("Proceed Options Clicked");
		
			//===========================================
			//Thread.sleep(10000l); // for loader if any
			//pa.waitTillLoader();
			pa.waitLoader();
			//==========================
			//pa.clickShowhide();
			//logger.info("Show/Hide Document Button Clicked");
			
			pa.setSearchPolicy(paread.getpamergedata(currentRow, "SearchPolicy"));
			logger.info("Policy Number Entered");
			
			pa.selectPolicy(row);
			logger.info("Policy Selected");
			
			//===========================================
			//Thread.sleep(15000l); // for loader if any
			pa.waitLoader();
			//===========================================			
			
			pa.clickPreApprovalHistory();
			logger.info("Pre Approval History Tab Clicked");

			pa.clickViewMore();
			logger.info("View More Options Clicked");
			
			pa.selectPreApprovalStatus(paread.getpamergedata(currentRow, "Pre-Approval Status"));
			logger.info("Pre-Approval Status Selected");
			
			pa.getClaimNumber(paread.getpamergedata(currentRow, "Pending PA"));
			logger.info("Get Claim Number(PANumber)");
			
			pa.verifyPANumber(paread.getpamergedata(currentRow, "Pending PA"));
			logger.info("PA Number Verified");
			
			pa.clickMerge();
			logger.info("Merge Clicked...");
			
			
			//pa.waitTillLoader();
			//Thread.sleep(30000l); // for loader if any
			pa.waitLoader();
			//===========================================
			
			pa.saveButton();
			logger.info("Save Button Clicked");
			
			paNdetails = pa.getpaNotification();
			logger.info("Success: "+ paNdetails);
			
			//===============
			//Thread.sleep(20000l); // for loader if any
			pa.waitLoader();
			//===============
			if (paNdetails.equalsIgnoreCase("Case has been updated")) {
				
				toppaNdetails = pa.moveToTop();
				logger.info("Success: "+ toppaNdetails);

			} else {
				
				pa.getNoTOStay();
				logger.info("No Clicked...");
			}
			
			//===============
			//Thread.sleep(25000l);
			//===============
			//if (paNdetails.equalsIgnoreCase("Case has been updated")) {
			//	pa.clickShowhide2();
			//	logger.info("Show/Hide Document Button Clicked");
			//}
			
			//===============
			//Thread.sleep(25000l); // for loader if any
			pa.waitLoader();
			//===============

			pa.clickautoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			//===============
			//Thread.sleep(20000l); // for loader if any
			pa.waitLoader();
			//================
			
			pa.gotoPreApprovalResult();
			logger.info("Go To Pre Approval Result");
			captureScreen(driver,row+"_Success_paTestMerge");
			logger.info("Screenshot captured of Pre Approval Result");
			
			//===============
			//Thread.sleep(10000l); // for loader if any
			//pa.waitLoader(); // uncomment if required
			//===============
			
			//========== Move To Pre Approval Details FOR LOG AMOUNT ===================================
			
			if (paread.getpamergedata(currentRow, "Log Amount").equals("Yes")) {

				Thread.sleep(4000l);
				pa.scrolltopad();
				logger.info("Scroll To Pre Approval Details");
				
				Thread.sleep(2000l);
				pa.chekLogAmount();
				logger.info("Logged Amount Checked");
				
				Thread.sleep(2000l);
				pa.enterLogAmount(paread.getpamergedata(currentRow, "Log Amount if empty"));
				logger.info("Log Amount Entered");
				
			}			
			
			//===============
			//Thread.sleep(20000l); // for loader if required
			//pa.waitLoader(); //uncomment if required
			//===============			

			Thread.sleep(3000l);
			if(paread.getpamergedata(currentRow, "Approve").equalsIgnoreCase("Yes")){
				
				pa.clickApprove();
				logger.info("Approve Clicked...");
				
				if(paread.getpamergedata(currentRow, "Log Amount").equalsIgnoreCase("No"))
				{
					System.out.println("if value = " +paread.getpamergedata(currentRow, "Log Amount"));
					
					actions = "Approve";
					
					pa.clickReasonForApprove();
					logger.info("Reason For Approved List Clicked");
					
					pa.selectReasonForApprove(row);
					logger.info("Option Selected for Reason For Approve");
					
					pa.clickSubmitReasonForApprove();
					logger.info("Submit Clicked of Reason For Approve");
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l);
					//===================
					
					//pa.clickBackToApprove();
					//logger.info("Back TO Approve Clicked...");					


				}else{
					
					System.out.println("Else value = " +paread.getpamergedata(currentRow, "Log Amount"));
					
					actions = "Approve";
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l);
					//===================
					
					//pa.clickBackToApprove(); // comment because proceed with chopping at below
					//logger.info("Back TO Approve Clicked...");
				
				}

			}
			
			
			logger.info("==> Process Complete of Merge(Generate PA No.), auto-audjudicate, and "+actions+" <==");
			
			
			//==================
			//Thread.sleep(30000l); //wait for loader if any
			pa.waitLoader();
			//==================
			
			pa.clickChopping();
			logger.info("Chopping Clicked");
			
			//============================================
			Set <String> st= driver.getWindowHandles();
			Iterator<String> it = st.iterator();
			parent =  it.next();
			child = it.next();
			
			// switch to child tab(Chopping Page)
			driver.switchTo().window(child);
			logger.info("Redirected to Chopping Page");
			//===========================================
			
		} catch (Exception e) {
			

			logger.info("====> PA TEST MERGE FAILED THROUGH DOCID <====");
			captureScreen(driver, row+"_paTestMerge");// first para is driver,
													// second is test name.
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			driver.switchTo().window(parent);
			Assert.assertTrue(false);

		}
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "paTestMerge" })
	public void paChoppingDocMerge(String row) throws Exception
	{
		try {
			
			logger.info("<==== Merge Document Chopping Started ====>");
			PAPage pa = new PAPage(driver);
			
			pa.waitTillDocLoad();
			logger.info("Document Loaded For Chopping");
			
			//Thread.sleep(10000l); // for loader if any
			pa.waitLoader();
			
			pa.performChopping();
			logger.info("Chopping Performed");

			pa.deleteChopping();
			logger.info("One Chopping Has Been Deleted");
			
			pa.clicksaveChopping();
			logger.info("Save Options Clicked After Chopping Process");
			
			Thread.sleep(4000l);
			captureScreen(driver,row+"_Success_paChoppingDocMerge");
			logger.info("Screenshots captured for Chopping Document");			
			logger.info("==> Document Chopping process completed <==");
			
		} catch (InterruptedException e) {
			

			logger.info("<==== Merge Document Chopping Failed ====>");
			captureScreen(driver, row+"_paChoppingDocMerge");
			
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
		}
		
	}

}
