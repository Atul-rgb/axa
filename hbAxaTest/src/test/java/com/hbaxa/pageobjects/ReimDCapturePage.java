package com.hbaxa.pageobjects;

import java.util.ArrayList;
import java.util.List;
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

import com.hbaxa.testdata.ReimdcaptureData;
import com.hbaxa.utilities.AdditionalConditions;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class ReimDCapturePage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	ReimdcaptureData reimDCRead = new ReimdcaptureData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	Select select;
	
	public ReimDCapturePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // previous was 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 60); // previous it was 90
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
	
	//@FindBy(how=How.XPATH, using="//a[contains(.,'Claims')]") -- previous used
	@FindBy(how=How.XPATH, using="//a[text()='Claims']")
	//@CacheLookup
	WebElement 	claimLink;
	
	//@FindBy(how=How.XPATH, using="(//a[contains(.,'Reimbursement')])[1]")
	@FindBy(how=How.LINK_TEXT, using="Reimbursement")
	//@CacheLookup
	WebElement 	ReimbursmentLink;
	
	//@FindBy(how=How.XPATH, using="(//a[contains(.,'Data Capture')])[2]")
	@FindBy(how=How.XPATH, using="(//a[text()='Data Capture'])[2]")
	//@CacheLookup
	WebElement 	DatacaptureLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'addManualClaimButton')]")
	@CacheLookup
	WebElement AddManualClaimLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'modifySearchButton')]")
	@CacheLookup
	WebElement ModifyBtnLink;
	
	@FindBy(how=How.XPATH, using="//li[contains(.,'Search from RLS')]")
	@CacheLookup
	WebElement SearchFromRLSLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='PolicyNumber']")
	@CacheLookup
	WebElement txtPolicyNumb;
	
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
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'Symptomcomplaint')]")
	@CacheLookup
	WebElement txtSymptom;
	
	@FindBy(how=How.ID, using="Currency")
	@CacheLookup
	WebElement elementBillCurrency;
	
	@FindBy(how=How.ID, using="DateOfDoc")
	@CacheLookup
	WebElement txtSubmissionLink;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'ICD Description')]")
	@CacheLookup
	WebElement gotoIcdDescrip;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Surgery Description')]")
	@CacheLookup
	WebElement gotosurgeryDescrip;
	
	@FindBy(how=How.XPATH, using="//input[@id='ICDCode']")
	//@CacheLookup
	WebElement txtIcdCode;
	
	@FindBy(how=How.XPATH, using="//label[contains(@for,'UnPreExisting')]")
	WebElement unknowPreExistingLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'ICDDetailBtn')]")
	//@CacheLookup
	WebElement ICDAddBtnLink;
	
	//======== SETTLEMENT METHOD ===========================
	@FindBy(how=How.XPATH, using="//span[contains(.,'Settlement Method')]")
	@CacheLookup
	WebElement gotoSettlementmethod;

	@FindBy(how=How.XPATH, using="//select[contains(@id,'ddlSettlementType')]")
	@CacheLookup
	WebElement elementSettlementType;
	
	@FindBy(how=How.XPATH, using="//input[@name='AutopayBankNo']")
	@CacheLookup
	WebElement bankno;
	
	@FindBy(how=How.XPATH,using="//input[@name='AutopayBranchNo']")
	@CacheLookup
	WebElement branchno;
	
	@FindBy(how=How.XPATH, using="//input[@id='AutopayAccountNo']")
	@CacheLookup
	WebElement accountno;
	
	@FindBy(how=How.XPATH,using="//input[@id='AutopayConfirmAccountNo']")
	@CacheLookup
	WebElement confirmaccount;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTPaymentMethod']")
	@CacheLookup
	WebElement paymentmethodtext;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTDebitAccountNo']")
	@CacheLookup
	WebElement debitacoountno;
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTDebitAccountCountryCode']")
	@CacheLookup
	WebElement debitaccounttype;
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTForeignExchangeRate']")
     @CacheLookup
     WebElement exchangerate;
	
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTChargesIndicator']")
    @CacheLookup
	WebElement chanrgeindicator; 	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTTransactionReferenceNumber']")
	@CacheLookup
	WebElement trn;
	
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTBeneficiaryIS']")
	@CacheLookup
	WebElement beneficiaryIS;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryName']")
	@CacheLookup
	WebElement Bname;
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTBeneficiaryAccountNumber']")
	@CacheLookup
	WebElement beneficiaryaccount;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryBankRoutingMethod']")
	@CacheLookup
	WebElement BankRoutingMethod;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryBankRoutingCode']")
	@CacheLookup
	WebElement BeneficiaryBankRoutingCode;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryBankName']")
	@CacheLookup
	WebElement BeneficiaryBankName;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryBankAddress1']")
	@CacheLookup
	WebElement BeneficiaryBankAddress1;
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryBankAddress2']")
	@CacheLookup
	WebElement BankAddress2;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTBeneficiaryBankAddress3']")
	@CacheLookup
	WebElement BankAddress3;
	
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTIntermediaryBankSWIFTCode']")
	@CacheLookup
	WebElement SWIFTCode;
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTIntermediaryBankSortCode']")
	@CacheLookup
	WebElement BankSortCode;
	
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTIntermediaryBankName']")
	@CacheLookup
	WebElement IntermediaryBankName;
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTIntermediaryBankAddress1']")
	@CacheLookup
	WebElement IntermediaryBankAddress1;
	@FindBy(how=How.XPATH, using="//input[@id='OverseasTTIntermediaryBankAddress2']")
	@CacheLookup
	WebElement IntermediaryBankAddress2;
	@FindBy(how=How.XPATH,using="//input[@id='OverseasTTIntermediaryBankAddress3']")
	@CacheLookup
	WebElement IntermediaryBankAddress3;
	
	
	@FindBy(how=How.XPATH, using="//label[contains(@for,'ChequeMemberAddress')]")
	@CacheLookup
	WebElement MemberAddressLink;
	
	@FindBy(how=How.XPATH, using="(//label[contains(@for,'ChequeMemberAddress')])[2]")
	@CacheLookup
	WebElement NONcrossmember;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Display Bill')]")
	@CacheLookup
	WebElement gotoDisplayBill;
	
	@FindBy(how=How.XPATH, using="//input[contains(@value,'Input by bill item')]")
	@CacheLookup
	WebElement InputByBillItemLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='modelPopupOkIdBillItemCashless']")
	@CacheLookup
	WebElement oKinputbybillLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='BillItem']")
	@CacheLookup
	WebElement txtdbbill_billitem;
	
	@FindBy(how=How.XPATH, using="//input[@id='BillAmount']")
	@CacheLookup
	WebElement txtdbbill_billamount;
	
	@FindBy(how=How.XPATH, using="//select[@id='BenefitItem']")
	@CacheLookup
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
	
	@FindBy(how=How.XPATH, using="//input[@id='ChargeDate']")
	//@CacheLookup
	WebElement txtbillchargeDate;
	
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
	
	//@FindBy(how=How.XPATH, using="//input[@value='Save']")
	@FindBy(how=How.XPATH, using="//input[@id='btnSaveClaimId']")
	//@CacheLookup
	WebElement saveBtnLink;
	
	//==== OTHER INSURANCE ============================
	@FindBy(how=How.XPATH, using="(//span[contains(.,'Other Insurance/Co Insurance')])[1]")
	WebElement gotoOtherInsurance;
	
	@FindBy(how=How.XPATH, using="//input[@id='ClaimCoInsuranceDetails_0__SmmAmt']")
	WebElement SMMamtLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='ApplyCoInsBtn']")
	WebElement applyOtherinsurance;
	
	
	//==== ASSESSMENT ENQUIRY METHOD ===================
	
	@FindBy(how=How.XPATH, using="//a[@id='AssmntEnqId']")
	@CacheLookup
	WebElement assessmentEnquiryLink;
	
	/*@FindBy(how=How.XPATH, using="(//a[@href='#'][contains(.,'View')])[1]")
	@CacheLookup
	WebElement assessmentviewLink;*/
	
	////new implimented for view link assessment-Dishant
	
	@FindBy(how=How.XPATH, using="(//div[@id='divAssessmentList']//td[6] //a[contains(text(),'View')])[1]")
	
	@CacheLookup
	WebElement assessmentviewLink;
	
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
	
	//By claimNotification = By.xpath("//div[contains(@ng-class,'config.title')]");
	By claimNotification = By.xpath("(//span[@class='UserMsg'])[2]");
	
	@FindBy(how=How.XPATH, using="//input[@id='btnAdjudicateId']")
	@CacheLookup
	WebElement autoAudjudicateBtnLink;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'btnConfirm')]")
	@CacheLookup
	WebElement confirmBtnLink;
	
	@FindBy(how=How.XPATH, using="//button[@name='btnGo']")
	@CacheLookup
	
	WebElement Gobutton;
	
	// ======== LOADER ========================

	//By loader = By.xpath("//div[contains(@ng-show,'loaderDiv == true') and contains(@aria-hidden,'false')]");
	
	By loader = By.xpath("//div[contains(@id,'loaderDiv') and contains(@style,'block')]");
	//By loader = By.xpath("//div[contains(@id,'loaderDiv') and contains(@style,'block')]");

	// #loaderDiv	
	
	
	// === SURGERY CODE ELEMENT ===================
	
	@FindBy(how=How.XPATH, using="//input[@id='SurgeryCode']")
	//@CacheLookup
	WebElement txtSurgeryCode;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'SurgeryAmount')]")
	//@CacheLookup
	WebElement txtSurgeryAmt;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'ddlIncision')]")
	WebElement elementIncision;
	
	@FindBy(how=How.XPATH, using="//button[@id='SurgeryDetailBtn']")
	//@CacheLookup
	WebElement addSurgeryBtnLink;
	
	// TODO======== Link/ D-link Element ==========
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Link/ D-Link Disability')]")
	//@CacheLookup
	WebElement gotoLinkDlink;
	
	@FindBy(how=How.XPATH, using="//input[@id='AutopayNameOfPayee']")
	//@CacheLookup
	WebElement name_of_payee;
	@FindBy(how=How.XPATH, using="//label[@for='ChequeMemberAddress']")
	//@CacheLookup
	WebElement check_box_memberaddress;
	@FindBy(how=How.XPATH, using="//select[@id='ddlSettlementType']")
	//@CacheLookup
	WebElement settlmentType;
	public void select_settlmentType_Dropdown(String data) {
		select =new Select(settlmentType);
		select.selectByVisibleText(data);
	}
	public void clickcheck_box_memberaddresst2()
	{
		wait.until(ExpectedConditions.elementToBeClickable(check_box_memberaddress)).click();
	}
	
	public void clickcheck_box_memberaddresst()
	{
		wait.until(ExpectedConditions.elementToBeClickable(check_box_memberaddress)).click();
	}

	
	// ======== Methods For WebElement ========  
	public void enter_name_of_payee(String uname)
	{
		name_of_payee.sendKeys(uname);
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

	public void clickReimbursment() {

		wait.until(ExpectedConditions.elementToBeClickable(ReimbursmentLink)).click();
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
	
	public void selectfreshPolicy(){
		
		wait.until(ExpectedConditions.elementToBeClickable(txtPolicyNumb)).sendKeys(Keys.ENTER);
	}
	
	public void selectPolicy(String row){
		
		int currentRow = Integer.parseInt(row);
		System.out.println(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "PolicyDetails")+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "PolicyDetails")+"')]"))).click();
		//li[contains(.,'HF120270 - 00001 - 02 ::  EIQF NQX ZXFU')]
	}
	
	
	// ====== SEARCH FROM RLS CODE =====
	
	public void selectSearchfromRls(){
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchFromRLSLink)).click();
	}
	
	// =================================

	public void gotoCreationForm() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotocreationform);
		
	}

	public void enterTreatmentLoc(String treatmentloc) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtTreatmentLoc)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtTreatmentLoc)).sendKeys(treatmentloc);
		
	}

	public void selectTreatmentLoc(String row) {

		int currentRow = Integer.parseInt(row);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "CF Treatment Location")+"')]"))).click();
		
		
	}

	public void enterDoctorName(String DoctorName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtDoctorName)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtDoctorName)).sendKeys(DoctorName);
		
	}

	public void selectDoctorName(String row) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "CF select Doc Name")+"')]"))).click();

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

	public void enterSymptom(String symptom) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtSymptom)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSymptom)).sendKeys(symptom);
		
	}

	public void selectBillCurrency(String billCurrency) {
		
		Select selectBillcurrency = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementBillCurrency)));
		selectBillcurrency.selectByVisibleText(billCurrency);
		
	}
	
	public void enterSubmissionDate(String submissionDate){

		wait.until(ExpectedConditions.elementToBeClickable(txtSubmissionLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSubmissionLink)).sendKeys(submissionDate);

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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "Select ICD CODE")+"')]"))).click();
		
	}
	
	public void clickUnknownPreExisting(){
		
		wait.until(ExpectedConditions.elementToBeClickable(unknowPreExistingLink)).click();
	}
	
	public void selectMultiICDCode(String row, int i) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataMultiICD(currentRow, "Select ICD CODE"+i)+"')]"))).click();

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
	
	public void enterBillItem(String dbbill_billitem) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_billitem)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtdbbill_billitem)).sendKeys(dbbill_billitem);
		
	}

	public void selectBillItem(String row) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "DBBILL Bill Item")+"')]"))).click();
		
	}
	
	public void selectMultiBillItem(String row, int i) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataMultiBill(currentRow, "Bill Items"+i)+"')]"))).click();
		
		
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
	
	public void enterbillchargeDate(String billchargeDate){
		
		wait.until(ExpectedConditions.elementToBeClickable(txtbillchargeDate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtbillchargeDate)).sendKeys(billchargeDate);
		wait.until(ExpectedConditions.elementToBeClickable(txtbillchargeDate)).sendKeys(Keys.TAB);
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
		
		String claimNUmber = wait.until(ExpectedConditions.visibilityOfElementLocated(claimNotification)).getText();
		return claimNUmber;
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
		
		Select selectSettlementType = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementSettlementType)));
		selectSettlementType.selectByVisibleText(settlmentType);		
		
	}
	
	public void bankno(String Bankno){
		
		bankno.sendKeys(Bankno);
	}
	
	public void branchno(String branch){
		
		branchno.sendKeys(branch);
	}
	
	public void accountno(String Autoaccountno){
		
		accountno.sendKeys(Autoaccountno);
	}
	
	public void confirmaccount(String Autoconfirmaccount){
		
		confirmaccount.sendKeys(Autoconfirmaccount);
	}
	
	public void paymenttypetext(String Paymenttypemethod ){
		
		paymentmethodtext.sendKeys(Paymenttypemethod);
	}
	
	public void debitaccount(String debitaccount){
		
		debitacoountno.sendKeys(debitaccount);
	}
	
	public void debitcountrycode(String debittypeaccount){
		
		debitaccounttype.sendKeys(debittypeaccount);
	}
	public void forienexchange(String rateechangeforiegn){
		exchangerate.sendKeys(rateechangeforiegn);
		}
	public void chanrgesind (String indicatorcharges){
		
		chanrgeindicator.sendKeys(indicatorcharges);
	}
    public void trnnumber(String referenceno){
    	
    	trn.sendKeys(referenceno);
    }
    
    public void ISbeneficiary(String ISbene){
    	beneficiaryIS.sendKeys(ISbene);
    }
	public void beneficiaryname(String beneficiary){
		
		Bname.sendKeys(beneficiary);
	}
	
	public void benefiryaccount(String bnaccount){
		
		beneficiaryaccount.sendKeys(bnaccount);
	}
	public void routingtype(String routing){
		
		BankRoutingMethod.sendKeys(routing);
	}
	
	public void Bankroutingcode(String swift){
		
		BeneficiaryBankRoutingCode.sendKeys(swift);
	}
	
	public void bankname(String bankname){
		
		BeneficiaryBankName.sendKeys(bankname);
	}
	
	public void bankaddress1(String address1){
		
		BeneficiaryBankAddress1.sendKeys(address1);
	}
	
	
	public void bankaddress2(String address2){
		
		BankAddress2.sendKeys(address2);
	}
	
	public void bankaddress3(String address3){
		
		BankAddress3.sendKeys(address3);
	}
	
	public void swiftcode(String beneficairyswiftcode){
		
		SWIFTCode.sendKeys(beneficairyswiftcode);
	}
	
	
	public void intermidiatesortcode(String sortcode){
		
		BankSortCode.sendKeys(sortcode);
	}
	
	public void banknameI(String Banknameinter){
		
		IntermediaryBankName.sendKeys(Banknameinter);
	}
	
	public void addressI(String AddressI1){
		
		IntermediaryBankAddress1.sendKeys(AddressI1);
	}
	
	public void addressI2(String Iaddress2){
		
		IntermediaryBankAddress2.sendKeys(Iaddress2);
	}
	public void addressI3(String Iaddress3){
		
		IntermediaryBankAddress3.sendKeys(Iaddress3);
	}
	public void Nonbcrossmember(){
		wait.until(ExpectedConditions.elementToBeClickable(NONcrossmember)).click();
	}
	
	public void clickMemberAddress() {

		wait.until(ExpectedConditions.elementToBeClickable(MemberAddressLink)).click();
		
	}

	// =============== ASSESSMENT ENQUIRE CODE ===================================
	public void clickAssessmentEnquiry() {
		
		wait.until(ExpectedConditions.elementToBeClickable(assessmentEnquiryLink)).click();
		
	}

	public void clickView() {
		
		wait.until(ExpectedConditions.elementToBeClickable(assessmentviewLink)).click();
		
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

	
	public void ClickGobutton(){
		
		wait.until(ExpectedConditions.elementToBeClickable(Gobutton)).click();
		
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataCapture(currentRow, "SD Code")+"')]"))).click();
		
	}
	
	public void selectMultiSurgeryCode(String row, int i) {
		
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'"+reimDCRead.getReimDataMultiSurgeryCode(currentRow, "SD Code"+i)+"')]"))).click();
		
	}	

	public void enterSurgeryAmt(String surgeryAmt) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtSurgeryAmt)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtSurgeryAmt)).sendKeys(surgeryAmt);

	}
	
	public void selectIncision(String incision){
		//dfsd
		Select selIncision = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementIncision)));
		selIncision.selectByVisibleText(incision);
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

	// === For alert table
	public void acceptAlert() {
		
		wait.until(ExpectedConditions.alertIsPresent()).accept();

	}

	
	// OHTER INSURANCE CALUCLATION =============================================
	public void gotoOtherInsurance() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", gotoOtherInsurance);
		
	}

	public void enterOtherBillAmount(String billAmt, int i) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ClaimCoInsuranceDetails_"+i+"__OtherInsuranceAmt']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ClaimCoInsuranceDetails_"+i+"__OtherInsuranceAmt']"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ClaimCoInsuranceDetails_"+i+"__OtherInsuranceAmt']"))).sendKeys(billAmt);
		
	}

	public void clickApply() {
		
		wait.until(ExpectedConditions.elementToBeClickable(applyOtherinsurance)).click();
		
	}

	public void enterOtherSMMAmount(String sMMAmt) {

		wait.until(ExpectedConditions.elementToBeClickable(SMMamtLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(SMMamtLink)).sendKeys(sMMAmt);
	}
	
	// TODO===== ===== Element Functionality of Link/ D-link ===============
	
	public void gotoLinkDlink() {
		
		//js.executeScript("arguments[0].scrollIntoView(true);", gotoLinkDlink);
		js.executeScript("argument[0]scrollView(true);", gotoLinkDlink);
		
	}

	public void linkClaim(String claimData) {
		
		WebElement linkContainer = ldriver.findElement(By.xpath("//div[@id='DisabilityContainer']"));
	    //Thread.sleep(3000);
	    List<WebElement> allOptions= linkContainer.findElements(By.xpath("//label[contains(@for,'IsSameDisability_')]"));
	    for(WebElement selectLi: allOptions)
	    {
	        if(selectLi.getText().contains(claimData)) {
	            selectLi.click();
	        }
	    }	
		
	}

	// TODO Code for data capture claim search.
	
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

	// CODE FOR PA SELECTION FOR GI CALCULATION CASE ========================
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Pre-approval History')]")
	@CacheLookup
	WebElement PreApprovalHistoryLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'View more')]")
	@CacheLookup
	WebElement viewMoreLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='PAHistoryModal']//input[@placeholder='Search...']")
	@CacheLookup
	WebElement viewMoreSearchTextLink;
	
	@FindBy(how=How.XPATH, using="(//div[@id='PAHistoryModal']//span[@class='glyphicon glyphicon-send'])[1]")
	@CacheLookup
	WebElement PreApprovalProceedLink;
	
	@FindBy(how=How.XPATH, using="(//td[@class='axa-table-icon-btn PAProceedCashless']//a[@title='Proceed'])[1]")
	@CacheLookup
	WebElement PreApprovalProceedSingleLink;
	
	//========================================================================
	public void clickPreApprovalHistory() {
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalHistoryLink)).click();
		
	}

	public void viewMore() {
		
		wait.until(ExpectedConditions.elementToBeClickable(viewMoreLink)).click();
		
	}

	public void enterSearchText(String searchTxt) {
	
		wait.until(ExpectedConditions.elementToBeClickable(viewMoreSearchTextLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(viewMoreSearchTextLink)).sendKeys(searchTxt);
		
	}

	public void clickProceed() {
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalProceedLink)).click();
		
	}

	public void clickProceedOne() {
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalProceedSingleLink)).click();
		
	}
	
	// Code For Select Services 
	
	@FindBy(how=How.ID, using="ServicesId")
	@CacheLookup
	WebElement elementServices;

	public void selectServices(String services) {
		
		Select selectServices = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementServices)));
		selectServices.selectByVisibleText(services);
		
	}

	
	// Code For Select wardType 
	
		@FindBy(how=How.ID, using="WardType")
		@CacheLookup
		WebElement elementwardType;
	
	public void selectWardType(String wardType) {
		
		Select selectWardType = new Select(wait.until(ExpectedConditions.elementToBeClickable(elementwardType)));
		selectWardType.selectByVisibleText(wardType);
		
	}

	
	
	
}
