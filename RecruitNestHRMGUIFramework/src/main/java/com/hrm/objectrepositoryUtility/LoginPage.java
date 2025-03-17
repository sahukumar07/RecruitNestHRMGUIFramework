package com.hrm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.webdriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
 public LoginPage(WebDriver driver)	{
	 this.driver=driver;
		PageFactory.initElements( driver,this);
	 
 }

	@FindBy(id="username")
	 private WebElement usernameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	


	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void toLoginToApp(String url, String username, String password) {
		toMaximize(driver);
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
		
		
		
	}
	
	


