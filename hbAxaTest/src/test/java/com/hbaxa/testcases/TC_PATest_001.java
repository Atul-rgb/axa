package com.hbaxa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.PAListPage;
import com.hbaxa.pageobjects.PAPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.PAData;

public class TC_PATest_001 extends BaseClass  {
	String parent;
	String child;
	String paNdetails;
	String toppaNdetails;
	String actions;
	String AlertMessage;
	String alertsAutoaudjudicateClick;
	String alertsApprovedClick;
	String alertsPendingClick;
	public static String paNumber;
	
	PAData paread = new PAData();
	LoginData ldread = new LoginData();
	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void paTestManual(String row) throws IOException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);		
			
			PAPage pa = new PAPage(driver);
			
			//Login Scenario
			logger.info("===== PA TEST STARTED THROUGH MANUAL PROCESS ====");
			
			driver.get(baseURL);
			logger.info("Base url launched ==>"+driver.getCurrentUrl());
			
			logger.info("Login test started");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setUserName(paread.getPaManual(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			lp.setPassWord(paread.getPaManual(currentRow,"Password")); // will make this code later under pa object page
			logger.info("Password Entered");
			
			lp.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//================
			
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
			//Thread.sleep(25000l); //for loader hard coded SLEEP TIME
			pa.waitLoader();
			logger.info("wait Loder");
			//===========================================
			//loadTimer.start();
			pa.clickaddManualPA();
			//loadTimer.stop();
			logger.info("Add Manual Pre-Approval Button Clicked");
			//logger.info("Add Manual Pre-Approval Button Clicked - Time Taken: "+ TimeUnit.MILLISECONDS.toSeconds(loadTimer.getTime()) +" seconds");
			
			//===========================================
			//ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//driver.switchTo().window(tabs.get(1));
			//String parent = driver.getWindowHandle();
			Set <String> st= driver.getWindowHandles();
			Iterator<String> it = st.iterator();
			parent =  it.next();
			child = it.next();
			
			//swtich to parent
			//driver.switchTo().window(parent);
			//System.out.println("Returned to parent");

			// switch to child tab
			driver.switchTo().window(child);
			
		
			//===========================================
			
			//pa.clickShowhide(); // Behavior changed
			//logger.info("Show/Hide Document Button Clicked");
			
			Thread.sleep(8000l);
			pa.setSearchPolicy(paread.getSearchPolicy(currentRow, "SearchPolicy"));
			logger.info("Policy Number Entered");
			
			//Thread.sleep(2000l);
			loadTimer.start();
			pa.selectPolicy(row);
			loadTimer.stop();
			logger.info("Policy Selected - Time Taken: "+ TimeUnit.MILLISECONDS.toSeconds(loadTimer.getTime()) +" seconds");
			
			//===========================================
			//Thread.sleep(15000l); //For Loader
			pa.waitLoader();
			//===========================================			
			
			//pa.scrolltopad();
			//logger.info("Scroll To Pre Approval Details");
			
			Thread.sleep(1000l);
			pa.selectMedicalCardType(paread.getPaManual(currentRow, "Medical Card Type"));
			logger.info("Medical Card Type Selected");
			
			
			loadTimer.reset();
			loadTimer.start();
			Thread.sleep(1000l);
			pa.getDocName(paread.getPaManual(currentRow, "Attending Doctor Name"));
			logger.info("Doctor Name Entered");
			
			Thread.sleep(2000l);
			pa.selectDocName();
			loadTimer.stop();
			logger.info("Doctor Name Selected - Time Taken: "+ TimeUnit.MILLISECONDS.toSeconds(loadTimer.getTime()) +" seconds");
			
			//===========================================
			//Thread.sleep(10000l); //For loader hard coded
//			pa.waitLoader();
			//===========================================
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			
			pa.getSymptomDate(paread.getPaManual(currentRow, "Symptom / Onset Date"));
			logger.info("Symptom / Onset Date Entered");
			
			pa.getConsultationDate(paread.getPaManual(currentRow, "First Consultation Date"));
			logger.info("First Consultation Date Entered");
			
			pa.getAdmissionDate(paread.getPaManual(currentRow, "Admission Date"));
			logger.info("Admission Date Entered");
			
			//pa.waitLoader();
			//Thread.sleep(15000l); // For a time being extending time to load properly
			pa.waitLoader();
			
			pa.getDischargeDate(paread.getPaManual(currentRow, "Discharge Date"));
			logger.info("Discharge Date Entered");
			
			pa.getTreatmentDate();
			logger.info("Treatment Date Clicked, Auto Calculated & Entered");
			
			pa.getSymptom(paread.getPaManual(currentRow, "Symptom / Complaint"));
			logger.info("Symptom / Complaint Entered");
			
			pa.getContactNumber(paread.getPaManual(currentRow, "Contact No. (Insured)"));
			logger.info("Contact No. (Insured) Entered");
			
			pa.getBillcurrency(paread.getPaManual(currentRow, "Bill Currency"));
			logger.info("Bill Currency Selected");
			
			//======================================
			Thread.sleep(4000l);
			
			
			//======================================
			
			pa.goToDiagnosisView();
			logger.info("Go To Diagnosis View");
			
			//======================================
			Thread.sleep(4000l);
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			//======================================
			
			pa.getIcdCode(paread.getPaManual(currentRow, "ICD Code / Description"));
			logger.info("ICD Code / Description Entered");
			
			Thread.sleep(2000l);
			pa.selectIcdCode(row);
			logger.info("ICD Code / Description Selected");
			
			//===========================================
			//Thread.sleep(10000l); // for loader
			pa.waitLoader();
			//===========================================
			pa.goToDiagnosisView();
			logger.info("Scroll the ICD add ");
			pa.getAddIcdCode();
			logger.info("ADD(ICD) Button Clicked");
			
			Thread.sleep(3000l);
			pa.goToDoctorFee();
			logger.info("Go To Doctor Fee");
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			
			pa.getDfBenefitItem(paread.getPaManual(currentRow, "DF Benefit Item"));
			logger.info("Doctor Fee Benefit Item Entered");
			
			Thread.sleep(2000l);
			
			
			
			pa.selectdfeeBenefitItem(row);
			logger.info("DF Benefit Item Selected");
			
			//===========================================
			//Thread.sleep(10000l); // For hard code sleep wait
//	    	pa.waitLoader();
			//===========================================			
			
			pa.getdfRequestedAmount(paread.getPaManual(currentRow, "DF Requested Amount"));
			logger.info("Doctor Fee Requested Amount Entered");
			
			Thread.sleep(1000l);
				pa.getdfApprovedAmount(paread.getPaManual(currentRow, "DF Approved Amount"));
			logger.info("Doctor Fee Approved Amount Entered");
			
			pa.clickAnesthesiologistfee();
			logger.info("Anesthesiologist's fee Clikced");
						
			Thread.sleep(3000l);
			pa.getAddDocFee();
			logger.info("Doctor Fee Add Button Clicked");
			Thread.sleep(2000l);
			
			//Hospital Charges =========================
			pa.goToHospitalCharges();
			logger.info("Go To Hospital Charges");
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			
			pa.getHCBenefitItem(paread.getPaManual(currentRow, "HC Benefit Item"));
			logger.info("HC Benefit ITem Entered");
			
			Thread.sleep(11000l);
			
			
			
			pa.selecteHCBenefitItem(row);
			logger.info("HC Benefit Item Selected");
			
		Thread.sleep(1000l);
			pa.getHCRequestedAmount(paread.getPaManual(currentRow, "HC Requested Amount"));
			logger.info("HC Requested Amount Entered");
			
			Thread.sleep(1000l);
			pa.getHCApprovedAmount(paread.getPaManual(currentRow, "HC Approved Amount"));
			logger.info("HC Approved Amount Entered");
			
			Thread.sleep(2000l);
			pa.getAddHospitalCharges();
			logger.info("Hospital Charges Add Button Clicked");

			
			Thread.sleep(2000);
			if(paread.getPaManual(currentRow, "Card Details").equalsIgnoreCase("Yes")){
			
				//CARD DETAILS
				pa.goTOCardDetails();
				logger.info("Go TO Card Details");
				
				pa.getCardNumber(paread.getPaManual(currentRow, "Card no."));
				logger.info("Card Number Entered");
	
				pa.getCardMonth();
				logger.info("Card Month Clicked");
				
				pa.getCardMonth(paread.getPaManual(currentRow, "Expiry Date"));
				logger.info("Expire Date/Month Selected");

			}
			
			pa.inputRemarks(paread.getPaManual(currentRow, "Remarks"));
			logger.info("Remarks Entered");
			
			Thread.sleep(2000);
			
			pa.saveButton();
			logger.info("Save Button Clicked");
			
			paNdetails = pa.getpaNotification();
			logger.info("Alert Message: "+ paNdetails);
			
			String preANumber = regExtract(paNdetails);
			
			// TODO PA INDEXING saved claim search ====
			
			if(paread.getPaManual(currentRow, "indexPaSearch").equalsIgnoreCase("Yes")){
				
				pa.clickYestoindexing();
				logger.info("Click Yes to back index page");
				
				pa.waitLoader();
				
				logger.info("<=== Start to search save pa in indexing page ====>");
				
				pa.enterPAtoSearch(preANumber);
				logger.info("Enter PA number to search in indexing page="+preANumber);
				
				pa.clickSearchbtn();
				logger.info("Clicked on search Button");
				
				//==== VERIFY PA SEARCH on Indexing page==============================================
				
				boolean chk = pa.verifypa(preANumber);
				
				if(chk){
				
					logger.info("Search pa verified on indexing page.");
					Thread.sleep(3000l);
					captureScreen(driver,row+"_Success_indexPASearch");
					
				}else{
					
					Assert.assertTrue(false,"PA Number is not found on Indexing Page");
					captureScreen(driver,row+"_indexPASearch");
				}
					
				//======================================================================				
				
				pa.clickpaProceed();
				logger.info("Click on Proceed");
				
				logger.info("===> Process complete to search save pa in indexing page <====");
				
				
			}
			
			// ========================================
			
			//=================
			//Thread.sleep(20000l); // For hard code sleep wait
			pa.waitLoader();
			//=================
			
			if (paNdetails.equalsIgnoreCase("Case has been updated")) {
				
				toppaNdetails = pa.moveToTop();
				logger.info("Success: "+ toppaNdetails);

			} else {
				
				if(paread.getPaManual(currentRow, "indexPaSearch").equalsIgnoreCase("Yes")){
					//pa.getNoTOStay();
					logger.info("No Clicked...Bypass");
				}else{
					pa.getNoTOStay();
					logger.info("No Clicked...");
				}
			}
			
			//===============
			//Thread.sleep(25000l);
			//===============

			
			//===============
			//Thread.sleep(30000l); // For hard code sleep wait
			pa.waitLoader();
			//===============
			pa.clickShowhide2(); // Behavior changed
			logger.info("Show/Hide Document Button Clicked");			
			
			//========== CODE FOR ASSESSMENT ENQUIRY =======================
			
			if(paread.getPaManual(currentRow, "Assessment Enquiry").equals("Yes")){
				
				pa.clickAssessmentEnquiry();
				logger.info("Assessment Enquiry clicked");
				//Thread.sleep(10000l); // For hard code sleep wait
				pa.waitLoader();
				
				String getPANumber = regExtract(paNdetails);
				
				//pa.clickViewAssesment();
				//logger.info("View Clicked");
				
				pa.clickAddAssessment();
				logger.info("Add Assessment Clicked");
				
				//Thread.sleep(7000l); // For hard code sleep wait
				pa.waitLoader();
				
				pa.selectPanumberforassessment(getPANumber);
				logger.info("PA Number Selected");
				
				Thread.sleep(1000l);
				pa.enterTextArea(paread.getPaManual(currentRow, "Assessment Text"));
				logger.info("Text Area Entered in Assessment Enquiry Page");

				Thread.sleep(1000l);
				pa.clickAddforAssessmentEnq();
				logger.info("Add clicked for Assessment Enquiry");
				
		        //Thread.sleep(5000l); // For hard code sleep wait
				pa.waitLoader();
		        
		        pa.enterPanumberAssessment(getPANumber);
		        logger.info("PA Number Entered for Search Assessment Enq");

		        Thread.sleep(1000l);
		        pa.clickGoAssessmentEnq();
		        logger.info("Go Clicked for Assessment Search");
		        
		        //Thread.sleep(10000l); //loader
		        pa.waitLoader();
		        
		        captureScreen(driver,row+"_Success_paassessmentEnq");
		        logger.info("Screenshot Caputered for Assessment Enquiry");
		        
		        Thread.sleep(1000l);
		        pa.clickCloseAssessmentEnq();
		        logger.info("Assesment Eqnuiry Pop Up Closed");
				
				
			}
			
			//==============================================================
			
			Thread.sleep(8000l);
			pa.waitLoader(); //if  any
			
			pa.clickautoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			alertsAutoaudjudicateClick = pa.getpaNotification();
			logger.info("Alert Message: "+ alertsAutoaudjudicateClick);			
			
			//================
			//Thread.sleep(25000l); // For hard code sleep wait
			pa.waitLoader();
			//=================
			
			pa.gotoPreApprovalResult();
			logger.info("Go To Pre Approval Result");
			captureScreen(driver,row+"_Success_paTestManual");
			logger.info("Screenshot captured of Pre Approval Result");
			
			//========== Move To Pre Approval Details FOR LOG AMOUNT CASE ===================================
			
			if (paread.getPaManual(currentRow, "Log Amount").equals("Yes")) {

				Thread.sleep(4000l);
				pa.scrolltopad();
				logger.info("Scroll To Pre Approval Details");
				
				Thread.sleep(2000l);
				pa.chekLogAmount();
				logger.info("Logged Amount Checked");
				
				Thread.sleep(2000l);
				pa.enterLogAmount(paread.getPaAdjustment(currentRow, "Log Amount if empty"));
				logger.info("Log Amount Entered");
				
			}			
			
			//===================
			//Thread.sleep(10000l); might be loader if any
			pa.waitLoader();
			//===================
			
			//============= FOR ACTIVITY LOG =======================================
			
			if(paread.getPaManual(currentRow, "Activity Log").equalsIgnoreCase("Yes")){
				
				pa.clickActivityLog();
				logger.info("Activity Log Clicked..");
				
				Thread.sleep(4000l);
				captureScreen(driver,row+"_Success_paActivityLog");
				logger.info("Screenshot caputred for Activity Log");
				
				pa.clickCloseActivityLog();
				logger.info("Close Activity Log Pop up");
			}
			
			//============= FOR APPROVE CASE =======================================

			Thread.sleep(2000l);
			if(paread.getPaManual(currentRow, "Approve").equalsIgnoreCase("Yes")){
				
				pa.clickApprove();
				logger.info("Approve Clicked...");
				
				if(paread.getPaManual(currentRow, "Log Amount").equalsIgnoreCase("No")) //change it to NO if yes
				{
					System.out.println("if value - " +paread.getPaManual(currentRow, "Log Amount"));
					
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
					//Thread.sleep(15000l); // For hard code sleep wait
					pa.waitLoader();
					//===================
					
					pa.clickBackToApprove();
					logger.info("Back TO Approve Clicked...");					

				}else{
					
					System.out.println("Else value - " +paread.getPaManual(currentRow, "Log Amount"));
					
					actions = "Approve";
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l); // For hard code sleep wait
					pa.waitLoader();
					//===================
					
					pa.clickBackToApprove();
					logger.info("Back TO Approve Clicked...");
				
				}

				//============= FOR PENDING CASE =======================================
			}else if(paread.getPaManual(currentRow, "Pending").equalsIgnoreCase("Yes")){
				
					actions = "Pending";
					
					pa.clickPending();
					logger.info("Pending Clicked...");
					
					pa.clickReasonForPending();
					logger.info("Reason For Pending List Clicked");
					
					pa.selectReasonForPending(row);
					logger.info("Option Selected for Reason For Pending");
					
					pa.clickSubmitReasonForPending();
					logger.info("Submit Clicked of Reason For Pending");
					
					alertsPendingClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsPendingClick);
	
					//Thread.sleep(15000l); // For hard code sleep wait
					pa.waitLoader(); // if any
					
					pa.clickBackToPending();
					logger.info("Back To Pending Clicked");
				
				//============= FOR REJECT CASE =======================================
			}else if(paread.getPaManual(currentRow, "Reject").equalsIgnoreCase("Yes")){
				
				actions = "Reject";
				
				pa.clickReject();
				logger.info("Reject Clicked...");
				
				pa.clickReasonForReject();
				logger.info("Reason For Reject List Clicked");
				
				pa.selectReasonForReject(row);
				logger.info("Option Selected for Reason For Reject");
				
				pa.clickSubmitReasonForReject();
				logger.info("Submit Clicked of Reason For Reject");
				
				/*if(!pa.getpaNotification().isEmpty())
				{
					String alertsRejectClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsRejectClick);
				}*/
				
				//Thread.sleep(15000l); //// For hard code sleep wait
				pa.waitLoader(); //if any
				
				pa.clickBackToReject();
				logger.info("Back To Reject Clicked");
			}
			
			logger.info("==> Process Complete of Save(Generate PA No.), auto-audjudicate, and "+actions+" Clicked <==");
			
			
		} catch (Exception e) {

			logger.info("paTestManual Fail");
			captureScreen(driver, row+"_paTestManual");// first parameter is driver, // second is test name.		
																			
			e.printStackTrace();

			if (child.equals(child)) {
				//============================================================================================================
				//driver.close();
			}
		//	driver.switchTo().window(parent);
			Assert.assertTrue(false);

		}
		
	
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "paTestManual" })
	public void palistSearch(String row) throws IOException
	{
		try {
			
			logger.info("==== "+actions+" PA Search Started ====");
			PAListPage palistp = new PAListPage(driver);
			
			paNumber = regExtract(paNdetails);

			System.out.println(paNumber);
			
			//Thread.sleep(10000l);  // for loader
			palistp.waitLoader();
			
			palistp.txtPaNum(paNumber);
			logger.info("PA Number Entered="+paNumber);
			
			Thread.sleep(1000l); 
			palistp.waitLoader();
			palistp.clickGO();
			logger.info("Go Clicked for PA Search");
			
			//Thread.sleep(5000l); // for loader
			palistp.waitLoader();
			
			captureScreen(driver,row+"_Success_palistSearch");
			logger.info("Screenshots captured for search PANumber");
			logger.info("====> "+actions+" PA Search Passed <====");
			
		} catch (InterruptedException e) {
			
			
			logger.info("====> "+actions+" PA Search Failed <====");
			captureScreen(driver, row+"_palistSearch");
			
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
			
			
		}
		
	}
	
