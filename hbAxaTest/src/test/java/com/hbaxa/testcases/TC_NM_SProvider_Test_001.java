package com.hbaxa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hbaxa.pageobjects.LoginPage;
import com.hbaxa.pageobjects.NM_SProvider_Page;
import com.hbaxa.pageobjects.ReimOverviewPage;
import com.hbaxa.testdata.LoginData;
import com.hbaxa.testdata.NM_SProvider_Data;

public class TC_NM_SProvider_Test_001 extends BaseClass {
	
	String alertmsg;
	public static String soloProvider;
	public static String inputSoloProvider;
	public static String listSoloProviderCode;
	
	NM_SProvider_Data nmSProviderData = new NM_SProvider_Data();

	@Parameters(value="tc_row")
	@Test(priority=1)
	public void loginNMSprovider(String row) throws IOException, InterruptedException
	{

			try {
				//Current row coming from testng xml
				int currentRow = Integer.parseInt(row);

				driver.get(baseURL);
				
				logger.info("Base url launched - "+driver.getCurrentUrl());
				
				logger.info("<===== Login test started ====>");
				
				NM_SProvider_Page nmSprovider = new NM_SProvider_Page(driver);
				
				nmSprovider.setUserName(nmSProviderData.getNmSProviderData(currentRow,"Username")); //First parameter is current row, second is collumn name
				logger.info("Username Entered");
				
				nmSprovider.setPassWord(nmSProviderData.getNmSProviderData(currentRow,"Password"));
				logger.info("Password Entered");
				
				nmSprovider.clickSubmit();
				logger.info("Submit Button Clicked");
				
				//if(driver.getTitle().equals("Home Page"))
				if(driver.getPageSource().contains("Network Maintenance"))	
				{
					Assert.assertTrue(true);
					logger.info("====> Login Test Pass <====");

					Thread.sleep(3000l);
					captureScreen(driver, row+"_Success_loginNMSprovider");
					//first parameter is driver, second is test name.
				}
				else
				{
					logger.info("Login Test Fail");
					Thread.sleep(3000l);
					captureScreen(driver,row+"_loginNMSprovider");
					//first parameter is driver, second is test name.
					Assert.assertTrue(false);

				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	
	
	@Parameters(value="tc_row")
	@Test(priority=2, dependsOnMethods = { "loginNMSprovider" })
	public void createNewSprovider(String row) throws IOException, InterruptedException
	{
		
		try {
			
			//Current row coming from testng xml
			int currentRow = Integer.parseInt(row);
			
			NM_SProvider_Page nmSprovider = new NM_SProvider_Page(driver);

			logger.info("<==== CREATE NEW SOLO PROVIDER TEST STARTED ====>");
			
			//Menu Navigation =====
			Thread.sleep(1000l);
			nmSprovider.clickNetworkMaintenance();
			logger.info("Network Maintenance Clicked");
			Thread.sleep(1000l);
			nmSprovider.clickMaintainSoloProvider();
			logger.info("Maintain Solo Provider Clicked");
			Thread.sleep(1000l);
			nmSprovider.clickCreateNew();
			logger.info("Create New Clicked");
			
			nmSprovider.enterSpsEffectiveDate(nmSProviderData.getNmSProviderData(currentRow, "SPS_Effective Date"));
			logger.info("Solo Provider Status -- Effective Date entered");
			
			soloProvider = nmSProviderData.getNmSProviderData(currentRow, "SPI_Solo Provider Name");
			nmSprovider.enterSpsProviderName(soloProvider);
			logger.info("Solo Provider Status -- Solo Provider Name entered - "+soloProvider);
			
			if(nmSProviderData.getNmSProviderData(currentRow, "SPI_Gender").equals("Male")){
				
				nmSprovider.clickMaleGender();
				logger.info("Solo Provider Status -- Solo Provider Gender Selected");
				
			}else
			{
				nmSprovider.clickFemaleGender();
				logger.info("Solo Provider Status -- Solo Provider Gender Selected");
			}
			
			nmSprovider.selectSpecialityEnglish(nmSProviderData.getNmSProviderData(currentRow, "SPI_Speciality"), row);
			logger.info("Speciality Selected");
			
			nmSprovider.gotoServiceLocation();
			logger.info("Go To Service Location");
			
			nmSprovider.enterSLEffectiveDate(nmSProviderData.getNmSProviderData(currentRow, "SL_Effective Date"));
			logger.info("SL Effective Date Entered");
			
			nmSprovider.selectStateProvinceArea(nmSProviderData.getNmSProviderData(currentRow, "SL_State/Province/Area (English)"));
			logger.info("State/Province/Area Selected");
			
			nmSprovider.selectDistrictEnglish(nmSProviderData.getNmSProviderData(currentRow, "SL_District (English)"));
			logger.info("District(English) Selected");
			
			nmSprovider.enterAddress1English(nmSProviderData.getNmSProviderData(currentRow, "SL_Address 1 (English)"));
			logger.info("Address 1 English Entered");
			
			nmSprovider.scrolldowntoLongitude();
			logger.info("Scroll Down to Longitude");
			
			nmSprovider.enterLatitude(nmSProviderData.getNmSProviderData(currentRow, "SL_Latitude"));
			logger.info("Latitude value Entered");
			
			nmSprovider.enterLongitude(nmSProviderData.getNmSProviderData(currentRow, "SL_Longitude"));
			logger.info("Longitude value Entered");
			
			nmSprovider.clickSLPlusButton();
			logger.info("Clicked on Service Location Plus Button");
			
			nmSprovider.gotoContactInformation();
			logger.info("Go To Contanct Information");
			
			nmSprovider.selectCountryCodeTel(nmSProviderData.getNmSProviderData(currentRow, "CI_Country Code (Tel)"));
			logger.info("Country Code(Tel) selected");
			
			nmSprovider.enterPhoneNumber(nmSProviderData.getNmSProviderData(currentRow, "CI_Phone number (Tel)"));
			logger.info("Phone Number Entered");
			
			nmSprovider.selectPModeofCommunication(nmSProviderData.getNmSProviderData(currentRow, "CI_Preferred Mode of Communication"));
			logger.info("Preferred Mode of Communication Selected");
			
			nmSprovider.clickCIPlusButton();
			logger.info("Clicked on Contact Information Plus Button");
			
			nmSprovider.gotoPaymentInformation();
			logger.info("Go To Payment Information");
			
			nmSprovider.selectPrefferedPaymentOptions(nmSProviderData.getNmSProviderData(currentRow, "PI_Preferred Payment Options"));
			logger.info("Preferred Payment options selected");
			
			nmSprovider.clickPIPlusButton();
			logger.info("Payment Information Plus Button Add");
			
			nmSprovider.clickSave();
			logger.info("Save Button Clicked");
			
			//nmSprovider.waitLoader();
			
			alertmsg = nmSprovider.getAlertotification();
			logger.info("Alert Message: "+ alertmsg);
			
			captureScreen(driver, row+"_Success_createNewSprovider");
			logger.info("====> CREATE NEW SOLO PROVIDER TEST PASSED <====");
			
			nmSprovider.waitLoader();
			
		} catch (Exception e) {
			
			Thread.sleep(3000l);
			captureScreen(driver, row+"_createNewSprovider");			
			logger.info("====> CREATE NEW SOLO PROVIDER TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value = "tc_row")
	@Test(priority = 3, dependsOnMethods = { "loginNMSprovider" })
	public void SearchNewSprovider(String row) throws IOException, InterruptedException {

		try {
			
			int currentRow = Integer.parseInt(row);
			
			NM_SProvider_Page nmSprovider = new NM_SProvider_Page(driver);			
			logger.info("<==== SEARCH NEW SOLO PROVIDER TEST STARTED ====>");
			
			if(nmSProviderData.getNmSProviderSearch(currentRow, "MenuRequired").equals("Yes")){
			
				//==== Menu Navigation =====
				Thread.sleep(1000l);
				nmSprovider.clickNetworkMaintenance();
				logger.info("Network Maintenance Clicked");
				Thread.sleep(1000l);
				nmSprovider.clickMaintainSoloProvider();
				logger.info("Maintain Solo Provider Clicked");
				Thread.sleep(1000l);
				nmSprovider.clickSearch();
				logger.info("Search Clicked");
			}
			
			nmSprovider.waitLoader();
			
			String sheetSoloProvider = nmSProviderData.getNmSProviderSearch(currentRow, "SoloProviderName");
			
			if(sheetSoloProvider == ""){

				inputSoloProvider = soloProvider;
				nmSprovider.enterSProviderName(inputSoloProvider);
				logger.info("Solo Provider Name Entered");
			}
			else
			{
				inputSoloProvider = sheetSoloProvider;
				nmSprovider.enterSProviderName(inputSoloProvider);
				logger.info("Solo Provider Name Entered");
				
			}
			
			nmSprovider.clickOnSearch();
			logger.info("Search Button Clicked");
			
			nmSprovider.waitLoader();

			
			listSoloProviderCode = nmSprovider.getSoloProviderCode();
			String listSoloProviderName = nmSprovider.getSoloProviderName();
			
			if(inputSoloProvider.equals(listSoloProviderName)){
				
				logger.info("List Solo Provider Code :- "+listSoloProviderCode);
				logger.info("List Solo Provider Name :- "+listSoloProviderName);
				captureScreen(driver, row+"_Success_SearchNewSprovider");
				
			}else{
				
				logger.info("Unable to get List Solo Provider Code :- Please Check");
				logger.info("Unable to get List Solo Provider Name :- Please Check");
			}
			
			logger.info("====> SEARCH NEW SOLO PROVIDER TEST PASSED <====");
			
			} 
		catch (Exception e) {
			Thread.sleep(3000l);
			captureScreen(driver, row + "_SearchNewSprovider");
			logger.info("====> SEARCH NEW SOLO PROVIDER TEST FAILED <====");
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Parameters(value="tc_row")
	@Test(priority=4, dependsOnMethods = { "SearchNewSprovider" })
	public void logoutNMSprovider(String row) throws IOException, InterruptedException
	{
			NM_SProvider_Page nmSprovider = new NM_SProvider_Page(driver);
			logger.info("<==== Logout Test Started ====>");
			
			Thread.sleep(10000l);
			nmSprovider.clickProfile();
			logger.info("Profile Icon Clicked for logout");
			
			nmSprovider.clickLogOut();
			logger.info("Log Out Clicked");
			
			Thread.sleep(3000l);
			if(driver.getTitle().equals("Sign In"))
			{
				Assert.assertTrue(true);
				logger.info("====> LogOut Test Pass <====");

				captureScreen(driver,row+"_Success_logoutNMSprovider");
				//first parameter is driver, second is test name.
			}
			else
			{
				logger.info("====> LogOut Test Fail <=====");
				
				captureScreen(driver,row+"_logoutNMSprovider");
				//first parameter is driver, second is test name.
				Assert.assertTrue(false);
			}
	}

}
