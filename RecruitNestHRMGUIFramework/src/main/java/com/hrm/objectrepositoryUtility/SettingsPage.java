package com.hrm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
	
		WebDriver driver;
		 public SettingsPage(WebDriver driver)	{
			 this.driver=driver;
				PageFactory.initElements( driver,this);
			 
		 }
		@FindBy(xpath ="//select[@class='form-control']")
		private WebElement settingsDropDwn;
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[4]//input[@id='read']")
		private WebElement proreadcheckbox;
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[4]//input[@id='Create']")
		private WebElement procreatecheckbox;
		
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[5]//input[@id='read']")
		private WebElement empreadcheckbox;
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[5]//input[@id='Create']")
		private WebElement empcreatecheckbox;
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[6]//input[@id='read']")
		private WebElement payrollcheckbox;
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[6]//input[@id='Create']")
		private WebElement payrollcreatecheckbox;
		
		@FindBy(xpath="//div[@class='form']//div[1]//div[1]//div[7]//button[@type='button']")
		private WebElement tokenbutton;
		
		@FindBy(xpath="//input[@type='text']")
		private WebElement bearerId;
		
		
		
		
		
		public WebElement getProcreatecheckbox() {
			return procreatecheckbox;
		}

		public WebElement getEmpcreatecheckbox() {
			return empcreatecheckbox;
		}

		public WebElement getPayrollcreatecheckbox() {
			return payrollcreatecheckbox;
		}

		public WebElement getBearerId() {
			return bearerId;
		}

		public WebElement getSettingsDropDwn() {
			return settingsDropDwn;
		}

		public WebElement getProreadcheckbox() {
			return proreadcheckbox;
		}

		public WebElement getEmpreadcheckbox() {
			return empreadcheckbox;
		}

		public WebElement getPayrollcheckbox() {
			return payrollcheckbox;
		}

		public WebElement getTokenbutton() {
			return tokenbutton;
		}
		
		

}
	