//=============================================================================================
	
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "palistSearch" })
	public void paGenerateLetter(String row) throws IOException
	{
		int currentRow = Integer.parseInt(row);	
		try {
			
			if(actions.equals("Approve"))
			{
			
				logger.info("==== "+actions+" PA Letter Generation Started ====");
				//PAPage pa = new PAPage(driver);
				PAListPage palistp = new PAListPage(driver);
				
				//========================================
				Thread.sleep(4000l);
				palistp.clickPreApprovalView();
				logger.info("Pre Approval View Clicked");
				
				// ====> REDIRECTING TO PRE APPROVAL VIEW PAGE <====
				ArrayList<String> tab1 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab1.get(2));
				
				//Thread.sleep(10000l);// for loader			
				palistp.waitLoader();
				
				// === FOR SCREENSHOT OF PRE-APPROVAL VIEW PAGE
				Thread.sleep(8000l);
				//captureScreen(driver,row+"_Success_paViewpage");
				captureScreenfullPage(driver,row+"_Success_paViewpage");
				logger.info("Full Screenshots captured of pre-approval view page");
				
				if(paread.getPaManual(currentRow, "TC_ID").contains("LIFE")){
					
					palistp.clickGenerateLetterLife();
					logger.info("Generate Letter Button Clicked");
					
				}else{
					
					palistp.clickGenerateLetterGI();
					logger.info("Generate Letter Button Clicked");
					
				}
				
				
				//SWITCH TO GENERATE LETTER TAB
				ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tab2.get(3));
				
				//GO TO GENERATE LETTER BUTTON
				Thread.sleep(10000l);
				palistp.gotoGenerateLetterButton();
				logger.info("Scroll to generate letter Button");
				
				palistp.clickgenerateLetterPage();
				logger.info("Generate Letter Page Clicked");
				
				//=========================================
				//Thread.sleep(13000l);
				palistp.waitLoader();
				
				captureScreen(driver,row+"_Success_paGenerateLetter");

				// ===== VERIFY PDF AVAILABLILITY =====================
				
				boolean chkPDF = palistp.validatepdf();
				
				if(chkPDF == true){
					
					logger.info("PDF Displayed.");
					
				}
				
				
				else
				{
					logger.info("PDF Not Displayed.");
					Assert.assertTrue(false, "PDF Not Displyed After Generate click");
				}		
				
				//driver.close();
				// ==================================================
				
				//captureScreen(driver,row+"_Success_paGenerateLetter");
				logger.info("Screenshots captured for search PANumber");
				
				logger.info("====> "+actions+" PA Letter Generation Passed <====");
			
			}else {
				
				logger.info("====> PA was not approved, that's why pa letter not generated <====");
			}
			
			//////Close the browser
		    driver.quit();
		logger.info("letter closed");
		
		}
		
		catch (InterruptedException e) {
			
			logger.info("====> "+actions+" PA Letter Generation Failed <====");
			captureScreen(driver, row+"_paGenerateLetter");			
			
			e.printStackTrace();
		
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
		}
		
		
		
		}
	
	
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "paTestManual" })
	public void indexPASearch(String row) throws IOException
	{	
		// STEPS ALREADY COVERD IN paTestManual TEST
		logger.info(" ====> Screenshot already captured for PA search on index Page <====");
	}		
	
	@Parameters(value="tc_row")
	@Test(priority=5, dependsOnMethods = { "paTestManual" })
	public void paassessmentEnq(String row) throws IOException
	{	
		// STEPS ALREADY COVERD IN paTestManual TEST
		logger.info(" ====> Screenshot already captured for Assessment Enquiry <====");
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=6, dependsOnMethods = { "paTestManual" })
	public void paActivityLog(String row) throws IOException
	{	
		// STEPS ALREADY COVERED IN paTestManual TEST
		logger.info(" ====> Screenshot already captured for Activity Log <====");
	}	
	
	@Parameters(value="tc_row")
	@Test(priority=7, dependsOnMethods = { "paGenerateLetter" })
	public void paViewpage(String row) throws IOException
	{	
		// STEPS ALREADY COVERD IN paGenerateLetter TEST
		logger.info(" ====> Screenshot already captured for Pre-Approval View Page <====");
		
		
		

		
	}
	
	
	
}


   
