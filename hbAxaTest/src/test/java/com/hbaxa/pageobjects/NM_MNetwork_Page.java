package com.hbaxa.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hbaxa.testdata.NM_MNetwork_Data;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class NM_MNetwork_Page {
	
	WebDriver ldriver;
	WebDriverWait wait;
	NM_MNetwork_Data nmMNetworkData = new NM_MNetwork_Data();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public NM_MNetwork_Page(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // previous was 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 60); // previous it was 90
		js = (JavascriptExecutor)rdriver;
		
	}
	
	// ======== NM NETWORK PROVIDER Page Element Objects ======== 
	
	@FindBy(name="UserName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassWord;

	@FindBy(id="submitBtn")
	@CacheLookup
	WebElement btnLogin;
	
	//==== Menu Navigation ====
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Network Maintenance')]")
	//@CacheLookup
	WebElement networkManintLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Maintain Network')]")
	//@CacheLookup
	WebElement maintainNetworkLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Create New')])[5]")
	@CacheLookup
	WebElement MaintainNetworkCreateNewLink;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Search')])[5]")
	@CacheLookup
	WebElement MaintainNetworkSearchMenuLink;
	
	//==== MAINTAIN PANEL CREATE NEW FORMDATA ====
	
	@FindBy(how=How.XPATH, using="//input[@id='EffectiveDate']")
	@CacheLookup
	WebElement nsEffectiveDateLink;
	
	
	@FindBy(how=How.XPATH, using="//input[@id='NetworkName']")
	@CacheLookup
	WebElement NINetworkNameLink;
	
	@FindBy(how=How.XPATH, using="//select[@id='HospitalType']")
	@CacheLookup
	WebElement elementHIhospitalType;

	@FindBy(how=How.XPATH, using="//button[@id='saveNext']")
	//@CacheLookup
	WebElement firstSaveandNextLink;
	
	// ==== ASSOCIATE PRODUCT TAB ELEMENT ====
	
	@FindBy(how=How.XPATH, using="//input[@id='productName']")
	//@CacheLookup
	WebElement ap_productNameLink;
	
	@FindBy(how=How.ID, using="btnProductSearch")
	//@CacheLookup
	WebElement ProductSearchbtnLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='tblSearchProduct-select-all']")
	//@CacheLookup
	WebElement AP_productSelectAll_Link;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnAttachProduct']")
	//@CacheLookup
	WebElement AProduct_Attachbtn_Link;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Affiliated Product & Plan')]")
	//@CacheLookup
	WebElement gotoAffiliatedProduct;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnNxt1Network']")
	//@CacheLookup
	WebElement SecondSaveandNext_Link;
	
	//===== LOADER ==========================
	
	By loader = By.xpath("//div[(contains(@id,'oaderDiv') or contains(@class,'ImageLoaderDiv')) and contains(@style,'opacity')]");
	
	//===== ALERT ============================
	
	By alertNotification = By.xpath("//span[@class='UserMsg']");
	
	//==== ASSOCIATE PROVIDER LINK ====
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'providerCodeSearch')]")
	@CacheLookup
	WebElement ProvidercodeLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSearch']")
	//@CacheLookup
	WebElement AProviderSearchLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='tblSearchProvider-select-all']")
	@CacheLookup
	WebElement selectAllCheckLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnAttachAssocitate']")
	@CacheLookup
	WebElement AttachButtonLink;
	
	//button[@id='btnSaveNetwork2']
	//@FindBy(how=How.ID, using="saveExitProvider")
	@FindBy(how=How.ID, using="btnSaveNetwork2")
	@CacheLookup
	WebElement SaveAndExitButtonLink;
	
	//==== MAINTAIN NETWORK SEARCH PAGE ELEMENT ====
	
	@FindBy(how=How.ID, using="networkName")
	@CacheLookup
	WebElement NetworkNameLink;
	
	@FindBy(how=How.ID, using="btnSearch")
	@CacheLookup
	WebElement btnNetworkSearchLink;
	
	//By pProviderCodeLink = By.xpath("//table[@id='tblPanelList']//tbody//td[2]");
	
	By networkNameLink = By.xpath("//table[@id='networkList']//tbody//td[2]");

	// ====
	
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

	public void clickMaintainNetwork() {

		wait.until(ExpectedConditions.elementToBeClickable(maintainNetworkLink)).click();

	}

	public void clickCreateNew() {

		wait.until(ExpectedConditions.elementToBeClickable(MaintainNetworkCreateNewLink)).click();
	}
	
	public void clickSearchMenu(){
		
		wait.until(ExpectedConditions.elementToBeClickable(MaintainNetworkSearchMenuLink)).click();
		
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

		for (int i = 0; i < 60; i++) {
			boolean loadercheck = false;

			try {

				Thread.sleep(1000);
				loadercheck = ldriver.findElement(loader).isEnabled();

			} catch (org.openqa.selenium.NoSuchElementException e) {
				// e.printStackTrace();
				if (i >= 60) {

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

	public void enterNSeffectiveDate(String nsEffectiveDate) {
		
		wait.until(ExpectedConditions.elementToBeClickable(nsEffectiveDateLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(nsEffectiveDateLink)).sendKeys(nsEffectiveDate);		
		
	}
	
	public void selectPanelCode(String panelCode) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(.,'"+panelCode+"')])[1]"))).click();
		
	}
	
	public void enterNINetworkName(String niNetworkName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(NINetworkNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(NINetworkNameLink)).sendKeys(niNetworkName);		
		
	}	
	
	
	public void clickFirstSaveAndNext() {
		
		wait.until(ExpectedConditions.elementToBeClickable(firstSaveandNextLink)).click();
		
	}
	
	// ==== AFTER REDIRECT, METHOD OF ASSOCIATED PRODUCT ====
	
	public void enterAP_ProductName(String ap_ProductName) {

		wait.until(ExpectedConditions.elementToBeClickable(ap_productNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(ap_productNameLink)).sendKeys(ap_ProductName);
		
	}
	
	public void selectAP_ProductName(String ap_ProductName){
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,'"+ap_ProductName+"')]"))).click();
	}
	
	public void clickProductSearch(){
		
		wait.until(ExpectedConditions.elementToBeClickable(ProductSearchbtnLink)).click();
		
	}
	
	public void verifyProductName(String ap_ProductName){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+ap_ProductName+"')]")));
	}
	
	public void clickProdSelectAllCheck(){
		
		wait.until(ExpectedConditions.elementToBeClickable(AP_productSelectAll_Link)).click();
	}
	
	public void clickProductAttachbtn(){
	
		wait.until(ExpectedConditions.elementToBeClickable(AProduct_Attachbtn_Link)).click();
	}
	
	public void gotoAffiliateProduct(){
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoAffiliatedProduct);
	}
	
	
	public void verfiyProductAttachment(String ap_planName){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='tblAffiliatedProduct']//td[contains(text(),'"+ap_planName+"')]")));
	}
	
	public void clickSecondSaveandNext(){
		
		wait.until(ExpectedConditions.elementToBeClickable(SecondSaveandNext_Link)).click();
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
		
		js.executeScript("arguments[0].scrollIntoView(true);", AttachButtonLink);
		wait.until(ExpectedConditions.elementToBeClickable(AttachButtonLink)).click();
		
	}

	public void clickSaveAndExit() {

		wait.until(ExpectedConditions.elementToBeClickable(SaveAndExitButtonLink)).click();
		
	}

	// ==== MAINTAIN NETWORK SEARCH PAGE CODING ====
	
	public void enterNetworkName(String inputNetworkName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(NetworkNameLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(NetworkNameLink)).sendKeys(inputNetworkName);		
				
	}

	public void clickOnbtnNetworkSearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(btnNetworkSearchLink)).click();
		
	}

	/*public String getPanelProviderCode() {
	
		String pProviderCode = wait.until(ExpectedConditions.visibilityOfElementLocated(pProviderCodeLink)).getText();
		return pProviderCode;
	}*/

	public String getNetworkName() {
	
		String listPanelName = wait.until(ExpectedConditions.visibilityOfElementLocated(networkNameLink)).getText();
		return listPanelName;
	}


	

}
