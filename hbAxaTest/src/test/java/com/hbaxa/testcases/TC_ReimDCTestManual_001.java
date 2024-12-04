package com.hbaxa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.ReimDCapturePage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.ReimdcaptureData;
import com.hbaxa.utilities.Fileupload_RobotClass;

public class TC_ReimDCTestManual_001 extends BaseClass {
	String claimdetails;
	String alertmsg;
	public static String claimNumber;
	//public static String claim5;
	
	ReimdcaptureData RDCapturedread = new ReimdcaptureData();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginLevel0Test(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched - "+driver.getCurrentUrl());
			
			logger.info("<===== Login test started ====>");
			
			ReimDCapturePage rdCapture = new ReimDCapturePage(driver);
			
			rdCapture.setUserName(RDCapturedread.getReimDataCapture(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			rdCapture.setPassWord(RDCapturedread.getReimDataCapture(currentRow,"Password"));
			logger.info("Password Entered");
			
			rdCapture.clickSubmit();
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
	public void reimDCaptureManual(String row) throws IOException, InterruptedException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			ReimDCapturePage rdCapture = new ReimDCapturePage(driver);

			logger.info("<==== REIMBURSMENT DATA CAPTURE THROUGH MANUAL TEST STARTED ====>");
			
			//Menu Navigation =====
			Thread.sleep(1000l);
			rdCapture.clickClaim();
			logger.info("Claim clicked");
			Thread.sleep(1000l);
			rdCapture.clickReimbursment();
			logger.info("Reimbursment Clicked");
			Thread.sleep(1000l);
			rdCapture.clickDataCapture();
			logger.info("DataCapture Clicked");
			
			//===============================
			//Thread.sleep(10000l); // use sleep for loader
			rdCapture.waitLoader();
			//===============================
			
			rdCapture.clickAddManualClaim();
			logger.info("Add Manual Claim Clicked");
			
			//===============================
			//Thread.sleep(10000l); // use sleep for loader
			rdCapture.waitLoader();
			//================================
			
			
			
			rdCapture.clickModify();
			logger.info("Clicked Modify to Enter Policy Number");
			
			rdCapture.enterPolicyNo(RDCapturedread.getReimDataCapture(currentRow,"SearchPolicy"));
			logger.info("Policy Number Entered..");
			
			if(RDCapturedread.getReimDataCapture(currentRow, "freshPolicy").equalsIgnoreCase("Yes")){
				
				Thread.sleep(2000l);
				captureScreen(driver, row+"_Success_reimDCaptureFreshPolicy");
				logger.info("Screenshot captured for fresh policy");
				
				Thread.sleep(2000l);
				rdCapture.selectSearchfromRls();
				logger.info("Search From RLS clicked for policy search");
				
				//====================================
				Thread.sleep(3000); // use sleep for loader //15000 previous value
				rdCapture.waitLoader();
				//====================================
				
				rdCapture.selectfreshPolicy();
				logger.info("Fresh Policy Selected..");
				
				//====================================
				Thread.sleep(3000); // use sleep for loader //15000 previous value
				rdCapture.waitLoader();
				//====================================
				
				captureScreen(driver, row+"_Success_reimDCaptureFreshPolicyDetails");
				logger.info("Screenshot captured for fresh policy after Selection");
				
			}else
			{
				Thread.sleep(3000l);
				rdCapture.selectPolicy(row);
				logger.info("Policy Selected..");
			}
			//====================================
			Thread.sleep(5000); // use sleep for loader //15000 previous value
			rdCapture.waitLoader();
			//====================================
			
			//====== FOR PA SELECTION IN GI CALCULATION CASE =========================
			
			if(RDCapturedread.getReimDataCapture(currentRow,"paRequired").equalsIgnoreCase("Yes")){
			
			rdCapture.clickPreApprovalHistory();
			logger.info("Pre Approval History Clicked");
			
			//====================================
			//Thread.sleep(15000); // use sleep for loader
			rdCapture.waitLoader();
			//====================================
			
			
			try {
				
				rdCapture.viewMore();
				logger.info("View More Clicked");
				
				Thread.sleep(2000l);
				rdCapture.enterSearchText(RDCapturedread.getReimDataCapture(currentRow,"Select Approved PA"));
				//rdCapture.enterSearchText(CashlessDCapturedread.getCashlessDataCapture(currentRow,"Select Approved PA"));
				logger.info("Search Text Entered -  Pre Approval Approved");
				
				rdCapture.clickProceed();
				logger.info("Proceed Clicked");
				
			} catch (Exception e) {
				
				
				rdCapture.clickProceedOne();
				logger.info("Proceed Clicked");
				System.out.println(e.getMessage());

				//e.printStackTrace();
			}
			
			Thread.sleep(4000l);
			driver.switchTo().alert().accept();
			logger.info("Alert accepted");
			
			//====================================
			//Thread.sleep(25000); // use sleep for laoder
			rdCapture.waitLoader();
			//====================================
			
			
			}
			//=====================================================
			
			rdCapture.gotoCreationForm();
			logger.info("Go To Creation Form");
			
			rdCapture.enterTreatmentLoc(RDCapturedread.getReimDataCapture(currentRow,"CF Treatment Location"));
			logger.info("Treatment Location Entered");

			Thread.sleep(3000l);
			rdCapture.selectTreatmentLoc(row);
			logger.info("Treatment Location Selected");
			
			rdCapture.enterDoctorName(RDCapturedread.getReimDataCapture(currentRow,"CF Attending Doctor Name"));
			logger.info("Doctor Name Entered");
			
			Thread.sleep(3000l);
			rdCapture.selectDoctorName(row);
			logger.info("Doctor Name Selected");
			
			rdCapture.selectServices(RDCapturedread.getReimDataCapture(currentRow,"CF Services"));
			logger.info("Services selected...");
			
			rdCapture.enterDateofAdmission(RDCapturedread.getReimDataCapture(currentRow,"CF Date of Admission"));
			logger.info("Date of Admission Entered");
			
			rdCapture.enterAdmissionTime(RDCapturedread.getReimDataCapture(currentRow,"CF Admission Time"));
			logger.info("Admission Time Entered");
			
			rdCapture.enterDateofDischarge(RDCapturedread.getReimDataCapture(currentRow,"CF Date Of Discharge"));
			logger.info("Date of Discharge Entered");
			
			rdCapture.selectWardType(RDCapturedread.getReimDataCapture(currentRow,"CF Ward Type"));
			logger.info("Ward type selected..");
			
			rdCapture.enterDischargeTime(RDCapturedread.getReimDataCapture(currentRow,"CF Discharge time"));
			logger.info("Discharge Time Entered");

			rdCapture.enterContactNumber(RDCapturedread.getReimDataCapture(currentRow,"CF Contact No. (Insured)"));
			logger.info("Contact Number Entered");
			
			rdCapture.enterEmailAddress(RDCapturedread.getReimDataCapture(currentRow,"CF Email Address (Insured)"));
			logger.info("Email Adress Entered");			
			
			rdCapture.enterSymptom(RDCapturedread.getReimDataCapture(currentRow,"CF Symptom/complaint"));
			logger.info("Symptom/complaint Entered");
			
			rdCapture.selectBillCurrency(RDCapturedread.getReimDataCapture(currentRow,"CF Bill Currency"));
			logger.info("Bill Currency Selected");
			
			rdCapture.enterSubmissionDate(RDCapturedread.getReimDataCapture(currentRow,"CF Submission Date"));
			logger.info("Submission Date Entered");
			
			//Thread.sleep(5000l); // use sleep for loader disappear
			rdCapture.waitLoader();
			
			rdCapture.gotoIcdDescription();
			logger.info("Go To ICD Description");
			
			if(RDCapturedread.getReimDataCapture(currentRow,"Multi Icd").equalsIgnoreCase("Yes")){
				
				String totalIcdcode = RDCapturedread.getReimDataMultiICD(currentRow, "Total ICD Code");
				
				int totalicd = Integer.parseInt(totalIcdcode);
				System.out.println("Total Bill = "+totalicd);
				
				for(int i = 1; i<=totalicd; i++){
					
					Thread.sleep(3000l);
					String icd_code = RDCapturedread.getReimDataMultiICD(currentRow,"ICD Code"+i);
					rdCapture.enterICDCode(icd_code);
					logger.info(i+" ICD CODE ENTERED - "+icd_code);
					
					Thread.sleep(2000l);
					rdCapture.selectMultiICDCode(row,i);
					logger.info(i+" ICD CODE Selected - "+icd_code);
					
					rdCapture.clickICDAddBtn();
					logger.info(i+" ICD ADD BUTTON CLICKED");					
					
				}
				
				
				
			}else{
			
					rdCapture.enterICDCode(RDCapturedread.getReimDataCapture(currentRow,"ICD Code"));
					logger.info("ICD CODE ENTERED");
					
					Thread.sleep(3000l);
					rdCapture.selectICDCode(row);
					logger.info("ICD CODE Selected");
					
					String unknownPreExisting = RDCapturedread.getReimDataCapture(currentRow,"ICD Unknown Pre-Existing (VHIS) CHECK");
					
					if(unknownPreExisting.equalsIgnoreCase("Yes")){
						
						rdCapture.clickUnknownPreExisting();
						logger.info("Click on Unknown PreExisting(VHIS)");
					}
					
					rdCapture.clickICDAddBtn();
					logger.info("ICD ADD BUTTON CLICKED");
					
			}
			
			//Thread.sleep(4000l); // use sleep for loader
			rdCapture.waitLoader();			
			captureScreen(driver,row+"_Success_ICd added succesfully");
			// ===== VERIFY ICD TABLE =====================
			Thread.sleep(2000l);
			boolean chkicdtable = rdCapture.validateICDTable();
			if(chkicdtable == true){
				
				logger.info("ICD Table Displayed.");
				
			}else
			{
				logger.info("ICD Table Not Displayed.");
				Assert.assertTrue(false, "ICD Table Not Displayed After Add click");
			}
			

			//======= SURGERY DESCRIPTION ==========
			
			rdCapture.gotoSurgeryDescription();
			logger.info("Go To Surgery Description");
			
			if(RDCapturedread.getReimDataCapture(currentRow,"Multi Surgery Code").equalsIgnoreCase("Yes")){
				
				String totalSurgerycode = RDCapturedread.getReimDataMultiSurgeryCode(currentRow, "Total SD Code");
				
				int totalsurgery = Integer.parseInt(totalSurgerycode);
				System.out.println("Total Bill = "+totalsurgery);
				
				for(int i = 1; i<=totalsurgery; i++){
					
					Thread.sleep(2000l);
					rdCapture.enterSurgeryCode(RDCapturedread.getReimDataMultiSurgeryCode(currentRow,"SD Code"+i));
					logger.info(i+" Surgery Code Entered");
					
					Thread.sleep(2000l);
					rdCapture.selectMultiSurgeryCode(row,i);
					logger.info(i+" Surgery Code Selected");
					
					Thread.sleep(1000l);
					rdCapture.enterSurgeryAmt(RDCapturedread.getReimDataMultiSurgeryCode(currentRow,"SD AMOUNT"+i));
					logger.info(i+" Surgery Amount Entered");
					
					/*rdCapture.selectIncision(RDCapturedread.getReimDataCapture(currentRow,"SD Incision"+i));
					logger.info(i+"Incision Selected");	*/				
					
					Thread.sleep(2000l);
					rdCapture.clickaddSurgeryBtn();
					logger.info(i+" Surgery Button Add Clicked");
				
				}
				
				
			}else{
				
					rdCapture.enterSurgeryCode(RDCapturedread.getReimDataCapture(currentRow,"SD Code"));
					logger.info("Surgery Code Entered");
					
					Thread.sleep(2000l);
					rdCapture.selectSurgeryCode(row);
					logger.info("Surgery Code Selected");
					
					rdCapture.enterSurgeryAmt(RDCapturedread.getReimDataCapture(currentRow,"SD AMOUNT"));
					logger.info("Surgery Amount Entered");
					
					rdCapture.selectIncision(RDCapturedread.getReimDataCapture(currentRow,"SD Incision"));
					logger.info("Incision Selected");
					
					Thread.sleep(2000l);
					rdCapture.clickaddSurgeryBtn();
					logger.info("Surgery Button Add Clicked");
					
			}
			
			Thread.sleep(3000l);
			boolean chksugerytable = rdCapture.validateSurgeryTable();
			if(chksugerytable == true){
				
				logger.info("Surgery Table Displayed.");
			}else
			{
				logger.info("Surgery Table Not Displayed.");
				Assert.assertTrue(false, "Surgery Table Not Displyed After Add click");
			}
			
			
			rdCapture.waitLoader();
			captureScreen(driver,row + "_Success_Surgery added succesfully");
			//======= SETTLEMENT METHOND =========
			
			rdCapture.gotoSettlementMethod();
			logger.info("Go To Settlement Method");
			if
			(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("By Autopay")) 
			{
				rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));	
				rdCapture.bankno(RDCapturedread.getReimDataCapture(currentRow, "SM Bank No"));
				logger.info("Bank no. enter="+RDCapturedread.getReimDataCapture(currentRow, "SM Bank No"));
				rdCapture.branchno(RDCapturedread.getReimDataCapture(currentRow, "SM Branch No"));
				logger.info("Enter the branch number="+RDCapturedread.getReimDataCapture(currentRow, "SM Branch No"));
				rdCapture.accountno(RDCapturedread.getReimDataCapture(currentRow, "SM Account No"));
				
				logger.info("enter the account no="+RDCapturedread.getReimDataCapture(currentRow, "SM Account No"));
				rdCapture.confirmaccount(RDCapturedread.getReimDataCapture(currentRow, "SM Confirm Account No"));
				logger.info("enter confirm account="+RDCapturedread.getReimDataCapture(currentRow, "SM Confirm Account No"));
				rdCapture.enter_name_of_payee(RDCapturedread.getReimDataCapture(currentRow, "SM Name Of Payee"));
				captureScreen(driver, "Screen shot taken for settlement method-by Autopay");
			}
			
			else if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("Non- cross cheque"))
			{
			rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
		    rdCapture.Nonbcrossmember();
			logger.info("Member Address Clicked");	
			captureScreen(driver, "Screen shot taken for settlement method-by Non cross");
			}
		//	else if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("Oversis TT"))
		else if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("TT"))
	
			{
			logger.info("Settlment Start By TT");
			rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			rdCapture.paymenttypetext(RDCapturedread.getReimDataCapture(currentRow, "SM Payment method"));
			
			logger.info("Enter the Paymnet type method");
			rdCapture.debitaccount(RDCapturedread.getReimDataCapture(currentRow, "SM Debit Account number"));
			logger.info("Enter the Debit account");
				
			rdCapture.debitcountrycode(RDCapturedread.getReimDataCapture(currentRow, "SM Debit Account Country code"));
			rdCapture.forienexchange(RDCapturedread.getReimDataCapture(currentRow, "SM Foreign Exchange Rate"));
			rdCapture.chanrgesind(RDCapturedread.getReimDataCapture(currentRow, "SM Charges Indicator"));
			rdCapture.trnnumber(RDCapturedread.getReimDataCapture(currentRow, "SM Transaction Reference Number"));
			
			rdCapture.ISbeneficiary(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary IS"));
			rdCapture.beneficiaryname(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary Name"));
			rdCapture.benefiryaccount(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary Account Number"));
			rdCapture.routingtype(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary (Bank) Routing Method"));
			
			rdCapture.Bankroutingcode(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary (Bank) Routing Code / SWIFT Code"));
			rdCapture.bankname(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary Bank Name"));
			rdCapture.bankaddress1(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary (Bank) Address 1"));
			rdCapture.bankaddress2(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary (Bank) Address 2 "));
			rdCapture.bankaddress3(RDCapturedread.getReimDataCapture(currentRow, "SM Beneficiary (Bank) Address 3 "));
			rdCapture.swiftcode(RDCapturedread.getReimDataCapture(currentRow, "SM Intermediary (Bank) SWIFT Code"));
			rdCapture.banknameI(RDCapturedread.getReimDataCapture(currentRow, "SM Intermediary (Bank) Name"));
			rdCapture.intermidiatesortcode(RDCapturedread.getReimDataCapture(currentRow, "SM Intermediary (Bank) Sort Code [Only for UK]"));
			rdCapture.addressI(RDCapturedread.getReimDataCapture(currentRow, "SM Intermediary (Bank) Address 1"));
			rdCapture.addressI2(RDCapturedread.getReimDataCapture(currentRow, "SM Intermediary (Bank) Address 2 "));
			rdCapture.addressI3(RDCapturedread.getReimDataCapture(currentRow, "SM Intermediary (Bank) Address 3 "));
			captureScreen(driver, "Screen shot taken for settlement method-Oversea");
			}else if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("By Cheque"))
	
			{
			logger.info("Settlment Start by Cheque");
			rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			logger.info("Select dropdown option="+RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			Thread.sleep(4000);
			rdCapture.clickcheck_box_memberaddresst();
			logger.info("Click check box");
			
			}
			else 
			{rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow,"SM Settlement Type"));
			logger.info("Settlement Type Selected");
			rdCapture.clickMemberAddress();
			logger.info("Member Address Clicked");
			captureScreen(driver, "Screen shot taken for settlement method-by cheque");
			}
			//======== DISPLAY BILL ========
			Thread.sleep(3000l);
			rdCapture.gotoDisplayBill();
			logger.info("GO TO DISPLAY BILL");
			
			if(RDCapturedread.getReimDataCapture(currentRow,"Input By Bill Item").equalsIgnoreCase("No")){
				
				System.out.println("if part");
				
				Thread.sleep(5000l);
				/*rdCapture.clickInputByBillItem();*/
				//logger.info("Clicked Input By Bill Item");
				
				/*rdCapture.clickOnOkinputbybill();*/
				logger.info("Ok Clicked..");
				
				if(RDCapturedread.getReimDataCapture(currentRow,"Multi Billing").equalsIgnoreCase("Yes")){
					
					//Multi billing code here
					
					String totalBillstring = RDCapturedread.getReimDataMultiBill(currentRow, "Total Bill Item");
					int totalBill = Integer.parseInt(totalBillstring);
					System.out.println("Total Bill = "+totalBill);
					
					for(int i = 1; i<=totalBill; i++){
						
						Thread.sleep(3000l);
						String billchargeDate = RDCapturedread.getReimDataMultiBill(currentRow, "Charge Date"+i);
						rdCapture.enterbillchargeDate(billchargeDate);
						logger.info(i+" Bill charge date entered. - " +billchargeDate);
						
						Thread.sleep(2000l);
						rdCapture.enterBillItem(RDCapturedread.getReimDataMultiBill(currentRow,"Bill Items"+i));
						logger.info("Bill"+i+" Item Entered");
						
						Thread.sleep(2000l);
						rdCapture.selectMultiBillItem(row,i);
						logger.info("Bill"+i+" Item Selected");
						
						Thread.sleep(2000l);
						String claim_amount = RDCapturedread.getReimDataMultiBill(currentRow,"BI"+i+"_CLAIM_AMOUNT");
						rdCapture.enterBillitemAmount(claim_amount);
						logger.info("Bill"+i+" Amount Entered -- "+ claim_amount );
						
						Thread.sleep(2000l);
						rdCapture.selectdbBillBenefitItem(RDCapturedread.getReimDataMultiBill(currentRow,"BI"+i+"_Benefit items"));
						logger.info("dbbillBenefit"+i+" Item Selected");
						
						Thread.sleep(3000l);
						rdCapture.clickAddbyitembill();
						logger.info("Add Bill Button Clicked");
						
					}
					
				}
				else{
				
					rdCapture.enterBillItem(RDCapturedread.getReimDataCapture(currentRow,"DBBILL Bill Item"));
					logger.info("Bill Item Entered");
					
					Thread.sleep(2000l);
					rdCapture.selectBillItem(row);
					logger.info("Bill Item Selected");
					Thread.sleep(3000l);
					
					rdCapture.enterBillitemAmount(RDCapturedread.getReimDataCapture(currentRow,"DBBILL Bill Amount"));
					logger.info("Bill Amount Entered");
					Thread.sleep(3000l);
					
					rdCapture.selectdbBillBenefitItem(RDCapturedread.getReimDataCapture(currentRow,"DBBILL BENEFIT ITEM"));
					logger.info("dbbillBenefit Item Selected");
					
					Thread.sleep(3000l);
					rdCapture.clickAddbyitembill();
					logger.info("Add Bill Button Clicked");
				
				}
				
			}else if(RDCapturedread.getReimDataCapture(currentRow,"Input By Benefit Item").equalsIgnoreCase("Yes")){
				
				System.out.println("2nd if part");
				
				Thread.sleep(5000l);
				rdCapture.clickInputByBenefitItem();
				logger.info("Clicked Input By Benefit Item");
				
				rdCapture.clickOnOkinputbybenefit();
				logger.info("Ok Clicked..");
				
				if(RDCapturedread.getReimDataCapture(currentRow,"Multi Billing").equalsIgnoreCase("Yes")){
					
					String totalBillstring = RDCapturedread.getReimDataMultiBillBenefit(currentRow, "Total Bill Item");
					int totalBill = Integer.parseInt(totalBillstring);
					
					for(int i = 1; i<=totalBill; i++){
						
						Thread.sleep(3000l);
						/*String chargeDate = RDCapturedread.getReimDataMultiBillBenefit(currentRow, "Charge Date"+i);
						rdCapture.enterchargeDate(chargeDate);
						logger.info(i+" Bill charge date entered. - " +chargeDate);*/
						
						Thread.sleep(4000l);
						String benefitItems = RDCapturedread.getReimDataMultiBillBenefit(currentRow,"Benefit Item"+i);
						rdCapture.selectBenfitItem(benefitItems);
						Thread.sleep(4000l);
						logger.info(i+" Benefit Item Selected - "+benefitItems);
						
						//Thread.sleep(2000l);
						String noClaimDays = RDCapturedread.getReimDataMultiBillBenefit(currentRow,"NoClaimDays"+i);
						rdCapture.enterClaimdays(noClaimDays);
						logger.info(i+" No. of Claim Days Entered - "+noClaimDays);
						
						Thread.sleep(2000l);
						String noPaidDays = RDCapturedread.getReimDataMultiBillBenefit(currentRow,"NoPaidDays"+i);
						rdCapture.enterPaiddays(noPaidDays);
						logger.info(i+" No. of Paid Days Entered - "+noPaidDays);
						
						Thread.sleep(2000l);
						String billAmt = RDCapturedread.getReimDataMultiBillBenefit(currentRow,"Bill Amount"+i);
						rdCapture.enterBillAmount(billAmt);
						logger.info(i+" Bill Amount Entered - "+billAmt);
						
						Thread.sleep(2000l);
						rdCapture.clickAddBill();
						logger.info(i+" Add Bill Clicked");
						
					}
				
				}else{
					
						Thread.sleep(2000l);
						rdCapture.selectBenfitItem(RDCapturedread.getReimDataCapture(currentRow,"DBBENEFIT Benefit Item"));
						logger.info("Benefit Item Selected");
						
						rdCapture.enterClaimdays(RDCapturedread.getReimDataCapture(currentRow,"DBBENEFIT No. of Claim Days"));
						logger.info("No. of Claim Days Entered");
						
						rdCapture.enterPaiddays(RDCapturedread.getReimDataCapture(currentRow,"DBBENEFIT No. of Paid Days"));
						logger.info("No. of Paid Days Entered");
						
						rdCapture.enterBillAmount(RDCapturedread.getReimDataCapture(currentRow,"DBBENEFIT Bill Amount"));
						logger.info("Bill Amount Entered");
						
						rdCapture.clickAddBill();
						logger.info("Add Bill Clicked");
				
				}
				
			}
			
			
			//Thread.sleep(5000l); // use sleep for laoder
			rdCapture.waitLoader();
			captureScreen(driver,row+  " "+"_Success_Bill added succesfuuly");
			// ===== VERIFY BILL TABLE =====================
			Thread.sleep(5000l);
			//boolean chkBilltable = rdCapture.validateBillTable();
			/*if(chkBilltable == true){
				
				logger.info("BILL Table Displyed.");
			}else
			{
				logger.info("BILL Table Not Displyed.");
				Assert.assertTrue(false, "BILL Table Not Displyed After Add click");
			}*/			
			
			//TODO===== LINK/ D-LINK DISABILITY Functionality TC====
			
			if(RDCapturedread.getReimDataCapture(currentRow,"Link").equalsIgnoreCase("Yes")){
				
				rdCapture.gotoLinkDlink();
				logger.info("Move to Link/ D-Link Area");
				
				if(row.equals("51")){
					
					String claimData = RDCapturedread.getReimLink(currentRow,"Claim1_50");
					
					rdCapture.linkClaim(claimData);
					logger.info("Claim1 "+claimData+" linked to Current Claim");
					
					
				}else if(row.equals("53")){
					
					String claimData = RDCapturedread.getReimLink(currentRow,"Claim3_52");
					
					rdCapture.linkClaim(claimData);
					logger.info("Claim3 "+claimData+" linked to Current Claim");
					
				}else if(row.equals("54")){
					
					String claimData = RDCapturedread.getReimLink(51,"Claim1_50");
					
					rdCapture.linkClaim(claimData);
					logger.info("Claim1 "+claimData+" linked to Current Claim");

				}else if(row.equals("55")){
					
					String claimData = RDCapturedread.getReimLink(53,"Claim3_52");
					
					rdCapture.linkClaim(claimData);
					logger.info("Claim3 "+claimData+" linked to Current Claim");

			}
				
				
			}
			
			//================================================
			
			rdCapture.clickSave();
			logger.info("Save Clicked");
			
			claimdetails = rdCapture.getClaimNotification();
			logger.info("Alert Message: "+ claimdetails);
			
			claimNumber = regExtract(claimdetails);
			
			// TODO DataCapture save claim search Code ======
			
			if(RDCapturedread.getReimDataCapture(currentRow,"dcaptureClaimSearch").equalsIgnoreCase("Yes")){
			
				logger.info("<=== Start to search save claim in data capture page ====>");
				
				//Menu Navigation =====
				Thread.sleep(1000l);
				rdCapture.clickClaim();
				logger.info("Claim clicked");
				Thread.sleep(1000l);
				rdCapture.clickReimbursment();
				logger.info("Reimbursment Clicked");
				Thread.sleep(1000l);
				rdCapture.clickDataCapture();
				logger.info("DataCapture Clicked");
				
				//===============================
				//Thread.sleep(10000l); // use sleep for loader
				rdCapture.waitLoader();
				//===============================
				
				rdCapture.enterClaimtoSearch(claimNumber);
				logger.info("Enter claim to search in data Capture");
				
				rdCapture.clickdcSearch();
				logger.info("Clicked on search Button");
				
				//==== VERIFY CLAIM SEARCH ==============================================
				
				boolean chk = rdCapture.verifyClaim(claimNumber);
				if(chk){
				
					logger.info("Search claim verified on data caputure page.");
					Thread.sleep(3000l);
					captureScreen(driver, row+"_Success_reimDCaptureSearchClaim");
					
				}else{
					
					Assert.assertTrue(false,"Claim Number is not found on Data Capture Page");
					captureScreen(driver, row+"_reimDCaptureSearchClaim");
				}
					
				//======================================================================				
				//acx
				rdCapture.clickdcProceed();
				logger.info("Click on Proceed");
				
				logger.info("===> Process complete to search save claim in data capture page <====");
				
			}
			// ==============================================
			
			//Thread.sleep(15000l); // use sleep for loader
			rdCapture.waitLoader();
			
			if(RDCapturedread.getReimDataCapture(currentRow,"Other Insurance Amt").equalsIgnoreCase("Yes")){
				
				rdCapture.gotoOtherInsurance();
				logger.info("Go To Other Amount Section");
				
				String totalBillstring = RDCapturedread.getReimDataOtherInsurance(currentRow, "Total Bill item");
				int totalBill = Integer.parseInt(totalBillstring);
				
				for(int i = 0; i<=totalBill; i++){
					
					Thread.sleep(2000l);
					System.out.println("i = "+i);
					String billAmt = RDCapturedread.getReimDataOtherInsurance(currentRow,"Other Amt"+i);
					rdCapture.enterOtherBillAmount(billAmt,i);
					logger.info(i+" Other Insurance Amount Entered - "+billAmt);
					
					rdCapture.clickApply();
					logger.info(i+" Apply Clicked");
				}
				
				if(RDCapturedread.getReimDataOtherInsurance(currentRow,"Other SMM").equalsIgnoreCase("Yes")){
					
					Thread.sleep(2000l);
					String SMMAmt = RDCapturedread.getReimDataOtherInsurance(currentRow,"Other SMM Amt");
					rdCapture.enterOtherSMMAmount(SMMAmt);
					logger.info("Other Insurance SMM Amount Entered - "+SMMAmt);

					rdCapture.clickApply();
					logger.info("Apply Clicked For SMM");
					
				}
				
				rdCapture.clickSave();
				logger.info("Save Clicked Again");
				
				rdCapture.waitLoader();
				
			}
			
			if(RDCapturedread.getReimDataCapture(currentRow,"Assessment Enquiry").equalsIgnoreCase("Yes")){
				
				
				rdCapture.clickAssessmentEnquiry();
				logger.info("AssessmentEnquiry Clicked");
				
				//Thread.sleep(20000l); //Wait full page load
				rdCapture.waitLoader();
				Thread.sleep(30001);
				
				//rdCapture.clickView();
				rdCapture.ClickGobutton();
				logger.info("Click on Go Button");
				 Thread.sleep(20001);     
				 rdCapture.clickView();
				 logger.info("View Clicked");
				
				//Thread.sleep(5000l); // use sleep for loader
				rdCapture.waitLoader();
				
				rdCapture.goToAssmentPageDetails();
				logger.info("Go To Assessment Page Details");
				//rdCapture.clickView();
				
				rdCapture.selectClaimNumber(claimNumber);
				logger.info("Claim Number Selected");
				
				rdCapture.enterDescription(RDCapturedread.getReimDataCapture(currentRow,"Assessment Description"));
				logger.info("Descript Entered in Assessment");
				
				rdCapture.clickSaveAssment();
				logger.info("Assessment Saved");
				
				Thread.sleep(15000l); // use sleep for loader
				rdCapture.waitLoader();
				//alertmsg = rdCapture.getClaimNotification();
				//logger.info("Alert Message: "+ alertmsg);
				
				rdCapture.closepopup();
				logger.info("Assessment Pop up Closed.");
				
				/*rdCapture.clickShowhidebtn();
				logger.info("click on Show Hide Pop up Button");*/
				
			
			}
			
			//Thread.sleep(15000l); // use sleep for loader
			rdCapture.waitLoader();
			
//=================new click interact execption error show    11-07-2024===================================================	
		/*	 if(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type").equalsIgnoreCase("By Cheque"))
					
				{
				logger.info("Settlment Start By Cheque");
				
				Thread.sleep(8000);
		
				rdCapture.select_settlmentType_Dropdown(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			logger.info("Select new  dropdown text");
				Thread.sleep(8000);
			//	rdCapture.selectSettelementType(RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
			//	logger.info("Select dropdown option="+RDCapturedread.getReimDataCapture(currentRow, "SM Settlement Type"));
				Thread.sleep(4000);
				rdCapture.clickcheck_box_memberaddresst2();
				logger.info("Click check box");
				
				}*/
			
			
			rdCapture.clickAutoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			//alertmsg = rdCapture.getClaimNotification(); // ACTIVE SOME TIME LATER
			//logger.info("Alert Message: "+ alertmsg); // ACTIVE SOME TIME LATER

			Thread.sleep(3000l);
			captureScreen(driver, row+"_Success_reimDCaptureManual");
			
			rdCapture.waitLoader(); // for loader
		    String str1=driver.findElement(By.xpath("(//div[@class='auto-adjudicate']//div[@class='row'])[2]//descendant::td[1]")).getText();
		     
		     logger.info(str1);
		     logger.info("Alert Message="+str1);
			rdCapture.clickConfirm();
			logger.info("Confirm Clicked");
			
			//ACCEPT ALERT
			Thread.sleep(5000l); // no loader, use sleep for alert load in dom.
			driver.switchTo().alert().accept();
			logger.info("Alert Accepted");
			
			Thread.sleep(8000l); //4000l
			rdCapture.waitLoader();
			//============================old code
		//	alertmsg = driver.switchTo().alert().getText();
		//	logger.info("Alert Message: "+ alertmsg);
			
			//Thread.sleep(4000l);
			rdCapture.waitLoader();
		  //  driver.switchTo().alert().accept();
			///////rdCapture.acceptAlert();
		//	logger.info("Second Alert Accepted");
          //==================================
			// TODO SET CLAIM NO UNDER EXCEL SHEET For Link D lInk case
			
			if(row.equals("50")){
				
				RDCapturedread.setReimDataCapture("LinkRimbursment", "Claim1_50", 51, claimNumber);
				
				
			}else if(row.equals("52")){
				
				RDCapturedread.setReimDataCapture("LinkRimbursment", "Claim3_52", 53, claimNumber);
				
				
			}
			// == For Claim 5 on link D link case ==
			if(row.equals("54")){
				
				RDCapturedread.setReimDataCapture("REIMOVERVIEW", "CLAIM NO", currentRow, claimNumber);
				logger.info("ClaimNumber set on ReimOverview Sheet");
			}
			
			// == For claim 3 link d link case set claim to reverse.
			if(row.equals("52")){
				
				RDCapturedread.setReimDataCapture("REIM_REVERSE", "Claim Number For Reverse", 52, claimNumber);
				logger.info("ClaimNumber3 set on Reverse Sheet");
			}
			
			//RDCapturedread.setReimDataCapture("REIMOVERVIEW", "CLAIM NO", currentRow, claimNumber);
			//logger.info("ClaimNumber set on ReimOverview Sheet"); //Comment as sometime due to running script pick old data
			
			logger.info("====> REIMBURSMENT DATA CAPTURE THROUGH MANUAL TEST PASSED <====");
			
			
		} catch (Exception e) {
			
			try {
				
				Thread.sleep(3000l);
				captureScreen(driver, row+"_reimDCaptureManual");
				logger.info("====> REIMBURSMENT DATA CAPTURE THROUGH MANUAL TEST FAILED <====");
				e.printStackTrace();
				Assert.assertTrue(false);
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				logger.info("====> REIMBURSMENT DATA CAPTURE THROUGH MANUAL TEST FAILED <====");
				Assert.assertTrue(false);
			}
			
		}
		
	}
	
	@Parameters(value="tc_row")
	@Test(priority=3, dependsOnMethods = { "reimDCaptureManual" })
	public void reimDCaptureSearchClaim(String row) throws IOException, InterruptedException
	{
		logger.info("Screenshot already capture for data capture claim search");
	}
		
			
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "reimDCaptureManual" })
	public void logoutLevel0Test(String row) throws IOException, InterruptedException
	{
			ReimDCapturePage rdCapture = new ReimDCapturePage(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			rdCapture.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			//rdCapture.clickLogOut();
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
