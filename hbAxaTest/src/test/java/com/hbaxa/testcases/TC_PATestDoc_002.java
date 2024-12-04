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

public class TC_PATestDoc_002 extends BaseClass  {
	String parent;
	String child;
	String paNdetails;
	String toppaNdetails;
	String paNumber;
	String actions;
	String AlertMessage;
	String alertsApprovedClick;
	
	PAData paread = new PAData();
	LoginData ldread = new LoginData();
	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void paTestDocId(String row) throws IOException
	{
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);		
			
			PAPage pa = new PAPage(driver);
			
			//Login Scenario
			logger.info("<==== PA TEST STARTED THROUGH DOCID ====>");
			
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
			
			//================ NAVIGATE TO INDEX MENU =======
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
			//Thread.sleep(25000l); // for loader hard code sleep
			//===========================================
			//pa.waitTillLoader(); // it takes too much time
			//===========================================
			pa.waitLoader();
			
			pa.clickAdvanceSerach();
			logger.info("Advanced Option Clicked");
			
			pa.enterDocID(paread.getPaDoc(currentRow, "DocId"));
			logger.info("Document ID Entered");
			
			Thread.sleep(2000l);
			pa.clickSearch();
			logger.info("Search Button Clicked");
			
			pa.verifyDocId(paread.getPaDoc(currentRow, "DocId"));
			logger.info("Document Id Verified");
			
			Thread.sleep(4000l);
			pa.clickProceed();
			logger.info("Proceed Options Clicked");
		
			//===========================================
			Thread.sleep(8000l);
			//pa.waitTillLoader();
			pa.waitLoader();
			//==========================
			
			pa.clickShowhide();
			logger.info("Show/Hide Document Button Clicked");
			
			pa.setSearchPolicy(paread.getSearchPolicy(currentRow, "SearchPolicy"));
			logger.info("Policy Number Entered");
			
			//Thread.sleep(2000l);
			pa.selectPolicy(row);
			logger.info("Policy Selected");
			
			//===========================================
			//Thread.sleep(15000l); //for loader hard code sleep
			pa.waitLoader();
			//===========================================			
			
			pa.scrolltopad();
			logger.info("Scroll To Pre Approval Details");
			
			Thread.sleep(1000l);
			pa.selectMedicalCardType(paread.getPaManual(currentRow, "Medical Card Type"));
			logger.info("Medical Card Type Selected");			
			
			Thread.sleep(1000l);
			pa.getDocName(paread.getPaDoc(currentRow, "Attending Doctor Name"));
			logger.info("Doctor Name Entered");
			
			Thread.sleep(2000l);
			pa.selectDocName();
			logger.info("Doctor Name Selected");
			
			//===========================================
			//Thread.sleep(10000l); // loader if any
			pa.waitLoader();
			//===========================================
			
			pa.getSymptomDate(paread.getPaDoc(currentRow, "Symptom / Onset Date"));
			logger.info("Symptom / Onset Date Entered");
			
			pa.getConsultationDate(paread.getPaDoc(currentRow, "First Consultation Date"));
			logger.info("First Consultation Date Entered");
			
			pa.getAdmissionDate(paread.getPaDoc(currentRow, "Admission Date"));
			logger.info("Admission Date Entered");
			
			pa.waitLoader();
			
			pa.getDischargeDate(paread.getPaDoc(currentRow, "Discharge Date"));
			logger.info("Discharge Date Entered");
			
			pa.getTreatmentDate();
			logger.info("Treatment Date Clicked, Auto Calculated & Entered");
			
			pa.getSymptom(paread.getPaDoc(currentRow, "Symptom / Complaint"));
			logger.info("Symptom / Complaint Entered");
			
			pa.getContactNumber(paread.getPaDoc(currentRow, "Contact No. (Insured)"));
			logger.info("Contact No. (Insured) Entered");
			
			pa.getBillcurrency(paread.getPaDoc(currentRow, "Bill Currency"));
			logger.info("Bill Currency Selected");
			
			//======================================
			//Thread.sleep(5000l); // loader if any
			pa.waitLoader();
			//======================================
			
			pa.goToDiagnosisView();
			logger.info("Go To Diagnosis View");
			
			//======================================
			Thread.sleep(3000l);
			//======================================
			
			pa.getIcdCode(paread.getPaDoc(currentRow, "ICD Code / Description"));
			logger.info("ICD Code / Description Entered");
			
