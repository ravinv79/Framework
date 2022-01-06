package com.Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CLADDPage 
{
	@FindBy(id="TxtUserName")
	private WebElement UNTB;
	
	@FindBy(id="TxtPassword")
	private WebElement pwdTB;
	
	@FindBy(id="btnLogin")
	private WebElement Loginbtn;
	
	public CLADDPage(WebDriver driver)
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void UNTB(String UN, String pwd)
	{
		UNTB.sendKeys(UN);		
		pwdTB.sendKeys(pwd);
		Loginbtn.click();
	}
	
	
	
	

}
