package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.PAListPage;
import com.hbaxa.pageobjects.PAPage;
import com.hbaxa.pageobjects.PreApproval_PA_List_Page;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.PAData;

public class TC_PATestAdjustment_001 extends BaseClass  {
	String parent;
	String child;
	String paNdetails;
	String actions;
	String AlertMessage;	
	
	PAData paread = new PAData();
	LoginData ldread = new LoginData();
	
	

	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void paTestAdjustment(String row) throws IOException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);		
			
			PAPage pa = new PAPage(driver);
			
			//Login Scenario
			logger.info("<===== PA TEST STARTED THROUGH ADJUSTMENT PROCESS ====>");
			
			driver.get(baseURL);
			logger.info("Base url launched");
			
			logger.info("Login test started");
			
			LoginPage lp = new LoginPage(driver);
			PAListPage palistp = new PAListPage(driver);
			
			lp.setUserName(ldread.getUsername(currentRow,"Username")); //First parameter is current row, second is column name
			logger.info("Username Entered");
			
			lp.setPassWord(ldread.getPassword(currentRow,"Password"));
			logger.info("Password Entered");
			
			lp.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//=============================================================
			Thread.sleep(1000l);
			pa.clickClaimmenu();
			logger.info("Claim Menu Clicked");
			
			Thread.sleep(1000l);
			pa.clickPalink();
			logger.info("Pre-Approval Clicked");
			
			Thread.sleep(1000l);
			palistp.clickPAList();
			logger.info("PA List Link Clicked");
			
			//===========================================
			//Thread.sleep(20000l); // for loader if any
			pa.waitLoader();
			//===========================================
			//pa.waitTillLoader();
			//===========================================
			
			pa.clickAdvanceSerach();
			logger.info("Advanced Option Clicked");
			
			// ==========================================================
			Thread.sleep(4000l);
			String sheetPA = paread.getPaAdjustment(currentRow, "PANo For Adjustment");
			System.out.println("sheetPA = "+ sheetPA);
			
			
			if(sheetPA == ""){
			//	palistp.txtPaNum(TC_PATest_001.paNumber);
				palistp.txtPaNum(TC_PATest_001_new_TC.paNumber);
				logger.info("PA No Entered");
				
			}else
			{
				palistp.txtPaNum(paread.getPaAdjustment(currentRow, "PANo For Adjustment"));
				logger.info("PA No Entered");
			}			
			
			
			// ========================================================
			
			//palistp.txtPaNum(paread.getPaAdjustment(currentRow, "PANo For Adjustment"));
			//logger.info("PA Number Entered");
			
			palistp.selectPaType(paread.getPaAdjustment(currentRow, "PA Type"));
			logger.info("PA Type Selected");			
			
			Thread.sleep(4000l);
			palistp.clickGO();
			logger.info("Go Clicked for PA Search");
			
			//Thread.sleep(2000l); // for loader if any
			palistp.waitLoader();
			//=============================NEW Code=============================
			//===
			
			
			palistp.clickAdjustment();
			logger.info("Adjustment icon clicked");
			
			//======= Wait For FUll Page Load ===========
			//pa.waitTillLoader();
			//===========================================
			//Thread.sleep(30000l); // for loader if any
			pa.waitLoader();
			//===========================================				
			
			//========== Move To Pre Approval Details ===================================
			
			if (paread.getPaAdjustment(currentRow, "Log Amount").equals("Yes")) {

				Thread.sleep(4000l);
				pa.scrolltopad();
				logger.info("Scroll To Pre Approval Details");
				
				pa.chekLogAmount();
				logger.info("Logged Amount Checked");
				
				Thread.sleep(2000l);
				pa.enterLogAmount(paread.getPaAdjustment(currentRow, "Log Amount if empty"));
				logger.info("Log Amount Entered");
				
			}
			
			//=========== MOVE TO DOCTOR FEE =============================================
		
			Thread.sleep(2000l);
			pa.entyerDoctorFee();
			logger.info("Go To Doctor Fee");
			
			pa.getDfBenefitItem(paread.getPaAdjustment(currentRow, "DF Benefit Item"));
			logger.info("Doctor Fee Benefit Item Entered");
			
			//pa.getDfcptCode(paread.getPaAdjustment(currentRow, "DF CPT Code Adjustment"));
			//logger.info("CPT Code Entered");
			
			//===========================================
			Thread.sleep(2000l);
			//===========================================			
			
			pa.selectdfeeBenefitItemAdjust(row);
			logger.info("Benefit Item Selected");
			
			//pa.selectCptCode(row);
			//logger.info("CPT Code Selected");
			
			//===========================================
			//Thread.sleep(10000l); // for loader if any
			pa.waitLoader();
			//===========================================			
			
			pa.getdfRequestedAmount(paread.getPaAdjustment(currentRow, "DF Requested Amount"));
			logger.info("Doctor Fee Requested Amount Entered");
	
			pa.getdfApprovedAmount(paread.getPaManual(currentRow, "DF Approved Amount"));
			logger.info("Doctor Fee Approved Amount Entered");			
			
			//===========================================
			Thread.sleep(3000l);
			//===========================================
			
			pa.getAddDocFee();
			logger.info("Doctor Fee Add Button Clicked");
			
			//===========================================
			Thread.sleep(2000l);
			//===========================================
			
			//=============================================================================
			
			//CARD DETAILS
			if(paread.getPaAdjustment(currentRow, "Card Details").equalsIgnoreCase("No")){
				
				pa.goTOCardDetails();
				logger.info("Go TO Card Details");
				
				pa.getCardNumber(paread.getPaAdjustment(currentRow, "Card no."));
				logger.info("Card Number Entered");
	
				pa.getCardMonth();
				logger.info("Card Month Clicked");
				
				pa.getCardMonth(paread.getPaAdjustment(currentRow, "Expiry Date"));
				logger.info("Expire Date/Month Selected");

			}
			
			pa.inputRemarks(paread.getPaAdjustment(currentRow, "Remarks"));
			logger.info("Remarks Entered");
			
			//===========================================
			//Thread.sleep(10000l); // loader if any
			pa.waitLoader();
			//===========================================
			
			pa.saveButton();
			logger.info("Save Button Clicked");
			
			paNdetails = pa.getpaNotification();
			logger.info("Alert Message: "+ paNdetails);			
			
			if (paNdetails.equalsIgnoreCase("Case has been updated")) {
				
				paNdetails = pa.getpaNotification();
				logger.info("Success: "+ paNdetails);

			} else {
				
				//===============
				//Thread.sleep(30000l); // loader if any
				pa.waitLoader();
				//===============				
				pa.getNoTOStay();
				logger.info("No Clicked...");
			}
			

			//pa.getNoTOStay();
			//logger.info("No Clicked...");
			
			//=================
			//Thread.sleep(25000l);
			//=================
			//pa.clickShowhide2();
			//logger.info("Show/Hide Document Button Clicked");
			
			//===============
			//pa.waitTillLoader();
			
			pa.waitLoader();
			Thread.sleep(10000l); //loader if any
			//===============
			pa.clickautoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			//===============
			//Thread.sleep(30000l); //loader if any
			pa.waitLoader();
			//===============

			pa.gotoPreApprovalResult();
			logger.info("Go To Pre Approval Result");
			captureScreen(driver,row+"_Success_paTestAdjustment");
			logger.info("Screenshot captured of Pre Approval Result");
			
			//===============
			//Thread.sleep(20000l); // loader if any
			pa.waitLoader();
			//===============
			pa.clickApprove();
			logger.info("Approve Clicked...");
			
			//==================
			//Thread.sleep(15000l); // loader if any
			pa.waitLoader();
			//==================
			pa.clickBackToApprove();
			logger.info("Back TO Approve Clicked...");
			logger.info("====> Process Complete of Save(Generate PA No.), auto-audjudicate, and approve For Adjustment <====");
			
			//==============================================================================================			
			
		} catch (Exception e) {
			

			logger.info("====> paTestAdjustment Fail <====");
			captureScreen(driver, row+"_paTestAdjustment");// first para is driver,
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
	@Test(priority=2, dependsOnMethods = { "paTestAdjustment" })
	public void palistSearchAdjustment(String row) throws IOException
	{
		try {
			
			logger.info("<==== Adjusted Approved PA Search Started ====>");
			//PAPage pa = new PAPage(driver);
			PAListPage palistp = new PAListPage(driver);
			
			String paNumber = regExtract(paNdetails);

			System.out.println(paNumber);
			
			//Thread.sleep(10000l); // loader if any
			palistp.waitLoader();
			
			
			palistp.txtPaNum(paNumber);
			logger.info("PA Number Entered");
			
			Thread.sleep(4000l);
			palistp.clickGO();
			logger.info("Go Clicked for PA Search");
			
			Thread.sleep(5000l);
			captureScreen(driver,row+"_Success_palistSearchAdjustment");
			logger.info("====> Screenshots captured for search PANumber <====");
			logger.info("====> Adjusted Approved PA Search Passed <====");
			
		} catch (InterruptedException e) {
			

			logger.info("====> Adjusted Approved PA Search Failed <====");
			captureScreen(driver, row+"_palistSearchAdjustment");
			
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
		}
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "palistSearchAdjustment" })
	public void palistAdjustmentLogLetter(String row) throws IOException
	{
		try {
			
			logger.info("<==== Adjusted Approved PA Started For Log Letter ====>");

			PAListPage palistp = new PAListPage(driver);
			
			String paNumber = regExtract(paNdetails);

			System.out.println(paNumber);
			
			//Thread.sleep(5000l); // for loader if any
			palistp.waitLoader();
			//====================================================================

			palistp.clickPreApprovalView();
			logger.info("Click on Pre Approval Icon");
			
			// ====> REDIRECTING TO PRE APPROVAL VIEW PAGE <====
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(1));
			//Thread.sleep(10000l);
			palistp.waitLoader();
			
			palistp.clickGenerateLogButton();
			logger.info("LOG Letter Button Clicked");
			
			//SWITCH TO GENERATE LOG LETTER TAB
			ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab2.get(2));
			
			//GO TO GENERATE LETTER BUTTON
			Thread.sleep(10000l);
			palistp.waitLoader();
			palistp.gotoGenerateLOGLetterButton();
			logger.info("Scroll to generate letter Button");
			
			//Click On GENERATE LETTER BUTTON
			palistp.clickGenerateLogLetter();
			logger.info("Generate Log Letter Page Clicked");
		
			//====================================================================			
			//Thread.sleep(5000l);
			palistp.waitLoader();

			// ===== VERIFY PDF AVAILABLILITY =====================
			
			boolean chkPDF = palistp.loglettercheck();
			
			if(chkPDF == true){
				
				logger.info("PDF Displayed.");
				
			}else
			{
				logger.info("PDF Not Displayed.");
				Assert.assertTrue(false, "PDF Not Displyed After Generate click");
			}
			
			// ==================================================			
			captureScreen(driver,row+"_Success_palistAdjustmentLogLetter");

			logger.info("====> Screenshots captured for Log Letter <====");
			logger.info("====> Adjusted Approved PA PASSED For Log Letter <====");
			
		} catch (InterruptedException e) {
			

			logger.info("====> Adjusted Approved PA FAILED For Log Letter <====");
			captureScreen(driver, row+"_palistAdjustmentLogLetter");
			
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
		}
		
		driver.quit();
		
	}	
	
	

}
