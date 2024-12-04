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

import com.hbaxa.testdata.CashlessOverviewData;
import com.hbaxa.testdata.ReimOverviewData;
import com.hbaxa.utilities.AdditionalConditions;
import com.mongodb.diagnostics.logging.Logger;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class CashlessOverviewPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	CashlessOverviewData cashlessOverviewRead = new CashlessOverviewData();
	
	
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public CashlessOverviewPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // previous it was 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 60); // previous it was 90
		js = (JavascriptExecutor)rdriver;
		
	}	
	
	
	// ======== CashlessDataCapture Page Element Objects ======== 
	
	@FindBy(name="UserName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassWord;

	@FindBy(id="submitBtn")
	@CacheLookup
	WebElement btnLogin;
	
	//===== LogOut =====
	@FindBy(how=How.XPATH, using="//nav[@class='top_nav navbar justify-content-between']//li[2]//a[@href='/HealthBuzzApp/Internal/SessionOut']")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Log Out')]")
	@CacheLookup
	WebElement logoutLink;
	
	//@FindBy(how=How.XPATH, using="//a[contains(.,'Claims')]")
	@FindBy(how=How.XPATH, using="//a[text()='Claims']")
	@CacheLookup
	WebElement 	claimLink;
	
	//@FindBy(how=How.XPATH, using="//a[contains(text(),'Cashless Claim')]")
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Cashless Claim')]")
	@CacheLookup
	WebElement 	CashlessClaimtLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Cashless Overview')]")
	@CacheLookup
	WebElement 	cOverviewLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='ClaimNo']")
	//@CacheLookup
	WebElement 	txtClaimNo;
	
	
	@FindBy(how=How.XPATH, using="//select[@name='UserDetails']")
	@CacheLookup
	WebElement 	elementcasePikcedBY;
	
	//@FindBy(how=How.XPATH, using="//input[@value='Go']")
	@FindBy(how=How.XPATH, using="//input[@value='Search']")
	//@CacheLookup
	WebElement 	goBtnLink;
	
	@FindBy(how=How.XPATH, using="//a[@data-original-title='Proceed']")
	@CacheLookup
	WebElement 	proceedLink;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'btnAdjudicateId')]")
	@CacheLookup
	WebElement 	autoAudjudicateLink;
	
	@FindBy(how=How.XPATH, using="//label[contains(.,'Claim Status')]")
	@CacheLookup
	WebElement 	gotoClaimStatLink;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'ApRejStatus')]")
	@CacheLookup
	WebElement 	elementClaimStatus;
	
	
	@FindBy(how=How.XPATH, using="//input[@id='approvedId']")
	@CacheLookup
	WebElement 	updateStatusLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='letterPreview']")
	@CacheLookup
	WebElement 	PreviewBenefitItemLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'View Letter')]")
	@CacheLookup
	WebElement 	viewLetterLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Generate letter')]")
	//@CacheLookup
	WebElement 	GenerateLetterLink;
	
	@FindBy(how=How.XPATH, using="//input[@value='Generate Letter']")
	//@CacheLookup
	WebElement 	GenerateLetterbtnLink;
	
	// ======== APS GENERATION ===========================================
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'APS Generation')]")
	@CacheLookup
	WebElement apsGenerationbtnLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'ApsGenerationId')]")
	@CacheLookup
	WebElement addNewbtnLink;

	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'DocHospClncId')]")
	@CacheLookup
	WebElement txtdoctorName;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnGoASPGenId']")
	@CacheLookup
	WebElement goapsLink;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Title')]")
	@CacheLookup
	WebElement txtTitle;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Payee')]")
	@CacheLookup
	WebElement txtpayee;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'AttentionName')]")
	@CacheLookup
	WebElement txtattentionName;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Address1')]")
	@CacheLookup
	WebElement txtaddress1;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Address2')]")
	@CacheLookup
	WebElement txtaddress2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Address3')]")
	@CacheLookup
	WebElement txtaddress3;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Address4')]")
	@CacheLookup
	WebElement txtaddress4;
	
	@FindBy(how=How.XPATH, using="//input[@id='ReminderPeriod']")
	@CacheLookup
	WebElement txtreminderNoDays;
	
	
	@FindBy(how=How.XPATH, using="//select[@id='StandardQuestionCode1']")
	@CacheLookup
	WebElement elementquest1;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'StandardQuestionCode2')]")
	@CacheLookup
	WebElement elementquest2;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'StandardQuestionCode3')]")
	@CacheLookup
	WebElement elementquest3;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'StandardQuestionCode4')]")
	@CacheLookup
	WebElement elementquest4;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'clickToSubmit')]")
	@CacheLookup
	WebElement savebtnLink;
	
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Generate letter')]")
	@CacheLookup
	WebElement generateLetterapsLink;
	
	@FindBy(how=How.XPATH, using="//input[@value='Generate Letter']")
	@CacheLookup
	WebElement generateLetterapsbtnLink;	
	
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Assessment Enquiry')]")
	@CacheLookup
	WebElement AssessmentenquirybtnLink;
	
	
	@FindBy(how=How.XPATH, using="//input[@id='AReferenceNo']")
	@CacheLookup
	WebElement txtclaimNumberAssEnq;
	
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSearchId']")
	@CacheLookup
	WebElement AssquiryGobtnLink;
	
	@FindBy(how=How.XPATH, using="//a[@id='AssessmentEnquiryClose']")
	@CacheLookup
	WebElement AssessEnqClosePopUpLink;
	
	// ======== PENDING NOTIFICATIONS =========
	
	@FindBy(how=How.XPATH, using="//input[@value='Pending Notification']")
	@CacheLookup
	WebElement PendingStatusLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSearchRemarkCode']")
	@CacheLookup
	WebElement RemarksSearchLink;
	
	@FindBy(how=How.XPATH, using="//div[@class='fancybox-inner']//input[@id='txtSrchRmkId']")
	@CacheLookup
	WebElement txtremarksCode;
	
	
	@FindBy(how=How.XPATH, using="(//input[@id='btnSearchRemark'])[2]")
	@CacheLookup
	WebElement SearchPendingNotiLink;
	
	//@FindBy(how=How.XPATH, using="(//input[@id='btnRemarkGo'])[3]")
	@FindBy(how=How.XPATH, using="//div[@class='fancybox-inner']//input[@id='btnRemarkGo']")
	@CacheLookup
	WebElement GoPendinNotiLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='btnSave']")
	@CacheLookup
	WebElement savePendingNotiLink;	
	
	
	@FindBy(how=How.XPATH, using="//input[@id='btnPendingNotification']")
	@CacheLookup
	WebElement claimViewPendingNotiLink;
	
	// FOR LOADER ============================================
	
	// ======== LOADER ========================

	//By loader = By.xpath("//div[contains(@ng-show,'loaderDiv == true') and contains(@aria-hidden,'false')]");
	
	By loader = By.xpath("//div[contains(@id,'loaderDiv') and contains(@style,'block')]");

	// #loaderDiv	
	
	// ==== FOR REASSIGNED ====================================
	
	@FindBy(how=How.XPATH, using="//button[@title='Reassign']")
	@CacheLookup
	WebElement reassignLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='UserSearchText']")
	@CacheLookup
	WebElement assignUserLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='UserSearchBtn']")
	@CacheLookup
	WebElement searchAssignLink;
	
	@FindBy(how=How.XPATH, using="//a[@class='link-title']")
	@CacheLookup
	WebElement selectAssignedLink;	
	
	// ==== WEBELEMENT FOR REVERSE PROCESS ====
	
	@FindBy(how=How.XPATH, using="//select[@name='Statusid']")
	@CacheLookup
	WebElement elementfirstStatus;
	
	@FindBy(how=How.XPATH, using="//a[contains(@data-original-title,'Reverse')]")
	@CacheLookup
	WebElement clickReverseLink;
	
	@FindBy(how=How.XPATH, using="//label[@for='chkRevise']")
	@CacheLookup
	WebElement checkReverseLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='ReviseClaimBtn']")
	@CacheLookup
	WebElement ReverseBtnLink;
	
	@FindBy(how=How.XPATH, using="//select[@name='Statusid']")
	@CacheLookup
	WebElement elementpendingStatus;	
	
	@FindBy(how=How.XPATH, using="//select[@name='Statusid']")
	//@CacheLookup
	WebElement elementStatusApproved;
	
	//@FindBy(how=How.XPATH, using="//input[@value='Search']")
	//@CacheLookup
	//WebElement clickSearchAgainLink;
	
	By clickSearchAgainLink = By.xpath("//input[@value='Search']");
	
	// FOR CALCULATION =================
	
	@FindBy(how=How.XPATH, using="//input[@id='totalClaimAmount']")
	@CacheLookup
	WebElement totalClaim;
	
	@FindBy(how=How.XPATH, using="//input[@id='tApprovedAmount']")
	@CacheLookup
	WebElement totalApprovedAmt;	
	
	// New changes For settlement type-Customer
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Settlement Type - Customer')]")
	@CacheLookup
	WebElement customertype;
	
	@FindBy(how=How.XPATH, using="//select[@id='ddlSettlementType']")
	@CacheLookup
	WebElement byautopaycutomer;
	///////////////////////
	@FindBy(how=How.XPATH, using="//input[@id='AutopayBankNo']") 
	@CacheLookup
	WebElement txtbankNumberC; 
	////=======================
	@FindBy(how=How.XPATH, using="//input[@id='AutopayBranchNo']")
	@CacheLookup
	WebElement txtbranchNumberC;
	/////========================
	@FindBy(how=How.XPATH, using="//input[@id='AutopayAccountNo']")
	@CacheLookup
	WebElement txtaccountNumberC;
	/////-----------------------
	@FindBy(how=How.XPATH, using="//input[@name='AutopayConfirmAccountNo']")
	@CacheLookup
	WebElement txtconfirmAccountNumberC;
	/////----------------------------
	@FindBy(how=How.XPATH, using="//input[@id='AutopayNameOfPayee']") 
	@CacheLookup
	WebElement txtpayeeNameautoC;
	@FindBy(how=How.XPATH, using="//label[@for='ChequeMemberAddress']")
	@CacheLookup
	WebElement MemberAddressLinkchq;
	
	
	// ======== Methods For WebElement ========  
	
	/// New changes Customer settlement type 
	
	public void selectcustomertype(String customertype){
		
		Select selectcustomermethod=new Select(wait.until(ExpectedConditions.elementToBeClickable(byautopaycutomer)));
		
		selectcustomermethod.selectByVisibleText(customertype);
		
	}
	
	public void selectCustmerbycheque(String customerbycheque){
		
		Select bychequecustomer= new Select(wait.until(ExpectedConditions.elementToBeClickable(byautopaycutomer)));
		
		bychequecustomer.selectByVisibleText(customerbycheque);
	}
	
		public void enterbankknocus(String banknocust){
			txtbankNumberC.sendKeys(banknocust);
			
		}
	
		public void enterbranchcustomer(String branchcust){
			txtbranchNumberC.sendKeys(branchcust);
			
		}
		public void enteraccountnocust(String customeraccount){
			txtaccountNumberC.sendKeys(customeraccount);
			
		}
		
		public void enterconfirmaccount(String confirmaccount){
			txtconfirmAccountNumberC.sendKeys(confirmaccount);
			
		}
		
		public void entercuspayeename(String payeenamecustomer){
			
			txtpayeeNameautoC.sendKeys(payeenamecustomer);
		}
		public void clickMemberAddress() {

			//wait.until(ExpectedConditions.elementToBeClickable(MemberAddressLink)).click();
			if(MemberAddressLinkchq.isSelected())
				
			{
				//MemberAddressLinkchq.click();
				System.out.println("Member Address Chq Already selected");
			}else
			{
				MemberAddressLinkchq.click();
				System.out.println("Member Address Chq selected");
		
			}
		}

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

	public void clickClaim() {

		wait.until(ExpectedConditions.elementToBeClickable(claimLink)).click();
		
	}

	public void clickCashlessClaim() {

		wait.until(ExpectedConditions.elementToBeClickable(CashlessClaimtLink)).click();
	}

	public void clickCOverview() {

		wait.until(ExpectedConditions.elementToBeClickable(cOverviewLink)).click();
		
	}
	
	//============================= FOR LOGOUT =====================================

	public void clickProfile() {
		
		wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
		
	}

	public void clickLogOut() {
		
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
		
	}
	//===============================================================================

	public void enterClaimNo(String claimNo) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtClaimNo)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtClaimNo)).sendKeys(claimNo);
		
	}
	
	public void selectCasePickedBy(String casePikcedBY){
		//sdfsd
		
		Select selectCasePickedBy = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementcasePikcedBY)));
		selectCasePickedBy.selectByVisibleText(casePikcedBY);
		
	}

	public void clickGo() {
		
		wait.until(ExpectedConditions.elementToBeClickable(goBtnLink)).click();
	}

	public void clickProceed() {
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedLink)).click();
		
	}

	public void clickAutoAdjudicate() {

		wait.until(ExpectedConditions.elementToBeClickable(autoAudjudicateLink)).click();
		
	}

	public void gotoClaimStatus() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoClaimStatLink);
		
	}
	///settlement type customer
	public void gotosettlementtypecutomer(){
		
		js.executeScript("arguments[0].scrollIntoView(true);", customertype);
	}
	
	public boolean settlementtypecustomer(){
		
		boolean settlementtypecus=customertype.isDisplayed();
		
		return settlementtypecus;
	}
	
	public void selectcutomertype(String bycustomertype){
		
		Select selectcutomerpayee=new Select(wait.until(ExpectedConditions.elementToBeClickable(byautopaycutomer)));
		
		selectcutomerpayee.selectByVisibleText(bycustomertype);
	}

	public void selectClaimStatus(String claimStatus) {
		
		Select selectClaimStatus = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementClaimStatus)));
		selectClaimStatus.selectByVisibleText(claimStatus);
		
	}

	public void clickUpdateStatus() {
		
		wait.until(ExpectedConditions.elementToBeClickable(updateStatusLink)).click();
		
	}
	
	public void clickPreviewBenefitItem(){
		
		wait.until(ExpectedConditions.elementToBeClickable(PreviewBenefitItemLink)).click();
	}

	public void clickViewLetter() {
		wait.until(ExpectedConditions.elementToBeClickable(viewLetterLink)).click();
		
	}

	public void clickGenerateLetter() {
		
		wait.until(ExpectedConditions.elementToBeClickable(GenerateLetterLink)).click();
		
	}

	public void gotoGeneratLetterbtn() {
		
		js.executeScript("window.scrollBy(0,1000)");
		
	}

	public void clickGenerateLetterbtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(GenerateLetterbtnLink)).click();
		
	}
	
	// =============================== For APS GENERATION =================================

	public void clickApsGeneration() {
		
		wait.until(ExpectedConditions.elementToBeClickable(apsGenerationbtnLink)).click();
		
	}

	public void clickAddnew() {
		
		wait.until(ExpectedConditions.elementToBeClickable(addNewbtnLink)).click();
		
	}

	public void enterDoctorName(String doctorName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtdoctorName)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdoctorName)).sendKeys(doctorName);
		
	}

	public void selectDoctorName(String row) {
		int currentRow = Integer.parseInt(row);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessOverviewRead.getCashlessOverviewAPS(currentRow, "Doctor/Hospital/Clinic")+"')]"))).click();
	}

	public void clickGoaps() {
		
		wait.until(ExpectedConditions.elementToBeClickable(goapsLink)).click();
		
	}

	public void enterTitle(String title) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtTitle)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtTitle)).sendKeys(title);
		
	}

	public void enterPayee(String payee) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtpayee)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtpayee)).sendKeys(payee);
		
	}

	public void enterAttentionName(String attentionName) {

		wait.until(ExpectedConditions.elementToBeClickable(txtattentionName)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtattentionName)).sendKeys(attentionName);
		
	}

	public void enterAddress1(String address1) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress1)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress1)).sendKeys(address1);
		
	}

	public void enterAddress2(String address2) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress2)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress2)).sendKeys(address2);
		
	}

	public void enterAddress3(String address3) {

		wait.until(ExpectedConditions.elementToBeClickable(txtaddress3)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress3)).sendKeys(address3);
		
	}

	public void enterAddress4(String address4) {

		wait.until(ExpectedConditions.elementToBeClickable(txtaddress4)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress4)).sendKeys(address4);
		
	}

	public void enterReminderPeriod(String reminderNoDays) {

		wait.until(ExpectedConditions.elementToBeClickable(txtreminderNoDays)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtreminderNoDays)).sendKeys(reminderNoDays);		
	}

	public void selectQuest1(String quest1) {
		
		Select selectquest1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementquest1)));
		selectquest1.selectByVisibleText(quest1);
		
	}

	public void selectQuest2(String quest2) {
		
		Select selectquest2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementquest2)));
		selectquest2.selectByVisibleText(quest2);
		
	}

	public void selectQuest3(String quest3) {

		Select selectquest3 = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementquest3)));
		selectquest3.selectByVisibleText(quest3);
		
	}

	public void selectQuest4(String quest4) {
		
		Select selectquest4 = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementquest4)));
		selectquest4.selectByVisibleText(quest4);
		
	}

	public void scrolldownToSave() {
		
		js.executeScript("window.scrollBy(0,1000)");
		
	}

	public void clikSave() {
		
		wait.until(ExpectedConditions.elementToBeClickable(savebtnLink)).click();
		
	}

	public void clikGenerateLetterAps() {
		
		wait.until(ExpectedConditions.elementToBeClickable(generateLetterapsLink)).click();
		
	}
	
	public void scrolldownToSave1() {
		
		js.executeScript("window.scrollBy(0,1000)");
		
	}

	public void clikGenerateLetterApsBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(generateLetterapsbtnLink)).click();
		
	}

	//  =================== FOR ASSESSMENT ENQUIRY POP UP CODE ===============================
	public void clickAssessmentenquiry() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AssessmentenquirybtnLink)).click();
		
	}

	public void enterClaimNuAssessment(String claimNumber) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtclaimNumberAssEnq)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtclaimNumberAssEnq)).sendKeys(claimNumber);	
		
	}

	public void clickGoAssessment() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AssquiryGobtnLink)).click();
		
	}

	public void clickCloseAssessmentPopup() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AssessEnqClosePopUpLink)).click();
		
	}
	
	// ======= CODE FOR PENDING NOTIFICATION =====

	public void clickPendingStatus() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(PendingStatusLink)).click();
		
	}
	
	public void clickRemarksSearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(RemarksSearchLink)).click();
		
	}

	public void enterRemarksCode(String remarksCode) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtremarksCode)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtremarksCode)).sendKeys(remarksCode);	
		
	}

	public void clickSearchPendingNoti() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchPendingNotiLink)).click();
		
	}

	public void clickGoPendinNoti() {
		
		wait.until(ExpectedConditions.elementToBeClickable(GoPendinNotiLink)).click();
		
	}

	public void clickSavePendingNoti() {
		
		wait.until(ExpectedConditions.elementToBeClickable(savePendingNotiLink)).click();
		
	}

	// PENDING NOTIFICATION FROM CLAIM VIEW =====================
	public void clickPendingNotification() {
		
		wait.until(ExpectedConditions.elementToBeClickable(claimViewPendingNotiLink)).click();
		
		
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
	
	//CODE FOR REASSIGN =======================

	public void clickReassign() {
		
		wait.until(ExpectedConditions.elementToBeClickable(reassignLink)).click();
		
	}

	public void enterAssigneUser(String assignUser) {
		
		wait.until(ExpectedConditions.elementToBeClickable(assignUserLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(assignUserLink)).sendKeys(assignUser);	
		
	}

	public void clickSearchAssign() {
	
		wait.until(ExpectedConditions.elementToBeClickable(searchAssignLink)).click();
		
	}

	public void clickSelectAssigned() {
		
		wait.until(ExpectedConditions.elementToBeClickable(selectAssignedLink)).click();
		
	}		
	
	// ======  CODE FOR REVERSE CLAIM PROCESS ============================
	
	public void selectFirstStatus(String firstStatus) {
		
		
		Select selectfirstStatus = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementfirstStatus)));
		selectfirstStatus.selectByVisibleText(firstStatus);
		
	}

	public void clickReverse() {
		
		wait.until(ExpectedConditions.elementToBeClickable(clickReverseLink)).click();
		
	}

	public void checkReverse() {
		
		wait.until(ExpectedConditions.elementToBeClickable(checkReverseLink)).click();
		
	}

	public void clickReverseBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ReverseBtnLink)).click();
		
	}

	public void selectStatusPending(String pendingStatus) {
		
		Select selStatusPending = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementpendingStatus)));
		selStatusPending.selectByVisibleText(pendingStatus);
		
	}	

	
	public void clickSearchAgain(){
		
		wait.until(ExpectedConditions.elementToBeClickable(clickSearchAgainLink)).click();
	}
	
	// ==== FOR CLAIM CALCULATION =========
	public String getClaimAmount() {
		
		String totalClaimAmt = totalClaim.getAttribute("value");
		return totalClaimAmt;
	}

	public String getTotalApprovedAmt() {
		
		String totalApprovAmt = totalApprovedAmt.getAttribute("value");
		return totalApprovAmt;
	}

	// Approved Claim List Search =========================
	
	public void selectStatusApproved(String StatusApproved) {
		
		Select selStatusApproved = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementStatusApproved)));
		selStatusApproved.selectByVisibleText(StatusApproved);		
		
	}

	public boolean verifyApprovedClaim(String claimNumber) {
		
		By verifyClaim = By.xpath("//td//span[contains(text(),'"+claimNumber+"')]");
		
		boolean chk = wait.until(ExpectedConditions.presenceOfElementLocated(verifyClaim)).isDisplayed();
		
		return chk;
		
	}
	

}