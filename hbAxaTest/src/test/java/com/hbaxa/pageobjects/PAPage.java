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

import com.hbaxa.testdata.PAData;
import com.hbaxa.utilities.AdditionalConditions;
import com.hbaxa.utilities.CommanCode;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class PAPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public PAPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(how=How.XPATH, using="//i[contains(@class,'fa fa fa-stethoscope')]")
	@CacheLookup
	WebElement navClaimmenu;
	
	//@FindBy(how=How.XPATH, using="//a[contains(.,'Pre-Approval')]")
	@FindBy(how=How.XPATH, using="//li[@class='active']//a[contains(text(),'Pre-Approval')]")
	@CacheLookup
	WebElement palink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Indexing')]")
	@CacheLookup
	WebElement indexinglink;	
	
	//@FindBy(xpath="//button[@ng-click='AddNewManualClaim()']")
	//@CacheLookup
	//WebElement btnaddManual;
	
	//================For Manual Process ===================================
	@CacheLookup
	//By btnaddManual = By.xpath("//button[@ng-click='AddNewManualClaim()']");
	By btnaddManual = By.xpath("//button[text()='Add Manual Pre-Approval']");
	@FindBy(how=How.XPATH, using="//button[text()='Add Manual Pre-Approval']")
	@CacheLookup
	WebElement btnaddManualnew;
	//================For DocID Process ===================================
	
	@FindBy(how=How.XPATH, using="//a[@id='advance_search']")
	@CacheLookup
	WebElement clickAdvaSearch;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Document ID']")
	@CacheLookup
	WebElement DocIdtxt;	
	
	@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Search')]")
	@CacheLookup
	WebElement clickSearch;	
	
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-share-square-o']")
	@CacheLookup
	WebElement clickProceed;
	
	@FindBy(how=How.XPATH, using="//label[@class='s3-readonly-title'][contains(.,'PreApproval No:')]")
	@CacheLookup
	WebElement movetopForPA;
	
	@FindBy(how=How.XPATH, using="(//div[contains(@class,'s3-readonly-group')])[1]")
	@CacheLookup
	WebElement paNumberTop;
	
	@FindBy(how=How.XPATH, using="//a[@id='OpenChopping']")
	@CacheLookup
	WebElement clickChopping;
	
	@FindBy(how=How.XPATH, using="//label[contains(.,'Page 1')]")
	@CacheLookup
	WebElement waitTillDoc;	
	
	@FindBy(how=How.ID, using="getpath1")
	@CacheLookup
	WebElement sourcegetpath1;	
	
	@FindBy(how=How.ID, using="getpath2")
	@CacheLookup
	WebElement sourcegetpath2;
	
	@FindBy(how=How.ID, using="getpath3")
	@CacheLookup
	WebElement sourcegetpath3;
	
	@FindBy(how=How.ID, using="getpath4")
	@CacheLookup
	WebElement sourcegetpath4;	
	
	@FindBy(how=How.ID, using="getpath5")
	@CacheLookup
	WebElement sourcegetpath5;

	@FindBy(how=How.XPATH, using="//span[contains(@onclick,'DeleteChop(1)')]")
	@CacheLookup
	WebElement DeleteOneChop;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'saveImageButton')]")
	@CacheLookup
	WebElement saveChopping;	
	
	//====================================================================
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'ShowHideDocument')]")
	@CacheLookup
	WebElement btnshowhide;
	//By btnshowhide = By.xpath("//button[@id='ShowHideDocument");
	
	@FindBy(how=How.ID, using="PolicyNo") //
	//@FindBy(how=How.ID, using="input-1")
	@CacheLookup
	WebElement searchPolicy;
	
	//===============================  OBJECT FOR MERGE ==========================================================
	
	@FindBy(how=How.XPATH, using="//a[@class='ng-binding'][contains(.,'Pre-approval History')]")
	@CacheLookup
	WebElement PreApprovalHistorylink;	
	
	@FindBy(how=How.XPATH, using="//a[contains(@data-target,'#ApprovalHistoryModal')]")
	@CacheLookup
	WebElement ViewMorelink;
	
	@FindBy(how=How.XPATH, using="//select[contains(@ng-model,'PreSearch.StatusNameH')]")
	@CacheLookup
	WebElement PreApprovalStatus;
	
	@FindBy(how=How.XPATH, using="//input[contains(@ng-model,'PreSearch.PreAppNo')]")
	@CacheLookup
	WebElement ClaimNumberPAH;

	//@FindBy(xpath="(//a[contains(.,'Merge')])[3]")
	
	@FindBy(how=How.XPATH, using="(//a[@ng-click='PreApprovalMergeAction(preApprovalHistory)'][contains(.,'Merge')])[3]")
	@CacheLookup
	WebElement Mergelink;
	
	//============================================================================================================
	
	//@FindBy(xpath="//span[@ng-show='item.LobId == 2'][contains(.,'HF120270 - 00001 - 02')]")
	@FindBy(how=How.XPATH, using="(//span[@class='item-metadata'])[1]")
	@CacheLookup
	WebElement selectSearchPolicy;
	
	//@CacheLookup
	//By selectSearchPolicy = By.xpath("//span[@ng-show='item.LobId == 2'][contains(.,'HF120270 - 00001 - 02')]");
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Pre-approval Details')]")
	//@CacheLookup
	WebElement scrollToPad;
	
	//By scrollToPad = By.xpath("//span[contains(.,'Pre-approval Details')]");
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'medicalCardTypes')]")
	//@CacheLookup
	WebElement medicalcardTypelink;
	
	@FindBy(how=How.XPATH, using="//input[@id='ServiceDoctor']")
	@CacheLookup
	WebElement inputDocName;
	
	@FindBy(how=How.XPATH, using="(//td[contains(@style,'width:15%')])[1]")
	@CacheLookup
	WebElement SelDocName;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'SymptomDate')]")
	@CacheLookup
	WebElement symptomDate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'ConsultationDate')]")
	@CacheLookup
	WebElement firstConsultationDate;
	
	@FindBy(how=How.XPATH, using="//input[@id='DateOfAdmission']")
	@CacheLookup
	WebElement admissionDate;
	
	@FindBy(how=How.XPATH, using="//input[@id='DateOfDischarge']")
	@CacheLookup
	WebElement dischargeDate;
	
	@FindBy(how=How.XPATH, using="//input[@id='TreatmentDate']")
	@CacheLookup
	WebElement treatmentDate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@name,'SymptomComplaint')]")
	@CacheLookup
	WebElement sympTomComplaint;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'ContactNoInsured')]")
	@CacheLookup
	WebElement contactNumber;
	
	@FindBy(how=How.XPATH, using="//select[@id='billCurrency']")
	@CacheLookup
	WebElement billCurrencylink;
	
	@FindBy(how=How.XPATH, using="(//span[contains(.,'Diagnosis')])[1]")
	@CacheLookup
	WebElement gotodiagView;
	
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'input-4')]") // previous
	@FindBy(how=How.XPATH, using="//input[contains(@id,'ICDCode')]")
	@CacheLookup
	WebElement icdCode;
	
	@FindBy(how=How.XPATH, using="//p[contains(text(),'R50.9')]")
	@CacheLookup
	WebElement selectIcdCode;
	@FindBy(how=How.XPATH, using="//p[contains(text(),'A01.0')]")
	@CacheLookup
	WebElement selectIcdCode_A01;
	@FindBy(how=How.XPATH, using="//p[text()='Typhoid and paratyphoid fevers '] ")
	@CacheLookup
	WebElement selectIcdCode_A01_ID;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'btnAddEditIcd')]")
	@CacheLookup
	WebElement btnAddEditIcd;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Doctor Fee')]")
	@CacheLookup
	WebElement gotodoctorfee;
	
	@FindBy(how=How.XPATH, using="//h4[contains(text(),'b) 12 Months Medical Condition')]")
	@CacheLookup
	WebElement enterdoctorfees;
	
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'input-5')]") //previous
	@FindBy(how=How.XPATH, using="//input[@id='BenefitItemDataList']")
	@CacheLookup
	WebElement dfbenefititem;
	
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'input-6')]")
	@FindBy(how=How.XPATH, using="//input[contains(@id,'input-7')]")
	@CacheLookup
	WebElement dfcptcode;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Post Surgery Home Nursing ')]")
	@CacheLookup
	WebElement selectdfbenefititem;
	
	@FindBy(how=How.XPATH, using="//input[@id='RequestedAmount']")
	@CacheLookup
	WebElement dfRequestAmount;
	
	@FindBy(how=How.XPATH, using="//input[@name='ApprovedAmount']")
	@CacheLookup
	WebElement dfapproveamountlink;
	
	@FindBy(how=How.XPATH, using="//label[@for='AnaesthesiologistFee']")
	@CacheLookup
	WebElement anesthesiologistfeeLink;
	
	@FindBy(how=How.XPATH, using="//button[@id='doctorFeeData']")
	@CacheLookup
	WebElement AddBenefitItems;

	//==============================================================
	
	//@FindBy(xpath="//label[@for='log']")
	//@FindBy(how=How.ID, using="log")
	@FindBy(how=How.XPATH, using="//label[@for='chkBoxLog']")
	@CacheLookup
	WebElement checkLog;
	
	@FindBy(how=How.XPATH, using="//label[@for='chkBoxLog']")
	@CacheLookup
	WebElement checkLog1;
	

	@FindBy(how=How.XPATH, using="//input[@id='logAmount']")
	@CacheLookup
	WebElement Logtxt;
	
	//===============================================================
	@FindBy(how=How.XPATH, using="//span[contains(.,'Hospital Charges')]")
	@CacheLookup
	WebElement gotohospitalcharges;
	
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'input-7')]")
	@FindBy(how=How.XPATH, using="//input[@id='BenefitItemListHospital']")
	@CacheLookup
	WebElement HCBenefitItem;
	
	@FindBy(how=How.XPATH, using="//ul[@id='ui-id-8']")
	@CacheLookup
	WebElement selHCBenFITem;
	
	@FindBy(how=How.XPATH, using="//input[@id='RequestedAmountH']")
	@CacheLookup
	WebElement HCRequestedAmount;
	
	@FindBy(how=How.XPATH, using="//input[@name='ApprovedAmountH']")
	@CacheLookup
	WebElement hcApprovedAmount;
	
	@FindBy(how=How.XPATH, using="//button[@id='hospitalChargesData']")
	@CacheLookup
	WebElement addHCCharges;
	
	//CARD DETAILS
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Card Details')]")
	@CacheLookup
	WebElement gotocarddetails;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'card_number')]")
	@CacheLookup
	WebElement cardNumber;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'cardExpDate')]")
	@CacheLookup
	WebElement cardMonth;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'cardExpDate')]")
	@CacheLookup
	WebElement enterCardMonth;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='textAreaRemarks']")
	@CacheLookup
	WebElement inputRemarks;
	
	// SAVE
	@FindBy(how=How.XPATH, using="//button[@id='btnSavePreapproval']")
	@CacheLookup
	WebElement buttonSave;
	
	// COPY PA NUMBER
	
