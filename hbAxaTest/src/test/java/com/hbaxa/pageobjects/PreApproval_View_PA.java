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

public class PreApproval_View_PA {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public PreApproval_View_PA(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	@FindBy(how=How.XPATH, using="//button[contains(.,'View Document')]")
	@CacheLookup
	WebElement view_document;
	@FindBy(how=How.ID, using="chopping")
	@CacheLookup
	WebElement chopping;
	@FindBy(how=How.ID, using="btnLogLetter_Life")
	@CacheLookup
	WebElement generate_log;
	@FindBy(how=How.ID, using="btnLetter_Life")
	@CacheLookup
	WebElement generate_letter;
	@FindBy(how=How.ID, using="pisPolicyNumber")
	@CacheLookup
	WebElement PolicyNumber;
	
	public String check_policyNumber() {
		return PolicyNumber.getText();
	}
	
	public void check_view_document() {
		wait.until(ExpectedConditions.elementToBeClickable(view_document));
		if(view_document.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	 
	}
	public void check_chopping() {
		wait.until(ExpectedConditions.elementToBeClickable(chopping));
		  if(chopping.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
		}
	
	public void click_generate_log() {
		wait.until(ExpectedConditions.elementToBeClickable(generate_log));
		generate_log.click();
			
		}
	
	

	public void check_generate_log() {
		wait.until(ExpectedConditions.elementToBeClickable(generate_log));
		if(generate_log.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	
	public void check_generate_letter() throws Exception {
	
		wait.until(ExpectedConditions.elementToBeClickable(generate_letter));
		 if(generate_letter.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
	}
	public void click_generate_letter() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(generate_letter));
		generate_letter.click();
	}
	public boolean  click_chopping(WebDriver driver) throws Exception {
		//pagination_Previous_button.click();
	//	CommanCode.javascript_scroll_to_element(driver,pagination_Previous_button);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", chopping);
		
		Thread.sleep(4000);
	 return 	true;//pagination_1_button.isSelected();
	}
	
	
	public void  click_view_document() {
		wait.until(ExpectedConditions.elementToBeClickable(view_document));
		view_document.click();
		}
	
	
	
	public void clickReasonForApprove(){
		
	//	wait.until(ExpectedConditions.elementToBeClickable(ReasonApproveBtnLink)).click();
	}	
	
	
	
	

	
}
