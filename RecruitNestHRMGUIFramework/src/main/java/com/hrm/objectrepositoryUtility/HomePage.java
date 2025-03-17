package com.hrm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	 public HomePage(WebDriver driver)	{
		 this.driver=driver;
			PageFactory.initElements( driver,this);
		 
	 }
	@FindBy(linkText ="Dashboard")
	private WebElement DashboardPageLink;
	
	@FindBy(linkText ="Projects")
	private WebElement ProjectPageLink;
	
	@FindBy(linkText ="Employees")
	private WebElement EmployeePageLink;
	
	@FindBy(linkText ="Payroll")
	private WebElement PayrollPageLink;
	
	@FindBy(linkText ="Status")
	private WebElement StatusPageLink;
	
	@FindBy(linkText ="Manage")
	private WebElement ManagePageLink;
	
	@FindBy(xpath="(//*[local-name()='svg'])[4]")
	
	private WebElement LogoutBtn;
	
	@FindBy(linkText ="Settings")
	private WebElement SettingsPageLink;
	
	@FindBy(linkText ="Resources")
	private WebElement ResourcesPageLink;
	
	

	public WebElement getSettingsPageLink() {
		return SettingsPageLink;
	}

	public WebElement getResourcesPageLink() {
		return ResourcesPageLink;
	}

	public WebElement getDashboardPageLink() {
		return DashboardPageLink;
	}

	public WebElement getProjectPageLink() {
		return ProjectPageLink;
	}

	public WebElement getEmployeePageLink() {
		return EmployeePageLink;
	}

	public WebElement getPayrollPageLink() {
		return PayrollPageLink;
	}

	public WebElement getStatusPageLink() {
		return StatusPageLink;
	}

	public WebElement getManagePageLink() {
		return ManagePageLink;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}

	public void toSignOut() {
		LogoutBtn.click();
		
		
	}
	
	
}