/*	@FindBy(xpath="//div[contains(@ng-class,'config.title')]")
	@CacheLookup
	WebElement paNumber;*/
	
	By paNotification = By.xpath("//span[@id='ErrorMsgText']");
	

	// NO TO STAY
	@FindBy(how=How.XPATH, using="//button[contains(@id,'SaveAlertDivStay')]")
	@CacheLookup
	WebElement notoStay;
	
	@FindBy(how=How.XPATH, using="//button[contains(@id,'ShowHideDocument')]")
	@CacheLookup
	WebElement btnshowhide2;
	
	//
	@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Auto-adjudicate')]")
	@CacheLookup
	WebElement autoAudjudicate;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Auto Pre-approval Result')]")
	@CacheLookup
	WebElement gotoPreApprovalRes;
	
	//FOR PENDING ACTIONS =========================================
	@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Pending')]")
	@CacheLookup
	WebElement pendingBtnLink;
	
	//@FindBy(how=How.XPATH, using="(//button[contains(.,'Select')])[2]")
	@FindBy(how=How.XPATH, using="(//button[contains(@class,'multiselect dropdown')])")
	@CacheLookup
	WebElement ReasonpendingBtnLink;	
	
	
	@FindBy(how=How.XPATH, using="(//button[@type='button'][contains(.,'Submit')])[1]")
	@CacheLookup
	WebElement SubmitReasonpendingBtnLink;	

	
	//@FindBy(how=How.XPATH, using="//a[@class='s3-button'][contains(.,'Back to Pending')]")
	
