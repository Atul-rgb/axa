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

public class Pop_up_Reason_For_Pending {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public Pop_up_Reason_For_Pending(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(how=How.XPATH, using="//label[contains(@title,'P20-Other')]")
	@CacheLookup
	WebElement P20_OTHER;
	@FindBy(how=How.ID, using="OtherPendingReason")
	@CacheLookup
	WebElement P20_OTHER_Reason;
	public void enter_P20_OTHER_Reason() {
		wait.until(ExpectedConditions.elementToBeClickable(P20_OTHER_Reason));
		P20_OTHER_Reason.sendKeys("Automation Testing");
	}
	
	public void  click_addManualPreAproval_button(WebDriver driver) {
	 	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", "");
	
	}
	public void enter_data_searchfield(String data) {
		wait.until(ExpectedConditions.elementToBeClickable(P20_OTHER));
		
	}
	public void select_P20_OTHER(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(P20_OTHER));
		P20_OTHER.click();
		Actions action = new Actions(driver);
		action.moveByOffset(0, 0).click().build().perform();
	}
	
	
	

	
}
