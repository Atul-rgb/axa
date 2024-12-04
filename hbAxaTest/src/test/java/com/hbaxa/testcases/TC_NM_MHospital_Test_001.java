package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.NM_MClinic_Page;
import com.hbaxa.pageobjects.NM_MHospital_Page;
import com.hbaxa.pageobjects.ReimOverviewPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.NM_MClinic_Data;
import com.hbaxa.testdata.NM_MHospital_Data;

public class TC_NM_MHospital_Test_001 extends BaseClass {
	
	String alertmsg;
	public static String hospitalName;
	public static String inputhospitalName;
	public static String listHospitalProviderCode;
	
	NM_MHospital_Data nmMHospitalData = new NM_MHospital_Data();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginNMMHospital(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched - "+driver.getCurrentUrl());
			
			logger.info("<===== Login test started ====>");
			
			NM_MHospital_Page nmMHospital = new NM_MHospital_Page(driver);
			
			nmMHospital.setUserName(nmMHospitalData.getNmMHospitalData(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			nmMHospital.setPassWord(nmMHospitalData.getNmMHospitalData(currentRow,"Password"));
			logger.info("Password Entered");
			
			nmMHospital.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//if(driver.getTitle().equals("Home Page"))
			if(driver.getPageSource().contains("Network Maintenance"))
			{
				Assert.assertTrue(true);
				logger.info("====> Login Test Pass <====");

				Thread.sleep(3000l);
				captureScreen(driver, row+"_Success_loginNMMHospital");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("Login Test Fail");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_loginNMMHospital");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
	
			}
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginNMMHospital" })
	public void createNewMHospital(String row) throws IOException, InterruptedException
	{
		
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			NM_MHospital_Page nmMHospital = new NM_MHospital_Page(driver);

			logger.info("<==== MAINTAIN HOSPITAL CREATE NEW TEST STARTED ====>");
			
			//Menu Navigation =====
			nmMHospital.gotoNMmenu();
			logger.info("Go To NM Menu");
			Thread.sleep(1000l);
			nmMHospital.clickNetworkMaintenance();
			logger.info("Network Maintenance Clicked");
			Thread.sleep(1000l);
			nmMHospital.clickMaintainHospital();
			logger.info("Maintain Hospital Clicked");
			Thread.sleep(1000l);
			nmMHospital.clickCreateNew();
			logger.info("Maintain Hospital Create New Clicked");
			

			//====== MAINTAIN HOSPITAL FORM DATA ENTRY =============
			
			nmMHospital.enterHSeffectiveDate(nmMHospitalData.getNmMHospitalData(currentRow,"HD_Effective Date"));
			logger.info("Hospital Status Effective Date Entered");
			
			nmMHospital.selectHIhospitalType(nmMHospitalData.getNmMHospitalData(currentRow,"HI_Hospital Type"));
			logger.info("Hospital Type Selected");
			
			hospitalName = nmMHospitalData.getNmMHospitalData(currentRow,"HI_Hospital Name (English)");
			nmMHospital.enterHospitalNameEnglish(hospitalName);
			logger.info("Hospital Name Entered");
			
				//===== CONTACT INFORMATION ====
			
			nmMHospital.gotoContactInformation();
			logger.info("Go TO Contact Information");
			
			nmMHospital.selectCountryCodeTel(nmMHospitalData.getNmMHospitalData(currentRow, "CI_Country Code (Tel)"));
			logger.info("Country Code(Tel) selected");
			
			nmMHospital.enterPhoneNumber(nmMHospitalData.getNmMHospitalData(currentRow, "CI_Phone number (Tel)"));
			logger.info("Phone Number Entered");
			
			nmMHospital.selectPMOCommuntication(nmMHospitalData.getNmMHospitalData(currentRow, "CI_Preferred Mode of Communication"));
			logger.info("Preferred Mode of Communication Selected");
			
			nmMHospital.clickCIPlusAdd();
			logger.info("Plus Button Clicked of Contact Information");
			
				// ==== PAYMENT INFORMATION
			
			nmMHospital.gotoPaymentInformation();
			logger.info("Go To Payment Information");
			
			nmMHospital.selectPrefferedPaymentOptions(nmMHospitalData.getNmMHospitalData(currentRow, "PI_Preferred Payment Options"));
			logger.info("Preferred Payment options selected");
			
			nmMHospital.clickPIPlusButton();
			logger.info("Payment Information Plus Button Add");
			
				// ===== SERVICE LOCATION  ====
			
			nmMHospital.gotoServiceLocation();
			logger.info("Go To Service Location");
			
			nmMHospital.selectStateProvArea(nmMHospitalData.getNmMHospitalData(currentRow, "SL_State/Province/Area (English)"));
			logger.info("State/Province/Area Selected");
			
			nmMHospital.selectDistrictEnglish(nmMHospitalData.getNmMHospitalData(currentRow, "SL_District (English)"));
			logger.info("District(English) Selected");
			
			nmMHospital.enterAddress1Eng(nmMHospitalData.getNmMHospitalData(currentRow, "Address 1 (English)"));
			logger.info("Address 1 English Entered");
			
				// ==== OPERATING HOURS ====
			
			//nmMClinic.gotoOperatingHours();
			//logger.info("Go To Operating Hours");
			
			//nmMClinic.byAppointmentOnly();
			//logger.info("By appointment only selected");
			
			//nmMClinic.clickOHPlusAdd();
			//logger.info("Operating Hours Plus Added");
			
			nmMHospital.clickSaveAndNext();
			logger.info("Save and Next Clicked");
			
			//====== Code after Save & Next ======
			alertmsg = nmMHospital.getAlertotification();
			logger.info("Alert Message: "+ alertmsg);
			


			nmMHospital.waitLoader();
			
			// ==== Page Redirected to Associate Provider ====
			
			String nmHospSheetProviderCode = nmMHospitalData.getNmMHospitalData(currentRow, "Provider Code");
			String providerCode;
			if(nmHospSheetProviderCode == ""){
				
				providerCode = TC_NM_SProvider_Test_001.listSoloProviderCode;
				nmMHospital.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
				
			}else
			{
				providerCode = nmHospSheetProviderCode;
				nmMHospital.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
			}
			
			
			nmMHospital.clickOnSearch();
			logger.info("Search Clicked");
			
			nmMHospital.waitLoader();
			
			nmMHospital.verifyProviderCode(providerCode);
			logger.info("Provider Code Verified - "+ providerCode);
			
			nmMHospital.clickSelectAllCheck();
			logger.info("Select All Check Clicked");
			
			nmMHospital.clickAttachButton();
			logger.info("Attach Button Clicked");
			
			nmMHospital.waitLoader();			
			
			nmMHospital.clickSaveAndExit();
			logger.info("Save and Exit clicked");

			//====== Code after Save & Exit ======
			alertmsg = nmMHospital.getAlertotification();
			logger.info("Alert Message after Save & Exit: "+ alertmsg);

			captureScreen(driver, row+"_Success_createNewMHospital");
			logger.info("====> MAINTAIN HOSPITAL CREATE NEW TEST PASSED <====");				
			
			nmMHospital.waitLoader();
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_createNewMHospital");			
			logger.info("====> MAINTAIN HOSPITAL CREATE NEW TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value = "tc_row")
	@Test(priority = 3, dependsOnMethods = { "loginNMMHospital" })
	public void searchNewMHospital(String row) throws IOException, InterruptedException {

		try {
			

			int currentRow = Integer.parseInt(row);
			
			NM_MHospital_Page nmMHospital = new NM_MHospital_Page(driver);	
			logger.info("<==== SEARCH NEW MAINTAIN HOSPITAL TEST STARTED ====>");
			
			if(nmMHospitalData.getNmMHospitalSearch(currentRow, "MenuRequired").equals("Yes")){
			
				//==== Menu Navigation =====
				nmMHospital.gotoNMmenu();
				logger.info("Go To NM Menu");
				Thread.sleep(1000l);
				nmMHospital.clickNetworkMaintenance();
				logger.info("Network Maintenance Clicked");
				Thread.sleep(1000l);
				nmMHospital.clickMaintainHospital();
				logger.info("Maintain Hospital Clicked");
				Thread.sleep(1000l);
				nmMHospital.clickSearchMenu();
				logger.info("Search Menu Clicked");
			}
			
			nmMHospital.waitLoader();
			
			String sheetHospitalName = nmMHospitalData.getNmMHospitalSearch(currentRow, "HospitalName");
			
			if(sheetHospitalName == ""){

				inputhospitalName = hospitalName;
				nmMHospital.enterHospitalName(inputhospitalName);
				logger.info("Hospital Name Entered");
			}
			else
			{
				inputhospitalName = sheetHospitalName;
				nmMHospital.enterHospitalName(inputhospitalName);
				logger.info("Hospital Name Entered");
				
			}
			
			nmMHospital.clickOnbtnHospitalSearch();
			logger.info("Search Button Clicked");
			
			nmMHospital.waitLoader();
			
			captureScreen(driver, row+"_Success_searchNewMHospital");
			
			listHospitalProviderCode = nmMHospital.getHospitalProviderCode();
			String listHospitalName = nmMHospital.getHospitalName();
			
			if(inputhospitalName.equals(listHospitalName)){
				
				logger.info("List Hospital Provider Code :- "+listHospitalProviderCode);
				logger.info("List Hospital Name :- "+listHospitalName);
				
			}else{
				
				logger.info("Unable to get List Hospital Provider Code :- Please Check");
				logger.info("Unable to get List Hospital Name :- Please Check");
			}
			
			logger.info("====> SEARCH NEW MAINTAIN HOSPITAL TEST PASSED <====");
			
			} 
		catch (Exception e) {
			Thread.sleep(3000l);
			captureScreen(driver, row + "_searchNewMHospital");
			logger.info("====> SEARCH NEW MAINTAIN HOSPITAL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "loginNMMHospital" })
	public void logoutNMMHospital(String row) throws IOException, InterruptedException
	{
			NM_MHospital_Page nmMHospital = new NM_MHospital_Page(driver);	
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			nmMHospital.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			nmMHospital.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutNMMHospital");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				captureScreen(driver,row+"_logoutNMMHospital");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
	}

}
