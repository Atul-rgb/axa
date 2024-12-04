package com.hbaxa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PAListPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public PAListPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 90);
		js = (JavascriptExecutor)rdriver;
		
	}
	
	@FindBy(xpath="//input[contains(@placeholder,'Pre-approval No')]")
	@CacheLookup
	WebElement txtPaNum;
	
	@FindBy(xpath="//a[contains(.,'PA List')]")
	@CacheLookup
	WebElement paListLink;	
	
	@FindBy(xpath="//input[@id='searchBtn']")
	@CacheLookup
	WebElement clickGO;
	
	@FindBy(xpath="//select[@id='StatusID']")
	@CacheLookup
	WebElement seletpa_status;
	
	//@FindBy(xpath="//i[@class='fa fa-object-group']")
	@FindBy(xpath="//a[@title='Adjustment']")
	@CacheLookup
	WebElement clickAdjustment;
	
	@FindBy(xpath="//a[@title='Pre-Approval View']")
	@CacheLookup
	WebElement preApprovalLink;
	
	//@FindBy(xpath="//button[@type='button'][contains(.,'Generate Letter')]") //Previous
	@FindBy(xpath="//button[contains(text(),'Generate Provider Letter')]")
	@CacheLookup
	WebElement GenerateLetterbtnlink;	
	
	@FindBy(xpath="//button[@type='button'][contains(.,'Generate Letter')]")
	@CacheLookup
	WebElement GenerateLetterbtnlinkLife;

	@FindBy(xpath="//input[contains(@value,'Generate Letter')]")
	@CacheLookup
	WebElement generateLetterPageLink;	
	
//	@FindBy(xpath="//button[contains(.,'GenerateLog()')]")
	@FindBy(xpath="//button[@id='btnLogLetter_Life']")

	@CacheLookup
	WebElement GenerateLogButtonlink;
	
	@FindBy(xpath="//input[contains(@value,'Generate Letter')]")
	@CacheLookup
	WebElement generateLogLetterbtn;
	
	@FindBy(xpath="//i[@class='fa fa-share-square-o']")
	@CacheLookup
	WebElement proceed;
	
	// ================ FOR LOADER ===========================
	By loader = By.xpath("//div[contains(@ng-show,'loaderDiv == true') and contains(@aria-hidden,'false')]");
	
	
	public void clickproceed()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();
	}
	public void txtPaNum(String panum)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtPaNum)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(txtPaNum)).sendKeys(panum);
	}
	
	public void clickGO()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(clickGO)).click();
	}

	public void clickAdjustment() {
		
		wait.until(ExpectedConditions.elementToBeClickable(clickAdjustment)).click();
	}

	public void clickPAList() {
		
		wait.until(ExpectedConditions.elementToBeClickable(paListLink)).click();
		
	}

	public void selectPaType(String exceldata) {

		//Select patype = new Select(wait.until(ExpectedConditions.elementToBeClickable(seletpatype)));
		Select patype = new Select(wait.until(ExpectedConditions.elementToBeClickable(seletpa_status)));
		patype.selectByVisibleText(exceldata);
		
	}

	public void clickPreApprovalView() {
		
		wait.until(ExpectedConditions.elementToBeClickable(preApprovalLink)).click();
	}

	public void clickGenerateLetterGI() {
		
		wait.until(ExpectedConditions.elementToBeClickable(GenerateLetterbtnlink)).click();
	}
	
	public void clickGenerateLetterLife() {
		
		wait.until(ExpectedConditions.elementToBeClickable(GenerateLetterbtnlinkLife)).click();
	}	

	public void gotoGenerateLetterButton() {
		
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void gotoGenerateLOGLetterButton(){
		
		js.executeScript("window.scrollBy(0,1000)");
		
	}

	public void clickgenerateLetterPage() {
		
		wait.until(ExpectedConditions.elementToBeClickable(generateLetterPageLink)).click();
		
	}

	public void clickGenerateLogButton() {// on pre approval page

		wait.until(ExpectedConditions.elementToBeClickable(GenerateLogButtonlink)).click();
		
	}
	
	public void clickGenerateLogLetter(){
		
		wait.until(ExpectedConditions.elementToBeClickable(generateLogLetterbtn)).click();
		/////input[contains(@value,'Save')]
	}
	
	public void waitLoader() throws InterruptedException {

		//=================================================================================
		
		for(int i=0;i<30;i++)
		{
			boolean loadercheck = false;
			
			try {
				
				Thread.sleep(1000);
				loadercheck = ldriver.findElement(loader).isEnabled();
				
			} catch (org.openqa.selenium.NoSuchElementException e) {
				//e.printStackTrace();
				System.out.println("page loaded in exception....");
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

	// VALIDATE PDF FILE ====================================
	
	//@FindBy(how=How.XPATH, using="//a[contains(@href,'pdf')]")
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Letter_of_Confirmation')]")
	WebElement checkpdf;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Letter_of_Guarantee')]")
	@CacheLookup
	WebElement log;
	
	public boolean validatepdf(){
		
		boolean chkpdf = checkpdf.isDisplayed();
		return chkpdf;
		
	}
	
	public boolean loglettercheck(){
		
		boolean logletter= log.isDisplayed();
		
		return logletter;
	}
	
	
}
