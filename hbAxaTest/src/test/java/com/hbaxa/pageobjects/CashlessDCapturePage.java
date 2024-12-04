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
import com.hbaxa.testdata.CashlessdcaptureData;
import com.hbaxa.utilities.AdditionalConditions;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class CashlessDCapturePage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	CashlessdcaptureData cashlessDCRead = new CashlessdcaptureData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public CashlessDCapturePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // previous it was 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 60); //previous 90
		js = (JavascriptExecutor)rdriver;
		
	}	
	
	
	// ======== ReimDataCapture Page Element Objects ======== 
	
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
	
	@FindBy(how=How.XPATH, using="//a[text()='Claims']")
	//@CacheLookup
	WebElement 	claimLink;
	
	//@FindBy(how=How.XPATH, using="//a[contains(.,'Cashless Claim')]")
	@FindBy(how=How.XPATH, using="//a[text()='Cashless Claim']")
	//@CacheLookup
	WebElement 	CashlessdcLink;
	
	//@FindBy(how=How.XPATH, using="(//a[contains(.,'Data Capture')])[1]")
	@FindBy(how=How.XPATH, using="(//a[text()='Data Capture'])[1]")
	//@CacheLookup
	WebElement 	DatacaptureLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'addManualClaimButton')]")
	@CacheLookup
	WebElement AddManualClaimLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'modifySearchButton')]")
	@CacheLookup
	WebElement ModifyBtnLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='PolicyNumber']")
	@CacheLookup
	WebElement txtPolicyNumb;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Pre-approval History')]")
	@CacheLookup
	WebElement PreApprovalHistoryLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'View more')]")
	@CacheLookup
	WebElement viewMoreLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='PAHistoryModal']//input[@placeholder='Search...']")
	@CacheLookup
	WebElement viewMoreSearchTextLink;
	
	@FindBy(how=How.XPATH, using="(//td[@class='axa-table-icon-btn PAProceedCashless']//a[@title='Proceed'])[2]")
	@CacheLookup
	WebElement PreApprovalProceedSingleLink;
	
	//@FindBy(how=How.XPATH, using="(//a[@title='Proceed'])[2]")
	@FindBy(how=How.XPATH, using="//div[@id='PAHistoryModal']//tr[1]//a[@class='pa-table-icon-btn PAProceedCashlessForGI']")
	@CacheLookup
	WebElement PreApprovalProceedLink;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Creation Form')]")
	@CacheLookup
	WebElement gotocreationform;
	
	@FindBy(how=How.XPATH, using="//input[@id='TreatmentLocation']")
	@CacheLookup
	WebElement txtTreatmentLoc;
	
	@FindBy(how=How.XPATH, using="//input[@id='ServiceDoctor']")
	@CacheLookup
	WebElement txtDoctorName;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'ui-id-67')]")
	@CacheLookup
	WebElement selectFirstDoctor;

	@FindBy(how=How.XPATH, using="//input[@id='DateofAdmission']")
	@CacheLookup
	WebElement txtDateOfAdmission;
	
	@FindBy(how=How.XPATH, using="//input[@id='AdmissionTime']")
	@CacheLookup
	WebElement txtAdmissionTime;
	
	@FindBy(how=How.XPATH, using="//input[@id='DateofDischarge']")
	@CacheLookup
	WebElement txtDateofdischarge;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'DischargeTime')]")
	@CacheLookup
	WebElement txtDischargeTime;
	
	@FindBy(how=How.XPATH, using="//input[@id='InsuredContactNo']")
	@CacheLookup
	WebElement txtcontatctNumber;

	@FindBy(how=How.XPATH, using="//input[@id='InsuredEmailId']")
	@CacheLookup
	WebElement txtemailAddress;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'SymptomDate')]")
	@CacheLookup
	WebElement txtSymptomdate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'ConsultationDate')]")
	@CacheLookup
	WebElement txtFirstConsultdate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Treatment_Date')]")
	@CacheLookup
	WebElement txtTreatmentmdate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Symptomcomplaint')]")
	@CacheLookup
	WebElement txtSymptom;
	
	@FindBy(how=How.ID, using="Currency")
	@CacheLookup
	WebElement elementBillCurrency;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'ICD Description')]")
	@CacheLookup
	WebElement gotoIcdDescrip;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Surgery Description')]")
	@CacheLookup
	WebElement gotosurgeryDescrip;
	
	@FindBy(how=How.XPATH, using="//input[@id='ICDCode']")
	//@CacheLookup
	WebElement txtIcdCode;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'ICDDetailBtn')]")
	//@CacheLookup
	WebElement ICDAddBtnLink;
	
	//======== SETTLEMENT METHOD ===========================
	@FindBy(how=How.XPATH, using="//span[contains(.,'Settlement Method')]")
	@CacheLookup
	WebElement gotoSettlementmethod;
	
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Settlement Type - Customer')]")
	//@CacheLookup
	WebElement elementSettlementCust;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Settlement Type - Provider')]")
	//@FindBy(how=How.XPATH, using="//div[contains(@id,'ServiceProvideInformationDivId') and contains(@style,'none') ]")
	//@CacheLookup
	WebElement elementSettlementProvider;

	@FindBy(how=How.XPATH, using="//select[@id='ddlSettlementType']")
	@CacheLookup
	WebElement elementSettlementCType;
	
	@FindBy(how=How.XPATH, using="//select[@id='sp_ddlSettlementType']")
	//@CacheLookup
	WebElement elementSettlementPType;	
	
	
	// === sm auto pay  - Cheque========
	
	//@FindBy(how=How.XPATH, using="//label[contains(@for,'ChequeMemberAddress')]")
	//@FindBy(how=How.ID, using="ChequeMemberAddress")
	@FindBy(how=How.XPATH, using="//label[@for='ChequeMemberAddress']")
	@CacheLookup
	WebElement MemberAddressLinkchq;
	
	////////////// for Non cross cheque
	@FindBy(how=How.XPATH, using="//label[@for='NonCrossChequeMemberAddress']")
    @CacheLookup
	WebElement noncrosscheque;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'ChequeNameofpayee')]") 
	@CacheLookup
	WebElement txtpayeeNamechq;
	
	// === sm auto pay ========
	
	@FindBy(how=How.XPATH, using="//input[@id='sp_AutopayBankNo']") 
	@CacheLookup
	WebElement txtbankNumberP;
	
	@FindBy(how=How.XPATH, using="//input[@id='AutopayBankNo']") 
	@CacheLookup
	WebElement txtbankNumberC;	
	
	@FindBy(how=How.XPATH, using="//input[@id='sp_AutopayBranchNo']")
	@CacheLookup
	WebElement txtbranchNumberP;
	
	@FindBy(how=How.XPATH, using="//input[@id='AutopayBranchNo']")
	@CacheLookup
	WebElement txtbranchNumberC;
	
	
	@FindBy(how=How.XPATH, using="//input[@name='sp_AutopayAccountNo']")
	@CacheLookup
	WebElement txtaccountNumberP;
	
	@FindBy(how=How.XPATH, using="//input[@id='AutopayAccountNo']")
	@CacheLookup
	WebElement txtaccountNumberC;	
	
	@FindBy(how=How.XPATH, using="//input[@id='sp_AutopayConfirmAccountNo']")
	@CacheLookup
	WebElement txtconfirmAccountNumberP;

	@FindBy(how=How.XPATH, using="//input[@name='AutopayConfirmAccountNo']")
	@CacheLookup
	WebElement txtconfirmAccountNumberC;
	
	@FindBy(how=How.XPATH, using="//input[@id='sp_AutopayNameOfPayee']") 
	@CacheLookup
	WebElement txtpayeeNameautoP;
	
	@FindBy(how=How.XPATH, using="//input[@id='AutopayNameOfPayee']") 
	@CacheLookup
	WebElement txtpayeeNameautoC;	
	
	//=========================================================================
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Display Bill')]")
	@CacheLookup
	WebElement gotoDisplayBill;
	
	@FindBy(how=How.XPATH, using="//input[contains(@value,'Input by bill item')]")
	@CacheLookup
	WebElement InputByBillItemLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='modelPopupOkIdBillItemCashless']")
	@CacheLookup
	WebElement oKinputbybillLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='ChargeDate']")
	@CacheLookup
	WebElement txtdbbill_chargedate;
	
	@FindBy(how=How.XPATH, using="//input[@id='BillItem']")
	@CacheLookup
	WebElement txtdbbill_billitem;
	
	@FindBy(how=How.XPATH, using="//input[@id='BillAmount']")
	@CacheLookup
	WebElement txtdbbill_billamount;
	
	@FindBy(how=How.XPATH, using="//select[@id='BenefitItem']")
	//@CacheLookup
	WebElement elementdbbill_benefitItem;	
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Add Bill')]")
	@CacheLookup
	WebElement addBtnbillitemLink;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'btnTwoCashless')]")
	@CacheLookup
	WebElement InputByBenefitItemLink;

	@FindBy(how=How.XPATH, using="//button[contains(@id,'modelPopupOkIdBenefitItmCashless')]")
	@CacheLookup
	WebElement oKinputbybenefitLink;
	
	//Input by Benefit Bill items ============================
	
	@FindBy(how=How.XPATH, using="//input[@id='BChargeDate']")
	//@CacheLookup
	WebElement txtchargeDate;	
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'TariffId')]")
	//@CacheLookup
	WebElement elementdbbenefit_benefititem;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'NoOfDays')]")
	//@CacheLookup
	WebElement txtdbbenefit_noClaimdays;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'NoOfPaidDays')]")
	//@CacheLookup
	WebElement txtdbbenefit_noPaiddays;	
	
	@FindBy(how=How.XPATH, using="//input[@id='BCommiteeAppAmt']")
	//@CacheLookup
	WebElement txtdbbenefit_BillItem;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'AddBenefitItemsBtn')]")
	//@CacheLookup
	WebElement inputbybenefiAddBilltLink;
	
	
	@FindBy(how=How.XPATH, using="//input[@value='Save']")
	@CacheLookup
	WebElement saveBtnLink;
	
	
	//==== ASSESSMENT ENQUIRY METHOD ===================
	
	
	@FindBy(how=How.XPATH, using="//a[@id='AssmntEnqId']")
	@CacheLookup
	WebElement assessmentEnquiryLink;
	
	@FindBy(how=How.XPATH, using="(//a[@href='#'][contains(.,'View')])[1]")
	@CacheLookup
	WebElement assessmentviewLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSearchId']")
	@CacheLookup
	WebElement gobtnassessmentview;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Add Assessment Page & Details')]")
	@CacheLookup
	WebElement goToAssmentPageDeta;
	
	@FindBy(how=How.XPATH, using="//select[@id='ReferenceNo']")
	@CacheLookup
	WebElement elementClaimNumber;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='Description']")
	@CacheLookup
	WebElement txtdescription;
	
	@FindBy(how=How.XPATH, using="//input[@id='btnSaveId']")
	@CacheLookup
	WebElement SaveAssmentLink;
	
	//@FindBy(how=How.XPATH, using="//a[@class='close_popup'][contains(text(),'x')]")
	@FindBy(how=How.XPATH, using="//a[@class='ClosePopUp'][contains(text(),'x')]")
	@CacheLookup
	WebElement closepopupLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='ShowHideDocument']")
	@CacheLookup
	WebElement ShowhidebtnLink;

	By txtClaimNumber = By.xpath("//input[@id='ClaimNumber']");
	
	//By claimNotification = By.xpath("//div[contains(@ng-class,'config.title')]");
	By claimNotification = By.xpath("(//span[@class='UserMsg'])[2]");
	
	By alertNotification = By.xpath("//span[@id='ErrorMsgText']");
	
	@FindBy(how=How.XPATH, using="//input[@id='btnAdjudicateId']")
	@CacheLookup
	WebElement autoAudjudicateBtnLink;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'btnConfirm')]")
	@CacheLookup
	WebElement confirmBtnLink;
	
	// ======== LOADER ========================

	//By loader = By.xpath("//div[contains(@ng-show,'loaderDiv == true') and contains(@aria-hidden,'false')]");
	
	//By loader = By.xpath("//div[contains(@id,'oaderDiv') and contains(@style,'block')]");
	
	By loader = By.xpath("//div[(contains(@id,'oaderDiv') or contains(@class,'ImageLoaderDiv')) and contains(@style,'block')]");

	// #loaderDiv
	
	// === SURGERY CODE ELEMENT ===================
	
	@FindBy(how=How.XPATH, using="//input[@id='SurgeryCode']")
	//@CacheLookup
	WebElement txtSurgeryCode;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'SurgeryAmount')]")
	//@CacheLookup
	WebElement txtSurgeryAmt;
	
	@FindBy(how=How.XPATH, using="//button[@id='SurgeryDetailBtn']")
	//@CacheLookup
	WebElement addSurgeryBtnLink;	
	
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

	public void clickClaim() {

		wait.until(ExpectedConditions.elementToBeClickable(claimLink)).click();
		
	}

	public void clickCashlessdc() {

		wait.until(ExpectedConditions.elementToBeClickable(CashlessdcLink)).click();
	}

	public void clickDataCapture() {

		wait.until(ExpectedConditions.elementToBeClickable(DatacaptureLink)).click();
		
	}

	public void clickAddManualClaim() {

		wait.until(ExpectedConditions.elementToBeClickable(AddManualClaimLink)).click();
		
	}

	public void clickModify() {

		wait.until(ExpectedConditions.elementToBeClickable(ModifyBtnLink)).click();
		
	}

	public void enterPolicyNo(String policynu) {

		wait.until(ExpectedConditions.elementToBeClickable(txtPolicyNumb)).sendKeys(policynu);
	}
	
	public void selectPolicy(String row) throws Exception{
		
		int currentRow = Integer.parseInt(row);
		By selElementPolicy = By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataCapture(currentRow, "PolicyDetails")+"')]");
		
		//By selElementPolicy = By.xpath("//li[@class='ui-menu-item'][contains(.,'HF120270 - 00001 - 02 ::  EIQF NQX ZXFU :: 1999/05/31 :: PM4-005- Top Plan')]");
		System.out.println(selElementPolicy.toString());
		//Thread.sleep(3000l);
		wait.until(ExpectedConditions.elementToBeClickable(selElementPolicy)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(selElementPolicy)).click();
		
	}
	
	// ==== Pre Approval Details
	public void clickPreApprovalHistory(){
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalHistoryLink)).click();
		
	}
	
	public void viewMore(){
		
		if(viewMoreLink.isDisplayed()){
		
		wait.until(ExpectedConditions.elementToBeClickable(viewMoreLink)).click();
		
		}
		
		else {
			
			System.out.println("View more button not visible");
		}
	}
	
	
	
	public void enterSearchText(String searchTxt){
		
		if(viewMoreLink.isDisplayed()){
		wait.until(ExpectedConditions.elementToBeClickable(viewMoreSearchTextLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(viewMoreSearchTextLink)).sendKeys(searchTxt);
		}else {
			System.out.println("Text field not displayed");
		}			
	}
	
	
	
	public void clickProceed(){
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalProceedLink)).click();
	}
	
	public void clickProceedOne(){
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalProceedSingleLink)).click();
	}
	
	public boolean checkview(){
		
		boolean viewbutton=viewMoreLink.isDisplayed();
		
		return viewbutton;
	}
	//===========================

	public void gotoCreationForm() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotocreationform);
		
	}

	public void enterTreatmentLoc(String treatmentloc) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtTreatmentLoc)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtTreatmentLoc)).sendKeys(treatmentloc);
		
	}

	public void selectTreatmentLoc(String row) {

		int currentRow = Integer.parseInt(row);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataCapture(currentRow, "CF Treatment Location")+"')]"))).click();
		
		
	}

	public void enterDoctorName(String DoctorName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtDoctorName)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtDoctorName)).sendKeys(DoctorName);
		
	}

	public void selectDoctorName(String row) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataCapture(currentRow, "CF select Doc Name")+"')]"))).click();

	}

	public void enterDateofAdmission(String dateOFAdmission) {

		wait.until(ExpectedConditions.elementToBeClickable(txtDateOfAdmission)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtDateOfAdmission)).sendKeys(dateOFAdmission);
		
	}

	public void enterAdmissionTime(String admissionTime) {

		wait.until(ExpectedConditions.elementToBeClickable(txtAdmissionTime)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtAdmissionTime)).sendKeys(admissionTime);		
		
	}

	public void enterDateofDischarge(String dateOFDischarge) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtDateofdischarge)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtDateofdischarge)).sendKeys(dateOFDischarge);	

	}

	public void enterDischargeTime(String dischargeTime) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtDischargeTime)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtDischargeTime)).sendKeys(dischargeTime);
		
	}

	public void enterContactNumber(String contatctNumber) {
	
		wait.until(ExpectedConditions.elementToBeClickable(txtcontatctNumber)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtcontatctNumber)).sendKeys(contatctNumber);
		
	}

	public void enterEmailAddress(String emailAddress) {

		wait.until(ExpectedConditions.elementToBeClickable(txtemailAddress)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtemailAddress)).sendKeys(emailAddress);		
	}
	
	public void enterSymptomdate(String Symptomdate) {

		wait.until(ExpectedConditions.elementToBeClickable(txtSymptomdate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSymptomdate)).sendKeys(Symptomdate);		
	}

	
	public void enterFirstConsultdate(String firstConsultdate) {

		wait.until(ExpectedConditions.elementToBeClickable(txtFirstConsultdate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtFirstConsultdate)).sendKeys(firstConsultdate);		
	}

	
	public void enterTreatmentmdate(String treatmentmdate) {

		wait.until(ExpectedConditions.elementToBeClickable(txtTreatmentmdate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtTreatmentmdate)).sendKeys(treatmentmdate);		
	}

	

	public void enterSymptom(String symptom) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtSymptom)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSymptom)).sendKeys(symptom);
		
	}

	public void selectBillCurrency(String billCurrency) {
		
		Select selectBillcurrency = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementBillCurrency)));
		selectBillcurrency.selectByVisibleText(billCurrency);
		
	}

	public void gotoIcdDescription() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoIcdDescrip);
	}
	
	public void gotoSurgeryDescription(){
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotosurgeryDescrip);
	}	

	public void enterICDCode(String icdCode) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtIcdCode)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtIcdCode)).sendKeys(icdCode);
		
	}

	public void selectICDCode(String row) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataCapture(currentRow, "Select ICD CODE")+"')]"))).click();
		
	}
	
	public void selectMultiICDCode(String row, int i) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataMultiICD(currentRow, "Select ICD CODE"+i)+"')]"))).click();
	}		
	
	public void clickICDAddBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ICDAddBtnLink)).click();
		
	}

	public void gotoDisplayBill() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoDisplayBill);
		
	}

	public void clickInputByBillItem() {
		
		wait.until(ExpectedConditions.elementToBeClickable(InputByBillItemLink)).click();
		
	}

	public void clickOnOkinputbybill() {
		
		wait.until(ExpectedConditions.elementToBeClickable(oKinputbybillLink)).click();
		
	}
	
	//=============================================================================
	
	public void enterChargeDate(String dbbill_chargedate){

		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_chargedate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_chargedate)).sendKeys(dbbill_chargedate);

		
	}
	
	public void enterBillItem(String dbbill_billitem) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_billitem)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_billitem)).sendKeys(dbbill_billitem);
		
	}

	public void selectBillItem(String row) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataCapture(currentRow, "DBBILL Bill Item")+"')]"))).click();
		
	}
	
	public void selectMultiBillItem(String row, int i) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getClessDataMultiBill(currentRow, "Bill Items"+i)+"')]"))).click();
		
		
	}	

	public void enterBillitemAmount(String dbbill_billamount) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_billamount)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_billamount)).sendKeys(dbbill_billamount);
		
	}
	
	public void selectdbBillBenefitItem(String dbbill_benefitItem){
		
		Select selectdbbill_benefitItem = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementdbbill_benefitItem)));
		selectdbbill_benefitItem.selectByVisibleText(dbbill_benefitItem);
		
	}	

	public void clickAddbyitembill() {
		
		wait.until(ExpectedConditions.elementToBeClickable(addBtnbillitemLink)).click();
		
	}
	//=============================================================================	

	public void clickInputByBenefitItem() {
		
		wait.until(ExpectedConditions.elementToBeClickable(InputByBenefitItemLink)).click();
		
	}

	public void clickOnOkinputbybenefit() {
	
		wait.until(ExpectedConditions.elementToBeClickable(oKinputbybenefitLink)).click();
		
	}
	
	public void enterchargeDate(String chargeDate){
		
		wait.until(ExpectedConditions.elementToBeClickable(txtchargeDate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtchargeDate)).sendKeys(chargeDate);
		wait.until(ExpectedConditions.elementToBeClickable(txtchargeDate)).sendKeys(Keys.TAB);
	}	

	public void selectBenfitItem(String dbbenefit_benefititem) {
		
		Select selectdbbenefit_benefititem = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementdbbenefit_benefititem)));
		selectdbbenefit_benefititem.selectByVisibleText(dbbenefit_benefititem);
		
	}

	public void enterClaimdays(String dbbenefit_noClaimdays) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbenefit_noClaimdays)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbenefit_noClaimdays)).sendKeys(dbbenefit_noClaimdays);
		
	}

	public void enterPaiddays(String dbbenefit_noPaiddays) {

		wait.until(ExpectedConditions.elementToBeClickable(txtdbbenefit_noPaiddays)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbenefit_noPaiddays)).sendKeys(dbbenefit_noPaiddays);
	}

	public void enterBillAmount(String dbbenefit_BillItem) {

		wait.until(ExpectedConditions.elementToBeClickable(txtdbbenefit_BillItem)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbenefit_BillItem)).sendKeys(dbbenefit_BillItem);
		
	}

	public void clickAddBill() {

		wait.until(ExpectedConditions.elementToBeClickable(inputbybenefiAddBilltLink)).click();
		
	}

	public void clickSave() {

		wait.until(ExpectedConditions.elementToBeClickable(saveBtnLink)).click();
		
	}

	public String getClaimNotification() {
		
		String ClaimNoti = wait.until(ExpectedConditions.visibilityOfElementLocated(claimNotification)).getText();
		return ClaimNoti;
	}

	public String getAlertNotification1() {
		
		String alertNoti = wait.until(ExpectedConditions.visibilityOfElementLocated(alertNotification)).getText();
		return alertNoti;
	}	
	
	public void clickAutoAudjudicate() {
		
		wait.until(ExpectedConditions.elementToBeClickable(autoAudjudicateBtnLink)).click();
		
	}

	public void clickConfirm() {

		wait.until(ExpectedConditions.elementToBeClickable(confirmBtnLink)).click();
		
	}

	public void clickProfile() {
		
		wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
		
	}

	public void clickLogOut() {
		
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
		
	}

	public void gotoSettlementMethod() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoSettlementmethod);
		
	}

	public void selectSettelementType(String settlmentType) {
		
		if(elementSettlementProvider.isDisplayed()){
			
			Select selectSettlementType = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementSettlementPType)));
			selectSettlementType.selectByVisibleText(settlmentType);
			
		}else{

			Select selectSettlementType = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementSettlementCType)));
			selectSettlementType.selectByVisibleText(settlmentType);		
			
		}
	}

	public void clickMemberAddress() {

		//wait.until(ExpectedConditions.elementToBeClickable(MemberAddressLink)).click();
		if(MemberAddressLinkchq.isEnabled())
		{
			//MemberAddressLinkchq.click();
			System.out.println("Member Address Chq Already Enabled");
		}else
		{
			MemberAddressLinkchq.click();
		}
	}
	public void clicknoncrossMemberAddress() {

		//wait.until(ExpectedConditions.elementToBeClickable(MemberAddressLink)).click();
		if(noncrosscheque.isEnabled())
		{
			//MemberAddressLinkchq.click();
			System.out.println("Member Address Chq Already Enabled");
		}else
		{
			noncrosscheque.click();
		}
	}
	
	
	
	public void enterPayeeNameCheck(String payeeName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtpayeeNamechq)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtpayeeNamechq)).sendKeys(payeeName);
		
	}
	
	//=======SM AUTO PAY ===
	
	public void enterBankNumber(String bankNumber) {

		if(elementSettlementProvider.isDisplayed()){
			wait.until(ExpectedConditions.elementToBeClickable(txtbankNumberP)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtbankNumberP)).sendKeys(bankNumber);
		}else{
			wait.until(ExpectedConditions.elementToBeClickable(txtbankNumberC)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtbankNumberC)).sendKeys(bankNumber);
		}

		
	}

	public void enterBranchNumber(String branchNumber) {
		
		if(elementSettlementProvider.isDisplayed()){
			wait.until(ExpectedConditions.elementToBeClickable(txtbranchNumberP)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtbranchNumberP)).sendKeys(branchNumber);			
		}else{
			wait.until(ExpectedConditions.elementToBeClickable(txtbranchNumberC)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtbranchNumberC)).sendKeys(branchNumber);
		}

		
	}

	public void enterAccountNumber(String accountNumber) {

		if(elementSettlementProvider.isDisplayed()){
			
			wait.until(ExpectedConditions.elementToBeClickable(txtaccountNumberP)).clear();
			System.out.println("first ");
		
			wait.until(ExpectedConditions.elementToBeClickable(txtaccountNumberP)).sendKeys(accountNumber);
			
		}else{
			System.out.println("second block ");
			wait.until(ExpectedConditions.elementToBeClickable(txtaccountNumberC)).clear();
			
			wait.until(ExpectedConditions.elementToBeClickable(txtaccountNumberC)).sendKeys(accountNumber);
			
		}
		
	}

	public void enterConfirmAccountNumber(String confirmAccountNumber) {

		if(elementSettlementProvider.isDisplayed()){
			wait.until(ExpectedConditions.elementToBeClickable(txtconfirmAccountNumberP)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtconfirmAccountNumberP)).sendKeys(confirmAccountNumber);			
		}else{
			wait.until(ExpectedConditions.elementToBeClickable(txtconfirmAccountNumberC)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtconfirmAccountNumberC)).sendKeys(confirmAccountNumber);			
		}

	}	
	
	public void enterPayeeNameAuto(String payeeName) {
		
		if(elementSettlementProvider.isDisplayed()){
			wait.until(ExpectedConditions.elementToBeClickable(txtpayeeNameautoP)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtpayeeNameautoP)).sendKeys(payeeName);			
		}else{
			wait.until(ExpectedConditions.elementToBeClickable(txtpayeeNameautoC)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(txtpayeeNameautoC)).sendKeys(payeeName);			
		}
	}	


	// =============== ASSESSMENT ENQUIRE CODE ===================================
	public void clickAssessmentEnquiry() {
		
		wait.until(ExpectedConditions.elementToBeClickable(assessmentEnquiryLink)).click();
		
	}

	public void clickView() throws InterruptedException {
		
		if(assessmentviewLink.isDisplayed()){
			
			wait.until(ExpectedConditions.elementToBeClickable(assessmentviewLink)).click();
			
		}else{
			
			wait.until(ExpectedConditions.elementToBeClickable(gobtnassessmentview)).click();
			
			Thread.sleep(10000l);
			wait.until(ExpectedConditions.elementToBeClickable(assessmentviewLink)).click();
		}
		
		//wait.until(ExpectedConditions.elementToBeClickable(assessmentviewLink)).click();
		
	}

	public void goToAssmentPageDetails() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", goToAssmentPageDeta);
		
	}

	public void selectClaimNumber(String claimNumber) {
		
		
		Select selectClaimNumber = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementClaimNumber)));
		selectClaimNumber.selectByVisibleText(claimNumber);
		
	}

	public void enterDescription(String description) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtdescription)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdescription)).sendKeys(description);
		
	}

	public void clickSaveAssment() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(SaveAssmentLink)).click();
		
	}

	public void closepopup() {
		
		wait.until(ExpectedConditions.elementToBeClickable(closepopupLink)).click();
		
	}

	public void clickShowhidebtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ShowhidebtnLink)).click();
		
	}

	public String getClaimNumber() {
		
		
		String claimNum = wait.until(ExpectedConditions.visibilityOfElementLocated(txtClaimNumber)).getAttribute("value");
		return claimNum;
		
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


	//  ========= SURGERY DESCRIPTION CODE ====================
	
	public void enterSurgeryCode(String surgeryCode) {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(txtSurgeryCode)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSurgeryCode)).sendKeys(surgeryCode);
		
	}

	public void selectSurgeryCode(String row) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataCapture(currentRow, "SD Code")+"')]"))).click();

	}
	
	public void selectMultiSurgeryCode(String row, int i) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+cashlessDCRead.getCashlessDataMultiSurgeryCode(currentRow, "SD Code"+i)+"')]"))).click();
		
	}	

	public void enterSurgeryAmt(String surgeryAmt) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtSurgeryAmt)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSurgeryAmt)).sendKeys(surgeryAmt);
		
	}

	public void clickaddSurgeryBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(addSurgeryBtnLink)).click();
		
	}

	// TABLE VERIFICATION CODE =======================================

	@FindBy(how=How.XPATH, using="//table[@id='ICDCodeDetailTable']")
	//@CacheLookup
	WebElement chkiCDtable;
	
	public boolean validateICDTable(){
		
		boolean chkICDTable = chkiCDtable.isDisplayed();
		return chkICDTable;
		
	}
	
	@FindBy(how=How.XPATH, using="//table[@id='SurgeryDetailTable']")
	//@CacheLookup
	WebElement chksurgertable;
	
	public boolean validateSurgeryTable(){
		
		boolean chkSurgeryTable = chksurgertable.isDisplayed();
		return chkSurgeryTable;
		
	}
	
	@FindBy(how=How.XPATH, using="//table[@id='DisplayBillDetailTable']")
	//@CacheLookup
	WebElement chkBilltable;	
	
	public boolean validateBillTable(){
		
		boolean chkBillTable = chkBilltable.isDisplayed();
		return chkBillTable;		
		
	}

	// TODO cashless Code for dataCapture claim search....
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'ClaimNo')]")
	WebElement claimSearhtxtLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Search')]")
	WebElement SearhbtnLink;
	
	@FindBy(how=How.XPATH, using="//a[@title='Proceed']")
	WebElement dcProceedLink;	
	
	public void enterClaimtoSearch(String claimNumber) {

		wait.until(ExpectedConditions.elementToBeClickable(claimSearhtxtLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(claimSearhtxtLink)).sendKeys(claimNumber);		
	}

	public void clickdcSearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(SearhbtnLink)).click();
		
	}

	public boolean verifyClaim(String claimNumber) {

		By verifyClaim = By.xpath("(//td[contains(.,'"+claimNumber+"')])[2]");
		boolean chk = wait.until(ExpectedConditions.presenceOfElementLocated(verifyClaim)).isDisplayed();
		return chk;
		
	}

	public void clickdcProceed() {

		wait.until(ExpectedConditions.elementToBeClickable(dcProceedLink)).click();
		
	}
	

	
	
	
}
