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
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.hbaxa.testdata.PAData;
import com.hbaxa.utilities.AdditionalConditions;
import com.hbaxa.utilities.CommanCode;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class PreApproval_Page {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	Select select;
	
	public PreApproval_Page(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
		
	}
	
	
	@FindBy(how=How.XPATH, using="//a[text()='Policy Information '] ")
	@CacheLookup
	WebElement policyinformation;
	@FindBy(how=How.XPATH, using="//a[text()='Pre-approval History'] ")
	@CacheLookup
	WebElement Pre_approval_History;
	@FindBy(how=How.XPATH, using="//a[text()='Claim History'] ")
	@CacheLookup
	WebElement claim_History;
	@FindBy(how=How.XPATH, using="//a[text()='Exclusions']")
	@CacheLookup
	WebElement Exclusions;
	@FindBy(how=How.XPATH, using="//li[@class='ui-menu-item']//br")
	@CacheLookup
	List<WebElement> policy_detail;
	@FindBy(how=How.XPATH, using="//div[@id='tab-1']//ul//li[1]//label//span")
	@CacheLookup
	WebElement policyDetail_policy_Number;
	@FindBy(how=How.XPATH, using="//span[@id='lblProductNameProfile']")
	@CacheLookup
	WebElement policyDetail_productName;
	@FindBy(how=How.ID, using="hdnSubmissionDate")
	@CacheLookup
	WebElement submission_date;
	@FindBy(how=How.XPATH, using="//input[@id='approver']")
	@CacheLookup
	WebElement Aprover_name;
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-user']//parent::li")
	@CacheLookup
	WebElement user_name;
	@FindBy(how=How.XPATH, using="(//table[@id='pa-table']//tbody)[1]//tr")
	@CacheLookup
	List <WebElement> pre_approval_history_Table_record;
	@FindBy(how=How.XPATH, using="//button[text()='View more']")
	@CacheLookup
	WebElement view_more_button;
	@FindBy(how=How.XPATH, using="(//button[@id='getAllPAHistoryBtn'])[1]")
	@CacheLookup
	WebElement view_more_button2;
	
	@FindBy(how=How.ID, using="refreshFromRLSBtn")
	@CacheLookup
	WebElement refreshFromRLSButton;
	@FindBy(how=How.ID, using="ErrorMsgText")
	@CacheLookup
	WebElement alert_Refresh_RLS_BTN;
	@FindBy(how=How.XPATH, using="//select[@id='Category']//option")
	@CacheLookup
	List<WebElement> category_dropdown;
	@FindBy(how=How.ID, using="Category")
	@CacheLookup
	WebElement category_Optiondropdown;
	@FindBy(how=How.ID, using="lblDoctorNetwork")
	@CacheLookup
	WebElement networkpanel;
	@FindBy(how=How.ID, using="DoctorRemark")
	@CacheLookup
	WebElement other_doctore;
	@FindBy(how=How.XPATH, using="//select[@id='wardType']//option")
	@CacheLookup
	List <WebElement> wardType_dropdown;
	@FindBy(how=How.XPATH, using="//input[@id='InvoluntaryWardType']")
	@CacheLookup
	WebElement check_box_invaluntary_wardType;
	@FindBy(how=How.XPATH, using="//span[text()='Same ICD already added!']")
	@CacheLookup
	WebElement check_ICD_alert_Message;
	@FindBy(how=How.XPATH, using="//tbody[@id='icdDataContainer']//tr[1]//td[13]//i[1]")
	@CacheLookup
	WebElement edit_ICD_;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnAddEditIcd']")
	@CacheLookup
	WebElement update_ICD_button;
	
	@FindBy(how=How.XPATH, using="//select[@id='icdStatus']")
	@CacheLookup
	WebElement status_dropdown;
	@FindBy(how=How.XPATH, using="//tbody[@id='icdDataContainer']//tr[2]//td[12]")
	@CacheLookup
	WebElement check_tablestatus;
	
	@FindBy(how=How.XPATH, using="//input[@id='UnPreExisting']")
	@CacheLookup
	WebElement checkBox_Unknown_Pre_Existing;
	@FindBy(how=How.XPATH, using="//input[@id='KnPreExisting']")
	@CacheLookup
	WebElement checkBox_KnPreExisting;
	@FindBy(how=How.XPATH, using="//input[@id='IsChronicRecurrent']")
	@CacheLookup
	WebElement checkBox_IsChronicRecurrent;
	@FindBy(how=How.XPATH, using="//h4[text()='a) 6 Months Medical Condition']")
	@CacheLookup
	WebElement sixth_month_medical;
	@FindBy(how=How.XPATH, using="//h4[text()='b) 12 Months Medical Condition']")
	@CacheLookup
	WebElement twel_month_medical;
	@FindBy(how=How.XPATH, using="//h4[text()='c) Other Condition']")
	@CacheLookup
	WebElement other_conditions;
	@FindBy(how=How.XPATH, using="//select[@id='wardTypeDoc']//option")
	@CacheLookup
	List <WebElement> doctore_fee_wardType_dropdown;
	@FindBy(how=How.XPATH, using="//select[@id='benefitPack']//option")
	@CacheLookup
	List <WebElement> doctore_fee_benefit_pack;
	@FindBy(how=How.XPATH, using="//input[@id='FwaAmount']//following::input[@id='hdnFwaAmount']")
	@CacheLookup
	WebElement doctore_free_FWA_amount;
	@FindBy(how=How.XPATH, using="//input[@id='FwaAmount']//following::input[@id='hdnFwaAmountH']")
	@CacheLookup
	WebElement HC_FWA_amount;
	@FindBy(how=How.XPATH, using="(//i[@class='fa fa-search'])[1]")
	@CacheLookup
	WebElement doctore_free_FWA_reason_search;
	@FindBy(how=How.XPATH, using="//select[@id='drFeeStatus']//option")
	@CacheLookup
	List <WebElement> doctore_fee_status_dropdown;
	@FindBy(how=How.XPATH, using="//table[@id='doctorFeeTableId']//tbody//tr")
	@CacheLookup
	List <WebElement> doctore_fee_Table_record;
	@FindBy(how=How.XPATH, using="//input[@id='a50']")
	@CacheLookup
	WebElement doctore_free_fifty_percent_checkbox;
	@FindBy(how=How.XPATH, using="//select[@id='BillWardTypeH']//option")
	@CacheLookup
	List <WebElement> HC_wardType_dropdown;
	@FindBy(how=How.XPATH, using="//select[@id='hospitalChargeStatus']//option")
	@CacheLookup
	List <WebElement> HC_status_dropdown;
	@FindBy(how=How.XPATH, using="(//i[@class='fa fa-search'])[2]")
	@CacheLookup
	WebElement HC_FWA_reason_search;
	@FindBy(how=How.XPATH, using="//label[text()='Total Approved Amount']")
	@CacheLookup
	WebElement total_approve_amount;
	@FindBy(how=How.XPATH, using="//label[text()='Total Approved Amount After Adjustment']")
	@CacheLookup
	WebElement total_approve_amount_aft_Adjustment;
	@FindBy(how=How.XPATH, using="//label[text()='Total Requested Amount']")
	@CacheLookup
	WebElement total_Total_Requested_Amount;
	@FindBy(how=How.XPATH, using="//label[text()='Total FWA Amount']")
	@CacheLookup
	WebElement total_Total_FWA_Amount;
	@FindBy(how=How.XPATH, using="//label[text()='Deductible Balance']")
	@CacheLookup
	WebElement Deductible_Balance;
	@FindBy(how=How.XPATH, using="//label[text()='Total Approved item(s)']")
	@CacheLookup
	WebElement total_aprove_item;
	@FindBy(how=How.XPATH, using="//label[text()='Total Rejected item(s)']")
	@CacheLookup
	WebElement total_Rejected_item;
	@FindBy(how=How.XPATH, using="//span[text()='Other Information']")
	@CacheLookup
	WebElement other_information;
	@FindBy(how=How.XPATH, using="//input[@id='otherDiseaseInformation']")
	@CacheLookup
	WebElement other_information_textfield;
	
	@FindBy(how=How.XPATH, using="//input[@id='CardHolder']//following::input")
	@CacheLookup
	WebElement cardholder;
	@FindBy(how=How.XPATH, using="//textarea[@id='networkLetterRemark']")
	@CacheLookup
	WebElement network_letter_remark;
	@FindBy(how=How.XPATH, using="//textarea[@id='customerRemark']")
	@CacheLookup
	WebElement customer_remark;
	@FindBy(how=How.XPATH, using="//label[text()='Card Status ']")
	@CacheLookup
	WebElement card_status;
	@FindBy(how=How.XPATH, using="//a[@id='pdfDownload']")
	@CacheLookup
	WebElement download_option;
	@FindBy(how=How.XPATH, using="//button[@id='popup-btn']")
	@CacheLookup
	WebElement open_popUp;
	@FindBy(how=How.XPATH, using="//div[@id='tab-2']//div//div//h4")
	@CacheLookup
	WebElement errorMessage;
	@FindBy(how=How.XPATH, using="//a[text()='Chopping']")
	@CacheLookup
	WebElement chopping;
	@FindBy(how=How.ID, using="showCanceltbtn")
	@CacheLookup
	WebElement cancelbutton;
	@FindBy(how=How.XPATH, using="//a[text()='Back to Cancel']")
	@CacheLookup
	WebElement back_to_cancelbutton;
	@FindBy(how=How.ID, using="showWithDrawbtn")
	@CacheLookup
	WebElement WithDrawbtnbutton;
	@FindBy(how=How.XPATH, using="//a[text()='Back to Withdraw']")
	@CacheLookup
	WebElement back_to_withdrawbutton;
	@FindBy(how=How.XPATH, using="//li[text()='No Record found.']")
	@CacheLookup
	WebElement policynumber_noData_message;
	public void  wrong_policy_errorMessage() {
		if(policynumber_noData_message.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void click_back_to_withdrawbutton(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(back_to_withdrawbutton));
			CommanCode.javascript_scroll_to_element(driver,back_to_withdrawbutton);
	}
	public void click_WithDrawbtnbutton(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(WithDrawbtnbutton));
			CommanCode.javascript_scroll_to_element(driver,WithDrawbtnbutton);
	}
	public void click_back_to_cancelbutton(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(back_to_cancelbutton));
			CommanCode.javascript_scroll_to_element(driver,back_to_cancelbutton);
	}
	public void click_cancelbutton(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(cancelbutton));
			CommanCode.javascript_scroll_to_element(driver,cancelbutton);
	}