//	@FindBy(how=How.XPATH, using="//a[@class='s3-button'][contains(.,'Back to Pending')]")
	@FindBy(how=How.XPATH, using="//a[text()='Back to Pending']")
	@CacheLookup
	WebElement clickBackToPendingLink;	
	
	//FOR REJECT ACTIONS ==============================================
	
	//@FindBy(how=How.XPATH, using="//button[@data-target='#RejectReason']")
	@FindBy(how=How.XPATH, using="//button[@id='btnReject']")
	@CacheLookup
	WebElement rejectBtnLink;
	
	
	//@FindBy(how=How.XPATH, using="//div[@id='RejectReason']//button[@type='button'][contains(text(),'Select')]")
	@FindBy(how=How.XPATH, using="//span[text()='None selected']//parent::button")

	@CacheLookup
	WebElement ReasonRejectBtnLink;
	
	// Select written under code function.
	
	@FindBy(how=How.XPATH, using="//div[@class='modal-footer']//button[@type='button'][contains(text(),'Reject')]")
	@CacheLookup
	WebElement SubmitReasonRejectBtnLink;
	
	//@FindBy(how=How.XPATH, using="//a[@class='s3-button'][contains(.,'Back to Declined')]")
	
	@FindBy(how=How.XPATH, using="//a[text()='Back to Declined']")
	@CacheLookup
	WebElement clickBackToRejectLink;
	
	//FOR APPROVE ACTIONS ========================================
	@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Approve')]")
	//@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Approve Without Cashless')]")
	@CacheLookup
	WebElement appRove;
	@FindBy(how=How.ID, using="ApproveWithReason")
	//@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Approve Without Cashless')]")
	@CacheLookup
	WebElement appRove_pending;
	
	@FindBy(how=How.XPATH, using="//div[@id='ApproveReason']//button[@type='button'][contains(text(),'Select')]")
	@CacheLookup
	WebElement ReasonApproveBtnLink;
	
	@FindBy(how=How.XPATH, using="(//button[@type='button'][contains(.,'Submit')])[2]")
	@CacheLookup
	WebElement SubmitReasonapproveBtnLink;
	
	@FindBy(how=How.XPATH, using="//a[@class='s3-button btnBackToApprove'][contains(.,'Back to Approve')]")
	@CacheLookup
	WebElement backToApprove;
	

	//By rfapprovetitlelink = By.xpath("(//h4[@class='modal-title'][contains(.,'Reason For Approve')])[1]");
	//By rfapprovechecklink = By.xpath("//a[@class='s3-button'][contains(.,'Back to Approve')]");
	
	
	//FOR LOADER
	//@FindBy(how=How.XPATH, using="//div[contains(@ng-show,'loaderDiv == true') and contains(@aria-hidden,'false')]")
	//@CacheLookup
	//WebElement loader;
	
	//By loader = By.id("loaderDiv");
	
	By loader = By.xpath("//div[contains(@ng-show,'loaderDiv == true') and contains(@aria-hidden,'false')]");
	
	By loadingImage = By.id("loaderDivL");
	
	
	
	// ASSESSMENT ENQUIRY ELEMENT ===========================================
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Assessment Enquiry')]")
	@CacheLookup
	WebElement AssessmentEnqlink;
	
	/*@FindBy(how=How.XPATH, using="(//i[@class='fa fa-eye'])[1]")
	@CacheLookup
	WebElement viewAssesmentlink;*/
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Assessment')]")
	@CacheLookup
	WebElement AddAssessmentlink;
	
	@FindBy(how=How.XPATH, using="//select[@ng-model='referencePANumber']")
	@CacheLookup
	WebElement selectPANassessmentlink;
	
	@FindBy(how=How.XPATH, using="//textarea[@ng-model='assessdesc']")
	@CacheLookup
	WebElement textArealink;
	
	@FindBy(how=How.XPATH, using="//input[@value='Add']")
	@CacheLookup
	WebElement AddforAssessmentlink;
	
	@FindBy(how=How.XPATH, using="//input[contains(@ng-model,'searchAssessmntPAReference')]")
	@CacheLookup
	WebElement panumberAssessmentlink;
	
	@FindBy(how=How.XPATH, using="//button[@ng-click='searchAssessment()']")
	@CacheLookup
	WebElement goAssessmentEnqlink;
	
	@FindBy(how=How.XPATH, using="//div[@id='AssmntEnqIdModal']//button[@type='button'][contains(text(),'Close')]")
	@CacheLookup
	WebElement closeAssessmentEnqink;
	
	
	//==== ELEMENT FOR ACTIVITY LOG ==========================
	
	@FindBy(how=How.XPATH, using="//button[@type='button'][contains(.,'Activity Log')]")
	@CacheLookup
	WebElement activityLogLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='ActivityLog']//button[@type='button'][contains(text(),'×')]")
	@CacheLookup
	WebElement closeActivityLogLink;
	
	
	//Element Method =========================================================
