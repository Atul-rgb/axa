package com.hbaxa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 90);
		
	}
	
	@FindBy(name="UserName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassWord;

	@FindBy(id="submitBtn")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@href='javascript:;']")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	@CacheLookup
	WebElement logoutlink;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassWord(String pwd)
	{
		txtPassWord.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		//btnLogin.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
	}
	
	public void clickProfile()
	{
		wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
	}
	
	public void clickLogOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(logoutlink)).click();
	}
	
}