			Thread.sleep(2000l);
			pa.selectIcdCode(row);
			logger.info("ICD Code / Description Selected");
			
			//===========================================
			//Thread.sleep(10000l); // loader if any
			pa.waitLoader();
			//===========================================
			
			pa.getAddIcdCode();
			logger.info("ADD(ICD) Button Clicked");
			
			Thread.sleep(3000l);
			pa.goToDoctorFee();
			logger.info("Go To Doctor Fee");
			
			pa.getDfBenefitItem(paread.getPaDoc(currentRow, "DF Benefit Item"));
			logger.info("Doctor Fee Benefit Item Entered");
			
			Thread.sleep(2000l);
			pa.selectdfeeBenefitItem(row);
			logger.info("DF Benefit Item Selected");
			
			//===========================================
			//Thread.sleep(10000l); // loader if any
			pa.waitLoader();
			//===========================================			
			
			pa.getdfRequestedAmount(paread.getPaDoc(currentRow, "DF Requested Amount"));
			logger.info("Doctor Fee Requested Amount Entered");
			
			pa.getdfApprovedAmount(paread.getPaDoc(currentRow, "DF Approved Amount"));
			logger.info("Doctor Fee Approved Amount Entered");
			
			Thread.sleep(2000l);
			pa.getAddDocFee();
			logger.info("Doctor Fee Add Button Clicked");
			
			Thread.sleep(3000l);
			//Hospital Charges =========================
			pa.goToHospitalCharges();
			logger.info("Go To Hospital Charges");
			
			pa.getHCBenefitItem(paread.getPaDoc(currentRow, "HC Benefit Item"));
			logger.info("HC Benefit ITem Entered");
			
			pa.selecteHCBenefitItem(row);
			logger.info("HC Benefit Item Selected");
			
			pa.getHCRequestedAmount(paread.getPaDoc(currentRow, "HC Requested Amount"));
			logger.info("HC Requested Amount Entered");
			
			pa.getHCApprovedAmount(paread.getPaDoc(currentRow, "HC Approved Amount"));
			logger.info("HC Approved Amount Entered");
			
			Thread.sleep(2000l);
			pa.getAddHospitalCharges();
			logger.info("Hospital Charges Add Button Clicked");
			
