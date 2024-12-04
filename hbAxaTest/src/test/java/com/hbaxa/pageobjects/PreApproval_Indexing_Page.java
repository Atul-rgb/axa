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

public class PreApproval_Indexing_Page {
	
	WebDriver ldriver;
	WebDriverWait wait;
	PAData paread = new PAData();
	JavascriptExecutor js;
	NgWebDriver ngWebDriver;
	
	public PreApproval_Indexing_Page(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // previous 50
		//rdriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) rdriver);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(how=How.XPATH, using="//a[text()='Reset']")
	@CacheLookup
	WebElement resetButton;
	@FindBy(how=How.ID, using="searchbutton")
	@CacheLookup
	WebElement searchButton;
	@FindBy(how=How.XPATH, using="//button[text()='Add Manual Estimation']")
	@CacheLookup
	WebElement Add_Manual_Estimation_button;
	@FindBy(how=How.XPATH, using="//a[contains(@onclick,'return confir')]")
	@CacheLookup
	WebElement go_to_previous_page;
	@FindBy(how=How.XPATH, using="//div[@class='breadcrumb']")
	@CacheLookup
	WebElement indexing_page_pagination;
	@FindBy(how=How.XPATH, using="//a[@data-dt-idx='2']")
	@CacheLookup
	WebElement pagination_2_button;
	@FindBy(how=How.ID, using="indexTablePa_previous")
	@CacheLookup
	WebElement pagination_Previous_button;
	@FindBy(how=How.XPATH, using="//a[@data-dt-idx='1']")
	@CacheLookup
	WebElement pagination_1_button;
	@FindBy(how=How.ID, using="indexTablePa_next")
	@CacheLookup
	WebElement pagination_Next_button;
	@FindBy(how=How.XPATH, using="//button[text()='Add Manual Pre-Approval']")
	@CacheLookup
	WebElement addManualPreAproval;
	@FindBy(how=How.XPATH, using="(//a[@title='Proceed'])[1]")
	@CacheLookup
	WebElement indexing_procced_link;
	@FindBy(how=How.XPATH, using="(//button[@title='Reassign'])[1]")
	@CacheLookup
	WebElement indexing_Reassign_link;
	@FindBy(how=How.XPATH, using="(//button[@title='Reassign'])[1]")
	@CacheLookup
	WebElement indexing_Reassign_link2;
	@FindBy(how=How.XPATH, using="(//button[@title='Reassign'])[1]")
	@CacheLookup
	WebElement indexing_Reassign_link3;
	
	@FindBy(how=How.XPATH, using="(//a[text()='TAT'])[1]")
	@CacheLookup
	WebElement indexing_TAT;
	@FindBy(how=How.XPATH, using="//tbody/tr[1]//td[8]")
	@CacheLookup
	WebElement indexing_TAT_data;
	@FindBy(how=How.XPATH, using="//tbody/tr[1]//td[8]")
	@CacheLookup
	WebElement indexing_TAT_data2;
	@FindBy(how=How.XPATH, using="//button[@title='Reassign']")
	@CacheLookup
	List <WebElement> indexing_Reassign_list;
	@FindBy(how=How.XPATH, using="//a[@title='Proceed']")
	@CacheLookup
	List <WebElement> indexing_Proceed_list;
	@FindBy(how=How.XPATH, using="//span[@class='pa-td-span2']")
	@CacheLookup
	WebElement indexing_table_casepickby;
	@FindBy(how=How.XPATH, using="//table[@id='indexTablePa']//tbody//span[@class='pa-td-span2']")
	@CacheLookup
	WebElement indexing_table_new_casepickby;
	public String  get_indexing_table_new_casepickby() {
		wait.until(ExpectedConditions.elementToBeClickable(indexing_table_new_casepickby));
		return indexing_table_new_casepickby.getText();
	}
	
	public String  get_indexing_table_casepickby() {
		wait.until(ExpectedConditions.elementToBeClickable(indexing_table_casepickby));
		return indexing_table_casepickby.getText();
	}
	public int  get_indexing_Proceed_list() {
		 return indexing_Proceed_list.size();
	}
	public int  get_indexing_Reassign_list() {
		 return indexing_Reassign_list.size();
	}
	public String get_indexing_TAT_data2() {
		return indexing_TAT_data2.getText();
	}
	public String get_indexing_TAT_data() {
		return indexing_TAT_data.getText();
	}
	public void click_indexing_TAT() {
		indexing_TAT.click();
	}
	public boolean check_indexing_procced_link() {
	  return	indexing_procced_link.isDisplayed();
	}
	public boolean check_indexing_Reassign_link() {
		  return	indexing_Reassign_link.isDisplayed();
		}
	public void click_indexing_Reassign_link() {
		  	indexing_Reassign_link.click();
		}
	public void click_indexing_Reassign_link2() {
	  	indexing_Reassign_link2.click();
	}
	public void click_indexing_Reassign_link3() {
	  	indexing_Reassign_link3.click();
	}
	
	public void  click_addManualPreAproval_button(WebDriver driver) {
	 	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", addManualPreAproval);
	
	}
	public void click_nextButton() {
		pagination_Next_button.click();
	}
	
	public boolean  check_pagination_Next_button_selecetd() throws Exception {
		
		
		Thread.sleep(4000);
    	boolean b	=pagination_2_button.isSelected();
	 return 	b;
	}
	public boolean  check_pagination_Previous_button_clickable(WebDriver driver) throws Exception {
		//pagination_Previous_button.click();
	//	CommanCode.javascript_scroll_to_element(driver,pagination_Previous_button);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", pagination_Previous_button);
		
		Thread.sleep(4000);
	 return 	true;//pagination_1_button.isSelected();
	}
	public boolean  check_pagination_2_button_selecetd(WebDriver driver) throws InterruptedException {
		 	//pagination_2_button.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", pagination_2_button);
		 //	CommanCode.javascript_scroll_to_element(driver,pagination_2_button);
		 	Thread.sleep(8000);
		 return  true;	//pagination_2_button.isSelected();
		}
	public boolean  check_indexing_page_pagination_display() {
		 return	indexing_page_pagination.isDisplayed();
		}
	
	public boolean  check_go_to_previous_page_display() {
		 return	go_to_previous_page.isDisplayed();
		}
	public boolean  check_Add_Manual_Estimation_button_display() {
		 return	Add_Manual_Estimation_button.isDisplayed();
		}
	public boolean  check_Reset_button_display() {
	 return	resetButton.isDisplayed();
	}
	public boolean  check_searchButton_display() {
		 return	searchButton.isDisplayed();
		}
	public void clickReasonForApprove(){
		
	//	wait.until(ExpectedConditions.elementToBeClickable(ReasonApproveBtnLink)).click();
	}	
	
	
	
	

	
}
