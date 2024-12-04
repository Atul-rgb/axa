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

import com.hbaxa.testdata.NM_SProvider_Data;
import com.hbaxa.utilities.AdditionalConditions;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class NM_SProvider_Page {
	
	WebDriver ldriver;
	WebDriverWait wait;
	NM_SProvider_Data NMSoloProviderData = new NM_SProvider_Data();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public NM_SProvider_Page(WebDriver rdriver)
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
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Maintain Solo Provider')]")
	//@CacheLookup
	WebElement maintainSoloProviderLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Create New')])[1]")
	@CacheLookup
	WebElement SoloProviderCreateNewLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Search')])[1]")
	@CacheLookup
	WebElement SoloProviderSearchLink;
	
	//==== CREATE FORM DATA ====
	
	@FindBy(how=How.XPATH, using="//input[@id='effectiveDate']")
	@CacheLookup
	WebElement SpsEffectiveDateLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='doctorNameEng']")
	@CacheLookup
	WebElement SpsProviderNameLink;
	
	@FindBy(how=How.XPATH, using="//label[@for='male']")
	@CacheLookup
	WebElement MaleGenderLink;

	@FindBy(how=How.XPATH, using="//label[@for='female']")
	@CacheLookup
	WebElement FemaleGenderLink;
	
	@FindBy(how=How.XPATH, using="(//span[contains(.,'None selected')])[2]")
	@CacheLookup
	WebElement SpecialityEngLink;
	
	@FindBy(how=How.XPATH, using="(//input[@placeholder='Search'])[1]")
	@CacheLookup
	WebElement providerNameSearchLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Service Locations')]")
	@CacheLookup
	WebElement gotoServiceLocationLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='slEffectiveDate']")
	@CacheLookup
	WebElement SLEffectiveDateLink;
	
	
	@FindBy(how=How.ID, using="stateService")
	@CacheLookup
	WebElement elementstateProvinceArea;
	
	@FindBy(how=How.ID, using="districtService")
	@CacheLookup
	WebElement elementDistrictEnglish;
	
	@FindBy(how=How.ID, using="address1ServiceEng")
	@CacheLookup
	WebElement address1Link;
	
	@FindBy(how=How.ID, using="latitudeService")
	@CacheLookup
	WebElement LatitudeLink;
	
	@FindBy(how=How.ID, using="longitudeService")
	@CacheLookup
	WebElement longitudeLink;
	
	@FindBy(how=How.XPATH, using="//a[@id='btnAddServiceLocation']//i")
	@CacheLookup
	WebElement SLPlusButtonLink;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Longitude')]")
	@CacheLookup
	WebElement gototoLongitude;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Contact Information')]")
	@CacheLookup
	WebElement gototoContactInformation;

	@FindBy(how=How.XPATH, using="//select[@id='countryCodeTelId']")
	@CacheLookup
	WebElement elementCountryCodeTel;
	
	@FindBy(how=How.XPATH, using="//input[@id='telPhNoInfo']")
	@CacheLookup
	WebElement PhoneNumberLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='preferredCommInfo']")
	@CacheLookup
	WebElement elementPModeofCommunication;
	
	@FindBy(how=How.XPATH, using="//div[@class='ButtonIcon']//a[@id='btnAddContactInfo']")
	@CacheLookup
	WebElement CIPlusButtonLink;
	
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Payment Information')]")
	@CacheLookup
	WebElement gototoPaymentInformation;
	
	@FindBy(how=How.XPATH, using="//select[@id='paymentModeOptionId']")
	@CacheLookup
	WebElement elementPrefferedPaymentOptions;
	
	@FindBy(how=How.XPATH, using="//div[@class='ButtonIcon']//a[@id='btnAddPayment']")
	@CacheLookup
	WebElement PIPlusButtonLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSaveDoctor']")
	@CacheLookup
	WebElement saveButtonLink;
	
	//===== LOADER =====
	
	By loader = By.xpath("//div[(contains(@id,'oaderDiv') or contains(@class,'ImageLoaderDiv')) and contains(@style,'opacity')]");
	//By loader = By.xpath("//div[(contains(@id,'oaderDiv') or contains(@class,'ImageLoaderDiv'))");
	
	//===== ALERT ======
	
	By alertNotification = By.xpath("//span[@class='UserMsg']");
	
	//==== SOLOPROVIDER SEARCH PAGE ELEMENT ====
	
	@FindBy(how=How.XPATH, using="//input[@id='soloProviderName']")
	@CacheLookup
	WebElement SProviderNameLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnDoctorDynamicSearch']")
	@CacheLookup
	WebElement searchButtonLink;
	
	By sProviderCodeLink = By.xpath("//table[@id='indexTable']//tbody//td[2]");
	
	By sProviderNameLink = By.xpath("//table[@id='indexTable']//tbody//td[3]");
	
	//===== LogOut =====
	@FindBy(how=How.XPATH, using="//a[@class='user-profile dropdown-toggle']")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Log Out')]")
	@CacheLookup
	WebElement logoutLink;
	
	// ======== Methods For WebElement ========  

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
	
	// ==== For Logout ================================
	
	
	public void clickProfile() {
		
		wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
		
	}

	public void clickLogOut() {
		
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
		
	}
	
	//===== Menu Navigation ====

	public void clickNetworkMaintenance() {
		
		wait.until(ExpectedConditions.elementToBeClickable(networkManintLink)).click();

	}

	public void clickMaintainSoloProvider() {

		wait.until(ExpectedConditions.elementToBeClickable(maintainSoloProviderLink)).click();

	}

	public void clickCreateNew() {

		wait.until(ExpectedConditions.elementToBeClickable(SoloProviderCreateNewLink)).click();
	}
	
	
	public void clickSearch(){
		
		wait.until(ExpectedConditions.elementToBeClickable(SoloProviderSearchLink)).click();
	}

	public void enterSpsEffectiveDate(String SpsEffectiveDate) {
	
		wait.until(ExpectedConditions.elementToBeClickable(SpsEffectiveDateLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(SpsEffectiveDateLink)).sendKeys(SpsEffectiveDate);
		
	}

	public void enterSpsProviderName(String soloProviderName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(SpsProviderNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(SpsProviderNameLink)).sendKeys(soloProviderName);
		
	}

	public void clickMaleGender() {

		wait.until(ExpectedConditions.elementToBeClickable(MaleGenderLink)).click();
	}

	public void clickFemaleGender() {

		wait.until(ExpectedConditions.elementToBeClickable(FemaleGenderLink)).click();
	}

	
	public void selectSpecialityEnglish(String SpecialityEnglish, String row) {
		
		int currentrow = Integer.parseInt(row);
		
		wait.until(ExpectedConditions.elementToBeClickable(SpecialityEngLink)).click();

		wait.until(ExpectedConditions.elementToBeClickable(providerNameSearchLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(providerNameSearchLink)).sendKeys(SpecialityEnglish);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@title,'"+NMSoloProviderData.getNmSProviderData(currentrow, "SPI_Speciality")+"')]"))).click();
		
	}

	public void gotoServiceLocation() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoServiceLocationLink);
		
	}

	public void enterSLEffectiveDate(String SLEffectiveDate) {
		
		wait.until(ExpectedConditions.elementToBeClickable(SLEffectiveDateLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(SLEffectiveDateLink)).sendKeys(SLEffectiveDate);
		
	}

	public void selectStateProvinceArea(String stateProvinceArea) {
	
		Select selectSPArea = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementstateProvinceArea)));
		selectSPArea.selectByVisibleText(stateProvinceArea);
		
	}

	public void selectDistrictEnglish(String district) {
	
		Select selectDistrictEnglish = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementDistrictEnglish)));
		selectDistrictEnglish.selectByVisibleText(district);
		
	}

	public void enterAddress1English(String address1Enter) {

		wait.until(ExpectedConditions.elementToBeClickable(address1Link)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(address1Link)).sendKeys(address1Enter);
	
		
	}

	public void enterLatitude(String latitudevalue) {
		
		wait.until(ExpectedConditions.elementToBeClickable(LatitudeLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(LatitudeLink)).sendKeys(latitudevalue);
	}

	public void enterLongitude(String longitudeValue) {
		
		wait.until(ExpectedConditions.elementToBeClickable(longitudeLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(longitudeLink)).sendKeys(longitudeValue);
		
	}

	public void clickSLPlusButton() {

		wait.until(ExpectedConditions.elementToBeClickable(SLPlusButtonLink)).click();
	}

	public void scrolldowntoLongitude() {

		js.executeScript("arguments[0].scrollIntoView(true);", gototoLongitude);
		
	}

	public void gotoContactInformation() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gototoContactInformation);
		
	}

	public void selectCountryCodeTel(String CountryCodeTel) {
		
		Select selectCountryCodeTel = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementCountryCodeTel)));
		selectCountryCodeTel.selectByVisibleText(CountryCodeTel);
		
	}

	public void enterPhoneNumber(String CIPhoneNumber) {

		wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberLink)).sendKeys(CIPhoneNumber);
		
	}

	public void selectPModeofCommunication(String PModeofCommunication) {
		
		Select selectPModeofCommunication = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementPModeofCommunication)));
		selectPModeofCommunication.selectByVisibleText(PModeofCommunication);
		
	}

	public void clickCIPlusButton() {

		wait.until(ExpectedConditions.elementToBeClickable(CIPlusButtonLink)).click();
		
	}

	public void gotoPaymentInformation() {

		js.executeScript("arguments[0].scrollIntoView(true);", gototoPaymentInformation);
		
	}

	public void selectPrefferedPaymentOptions(String PrefferedPaymentOptions) {
		
		Select selPrefferedPaymentOptions = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementPrefferedPaymentOptions)));
		selPrefferedPaymentOptions.selectByVisibleText(PrefferedPaymentOptions);
		
	}

	public void clickPIPlusButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(PIPlusButtonLink)).click();
		
	}

	public void clickSave() {
		
		wait.until(ExpectedConditions.elementToBeClickable(saveButtonLink)).click();
		
	}

	// ================== FOR LOADER ==================================================

	public void waitLoader() throws InterruptedException {

		//=================================================================================
		
		for(int i=0;i<60;i++)
		{
			boolean loadercheck = false;
			
			try {
				
				Thread.sleep(1000);
				loadercheck = ldriver.findElement(loader).isEnabled();
				
			} catch (org.openqa.selenium.NoSuchElementException e) {
				//e.printStackTrace();
				if(i>=60){
					
					System.out.println("website too slow to response, check internet speed or code");
					
				}else{
					
					System.out.println("page loaded in exception....");	
				}
				
				//loadercheck = false;
			}catch(Exception e)
			{
				System.out.println("Thread Exception");
			}
			
			
			if(loadercheck == true)
			{
				System.out.println("Page Loading....");
				
			}
			else
			{
				System.out.println("Page Loaded cause no Loader.....");
				//Thread.sleep(5000l);
				break;
			}
			
		}
		
		//=================================================================================		
		
	}

	public String getAlertotification() {
		
		String alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertNotification)).getText();
		return alert;
	}

	public void enterSProviderName(String soloProvider) {
		
		wait.until(ExpectedConditions.elementToBeClickable(SProviderNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(SProviderNameLink)).sendKeys(soloProvider);
		
	}

	public void clickOnSearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(searchButtonLink)).click();
		
	}

	public String getSoloProviderCode() {
		
		String sProviderCode = wait.until(ExpectedConditions.visibilityOfElementLocated(sProviderCodeLink)).getText();
		return sProviderCode;
	}

	public String getSoloProviderName() {
		
		String sProviderName = wait.until(ExpectedConditions.visibilityOfElementLocated(sProviderNameLink)).getText();
		return sProviderName;
	}	

}