			Thread.sleep(3000l);
			if(paread.getPaDoc(currentRow, "Card Details").equalsIgnoreCase("Yes")){
				
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
			
			pa.inputRemarks(paread.getPaDoc(currentRow, "Remarks"));
			logger.info("Remarks Entered");
			
			Thread.sleep(2000l);
			pa.saveButton();
			logger.info("Save Button Clicked");
			
			paNdetails = pa.getpaNotification();
			logger.info("Success: "+ paNdetails);
			
			//===============
			//Thread.sleep(20000l); // for loader hard code sleep
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
			//Thread.sleep(35000l); //for loader if any
			pa.waitLoader();
			//===============
			
			pa.clickShowhide2();
			logger.info("Show/Hide Document Button Clicked");

			pa.clickautoAudjudicate();
			logger.info("Auto-Audjudicate Clicked");
			
			//===============
			//Thread.sleep(25000l); // for loader if any
			pa.waitLoader();
			//================
			
			pa.gotoPreApprovalResult();
			logger.info("Go To Pre Approval Result");
			captureScreen(driver,row+"_Success_paTestDocId");
			logger.info("Screenshot captured of Pre Approval Result");
			
			//========== Move To Pre Approval Details ===================================
			
			if (paread.getPaDoc(currentRow, "Log Amount").equals("Yes")) {

				Thread.sleep(3000l);
				pa.scrolltopad();
				logger.info("Scroll To Pre Approval Details");
				
				Thread.sleep(2000l);
				pa.chekLogAmount();
				logger.info("Logged Amount Checked");
				
				Thread.sleep(2000l);
				pa.enterLogAmount(paread.getPaAdjustment(currentRow, "Log Amount if empty"));
				logger.info("Log Amount Entered");
				
			}
			
			//===============
			//Thread.sleep(10000l); //loader if any
			pa.waitLoader();
			//===============
			
			if(paread.getPaDoc(currentRow, "Approve").equalsIgnoreCase("Yes")){
				
				pa.clickApprove();
				logger.info("Approve Clicked...");
				
				if(paread.getPaDoc(currentRow, "Log Amount").equalsIgnoreCase("No"))
				{
					actions = "Approve";
					
					Thread.sleep(2000l);
					pa.clickReasonForApprove();
					logger.info("Reason For Approve List Clicked");
					
					Thread.sleep(2000l);
					pa.selectReasonForApprove(row);
					logger.info("Option Selected for Reason For Approve");
					
					Thread.sleep(2000l);
					pa.clickSubmitReasonForApprove();
					logger.info("Submit Clicked of Reason For Approve");
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l); // loader if any
					pa.waitLoader();
					//===================
					
					pa.clickChopping();
					logger.info("Chopping Clicked");
					
					Set <String> st= driver.getWindowHandles();
					Iterator<String> it = st.iterator();
					parent =  it.next();
					child = it.next();
					
					// switch to child tab(Chopping Page)
					driver.switchTo().window(child);
					logger.info("Redirected to Chopping Page");	
					
				}
				else {
					
					System.out.println("else approve --  check");
					
					actions = "Approve";
					
					alertsApprovedClick = pa.getpaNotification();
					logger.info("Alert Message: "+ alertsApprovedClick);
					
					//===================
					//Thread.sleep(15000l); //for loader if any
					pa.waitLoader();
					//===================
					
					pa.clickChopping();
					logger.info("Chopping Clicked");
					
					Set <String> st= driver.getWindowHandles();
					Iterator<String> it = st.iterator();
					parent =  it.next();
					child = it.next();
					
					// switch to child tab(Chopping Page)
					driver.switchTo().window(child);
					logger.info("Redirected to Chopping Page");
					
				}

			}else if(paread.getPaDoc(currentRow, "Pending").equals("Yes")){
				
				actions = "Pending";
				
				pa.clickPending();
				logger.info("Pending Clicked...");
				
				pa.clickReasonForPending();
				logger.info("Reason For Pending List Clicked");
				
				pa.selectReasonForPending(row);
				logger.info("Option Selected for Reason For Pending");
				
				pa.clickSubmitReasonForPending();
				logger.info("Submit Clicked of Reason For Pending");
				
				//Get Text From alert

				//Thread.sleep(15000l); // for loader if any
				pa.waitLoader();
				//pa.clickBackToPending();
				//logger.info("Back To Pending Clicked");
				
				pa.clickChopping();
				logger.info("Chopping Clicked");
				
				//===================
				//Thread.sleep(15000l);
				//===================
				
				//============================================
				Set <String> st= driver.getWindowHandles();
				Iterator<String> it = st.iterator();
				parent =  it.next();
				child = it.next();
				
				// switch to child tab(Chopping Page)
				driver.switchTo().window(child);
				logger.info("Redirected to Chopping Page");
				
			}
			
			logger.info("==> Process Complete of Save(Generate PA No.), auto-audjudicate, and "+actions+" Clicked <==");
			

			//===========================================
			
		} catch (Exception e) {
			
	
			logger.info("====> PA TEST FAILED THROUGH DOCID <====");
			captureScreen(driver, row+"_paTestDocId");// first para is driver,
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
	@Test(priority=2, dependsOnMethods = { "paTestDocId" })
	public void paChoppingDoc(String row) throws Exception
	{
		try {
			
			logger.info("==== Document Chopping Started ====");
			PAPage pa = new PAPage(driver);
			
			Thread.sleep(4000l);
			pa.waitTillDocLoad();
			logger.info("Document Loaded For Chopping");
			
			//Thread.sleep(10000l); //for loader if any
			pa.waitLoader();
			
			pa.performChopping();
			logger.info("Chopping Performed");

			Thread.sleep(1000l);
			pa.deleteChopping();
			logger.info("One Chopping Has Been Deleted");
			
			pa.clicksaveChopping();
			logger.info("Save Options Clicked After Chopping Process");
			
			Thread.sleep(3000l);
			captureScreen(driver,row+"_Success_paChoppingDoc");
			logger.info("Screenshots captured for Chopping Document");
			
			logger.info("==> Document Chopping process completed <==");
			
		} catch (InterruptedException e) {
			

			logger.info("==> Document Chopping process Failed <==");
			captureScreen(driver, row+"_paChoppingDoc");
			
			e.printStackTrace();
			
			if (child.equals(child)) {
				driver.close();
			}
			
			driver.switchTo().window(parent);
			Assert.assertTrue(false);
		}
		
	}

}
