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

public class Pop_up_Reason_For_Aprove {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public Pop_up_Reason_For_Aprove(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='None selected']")
	@CacheLookup
	WebElement dropdown;
	
	@FindBy(how=How.XPATH, using="//input[@value='multiselect-all']")
	@CacheLookup
	WebElement checkbox_selectall;
	@FindBy(how=How.XPATH, using="(//button[text()='Submit'])[2]")
	@CacheLookup
	WebElement submit_button;
	
	public void  click_addManualPreAproval_button(WebDriver driver) {
	 	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", "");
	
	}
	
	public void click_dropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		//driver.findElement(By.xpath("//table[@id='fwaReasonPA']//tbody//tr[2]//td[4]//div//input[@type='checkbox']")).click();
		dropdown.click();
	}
	public void click_checkbox_selectall() {
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_selectall));
		checkbox_selectall.click();
	}
	public void click_submit_button() {
		wait.until(ExpectedConditions.elementToBeClickable(submit_button));
		submit_button.click();
	}
	
	
	

	
}
