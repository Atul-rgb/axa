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

public class HomePage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-dashboard']")
	@CacheLookup
	WebElement dashbord;
	@FindBy(how=How.XPATH, using="//h2[text()='Total PA']")
	@CacheLookup
	WebElement total_PA;
	@FindBy(how=How.XPATH, using="//h2[text()='Pending PA']")
	@CacheLookup
	WebElement pending_PA;
	@FindBy(how=How.XPATH, using="//h2[text()='Approved PA']")
	@CacheLookup
	WebElement Approved_PA;
	@FindBy(how=How.XPATH, using="//h2[text()='Declined PA']")
	@CacheLookup
	WebElement decliend_PA;
	@FindBy(how=How.ID, using="pieCashless")
	@CacheLookup
	WebElement cashless_piechart;
	@FindBy(how=How.ID, using="pieReimbursement")
	@CacheLookup
	WebElement reimbursement_piechart;
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-sign-out']")
	@CacheLookup
	WebElement logout;
	public void check_logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		if(logout.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	public void check_reimbursement_piechart() {
		wait.until(ExpectedConditions.elementToBeClickable(reimbursement_piechart));
		if(reimbursement_piechart.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	public void check_cashless_piechart() {
		wait.until(ExpectedConditions.elementToBeClickable(cashless_piechart));
		if(cashless_piechart.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	public void check_decliend_PA() {
		wait.until(ExpectedConditions.elementToBeClickable(decliend_PA));
		if(decliend_PA.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	public void check_Approved_PA() {
		wait.until(ExpectedConditions.elementToBeClickable(Approved_PA));
		if(Approved_PA.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	public void check_total_PA() {
		wait.until(ExpectedConditions.elementToBeClickable(total_PA));
		if(total_PA.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
		public void check_pending_PA() {
			wait.until(ExpectedConditions.elementToBeClickable(pending_PA));
			if(pending_PA.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
	 
	}
	public void click_dashbord(){
		
			wait.until(ExpectedConditions.elementToBeClickable(dashbord)).click();
		}	
	
	public void clickReasonForApprove(){
		
	//	wait.until(ExpectedConditions.elementToBeClickable(ReasonApproveBtnLink)).click();
	}	
	
	
	
	

	
}
