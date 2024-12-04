package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.NM_MNetwork_Page;
import com.hbaxa.testdata.NM_MNetwork_Data;

public class TC_NM_MNetwork_Test_001 extends BaseClass {
	
	String alertmsg;
	public static String networkName;
	public static String inputNetworkName;
	public static String listNetworkProviderCode;
	
	NM_MNetwork_Data nmMNetworkData = new NM_MNetwork_Data();
	
	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginNMMNetwork(String row) throws IOException, InterruptedException
	{

			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);

			driver.get(baseURL);
			
			logger.info("Base url launched - "+driver.getCurrentUrl());
			
			logger.info("<===== Login test started ====>");
			
			NM_MNetwork_Page nmMNetwork = new NM_MNetwork_Page(driver);
			
			nmMNetwork.setUserName(nmMNetworkData.getNmMNetworkData(currentRow,"Username")); //First parameter is current row, second is collumn name
			logger.info("Username Entered");
			
			nmMNetwork.setPassWord(nmMNetworkData.getNmMNetworkData(currentRow,"Password"));
			logger.info("Password Entered");
			
			nmMNetwork.clickSubmit();
			logger.info("Submit Button Clicked");
			
			//if(driver.getTitle().equals("Home Page"))
			if(driver.getPageSource().contains("Network Maintenance"))
			{
				Assert.assertTrue(true);
				logger.info("====> Login Test Pass <====");

				Thread.sleep(3000l);
				captureScreen(driver, row+"_Success_loginNMMNetwork");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("Login Test Fail");
				Thread.sleep(3000l);
				captureScreen(driver,row+"_loginNMMNetwork");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
	
			}
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginNMMNetwork" })
	public void createNewMNetwork(String row) throws IOException, InterruptedException
	{
		
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			NM_MNetwork_Page nmMNetwork = new NM_MNetwork_Page(driver);

			logger.info("<==== MAINTAIN NETWORK CREATE NEW TEST STARTED ====>");
			
			//Menu Navigation =====
			nmMNetwork.gotoNMmenu();
			logger.info("Go To NM Menu");
			Thread.sleep(1000l);
			nmMNetwork.clickNetworkMaintenance();
			logger.info("Network Maintenance Clicked");
			Thread.sleep(1000l);
			nmMNetwork.clickMaintainNetwork();
			logger.info("Maintain Network Clicked");
			Thread.sleep(1000l);
			nmMNetwork.clickCreateNew();
			logger.info("Maintain Network Create New Clicked");
			
			//====== MAINTAIN NETWORK FORM DATA ENTRY =============
			
			nmMNetwork.enterNSeffectiveDate(nmMNetworkData.getNmMNetworkData(currentRow,"NS_Effective Date"));
			logger.info("Networ Status Effective Date Entered");
			
			networkName = nmMNetworkData.getNmMNetworkData(currentRow,"NI_Network Name");
			nmMNetwork.enterNINetworkName(networkName);
			logger.info("Network Name Entered");
			
			// CLICK FIRST SAVE AND NEXT
			
			nmMNetwork.clickFirstSaveAndNext();
			logger.info("First Save and Next Clicked");
			
			//====== Code after Save & Next ======
			alertmsg = nmMNetwork.getAlertotification();
			logger.info("Alert Message: "+ alertmsg);
			
			nmMNetwork.waitLoader();
			
			// ==== Tab Redirected to Associated Products ====
			String ap_productName = nmMNetworkData.getNmMNetworkData(currentRow,"AP_Product Name");
			nmMNetwork.enterAP_ProductName(ap_productName);
			logger.info("Product Name Entered of Associated Products");
			
			nmMNetwork.selectAP_ProductName(ap_productName);
			logger.info("Product Name Selected");
			
			nmMNetwork.clickProductSearch();
			logger.info("Search Button Clicked of Associated Products");
			
			nmMNetwork.waitLoader();
			
			nmMNetwork.verifyProductName(ap_productName);
			logger.info("Product Name Verified");
			
			nmMNetwork.clickProdSelectAllCheck();
			logger.info("Select All Checked");
			
			nmMNetwork.clickProductAttachbtn();
			logger.info("Attach Button Clicked of Associate Products");
			
			nmMNetwork.gotoAffiliateProduct();
			logger.info("Move to Affiliated Product section");
			
			String ap_planName = nmMNetworkData.getNmMNetworkData(currentRow,"Plan Name");
			nmMNetwork.verfiyProductAttachment(ap_planName);
			logger.info("Product attachement veryfied");
			
			nmMNetwork.clickSecondSaveandNext();
			logger.info("Save and Next Clicked on Associated Products tab");
			
			//====== Code after Save & Next ======
			alertmsg = nmMNetwork.getAlertotification();
			logger.info("Second Save & Next Alert Message: "+ alertmsg);
			
			nmMNetwork.waitLoader();
			
			
			// ==== Tab Redirected to Associated Providers ====
			
			String nmNetworkSheetProviderCode =  nmMNetworkData.getNmMNetworkData(currentRow, "Provider Code");
			String providerCode;
			if(nmNetworkSheetProviderCode == ""){
				
				providerCode = TC_NM_SProvider_Test_001.listSoloProviderCode;
				nmMNetwork.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
				
			}else
			{
				providerCode = nmNetworkSheetProviderCode;
				nmMNetwork.enterProvidercode(providerCode);
				logger.info("Provider Code Entered");
			}
			
			
			nmMNetwork.clickOnSearch();
			logger.info("Search Clicked");
			
			nmMNetwork.waitLoader();
			
			nmMNetwork.verifyProviderCode(providerCode);
			logger.info("Provider Code Verified - "+ providerCode);
			
			nmMNetwork.clickSelectAllCheck();
			logger.info("Select All Check Clicked");
			
			nmMNetwork.clickAttachButton();
			logger.info("Attach Button Clicked");
			
			nmMNetwork.gotoAffiliateProduct();
			logger.info("Go To Affiliate Providers");
			
			nmMNetwork.waitLoader();			
			
			nmMNetwork.clickSaveAndExit();
			logger.info("Save and Exit clicked");

			//====== Code after Save & Exit ======
			alertmsg = nmMNetwork.getAlertotification();
			logger.info("Alert Message after Save & Exit: "+ alertmsg);

			captureScreen(driver, row+"_Success_createNewMNetwork");
			logger.info("====> MAINTAIN NETWORK CREATE NEW TEST PASSED <====");				
			
			nmMNetwork.waitLoader();
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_createNewMNetwork");			
			logger.info("====> MAINTAIN NETWORK CREATE NEW TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value = "tc_row")
	@Test(priority = 3, dependsOnMethods = { "loginNMMNetwork" })
	public void searchNewMNetwork(String row) throws IOException, InterruptedException {

		try {
			
			int currentRow = Integer.parseInt(row);
			
			NM_MNetwork_Page nmMNetwork = new NM_MNetwork_Page(driver);
			logger.info("<==== SEARCH NEW MAINTAIN NETWORK TEST STARTED ====>");
			
			if(nmMNetworkData.getNmMNetworkSearch(currentRow, "MenuRequired").equals("Yes")){
			
				//==== Menu Navigation =====
				nmMNetwork.gotoNMmenu();
				logger.info("Go To NM Menu");
				Thread.sleep(1000l);
				nmMNetwork.clickNetworkMaintenance();
				logger.info("Network Maintenance Clicked");
				Thread.sleep(1000l);
				nmMNetwork.clickMaintainNetwork();
				logger.info("Maintain Network Clicked");
				Thread.sleep(1000l);
				nmMNetwork.clickSearchMenu();
				logger.info("Search Menu Clicked");
			}
			
			nmMNetwork.waitLoader();
			
			String sheetNetworkName = nmMNetworkData.getNmMNetworkSearch(currentRow, "NetworkName");
			
			if(sheetNetworkName == ""){

				inputNetworkName = networkName;
				nmMNetwork.enterNetworkName(inputNetworkName);
				logger.info("Network Name Entered");
			}
			else
			{
				inputNetworkName = sheetNetworkName;
				nmMNetwork.enterNetworkName(inputNetworkName);
				logger.info("Network Name Entered");
				
			}
			
			nmMNetwork.clickOnbtnNetworkSearch();
			logger.info("Search Button Clicked");
			
			nmMNetwork.waitLoader();
			
			captureScreen(driver, row+"_Success_searchNewMNetwork");
			
			//listPanelProviderCode = nmMPanel.getPanelProviderCode();
			String listNetworkName = nmMNetwork.getNetworkName();
			
			if(inputNetworkName.equals(listNetworkName)){
				
				//logger.info("List Panel Provider Code :- "+listPanelProviderCode);
				logger.info("List NETWORK Name :- "+listNetworkName);
				
			}else{
				
				//logger.info("Unable to get List Panel Provider Code :- Please Check");
				logger.info("Unable to get List NETWORK Name :- Please Check");
			}
			
			logger.info("====> SEARCH NEW MAINTAIN NETWORK TEST PASSED <====");
			
			}
		catch (Exception e) {
			Thread.sleep(3000l);
			captureScreen(driver, row + "_searchNewMNetwork");
			logger.info("====> SEARCH NEW MAINTAIN NETWORK TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "loginNMMNetwork" })
	public void logoutNMMNetwork(String row) throws IOException, InterruptedException
	{
			NM_MNetwork_Page nmMNetwork = new NM_MNetwork_Page(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			nmMNetwork.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			nmMNetwork.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutNMMNetwork");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				captureScreen(driver,row+"_logoutNMMNetwork");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
	}

}
