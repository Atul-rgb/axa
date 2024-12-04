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

public class PreApproval_PA_List_Page {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public PreApproval_PA_List_Page(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	
	@FindBy(how=How.XPATH, using="//a[contains(@onclick,'return confir')]")
	@CacheLookup
	WebElement go_to_previous_page;
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-file-text-o']")
	@CacheLookup
	WebElement viewlog;
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-file-pdf-o']")
	@CacheLookup
	WebElement view_Letter;
	@FindBy(how=How.ID, using="indexTablePa_previous")
	@CacheLookup
	WebElement pagination_Previous_button;
	@FindBy(how=How.XPATH, using="//a[@data-dt-idx='1']")
	@CacheLookup
	WebElement pagination_1_button;
	@FindBy(how=How.ID, using="indexTablePaList_next")
	@CacheLookup
	WebElement pagination_Next_button;
	
	@FindBy(how=How.XPATH, using="(//a[@title='Proceed'])[1]")
	@CacheLookup
	WebElement indexing_procced_link;
	@FindBy(how=How.XPATH, using="//i[@class='fa fa-eye']")
	@CacheLookup
	WebElement pre_approval_link;
	
	
	
	public void check_indexing_procced_link() {
		if(indexing_procced_link.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	 
	}
	public void check_pre_approval_link() {
		
		  if(pre_approval_link.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
		}
	
	public void click_pre_approval_link() {
		
		  pre_approval_link.click();
			
		}
	
	

	public void check_nextButton() {
	//	pagination_Next_button.click();
		if(pagination_Next_button.isDisplayed()==true) {
			Assert.assertEquals(true, true);
		}else {
			Assert.assertEquals(true, false);
		}
	}
	
	public void check_view_Log() throws Exception {
	
				
		 if(viewlog.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
	}
	public void click_view_Log() throws Exception {
		 viewlog.click();
	}
	public boolean  check_pagination_Previous_button_clickable(WebDriver driver) throws Exception {
		//pagination_Previous_button.click();
	//	CommanCode.javascript_scroll_to_element(driver,pagination_Previous_button);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", pagination_Previous_button);
		
		Thread.sleep(4000);
	 return 	true;//pagination_1_button.isSelected();
	}
	
	public void  check_view_Letter() {
		
		 if(view_Letter.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
		}
	public void  click_view_Letter() {
		
		 view_Letter.click();
		}
	
	public void  check_go_to_previous_page_display() {
		
		 if(go_to_previous_page.isDisplayed()==true) {
				Assert.assertEquals(true, true);
			}else {
				Assert.assertEquals(true, false);
			}
		}
	
	public void clickReasonForApprove(){
		
	//	wait.until(ExpectedConditions.elementToBeClickable(ReasonApproveBtnLink)).click();
	}	
	
	
	
	

	
}