public void click_selectIcdCode_A01_ID(){
		
		wait.until(ExpectedConditions.elementToBeClickable(selectIcdCode_A01_ID)).click();
	}
	
	public void clickClaimmenu(){
		
		wait.until(ExpectedConditions.elementToBeClickable(navClaimmenu)).click();
	}
	
	public void clickPalink(){
		
		wait.until(ExpectedConditions.elementToBeClickable(palink)).click();
	}
	
	public void clickIndexinglink(){
		
		wait.until(ExpectedConditions.elementToBeClickable(indexinglink)).click();
		//ngWebDriver.waitForAngularRequestsToFinish();
	}	
	
	public void clickaddManualPA()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//div[@ng-show='loaderDiv == true']"))));
		
		//boolean invisibleLoader = wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		//boolean invisibleLoader = wait.until(ExpectedConditions.invisibilityOf(loader));
			
		/*if(invisibleLoader){
			
			WebElement addmanual = wait.until(ExpectedConditions.elementToBeClickable(btnaddManual));
			addmanual.click();
		}*/// --this method takes more than one minute to execute so commenting this and using thread.
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(btnaddManual)).click(); //Original
		
		
		
	}
	public void clickaddManualPA_new(WebDriver driver)
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnaddManualnew))	;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnaddManualnew);
	}
	
	public void clickShowhide()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnshowhide)).click();
	}
	
	public void setSearchPolicy(String sPolicy) throws InterruptedException
	{
		
		Thread.sleep(3000l);
		searchPolicy.sendKeys(sPolicy);
		Thread.sleep(1000l);
		searchPolicy.sendKeys(Keys.chord(Keys.CONTROL, "a")); //highlight all in box
		Thread.sleep(1000l);
		searchPolicy.sendKeys(Keys.chord(Keys.CONTROL, "x")); //cut
		Thread.sleep(2000l);
		searchPolicy.sendKeys(Keys.chord(Keys.CONTROL, "v")); //paste
		Thread.sleep(4000l);
		
		/*Thread.sleep(3000l);
		wait.until(ExpectedConditions.elementToBeClickable(searchPolicy)).sendKeys(sPolicy);
		Thread.sleep(1000l);
		wait.until(ExpectedConditions.elementToBeClickable(searchPolicy)).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(searchPolicy)).clear();
		Thread.sleep(2000l);
		wait.until(ExpectedConditions.elementToBeClickable(searchPolicy)).sendKeys(sPolicy);*/
		
		//Thread.sleep(1000l);
		//wait.until(ExpectedConditions.elementToBeClickable(searchPolicy)).sendKeys(Keys.BACK_SPACE);
		//Thread.sleep(1000l);
		//wait.until(ExpectedConditions.elementToBeClickable(searchPolicy)).sendKeys("0");
	}	
	
	public void clear_data_policy_Field() {
		searchPolicy.clear();
	}
	
	//@Parameters(value="tc_row")
	public void selectPolicy(String row)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(selectSearchPolicy)).click();
		
		int currentRow = Integer.parseInt(row);
		//By selectElementPolicy = By.xpath("//span[contains(@ng-show,'item.LobId')][contains(.,'"+paread.getPaManual(currentRow, "PolicyNumber")+"')]");
		//li[text()='588-9158670']
		By selectElementPolicy = By.xpath("//li[text()='588-9158670']");
		WebElement selectPolicy = wait.until(ExpectedConditions.elementToBeClickable(selectElementPolicy));
		selectPolicy.click();
	}
	public void selectPolicy2(String row)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(selectSearchPolicy)).click();
		
		int currentRow = Integer.parseInt(row);
	//	By selectElementPolicy = By.xpath("//span[contains(@ng-show,'item.LobId')][contains(.,'"+paread.getPaManual(currentRow, "PolicyNumber")+"')]");
		By selectElementPolicy = By.xpath("//li[contains(.,'"+paread.getPaManual(currentRow, "PolicyNumber")+"')]");

		////li[contains(text(),'588-9124078')]
		//By selectElementPolicy = By.xpath("//li[text()='588-9158670']");
		WebElement selectPolicy = wait.until(ExpectedConditions.elementToBeClickable(selectElementPolicy));
		selectPolicy.click();
	}
	public void click_PA_Link2(String row)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(selectSearchPolicy)).click();
		
		int currentRow = Integer.parseInt(row);
	//	By selectElementPolicy = By.xpath("//span[contains(@ng-show,'item.LobId')][contains(.,'"+paread.getPaManual(currentRow, "PolicyNumber")+"')]");
		By selectElementPolicy = By.xpath("//a[contains(.,'"+paread.getPaManual(currentRow, "PA_Number")+"')]");

		////li[contains(text(),'588-9124078')]
		//By selectElementPolicy = By.xpath("//li[text()='588-9158670']");
		WebElement selectPolicy = wait.until(ExpectedConditions.elementToBeClickable(selectElementPolicy));
		selectPolicy.click();
	}
	
	//===============================  CODE FOR MERGE ==================================================================
	
	public void clickPreApprovalHistory(){
		
		wait.until(ExpectedConditions.elementToBeClickable(PreApprovalHistorylink)).click();
	}
	
	public void clickViewMore(){
		
		wait.until(ExpectedConditions.elementToBeClickable(ViewMorelink)).click();
		
	}
	
	public void selectPreApprovalStatus(String pastatus){
		
		Select patype = new Select(wait.until(ExpectedConditions.elementToBeClickable(PreApprovalStatus)));
		patype.selectByVisibleText(pastatus);
	}
	
	public void getClaimNumber(String pendingPaN) throws Exception{
		
		wait.until(ExpectedConditions.elementToBeClickable(ClaimNumberPAH)).sendKeys(pendingPaN);
		Thread.sleep(4000l);
		ClaimNumberPAH.sendKeys(Keys.ENTER);
	}
	
	public void verifyPANumber(String pendingPa){
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='link-title ng-binding'][contains(.,'"+pendingPa+"')]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ApprovalHistoryModal']//table[@class='pa-table'][contains(.,'"+pendingPa+"') and contains(.,'Merge')]")));
		//div[@id='ApprovalHistoryModal']//table[@class='pa-table'][contains(.,'PA00109') and contains(.,'Merge')]
	}
	
	public void clickMerge(){
		
		wait.until(ExpectedConditions.elementToBeClickable(Mergelink)).click();
	}
	
	//==============================================================================================================================
	
	public void scrolltopad()
	{
		//wait.until(ExpectedConditions.invisibilityOf((WebElement) By.id("loaderDiv")));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToPad);
		//((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", scrollToPad);
	}
	
	
	public void selectMedicalCardType(String medicalcardType){
		
		Select selectMedicalCardType = new Select(wait.until(ExpectedConditions.elementToBeClickable(medicalcardTypelink)));
		selectMedicalCardType.selectByVisibleText(medicalcardType);			
	}
	
	public void getDocName(String getDoctor)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(inputDocName)).sendKeys(getDoctor);
		
		for(int i=0;i<10;i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
			}
			boolean status = js.executeScript("return document.readyState").toString().equals("complete");
			boolean ajaxIsComplete = (boolean)js.executeScript("return jQuery.active == 0");
			if(status && ajaxIsComplete)
			{
				System.out.println("Page Loaded");
				//wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//div[@ng-show='loaderDiv == false']"))));
				////ngWebDriver.waitForAngularRequestsToFinish();
				wait.until(ExpectedConditions.elementToBeClickable(inputDocName)).sendKeys(getDoctor);
				break;
			}
			else
			{
				System.out.println("Page Loading.....");
			}
			
		}
		
	}
	
	public void selectDocName()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(SelDocName)).click();
	}


	public void getSymptomDate(String getsymptomDate)
	{
		//ngWebDriver.waitForAngularRequestsToFinish();
		wait.until(ExpectedConditions.elementToBeClickable(symptomDate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(symptomDate)).sendKeys(getsymptomDate);
	}
	
	public void getConsultationDate(String getConsultDate)
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstConsultationDate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(firstConsultationDate)).sendKeys(getConsultDate);
	}
	
	public void getAdmissionDate(String getAdmissionDate)
	{
		wait.until(ExpectedConditions.elementToBeClickable(admissionDate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(admissionDate)).sendKeys(getAdmissionDate);
		wait.until(ExpectedConditions.elementToBeClickable(admissionDate)).sendKeys(Keys.TAB);
	}
	
	public void getDischargeDate(String getDischargeDate)
	{
		wait.until(ExpectedConditions.elementToBeClickable(dischargeDate)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(dischargeDate)).sendKeys(getDischargeDate);
	}	
	
	public void getTreatmentDate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(treatmentDate)).click();
	}
	
	public void getSymptom(String symptom)
	{
		wait.until(ExpectedConditions.elementToBeClickable(sympTomComplaint)).sendKeys(symptom);
	}
	
	public void getContactNumber(String contactNum)
	{
		wait.until(ExpectedConditions.elementToBeClickable(contactNumber)).sendKeys(contactNum);
	}
	
	public void getBillcurrency(String billCurrency){
		
		Select selectbillCurrency = new Select(wait.until(ExpectedConditions.elementToBeClickable(billCurrencylink)));
		selectbillCurrency.selectByVisibleText(billCurrency);		
	}
	
	public void goToDiagnosisView()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", gotodiagView);
	}
	
	
	public void getIcdCode(String icdCodedes) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).sendKeys("R");
		Thread.sleep(5000l);
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).sendKeys(icdCodedes);
/*		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).clear();
		Thread.sleep(3000l);
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).click();
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).sendKeys(icdCodedes);
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).clear();
		Thread.sleep(3000l);
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).click();
		wait.until(ExpectedConditions.elementToBeClickable(icdCode)).sendKeys(icdCodedes);*/		
	}
	
	public void selectIcdCode(String row)
	{
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(selectIcdCode)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//strong[@class='ng-binding'][contains(.,'"+paread.getPaManual(currentRow, "ICD Code / Description")+"')]")))).click();
	}
	public void selectIcdCode_A01()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectIcdCode_A01)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//strong[@class='ng-binding'][contains(.,'"+paread.getPaManual(currentRow, "ICD Code / Description")+"')]")))).click();
	}
	
	public void getAddIcdCode()
	{
		//ngWebDriver.waitForAngularRequestsToFinish();
		wait.until(ExpectedConditions.elementToBeClickable(btnAddEditIcd)).click();
	}
	
	public void goToDoctorFee()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", gotodoctorfee);
	}
	
	public void entyerDoctorFee()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", enterdoctorfees);
	}
	
	public void getDfBenefitItem(String docBenefititem)
	{
		wait.until(ExpectedConditions.elementToBeClickable(dfbenefititem)).sendKeys(docBenefititem);
	}
	
	public void selectdfeeBenefitItem(String row)
	{
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(selectdfbenefititem)).click();
		// wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//span[@class='ng-binding'][contains(.,'"+paread.getPaManual(currentRow, "DF Benefit Item")+"')]")))).click();
		//span[@class='ng-binding'][contains(.,'Abdominal Paracentesis &/ Peritoneal Larvage')]
		
	}
	
	public void selectdfeeBenefitItemAdjust(String row)
	{
		int currentRow = Integer.parseInt(row);
		//wait.until(ExpectedConditions.elementToBeClickable(selectdfbenefititem)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//li[@class='ui-menu-item'][contains(.,'"+paread.getPaAdjustment(currentRow, "DF Benefit Item")+"')]")))).click();
		//span[@class='ng-binding'][contains(.,'Abdominal Paracentesis &/ Peritoneal Larvage')]
		
	}	
	
	public void getdfRequestedAmount(String docrequestAmount)
	{
		//ngWebDriver.waitForAngularRequestsToFinish();
		wait.until(ExpectedConditions.elementToBeClickable(dfRequestAmount)).sendKeys(docrequestAmount);
	}
	
	public void getdfApprovedAmount(String dfapproveamount){
		
		wait.until(ExpectedConditions.elementToBeClickable(dfapproveamountlink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(dfapproveamountlink)).sendKeys(dfapproveamount);
	}
	
	public void clickAnesthesiologistfee(){
		
		wait.until(ExpectedConditions.elementToBeClickable(anesthesiologistfeeLink)).click();
		
	}
public void clickAnesthesiologistfee2(WebDriver driver){
		
		//wait.until(ExpectedConditions.elementToBeClickable(anesthesiologistfeeLink)).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", anesthesiologistfeeLink);
	}
	public void getAddDocFee()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AddBenefitItems)).click();
	}
	
	//=========================== LOG AMOUNT =======================================
	
	public void chekLogAmount(){
		
		//wait.until(ExpectedConditions.elementToBeClickable(checkLog)).click();
		//checkLog.click();
		
		if(checkLog.isSelected()){
			
			System.out.println("LOG Already Checked");
			
		}else
		{
			
			checkLog1.click();
		}
	}
	
	public void enterLogAmount(String LogAmount){
		
		String Logtext = Logtxt.getText();
		
		System.out.println("Log Amount = "+Logtext);
		
		if(Logtext == "") {
			
			wait.until(ExpectedConditions.elementToBeClickable(Logtxt)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(Logtxt)).sendKeys(LogAmount);
		}
		else
		{
			System.out.println("Log Amount Already exist");
		}
	}
	
	//==============================================================================
	
	//Proceed Work From GoToHospitalCharges
	public void goToHospitalCharges()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", gotohospitalcharges);
	}
	
	public void getHCBenefitItem(String hcBenefitItem)
	{
		wait.until(ExpectedConditions.elementToBeClickable(HCBenefitItem)).sendKeys(hcBenefitItem);
		//wait.until(ExpectedConditions.elementToBeClickable(HCBenefitItem)).sendKeys("Post-Confinement");

		
	}
	
	public void selecteHCBenefitItem(String row)
	{
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(selHCBenFITem)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//span[@class='ng-binding'][contains(.,'"+paread.getPaManual(currentRow, "HC Benefit Item")+"')]")))).click();
	}
	
	public void getHCRequestedAmount(String hcRequestedAmount)
	{
		wait.until(ExpectedConditions.elementToBeClickable(HCRequestedAmount)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(HCRequestedAmount)).sendKeys(hcRequestedAmount);
	}
	
	public void getHCApprovedAmount(String hchargesApprovedAmount)
	{
		wait.until(ExpectedConditions.elementToBeClickable(hcApprovedAmount)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(hcApprovedAmount)).sendKeys(hchargesApprovedAmount);
	}
	
	public void getAddHospitalCharges()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addHCCharges)).click();
	}
	
	//CARD DETAILS
	public void goTOCardDetails()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", gotocarddetails);
	}
	
	public void getCardNumber(String cardNum)
	{
		wait.until(ExpectedConditions.elementToBeClickable(cardNumber)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(cardNumber)).sendKeys(cardNum);
	}
	
	public void getCardMonth()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cardMonth)).click();
		
	}
	
	public void getCardMonth(String getcardMon)
	{
		wait.until(ExpectedConditions.elementToBeClickable(enterCardMonth)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(enterCardMonth)).sendKeys(getcardMon);
	}
	
	public void inputRemarks(String iremarks)
	{
		wait.until(ExpectedConditions.elementToBeClickable(inputRemarks)).sendKeys(iremarks);
	}
	
	public void saveButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
	}
	
	public String getpaNotification()
	{
		String paNUmber = wait.until(ExpectedConditions.elementToBeClickable(paNotification)).getText();
		return paNUmber;
	}
	
	public void getNoTOStay()
	{
		wait.until(ExpectedConditions.elementToBeClickable(notoStay)).click();
	}
	
	public void clickShowhide2()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnshowhide2)).click();
	}
	
	public void clickautoAudjudicate()
	{
		wait.until(ExpectedConditions.elementToBeClickable(autoAudjudicate)).click();
	}
	
	public void gotoPreApprovalResult()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", gotoPreApprovalRes);
	}
	
	//===================== FOR PENDING ACTION ======================================
	
	public void clickPending(){
		
		wait.until(ExpectedConditions.elementToBeClickable(pendingBtnLink)).click();
	}
	
	public void clickReasonForPending(){
		
		wait.until(ExpectedConditions.elementToBeClickable(ReasonpendingBtnLink)).click();
	}
	
	public void selectReasonForPending(String row){
		
		int currentRow = Integer.parseInt(row);
		//wait.until(ExpectedConditions.elementToBeClickable(selHCBenFITem)).click();
		//oldxpath=wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//b[contains(.,'"+paread.getPaManual(currentRow, "Reason For Pending")+"')]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//label[contains(@title,'P01-Please provide Pre-authorisation Form 1')]")))).click();
	
	}
	
	public void clickSubmitReasonForPending(){
		
		wait.until(ExpectedConditions.elementToBeClickable(SubmitReasonpendingBtnLink)).click();
		
	}
	
	public void clickBackToPending(){
		
		wait.until(ExpectedConditions.elementToBeClickable(clickBackToPendingLink)).click();
	}
	
	//==========================FOR REJECT ACTIONS =======================================================================	
	
	public void clickReject(){
		
		wait.until(ExpectedConditions.elementToBeClickable(rejectBtnLink)).click();
	}
	
	public void clickReasonForReject(){
		
		wait.until(ExpectedConditions.elementToBeClickable(ReasonRejectBtnLink)).click();
	}
	
	public void selectReasonForReject(String row){
		
		int currentRow = Integer.parseInt(row);
		//wait.until(ExpectedConditions.elementToBeClickable(selHCBenFITem)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//b[contains(.,'"+paread.getPaManual(currentRow, "Reason For Reject")+"')]")))).click();
		
	}
	
	public void clickSubmitReasonForReject(){
		
		wait.until(ExpectedConditions.elementToBeClickable(SubmitReasonRejectBtnLink)).click();
		
	}
	
	public void clickBackToReject(){
		
		wait.until(ExpectedConditions.elementToBeClickable(clickBackToRejectLink)).click();
	}	
	
	//==========================FOR APPROVE ACTIONS ==========================================
	public void clickApprove()
	{
		wait.until(ExpectedConditions.elementToBeClickable(appRove)).click();
	}
	public void clickappRove_pending()
	{
		wait.until(ExpectedConditions.elementToBeClickable(appRove_pending)).click();
	}
	
	public void clickReasonForApprove(){
		
		wait.until(ExpectedConditions.elementToBeClickable(ReasonApproveBtnLink)).click();
	}	
	
	
	
	@FindBy(how=How.XPATH, using="//b[contains(.,'WC1 - No Credit Card Payment Authorisation')]")
	@CacheLookup
	WebElement SelectReasonapproveBtnLink;
	
	public void selectReasonForApprove(String row){

		int currentRow = Integer.parseInt(row);
		//wait.until(ExpectedConditions.elementToBeClickable(selHCBenFITem)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//b[contains(.,'"+paread.getPaManual(currentRow, "Reason For Approve")+"')]")))).click();
		System.out.println("//b[contains(.,'"+paread.getPaManual(currentRow, "Reason For Approve")+"')]");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(.,'"+paread.getPaManual(currentRow, "Reason For Approve")+"')]"))).click();
	}
	
	
	public void clickSubmitReasonForApprove(){
		
		wait.until(ExpectedConditions.elementToBeClickable(SubmitReasonapproveBtnLink)).click();
		
	}
	
	
	public void clickBackToApprove()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(backToApprove)).click();
	}
	
	//========================================================================================	
	//============================Function to Navigate through docID=======================
	
	public void clickAdvanceSerach()
	{
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
		wait.until(ExpectedConditions.elementToBeClickable(clickAdvaSearch)).click();
	}
	
	public void enterDocID(String docId)
	{
		wait.until(ExpectedConditions.elementToBeClickable(DocIdtxt)).sendKeys(docId);
	}
	
	
	public void clickSearch()
	{
		wait.until(ExpectedConditions.elementToBeClickable(clickSearch)).click();
	}
	
	public void verifyDocId(String docId)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(.,'"+docId+"')]")));
	}	
	
	public void clickProceed()
	{
		wait.until(ExpectedConditions.elementToBeClickable(clickProceed)).click();
	}

	public String moveToTop() {
		
		
		js.executeScript("arguments[0].scrollIntoView(true);", movetopForPA);
		
		//String panGetDetails = 
				
		String panGetDetails = wait.until(ExpectedConditions.elementToBeClickable(paNumberTop)).getText();
		return panGetDetails;
		
		//movetopForPA
	}

	public void clickChopping() {
		
		wait.until(ExpectedConditions.elementToBeClickable(clickChopping)).click();
		
	}

	public void waitTillDocLoad() {
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(waitTillDoc));
		wait.until(ExpectedConditions.visibilityOf(waitTillDoc));
	}

	public void performChopping() throws Exception {
		
		Actions actchopping = new Actions(ldriver);
		
		Thread.sleep(2000l);
		//actchopping.dragAndDropBy(sourcegetpath1, 100, 0).build().perform();
		actchopping.dragAndDropBy(sourcegetpath1, 265, 370).build().perform();
		
		Thread.sleep(2000l);
		//actchopping.dragAndDropBy(sourcegetpath2, 350, 0).build().perform();
		actchopping.dragAndDropBy(sourcegetpath2, 350, 390).build().perform();

		Thread.sleep(2000l);
		actchopping.dragAndDropBy(sourcegetpath3, 400, 390).build().perform();

		Thread.sleep(2000l);
		actchopping.dragAndDropBy(sourcegetpath4, 500, 380).build().perform();

		Thread.sleep(2000l);
		actchopping.dragAndDropBy(sourcegetpath5, 550, 380).build().perform();
	}
	
	public void deleteChopping() {
		wait.until(ExpectedConditions.elementToBeClickable(DeleteOneChop)).click();
	}		
	
	public void clicksaveChopping() {
		
		wait.until(ExpectedConditions.elementToBeClickable(saveChopping)).click();
	}
	
	public void waitTillLoader() {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
	}

	public void getDfcptCode(String excelcpt) {

		wait.until(ExpectedConditions.elementToBeClickable(dfcptcode)).sendKeys(excelcpt);
		
	}
	
	public void selectCptCode(String row)
	{
		int currentRow = Integer.parseInt(row);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ng-binding'][contains(.,'"+paread.getPaManual(currentRow, "DF CPT Code Adjustment")+"')]"))).click();
	}

	// ================= ASSESSMENT ENQUIRY CODE ===========================
	
	public void clickAssessmentEnquiry() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AssessmentEnqlink)).click();
		
	}

