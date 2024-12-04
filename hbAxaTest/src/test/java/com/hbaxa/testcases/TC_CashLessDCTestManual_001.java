package com.hbaxa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.CashlessDCapturePage;
import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.ReimDCapturePage;
import com.hbaxa.testdata.CashlessdcaptureData;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.ReimdcaptureData;

public class TC_CashLessDCTestManual_001 extends BaseClass {
	String claimdetails;
	String alertmsg;
	public static String claimNumber;
	
	CashlessdcaptureData CashlessDCapturedread = new CashlessdcaptureData();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginLevel0Test(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched - "+driver.getCurrentUrl());
			
			logger.info("<===== Login test started ====>");
			
			CashlessDCapturePage cashlessdCapture = new CashlessDCapturePage(driver);
			
			cashlessdCapture.setUserName(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			cashlessdCapture.setPassWord(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Password"));
			logger.info("Password Entered");
			
			cashlessdCapture.clickSubmit();
			logger.info("Submit Button Clicked");
			
			if(driver.getTitle().equals("Home Page"))
			{
				Assert.assertTrue(true);
				logger.info("====> Login Test Pass <====");

				Thread.sleep(3000l);
				captureScreen(driver, row+"_Success_loginLevel0Test");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("Login Test Fail");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_loginLevel0Test");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
	
			}
		
	}
	

	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginLevel0Test" })
	public void cashlessDCaptureManual(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			CashlessDCapturePage cashlessdCapture = new CashlessDCapturePage(driver);

			logger.info("<==== CASHLESS DATA CAPTURE THROUGH MANUAL TEST STARTED ====>");
			
			//Menu Navigation =========
			cashlessdCapture.clickClaim();
			logger.info("Claim clicked");
			
			Thread.sleep(1000l);
			cashlessdCapture.clickCashlessdc();
			logger.info("Cashless Clicked");
			
			Thread.sleep(1000l);
			cashlessdCapture.clickDataCapture();
			logger.info("DataCapture Clicked");
			
			//===============================
			//Thread.sleep(10000l); // use sleep for loader
			cashlessdCapture.waitLoader();
			//===============================
			
			cashlessdCapture.clickAddManualClaim();
			logger.info("Add Manual Claim Clicked");
			
			//===============================
			//Thread.sleep(10000l); // use sleep for loader
			cashlessdCapture.waitLoader();
			//================================
			
			cashlessdCapture.clickModify();
			logger.info("Clicked Modify to Enter Policy Number");	
			
			cashlessdCapture.enterPolicyNo(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SearchPolicy"));
			logger.info("Policy Number Entered..");
			
			Thread.sleep(2000l);
			cashlessdCapture.selectPolicy(row);
			logger.info("Policy Selected..");
			
			//alertmsg = cashlessdCapture.getAlertNotification1();
			//logger.info("Alert Message: "+ alertmsg);
			
			//====================================
			//Thread.sleep(15000); // use sleep for loader
			cashlessdCapture.waitLoader();
			//====================================
			
			cashlessdCapture.clickPreApprovalHistory();
			logger.info("Pre Approval History Clicked");
			
			//====================================
			//Thread.sleep(15000); // use sleep for loader
			cashlessdCapture.waitLoader();
			//====================================
			
			
			try {
				
				cashlessdCapture.viewMore();
				logger.info("View More Clicked");
				
				Thread.sleep(2000l);
				cashlessdCapture.enterSearchText(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Select Approved PA"));
				logger.info("Search Text Entered -  Pre Approval Approved");
				boolean viewmore= cashlessdCapture.checkview();
				System.out.println(viewmore);
				if(viewmore==true){
					cashlessdCapture.clickProceed();
					logger.info("Proceed Clicked");
					}
				else{
			   cashlessdCapture.clickProceedOne();
			   logger.info("Proceed Clicked");
				}
				} catch (Exception e) {
				
				System.out.println(e.getMessage());

				//e.printStackTrace();
			}
			
			Thread.sleep(4000l);
			driver.switchTo().alert().accept();
			logger.info("Alert accepted");
			
			//====================================
			//Thread.sleep(25000); // use sleep for laoder
			cashlessdCapture.waitLoader();
			//====================================
			
			cashlessdCapture.gotoCreationForm();
			logger.info("Go To Creation Form");
			
			cashlessdCapture.enterTreatmentLoc(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Treatment Location"));
			logger.info("Treatment Location Entered");

			Thread.sleep(3000l);
			cashlessdCapture.selectTreatmentLoc(row);
			logger.info("Treatment Location Selected");
			
			/*cashlessdCapture.enterDoctorName(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Attending Doctor Name"));
			logger.info("Doctor Name Entered");
			
			Thread.sleep(3000l);
			cashlessdCapture.selectDoctorName(row);
			logger.info("Doctor Name Selected");*/
			
			cashlessdCapture.enterDateofAdmission(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Date of Admission"));
			logger.info("Date of Admission Entered");
			
			cashlessdCapture.enterAdmissionTime(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Admission Time"));
			logger.info("Admission Time Entered");	
			
			cashlessdCapture.enterDateofDischarge(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Date Of Discharge"));
			logger.info("Date of Discharge Entered");
			
			cashlessdCapture.enterDischargeTime(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Discharge time"));
			logger.info("Discharge Time Entered");

			cashlessdCapture.enterContactNumber(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Contact No. (Insured)"));
			logger.info("Contact Number Entered");
			
			cashlessdCapture.enterEmailAddress(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Email Address (Insured)"));
			logger.info("Email Adress Entered");	
			
			cashlessdCapture.enterSymptomdate(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Symptom / Onset Date"));
			logger.info("Symptom Date Entered");
			
			cashlessdCapture.enterFirstConsultdate(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Symptom / Onset Date"));
			logger.info("First Consultation Date Entered");
			
			cashlessdCapture.enterTreatmentmdate(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Symptom / Onset Date"));
			logger.info("Treatment Date Entered");
			
			cashlessdCapture.enterSymptom(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Symptom/complaint"));
			logger.info("Symptom/complaint Entered");
			
			cashlessdCapture.selectBillCurrency(CashlessDCapturedread.getCashlessDataCapture(currentRow,"CF Bill Currency"));
			logger.info("Bill Currency Selected");
			
			//Thread.sleep(5000l);
			
			cashlessdCapture.waitLoader();
			cashlessdCapture.gotoIcdDescription();
			logger.info("Go To ICD Description");
			

			if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Multi Icd").equalsIgnoreCase("No")){
				
				String totalIcdcode = CashlessDCapturedread.getCashlessDataMultiICD(currentRow, "Total ICD Code");
				
				int totalicd = Integer.parseInt(totalIcdcode);
				System.out.println("Total Bill = "+totalicd);
				
				for(int i = 1; i<=totalicd; i++){
					
					Thread.sleep(3000l);
					String icd_code = CashlessDCapturedread.getCashlessDataMultiICD(currentRow,"ICD Code"+i);
					cashlessdCapture.enterICDCode(icd_code);
					logger.info(i+" ICD CODE ENTERED - "+icd_code);
					
					Thread.sleep(2000l);
					cashlessdCapture.selectMultiICDCode(row,i);
					logger.info(i+" ICD CODE Selected - "+icd_code);
					
					cashlessdCapture.clickICDAddBtn();
					logger.info(i+" ICD ADD BUTTON CLICKED");					
					
				}
				
			}else {
			
					cashlessdCapture.enterICDCode(CashlessDCapturedread.getCashlessDataCapture(currentRow,"ICD Code"));
					logger.info("ICD CODE ENTERED");
					
					Thread.sleep(3000l);
					cashlessdCapture.selectICDCode(row);
					logger.info("ICD CODE Selected");
					
					cashlessdCapture.clickICDAddBtn();
					logger.info("ICD ADD BUTTON CLICKED");
			}
			
			cashlessdCapture.waitLoader();
			
			// ===== VERIFY ICD TABLE =====================
			//Thread.sleep(2000l);
			boolean chkicdtable = cashlessdCapture.validateICDTable();
			if(chkicdtable == true){
				
				logger.info("ICD Table Displyed.");
			}else
			{
				logger.info("ICD Table Not Displyed.");
				Assert.assertTrue(false, "ICD Table Not Displyed After Add click");
			}
			
			
			
			//======= SURGERY DESCRIPTION ========
			cashlessdCapture.gotoSurgeryDescription();
			logger.info("Go To Surgery Description");
			
		if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Multi Surgery Code").equalsIgnoreCase("Yes")){
				
				String totalSurgerycode = CashlessDCapturedread.getCashlessDataMultiSurgeryCode(currentRow, "Total SD Code");
				
				int totalsurgery = Integer.parseInt(totalSurgerycode);
				System.out.println("Total Bill = "+totalsurgery);
				
				for(int i = 1; i<=totalsurgery; i++){
					
					Thread.sleep(2000l);
					cashlessdCapture.enterSurgeryCode(CashlessDCapturedread.getCashlessDataMultiSurgeryCode(currentRow,"SD Code"+i));
					logger.info(i+" Surgery Code Entered");
					
					Thread.sleep(2000l);
					cashlessdCapture.selectMultiSurgeryCode(row,i);
					logger.info(i+" Surgery Code Selected");
					
					Thread.sleep(1000l);
					cashlessdCapture.enterSurgeryAmt(CashlessDCapturedread.getCashlessDataMultiSurgeryCode(currentRow,"SD AMOUNT"+i));
					logger.info(i+" Surgery Amount Entered");
					
					Thread.sleep(2000l);
					cashlessdCapture.clickaddSurgeryBtn();
					logger.info(i+" Surgery Button Add Clicked");
				
				}
				
			}else{
				
					cashlessdCapture.enterSurgeryCode(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SD Code"));
					logger.info("Surgery Code Entered");
					
					Thread.sleep(2000l);
					cashlessdCapture.selectSurgeryCode(row);
					logger.info("Surgery Code Selected");
					
					cashlessdCapture.enterSurgeryAmt(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SD AMOUNT"));
					logger.info("Surgery Amount Entered");
					
					Thread.sleep(2000l);
					cashlessdCapture.clickaddSurgeryBtn();
					logger.info("Surgery Button Add Clicked");
			}	
			
			
			//Thread.sleep(3000l);
			cashlessdCapture.waitLoader();
			
			boolean chksugerytable = cashlessdCapture.validateSurgeryTable();
			if(chksugerytable == true){
				
				logger.info("Surgery Table Displyed.");
			}else
			{
				logger.info("Surgery Table Not Displyed.");
				Assert.assertTrue(false, "Surgery Table Not Displyed After Add click");
			}
			
			
			//======= SETTLEMENT METHOND =========
			//Thread.sleep(4000l);
			cashlessdCapture.gotoSettlementMethod();
			logger.info("Go To Settlement Method");
			
			if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type").equalsIgnoreCase("By Cheque"))
			{
				cashlessdCapture.selectSettelementType(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type"));
				logger.info("Settlement Type Selected");
				
				Thread.sleep(3000l);
				cashlessdCapture.clickMemberAddress();
				logger.info("Member Address Clicked");
				
				cashlessdCapture.enterPayeeNameCheck(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Payee Name"));
				logger.info("Payee Name Entered By Cheque");
			}
			
			
			 else if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type").equalsIgnoreCase("By Autopay"))
			{
				cashlessdCapture.selectSettelementType(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type"));
				logger.info("Settlement Type Selected");
				
				cashlessdCapture.enterBankNumber(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Bank No"));
				logger.info("Bank No Entered");
				
				cashlessdCapture.enterBranchNumber(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Branch No"));
				logger.info("Branch No Entered");
				
			

				cashlessdCapture.enterAccountNumber(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Account No"));
				logger.info("Account No Entered");

				cashlessdCapture.enterConfirmAccountNumber(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Confirm Account No"));
				logger.info("Confirm Account No Entered");
				
				cashlessdCapture.enterPayeeNameAuto(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Payee Name"));
				logger.info("Payee Name Entered By Autopay");

			}
			
			 else if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type").equalsIgnoreCase("Non- cross cheque")){
				 cashlessdCapture.selectSettelementType(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type"));
				 cashlessdCapture.clicknoncrossMemberAddress();	 
				 logger.info("Non- cross cheque");
			 }
			
			
			 else if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type").equalsIgnoreCase("Overseas TT")){
			 cashlessdCapture.selectSettelementType(CashlessDCapturedread.getCashlessDataCapture(currentRow,"SM Settlement Type")); 
			 	 
			 }
			
			//======== DISPLAY BILL ========
			Thread.sleep(3000l);
			cashlessdCapture.gotoDisplayBill();
			logger.info("GO TO DISPLAY BILL");
			
			if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Input By Bill Item").equalsIgnoreCase("Yes")){
				
				System.out.println("if part");
				
				Thread.sleep(5000l);
				cashlessdCapture.clickInputByBillItem();
				logger.info("Clicked Input By Bill Item");
				
				cashlessdCapture.clickOnOkinputbybill();
				logger.info("Ok Clicked..");
				
				if(CashlessDCapturedread.getCashlessDataCapture(currentRow, "Multi Billing").equalsIgnoreCase("Yes")){

					String totalBillstring = CashlessDCapturedread.getClessDataMultiBill(currentRow, "Total Bill Item");
					int totalBill = Integer.parseInt(totalBillstring);
					
					for(int i = 1; i<=totalBill; i++){
						
						Thread.sleep(2000l);
						cashlessdCapture.enterChargeDate(CashlessDCapturedread.getClessDataMultiBill(currentRow,"Charge Date"));
						logger.info("Charge Date Entered");	
						
						cashlessdCapture.enterBillItem(CashlessDCapturedread.getClessDataMultiBill(currentRow,"Bill Items"+i));
						logger.info("Bill"+i+" Item Entered");
						
						Thread.sleep(2000l);
						cashlessdCapture.selectMultiBillItem(row,i);
						logger.info("Bill"+i+" Item Selected");
						
						Thread.sleep(2000l);
						String claim_amount = CashlessDCapturedread.getClessDataMultiBill(currentRow,"BI"+i+"_CLAIM_AMOUNT");
						cashlessdCapture.enterBillitemAmount(claim_amount);
						logger.info("Bill"+i+" Amount Entered -- "+ claim_amount );
						
						Thread.sleep(2000l);
						cashlessdCapture.selectdbBillBenefitItem(CashlessDCapturedread.getClessDataMultiBill(currentRow,"BI"+i+"_Benefit items"));
						logger.info("dbbillBenefit"+i+" Item Selected");
						
						Thread.sleep(3000l);
						cashlessdCapture.clickAddbyitembill();
						logger.info("Add Bill Button Clicked");	
					}
					
				}else{
				
						cashlessdCapture.enterChargeDate(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBILL Charge Date"));
						logger.info("Charge Date Entered");
						
						cashlessdCapture.enterBillItem(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBILL Bill Item"));
						logger.info("Bill Item Entered");
						
						Thread.sleep(2000l);
						cashlessdCapture.selectBillItem(row);
						logger.info("Bill Item Selected");
						
						cashlessdCapture.enterBillitemAmount(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBILL Bill Amount"));
						logger.info("Bill Amount Entered");
						
						Thread.sleep(2000l);
						cashlessdCapture.selectdbBillBenefitItem(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Bill Benefit items"));
						logger.info("dbbillBenefit Item Selected");						
						
						Thread.sleep(3000l);
						cashlessdCapture.clickAddbyitembill();
						logger.info("Add Bill Button Clicked");
				
				}
				
			}else if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Input By Benefit Item").equalsIgnoreCase("Yes")){

				System.out.println("2nd if part");
				
				Thread.sleep(5000l);
				cashlessdCapture.clickInputByBenefitItem();
				logger.info("Clicked Input By Benefit Item");
				
				cashlessdCapture.clickOnOkinputbybenefit();
				logger.info("Ok Clicked..");
				
				
				if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Multi Billing").equalsIgnoreCase("Yes")){
					
					String totalBillstring = CashlessDCapturedread.getCashlessDataMultiBillBenefit(currentRow, "Total Bill Item");
					int totalBill = Integer.parseInt(totalBillstring);
					
					for(int i = 1; i<=totalBill; i++){
						
						Thread.sleep(3000l);
						String chargeDate = CashlessDCapturedread.getCashlessDataMultiBillBenefit(currentRow, "Charge Date"+i);
						cashlessdCapture.enterchargeDate(chargeDate);
						logger.info(i+" Bill charge date entered. - " +chargeDate);
						
						Thread.sleep(4000l);
						String benefitItems = CashlessDCapturedread.getCashlessDataMultiBillBenefit(currentRow,"Benefit Item"+i);
						cashlessdCapture.selectBenfitItem(benefitItems);
						logger.info(i+" Benefit Item Selected - "+benefitItems);
						
						Thread.sleep(2000l);
						String noClaimDays = CashlessDCapturedread.getCashlessDataMultiBillBenefit(currentRow,"NoClaimDays"+i);
						cashlessdCapture.enterClaimdays(noClaimDays);
						logger.info(i+" No. of Claim Days Entered - "+noClaimDays);
						
						Thread.sleep(2000l);
						String noPaidDays = CashlessDCapturedread.getCashlessDataMultiBillBenefit(currentRow,"NoPaidDays"+i);
						cashlessdCapture.enterPaiddays(noPaidDays);
						logger.info(i+" No. of Paid Days Entered - "+noPaidDays);
						
						Thread.sleep(2000l);
						String billAmt = CashlessDCapturedread.getCashlessDataMultiBillBenefit(currentRow,"Bill Amount"+i);
						cashlessdCapture.enterBillAmount(billAmt);
						logger.info(i+" Bill Amount Entered - "+billAmt);
						
						Thread.sleep(2000l);
						cashlessdCapture.clickAddBill();
						logger.info(i+" Add Bill Clicked");
						
					}
				
				}else{
				
						Thread.sleep(2000l);
						cashlessdCapture.selectBenfitItem(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBENEFIT Benefit Item"));
						logger.info("Benefit Item Selected");
						
						cashlessdCapture.enterClaimdays(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBENEFIT No. of Claim Days"));
						logger.info("No. of Claim Days Entered");
						
						cashlessdCapture.enterPaiddays(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBENEFIT No. of Paid Days"));
						logger.info("No. of Paid Days Entered");
						
						cashlessdCapture.enterBillAmount(CashlessDCapturedread.getCashlessDataCapture(currentRow,"DBBENEFIT Bill Amount"));
						logger.info("Bill Amount Entered");
						
						cashlessdCapture.clickAddBill();
						logger.info("Add Bill Clicked");
				}
				
			}
			
			cashlessdCapture.waitLoader();
			// ===== VERIFY BILL TABLE =====================
			//Thread.sleep(2000l);
			/*boolean chkBilltable = cashlessdCapture.validateBillTable();
			if(chkBilltable == true){
				
				logger.info("BILL Table Displyed.");
			}else
			{
				logger.info("BILL Table Not Displyed.");
				Assert.assertTrue(false, "BILL Table Not Displyed After Add click");
			}*/
			
			//Thread.sleep(5000l);
			cashlessdCapture.clickSave();
			logger.info("Save Clicked");
			
			//claimdetails = cashlessdCapture.getClaimNotification();  //uncomment this after
			//logger.info("Alert Message: "+ claimdetails);
			
			//claimNumber = regExtract(claimdetails);
			
			//Thread.sleep(20000l); // might be for loader
			cashlessdCapture.waitLoader();
			
			claimNumber = cashlessdCapture.getClaimNumber();
			logger.info("Claim Number Captured:- "+claimNumber);
			
			// TODO CASHLESS DataCapture saved claim search ====
			
			if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"dcaptureClaimSearch").equalsIgnoreCase("Yes")){
				
				logger.info("<=== Start to search save claim in data capture page ====>");
				
				//Menu Navigation =========
				cashlessdCapture.clickClaim();
				logger.info("Claim clicked");
				
				Thread.sleep(1000l);
				cashlessdCapture.clickCashlessdc();
				logger.info("Cashless Clicked");
				
				Thread.sleep(1000l);
				cashlessdCapture.clickDataCapture();
				logger.info("DataCapture Clicked");
				
				//===============================
				//Thread.sleep(10000l); // use sleep for loader
				cashlessdCapture.waitLoader();
				//===============================
				
				cashlessdCapture.enterClaimtoSearch(claimNumber);
				logger.info("Enter claim to search in data Capture");
				
				cashlessdCapture.clickdcSearch();
				logger.info("Clicked on search Button");
				
				//==== VERIFY CLAIM SEARCH ==============================================
				
				boolean chk = cashlessdCapture.verifyClaim(claimNumber);
				
				if(chk){
				
					logger.info("Search claim verified on data caputure page.");
					Thread.sleep(3000l);
					captureScreen(driver, row+"_Success_cashlessDCaptureSearchClaim");
					
				}else{
					
					Assert.assertTrue(false,"Claim Number is not found on Data Capture Page");
					captureScreen(driver, row+"_cashlessDCaptureSearchClaim");
				}
					
				//======================================================================				
				
				cashlessdCapture.clickdcProceed();
				logger.info("Click on Proceed");
				
				logger.info("===> Process complete to search save claim in data capture page <====");
				
			}
			
			//===================================================
			
			if(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Assessment Enquiry").equalsIgnoreCase("Yes")){
				
				cashlessdCapture.clickAssessmentEnquiry();
				logger.info("AssessmentEnquiry Clicked");
				
				//Thread.sleep(20000l); //Wait till loader gone
				cashlessdCapture.waitLoader();
				
				cashlessdCapture.clickView();
				logger.info("View Clicked");
				
				Thread.sleep(4000l);
				cashlessdCapture.goToAssmentPageDetails();
				logger.info("Go To Assessment Page Details");
				
				cashlessdCapture.selectClaimNumber(claimNumber);
				logger.info("Claim Number Selected");
				
				cashlessdCapture.enterDescription(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Assessment Description"));
				logger.info("Descript Entered in Assessment");
				
				cashlessdCapture.clickSaveAssment();
				logger.info("Assessment Saved");
				
				//Thread.sleep(20000l); // use sleep might for loader
				cashlessdCapture.waitLoader();
				//alertmsg = cashlessdCapture.getClaimNotification();
				//logger.info("Alert Message: "+ alertmsg);
				
				cashlessdCapture.closepopup();
				logger.info("Assessment Pop up Closed.");
				
				cashlessdCapture.clickShowhidebtn();
				logger.info("click on Show Hide Pop up Button");
				
			
			}
			
			//Thread.sleep(15000l); // use sleep for loader
			cashlessdCapture.waitLoader();
//=======================================			
			driver.findElement(By.xpath("//input[@id='btnSaveClaimId']")).click();
			logger.info("Click save button");
			Thread.sleep(8000);
//==================================================================			
			cashlessdCapture.clickAutoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			//alertmsg = cashlessdCapture.getClaimNotification();
			//logger.info("Alert Message: "+ alertmsg); //Comment as sometime it does not appear in after auto-audjudicate clicked

			Thread.sleep(3000l);
			captureScreen(driver, row+"_Success_cashlessDCaptureManual");
			
			//Thread.sleep(7000l); // use sleep for loader
			cashlessdCapture.waitLoader();
			
			
//===========================================================BELOW NEW CODE=================================			
		
			
//==========================================================================================================================================					
			
			cashlessdCapture.clickConfirm();
			logger.info("Confirm Clicked");
			
			//ACCEPT ALERT
			//Thread.sleep(4000l);
			cashlessdCapture.waitLoader();
			driver.switchTo().alert().accept();
			logger.info("Alert Accepted");
			
			Thread.sleep(8000l); //8000l
			cashlessdCapture.waitLoader();
			alertmsg = driver.switchTo().alert().getText();
			logger.info("Alert Message: "+ alertmsg);
			
			Thread.sleep(5000l);
			cashlessdCapture.waitLoader();
			//captureScreen(driver, row+"_cashlessDCsecondalert");
			driver.switchTo().alert().accept();
			logger.info("Second Alert Accepted");

			// SET CLAIM NO UNDER EXCEL SHEET
			
			//CashlessDCapturedread.setCashlessDataCapture("CASHLESSOVERVIEW", "CLAIM NO", currentRow, claimNumber);
			//logger.info("ClaimNumber set on ReimOverview Sheet"); //Comment as sometime due to running script pick old data
			
			logger.info("====> CASHLESS DATA CAPTURE THROUGH MANUAL TEST PASSED <====");
			
			
		} catch (Exception e) {

			logger.info("====> CASHLESS DATA CAPTURE THROUGH MANUAL TEST FAILED <====");
			Thread.sleep(3000l);
			captureScreen(driver, row+"_cashlessDCaptureManual");			
			e.printStackTrace();
			Assert.assertTrue(false);			
		}
		
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "cashlessDCaptureManual" })
	public void cashlessDCaptureSearchClaim(String row) throws IOException, InterruptedException
	{
		logger.info("Screenshot already capture for data capture claim search");
	}
			
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "cashlessDCaptureManual" })
	public void logoutLevel0Test(String row) throws IOException, InterruptedException
	{
		
			CashlessDCapturePage cashlessdCapture = new CashlessDCapturePage(driver);
			logger.info("<==== Logout Test Started ====>");
			
			//Thread.sleep(10000l); // wait for loader or implicit wait
			cashlessdCapture.waitLoader();
			
			cashlessdCapture.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			//cashlessdCapture.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutLevel0Test");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				
				captureScreen(driver,row+"_logoutLevel0Test");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
			
			driver.close();
	}

}
