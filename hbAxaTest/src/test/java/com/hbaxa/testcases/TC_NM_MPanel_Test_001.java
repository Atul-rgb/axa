package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.NM_MClinic_Page;
import com.hbaxa.pageobjects.NM_MPanel_Page;
import com.hbaxa.pageobjects.ReimOverviewPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.NM_MClinic_Data;
import com.hbaxa.testdata.NM_MPanel_Data;

public class TC_NM_MPanel_Test_001 extends BaseClass {
	
	String alertmsg;
	public static String panelName;
	public static String inputpanelName;
	public static String listPanelProviderCode;
	
	NM_MPanel_Data nmMPanelData = new NM_MPanel_Data();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginNMMPanel(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched - "+driver.getCurrentUrl());
			
			logger.info("<===== Login test started ====>");
			
			NM_MPanel_Page nmMPanel = new NM_MPanel_Page(driver);
			
			nmMPanel.setUserName(nmMPanelData.getNmMPanelData(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			nmMPanel.setPassWord(nmMPanelData.getNmMPanelData(currentRow,"Password"));
			logger.info("Password Entered");
			
			nmMPanel.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//if(driver.getTitle().equals("Home Page"))
			if(driver.getPageSource().contains("Network Maintenance"))
			{
				Assert.assertTrue(true);
				logger.info("====> Login Test Pass <====");

				Thread.sleep(3000l);
				captureScreen(driver, row+"_Success_loginNMMPanel");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("Login Test Fail");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_loginNMMPanel");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
	
			}
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginNMMPanel" })
	public void createNewMPanel(String row) throws IOException, InterruptedException
	{
		
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			NM_MPanel_Page nmMPanel = new NM_MPanel_Page(driver);

			logger.info("<==== MAINTAIN PANEL CREATE NEW TEST STARTED ====>");
			
			//Menu Navigation =====
			nmMPanel.gotoNMmenu();
			logger.info("Go To NM Menu");
			Thread.sleep(1000l);
			nmMPanel.clickNetworkMaintenance();
			logger.info("Network Maintenance Clicked");
			Thread.sleep(1000l);
			nmMPanel.clickMaintainPanel();
			logger.info("Maintain Panel Clicked");
			Thread.sleep(1000l);
			nmMPanel.clickCreateNew();
			logger.info("Maintain Panel Create New Clicked");
			
			//====== MAINTAIN PANEL FORM DATA ENTRY =============
			
			nmMPanel.enterPSeffectiveDate(nmMPanelData.getNmMPanelData(currentRow,"PS_Effective Date"));
			logger.info("Panel Status Effective Date Entered");
			
			//String panelCode = nmMPanelData.getNmMPanelData(currentRow,"PI_Panel Code");
			//nmMPanel.enterPanelCode(panelCode);
			//logger.info("Panel Code Entered");
			
			panelName = nmMPanelData.getNmMPanelData(currentRow,"PI_Panel Name");
			nmMPanel.enterPIPanelName(panelName);
			logger.info("Panel Name Entered");
			
			nmMPanel.selectPanelName(panelName);
			logger.info("Panel Name Selected");
			
			
			//nmMPanel.selectHIhospitalType(panelCode);
			//logger.info("Hospital Type Selected");
			
			//hospitalName = nmMHospitalData.getNmMHospitalData(currentRow,"HI_Hospital Name (English)");
			//nmMHospital.enterHospitalNameEnglish(hospitalName);
			//logger.info("Hospital Name Entered");
			
				//===== CONTACT INFORMATION ====
			
			nmMPanel.gotoContactInformation();
			logger.info("Go TO Contact Information");
			
			nmMPanel.selectCountryCodeTel(nmMPanelData.getNmMPanelData(currentRow, "CI_Country Code (Tel)"));
			logger.info("Country Code(Tel) selected");
			
			nmMPanel.enterPhoneNumber(nmMPanelData.getNmMPanelData(currentRow, "CI_Phone number (Tel)"));
			logger.info("Phone Number Entered");
			
			nmMPanel.selectPMOCommuntication(nmMPanelData.getNmMPanelData(currentRow, "CI_Preferred Mode of Communication"));
			logger.info("Preferred Mode of Communication Selected");
			
			nmMPanel.clickCIPlusAdd();
			logger.info("Plus Button Clicked of Contact Information");
			
				// ==== PAYMENT INFORMATION
			
			nmMPanel.gotoPaymentInformation();
			logger.info("Go To Payment Information");
			
			nmMPanel.selectPrefferedPaymentOptions(nmMPanelData.getNmMPanelData(currentRow, "PI_Preferred Payment Options"));
			logger.info("Preferred Payment options selected");
			
			nmMPanel.clickPIPlusButton();
			logger.info("Payment Information Plus Button Add");
			
				// ===== SERVICE LOCATION  ====
			
			//nmMHospital.gotoServiceLocation();
			//logger.info("Go To Service Location");
			
			//nmMHospital.selectStateProvArea(nmMHospitalData.getNmMHospitalData(currentRow, "SL_State/Province/Area (English)"));
			//logger.info("State/Province/Area Selected");
			
			//nmMHospital.selectDistrictEnglish(nmMHospitalData.getNmMHospitalData(currentRow, "SL_District (English)"));
			//logger.info("District(English) Selected");
			
			//nmMHospital.enterAddress1Eng(nmMHospitalData.getNmMHospitalData(currentRow, "Address 1 (English)"));
			//logger.info("Address 1 English Entered");
			
				// ==== OPERATING HOURS ====
			
			//nmMClinic.gotoOperatingHours();
			//logger.info("Go To Operating Hours");
			
			//nmMClinic.byAppointmentOnly();
			//logger.info("By appointment only selected");
			
			//nmMClinic.clickOHPlusAdd();
			//logger.info("Operating Hours Plus Added");
			
			nmMPanel.clickSaveAndNext();
			logger.info("Save and Next Clicked");
			
			//====== Code after Save & Next ======
			alertmsg = nmMPanel.getAlertotification();
			logger.info("Alert Message: "+ alertmsg);
			


			nmMPanel.waitLoader();
			
			// ==== Page Redirected to Associate Provider ====
			
			String nmPanelSheetProviderCode = nmMPanelData.getNmMPanelData(currentRow, "Provider Code");
			String providerCode;
			if(nmPanelSheetProviderCode == ""){
				
				providerCode = TC_NM_SProvider_Test_001.listSoloProviderCode;
				nmMPanel.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
				
			}else
			{
				providerCode = nmPanelSheetProviderCode;
				nmMPanel.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
			}
			
			
			nmMPanel.clickOnSearch();
			logger.info("Search Clicked");
			
			nmMPanel.waitLoader();
			
			nmMPanel.verifyProviderCode(providerCode);
			logger.info("Provider Code Verified - "+ providerCode);
			
			nmMPanel.clickSelectAllCheck();
			logger.info("Select All Check Clicked");
			
			nmMPanel.clickAttachButton();
			logger.info("Attach Button Clicked");
			
			nmMPanel.waitLoader();			
			
			nmMPanel.clickSaveAndExit();
			logger.info("Save and Exit clicked");

			//====== Code after Save & Exit ======
			alertmsg = nmMPanel.getAlertotification();
			logger.info("Alert Message after Save & Exit: "+ alertmsg);

			captureScreen(driver, row+"_Success_createNewMPanel");
			logger.info("====> MAINTAIN PANEL CREATE NEW TEST PASSED <====");				
			
			nmMPanel.waitLoader();
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_createNewMPanel");			
			logger.info("====> MAINTAIN PANEL CREATE NEW TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value = "tc_row")
	@Test(priority = 3, dependsOnMethods = { "loginNMMPanel" })
	public void searchNewMPanel(String row) throws IOException, InterruptedException {

		try {
			
			int currentRow = Integer.parseInt(row);
			
			NM_MPanel_Page nmMPanel = new NM_MPanel_Page(driver);
			logger.info("<==== SEARCH NEW MAINTAIN PANEL TEST STARTED ====>");
			
			if(nmMPanelData.getNmMPanelSearch(currentRow, "MenuRequired").equals("Yes")){
			
				//==== Menu Navigation =====
				nmMPanel.gotoNMmenu();
				logger.info("Go To NM Menu");
				Thread.sleep(1000l);
				nmMPanel.clickNetworkMaintenance();
				logger.info("Network Maintenance Clicked");
				Thread.sleep(1000l);
				nmMPanel.clickMaintainPanel();
				logger.info("Maintain Hospital Clicked");
				Thread.sleep(1000l);
				nmMPanel.clickSearchMenu();
				logger.info("Search Menu Clicked");
			}
			
			nmMPanel.waitLoader();
			
			String sheetPanelName = nmMPanelData.getNmMPanelSearch(currentRow, "PanelName");
			
			if(sheetPanelName == ""){

				inputpanelName = panelName;
				nmMPanel.enterPanelName(inputpanelName);
				logger.info("Hospital Name Entered");
			}
			else
			{
				inputpanelName = sheetPanelName;
				nmMPanel.enterPanelName(inputpanelName);
				logger.info("Hospital Name Entered");
				
			}
			
			nmMPanel.clickOnbtnPanelSearch();
			logger.info("Search Button Clicked");
			
			nmMPanel.waitLoader();
			
			captureScreen(driver, row+"_Success_searchNewMPanel");
			
			listPanelProviderCode = nmMPanel.getPanelProviderCode();
			String listPanelName = nmMPanel.getPanelName();
			
			if(inputpanelName.equals(listPanelName)){
				
				logger.info("List Panel Provider Code :- "+listPanelProviderCode);
				logger.info("List Panel Name :- "+listPanelName);
				
			}else{
				
				logger.info("Unable to get List Panel Provider Code :- Please Check");
				logger.info("Unable to get List Panel Name :- Please Check");
			}
			
			logger.info("====> SEARCH NEW MAINTAIN PANEL TEST PASSED <====");
			
			}
		catch (Exception e) {
			Thread.sleep(3000l);
			captureScreen(driver, row + "_searchNewMPanel");
			logger.info("====> SEARCH NEW MAINTAIN PANEL TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "loginNMMPanel" })
	public void logoutNMMPanel(String row) throws IOException, InterruptedException
	{
			NM_MPanel_Page nmMPanel = new NM_MPanel_Page(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			nmMPanel.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			nmMPanel.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutNMMPanel");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				captureScreen(driver,row+"_logoutNMMPanel");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
	}

}