/*	public void clickViewAssesment() {
	
		wait.until(ExpectedConditions.elementToBeClickable(viewAssesmentlink)).click();
		
	}*/
	
	public void clickAddAssessment(){
		
		wait.until(ExpectedConditions.elementToBeClickable(AddAssessmentlink)).click();
	}

	public void selectPanumberforassessment(String getPANumber) {
		
		Select selectPANassessment = new Select(wait.until(ExpectedConditions.elementToBeClickable(selectPANassessmentlink)));
		selectPANassessment.selectByVisibleText(getPANumber);
		
	}

	public void enterTextArea(String assessmentTextArea) {
		
		wait.until(ExpectedConditions.elementToBeClickable(textArealink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(textArealink)).sendKeys(assessmentTextArea);
		
	}

	public void clickAddforAssessmentEnq() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AddforAssessmentlink)).click();
		
	}

	public void enterPanumberAssessment(String getPANumber) {

		wait.until(ExpectedConditions.elementToBeClickable(panumberAssessmentlink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(panumberAssessmentlink)).sendKeys(getPANumber);

		
	}

	public void clickGoAssessmentEnq() {
		
		wait.until(ExpectedConditions.elementToBeClickable(goAssessmentEnqlink)).click();
		
	}

	public void clickCloseAssessmentEnq() {
		
		wait.until(ExpectedConditions.elementToBeClickable(closeAssessmentEnqink)).click();
		
	}

	// ================== CODE FOR ACTIVITY LOG ============================
	public void clickActivityLog() {
		
		wait.until(ExpectedConditions.elementToBeClickable(activityLogLink)).click();
		
	}

	public void clickCloseActivityLog() {
		
		wait.until(ExpectedConditions.elementToBeClickable(closeActivityLogLink)).click();
		
	}

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
	
	// ==== TODO CODE for indexing pa search

	@FindBy(how=How.XPATH, using="//button[@id='GoIndexing']")
	WebElement yesLink;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Pre-approval No']")
	WebElement paSearhtxtLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Search')]")
	WebElement SearchbtnLink;
	
	@FindBy(how=How.XPATH, using="//a[@title='Proceed']")
	WebElement paProceedLink;
	
	public void clickYestoindexing() {
		
		wait.until(ExpectedConditions.elementToBeClickable(yesLink)).click();
		
	}

	public void enterPAtoSearch(String preANumber) {
		
		wait.until(ExpectedConditions.elementToBeClickable(paSearhtxtLink)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(paSearhtxtLink)).sendKeys(preANumber);	
		
	}

	public void click_Indexing_Searchbtn(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(SearchbtnLink));
		CommanCode.javascript_scroll_to_element(driver, SearchbtnLink);
	}
	public void clickSearchbtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchbtnLink)).click();
		
	}

	public boolean verifypa(String preANumber) {

		By verifyClaim = By.xpath("(//td[contains(.,'"+preANumber+"')])[2]");
		
		boolean chk = wait.until(ExpectedConditions.presenceOfElementLocated(verifyClaim)).isDisplayed();
		
		return chk;
		
	}

	public void clickpaProceed() {
		
		wait.until(ExpectedConditions.elementToBeClickable(paProceedLink)).click();
		
	}
	

	
}
