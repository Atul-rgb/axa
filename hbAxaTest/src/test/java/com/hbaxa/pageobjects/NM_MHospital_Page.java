package com.hbaxa.pageobjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.hbaxa.testdata.NM_MHospital_Data;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class NM_MHospital_Page {
	
	WebDriver ldriver;
	WebDriverWait wait;
	NM_MHospital_Data nmMHospitalData = new NM_MHospital_Data();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public NM_MHospital_Page(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // previous was 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 60); // previous it was 90
		js = (JavascriptExecutor)rdriver;
		
	}
	
	// ======== NM SOLO PROVIDER Page Element Objects ======== 
	
	@FindBy(name="UserName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassWord;

	@FindBy(id="submitBtn")
	@CacheLookup
	WebElement btnLogin;
	
	// Menu Navigation ====
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Network Maintenance')]")
	//@CacheLookup
	WebElement networkManintLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Maintain Hospital')]")
	//@CacheLookup
	WebElement maintainHospitalLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Create New')])[3]")
	@CacheLookup
	WebElement MaintainHospitalCreateNewLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Search')])[3]")
	@CacheLookup
	WebElement MaintainHospitalSearchMenuLink;
	
	//==== MAINTAIN CLINIC CREATE NEW FORMDATA =
	
	@FindBy(how=How.XPATH, using="//input[@id='effectiveDate']")
	@CacheLookup
	WebElement hsEffectiveDateLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='HospitalType']")
	@CacheLookup
	WebElement elementHIhospitalType;
	
	@FindBy(how=How.XPATH, using="//input[@id='hospitalNameEng']")
	@CacheLookup
	WebElement nmHospitalNameLink;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Contact Information')]")
	@CacheLookup
	WebElement gotoContactInformationLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='countryCodeTelId']")
	@CacheLookup
	WebElement elementCountryCodeTel;
	
	@FindBy(how=How.XPATH, using="//input[@id='telPhNoInfo']")
	@CacheLookup
	WebElement PhoneNumberLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='preferredCommInfo']")
	@CacheLookup
	WebElement elementPMOCommuntication;
	
	@FindBy(how=How.XPATH, using="//a[@id='btnAddContactInfo']")
	@CacheLookup
	WebElement CIPlusLink;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Payment Information')]")
	@CacheLookup
	WebElement gotoPaymentInformationLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='paymentModeOptionId']")
	@CacheLookup
	WebElement elementPrefferedPaymentOptions;
	
	@FindBy(how=How.XPATH, using="//div[@class='ButtonIcon']//a[@id='btnAddPayment']")
	@CacheLookup
	WebElement PIPlusButtonLink;	
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Service Location')]")
	@CacheLookup
	WebElement gotoServiceLocationLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='stateService']")
	@CacheLookup
	WebElement elementStateProvArea;
	
	@FindBy(how=How.XPATH, using="//select[@id='districtService']")
	@CacheLookup
	WebElement elementDistrictEnglish;
	
	@FindBy(how=How.XPATH, using="//input[@id='address1ServiceEng']")
	@CacheLookup
	WebElement Address1EngLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Operating Hours')]")
	@CacheLookup
	WebElement gotoOperatingHours;
	
	@FindBy(how=How.XPATH, using="//label[@for='ByAppointmentOnly']")
	@CacheLookup
	WebElement byAppointmentOnlyLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(@onclick,'ByAppointmentOnly')])[1]")
	@CacheLookup
	WebElement OperatingHoursPlusLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='saveNextHospital']")
	@CacheLookup
	WebElement SaveandNextLink;
	
	//===== LOADER ==========================
	
	By loader = By.xpath("//div[(contains(@id,'oaderDiv') or contains(@class,'ImageLoaderDiv')) and contains(@style,'opacity')]");
	
	//===== ALERT ============================
	
	By alertNotification = By.xpath("//span[@class='UserMsg']");
	
	//==== ASSOCIATE PROVIDER LINK ====
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'providerCodeSearch')]")
	@CacheLookup
	WebElement ProvidercodeLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSearch']")
	@CacheLookup
	WebElement AProviderSearchLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='tblSearchProvider-select-all']")
	@CacheLookup
	WebElement selectAllCheckLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnAttachAssocitate']")
	@CacheLookup
	WebElement AttachButtonLink;
	
	//@FindBy(how=How.ID, using="saveExitProvider")
	@FindBy(how=How.ID, using="btnExitCancel")
	@CacheLookup
	WebElement SaveAndExitButtonLink;
	
	//==== MAINTAIN HOSPITAL SEARCH PAGE ELEMENT ====
	
	@FindBy(how=How.ID, using="hospitalNameEng")
	@CacheLookup
	WebElement HospitalNameLink;
	
	@FindBy(how=How.ID, using="btnHospitalSearch")
	@CacheLookup
	WebElement btnHospitalSearchLink;
	
	By hProviderCodeLink = By.xpath("//table[@id='tblHospitalList']//tbody//td[2]");
	
	By hospitalNameLink = By.xpath("//table[@id='tblHospitalList']//tbody//td[3]");

	// 
	
	//===== LogOut =====
	@FindBy(how=How.XPATH, using="//a[@class='user-profile dropdown-toggle']")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Log Out')]")
	@CacheLookup
	WebElement logoutLink;
	
	
	
	
	
	
	
	// ======== Methods For WebElement ========  

	// ======== LOGIN ================================
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassWord(String pwd)
	{
		txtPassWord.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
	}
	
	//===== MENU NAVIGATION ============================
	
	public void gotoNMmenu(){
		
		js.executeScript("arguments[0].scrollIntoView(true);", networkManintLink);
	}

	public void clickNetworkMaintenance() {
		
		wait.until(ExpectedConditions.elementToBeClickable(networkManintLink)).click();

	}

	public void clickMaintainHospital() {

		wait.until(ExpectedConditions.elementToBeClickable(maintainHospitalLink)).click();

	}

	public void clickCreateNew() {

		wait.until(ExpectedConditions.elementToBeClickable(MaintainHospitalCreateNewLink)).click();
	}
	
	public void clickSearchMenu(){
		
		wait.until(ExpectedConditions.elementToBeClickable(MaintainHospitalSearchMenuLink)).click();
		
	}
	
	// ==== FOR LOGOUT ================================================================
	
	
	public void clickProfile() {
		
		wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
		
	}

	public void clickLogOut() {
		
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
		
	}
	
	// ================== FOR LOADER ==================================================

	public void waitLoader() throws InterruptedException {

		// =================================================================================

		for (int i = 0; i < 120; i++) {
			boolean loadercheck = false;

			try {

				Thread.sleep(1000);
				loadercheck = ldriver.findElement(loader).isEnabled();

			} catch (org.openqa.selenium.NoSuchElementException e) {
				// e.printStackTrace();
				if (i >= 120) {

					System.out
							.println("website too slow to response, check internet speed or code");

				} else {

					System.out.println("page loaded in exception....");
				}

				// loadercheck = false;
			} catch (Exception e) {
				System.out.println("Thread Exception");
			}

			if (loadercheck == true) {
				System.out.println("Page Loading....");

			} else {
				System.out.println("Page Loaded cause no Loader.....");
				// Thread.sleep(5000l);
				break;
			}

		}

		// =================================================================================

	}

	public void enterHSeffectiveDate(String hsEffectiveDate) {
		
		wait.until(ExpectedConditions.elementToBeClickable(hsEffectiveDateLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(hsEffectiveDateLink)).sendKeys(hsEffectiveDate);		
		
	}

	public void selectHIhospitalType(String hiHospitalType) {
		
		Select selecthiHospitalType = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementHIhospitalType)));
		selecthiHospitalType.selectByVisibleText(hiHospitalType);
		
	}

	public void enterHospitalNameEnglish(String nmHospitalName) {

		wait.until(ExpectedConditions.elementToBeClickable(nmHospitalNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(nmHospitalNameLink)).sendKeys(nmHospitalName);
	}
	
	public void gotoContactInformation() {

		js.executeScript("arguments[0].scrollIntoView(true);", gotoContactInformationLink);
		
	}

	public void selectCountryCodeTel(String CountryCodeTel) {
		
		Select selectCountryCodeTel = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementCountryCodeTel)));
		selectCountryCodeTel.selectByVisibleText(CountryCodeTel);
		
	}

	public void enterPhoneNumber(String CIPhoneNumber) {

		wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberLink)).sendKeys(CIPhoneNumber);
		
	}

	public void selectPMOCommuntication(String PMOCommuntication) {
		
		Select selectPMOCommuntication = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementPMOCommuntication)));
		selectPMOCommuntication.selectByVisibleText(PMOCommuntication);
		
	}

	public void clickCIPlusAdd() {

		wait.until(ExpectedConditions.elementToBeClickable(CIPlusLink)).click();
		
		
	}

	public void gotoPaymentInformation() {

		js.executeScript("arguments[0].scrollIntoView(true);", gotoPaymentInformationLink);
		
		
	}

	public void selectPrefferedPaymentOptions(String PrefferedPaymentOptions) {
		
		Select selPrefferedPaymentOptions = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementPrefferedPaymentOptions)));
		selPrefferedPaymentOptions.selectByVisibleText(PrefferedPaymentOptions);
		
	}

	public void clickPIPlusButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(PIPlusButtonLink)).click();
		
	}

	// ====  GO TO SERVICE LOCATION ====
	public void gotoServiceLocation() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoServiceLocationLink);
		
	}

	public void selectStateProvArea(String StateProvArea) {

		Select selStateProvArea = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementStateProvArea)));
		selStateProvArea.selectByVisibleText(StateProvArea);
		
	}

	public void selectDistrictEnglish(String DistrictEnglish) {

		Select selDistrictEnglish = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementDistrictEnglish)));
		selDistrictEnglish.selectByVisibleText(DistrictEnglish);
		
	}

	public void enterAddress1Eng(String Address1Eng) {

		wait.until(ExpectedConditions.elementToBeClickable(Address1EngLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(Address1EngLink)).sendKeys(Address1Eng);
	}

	public void gotoOperatingHours() {

		js.executeScript("arguments[0].scrollIntoView(true);", gotoOperatingHours);
		
	}

	public void byAppointmentOnly() {

		wait.until(ExpectedConditions.elementToBeClickable(byAppointmentOnlyLink)).click();
		
	}

	public void clickOHPlusAdd() {

		wait.until(ExpectedConditions.elementToBeClickable(OperatingHoursPlusLink)).click();
		
	}

	public void clickSaveAndNext() {
		
		wait.until(ExpectedConditions.elementToBeClickable(SaveandNextLink)).click();
		
	}
	
	
	public String getAlertotification() {

		String alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertNotification)).getText();
		return alert;
	}
	
	// ==== PAGE REDIRECTED TO ASSOCIATE PROVIDER ====

	public void enterProvidercode(String Providercode) {

		wait.until(ExpectedConditions.elementToBeClickable(ProvidercodeLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(ProvidercodeLink)).sendKeys(Providercode);
		
	}

	public void clickOnSearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AProviderSearchLink)).click();
		
	}

	public void verifyProviderCode(String ProviderCode) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+ProviderCode+"')]")));
		
	}

	public void clickSelectAllCheck() {
		
		wait.until(ExpectedConditions.elementToBeClickable(selectAllCheckLink)).click();
		
	}

	public void clickAttachButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AttachButtonLink)).click();
		
	}

	public void clickSaveAndExit() {

		wait.until(ExpectedConditions.elementToBeClickable(SaveAndExitButtonLink)).click();
		
	}

	// ==== MAINTAIN CLINIC SEARCH PAGE CODING ====
	
	public void enterHospitalName(String inputHospitalName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(HospitalNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(HospitalNameLink)).sendKeys(inputHospitalName);		
				
	}

	public void clickOnbtnHospitalSearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(btnHospitalSearchLink)).click();
		
	}

	public String getHospitalProviderCode() {
	
		String cProviderCode = wait.until(ExpectedConditions.visibilityOfElementLocated(hProviderCodeLink)).getText();
		return cProviderCode;
	}

	public String getHospitalName() {
	
		String clinicName = wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalNameLink)).getText();
		return clinicName;
	}
	

}
