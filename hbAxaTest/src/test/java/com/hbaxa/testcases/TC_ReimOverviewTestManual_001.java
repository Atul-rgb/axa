package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.ReimDCapturePage;
import com.hbaxa.pageobjects.ReimOverviewPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.ReimOverviewData;
import com.hbaxa.testdata.ReimdcaptureData;

public class TC_ReimOverviewTestManual_001 extends BaseClass {
	String claimdetails;
	String alertmsg;
	ReimdcaptureData RDCapturedread = new ReimdcaptureData();
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
			
			rOverview.setUserName(ReimOverview.getReimOverview(currentRow,"Username")); //First parameter is current row, second is column name
			logger.info("Username Entered");
			
			rOverview.setPassWord(ReimOverview.getReimOverview(currentRow,"Password"));
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
	public void reimOverviewManual(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW THROUGH MANUAL TEST STARTED ====>");
			
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
			
			String sheetClaim = ReimOverview.getReimOverview(currentRow,"CLAIM NO");
			System.out.println("Sheetclaim = "+ sheetClaim);
			
			
			if(sheetClaim == ""){
				
				rOverview.enterClaimNo(TC_ReimDCTestManual_001.claimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				rOverview.enterClaimNo(ReimOverview.getReimOverview(currentRow,"CLAIM NO"));
				logger.info("Claim No Entered");
			}			
			
			
			Thread.sleep(1000l);
			rOverview.selectCasePickedBy(ReimOverview.getReimOverview(currentRow,"CASE PICKED BY"));
			logger.info("Case Picked by selected");		
		
			
			rOverview.clickGo();
			logger.info("claim search");
		
			
			//===============================
			//Thread.sleep(3000l); // use sleep for loader
			rOverview.waitLoader();
			//===============================
			
			//CODE FOR REASSIGN =======================
			
			rOverview.clickReassign();
			logger.info("Reassigned Clicked");
			
			
			
			
			rOverview.enterAssigneUser(ReimOverview.getReimOverview(currentRow,"Username"));
			logger.info("User Name Entered for Reassigned");
			
			rOverview.clickSearchAssign();
			logger.info("Search Clicked for Assigned User");
			
			rOverview.clickSelectAssigned();
			logger.info("Select Clicked and User Assigned for the claim");
			
			//rOverview.waitLoader();
			//=========================================
			
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			rOverview.waitLoader();
			
			rOverview.clickProceed();
			
			logger.info("Proceed Clicked");
			
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
			
			Thread.sleep(15000l);
			//===============================
			
			//=================comment code 180 to	348
		 ///////////////APS New Code////////////////////////////////////////
	/*		try{
				
			
			rOverview.clickApsGeneration();
             logger.info("APS Generate Letter Button Clicked");
			
			//===============================
			Thread.sleep(5000l);
			//===============================
			
			//SWITCH TO APS GENERATION TAB
			ArrayList<String> tab11 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab11.get(2));
			
			rOverview.clickAddnew();
			rOverview.enterDoctorName(ReimOverview.getReimOverviewAPS(currentRow, "Doctor/Hospital/Clinic"));
			logger.info("Doctor Name Entered");
			
			Thread.sleep(3000l);
			rOverview.selectDoctorName(row);
			logger.info("Doctor Name Selected");
			
			rOverview.clickGoaps();
			logger.info("Go Clicked");
			
			//SWITCH TO APS CAPTURE TAB
			ArrayList<String> tab12 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab12.get(3));
			
			//===============================
			Thread.sleep(5000l);
			//===============================
		
			//=============== APS CAPTURE FORM FILLING ===============================
			
			rOverview.enterTitle(ReimOverview.getReimOverviewAPS(currentRow, "Title"));
			logger.info("Title Entered");
			
			rOverview.enterPayee(ReimOverview.getReimOverviewAPS(currentRow, "Payee"));
			logger.info("Payee Entered");
			
			rOverview.enterAttentionName(ReimOverview.getReimOverviewAPS(currentRow, "Attention Name"));
			logger.info("Attention Name Entered");
			
			rOverview.enterAddress1(ReimOverview.getReimOverviewAPS(currentRow, "Address 1"));
			logger.info("Address 1 Entered");

			rOverview.enterAddress2(ReimOverview.getReimOverviewAPS(currentRow, "Address 2"));
			logger.info("Address 2 Entered");
			
			rOverview.enterAddress3(ReimOverview.getReimOverviewAPS(currentRow, "Address 3"));
			logger.info("Address 3 Entered");			
			
			rOverview.enterAddress4(ReimOverview.getReimOverviewAPS(currentRow, "Address 4"));
			logger.info("Address 4 Entered");			
			
			rOverview.enterReminderPeriod(ReimOverview.getReimOverviewAPS(currentRow, "Reminder Period (No. of Days)"));
			logger.info("Reminder Period Entered");
			
			Thread.sleep(2000l);
			rOverview.selectQuest1(ReimOverview.getReimOverviewAPS(currentRow, "SQC1"));
			logger.info("Question 1 Selected");
			
			Thread.sleep(2000l);
			rOverview.selectQuest2(ReimOverview.getReimOverviewAPS(currentRow, "SQC2"));
			logger.info("Question 2 Selected");
			
			Thread.sleep(2000l);
			rOverview.selectQuest3(ReimOverview.getReimOverviewAPS(currentRow, "SQC3"));
			logger.info("Question 3 Selected");
			
			Thread.sleep(2000l);
			rOverview.selectQuest4(ReimOverview.getReimOverviewAPS(currentRow, "SQC4"));
			logger.info("Question 4 selected");
			
			
			Thread.sleep(5000l);
			rOverview.scrolldownToSave();
			logger.info("Scroll Down TO Save");
			
			rOverview.clikSave();
			logger.info("Save Clicked");
			
			Thread.sleep(10000l);
			
			rOverview.clikGenerateLetterAps();
			logger.info("Generate Letter Clicked");
			
			//SWITCH TO GENERATE LETTER (APS) TAB
			ArrayList<String> tab13 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab13.get(4));
			
			
			rOverview.scrolldownToSave1();
			logger.info("Scroll Down TO Save");	
			
			
			rOverview.clikGenerateLetterApsBtn();
			logger.info("Generate Letter Button Clicked");
			///To verify the APS letter is generated or Not/////
			rOverview.waitLoader();
			
			boolean apschck=rOverview.validatepdf();
			logger.info(apschck);
			
			if(apschck==true){
				
				logger.info("APS letter generated generated");
				
				Assert.assertTrue(true, "APS letter succesfully Generated");
			   }else 
				
				logger.info("APS letter not generated ");
			   Assert.assertTrue(true, "letter not generted");;
			
			
			Thread.sleep(20000l);
			//=============================
			captureScreen(driver, row+"_Success_roManualAPSGeneration");
			logger.info("====> REIMBURSMENT OVERVIEW roManualAPSGeneration THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab13.get(3));			
			Thread.sleep(2000l);
			
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab13.get(2));
			Thread.sleep(2000l);
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab13.get(1));
			
			
			//===============================
			
			
			
			//==============================
			Thread.sleep(5000l);
			}catch(Exception e) {
				
				Thread.sleep(3000l);
				captureScreen(driver, row+"_roManualAPSGeneration");
				
				//================================================
				//Handle Tab Exception Here
				//===============================================
				
				
				logger.info("====> REIMBURSMENT OVERVIEW roManualAPSGeneration THROUGH MANUAL TEST FAILED <====");
				e.printStackTrace();
				Assert.assertTrue(false);			
			}
			
			*/
			
			
			//=============================ENd the APS here////////////////////////////////////
				
		
		
			// TODO COD FOR CLAIM 5 WHICH IS BEING LINK TO CLAIM 3 HERE.
			if(row.equals("54")){
				
				rOverview.gotoLinkDlink();
				logger.info("Move to Link/ D-Link Area");
				
				String claimData = ReimOverview.getReimLink(currentRow,"Claim3_52");
				
				rOverview.linkClaim(claimData);
				logger.info("Claim3 "+claimData+" linked to Current Claim");
				
			}
			
			if(ReimOverview.getReimOverview(currentRow,"Pending Status").equalsIgnoreCase("Yes")){
				
				rOverview.clickPendingStatus();
				logger.info("Pending Notification Clicked");
				
				Thread.sleep(4000l);
				//SWITCH TO PENDING NOTIFICATIONS TAB
				ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab2.get(2));

				Thread.sleep(8000l);
				rOverview.clickRemarksSearch();
				logger.info("Search Remarks Clicked"); // Previous Click Search Remarks
				
				//Thread.sleep(4000l); // loader if any
				rOverview.waitLoader();
				
				rOverview.enterRemarksCode(ReimOverview.getReimOverview(currentRow,"Pending Remarks Code"));
				logger.info("Remarks Code Entered");
				
				Thread.sleep(1000l);
				rOverview.clickSearchPendingNoti();
				logger.info("Search Clicked");
				
				Thread.sleep(3000l);
				rOverview.clickGoPendinNoti();
				logger.info("Go Clicked");
				
				Thread.sleep(3000l);
				rOverview.clickSavePendingNoti();
				logger.info("Save Clicked");
				
				//Thread.sleep(15000l); // use sleep for loader
				rOverview.waitLoader();
				
				//Close current tab.
				driver.close();
				//Switch to previous tab
				driver.switchTo().window(tab2.get(1));
				
			}
			
//=============================below code show element click intract exeception 11-07-2024===========================			
		/*	 if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("By Cheque"))
					
				{
				logger.info("Settlment Start By Cheque");
				
				Thread.sleep(8000);
				ReimDCapturePage rdCapture = new ReimDCapturePage(driver);
				rdCapture.select_settlmentType_Dropdown(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			logger.info("Select new  dropdown text");
				Thread.sleep(8000);
			//	rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			//	logger.info("Select dropdown option="+RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
				Thread.sleep(4000);
				rdCapture.clickcheck_box_memberaddresst2();
				logger.info("Click check box");
				
				}
				*/
			
			Thread.sleep(4000l);
			
			
			rOverview.clickAutoAdjudicate();
			logger.info("Auto Audjudicate Clicked");
			
			//===============================
			//Thread.sleep(15000l); // use sleep for loader
			rOverview.waitLoader();
			
//========================below code show element click interact execption 11-07-2024==================	
			
		/*	 if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("By Cheque"))
					
				{
				logger.info("Settlment Start By Cheque");
				
				Thread.sleep(8000);
				ReimDCapturePage rdCapture = new ReimDCapturePage(driver);
				rdCapture.select_settlmentType_Dropdown(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			logger.info("Select new  dropdown text");
				Thread.sleep(8000);
			//	rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			//	logger.info("Select dropdown option="+RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
				Thread.sleep(4000);
				rdCapture.clickcheck_box_memberaddresst2();
				logger.info("Click check box");
				
				}*/
		
			rOverview.gotoClaimStatus();
			logger.info("Go TO Claim Status");
			
			rOverview.selectClaimStatus(ReimOverview.getReimOverview(currentRow,"Claim Status"));
			logger.info("Claim Status Selected");
			
			if(ReimOverview.getReimOverview(currentRow,"Pending Status").equalsIgnoreCase("Yes")){  // site ask extra alert if pending status form filled
				
				Thread.sleep(4000l);
				rOverview.clickUpdateStatus();
				logger.info("Update Status Clicked");
				
				Thread.sleep(4000l);
				driver.switchTo().alert().accept();
				logger.info("Pending Alert Accepted");
				
			}else{
				
				Thread.sleep(4000l);
				
				
				
				rOverview.clickUpdateStatus();
				logger.info("Update Status Clicked");
			}
			
			//===============================
			//Thread.sleep(30000l); // use sleep for loader
			rOverview.waitLoader();
			//===============================				
			
			//captureScreen(driver, row+"_Success_reimOverviewManual");
			captureScreenfullPage(driver, row+"_Success_reimOverviewManual");
			logger.info("====> REIMBURSMENT OVERVIEW THROUGH MANUAL TEST PASSED <====");
			
			// ==== FOR CLAIM CALCULATION ==============================================
			
			if(ReimOverview.getReimDataCapture(currentRow, "Multi Billing").equalsIgnoreCase("Yes")){
				
				Thread.sleep(1000l);
				String totalClaimAmount = rOverview.getClaimAmount();
				logger.info("Total Claim Amount Fetched from site:- "+ totalClaimAmount);
				
				String expectedApprovAmt;
				String totalApprovedAmount;
				
				if(ReimOverview.getReimDataCapture(currentRow, "Input By Bill Item").equalsIgnoreCase("Yes")){
					
					expectedApprovAmt = ReimOverview.getReimDataMultiBilliTEM(currentRow, "Expected Amt");
					Thread.sleep(1000l);
					totalApprovedAmount = rOverview.getTotalApprovedAmt();
					
				}else{
					
					expectedApprovAmt = ReimOverview.getReimDataMultiBillBenefit(currentRow, "Expected Amt");
					Thread.sleep(1000l);
					totalApprovedAmount = rOverview.getTotalApprovedAmt();
				}
				
				if(expectedApprovAmt.equals(totalApprovedAmount)){
				
					logger.info("Total Approved Amount Fetched from site(claim view) is equal as expected :- "+ totalApprovedAmount);
					
				}else
				{
					logger.info("Total Approved Amount Fetched from site(claim view) is not equal as expected :- "+ totalApprovedAmount);
					
				}
				
			}
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_reimOverviewManual");			
			logger.info("====> REIMBURSMENT OVERVIEW TEST THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	//========================================================================================
	
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "reimOverviewManual" })
	public void roManualPreviewBenefitItem(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW PREVIEW BENEFIT ITEM THROUGH MANUAL TEST STARTED ====>");
		
			rOverview.clickPreviewBenefitItem();
			logger.info("Preview Benefit Item Clicked");
			
			//===============================
			Thread.sleep(5000l);
			//===============================
			
			//SWITCH TO VIEW LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//===============================
			Thread.sleep(30000l);
			//===============================	

			captureScreen(driver, row+"_Success_roManualPreviewBenefitItem");
			logger.info("====> REIMBURSMENT OVERVIEW PREVIEW BENEFIT ITEM THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_roManualPreviewBenefitItem");			
			logger.info("====> REIMBURSMENT OVERVIEW PREVIEW BENEFIT ITEM THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}
	
	
	
	//========================================================================================
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "reimOverviewManual" })
	public void roManualviewLetter(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW VIEW LETTER THROUGH MANUAL TEST STARTED ====>");
			
			rOverview.clickViewLetter();
			logger.info("View Letter Clicked");
			
			//===============================
			Thread.sleep(5000l);
			//===============================
			
			//SWITCH TO VIEW LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//===============================
			Thread.sleep(30000l);
			//===============================	

			captureScreen(driver, row+"_Success_roManualviewLetter");
			logger.info("====> REIMBURSMENT OVERVIEW THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_roManualviewLetter");			
			logger.info("====> REIMBURSMENT OVERVIEW VIEW LETTER THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=5, dependsOnMethods = { "reimOverviewManual" })
	public void roManualGenerateLetter(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW GENERATE LETTER THROUGH MANUAL TEST STARTED ====>");
			
			rOverview.clickGenerateLetter();
			logger.info("Generate Letter Button Clicked");
			
			//===============================
			Thread.sleep(5000l);
			//===============================
			
			//SWITCH TO GENERATE LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//==============================
			Thread.sleep(15000l);
			//==============================
			
			// ==== Switch to Internal letter frame from web window ==================
		    driver.switchTo().frame(0);
			//String letterContent = driver.findElement(By.xpath("(((//table[@class='english content cke_show_border']//tbody)[2]//tr)[3]//td)[1]")).getText();
		   
		    String letterContent;
		    if(ReimOverview.getReimDataCapture(currentRow, "TC_ID").contains("_GI_")){
		    	
		    	letterContent = driver.findElement(By.xpath("//p[contains(text(),'An amount of HKD')]")).getText();
		    	logger.info("Letter Content:- "+letterContent);
		    	
		    }else if ( ReimOverview.getReimDataCapture(currentRow, "TC_ID").contains("LIFE")){
		    	
		    	letterContent=driver.findElement(By.xpath("//p[contains(text(),'If you disagree with the above claim decision')]")).getText();
		    	logger.info("Letter Content:- "+letterContent);
		    }
		    else{
		    	
		    	letterContent = driver.findElement(By.xpath("//p[contains(text(),'A payment for HKD')]")).getText();
		    	logger.info("Letter Content:- "+letterContent);
		    }
		   
		    //  String letterContent = driver.findElement(By.xpath("//p[contains(text(),'A payment for HKD')]")).getText();
			
		    //logger.info("Letter Content:- "+letterContent);
			// ==== Return to web window from Internal Frame ====
			driver.switchTo().defaultContent();
			// ========================================================================
			
			rOverview.gotoGeneratLetterbtn();
			logger.info("Scroll Down to Generate Letter Button");
			//==============================
			
			rOverview.clickGenerateLetterbtn();
			logger.info("Generate Letter Button Clicked");
			
			//===============================
			Thread.sleep(30000l);
			//===============================	
			
			boolean approvedletter=rOverview.settlementlettercheck();
			logger.info(approvedletter);
			
			if(approvedletter==true){
				logger.info("Settlement letter generated");
				 Assert.assertTrue(true, "Settlement letter generated successfully");
				
			}else{
				
				logger.info("Settlement letter not genertaed");
				
				Assert.assertTrue(false, "settlement letter not generated");
			}

			captureScreenfullPage(driver, row+"_Success_roManualGenerateLetter");
			logger.info("====> REIMBURSMENT OVERVIEW GENERATE LETTER THROUGH MANUAL TEST PASSED <====");
			
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_roManualGenerateLetter");			
			logger.info("====> REIMBURSMENT OVERVIEW GENERATE LETTER THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}	
	
	
	
	
	@Parameters(value="tc_row")
	@Test(priority=6, dependsOnMethods = { "reimOverviewManual" })
	public void roManualAssessmentEnquiry(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);
			Thread.sleep(3000l);
			logger.info("<==== REIMBURSMENT OVERVIEW roManualAssessmentEnquiry THROUGH MANUAL TEST STARTED ====>");
			
			rOverview.clickAssessmentenquiry();
			logger.info("Assessment Enquiry Button Clicked");
			
			//===============================
			Thread.sleep(15000l);
			//===============================
			
			rOverview.enterClaimNuAssessment(TC_ReimDCTestManual_001.claimNumber);
			logger.info("Claim Number Entered");
			
			rOverview.clickGoAssessment();
			logger.info("Go Button Clicked");
			
			//===============================
			Thread.sleep(20000l);
			//===============================
			captureScreen(driver, row+"_Success_roManualAssessmentEnquiry");

			//Close Assessment Enquiry Pop up
			rOverview.clickCloseAssessmentPopup();
			logger.info("Assessment Enquiry pop up Closed");

			logger.info("====> REIMBURSMENT OVERVIEW roManualAssessmentEnquiry THROUGH MANUAL TEST PASSED <====");
			//driver.close();
			//SWITCH TO PREVIOUS TAB
			//driver.switchTo().window(tab1.get(1));
			
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_roManualAssessmentEnquiry");
			logger.info("====> REIMBURSMENT OVERVIEW roManualAssessmentEnquiry THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}	
	
	@Parameters(value="tc_row")
	@Test(priority=7, dependsOnMethods = { "reimOverviewManual" })
	public void roManualPendinNotification(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW roManualPendinNotification THROUGH MANUAL TEST STARTED ====>");
			
			rOverview.clickPendingNotification();
			logger.info("Pending Notification Button Clicked");
			
			//===============================
			Thread.sleep(5000l);
			//===============================
			
			//SWITCH TO GENERATE LETTER TAB
			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tab1.get(2));
			
			//==============================
			//Thread.sleep(15000l); // use sleep if required
			rOverview.waitLoader();
			//==============================
			captureScreen(driver, row+"_Success_roManualPendinNotification");
			
			// === CODE PENDING GENERATE LETTER

			if(ReimOverview.getReimOverview(currentRow,"TC_ID").contains("_GI_")){
				
				rOverview.clickGenerateLetter();
				logger.info("Generate Letter Button Clicked");
				
				//SWITCH TO GENERATE LETTER PAGE
				Thread.sleep(3000l);
				ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab2.get(3));
				//==============================
				
				rOverview.waitLoader();
	
				rOverview.gotoGeneratLetterbtn();
				logger.info("Go To Generate Letter Button");
				
				rOverview.clickGenerateLetterbtn();
				logger.info("Generate Letter button Clicked");
				
				rOverview.waitLoader();
				Thread.sleep(8000l);
				//==============================			
				captureScreen(driver, row+"_Success_roManualPendinNotificationLetter");
				
				logger.info("Screenshot captured of Generate Letter Page, Pending Notification.");
				
				//Close Current tab
				Thread.sleep(2000l);
				driver.close();
				
				//SWITCH TO PREVIOUS TAB
				Thread.sleep(2000l);
				driver.switchTo().window(tab1.get(2));	
			}
			
			else{
				
				logger.info("====> REIMBURSMENT OVERVIEW roManualPendinNotification THROUGH MANUAL TEST PASSED <====");
				
				//Close Current tab
				Thread.sleep(2000l);
				driver.close();
				
				//SWITCH TO PREVIOUS TAB
				Thread.sleep(2000l);
				driver.switchTo().window(tab1.get(1));
			}
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_roManualPendinNotification");			
			logger.info("====> REIMBURSMENT OVERVIEW roManualPendinNotification THROUGH MANUAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=9, dependsOnMethods = {"roManualPendinNotification"})
	public void roManualPendinNotificationLetter(String row) throws IOException, InterruptedException
	{
		logger.info("<==== Screenshot Already captured pending generate letter page ====>");
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=10, dependsOnMethods = { "reimOverviewManual" })
	public void roManualApprovedClaimSearch(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimOverviewPage rOverview = new ReimOverviewPage(driver);

			logger.info("<==== REIMBURSMENT OVERVIEW roManualApprovedClaimSearch THROUGH MANUAL TEST STARTED ====>");

			ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
			//Close Current tab
			driver.close();
			//SWITCH TO PREVIOUS TAB
			driver.switchTo().window(tab1.get(0));
			
			//======================================================================
			
			rOverview.selectStatusApproved(ReimOverview.getReimOverview(currentRow,"First Status"));
			logger.info("Approved Status Selected");
			
			String sheetClaim = ReimOverview.getReimOverview(currentRow,"CLAIM NO");
			System.out.println("Sheetclaim = "+ sheetClaim);
			
			String ClaimNumber;
			if(sheetClaim == ""){
			
				ClaimNumber = TC_ReimDCTestManual_001.claimNumber;
				rOverview.enterClaimNo(ClaimNumber);
				logger.info("Claim No Entered");
				
			}else
			{
				ClaimNumber = ReimOverview.getReimOverview(currentRow,"CLAIM NO");
				rOverview.enterClaimNo(ClaimNumber);
				logger.info("Claim No Entered");
			}
			
			
			rOverview.clickSearchAgain();
			logger.info("Search Button Clicked");
			
			//==== VERIFY LIST SEARCH ==============================================
			
			boolean chk = rOverview.verifyApprovedClaim(ClaimNumber);
			if(chk){
			
				logger.info("Claim Number Verified");
				
			}else{
				
				Assert.assertTrue(false,"Claim Number is not found on Claim List Page");
			}
				
			//======================================================================
			
			rOverview.waitLoader();
			captureScreen(driver, row+"_Success_roManualApprovedClaimSearch");
			logger.info("====> REIMBURSMENT OVERVIEW roManualApprovedClaimSearch THROUGH MANUAL TEST PASSED <====");
			
		
		} catch (Exception e) {
			
			logger.info("====> REIMBURSMENT OVERVIEW roManualApprovedClaimSearch THROUGH MANUAL TEST FAILED <====");
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_roManualApprovedClaimSearch");

			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}	
	

	
		
	@Parameters(value="tc_row")
	@Test(priority=11, dependsOnMethods = { "reimOverviewManual" })
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