package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.NM_MClinic_Page;
import com.hbaxa.pageobjects.ReimOverviewPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.NM_MClinic_Data;

public class TC_NM_MClinic_Test_001 extends BaseClass {
	
	String alertmsg;
	public static String clinicName;
	public static String inputclinicName;
	public static String listClinicProviderCode;
	
	NM_MClinic_Data nmMClinicData = new NM_MClinic_Data();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginNMMClinic(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched - "+driver.getCurrentUrl());
			
			logger.info("<===== Login test started ====>");
			
			NM_MClinic_Page nmMClinic = new NM_MClinic_Page(driver);
			
			nmMClinic.setUserName(nmMClinicData.getNmMClinicData(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			nmMClinic.setPassWord(nmMClinicData.getNmMClinicData(currentRow,"Password"));
			logger.info("Password Entered");
			
			nmMClinic.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//if(driver.getTitle().equals("Home Page"))
			if(driver.getPageSource().contains("Network Maintenance"))
			{
				Assert.assertTrue(true);
				logger.info("====> Login Test Pass <====");

				Thread.sleep(3000l);
				captureScreen(driver, row+"_Success_loginNMMClinic");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("Login Test Fail");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_loginNMMClinic");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
	
			}
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginNMMClinic" })
	public void createNewMClinic(String row) throws IOException, InterruptedException
	{
		
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			NM_MClinic_Page nmMClinic = new NM_MClinic_Page(driver);

			logger.info("<==== MAINTAIN CLINIC CREATE NEW TEST STARTED ====>");
			
			//Menu Navigation =====
			Thread.sleep(1000l);
			nmMClinic.clickNetworkMaintenance();
			logger.info("Network Maintenance Clicked");
			Thread.sleep(1000l);
			nmMClinic.clickMaintainClinic();
			logger.info("Maintain Clinic Clicked");
			Thread.sleep(1000l);
			nmMClinic.clickCreateNew();
			logger.info("Maintain Clinic Create New Clicked");
			

			//====== MAINTAIN CLINIC FORM DATA ENTRY =============
			
			nmMClinic.enterCSeffectiveDate(nmMClinicData.getNmMClinicData(currentRow,"CS_Effective Date"));
			logger.info("Clinic Status Effective Date Entered");
			
			nmMClinic.selectCIclinicType(nmMClinicData.getNmMClinicData(currentRow,"CI_Clinic Type"));
			logger.info("Clinic Type Selected");
			
			clinicName = nmMClinicData.getNmMClinicData(currentRow,"CI_Clinic Name (English)");
			nmMClinic.enterClinicNameEnglish(clinicName);
			logger.info("Clinic Name Entered");
			
				//===== CONTACT INFORMATION ====
			
			nmMClinic.gotoContactInformation();
			logger.info("Go TO Contact Information");
			
			nmMClinic.selectCountryCodeTel(nmMClinicData.getNmMClinicData(currentRow, "CI_Country Code (Tel)"));
			logger.info("Country Code(Tel) selected");
			
			nmMClinic.enterPhoneNumber(nmMClinicData.getNmMClinicData(currentRow, "CI_Phone number (Tel)"));
			logger.info("Phone Number Entered");
			
			nmMClinic.selectPMOCommuntication(nmMClinicData.getNmMClinicData(currentRow, "CI_Preferred Mode of Communication"));
			logger.info("Preferred Mode of Communication Selected");
			
			nmMClinic.clickCIPlusAdd();
			logger.info("Plus Button Clicked of Contact Information");
			
				// ==== PAYMENT INFORMATION
			
			nmMClinic.gotoPaymentInformation();
			logger.info("Go To Payment Information");
			
			nmMClinic.selectPrefferedPaymentOptions(nmMClinicData.getNmMClinicData(currentRow, "PI_Preferred Payment Options"));
			logger.info("Preferred Payment options selected");
			
			nmMClinic.clickPIPlusButton();
			logger.info("Payment Information Plus Button Add");
			
				// ===== SERVICE LOCATION  ====
			
			nmMClinic.gotoServiceLocation();
			logger.info("Go To Service Location");
			
			nmMClinic.selectStateProvArea(nmMClinicData.getNmMClinicData(currentRow, "SL_State/Province/Area (English)"));
			logger.info("State/Province/Area Selected");
			
			nmMClinic.selectDistrictEnglish(nmMClinicData.getNmMClinicData(currentRow, "SL_District (English)"));
			logger.info("District(English) Selected");
			
			nmMClinic.enterAddress1Eng(nmMClinicData.getNmMClinicData(currentRow, "Address 1 (English)"));
			logger.info("Address 1 English Entered");
			
				// ==== OPERATING HOURS ====
			
			nmMClinic.gotoOperatingHours();
			logger.info("Go To Operating Hours");
			
			nmMClinic.byAppointmentOnly();
			logger.info("By appointment only selected");
			
			nmMClinic.clickOHPlusAdd();
			logger.info("Operating Hours Plus Added");
			
			nmMClinic.clickSaveAndNext();
			logger.info("Save and Next Clicked");
			
			//====== Code after Save & Next ======
			alertmsg = nmMClinic.getAlertotification();
			logger.info("Alert Message: "+ alertmsg);
			


			nmMClinic.waitLoader();
			
			// ==== Page Redirected to Associate Provider ====
			
			String nmClinicSheetProviderCode = nmMClinicData.getNmMClinicData(currentRow, "Provider Code");
			String providerCode;
			if(nmClinicSheetProviderCode == ""){
				
				providerCode = TC_NM_SProvider_Test_001.listSoloProviderCode;
				nmMClinic.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
				
			}else
			{
				providerCode = nmClinicSheetProviderCode;
				nmMClinic.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
			}
			
			
			nmMClinic.clickOnSearch();
			logger.info("Search Clicked");
			
			nmMClinic.waitLoader();
			
			nmMClinic.verifyProviderCode(providerCode);
			logger.info("Provider Code Verified - "+ providerCode);
			
			nmMClinic.clickSelectAllCheck();
			logger.info("Select All Check Clicked");
			
			nmMClinic.clickAttachButton();
			logger.info("Attach Button Clicked");
			
			nmMClinic.waitLoader();			
			
		
			nmMClinic.clickSaveAndExit();
			logger.info("Save and Exit clicked");

			//====== Code after Save & Exit ======
			alertmsg = nmMClinic.getAlertotification();
			logger.info("Alert Message after Save & Exit: "+ alertmsg);

			captureScreen(driver, row+"_Success_createNewMClinic");
			logger.info("====> MAINTAIN CLININC CREATE NEW TEST PASSED <====");				
			
			nmMClinic.waitLoader();
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_createNewMClinic");			
			logger.info("====> MAINTAIN CLININC CREATE NEW TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value = "tc_row")
	@Test(priority = 3, dependsOnMethods = { "loginNMMClinic" })
	public void searchNewMClinic(String row) throws IOException, InterruptedException {

		try {
			
			
			
			int currentRow = Integer.parseInt(row);
			
			NM_MClinic_Page nmMClinic = new NM_MClinic_Page(driver);		
			logger.info("<==== SEARCH NEW MAINTAIN CLINIC TEST STARTED ====>");
			
			if(nmMClinicData.getNmMClinicSearch(currentRow, "MenuRequired").equals("Yes")){
			
				//==== Menu Navigation =====
				Thread.sleep(1000l);
				nmMClinic.clickNetworkMaintenance();
				logger.info("Network Maintenance Clicked");
				Thread.sleep(1000l);
				nmMClinic.clickMaintainClinic();
				logger.info("Maintain Clinic Clicked");
				Thread.sleep(1000l);
				nmMClinic.clickSearchMenu();
				logger.info("Search Menu Clicked");
			}
			
			nmMClinic.waitLoader();
			
			String sheetClinicName = nmMClinicData.getNmMClinicSearch(currentRow, "ClinicName");
			
			if(sheetClinicName == ""){

				inputclinicName = clinicName;
				nmMClinic.enterClinicName(inputclinicName);
				logger.info("Clinic Name Entered");
			}
			else
			{
				inputclinicName = sheetClinicName;
				nmMClinic.enterClinicName(inputclinicName);
				logger.info("Clinic Name Entered");
				
			}
			
			nmMClinic.clickOnbtnClinicSearch();
			logger.info("Search Button Clicked");
			
			nmMClinic.waitLoader();
			
			captureScreen(driver, row+"_Success_searchNewMClinic");
			
			listClinicProviderCode = nmMClinic.getClinicProviderCode();
			String listClinicName = nmMClinic.getClinicName();
			
			if(inputclinicName.equals(listClinicName)){
				
				logger.info("List Clinic Provider Code :- "+listClinicProviderCode);
				logger.info("List clinic Name :- "+listClinicName);
				
			}else{
				
				logger.info("Unable to get List Solo Provider Code :- Please Check");
				logger.info("Unable to get List Solo Provider Name :- Please Check");
			}
			
			logger.info("====> SEARCH NEW MAINTAIN CLINIC TEST PASSED <====");
			
			} 
		catch (Exception e) {
			Thread.sleep(3000l);
			captureScreen(driver, row + "_searchNewMClinic");
			logger.info("====> SEARCH NEW MAINTAIN CLINIC TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "loginNMMClinic" })
	public void logoutNMMClinic(String row) throws IOException, InterruptedException
	{
			NM_MClinic_Page nmMClinic = new NM_MClinic_Page(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			nmMClinic.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			nmMClinic.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutNMMClinic");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				captureScreen(driver,row+"_logoutNMMClinic");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
	}

}