public void click_chopping(WebDriver driver) {
	wait.until(ExpectedConditions.elementToBeClickable(chopping));
		CommanCode.javascript_scroll_to_element(driver,chopping);
}
	public void  check_errorMessage() {
		wait.until(ExpectedConditions.elementToBeClickable(errorMessage));
		if(errorMessage.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_open_popUp() {
		if(open_popUp.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_download_option() {
		if(download_option.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_card_status() {
		if(card_status.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void enter_data_customer_remark() {
		customer_remark.sendKeys("Testdata");
	}
	public void enter_data_network_letter_remarkfield() {
		network_letter_remark.sendKeys("Testdata");
	}
	public String check_cardholder() {
		return cardholder.getAttribute("value");
	}
	public void enter_data_other_information_textfield() {
		other_information_textfield.sendKeys("Testdata");
	}
	public void  check_other_information_section() {
		if(other_information.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_total_Rejected_item() {
		if(total_Rejected_item.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	
	public void  check_total_aprove_item() {
		if(total_aprove_item.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_Deductible_Balance() {
		if(Deductible_Balance.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_total_Total_FWA_Amount() {
		if(total_Total_FWA_Amount.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_total_Total_Requested_Amount() {
		if(total_Total_Requested_Amount.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_total_approve_amount_aft_Adjustment() {
		if(total_approve_amount_aft_Adjustment.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	public void  check_total_approve_amount_field() {
		if(total_approve_amount.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
	}
	
 public void click_HC_FWA_reason_search(WebDriver driver) {
		
		CommanCode.javascript_scroll_to_element(driver,HC_FWA_reason_search);
	//	CommanCode.javascript_scroll_to_element(driver,HC_FWA_reason_search);

	////	HC_FWA_reason_search.click();
	}
	public void check_HC_status_dropdownn() {
		 
		  if( HC_status_dropdown.size()>=1) {
			  Assert.assertEquals( HC_status_dropdown.size(), 2);
		  }
		  else {
			  Assert.assertEquals( HC_status_dropdown.size(), 0);
		  }
	}
	public void check_HC_wardType_dropdown() {
		 
		  if( HC_wardType_dropdown.size()>=1) {
			  Assert.assertEquals( HC_wardType_dropdown.size(), 9);
		  }
		  else {
			  Assert.assertEquals( HC_wardType_dropdown.size(), 0);
		  }
	}
	public void  click_doctore_free_fifty_percent_checkbox(WebDriver driver) {
	//	wait.until(ExpectedConditions.elementToBeClickable(doctore_free_fifty_percent_checkbox));
		CommanCode.javascript_scroll_to_element(driver,doctore_free_fifty_percent_checkbox);
		//doctore_free_fifty_percent_checkbox.click();
	}
	
	public void check_doctore_fee_Table_record() {
		 
		  if( doctore_fee_Table_record.size()>=1) {
			  Assert.assertEquals( doctore_fee_Table_record.size(), 2);
		  }
		  else {
			  Assert.assertEquals( doctore_fee_Table_record.size(), 0);
		  }
	}
	public void check_doctore_fee_status_dropdown() {
		 
		  if( doctore_fee_status_dropdown.size()>=1) {
			  Assert.assertEquals( doctore_fee_status_dropdown.size(), 2);
		  }
		  else {
			  Assert.assertEquals( doctore_fee_status_dropdown.size(), 0);
		  }
	}
public void click_doctore_free_FWA_reason_search(WebDriver driver) {
	wait.until(ExpectedConditions.elementToBeClickable(doctore_free_FWA_reason_search));
		CommanCode.javascript_scroll_to_element(driver,doctore_free_FWA_reason_search);
		doctore_free_FWA_reason_search.click();
	}
	public String check_FWA_amount() throws Exception {
		Thread.sleep(15000);
	return 	doctore_free_FWA_amount.getAttribute("value")	;
	}
	
	public String check_HC_FWA_amount() throws Exception {
		Thread.sleep(15000);
	return 	HC_FWA_amount.getAttribute("value")	;
	}
	public String check_HC__FWA_amount() throws Exception {
		Thread.sleep(15000);
	return 	doctore_free_FWA_amount.getAttribute("value")	;
	}
	
	public void check_doctore_fee_benefit_pack() {
		 
		  if( doctore_fee_benefit_pack.size()>=1) {
			  Assert.assertEquals( doctore_fee_benefit_pack.size(), 2);
		  }
		  else {
			  Assert.assertEquals( doctore_fee_benefit_pack.size(), 0);
		  }
	}
	public void check_doctore_fee_wardType_dropdown() {
		 
		  if( doctore_fee_wardType_dropdown.size()>=1) {
			  Assert.assertEquals( doctore_fee_wardType_dropdown.size(), 9);
		  }
		  else {
			  Assert.assertEquals( doctore_fee_wardType_dropdown.size(), 0);
		  }
	}
public void click_other_conditions(WebDriver driver) {
		
		CommanCode.javascript_scroll_to_element(driver,other_conditions);
		if(other_conditions.getText().contains("c) Other Condition")) {
			
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
		
	}
	public void click_sixth_month_medical(WebDriver driver) {
		
		CommanCode.javascript_scroll_to_element(driver,sixth_month_medical);
		if(sixth_month_medical.getText().contains("a) 6 Months Medical Condition")) {
			
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
		
	}
public void click_twel_month_medical(WebDriver driver) {
		
		CommanCode.javascript_scroll_to_element(driver,twel_month_medical);
		if(twel_month_medical.getText().contains("b) 12 Months Medical Condition")) {
			
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
		
	}
	
	public void click_checkBox_IsChronicRecurrent(WebDriver driver) {
		//wait.until(ExpectedConditions.elementToBeClickable(checkBox_Unknown_Pre_Existing));
		CommanCode.javascript_scroll_to_element(driver,checkBox_IsChronicRecurrent);
		if(checkBox_IsChronicRecurrent.isSelected()==true) {
			
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
		
	}
	public void click_checkBox_Unknown_Pre_Existing(WebDriver driver) {
		//wait.until(ExpectedConditions.elementToBeClickable(checkBox_Unknown_Pre_Existing));
		CommanCode.javascript_scroll_to_element(driver,checkBox_Unknown_Pre_Existing);
		if(checkBox_Unknown_Pre_Existing.isSelected()==true) {
			
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(false, true);
		}
		
	}
	public void click_checkBox_checkBox_KnPreExisting(WebDriver driver) {
		//wait.until(ExpectedConditions.elementToBeClickable(checkBox_Unknown_Pre_Existing));
		CommanCode.javascript_scroll_to_element(driver,checkBox_KnPreExisting);
		if(checkBox_KnPreExisting.isSelected()==true) {
			
			Assert.assertNotEquals(checkBox_Unknown_Pre_Existing.isSelected(), true);
		}else {
			Assert.assertEquals(false, true);
		}
		
	}
	public void  check_tablestatus() {
		wait.until(ExpectedConditions.elementToBeClickable(check_tablestatus));
		
		Assert.assertEquals(check_tablestatus.getText(), "Reject");
	}
	public void select_status_dropdown(String data) {
		select=new Select(status_dropdown);
		select.selectByVisibleText(data);
	}
	public void click_update_ICD_button() {
		wait.until(ExpectedConditions.elementToBeClickable(update_ICD_button));
	  	update_ICD_button.click();
	}
	
	public void  click_ICD_edit() {
		wait.until(ExpectedConditions.elementToBeClickable(edit_ICD_));
	 	edit_ICD_.click();
	}
	
	public String  check_ICD_alert_Message() {
		wait.until(ExpectedConditions.elementToBeClickable(check_ICD_alert_Message));
	 return 	check_ICD_alert_Message.getText();
	}
	
	public void click_check_box_invaluntary_wardType(WebDriver driver) {
		CommanCode.javascript_scroll_to_element(driver,check_box_invaluntary_wardType);
		//check_box_invaluntary_wardType.click();
	}
	public void check_check_box_invaluntary_wardType() {
	  	
	  	if(check_box_invaluntary_wardType.isSelected()==true) {
	  		Assert.assertEquals(true, true);
	  	}else {
	  		Assert.assertEquals(false, true);
	  	}
	}
	
	public void check_wardtype_option() {
		 
		  if( wardType_dropdown.size()>=1) {
			  Assert.assertEquals( wardType_dropdown.size(), 9);
		  }
		  else {
			  Assert.assertEquals( wardType_dropdown.size(), 0);
		  }
	}
	
	public void enter_other_doctore() {
		other_doctore.sendKeys("atul");
	}
	public String  check_network_panel() {
		wait.until(ExpectedConditions.elementToBeClickable(networkpanel));
	 return 	networkpanel.getText();
	}
	
	public void check_category_dropdown() {
	for (int i=1;i<=2;i++) {
		if(i==1) {
			Assert.assertEquals(category_dropdown.get(i).getText(), "Out-Patient");
		}
		if(i==2) {
			Assert.assertEquals(category_dropdown.get(i).getText(), "Endoscopy");
		}
	}
		
	}
	public String check_category_Optiondropdown() {
		return category_Optiondropdown.getText();
	}
	public boolean check_alert_message() {
		wait.until(ExpectedConditions.elementToBeClickable(alert_Refresh_RLS_BTN));
	 return 	alert_Refresh_RLS_BTN.isDisplayed();
	}
	public void click_RefreshFromRLS_button(WebDriver driver) {
		//refreshFromRLSButton.click();
		CommanCode.javascript_scroll_to_element(driver,refreshFromRLSButton);
	}
	
	public void check_view_more_button_display(WebDriver driver) {
	//	 view_more_button.click();
		wait.until(ExpectedConditions.elementToBeClickable(view_more_button));
		 CommanCode.javascript_scroll_to_element(driver,view_more_button);
	}
	public void check_view_more_button_display2(WebDriver driver) {
		//	 view_more_button.click();
			wait.until(ExpectedConditions.elementToBeClickable(view_more_button2));
			 CommanCode.javascript_scroll_to_element(driver,view_more_button2);
		}
	public void check_view_more_button_display3(WebDriver driver) {
		//	 view_more_button.click();
			wait.until(ExpectedConditions.elementToBeClickable(view_more_button2));
			 CommanCode.javascript_scroll_to_element(driver,view_more_button2);
		}
	
	public int check_pre_approval_history_Table_record_size() {
		return pre_approval_history_Table_record.size();
		}
	public String check_user_name() {
		 return user_name.getText();
		}
	public String check_Aprover_name() {
		 return Aprover_name.getAttribute("value");
		}
	
	public String check_submission_date() {
		 return submission_date.getAttribute("value");
		}
	public String check_policyDetail_productName() {
		 return policyDetail_productName.getText();
		}
	public String check_policyDetail_policy_Number() {
		 return policyDetail_policy_Number.getText();
		}
	public int size_policy_detail() {
		 return policy_detail.size();
		}
	public void click_Exclusions() {
		 	Exclusions.click();;
		}
	public void click_claim_History_tab() {
		 	claim_History.click();
		}
	public void click_policyinformation() {
	 	policyinformation.click();
	}
	public void click_Pre_approval_History(WebDriver driver) {
		 //	Pre_approval_History.click();
		wait.until(ExpectedConditions.elementToBeClickable(Pre_approval_History));
		 	CommanCode.javascript_scroll_to_element(driver,Pre_approval_History);
		}
	
	public void  check_pagination_Previous_button_clickable(WebDriver driver) {
		
	//	CommanCode.javascript_scroll_to_element(driver,pagination_Previous_button);
	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	executor.executeScript("arguments[0].click();", pagination_Previous_button);
	}
	
	
	
	
	

	
}
