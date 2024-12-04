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

public class Pop_up_Reassign_Claim {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public Pop_up_Reassign_Claim(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(how=How.ID, using="UserSearchText")
	@CacheLookup
	WebElement search_field;
	@FindBy(how=How.ID, using="iRemarkCodeSearchProc")
	@CacheLookup
	WebElement search_icon;
	@FindBy(how=How.XPATH, using="//tbody[@id='trSearchList']//tr[1]//td[4]")
	@CacheLookup
	WebElement selectlink;
	@FindBy(how=How.XPATH, using="//table//tbody[@id='trSearchList']//tr[1]//td[4]")
	@CacheLookup
	WebElement newselectlink;
	public void click_select(WebDriver driver) {
	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	executor.executeScript("arguments[0].click();", "selectlink");
		wait.until(ExpectedConditions.elementToBeClickable(selectlink));
	selectlink.click();
	}
	public void click_newselectlink(WebDriver driver) {
		//	JavascriptExecutor executor = (JavascriptExecutor)driver;
		//	executor.executeScript("arguments[0].click();", "selectlink");
		wait.until(ExpectedConditions.elementToBeClickable(newselectlink));
		newselectlink.click();
		}
	public void  click_addManualPreAproval_button(WebDriver driver) {
	 	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", "");
	
	}
	public void enter_data_searchfield(String data) {
		search_field.sendKeys(data);
	}
	public void click_search_icon() {
		search_icon.click();
	}
	
	
	

	
}
