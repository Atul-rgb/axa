package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.CashlessOverviewPage;
import com.hbaxa.testdata.CashlessOverviewData;

public class TC_CashlessOverviewTestManual_001 extends BaseClass {
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
			
			cashlessOverview.setUserName(CashlessOverview.getCashlessOverview(currentRow,"Username")); //First parameter is current row, second is column name
			logger.info("Username Entered");
			
			cashlessOverview.setPassWord(CashlessOverview.getCashlessOverview(currentRow,"Password"));
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
	public void cashlessOverviewManual(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW THROUGH MANUAL TEST STARTED ====>");
			
			//Menu Navigation =====
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
			
			//cashlessOverview.enterClaimNo(CashlessOverview.getCashlessOverview(currentRow,"CLAIM NO"));
			
			String sheetClaim = CashlessOverview.getCashlessOverview(currentRow,"CLAIM NO");
			System.out.println("Sheetclaim = "+ sheetClaim);
			
			
			if(sheetClaim == ""){
				cashlessOverview.enterClaimNo(TC_CashLessDCTestManual_001.claimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				cashlessOverview.enterClaimNo(CashlessOverview.getCashlessOverview(currentRow,"CLAIM NO"));
				logger.info("Claim No Entered");
			}
			
			
			Thread.sleep(1000l);
			cashlessOverview.selectCasePickedBy(CashlessOverview.getCashlessOverview(currentRow,"CASE PICKED BY"));
			logger.info("Case Picked by selected");
			
			cashlessOverview.clickGo();
			logger.info("Go Clicked");
			
			//===============================
			//Thread.sleep(3000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================	
			
			//CODE FOR REASSIGN =======================
			
			cashlessOverview.clickReassign();
			logger.info("Reassigned Clicked");
			
			cashlessOverview.enterAssigneUser(CashlessOverview.getCashlessOverview(currentRow,"Username"));
			logger.info("User Name Entered for Reassigned");
			
			cashlessOverview.clickSearchAssign();
			logger.info("Search Clicked for Assigned User");
			
			cashlessOverview.clickSelectAssigned();
			logger.info("Select Clicked and User Assigned for the claim");
			
			//cashlessOverview.waitLoader();
			//=========================================	
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			cashlessOverview.waitLoader();
			
			cashlessOverview.clickProceed();
			logger.info("Proceed Clicked");
			
			//===============================
			//Thread.sleep(5000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================
			
			//SWITCH TO NEXT TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(1));
			
			//===============================
			//Thread.sleep(25000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================	
			//====== APS new Code================
			
			/*try{
				
				cashlessOverview.clickApsGeneration();
				logger.info("APS Generate Letter Button Clicked");
				
				//===============================
				//Thread.sleep(5000l); // use sleep for loader
				cashlessOverview.waitLoader();
				//===============================
				
				//SWITCH TO APS GENERATION TAB
				ArrayList<String> tab12 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab12.get(2));
				
				//==============================
				// Thread.sleep(15000l); // use sleep for loader
				cashlessOverview.waitLoader();
				//==============================
				
				cashlessOverview.clickAddnew();
				logger.info("Click Add New");
				
				cashlessOverview.enterDoctorName(CashlessOverview.getCashlessOverviewAPS(currentRow, "Doctor/Hospital/Clinic"));
				logger.info("Doctor Name Entered");
				
				cashlessOverview.selectDoctorName(row);
				logger.info("Doctor Name Selected");
				
				cashlessOverview.clickGoaps();
				logger.info("Go Clicked");
				
				//===============================
				Thread.sleep(3000l);
				//===============================
				
				//SWITCH TO APS CAPTURE TAB
				ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab2.get(3));
				
				//===============================
				Thread.sleep(5000l);
				//===============================
				
				//=============== APS CAPTURE FORM FILLING ===============================
				
				cashlessOverview.enterTitle(CashlessOverview.getCashlessOverviewAPS(currentRow, "Title"));
				logger.info("Title Entered");
				
				cashlessOverview.enterPayee(CashlessOverview.getCashlessOverviewAPS(currentRow, "Payee"));
				logger.info("Payee Entered");
				
				cashlessOverview.enterAttentionName(CashlessOverview.getCashlessOverviewAPS(currentRow, "Attention Name"));
				logger.info("Attention Name Entered");
				
				cashlessOverview.enterAddress1(CashlessOverview.getCashlessOverviewAPS(currentRow, "Address 1"));
				logger.info("Address 1 Entered");

				cashlessOverview.enterAddress2(CashlessOverview.getCashlessOverviewAPS(currentRow, "Address 2"));
				logger.info("Address 2 Entered");
				
				cashlessOverview.enterAddress3(CashlessOverview.getCashlessOverviewAPS(currentRow, "Address 3"));
				logger.info("Address 3 Entered");			
				
				cashlessOverview.enterAddress4(CashlessOverview.getCashlessOverviewAPS(currentRow, "Address 4"));
				logger.info("Address 4 Entered");			
				
				cashlessOverview.enterReminderPeriod(CashlessOverview.getCashlessOverviewAPS(currentRow, "Reminder Period (No. of Days)"));
				logger.info("Reminder Period Entered");
				
				Thread.sleep(2000l);
				cashlessOverview.selectQuest1(CashlessOverview.getCashlessOverviewAPS(currentRow, "SQC1"));
				logger.info("Question 1 Selected");
				
				Thread.sleep(2000l);
				cashlessOverview.selectQuest2(CashlessOverview.getCashlessOverviewAPS(currentRow, "SQC2"));
				logger.info("Question 2 Selected");
				
				Thread.sleep(2000l);
				cashlessOverview.selectQuest3(CashlessOverview.getCashlessOverviewAPS(currentRow, "SQC3"));
				logger.info("Question 3 Selected");
				
				Thread.sleep(2000l);
				cashlessOverview.selectQuest4(CashlessOverview.getCashlessOverviewAPS(currentRow, "SQC4"));
				logger.info("Question 4 selected");
				
				
				Thread.sleep(4000l);
				cashlessOverview.scrolldownToSave();
				logger.info("Scroll Down TO Save");
				
				cashlessOverview.clikSave();
				logger.info("Save Clicked");
				
				// Thread.sleep(10000l); // use sleep for loader
				cashlessOverview.waitLoader();
				
				cashlessOverview.clikGenerateLetterAps();
				logger.info("Generate Letter Clicked");
				
				//===============================
				Thread.sleep(3000l);
				//===============================
				
				//SWITCH TO GENERATE LETTER (APS) TAB
				ArrayList<String> tab3 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab3.get(4));
				
				//===============================
				// Thread.sleep(10000l); // use sleep for loader
				cashlessOverview.waitLoader();
				//===============================
				
				cashlessOverview.scrolldownToSave1();
				logger.info("Scroll Down TO Save");	
				
				
				cashlessOverview.clikGenerateLetterApsBtn();
				logger.info("Generate Letter Button Clicked");
				
				
				//Thread.sleep(20000l); // use sleep for loader if any
				cashlessOverview.waitLoader();
				
				//=============================
				captureScreen(driver, row+"_Success_cashlessOManualAPSGeneration");
				logger.info("====> CASHLESS OVERVIEW cashlessOManualAPSGeneration THROUGH MANUAL TEST PASSED <====");
				
				//Close Current tab
				driver.close();
				//SWITCH TO PREVIOUS TAB
				driver.switchTo().window(tab3.get(3));			
				Thread.sleep(2000l);
				
				
				//Close Current tab
				driver.close();
				//SWITCH TO PREVIOUS TAB
				driver.switchTo().window(tab3.get(2));
				Thread.sleep(2000l);
				
				//Close Current tab
				driver.close();
				//SWITCH TO PREVIOUS TAB
				driver.switchTo().window(tab3.get(1));
				
			} catch (Exception e) {
				
				Thread.sleep(3000l);
				captureScreen(driver, row+"_cashlessOManualAPSGeneration");
				
				//================================================
				//Handle Tab Exception Here
				//===============================================
				
				
				logger.info("====> CASHLESS OVERVIEW cashlessOManualAPSGeneration THROUGH MANUAL TEST FAILED <====");
				e.printStackTrace();
				Assert.assertTrue(false);			
			}*/
			
		//===============APS end here=========
			
			
			/*if(CashlessOverview.getCashlessOverview(currentRow,"Pending Status").equalsIgnoreCase("Yes")){
				
				cashlessOverview.clickPendingStatus();
				logger.info("Pending Notification Clicked");
				
				Thread.sleep(3000l);
				//SWITCH TO PENDING NOTIFICATIONS TAB
				ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab2.get(2));
				
				Thread.sleep(8000l);
				cashlessOverview.clickRemarksSearch();
				logger.info("Click Search Remarks");
				
				cashlessOverview.enterRemarksCode(CashlessOverview.getCashlessOverview(currentRow,"Pending Remarks Code"));
				logger.info("Remarks Code Entered");
				
				cashlessOverview.clickSearchPendingNoti();
				logger.info("Search Clicked");
				
				Thread.sleep(3000l);
				cashlessOverview.clickGoPendinNoti();
				logger.info("Go Clicked");
				
				Thread.sleep(3000l);
				cashlessOverview.clickSavePendingNoti();
				logger.info("Save Clicked");
				
				//Thread.sleep(15000l); // use sleep for loader
				cashlessOverview.waitLoader();
				
				//Close current tab.
				driver.close();
				//Switch to previous tab
				driver.switchTo().window(tab2.get(1));
				
			}
			cashlessOverview.waitLoader();*/
			Thread.sleep(5000l);
			cashlessOverview.gotosettlementtypecutomer();
			
			boolean checksettlementtype= cashlessOverview.settlementtypecustomer();
			logger.info(checksettlementtype);
			
			if(checksettlementtype==true){
				
				
				
				if(CashlessOverview.getCashlessOverview(currentRow, "SM Settlement Type").equalsIgnoreCase("By Autopay")){
					
					cashlessOverview.selectcustomertype(CashlessOverview.getCashlessOverview(currentRow, "SM Settlement Type"));
					
					cashlessOverview.enterbankknocus(CashlessOverview.getCashlessOverview(currentRow, "SM Bank No"));
					cashlessOverview.enterbranchcustomer(CashlessOverview.getCashlessOverview(currentRow, "SM Branch No"));
					cashlessOverview.enteraccountnocust(CashlessOverview.getCashlessOverview(currentRow, "SM Account No"));
					cashlessOverview.enterconfirmaccount(CashlessOverview.getCashlessOverview(currentRow, "SM Confirm Account No"));
					cashlessOverview.entercuspayeename(CashlessOverview.getCashlessOverview(currentRow, "SM Name Of Payee"));
					Thread.sleep(5000l);
				}
				
				else if(CashlessOverview.getCashlessOverview(currentRow, "SM Settlement Type").equalsIgnoreCase("By Cheque")){
				
					cashlessOverview.selectcustomertype(CashlessOverview.getCashlessOverview(currentRow, "SM Settlement Type"));
					
					cashlessOverview.clickMemberAddress();	
					
				}
				Thread.sleep(5000l);
				
				
		}
			
			
            cashlessOverview.clickAutoAdjudicate();
			logger.info("Auto Audjudicate Clicked");
			
			//===============================
			//Thread.sleep(15000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================			
			
			cashlessOverview.gotoClaimStatus();
			logger.info("Go TO Claim Status");
			
			cashlessOverview.selectClaimStatus(CashlessOverview.getCashlessOverview(currentRow,"Claim Status"));
			logger.info("Claim Status Selected");
			
			if(CashlessOverview.getCashlessOverview(currentRow,"Pending Status").equalsIgnoreCase("Yes")){
				
				cashlessOverview.clickUpdateStatus();
				logger.info("Update Status Clicked");
				
				Thread.sleep(4000l);
				driver.switchTo().alert().accept();
				logger.info("Pending Alert Accepted");
				
			}else{
				
				cashlessOverview.clickUpdateStatus();
				logger.info("Update Status Clicked");
			}
			
			//===============================
			//Thread.sleep(30000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================				
			
			//captureScreen(driver, row+"_Success_cashlessOverviewManual");
			captureScreenfullPage(driver, row+"_Success_cashlessOverviewManual");
			logger.info("====> CASHLESS OVERVIEW THROUGH MANUAL TEST PASSED <====");
			
			// ==== FOR CLAIM CALCULATION ==============================================
			
			if(CashlessOverview.getCashlessDataCapture(currentRow, "Multi Billing").equalsIgnoreCase("Yes")){
				
				Thread.sleep(1000l);
				String totalClaimAmount = cashlessOverview.getClaimAmount();
				logger.info("Total Claim Amount Fetched from site:- "+ totalClaimAmount);
				
				Thread.sleep(1000l);
				String totalApprovedAmount = cashlessOverview.getTotalApprovedAmt();
				logger.info("Total Approved Amount Fetched from site is :- "+ totalApprovedAmount);
			}			
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOverviewManual");			
			logger.info("====> CASHLESS OVERVIEW TEST THROUGH MANUAL TEST FAILED <====");
			
			ArrayList<String> tab3 = new ArrayList<String> (driver.getWindowHandles());
			//Close current tab.
			driver.close();
			//Switch to previous tab
			driver.switchTo().window(tab3.get(0));
			
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}

	/*@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "cashlessOverviewManual" })
	public void cOverviewManualPreviewBenefitItem(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW PREVIEW BENEFIT ITEM THROUGH MANUAL TEST STARTED ====>");
			
			cashlessOverview.clickPreviewBenefitItem();
			logger.info("Preview Benefit Item Button Clicked");
			
			//===============================
			Thread.sleep(3000l);
			//===============================
			
			//SWITCH TO VIEW LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//===============================
			//Thread.sleep(30000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================	

			captureScreen(driver, row+"_Success_cOverviewManualPreviewBenefitItem");
			logger.info("====> CASHLESS OVERVIEW PREVIEW BENEFIT ITEM THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cOverviewManualPreviewBenefitItem");			
			logger.info("====> CASHLESS OVERVIEW PREVIEW BENEFIT ITEM THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}	*/
	
	
	/*@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "cashlessOverviewManual" })
	public void cashlessOManualviewLetter(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW VIEW LETTER THROUGH MANUAL TEST STARTED ====>");
			
			cashlessOverview.clickViewLetter();
			logger.info("View Letter Clicked");
			
			//===============================
			Thread.sleep(3000l);
			//===============================
			
			//SWITCH TO VIEW LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//===============================
			//Thread.sleep(30000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================	

			captureScreen(driver, row+"_Success_cashlessOManualviewLetter");
			logger.info("====> CASHLESS OVERVIEW VIEW LETTER THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOManualviewLetter");			
			logger.info("====> CASHLESS OVERVIEW VIEW LETTER THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}*/
	
	
	@Parameters(value="tc_row")
	@Test(priority=5, dependsOnMethods = { "cashlessOverviewManual" })
	public void cashlessOManualGenerateLetter(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW GENERATE LETTER THROUGH MANUAL TEST STARTED ====>");
			
			cashlessOverview.clickGenerateLetter();
			logger.info("Generate Letter Button Clicked");
			
			//===============================
			Thread.sleep(3000l);
			//===============================
			
			//SWITCH TO GENERATE LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//==============================
			//Thread.sleep(15000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//=============================
			
			// ==== Switch to Internal letter frame from web window ==================
		    driver.switchTo().frame(0);
			//String letterContent = driver.findElement(By.xpath("(((//table[@class='english content cke_show_border']//tbody)[2]//tr)[3]//td)[1]")).getText();
			
		    /*String letterContent=null;
    		if(CashlessOverview.getCashlessDataCapture(currentRow, "TC_ID").contains("_GI_")){
		    	
		    	letterContent = driver.findElement(By.xpath("//p[contains(text(),'A Payment of HKD')]")).getText();
		    	
		    }
    		 else if(CashlessOverview.getCashlessDataCapture(currentRow, "TC_ID").contains("_LIFE_")){
    			
    			 letterContent = driver.findElement(By.xpath("//p[contains(text(),'We have deducted the eligible')]")).getText();
		    	
		    	
    		 }
    		
    		
    		else if(CashlessOverview.getCashlessDataCapture(currentRow, "TC_ID").contains("_LIFE_")){
    			
    			letterContent = driver.findElement(By.xpath("//p[contains(text(),'An amount of HKD')]")).getText();
    		
    		}
    		
    		  
		    	
		    
		    
		   // String letterContent = driver.findElement(By.xpath("//p[contains(text(),'A payment of HKD')]")).getText();
			logger.info("Letter Content:- "+ letterContent);*/
			// ==== Return to web window from Internal Frame ====
			driver.switchTo().defaultContent();
			// ========================================================================
			
			cashlessOverview.gotoGeneratLetterbtn();
			logger.info("Scroll Down to Generate Letter Button");
			//==============================
			
			cashlessOverview.clickGenerateLetterbtn();
			logger.info("Generate Letter Button Clicked");
			
			//===============================
			// Thread.sleep(30000l); // use sleep for loader
			cashlessOverview.waitLoader();
			//===============================

			captureScreen(driver, row+"_Success_cashlessOManualGenerateLetter");
			logger.info("====> CASHLESS OVERVIEW GENERATE LETTER THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOManualGenerateLetter");			
			logger.info("====> CASHLESS OVERVIEW GENERATE LETTER THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}	
	
	
	
	@Parameters(value="tc_row")
	@Test(priority=6, dependsOnMethods = { "cashlessOverviewManual" })
	public void cashlessOManualAssessmentEnquiry(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);
			
			Thread.sleep(3000l);
			logger.info("<==== CASHLESS OVERVIEW cashlessOManualAssessmentEnquiry THROUGH MANUAL TEST STARTED ====>");
			
			cashlessOverview.clickAssessmentenquiry();
			logger.info("Assessment Enquiry Button Clicked");
			
			//===============================
			//Thread.sleep(15000l); // use sleep for loader if any
			cashlessOverview.waitLoader();
			//===============================
			
			cashlessOverview.enterClaimNuAssessment(TC_CashLessDCTestManual_001.claimNumber);
			logger.info("Claim Number Entered");
			
			cashlessOverview.clickGoAssessment();
			logger.info("Go Button Clicked");
			
			//===============================
			// Thread.sleep(20000l); // use sleep for loader if any
			cashlessOverview.waitLoader();
			//===============================	
			captureScreen(driver, row+"_Success_cashlessOManualAssessmentEnquiry");

			//Close Assessment Enquiry Pop up
			cashlessOverview.clickCloseAssessmentPopup();
			logger.info("Assessment Enquiry pop up Closed");

			logger.info("====> CASHLESS OVERVIEW cashlessOManualAssessmentEnquiry THROUGH MANUAL TEST PASSED <====");
			//driver.close();
			//SWITCH TO PREVIOUS TAB
			//driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOManualAssessmentEnquiry");			
			logger.info("====> CASHLESS OVERVIEW cashlessOManualAssessmentEnquiry THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}	
	
	/*@Parameters(value="tc_row")
	@Test(priority=7, dependsOnMethods = { "cashlessOverviewManual" })
	public void cashlessOManualPendinNotification(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW cashlessOManualPendinNotification THROUGH MANUAL TEST STARTED ====>");
			
			cashlessOverview.clickPendingNotification();
			logger.info("Pending Notification Button Clicked");
			
			//===============================
			Thread.sleep(3000l);
			//===============================
			
			//SWITCH TO GENERATE LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//==============================
			// Thread.sleep(15000l); // use sleep for loader if any
			cashlessOverview.waitLoader();
			captureScreen(driver, row+"_Success_cashlessOManualPendinNotification");	
			
			if(CashlessOverview.getCashlessOverview(currentRow,"TC_ID").equals("_GI_")){
				
			// ==== CODE PENDING GENERATE LETTER
			
			cashlessOverview.clickGenerateLetter();
			logger.info("Generate Letter Button Clicked");
			
			//==============================
			
			//SWITCH TO GENERATE LETTER PAGE
			Thread.sleep(3000l);
			ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab2.get(3));
			//==============================			

			cashlessOverview.waitLoader();

			cashlessOverview.gotoGeneratLetterbtn();
			logger.info("Go To Generate Letter Button");
			
			cashlessOverview.clickGenerateLetterbtn();
			logger.info("Generate Letter button Clicked");
			
			cashlessOverview.waitLoader();
			Thread.sleep(8000l);
			//==============================			
			captureScreen(driver, row+"_Success_cashlessOManualPendinNotificationLetter");
			
			logger.info("Screenshot captured of Generate Letter Page, Pending Notification.");

			
			//Close Current tab
			Thread.sleep(2000l);
			driver.close();
			
			//SWITCH TO PREVIOUS TAB
			Thread.sleep(2000l);
			driver.switchTo().window(tab1.get(2));
			}
			else{
				
				logger.info("====> CASHLESS OVERVIEW cashlessOManualPendinNotification THROUGH MANUAL TEST PASSED <====");

				//Close Current tab
				Thread.sleep(2000l);
				driver.close();
				
				//SWITCH TO PREVIOUS TAB
				Thread.sleep(2000l);
				driver.switchTo().window(tab1.get(1));
			
			}
			

			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOManualPendinNotification");			
			logger.info("====> CASHLESS OVERVIEW cashlessOManualPendinNotification THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}*/
	
	@Parameters(value="tc_row")
	@Test(priority=8, dependsOnMethods = {"cashlessOManualPendinNotification"})
	public void cashlessOManualPendinNotificationLetter(String row) throws IOException, InterruptedException
	{
		logger.info("<==== Screenshot Already captured pending generate letter page ====>");
	}	
	
	@Parameters(value="tc_row")
	@Test(priority=9, dependsOnMethods = { "cashlessOverviewManual" })
	public void cashlessOManualApprovedClaimSearch(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);

			logger.info("<==== CASHLESS OVERVIEW cashlessOManualApprovedClaimSearch THROUGH MANUAL TEST STARTED ====>");

			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(0));
			
			//======================================================================
			
			cashlessOverview.selectStatusApproved(CashlessOverview.getCashlessOverview(currentRow,"First Status"));
			logger.info("Approved Status Selected");
			
			String sheetClaim = CashlessOverview.getCashlessOverview(currentRow,"CLAIM NO");
			System.out.println("Sheetclaim = "+ sheetClaim);
			
			String ClaimNumber;
			if(sheetClaim == ""){
			
				ClaimNumber = TC_CashLessDCTestManual_001.claimNumber;
				cashlessOverview.enterClaimNo(ClaimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				ClaimNumber = CashlessOverview.getCashlessOverview(currentRow,"CLAIM NO");
				cashlessOverview.enterClaimNo(ClaimNumber);
				logger.info("Claim No Entered");
			}
			
			
			cashlessOverview.clickSearchAgain();
			logger.info("Search Button Clicked");
			
			//==== VERIFY LIST SEARCH ==============================================
			
			boolean chk = cashlessOverview.verifyApprovedClaim(ClaimNumber);
			if(chk){
			
				logger.info("Claim Number Verified");
				
			}else{
				
				Assert.assertTrue(false,"Claim Number is not found on Claim List Page");
			}
				
			//======================================================================
			
			cashlessOverview.waitLoader();
			captureScreen(driver, row+"_Success_cashlessOManualApprovedClaimSearch");
			logger.info("====> CASHLESS OVERVIEW roManualApprovedClaimSearch THROUGH MANUAL TEST PASSED <====");
			
		
		} catch (Exception e) {
			
			logger.info("====> CASHLESS OVERVIEW roManualApprovedClaimSearch THROUGH MANUAL TEST FAILED <====");
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessOManualApprovedClaimSearch");

			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}	
		
			
	@Parameters(value="tc_row")
	@Test(priority=10, dependsOnMethods = { "cashlessOverviewManual" })
	public void logoutLevel2Test(String row) throws IOException, InterruptedException
	{
			CashlessOverviewPage cashlessOverview = new CashlessOverviewPage(driver);
			
			logger.info("<==== Logout Test Started ====>");
			
			// Thread.sleep(10000l); //use sleep for loader if any
			cashlessOverview.waitLoader();
			
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
