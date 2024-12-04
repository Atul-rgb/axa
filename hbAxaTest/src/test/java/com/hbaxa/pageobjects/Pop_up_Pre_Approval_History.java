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

import com.hbaxa.testdata.PAData;
import com.hbaxa.utilities.AdditionalConditions;
import com.hbaxa.utilities.CommanCode;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class Pop_up_Pre_Approval_History {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	Select select;
	Pop_up_Pre_Approval_History pop_up_Pre_Approval_History;
	
	public Pop_up_Pre_Approval_History(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
	
	}
	
	@FindBy(how=How.ID, using="PASearch")
	@CacheLookup
	WebElement PAnumbersearch_field;
	@FindBy(how=How.ID, using="ddlPAhistorystatus")
	@CacheLookup
	WebElement pre_aproval_status;
	//(//table[@id='pa-table'])[2]//tbody//tr[3]//td[8]
	@FindBy(how=How.XPATH, using="(//table[@id='pa-table'])[2]//tbody//tr[@class='commonPAHistoryClassMoreRecord']//td[text()='Pending']")
	//@FindBy(how=How.XPATH, using="//td[text()='Pending']")
	@CacheLookup
	WebElement table_pre_aproval_status;
	@FindBy(how=How.XPATH, using="(//table[@id='pa-table'])[2]//tbody//tr[@class='commonPAHistoryClassMoreRecord']//td[text()='Pre Approval Approved']")
	@CacheLookup
	WebElement table_pre_aproval_status_approved;
	@FindBy(how=How.XPATH, using="(//table[@id='pa-table'])[2]//tbody//tr[@class='commonPAHistoryClassMoreRecord']//td//a[text()='PA001817']")
	//@FindBy(how=How.XPATH, using="//a[contains(.,'"+paread.getPaManual(currentRow, "PA_Number")+"')]
	//span[contains(@ng-show,'item.LobId')][contains(.,'"+paread.getPaManual(currentRow, "PA_Number")+"')]
	@CacheLookup
	WebElement table_pre_aproval_number;
	@FindBy(how=How.XPATH, using="//h4[text()='No data Available']")
	@CacheLookup
	WebElement error_message;
	@FindBy(how=How.XPATH, using="(//button[text()='Close'])[3]")
	@CacheLookup
	WebElement close_button;
	
	
	public void click_new_PA_number(WebDriver driver,int currentRow) {
		String data=	paread.getPaManual(currentRow, "PA_Number");
		//WebElement ele=driver.findElement( By.xpath("(//a[contains(.,'"+paread.getPaManual(currentRow, "PA_Number")+"')[2]"));
	
	System.out.println("========"+data);
	//	WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'"+paread.getPaManual(currentRow, "PA_Number")+"')]"));
	WebElement ele=driver.findElement(By.xpath("(//a[contains(text(),'"+data+"')])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	public void  click_PA_number_hyperlink() {
		 table_pre_aproval_number.click();;
	}
	public String  check_PA_number_hyperlink() {
		 return table_pre_aproval_number.getAttribute("class");
	}
	public void  click_close_button() {
		close_button.click();
	}
	public String  check_table_pre_aproval_status_approved() {
		return  table_pre_aproval_status_approved.getText();
	}
	public String  check_error_message() {
		return  error_message.getText();
	}
	public String check_table_pre_aproval_number() {
		
	return 	table_pre_aproval_number.getText();
	}
	public String check_table_pre_aproval_status() {
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", "selectlink");
		wait.until(ExpectedConditions.elementToBeClickable(table_pre_aproval_status));
	return 	table_pre_aproval_status.getText();
	}
	public void  click_addManualPreAproval_button(WebDriver driver) {
	 	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", "");
	
	}
	public void enter_data_PAnumbersearch_field(String data) {
		PAnumbersearch_field.clear();
		PAnumbersearch_field.sendKeys(data);
		
		
	}
	public void select_pre_aproval_status_dropdown(String data) {
		//pre_aproval_status.click();
		select=new Select(pre_aproval_status);
		select.selectByVisibleText(data);
	}
	
	
	

	
}
